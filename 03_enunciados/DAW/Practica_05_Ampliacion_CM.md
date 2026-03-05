# 🧪 Practica 05 – Gestión de Biblioteca Digital

---

## 🎯 Objetivo

Desarrollar una aplicación en **Java** que permita gestionar los materiales de una biblioteca digital, aplicando correctamente:

- Herencia básica
- Uso correcto de `ArrayList<>`
- Uso correcto de `Map<K,V>`
- Implementación correcta de `equals()` y `hashCode()`
- Uso de objetos como clave en un `Map`

⏳ **Duración máxima: 60 minutos**

---

# 📚 Contexto del problema

Una biblioteca necesita un sistema para gestionar los materiales disponibles para préstamo.

Existen distintos tipos de materiales, pero todos comparten ciertas características comunes.

Además, la biblioteca quiere controlar el **stock disponible de cada material**.

---

# 🧩 Parte 1 – Modelo de clases (Herencia)

## 1️⃣ Clase abstracta `Material`

Debe contener como mínimo:

- `String codigo` (identificador único)
- `String titulo`
- `String autor`
- `int anioPublicacion`

### Requisitos obligatorios:

- Constructor
- Getters
- Método abstracto:

```java
public abstract String mostrarDetalle();
```

- Sobreescribir correctamente:
  - `equals()`
  - `hashCode()`

⚠️ **La igualdad debe depender únicamente del atributo `codigo`.**

- Formato correcto del código:
  - Se debe validar el código con el siguiente formato: 3 letras seguido de 2 números.
  - El código se debe almacenar en mayúsculas.

---

## 2️⃣ Subclases

Crear al menos dos tipos de materiales:

### 📖 `Libro`
- `int numeroPaginas`

### 💿 `Revista`
- `int numeroEdicion`

Cada subclase debe:

- Llamar al constructor de la clase padre
- Implementar el método `mostrarDetalle()`

---

# 📦 Parte 2 – Gestión con Colecciones

Crear una clase `Biblioteca` que gestione los materiales.

Debe contener:

```java
private ArrayList<Material> listaMateriales;
private Map<Material, Integer> stockMateriales;
```

### Condiciones:

- El `ArrayList` almacenará los materiales sin duplicados.
- El `Map` almacenará como clave el objeto `Material` y como valor un `Integer` que represente el stock disponible.
- El correcto funcionamiento del `Map` dependerá de la implementación adecuada de `equals()` y `hashCode()`.

---

# 🛠 Parte 3 – Funcionalidades obligatorias

## 1️⃣ Añadir material

```java
public void agregarMaterial()
```

Requisitos:

- Si el material ya existe (según `equals()`), mostrar un mensaje de que ya existe.
- Si no existe, añadirlo al `ArrayList` y registrarlo en el `Map` con stock inicial 1.
- No deben existir duplicados en el `ArrayList`.

---

## 2️⃣ Consultar stock

```java
public Integer consultarStock()
```

Debe mostrar el stock usando directamente el `Map` (NO recorrer el ArrayList).

---

## 3️⃣ Reducir stock (simular préstamo)

```java
public boolean prestarMaterial()
```

Debe:

- Pedir el código del material.
- Reducir el stock en 1 si está disponible.
- Si el stock llega a 0, eliminar el material del `Map` y del `ArrayList`.
- Mantener coherencia entre ambas estructuras.

---

## 4️⃣ Mostrar todos los materiales

```java
public void mostrarMateriales()
```

Debe recorrer el `ArrayList` y mostrar la información detallada.

---

# 🧠 Parte 4 – Menú principal

En una clase Main el programa mostrará de forma repetitiva el siguiente menú hasta que el usuario decida salir:

```
===== GESTIÓN DE BIBLIOTECA DIGITAL =====
1. Registrar Material
2. Mostrar Stock
3. Prestar Material
4. Mostrar Material disponible
5. Salir
```
---

# 📌 Restricciones técnicas

- No usar `static` para almacenar datos globales.
- No usar Streams.
- No usar estructuras distintas a `ArrayList` y `Map`.
- Comparaciones de `String` con `.equals()`.

---

# 🚨 Errores que penalizan

- No sobrescribir correctamente `equals()` y `hashCode()`.
- Permitir duplicados en el `ArrayList`.
- No usar el `Map` para consultar stock.
- No mantener sincronizadas ambas estructuras.
- Comparar `String` con `==`.

---

# 📊 Rúbrica de evaluación (sobre 10 puntos)

| Criterio                         | Descripción                                                      | Puntuación |
|----------------------------------|------------------------------------------------------------------|------------|
| Modelo de herencia               | Clase abstracta correcta y subclases bien implementadas          | 2 puntos   |
| equals() y hashCode()            | Implementación correcta basada solo en `codigo`                  | 2 puntos   |
| Uso correcto de ArrayList        | Sin duplicados y correctamente gestionado                        | 1.5 puntos |
| Uso correcto de Map              | Gestión adecuada de stock con `Map<Material, Integer>`           | 2 puntos   |
| Funcionalidades obligatorias     | Métodos agregar, consultar y prestar correctamente implementados | 1.5 puntos |
| Coherencia entre estructuras     | Sin inconsistencias entre ArrayList y Map                        | 0.5 puntos |
| Código limpio y buenas prácticas | Claridad, estructura y uso correcto de Java                      | 0.5 puntos |

---

# 🏁 Nota final

La nota final será la suma de los apartados anteriores sobre un máximo de **10 puntos**.

Se valorará especialmente:

- Comprensión real de cómo funciona un `Map` con objetos como clave.
- Correcta implementación del contrato entre `equals()` y `hashCode()`.
- Uso adecuado de la herencia.

