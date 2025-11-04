# 🧩 Práctica 1 – Control de acceso por edad

**Asignatura:** Ampliación de Programación  
**Nivel:** 1º DAW  
**Lenguaje:** Java  
**Duración estimada:** 1 hora  
**Tipo:** Práctica individual  
**Fecha:** 31/10/2025

---

## 🎯 Objetivo
Practicar el uso de:
- Estructuras condicionales (`if`, `else if`, `else`)
- Bucles (`while`)
- Lectura de datos
- Validación de entradas numéricas

---

## 📘 Enunciado

Desarrolla un programa en Java que pida al usuario su edad y determine si puede acceder al sistema.

El programa debe cumplir las siguientes condiciones:

1. Si la edad es **menor de 0 o mayor de 120**, se debe mostrar un mensaje de error.  
2. Si la edad es **menor de 18**, mostrar:  
   > "Acceso denegado: menor de edad."
3. Si la edad está entre **18 y 65 años**, mostrar:  
   > "Acceso permitido."
4. Si la edad es **mayor de 65**, mostrar:  
   > "Acceso con beneficios para jubilados."
5. El usuario tiene **3 intentos** para introducir una edad válida antes de que el programa finalice.

---

## ⚙️ Requisitos técnicos

- El programa debe contener una programacion_clase principal llamada `ControlAcceso` con un método `main`.
- Se debe usar la programacion_clase `recursos.MyScanner` para la entrada de datos.
- Utiliza **estructuras de control** y **bucles** correctamente indentados.
- No se deben usar bibliotecas externas.

**Nombre del archivo:** `ControlAcceso_[nombre_alumno].java`

---

## 💡 Pistas

- Usa un contador de intentos (`int intentos = 0;`).
- Controla el rango de edad antes de aplicar los mensajes.
- Puedes usar `while (intentos < 3 && !valido)` para limitar intentos.
- Cierra el `recursos.MyScanner` al final con `sc.cerrar();`.

---

## 🧩 Ejemplo de ejecución

```
Introduce tu edad: -5
Error: Edad no válida. Intento 1 de 3.

Introduce tu edad: 17
Acceso denegado: menor de edad.

Introduce tu edad: 45
Acceso permitido.
```

---

## 🧮 Evaluación (10 puntos)

| Criterio | Puntos |
|-----------|--------|
| Validación y control de errores | 3 |
| Uso correcto de estructuras condicionales y bucles | 4 |
| Código limpio y comentado | 2 |
| Ejecución sin errores | 1 |

---

## 🧠 Reflexión final (opcional)

1. ¿Por qué es útil limitar el número de intentos?  
2. ¿Qué ventajas tiene validar los datos antes de procesarlos?  
3. ¿Qué sucedería si no se controlara el rango de edad?
