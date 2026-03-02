# 🧪 SIMULACRO – Gestión de Vehículos en un Concesionario

---

## 🎯 Objetivo

Desarrollar una aplicación en **Java** que permita gestionar los vehículos de un concesionario, aplicando correctamente:

- Herencia básica
- Uso de `ArrayList<>`
- Uso de `Map<K,V>`
- Sobreescritura correcta de `equals()` y `hashCode()`
- Uso de un atributo como clave única dentro de un `Map`

---

# 🏢 Contexto del problema

Un concesionario necesita una aplicación para gestionar los vehículos que tiene disponibles para la venta.

Todos los vehículos comparten características comunes, pero existen distintos tipos de vehículos.

---

# 🚗 Parte 1 – Modelo de clases (Herencia)

## 1️⃣ Clase abstracta `Vehiculo`

Debe contener como mínimo:

- `String matricula` (clave única)
- `String marca`
- `String modelo`
- `double precio`

### Requisitos:

- Constructor
- Getters
- Método abstracto:

```java
public abstract String mostrarInformacion();
```

- Sobreescribir correctamente:
  - `equals()`
  - `hashCode()`

⚠️ **La igualdad debe depender únicamente de la `matricula`.**

---

## 2️⃣ Subclases

Crear al menos dos tipos de vehículos:

### 🚘 `Coche`
- `int numeroPuertas`

### 🏍 `Moto`
- `int cilindrada`

Cada subclase debe:

- Llamar al constructor de la clase padre
- Implementar el método `mostrarInformacion()`

---

# 📚 Parte 2 – Gestión con Colecciones

Crear una clase `Concesionario` que gestione los vehículos.

Debe contener:

```java
private ArrayList<Vehiculo> listaVehiculos;
private Map<Vehiculo, Integer> stockVehiculos;
```

Donde:

- El `ArrayList` almacenará todos los vehículos registrados.
- El `Map` almacenará como clave el objeto `Vehiculo` y como valor un `Integer` que representará el stock disponible.
- La clave del `Map` debe funcionar correctamente gracias a la implementación adecuada de `equals()` y `hashCode()` basada únicamente en la `matricula`.

---

# 🛠 Parte 3 – Funcionalidades obligatorias

## 1️⃣ Añadir vehículo

```java
public boolean agregarVehiculo()
```

### Requisitos:

- Si el vehículo ya existe (según `equals()` y `hashCode()`), aumentar su stock en el `Map`.
- Si no existe, añadirlo al `ArrayList` y registrarlo en el `Map` con stock inicial 1.
- No deben existir vehículos duplicados en el `ArrayList`.

---

## 2️⃣ Consultar stock de un vehículo

```java
public void consultarStock()
```

Debe mostrar el stock utilizando el `Map` (NO recorrer el ArrayList).

---

## 3️⃣ Mostrar todos los vehículos

```java
public void mostrarVehiculos()
```

Debe recorrer el `ArrayList`.

---

## 4️⃣ Reducir stock de un vehículo

```java
public boolean reducirStock()
```

Debe:

- Reducir en 1 el stock si existe.
- Si el stock llega a 0, eliminarlo del `Map` y del `ArrayList`.
- Mantener coherencia entre ambas estructuras.


