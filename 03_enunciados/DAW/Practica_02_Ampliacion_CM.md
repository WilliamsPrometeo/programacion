# 📘 Proyecto 02 – Calculadora de Estadísticas Numéricas - CM

## 📝 Descripción general
En este proyecto deberás crear un programa en Java que lea **dos números introducidos por el usuario** y calcule
diferentes operaciones básicas. Este proyecto permite practicar:

- Métodos estáticos
- Estructuras de control
- Validación de datos
- Entrada por teclado usando MyScanner
- Uso de bucles
- Manejo de excepciones personalizadas

---

## 🎯 Requisitos funcionales

El programa debe:

1. Contener una **clase principal** llamada `CalculadoraBasica` con un **método `main`**.
2. Usar la clase **MyScanner** para recoger los datos introducidos por el usuario.
3. Pedir al usuario **dos números**, uno a uno.
4. Validar que cada número esté dentro del rango permitido:
    - **Solo valores entre 0 y 100 (inclusive)**
    - Si el valor no es válido, volver a pedirlo.
5. Implementar **al menos estos métodos estáticos**:
    - `pedirNumero(String mensaje)`
    - `sumar(double a, double b)`
    - `restar(double a, double b)`
    - `multiplicar(double a, double b)`
    - `dividir(double a, double b)`
6. Implementar una **excepción personalizada** (que herede de `Exception`) para controlar errores:
    - Si se intenta dividir entre 0, el método `dividir` debe **lanzar la excepción**.
    - El `main` debe capturarla y mostrar el mensaje:  
      `"No se puede dividir entre 0."`
7. Al finalizar, el programa debe mostrar un **resumen** con:
    - Los valores introducidos
    - El resultado de las operaciones
    - El aviso adecuado en caso de división inválida

---

## ⚙️ Requisitos técnicos

- Todo debe implementarse mediante **métodos estáticos**.
- El programa debe estar correctamente indentado y comentado.
- Se debe validar toda entrada del usuario.
- No se pueden usar arrays.
- No se pueden usar métodos de String.
- El programa debe manejar correctamente la excepción personalizada.

---

## 🧮 Ejemplo de ejecución esperada

```
=== CALCULADORA BÁSICA ===
Introduce el número 1: 10
Introduce el número 2: 4

===== RESUMEN =====
Número 1: 10
Número 2: 4
Suma: 14
Resta: 6
Multiplicación: 40
División: 2.5
```

---
## 🧮 Ejemplo de ejecución con errores

```
=== CALCULADORA BÁSICA ===
Introduce el número 1: 5
Introduce el número 2: -2
Error: Valor introducido erroneo. Rango del 0 al 100 válidos.
Introduce el número 2: 0

===== RESUMEN =====
Número 1: 5
Número 2: 0
Suma: 5
Resta: 5
Multiplicación: 0
División: No se puede dividir entre 0.
```

---

## 🧾 Rúbrica de evaluación (10 puntos)

| Criterio                                               | Puntos    |
|--------------------------------------------------------|-----------|
| Estructuras de control (bucles y condicionales)        | **3 pts** |
| Métodos estáticos bien organizados                     | **3 pts** |
| Validación y tratamiento de errores mediante excepción | **2 pts** |
| Claridad, comentarios e indentación                    | **1 pt**  |
| Funcionamiento sin errores                             | **1 pt**  |

---

## 💡 Recomendaciones

- Evita repetir código: crea métodos reutilizables.
- Comprueba siempre los límites antes de aceptar un número.
- Mantén el código ordenado para facilitar su lectura.
- Usa la excepción personalizada para gestionar situaciones no válidas.

---

🕒 **Duración estimada:** 1 hora  
🎯 **Objetivo pedagógico:** practicar modularidad, control de flujo, validación y manejo básico de excepciones sin necesidad de POO avanzada.
