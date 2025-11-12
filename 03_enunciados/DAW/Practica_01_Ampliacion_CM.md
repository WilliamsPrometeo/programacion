# 🧮 Proyecto 01 - CM – Calculadora de Horas Laborales

## 📘 Descripción general
En este proyecto el alumno deberá desarrollar un programa en Java que calcule el **sueldo semanal de un trabajador** según las horas trabajadas y su tarifa por hora, aplicando reglas de validación y condiciones especiales.

El objetivo es reforzar el uso de **condicionales, bucles y validación de datos**, sin emplear clases ni objetos adicionales (solo el `main` y métodos estáticos).

---

## 🧩 Requisitos funcionales

1. El programa debe tener una **clase principal llamada `CalculadoraHoras`** con un **método `main`**.
2. Se debe usar la **clase `MyScanner`** para leer datos del usuario.
3. El programa debe pedir los siguientes datos:
    - Nombre del empleado.
    - Horas trabajadas durante la semana (de **0 a 70**).
    - 
4. Establecer la tarifa por hora (de **7.5 euros/hora**).
5. Si los valores introducidos están fuera del rango válido, debe volver a pedirse el dato.
    - Máximo **3 intentos** antes de mostrar un mensaje de error y finalizar el programa.

6. Al final, debe mostrarse un resumen con:
    - Nombre del empleado.
    - Horas trabajadas.
    - Tarifa.
    - Salario total.

---

## ⚙️ Requisitos técnicos

- El código debe estar correctamente **indentado** y **comentado**.
- Se deben usar **métodos estáticos** para dividir la lógica:
    - `pedirHoras()`, `calcularSalario()`, `mostrarResumen()`.
- Se debe validar la entrada numérica y controlar los intentos.
- No se permite el uso de bibliotecas externas.
- El programa debe funcionar correctamente sin errores de ejecución.

---

## 🧮 Ejemplo de salida esperada

```
=== CALCULADORA DE HORAS LABORALES ===
Introduce el nombre del empleado: Marta
Introduce las horas trabajadas esta semana: 46

===== RESUMEN SEMANAL =====
Empleado: Marta
Horas trabajadas: 46
Tarifa por hora: 7.5 €
Salario total: 735.0 €
```

---

## 🧾 Criterios de evaluación (Rúbrica / 10 pts)

| Criterio | Descripción | Puntos |
|-----------|-------------|--------|
| **1️⃣ Estructuras de control** | Uso correcto de condicionales y bucles para validar los datos. | **3 pts** |
| **2️⃣ Métodos y modularidad** | Código dividido en métodos estáticos con responsabilidades claras. | **3 pts** |
| **3️⃣ Validación y manejo de errores** | Control de rangos y de número máximo de intentos. | **2 pts** |
| **4️⃣ Claridad y comentarios** | Código legible, indentado y con comentarios explicativos. | **1 pt** |
| **5️⃣ Ejecución sin errores** | Compila y muestra resultados correctos. | **1 pt** |

---

## 💬 Recomendaciones

- Usa constantes (`HORAS_MAX = 70`, `TARIFA_MIN = 7.5`, etc.).
- Aplica condiciones claras para los tramos de horas.
- Incluye al menos un comentario en cada método explicando su función.
- Termina el programa de forma elegante si se superan los intentos permitidos.  
