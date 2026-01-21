# 📚 SIMULACRO – GESTIÓN DE LIBRERÍA

## 🎯 Objetivo de la práctica
Poner en práctica el uso de **flujos de datos en Java**, el manejo de **colecciones (`ArrayList`, `Map`)**, el trabajo con **fechas**, y la **escritura en ficheros de texto** usando una ruta absoluta.

---

## 🧾 Contexto

Dispones de las siguientes clases ya creadas y correctamente implementadas:

### 📘 Clases del modelo

**Libro**
- `String isbn`
- `String titulo`
- `String autor`
- `Genero genero` *(enum)*
- `LocalDate fecha_publicacion`
- Métodos `equals()` y `hashCode()` correctamente sobrescritos

---

## 🏗️ Clase principal

La clase `GestionLibreria` contiene los siguientes atributos estáticos:

```java
static ArrayList<Libro> libros;
static Map<Libro, Integer> stockLibros;
```

---

## 📋 Menú principal

El programa debe mostrar el siguiente menú de forma repetitiva hasta que el usuario decida salir:

```
===== GESTION LIBRERIA =====
1. Agregar libro
2. Mostrar libros
3. Gestionar stock de libros
4. Prestar libro
5. Salir
Inserte la opción que desee:
```

---

## ✅ Funcionalidades a implementar

### 1️⃣ Agregar libro
- Solicitar todos los datos necesarios para crear un objeto `Libro`.
- **El ISBN debe cumplir las siguientes restricciones:**
  - Ser **alfanumérico**.
  - Contener **exactamente 3 letras y 2 números**.
  - Convertirse y almacenarse siempre en **mayúsculas**.
  - Ejemplo válido: `ABC12`.
- Validar el ISBN antes de crear el objeto `Libro`.
- Añadir el libro al `ArrayList<Libro>`.
- Inicializar su stock en el `Map<Libro, Integer>`.
- No se permiten libros duplicados (usar `equals`).

---

### 2️⃣ Mostrar libros
Mostrar todos los libros registrados con la siguiente información:
- ISBN
- Título
- Autor
- Género
- Fecha de publicación
- Stock disponible

---

### 3️⃣ Gestionar stock de libros
Permitir:
- Aumentar stock
- Disminuir stock (sin permitir valores negativos)
- Mostrar el stock completo de la librería

La búsqueda del libro se realizará mediante su ISBN.

---

### 4️⃣ Prestar libro (FLUJOS DE DATOS)

#### 📌 Funcionamiento
1. Solicitar el ISBN del libro a prestar.
2. Comprobar que:
   - El libro existe.
   - Hay stock disponible.
3. Reducir el stock del libro en el `Map`.
4. Registrar el préstamo en un fichero de texto.

---

## 📂 Escritura en fichero (OBLIGATORIO)

- El préstamo debe guardarse en una **ruta absoluta del escritorio**, por ejemplo:

```
C:\Users\Usuario\Desktop\prestamos_libreria.txt
```

- El fichero debe crearse si no existe.
- Los préstamos se deben **añadir al final del archivo**, no sobrescribir.

---

### 📄 Formato del fichero

Cada préstamo debe seguir el siguiente formato:

```
----- PRESTAMO -----
Fecha préstamo: 2026-01-21
Libro:
  ISBN: ABC12
  Título: El Quijote
  Autor: Miguel de Cervantes
--------------------
```

📌 La fecha del préstamo se obtendrá automáticamente con `LocalDate.now()`.

📌 Se deben usar **flujos de datos** (`FileWriter`).

---

### 5️⃣ Salir
- Finaliza el programa mostrando un mensaje de despedida.

---

## ⚙️ Requisitos técnicos obligatorios

- Uso de:
  - `Map<Libro, Integer>`
  - `LocalDate`
  - Clases de `java.io`
- Uso correcto de `try-catch` o `try-with-resources`
- Ruta absoluta al escritorio
- Código modularizado en métodos
- Control de errores en la entrada de datos

---

## ⭐ Ampliaciones opcionales

- Mostrar el historial de préstamos leyendo el fichero.
- Registrar también la hora del préstamo (`LocalDateTime`).
- Guardar cada préstamo en un fichero distinto.
- Ordenar los libros al mostrarlos.

---

## 🎓 Criterios de evaluación

- Correcto uso de flujos de datos
- Gestión adecuada del stock con `Map`
- Formato correcto del fichero
- Código limpio y bien estructurado
- Control de errores

---

📌 **Entrega**: Código Java funcional y comentado.

