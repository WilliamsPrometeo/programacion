# 📘 Práctica 3 – Biblioteca de Libros
**Tema:** Clases y colecciones simples (ArrayList)  
**Objetivo:** Manejar listas de objetos y operaciones básicas con colecciones.

---

## 📝 Descripción general
En esta práctica crearás una pequeña biblioteca digital que permita almacenar libros, listarlos y buscar por autor.  
Aplicarás:
- Programación orientada a objetos básica
- Clases con atributos y métodos
- Uso de `ArrayList`
- Separación de responsabilidades en varias clases

---

## 📂 Archivos requeridos
El proyecto debe incluir **exactamente estos tres archivos**:

- `Libro.java`
- `Biblioteca.java`
- `Libreria.java` (con `main`)

---

## 🎯 Requisitos funcionales

### ✔ Clase **Libro**
Crear una clase `Libro` que contenga:
- Atributos privados:
    - `String titulo`
    - `String autor`
- Constructor
- Getters y setters
- Método `toString()` para mostrar la información del libro

---

### ✔ Clase **Biblioteca**
Crear una clase `Biblioteca` que contenga:
- Un atributo:
  - private ArrayList<Libro> libros = new ArrayList<>();
  - Métodos obligatorios:
- agregarLibro(Libro libro)
  - Agrega un libro al ArrayList.

- mostrarLibros()
  - Muestra todos los libros almacenados, uno por línea.

- buscarPorAutor(String autor)
  - Debe recorrer el ArrayList y mostrar únicamente los libros cuyo autor coincida (no es necesario ignorar 
    mayúsculas o acentos).

---

### ✔ Clase **Libreria**
Debe contener el método main, donde:
- Se crean varios objetos Libro (al menos 2).
- Se agrega cada libro a un objeto Biblioteca.
- Se llaman a los métodos:
  - mostrarLibros()
  - buscarPorAutor()
- Se muestra el resultado en formato ordenado.

---

## 🧮 Ejemplo de salida esperada
```
=== TODOS LOS LIBROS ===
Título: El Quijote | Autor: Cervantes
Título: Fundación | Autor: Isaac Asimov
Título: It | Autor: Stephen King

=== BÚSQUEDA POR AUTOR: Isaac Asimov ===
Título: Fundación | Autor: Isaac Asimov
```

---

## 🧾 Rúbrica de evaluación (10 puntos)

| Criterio                           | Puntos |
|------------------------------------|--------|
| Definición correcta de clases      | **3**  |
| Gestión correcta del ArrayList     | **3**  |
| Métodos funcionales y salida clara | **3**  |
| Legibilidad y comentarios          | **1**  |

---

## 💡 Recomendaciones
- Mantén los atributos privados y usa getters/setters.
- Usa ArrayList<Libro> correctamente.
- En el método buscarPorAutor, recorre la lista con un for-each.
- No dejes lógica del programa dentro de la clase Libro.
- Organiza bien las salidas por pantalla.

---
🕒 **Duración estimada:** 1 hora  
🎯 **Objetivo pedagógico:** trabajar colecciones, clases simples y métodos de búsqueda.