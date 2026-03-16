# Simulacro de Evaluación – Gestión de Clientes (Ficheros y Flujos en Java)


## Objetivo
Desarrollar una aplicación en Java que permita gestionar una **lista de clientes** de una empresa.

El programa deberá utilizar:

- Manejo de **ficheros con la clase File**
- **Lectura y escritura de texto**
- Uso de **BufferedReader y BufferedWriter**
- Uso de **ArrayList para almacenar objetos**
- Organización del código en **varias clases**

---

# Enunciado

Una empresa quiere almacenar información básica de sus **clientes** en un fichero de texto.

Debes desarrollar una aplicación que permita:

1. Registrar nuevos clientes
2. Mostrar todos los clientes
3. Guardar los clientes en un fichero
4. Cargar los clientes desde un fichero

Toda la información deberá mantenerse en memoria utilizando un **ArrayList**.

---

# Estructura mínima del programa

El programa deberá estar compuesto por al menos **tres clases**.

---

# Clase `Cliente`

Debe representar a un cliente de la empresa.

## Atributos mínimos

- `id` (String)
- `nombre` (String)
- `email` (String)

## Métodos

Debe incluir al menos:

- Constructor
- Getters
- Método `toString()`

---

# Clase `GestionClientes`

Será la clase encargada de manejar la lista de clientes.

## Atributo

```java
ArrayList<Cliente> clientes
```

---

# Métodos obligatorios

## `agregarCliente()`

Añade un cliente al sistema.

No debe permitir **clientes con el mismo id**.

---

## `mostrarClientes()`

Muestra todos los clientes almacenados en el `ArrayList`.

---

## `guardarClientes()`

Guarda todos los clientes en un fichero de texto.

Debe utilizar:

- `File`
- `FileWriter`
- `BufferedWriter`

Formato del fichero:

```
id;nombre;email
```

Ejemplo:

```
C01;Ana Lopez;ana@email.com
C02;Luis Perez;luis@email.com
```

---

## `cargarClientes(String ruta)`

Lee los clientes desde el fichero.

Debe utilizar:

- `File`
- `FileReader`
- `BufferedReader`

El método debe:

1. Leer cada línea del fichero
2. Separar los datos usando `split(";")`
3. Crear un objeto `Cliente`
4. Añadirlo al `ArrayList`

---

# Clase `Main`

Debe implementar un menú por consola:

```
1. Añadir cliente
2. Mostrar clientes
3. Guardar clientes en fichero
4. Cargar clientes desde fichero
5. Salir
```

---

# Requisitos del programa

El programa debe:

- Utilizar **ArrayList para almacenar los clientes**
- Usar correctamente **BufferedReader y BufferedWriter**
- Comprobar si el fichero **existe** usando `File`
- Evitar **clientes duplicados por id**
- Estar organizado en **varias clases**
