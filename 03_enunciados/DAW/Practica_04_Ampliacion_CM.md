# 🏨 Proyecto DAW 04 – Control de Reservas

## 🎯 Resultados de aprendizaje

Este ejercicio tiene como finalidad evaluar que el alumnado es capaz de:

- Definir correctamente **clases en Java**
- Usar **atributos privados**, incluidos **ENUM** y **`LocalDate`**
- Implementar **constructores**, **getters**, **setters** y **`toString()`**
- Crear **métodos sencillos** relacionados con fechas
- Gestionar información mediante **arrays unidimensionales**
- Aplicar buenas prácticas básicas de POO

---

## 🧩 Enunciado

Una empresa necesita una aplicación sencilla para gestionar las **reservas de habitaciones**.

Cada reserva debe almacenarse como un objeto de una clase creada por ti y la aplicación permitirá registrar y consultar reservas según la **fecha**.

---

## 🏗️ Requisitos obligatorios

### 1️⃣ Clase `Reserva`

Debes crear una clase llamada `Reserva` que contenga, como mínimo:

- **Atributos privados**:
  - `String` identificador de la reserva
  - `String` nombre del cliente
  - `LocalDate` fecha de la reserva
  - `TipoReserva` (ENUM)

- **Constructor con parámetros**
- **Getters y setters**
- **Método `toString()`** sobrescrito correctamente

---

### 2️⃣ ENUM `TipoReserva`

Crea un ENUM llamado `TipoReserva` con al menos tres valores, por ejemplo:

- INDIVIDUAL
- DOBLE
- SUITE

Este ENUM debe utilizarse como atributo en la clase `Reserva`.

---

### 3️⃣ Gestión de fechas con `LocalDate`

Debes usar obligatoriamente:

```java
import java.time.LocalDate;
```

Implementa métodos que permitan:

- Mostrar reservas de un **año concreto**
- Mostrar reservas de un **mes concreto**
- Mostrar reservas dentro de un **rango de años**

Para ello, usa métodos como `getYear()` y `getMonthValue()`.

---

### 4️⃣ Uso de arrays unidimensionales

- Las reservas se almacenarán en un **array unidimensional**
- ❌ No está permitido usar `ArrayList` ni otras colecciones

Ejemplo:

```java
Reserva[] reservas = new Reserva[30];
```

Debes controlar manualmente la posición libre del array.

---

## 🔍 Funcionalidades mínimas

La aplicación debe permitir:

- Añadir una reserva al array
- Mostrar todas las reservas
- Filtrar reservas por año
- Filtrar reservas por mes
- Filtrar reservas por rango de años

---

## 🚫 Restricciones estrictas

- ❌ Prohibido usar `ArrayList`, `List`, `Map` u otras colecciones
- ❌ Prohibido usar atributos públicos
- ❌ Prohibido usar fechas como `String`

---

## 🏁 Entrega

- Código Java compilable
- Estructura clara y ordenada

---

## 📊 Rúbrica de evaluación (10 puntos)

> **Evaluación técnica y excluyente.** El incumplimiento de los requisitos básicos supondrá penalizaciones automáticas.

| Criterio evaluado                                         | Descripción                                                                                                                                                   | Puntuación   |
|-----------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|
| **Implementación de la clase `Reserva`**                  | Clase correctamente definida con atributos privados, tipos adecuados, constructor con parámetros, getters, setters y método `toString()` funcional y completo | **5 puntos** |
| **Gestión de fechas con `LocalDate` y filtros por fecha** | Uso correcto de `LocalDate` y de sus métodos. Funcionan correctamente los filtros por **año**, **mes** y **rango de años**                                    | **3 puntos** |
| **Gestión del array unidimensional**                      | Añadir reservas controlando la posición libre, sin sobrescrituras ni accesos fuera de rango                                                                   | **1 punto**  |
| **Mostrar reservas**                                      | Muestra correcta de todas las reservas usando `toString()`                                                                                                    | **1 punto**  |


---

### ❌ Penalizaciones automáticas

* Uso de `ArrayList`, `List`, `Map` u otra colección → **0 puntos en el ejercicio**
* Uso de fechas como `String` → **−4 puntos**
* Atributos públicos → **−2 puntos**
* Código que no compila → **nota máxima: 3 puntos**
* No implementar alguno de los filtros solicitados → **−0,5 puntos por filtro**
* Lanza una excepción no controlada → **−0,5 puntos por excepción**

---

### ⚠️ Observaciones finales

* El código debe ser **compilable y funcional** para ser evaluado
* No se puntúa código redundante o innecesariamente complejo
* La corrección técnica prevalece sobre la cantidad de código
* El uso de LocalDate está directamente ligado al correcto funcionamiento de los filtros por fecha
* Si los filtros no funcionan, se considerará incorrecto el tratamiento de fechas
* La corrección técnica prevalece sobre la cantidad de código

💡 **Nota:** Un ejercicio que no respete los principios básicos de POO no podrá superar el aprobado.

