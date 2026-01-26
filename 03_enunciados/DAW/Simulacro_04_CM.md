# 📘 Simulacro 04 – Mini proyecto con Clases y Fechas

## 🎯 Objetivo

Desarrollar una aplicación sencilla en Java para demostrar el dominio de:

- Clases y atributos
- Constructores
- Getters y setters
- `toString()`
- Uso de **ENUM**
- Uso de **fechas con `LocalDate`** y sus métodos
- Manejo de **arrays unidimensionales**

---

## 🧩 Enunciado

Crea una aplicación en Java que gestione un conjunto de **registros** (pueden ser eventos, pedidos, préstamos, incidencias, etc.).

Cada registro estará representado mediante una **clase principal** creada por ti.

---

## 🏗️ Requisitos obligatorios

### 1️⃣ Clase principal

La clase debe contener:

- **Atributos privados**, incluyendo obligatoriamente:
  - Al menos **1 atributo `LocalDate`**
  - Al menos **1 atributo de tipo ENUM**
  - Otros atributos básicos (`String`, `int`, etc.)

- **Constructor con parámetros**
- **Getters y setters**
- **Método `toString()`** correctamente implementado

---

### 2️⃣ ENUM

Crea un **ENUM** que represente una característica del registro (estado, tipo, categoría…).

Este ENUM debe usarse como atributo en la clase principal.

---

### 3️⃣ Trabajo con fechas (`LocalDate`)

Debes usar la librería:

```java
import java.time.LocalDate;
```

Implementa métodos que permitan:

- Obtener registros de un **año concreto**
- Obtener registros de un **mes concreto**
- Obtener registros dentro de un **rango de años**

Usa métodos de `LocalDate` como `getYear()` y `getMonthValue()`.

---

### 4️⃣ Uso de arrays

- Los registros se almacenarán en un **array unidimensional**
- ❌ No está permitido usar `ArrayList` ni otras colecciones

Ejemplo:

```java
Registro[] registros = new Registro[20];
```

---

## 🔍 Funcionalidades mínimas

La aplicación debe permitir:

- Añadir registros al array
- Mostrar todos los registros
- Filtrar registros por año
- Filtrar registros por mes
- Filtrar registros por rango de años


