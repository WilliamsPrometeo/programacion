# 🎬 PROYECTO 03 – GESTIÓN DE PELÍCULAS

## 🎯 Objetivo de la práctica

Desarrollar una aplicación en **Java** que permita gestionar un catálogo de **películas**, poniendo en práctica los siguientes **resultados de aprendizaje**:

- Uso correcto de **colecciones** (`ArrayList`, `Map`)
- Manejo de **fechas** mediante `LocalDate`
- Escritura en **ficheros de texto** usando flujos de datos
- Aplicación correcta de **Programación Orientada a Objetos**
- Sobrescritura correcta de los métodos `equals()` y `hashCode()`
- Documentación del código mediante **JavaDoc**

---

## 🧾 Contexto

Una plataforma de streaming desea desarrollar un sistema sencillo para **gestionar su catálogo de películas** y registrar las **visualizaciones realizadas por los usuarios**.

Cada vez que una película es visualizada, el sistema deberá actualizar un contador y registrar la acción en un fichero de texto.

---

## 🧱 Modelo de clases

### 🎥 Clase `Pelicula`

Representa una película del catálogo.

**Atributos:**
- `String codigo` *(identificador único)*
- `String titulo`
- `String director`
- `Genero genero` *(enum)*
- `LocalDate fechaEstreno`

📌 El atributo `codigo` identificará de forma única a cada película.

---

### 🎞️ Enumerado `Genero`

Contendrá distintos géneros cinematográficos (acción, drama, comedia, ciencia ficción, etc.).

---

## 🏗️ Clase principal

### `GestionPeliculas`

Contendrá los siguientes atributos estáticos:

```java
static ArrayList<Pelicula> peliculas;
static Map<Pelicula, Integer> visualizaciones;
```

- El `ArrayList` almacenará todas las películas registradas.
- El `Map` almacenará el número de visualizaciones de cada película.

---

## 📋 Menú principal

El programa mostrará de forma repetitiva el siguiente menú hasta que el usuario decida salir:

```
===== GESTIÓN DE PELÍCULAS =====
1. Registrar película
2. Mostrar películas
3. Ver película
4. Mostrar estadísticas de visualización
5. Salir
```

---

## ✅ Funcionalidades a implementar

### 1️⃣ Registrar película

- Solicitar todos los datos necesarios para crear una película.
- El `codigo` debe:
  - Ser alfanumérico
  - Almacenarse siempre en mayúsculas
- Añadir la película al `ArrayList`.
- Inicializar su número de visualizaciones en el `Map`.

📌 No se permitirán películas duplicadas.

---

### 2️⃣ Mostrar películas

Mostrar todas las películas registradas indicando:
- Código
- Título
- Director
- Género
- Fecha de estreno
- Número de visualizaciones

---

### 3️⃣ Ver película (FLUJOS DE DATOS)

Simula la visualización de una película.

**Funcionamiento:**
1. Solicitar el código de la película.
2. Comprobar que la película existe.
3. Incrementar su número de visualizaciones en el `Map`.
4. Registrar la visualización en un fichero de texto.

---

## 📂 Escritura en fichero (OBLIGATORIO)

- El fichero se guardará en una **ruta absoluta del escritorio** del usuario.
- Se crearán los subdirectorios necesarios en el escritorio. Estructura:
```
Descktop
|--- DAM
      |--- Proyectos
              |--- Peliculas
```
- Nombre del fichero:

```
historial_peliculas.txt
```

- El fichero debe crearse si no existe.
- Las visualizaciones se añadirán **al final del fichero**, sin sobrescribir.
- Uso obligatorio de `FileWriter` y `try-with-resources`.

### 📄 Formato del fichero

```
----- VISUALIZACIÓN -----
Fecha: 2026-02-01
Código: MOV123
Título: Matrix
Director: Wachowski
------------------------
```

📌 La fecha se obtendrá automáticamente mediante `LocalDate.now()`.

---

## ⚙️ Requisitos técnicos obligatorios

- Uso de `ArrayList` y `Map<Pelicula, Integer>`
- Uso correcto de `LocalDate`
- Sobrescritura correcta de `equals()` y `hashCode()`
- Uso de flujos de datos (`java.io`)
- Código modularizado en métodos
- Control de errores en la entrada de datos
- **Uso obligatorio de JavaDoc en todas las clases y métodos públicos**

⚠️ **Sin JavaDoc el proyecto no será corregido.**

---

## 📊 Rúbrica de evaluación (sobre 10 puntos)

| Criterio de evaluación                                | Puntuación |
|-------------------------------------------------------|------------|
| **JavaDoc completo y correcto (OBLIGATORIO)**         | **1,5**    |
| Sobrescritura correcta de `equals()` y `hashCode()`   | 2,0        |
| Gestión correcta de colecciones (`ArrayList` y `Map`) | 1,5        |
| Registro e incremento correcto de visualizaciones     | 1,5        |
| Escritura correcta en fichero (flujos de datos)       | 1,5        |
| Uso adecuado de `LocalDate`                           | 1,0        |
| Código limpio, modularizado y legible                 | 1,0        |
| **TOTAL**                                             | **10**     |

---

## 📝 Observaciones finales

- El proyecto debe compilar y ejecutarse correctamente.
- Se valorará especialmente la claridad del código y el uso correcto de POO.
- Las ampliaciones son bienvenidas siempre que no rompan los requisitos obligatorios.

📌 **Entrega:** proyecto Java funcional y documentado.

