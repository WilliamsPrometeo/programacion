# 🌐 JSON en Java
# (JavaScript Object Notation)

---

# 1️⃣ ¿Qué es JSON?

JSON es un **formato de intercambio de datos ligero** basado en texto.

Se utiliza para:

- Enviar datos entre cliente y servidor
- Guardar información en archivos
- Comunicarse con APIs

Ejemplo simple:

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anio": 2008
}
```

---

# 🧠 2️⃣ Características principales

✅ Formato basado en texto

✅ Fácil de leer por humanos

✅ Fácil de parsear por máquinas

✅ Independiente del lenguaje

---

# 🏗 3️⃣ Estructura básica de JSON

JSON se construye con:

## 🔹 Objetos

Se definen con llaves `{}`

```json
{
  "nombre": "Ana",
  "edad": 25
}
```

---

## 🔹 Arrays

Se definen con corchetes `[]`

```json
[
  {"titulo": "Libro 1"},
  {"titulo": "Libro 2"}
]
```

---

## 🔹 Tipos de datos permitidos

- String
- Number
- Boolean
- Object
- Array
- null

---

# 🔄 4️⃣ JSON y flujo de datos

En una aplicación web el flujo sería:

Frontend → JSON → Backend

Backend → JSON → Frontend

Ejemplo conceptual:

Usuario crea un libro →
Se convierte en JSON →
Se envía al servidor →
Se convierte en objeto Java

---

# 💻 5️⃣ JSON en Java

Java no trabaja directamente con JSON.

Necesita una librería como:

- Jackson
- Gson

Concepto clave:

## Serializar a JSON

Objeto Java → JSON

## Deserializar desde JSON

JSON → Objeto Java

---

# 📤 6️⃣ Ejemplo conceptual de serialización

Objeto Java:

```java
Libro libro = new Libro("Clean Code", "Robert C. Martin");
```

Se transforma en:

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin"
}
```

---

# 📥 7️⃣ Ejemplo conceptual de deserialización

JSON recibido:

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin"
}
```

Se convierte en:

```java
Libro libro = new Libro(...);
```

---

# 🏗 8️⃣ Uso en arquitectura MVC

## 📌 En el Modelo

El modelo es una clase normal Java:

```java
public class Libro {
    private String titulo;
    private String autor;
}
```

---

## 📌 En el Controller (API real)

El controlador recibe JSON automáticamente y lo convierte en objeto.

---

## 📌 En la capa de persistencia

También podemos guardar directamente en archivo `.json`.

Flujo completo:

Objeto → JSON → Archivo

Archivo → JSON → Objeto

---

# ⚖ 9️⃣ JSON vs Serializable

| Característica | JSON | Serializable |
|----------------|------|--------------|
| Formato | Texto | Binario |
| Legible | Sí | No |
| Multilenguaje | Sí | No |
| Uso web | Sí | No |

Conclusión:

Serializable es útil para aprendizaje y persistencia simple.

JSON es el estándar real en aplicaciones web.

---

# ⚠️ 1️⃣0️⃣ Buenas prácticas

✅ No guardar fechas como texto sin formato claro.

✅ Usar DTO cuando trabajemos con APIs.

✅ Validar datos recibidos.

---

# 🎯 1️⃣1️⃣ Idea clave

> JSON no es una base de datos.
>
> JSON es un formato de transporte de datos.
>
> Es el idioma que hablan frontend y backend.

