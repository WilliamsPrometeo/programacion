# 📘 Proyecto Evaluable DAW 1
## Gestión de Reservas de una Biblioteca

---

## 🎯 Objetivo del proyecto
Desarrollar una aplicación de **consola en Java** que permita gestionar los **libros de una biblioteca y su stock de ejemplares**, aplicando los contenidos trabajados durante el curso.

Este proyecto es **obligatorio y evaluable** y servirá para comprobar el dominio de:

- Programación orientada a objetos
- Colecciones (`ArrayList`, `Map`)
- Sobrescritura de métodos (`equals`, `hashCode`, `toString`)
- Excepciones personalizadas
- Validación de datos
- Documentación con **JavaDoc**

---

## 📚 Clase `Libro`
La clase `Libro` representará un libro de la biblioteca y **deberá estar documentada completamente con JavaDoc**.

### Atributos mínimos obligatorios
- `isbn` (String) → **identificador único del libro**
- `titulo` (String)
- `autor` (String)
- `anioPublicacion` (int)

### Requisitos técnicos de la clase `Libro`
- Constructor con todos los atributos
- Métodos `get` y `set` necesarios
- Método `toString()` sobrescrito
- **Sobrescritura correcta de `equals()` y `hashCode()` usando exclusivamente el atributo `isbn`**
- Documentación **JavaDoc obligatoria** para:
  - La clase
  - El constructor
  - Todos los métodos públicos

⚠️ **IMPORTANTE**: si la clase `Libro` NO está documentada con JavaDoc, **el proyecto NO será corregido**.

---

## 🗃️ Estructuras de datos obligatorias
En la clase principal del programa deberán existir como mínimo:

- `ArrayList<Libro>` → almacena los libros registrados
- `Map<Libro, Integer>` → gestiona el stock de ejemplares

📌 El mapa utilizará objetos `Libro` como clave, por lo que **`equals()` y `hashCode()` deben estar correctamente implementados en función del ISBN**.

---

## ⚠️ Excepciones personalizadas
Se deberán crear y utilizar **excepciones propias**, al menos:

- `IsbnInvalidoException`
- `AnioInvalidoException`
- `CantidadInvalidaException`

Estas excepciones deberán lanzarse cuando los datos introducidos no cumplan las validaciones establecidas.

---

## 📋 Funcionalidades obligatorias
El programa deberá mostrar un menú interactivo similar al siguiente:

```
==== GESTIÓN BIBLIOTECA ====
1. Registrar libro
2. Mostrar catálogo
3. Gestionar ejemplares
4. Salir
```

---

### 1️⃣ Registrar libro
Se solicitarán los siguientes datos:

- ISBN
  - No puede estar vacío
  - Mínimo 5 caracteres
  - No puede repetirse
- Título
  - Solo texto
  - No vacío
- Autor
  - Solo texto
  - No vacío
- Año de publicación
  - Mayor que 0

Todos los errores deberán gestionarse mediante **excepciones personalizadas**.

El libro se añadirá al `ArrayList<Libro>`.

---

### 2️⃣ Mostrar catálogo
- Mostrar todos los libros registrados
- Indicar el número de ejemplares disponibles si el libro existe en el mapa

---

### 3️⃣ Gestionar ejemplares
- Recorrer la lista de libros
- Para cada libro:
  - Solicitar el número de ejemplares disponibles
  - Validar que no sea negativo
  - Guardar la información en el `Map<Libro, Integer>`

---

### 4️⃣ Salir
- Finalizar correctamente la ejecución del programa

---

## ✅ Requisitos obligatorios

- Uso correcto de clases y métodos
- Uso de `ArrayList` y `Map`
- Sobrescritura correcta de `equals()` y `hashCode()`
- Control de errores mediante excepciones personalizadas
- Menú funcional y repetitivo
- Código limpio, indentado y legible
- **Documentación JavaDoc obligatoria**

🚫 No se permite:
- Uso de bases de datos
- Interfaces gráficas
- Librerías externas

---

## 📝 Rúbrica de evaluación (sobre 10 puntos)

| Apartado                                                 | Puntuación    |
|----------------------------------------------------------|---------------|
| Estructura del proyecto y organización                   | 1,5           |
| Clase `Libro` (atributos, constructor, getters, setters) | 1,5           |
| `equals()` y `hashCode()` correctamente implementados    | 2,0           |
| Uso correcto de `ArrayList` y `Map<Libro, Integer>`      | 1,5           |
| Validaciones y excepciones personalizadas                | 1,5           |
| Funcionamiento del menú y lógica general                 | 1,0           |
| **Documentación JavaDoc completa y correcta**            | **1,0**       |
| **TOTAL**                                                | **10 puntos** |

---

## ⚠️ Condición obligatoria

🔴 **La documentación JavaDoc es obligatoria.**

Si la clase `Libro` no está correctamente documentada con JavaDoc, **el proyecto NO será corregido y la calificación será 0**.
