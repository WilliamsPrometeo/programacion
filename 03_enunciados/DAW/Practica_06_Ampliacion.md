# Práctica 06 – Gestión de Pedidos

## Objetivo
Desarrollar una aplicación en Java que permita gestionar los **pedidos de un restaurante** utilizando:

- Manejo de **ficheros con la clase `File`**
- **Flujos de entrada y salida de texto**
- Uso de **`BufferedReader` y `BufferedWriter`**
- Uso correcto de **`ArrayList` dentro de clases**
- Separación básica de responsabilidades entre clases (MVC formativo)

---

# Enunciado

Un restaurante quiere almacenar los pedidos realizados durante el día en un sistema sencillo.

Debes desarrollar una aplicación en Java que permita:

1. Registrar un nuevo pedido
2. Mostrar todos los pedidos registrados
3. Guardar los pedidos en un fichero de texto
4. Cargar los pedidos desde un fichero

Todos los pedidos deberán almacenarse en memoria utilizando un **ArrayList**.

---

# Estructura mínima del programa

El programa deberá estar compuesto al menos por las siguientes clases:

- `PedidoController`
- `PedidoException`
- `PedidoService`
- `PedidoDAO`
- `Pedido`
- `Main`

---

# Clase `Pedido`

Representa un pedido realizado en el restaurante.

## Atributos mínimos

- `id` (String - 3 letras y 2 números)
- `nombreCliente` (String)
- `plato` (String)
- `precio` (double)

## Métodos

Debe incluir al menos:

- Constructor
- Getters
- Método `toString()` para mostrar la información del pedido
- El id debe almacenarse en mayúsculas

---

# Métodos obligatorios

## `agregarPedido(Pedido pedido)`

Añade un nuevo pedido al sistema.

No se deben permitir **pedidos con el mismo `id`**.

---

## `mostrarPedidos()`

Muestra todos los pedidos almacenados en el `ArrayList`.

---

## `guardar(String ruta)`

Guarda todos los pedidos en un fichero de texto.

Debe utilizar:

- `File`
- `FileWriter`
- `BufferedWriter`

Formato del fichero:

```
id;cliente;plato;precio
```

Ejemplo:

```
PED01;Carlos;Hamburguesa;9.50
PED02;Laura;Pizza;11.00
```

Cada pedido debe guardarse en **una línea del fichero**.

---

## `cargar()`

Lee los pedidos desde el fichero.

Debe utilizar:

- `File`
- `FileReader`
- `BufferedReader`

El método debe:

1. Leer cada línea del fichero
2. Separar los datos usando `split(";")`
3. Crear un objeto `Pedido`
4. Añadir el pedido al `ArrayList`
5. Devuelve la lista de pedidos

Cada método debe implementarse en la clase que corresponda siguiendo el principio de responsabilidad única.

---

# Clase `Main`

Debe incluir un menú por consola similar al siguiente:

```
==== GESTION DE PEDIDOS ====
1. Registrar pedido
2. Mostrar pedidos
3. Guardar pedidos en fichero
4. Cargar pedidos desde fichero
5. Salir
```

El programa debe ejecutarse hasta que el usuario elija la opción **Salir**.

---

# Requisitos del programa

El programa debe:

- Utilizar **ArrayList para almacenar los pedidos**
- Utilizar correctamente **BufferedReader y BufferedWriter**
- Comprobar si el fichero existe utilizando **File**
- Evitar **pedidos duplicados por idPedido**
- Estar correctamente organizado en **varias clases**

---

# Rúbrica de Evaluación (sobre 10 puntos)

| Criterio                               | Descripción                                                                        | Puntos |
|----------------------------------------|------------------------------------------------------------------------------------|--------|
| Modelado de clases                     | Definición correcta de la clase `Pedido` con atributos, constructor y `toString()` | 1      |
| Uso de ArrayList                       | Uso correcto de `ArrayList` para almacenar objetos sin duplicados                  | 1      |
| Escritura en fichero                   | Uso correcto de `File`, `FileWriter` y `BufferedWriter` para guardar datos         | 1.5    |
| Lectura de fichero                     | Uso correcto de `File`, `FileReader` y `BufferedReader` para leer datos            | 1.5    |
| Separación básica de responsabilidades | Separación correcta de lógica siguiedo el principio de responsabilidad única       | 5      |

**Total: 10 puntos**

