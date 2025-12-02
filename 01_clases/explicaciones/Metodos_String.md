# ✨ Métodos esenciales de `String` en Java

La clase **String** es una de las más usadas en Java.  
Aquí tienes una explicación clara y sencilla de varios métodos fundamentales:  
`.matches()`, `.contains()`, `.charAt()`, `.equals()`, `String.valueOf()`, `.length()`, `.toLowerCase()`, `.toUpperCase()`.

---

# 🔍 `.matches(String regex)`

Comprueba si el texto **coincide EXACTAMENTE** con una expresión regular (regex).

```java
String dni = "12345678A";
boolean valido = dni.matches("[0-9]{8}[A-Z]");
```

✔ Devuelve `true` si coincide  
✖ Devuelve `false` si no

---

# 🔎 `.contains(String parte)`

Comprueba si una cadena contiene otra dentro de sí.

```java
String texto = "Hola mundo";
boolean tieneMundo = texto.contains("mundo"); // true
```

✔ Sensible a mayúsculas/minúsculas  
✔ No usa regex

---

# 🔤 `.charAt(int posicion)`

Devuelve el carácter situado en la posición indicada.

```java
String palabra = "Auto";
char letra = palabra.charAt(0); // 'A'
```

⚠ La primera posición es la **0**  
⚠ Lanza error si el índice está fuera de rango

---

# 🤝 `.equals(Object obj)`

Compara cadenas **por su contenido** (no por referencia).

```java
String a = "Hola";
String b = "Hola";
boolean iguales = a.equals(b); // true
```

✔ Forma correcta de comparar Strings  
✖ ¡Nunca usar `==` para comparar texto!

---

# 🧪 `String.valueOf(...)`

Convierte valores de otros tipos a `String`.

```java
int numero = 25;
String texto = String.valueOf(numero); // "25"
```

También funciona con:
- `double`
- `boolean`
- `char`
- objetos

---

# 📏 `.length()`

Devuelve la cantidad de caracteres de la cadena.

```java
String nombre = "Carlos";
int largo = nombre.length(); // 6
```

✔ Incluye espacios  
✔ No empieza desde 0 (es cantidad, no índice)

---

# 🔽 `.toLowerCase()`

Convierte todo el texto a minúsculas.

```java
String frase = "Hola Mundo";
String minus = frase.toLowerCase(); // "hola mundo"
```

✔ Útil para comparaciones sin distinguir mayúsculas

---

# 🔼 `.toUpperCase()`

Convierte todo el texto a mayúsculas.

```java
String frase = "Hola Mundo";
String mayus = frase.toUpperCase(); // "HOLA MUNDO"
```

✔ También útil para comparaciones

---

# 🧠 Ejemplo práctico combinando varios métodos

```java
String matricula = "1234abc";

// Validar longitud
if (matricula.length() == 7) {
    // Comparar ignorando mayúsculas
    boolean terminaEnC = matricula.toUpperCase().endsWith("C");

    // Obtener primer carácter
    char primero = matricula.charAt(0);

    // Comprobar formato con regex
    boolean formatoCorrecto = matricula.matches("[0-9]{4}[A-Z]{3}");
}
```

---

# 🎯 Resumen rápido

| Método | Para qué sirve |
|--------|----------------|
| `.matches()` | Comparar con una expresión regular |
| `.contains()` | Ver si un texto contiene otro |
| `.charAt()` | Obtener un carácter por posición |
| `.equals()` | Comparar cadenas correctamente |
| `valueOf()` | Convertir otros tipos a String |
| `.length()` | Obtener longitud |
| `.toLowerCase()` | Convertir a minúsculas |
| `.toUpperCase()` | Convertir a mayúsculas |

---

¡Listo! Ahora tienes una guía clara y práctica sobre los métodos más usados de `String` en Java.
