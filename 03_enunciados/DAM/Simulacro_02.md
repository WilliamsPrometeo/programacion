# 📘 Simulacro Proyecto 2 — Sistema de Gestión de Librería

## 🎯 Objetivos de aprendizaje
Durante este proyecto deberás demostrar:

- Creación y uso de **clases**, **herencia** y **polimorfismo**.  
- Implementación de **métodos con parámetros y retorno**.  
- Correcto uso de **ArrayList** y **Map** para almacenar objetos.  
- Aplicación de **condicionales**, **switch**, **operador ternario**, bucles y filtrados.  
- Uso de **Enums** para clasificaciones.  
- Obtención de la fecha y hora actual mediante **LocalDateTime**, formateada adecuadamente.  
- Control de errores mediante una **excepción personalizada (UserNotFound)**.  
- Formateo de texto con `printf` y `String.formatted()`.  
- Uso obligatorio de la clase **MyScanner** para la entrada de datos del usuario.
- Documentación **obligatoria** mediante JavaDoc.

---

# 📚 Descripción general del proyecto

Deberás crear un pequeño sistema de gestión para una **librería** que permite registrar usuarios, registrar libros, prestar libros y consultar información de libros y préstamos.

La aplicación tendrá un menú principal y funcionará completamente por consola utilizando **MyScanner** para todas las entradas de texto o números.

---

# 🧱 Estructura de clases requerida

## 🧍‍♂️ Clase `Persona`
Crea una clase abstracta llamada **Persona**, que contendrá los atributos:

- `String nombre`  
- `String dni`

Además, deberá incluir:

- Constructores apropiados  
- Getters y setters  
- Métodos adicionales si son necesarios

La clase **Usuario** deberá heredar de esta clase.

---

## 👤 Clase `Usuario` (hereda de Persona)
La clase `Usuario` representará a un cliente de la librería.

Requisitos:
- Hereda de **Persona**  
- Debe contener un atributo que contenga la fecha de creación del Usuario
- Debe sobrescribir:
  - `toString()` con formato  
  - `equals()` y `hashCode()` **basados únicamente en el DNI**  
- Será el tipo utilizado como **clave del Map** de préstamos

---

## 📘 Clase `Libro`
Cada libro debe tener:

- `String titulo`  
- `String autor`  
- `Genero genero` (usando un **Enum**)

Además:

- Al menos un constructor básico  
- Getters y setters  
- Método `toString()` con texto formateado

---

## 🏷️ Enum `Genero`
Debes definir un **enum** llamado `Genero` que represente categorías como:

- FICCION  
- NO_FICCION  
- MISTERIO  
- TECNICO  

Puedes ampliarlo si lo deseas.

---

## 🏢 Clase `Libreria`
Esta clase será el “núcleo” del proyecto.

### **Atributos obligatorios**
- `ArrayList<Libro> disponibles` → libros disponibles para prestar  
- `Map<Usuario, Libro> prestamos` → registro de préstamos  
- `ArrayList<Usuario> usuarios` → listado de usuarios registrados

### **Constructor**
- Constructor vacío en el que se inicialicen todas las colecciones

### **Métodos obligatorios**

1. **registrarUsuario()**  
   - Solicita datos al usuario mediante **MyScanner**  
   - Crea un usuario y lo añade a la lista
   - Validar que el DNI tenga 9 caracteres; en caso contrario, mostrar un mensaje de error y repetir la solicitud.

2. **registrarLibro()**  
   - Solicita título, autor y género (usando menú con `switch`)  
   - Crea el libro y lo añade a `disponibles`

3. **prestarLibro()**  
   - Solicita DNI del usuario  
   - Llama internamente a **buscarUsuario()**  
   - Si no existe → lanzar **UserNotFound**  
   - Solicita el título del libro  
   - Busca el libro  
   - Si existe:  
     - Lo elimina de `disponibles`  
     - Lo registra en `prestamos`  
     - Muestra fecha y hora del préstamo con **LocalDateTime**  
   - Debe usar al menos un **operador ternario**

4. **mostrarLibros()**  
   - Muestra todos los libros disponibles  
   - Ofrece una opción de filtrar por `Genero`

5. **mostrarPrestamos()**  
   - Muestra el contenido del Map con formato (`printf`)

6. **buscarUsuario(String dni)**  
   - Devuelve un usuario existente  
   - Si no existe → lanza **UserNotFound**

7. **buscarLibro(String titulo)**  
   - Devuelve el libro o `null`

---

## ❗ Excepción personalizada: `UserNotFound`
Debe extender de `Exception` (no RuntimeException).  
Será utilizada cuando se intente operar con un usuario no registrado.

---

## ⌨️ Uso obligatorio de MyScanner
La clase **MyScanner** deberá utilizarse **para todas las entradas del usuario**.

---
## ⌨️ Documentación obligatoria mediante JavaDoc
Las clases serán documentadas con JavaDoc con el formato enseñado en clase.

---

# ▶️ Clase Main
Crear una clase `Main` con un menú que permita:

1. Registrar usuario  
2. Registrar libro  
3. Prestar libro  
4. Mostrar libros disponibles  
5. Mostrar préstamos  
6. Salir

El menú debe utilizar **switch** y funcionar dentro de un **bucle**.

---

# ✨ Requisitos adicionales
Para obtener la máxima puntuación, asegúrate de:

- Usar correctamente la **herencia** Persona → Usuario  
- Que el **Map<Usuario, Libro>** funcione usando bien equals/hashCode  
- Usar `printf` para formatear texto  
- Incluir un **operador ternario**  
- Incluir un uso de **LocalDateTime** con formato  
- Mantener el código legible, claro y organizado
- Documentar el código con JavaDoc

