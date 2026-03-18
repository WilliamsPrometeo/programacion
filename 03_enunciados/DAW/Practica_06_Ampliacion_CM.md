# Práctica 06: Gestión de Inventario de Videojuegos

## Contexto
Una tienda de videojuegos quiere digitalizar su inventario. Para ello necesita una pequeña aplicación en Java que permita gestionar los videojuegos disponibles y guardar la información en archivos de texto.

El sistema deberá permitir registrar videojuegos, consultar el inventario y guardar/cargar los datos desde archivos utilizando flujos de datos con buffer.

## Objetivos de aprendizaje
- Uso de la clase `File` para gestionar archivos.
- Uso de flujos de entrada y salida de texto.
- Uso de `BufferedReader` y `BufferedWriter`.
- Gestión de colecciones con `ArrayList`.

## Requisitos

### 1. Clase Videojuego
Cada videojuego debe tener:
- id (String)
- titulo (String)
- plataforma (ENUM)
- precio (double)

El id debe seguir el siguiente formato: 2 letras y 2 números, además de almacenarse en mayúsculas.
Debe estar correctamente documentada. Debe incluir al menos 1 constructor, getter y setter de todos los atributos, el método to string correctamente formateado.

### 2. Clase Inventario
Debe gestionar una colección `ArrayList<Videojuego>` y proporcionar métodos para:

- Agregar un videojuego
- Mostrar todos los videojuegos
- Guardar el inventario en un archivo de texto
- Cargar el inventario desde un archivo

No se permiten almacenar id duplicados.

### 3. Persistencia en archivo
El programa debe:

- Crear un archivo si no existe y guardarlo en la siguiente ruta -> `/Desktop/DAW/Proyectos/`.
- El archivo se llamará `inventario.txt`
- Guardar los videojuegos en el archivo usando `BufferedWriter`.
- Leer los videojuegos usando `BufferedReader`.

Formato sugerido del archivo:

```
id;titulo;plataforma;precio
```

### 4.Clase Main
El programa principal debe mostrar un menú por consola:

1. Registrar videojuego
2. Mostrar inventario
3. Mostrar datos del videojuego por id
4. Guardar inventario en archivo
5. Cargar inventario desde archivo
6. Salir


## Rúbrica de evaluación

| Criterio              | Descripción                             | Puntuación |
|-----------------------|-----------------------------------------|------------|
| Modelo de datos       | Clase Videojuego correctamente definida | 2          |
| Uso de ArrayList      | Gestión correcta de la colección        | 2          |
| Escritura en archivo  | Uso correcto de File y BufferedWriter   | 2          |
| Lectura de archivo    | Uso correcto de BufferedReader          | 2          |
| Menú y funcionamiento | El programa funciona correctamente      | 2          |

**Total: 10 puntos**

