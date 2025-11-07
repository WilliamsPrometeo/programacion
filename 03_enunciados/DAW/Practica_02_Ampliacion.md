# 🧩 Proyecto 3 – Gestión de Notas de Alumnos

## 📘 Nivel
1º DAW — Asignatura: *Ampliación de Programación (Java)*  
Duración estimada: 1 hora  
Actividad individual y evaluable

---

## 🎯 Objetivo
Desarrollar un programa modular en Java que gestione la calificación de un alumno, aplicando **clases, atributos, constructores y métodos**.  
El alumno practicará el uso de **Programación Orientada a Objetos (POO)**, **validación de datos** y **métodos de cálculo** mediante la clase `MyScanner`.

---

## 🧠 Descripción general
El programa debe permitir introducir las notas de un estudiante en tres asignaturas y calcular su **media final**, indicando si el alumno **aprueba o suspende**.

El resultado debe incluir:
- Nombre del alumno.  
- Notas introducidas para cada asignatura.  
- Media numérica calculada.  
- Mensaje final con la calificación global.

---

## ⚙️ Requisitos técnicos

1. **Clase principal:**  
   - El programa debe contener una clase llamada `ControlNotas` con el método `main`.  

2. **Clases auxiliares:**  
   - Debe existir una clase adicional (`Alumno`) que contenga los atributos, constructor y métodos de cálculo.  

3. **Entrada de datos:**  
   - Se debe usar exclusivamente la clase `MyScanner`.  
   - No se permite el uso de `java.util.Scanner` ni bibliotecas externas.  

4. **Validaciones:**  
   - Las notas deben estar entre **0 y 10**.  
   - No se deben aceptar valores negativos o superiores a 10.  

5. **Estructuras de control:**  
   - Deben emplearse correctamente `if`, `else if`, `else` y bucles (`for` o `while`) si son necesarios.  

6. **Formato y limpieza del código:**  
   - Código indentado, con comentarios claros y encabezado identificativo (nombre, curso, fecha, asignatura).  
   - Atributos privados, métodos públicos.  

---

## 📋 Requisitos funcionales

El programa debe ser capaz de:

1. Pedir el **nombre del alumno** y las **tres notas** (por ejemplo, Programación, Bases de Datos y Entornos).  
2. Validar que cada nota esté entre 0 y 10.  
3. Calcular la **media aritmética** de las tres calificaciones.  
4. Mostrar un resumen final con:
   - Nombre del alumno.  
   - Cada nota individual.  
   - Media obtenida.  
   - Mensaje:  
     - `"Aprobado"` si la media es **≥ 5.0**  
     - `"Suspenso"` si la media es **< 5.0**

---

## 🧩 Estructura esperada

Tu proyecto debe incluir **al menos dos clases**:

| Clase | Descripción |
|--------|--------------|
| `ControlNotas` | Clase principal con el método `main`, responsable de la interacción con el usuario. |
| `Alumno` | Clase auxiliar que contiene los atributos, constructor, y los métodos de cálculo y visualización. |

---

## ⚖️ Rúbrica de evaluación (10 puntos)

| Criterio | Descripción | Puntos |
|-----------|-------------|--------|
| **1️⃣ Clases y atributos** | Definición correcta de la clase `Alumno` con atributos privados y constructor adecuado | **3 pts** |
| **2️⃣ Métodos de cálculo y encapsulación** | Métodos funcionales para calcular la media y mostrar el resultado | **3 pts** |
| **3️⃣ Interacción con el usuario** | Solicita datos correctamente, valida entradas y muestra salida clara | **2 pts** |
| **4️⃣ Código limpio y comentado** | Código bien indentado, con comentarios descriptivos | **1 pt** |
| **5️⃣ Ejecución sin errores** | El programa compila y ejecuta correctamente | **1 pt** |

---

## 📗 Objetivos pedagógicos
- Consolidar los conocimientos de **Programación Orientada a Objetos (POO)**.  
- Reforzar la validación de datos numéricos con estructuras de control.  
- Aplicar **métodos y encapsulación** en un contexto práctico y diferente al Proyecto 2.  
- Fomentar la claridad y la legibilidad del código.

---

**Entrega:**  
- Archivos `.java` funcionales (`ControlNotas.java` y `Alumno.java`).  
- Encabezado obligatorio con nombre, fecha, curso y asignatura.  
- Entregar mediante el aula virtual o la plataforma designada.
