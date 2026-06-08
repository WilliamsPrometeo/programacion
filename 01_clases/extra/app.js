const API_BASE_URL = "http://localhost:9090";
const WS_BASE_URL = "ws://localhost:9090";

const loginView = document.getElementById("loginView");
const chatView = document.getElementById("chatView");
const loginForm = document.getElementById("loginForm");
const loginError = document.getElementById("loginError");
const logoutButton = document.getElementById("logoutButton");
const messageForm = document.getElementById("messageForm");
const messageInput = document.getElementById("messageInput");
const sendButton = document.getElementById("sendButton");
const messagesDiv = document.getElementById("messages");
const connectionStatus = document.getElementById("connectionStatus");

let socket;
let currentUser;
let token;

loginForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    loginError.textContent = "";

    const formData = new FormData(loginForm);

    try {
        const response = await fetch(`${API_BASE_URL}/auth/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: formData.get("username"),
                password: formData.get("password")
            })
        });

        if (!response.ok) {
            throw new Error(await response.text());
        }

        const loginResponse = await response.json();
        currentUser = loginResponse.username;
        token = loginResponse.token;

        showChat();
        connectWebSocket();
    } catch (error) {
        loginError.textContent = error.message || "No se pudo iniciar sesión";
    }
});

messageForm.addEventListener("submit", (event) => {
    event.preventDefault();

    const message = messageInput.value.trim();
    if (!message || !socket || socket.readyState !== WebSocket.OPEN) {
        return;
    }

    socket.send(message);
    messageInput.value = "";
});

logoutButton.addEventListener("click", () => {
    if (socket) {
        socket.close();
    }

    currentUser = null;
    token = null;
    messagesDiv.innerHTML = "";
    loginForm.reset();
    showLogin();
});

function connectWebSocket() {
    connectionStatus.textContent = "Conectando...";
    sendButton.disabled = true;

    socket = new WebSocket(`${WS_BASE_URL}/chat?token=${encodeURIComponent(token)}`);

    socket.onopen = () => {
        connectionStatus.textContent = `Conectado como ${currentUser}`;
        sendButton.disabled = false;
    };

    socket.onmessage = (event) => {
        addMessage(JSON.parse(event.data));
    };

    socket.onclose = () => {
        connectionStatus.textContent = "Desconectado";
        sendButton.disabled = true;
    };

    socket.onerror = () => {
        connectionStatus.textContent = "Error de conexión";
        sendButton.disabled = true;
    };
}

function showChat() {
    loginView.classList.add("hidden");
    chatView.classList.remove("hidden");
}

function showLogin() {
    chatView.classList.add("hidden");
    loginView.classList.remove("hidden");
}

function addMessage(message) {
    const messageElement = document.createElement("div");
    messageElement.classList.add("message");

    const author = document.createElement("strong");
    author.textContent = message.username;

    const text = document.createElement("span");
    text.textContent = `: ${message.message}`;

    const timestamp = document.createElement("small");
    timestamp.textContent = formatTimestamp(message.timestamp);

    messageElement.append(author, text, timestamp);
    messagesDiv.appendChild(messageElement);
    messagesDiv.scrollTop = messagesDiv.scrollHeight;
}

function formatTimestamp(timestamp) {
    if (!timestamp) {
        return "";
    }

    return new Date(timestamp).toLocaleTimeString([], {
        hour: "2-digit",
        minute: "2-digit"
    });
}
