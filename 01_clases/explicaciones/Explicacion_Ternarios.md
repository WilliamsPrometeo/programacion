# 🧩 Explicación de los Operadores Ternarios en Java

El **operador ternario** en Java es una forma compacta de escribir una expresión condicional.  
Se utiliza cuando quieres evaluar una condición y devolver un valor u otro dependiendo de si la condición se cumple.

---

## ⭐ ¿Qué es el operador ternario?

El operador ternario tiene esta estructura:

```
condicion ? valorSiEsVerdadero : valorSiEsFalso
```

Funciona igual que un `if-else`, pero en una sola línea.

---

## 🔍 Ejemplo básico

### Forma tradicional con if-else:

```java
int edad = 20;
String mensaje;

if (edad >= 18) {
    mensaje = "Mayor de edad";
} else {
    mensaje = "Menor de edad";
}
```

### Usando el operador ternario:

```java
int edad = 20;
String mensaje = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
```

Ambas formas hacen exactamente lo mismo, pero el ternario es más corto y legible cuando es una condición simple.

---

## 🛠️ Ejemplo práctico dentro de un método

```java
String estadoVehiculo = (vehiculo != null)
        ? "El vehículo existe en el sistema."
        : "El vehículo NO está registrado.";
```

Esto evalúa si `vehiculo` es `null` y devuelve un mensaje u otro.

---

## 🎯 ¿Cuándo usar un operador ternario?

Úsalo cuando:

✔ La condición es simple  
✔ Solo necesitas asignar un valor  
✔ No necesitas ejecutar varias líneas de código

Evítalo cuando:

✖ La lógica es larga o compleja  
✖ Hay varias operaciones dentro de cada rama  
✖ La condición afecta a bloques grandes de código  

---

## 🔥 Ejemplo realista para tu proyecto

Supongamos que quieres mostrar un mensaje dependiendo de si un servicio existe o no:

```java
String resultado = (servicioBuscado == null)
        ? "El servicio no está disponible."
        : "Servicio encontrado y listo para asignar.";
```

---

## 🧠 Consejo final

El operador ternario **no sustituye a `if-else`**, pero es excelente para:

- Mensajes cortos  
- Asignación de valores  
- Evitar código repetitivo  

Úsalo con moderación y claridad siempre como prioridad.

---

¡Y eso es todo! Ahora sabes cómo funcionan los ternarios y cómo aplicarlos correctamente en tu proyecto.
