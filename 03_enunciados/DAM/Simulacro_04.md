# 🏨 SIMULACRO_04 – GESTIÓN DE RESERVAS

## 🎯 Objetivo del proyecto

Desarrollar una aplicación en **Java** para la gestión básica de reservas en un alojamiento (hotel o apartamentos) aplicando el patrón **MVC (Modelo – Vista – Controlador)** en entorno de consola.

⚠️ Importante:

* No se utilizará entorno gráfico.
* La "Vista" estará integrada dentro del Controller (MVC formativo).
* Los datos deberán poder guardarse y cargarse desde archivo binario (.dat).

---

## 📌 Requisitos funcionales

La aplicación deberá permitir:

1. Registrar una reserva.
2. Listar todas las reservas.
3. Buscar una reserva por su código.
4. Cancelar (eliminar) una reserva por su código.
5. Guardar los datos en archivo binario (.dat).
6. Cargar los datos desde archivo binario (.dat).

El menú deberá repetirse hasta que el usuario elija la opción de salir.

---

## 🏗 Estructura obligatoria del proyecto

El proyecto deberá respetar la siguiente estructura de paquetes:

```
reservas
 ├── controller
 ├── dao
 ├── exceptions
 ├── models
 │    └── enums
 ├── repository
 ├── service
 └── AppReservas.java
```

---

## 🧠 Requisitos técnicos obligatorios

### 1️⃣ MVC Formativo

* El Controller pedirá los datos por consola.
* El Service contendrá la lógica de negocio.
* El Repository será el contrato que seguirá el Service.
* El DAO gestionará la persistencia en archivo.
* El App ejecutará la aplicación y contendrá el menú.

⚠️ No se permite mezclar lógica de negocio en el Controller.

---

### 2️⃣ Uso de Map

Las reservas deberán almacenarse en memoria utilizando un **Map cuya clave sea el propio objeto Reserva**.

Estructura obligatoria:

```
Map<Reserva, TipoHabitacion> asignaciones
```

Donde:

* La clave será el objeto `Reserva`.
* El atributo `codigoReserva` deberá identificarla de manera única.
* El valor `TipoHabitacion` será un ENUM con los tipos disponibles.

Ejemplo de ENUM:

* INDIVIDUAL
* DOBLE
* SUITE

⚠️ IMPORTANTE:

Será obligatorio:

* Sobrescribir `equals()`
* Sobrescribir `hashCode()`

Ambos métodos deberán basarse únicamente en el atributo `codigoReserva`.

Si no se implementan correctamente:

* No se detectarán duplicados.
* No se podrán recuperar correctamente las reservas.
* El Map no funcionará adecuadamente.

❌ No se permite usar únicamente ArrayList como estructura principal.

---

### 3️⃣ Herencia

Debe existir:

* Una clase abstracta `Reserva`
* Al menos dos clases que hereden de ella (por ejemplo: `ReservaHotel` y `ReservaApartamento`)

La clase `Reserva` deberá contener:

* codigoReserva (formato obligatorio: 2 letras seguidas de 4 números. Ejemplo válido: AB1234)
* fechaEntrada
* fechaSalida
* método abstracto que identifique el tipo de reserva

El código deberá validarse mediante comprobación (por ejemplo, usando expresiones regulares).
Si no cumple el formato, se deberá lanzar una excepción personalizada verificable.

Cada subclase deberá contener:

* Un atributo propio (por ejemplo: incluyeDesayuno / numeroPlazaGaraje)
* Implementación correcta del método abstracto

---

### 4️⃣ Serializable

Todos los modelos deberán implementar `Serializable`.

Se deberá:

* Definir `serialVersionUID`
* Permitir guardar y recuperar los datos correctamente

---

### 5️⃣ Persistencia (.dat)

Se deberá crear:

* Una interfaz DAO
* Una implementación que guarde y cargue usando:

  * `ObjectOutputStream`
  * `ObjectInputStream`

El archivo deberá llamarse:

```
reservas.dat
```

Deberá guardarse en la siguiente ruta:

```
Desktop/DAM/Simulacros/Reservas
```

Se deberá controlar correctamente:

* Excepciones de E/S
* Archivo inexistente
* Archivo vacío

---

### 6️⃣ Excepciones personalizadas verificadas

Se deberán crear al menos:

* `InvalidReservaException`
* `InvalidDateException`

Las excepciones deberán:

* Extender de `Exception` (NO RuntimeException)
* Sobrescribir `getMessage()`
* Contener información adicional cuando sea necesario

Ejemplos de validaciones obligatorias:

* Código vacío o nulo
* Código con formato incorrecto
* Fecha de entrada posterior a la fecha de salida
* Fecha de entrada anterior a la fecha actual

---

## 📋 Funcionamiento esperado

Ejemplo de menú:

```
1. Registrar reserva
2. Listar reservas
3. Buscar reserva
4. Cancelar reserva
5. Guardar datos
6. Cargar datos
0. Salir
```

El programa:

* No debe finalizar si ocurre una excepción controlada.
* Debe mostrar mensajes claros al usuario.
* Debe mantener estabilidad en el flujo del menú.

---

## 🧩 Consideraciones de diseño

Antes de comenzar a programar:

1. Diseña correctamente el modelo.
2. Define bien las validaciones.
3. Implementa primero el Repository.
4. Después el Service.
5. Luego el Controller.
6. Finalmente la persistencia.

⚠️ Se valorará especialmente:

* Separación clara de responsabilidades.
* Validaciones centralizadas en Service.
* Diseño orientado a dominio.
* Uso correcto de herencia y polimorfismo.
* Implementación rigurosa de `equals()` y `hashCode()`.

---

## 🏁 Resultado esperado

Al finalizar el proyecto, el alumno deberá haber demostrado:

* Aplicación real del patrón MVC formativo.
* Uso correcto de Map como estructura principal.
* Implementación de herencia con clase abstracta.
* Gestión de excepciones verificadas.
* Persistencia mediante serialización.
* Diseño coherente y profesional orientado a objetos.
