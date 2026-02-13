# 🧭 Introducción al Debug en Java

## 📘 ¿Qué es el Debug?
El **debug** (o depuración) es el proceso mediante el cual un programador ejecuta un programa paso a paso para:
- Analizar su comportamiento.
- Observar el valor de las variables en tiempo real.
- Verificar el flujo lógico del código.
- Identificar y corregir errores que no son detectados por el compilador.

El debug permite entender *cómo* se comporta el programa realmente, no solo cómo **creemos** que lo hace.

> 💡 Mientras que un error de compilación detiene el programa inmediatamente, un error lógico solamente se detecta ejecutando y analizando el flujo del código.  
> Ahí es donde el debug se vuelve fundamental.

---

## 🎯 ¿Cuándo usar el debug?

Debes usar el debug cuando:

### 🔹 1. El programa compila, pero no funciona como esperas  
Ejemplo:  
Una suma devuelve un número incorrecto.  
Un bucle recorre posiciones inesperadas.

### 🔹 2. Una variable cambia de valor sin motivo aparente  
Debug te permite ver paso a paso *cuándo* cambia una variable.

### 🔹 3. Un `if` o un bucle no se ejecuta  
Depurando puedes comprobar condiciones y valores reales.

### 🔹 4. Necesitas comprender código antiguo o de otra persona  
El debug muestra:
- Orden de ejecución  
- Valores reales  
- Métodos que se llaman  
- Flujo interno del programa  

### 🔹 5. El programa lanza excepciones inesperadas  
Puedes detenerlo justo antes de la excepción y ver en qué estado estaba todo.

---

## 🧰 Herramientas del Debugger (IntelliJ / Eclipse / VS Code)

Los entornos de desarrollo incluyen potentes herramientas interactivas:

### 🔴 **Breakpoint (Punto de interrupción)**
Permite detener la ejecución en una línea concreta para examinar el estado del programa.

### 👉 **Step Over (F8)**
Ejecuta la siguiente línea pero *sin entrar* dentro de los métodos llamados.  
Perfecto cuando solo quieres ver el flujo general.

### 🔽 **Step Into (F7)**
Entra dentro de los métodos llamados.  
Útil cuando quieres analizar un método en detalle.

### 🔼 **Step Out (Shift + F8)**
Sale del método actual y vuelve al llamador.  
Ideal si entraste por error o ya entendiste lo que sucede dentro.

### ▶️ **Resume (F9)**
Continúa ejecución hasta el siguiente breakpoint.  
Útil para saltarse partes que ya conoces.

### 🧪 **Variables / Watches**
Ventanas que te muestran:
- El valor actual de todas las variables locales.
- Estructuras internas como ArrayList, objetos, etc.
- Variables que deseas vigilar expresamente.

### 🧱 **Call Stack (Pila de llamadas)**
Muestra la cadena de métodos que llevaron hasta la línea actual.  
Es esencial para entender errores profundos o recursión.

---

## ✨ ¿Por qué enseñar debug?

Porque es una habilidad fundamental en programación profesional.  
Trabajar con debug enseña:

- Pensamiento analítico  
- Comprensión del flujo del programa  
- Detección de errores complejos  
- Razonamiento lógico  

Un buen programador **no solo escribe código**, sino que sabe **inspeccionarlo y entenderlo**.
