# Simulacro de Evaluación – Ficheros, Flujos de Datos y ArrayList en Java

## Objetivo
Desarrollar una pequeña aplicación en Java que permita gestionar un conjunto de **libros de una biblioteca** utilizando:

- Manejo de **ficheros con la clase File**
- **Flujos de entrada y salida de texto**
- Uso de **BufferedReader y BufferedWriter**
- Uso correcto de **ArrayList dentro de clases**
- Separación básica de responsabilidades entre clases

---

# Enunciado

Una biblioteca quiere almacenar información sobre los libros que tiene disponibles. Para ello se desarrollará una pequeña aplicación en Java que permita:

1. Registrar libros
2. Mostrar los libros registrados
3. Guardar los libros en un fichero de texto
4. Cargar los libros desde un fichero

Toda la información deberá almacenarse en memoria utilizando **ArrayList**.

---

# Estructura mínima

Se deben crear al menos las siguientes clases:

## Clase Libro

Atributos mínimos:

- codigo (String)
- titulo (String)
- autor (String)

Debe incluir:

- Constructor
- Getters
- Método `toString()`

---

## Clase Biblioteca

Atributo principal:

- `ArrayList<Libro> libros`

Métodos mínimos:

### agregarLibro(Libro libro)
Añade un libro a la colección.

### mostrarLibros()
Muestra todos los libros almacenados en la lista.

### guardarEnFichero(String ruta)
Guarda todos los libros en un fichero de texto utilizando:

- File
- FileWriter
- BufferedWriter

Formato del fichero:

```
codigo;titulo;autor
```

Ejemplo:

```
L001;El Quijote;Cervantes
L002;1984;George Orwell
```

---

### cargarDesdeFichero(String ruta)
Lee los libros desde el fichero utilizando:

- File
- FileReader
- BufferedReader

Debe:

1. Leer cada línea
2. Separar los datos
3. Crear objetos `Libro`
4. Añadirlos al `ArrayList`

---

## Clase Main

Debe incluir un menú sencillo por consola:

```
1. Registrar libro
2. Mostrar libros
3. Guardar en fichero
4. Cargar desde fichero
5. Salir
```

---

# Requisitos

El programa debe:

- Utilizar **ArrayList para almacenar los objetos**
- Utilizar correctamente **BufferedReader y BufferedWriter**
- Comprobar si el fichero existe usando **File**
- Evitar duplicados por código
- Mantener una estructura clara entre clases


