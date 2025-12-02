# 🔀 Explicación del `switch`, `case`, `break` y `default` en Java

El bloque **switch** en Java permite ejecutar diferentes partes del código según el valor de una variable.  
Es una alternativa clara y ordenada a múltiples estructuras `if-else`.

---

## ⭐ ¿Qué es un `switch`?

Un `switch` evalúa una expresión y ejecuta el bloque correspondiente según el **case** que coincida.

Estructura general:

```java
switch (variable) {
    case valor1:
        // código
        break;
    case valor2:
        // código
        break;
    default:
        // código si ninguno coincide
        break;
}
```

---

# 🧱 Componentes del switch

## 🔸 1. `case`
Representa un valor posible de la variable del `switch`.

Ejemplo:

```java
case 1:
    System.out.println("Opción 1 elegida");
    break;
```

El código dentro del `case` se ejecutará si la variable evaluada es igual a ese valor.

---

## 🔸 2. `break`
Detiene la ejecución del `switch`.  
Sin `break`, la ejecución continúa hacia el siguiente `case` (**fall-through**).

Ejemplo correcto:

```java
case 2:
    System.out.println("Opción 2");
    break; // detiene el switch
```

Ejemplo incorrecto sin break (y efecto no deseado):

```java
case 2:
    System.out.println("Opción 2");
    // sin break → continúa ejecutando case 3
case 3:
    System.out.println("Opción 3");
```

---

## 🔸 3. `default`
Se ejecuta solo si **ningún case coincide**.

```java
default:
    System.out.println("Opción no válida");
    break;
```

Es equivalente a un `else` en un if-else.

---

# 🧪 Ejemplo práctico

Supongamos que el usuario ingresa una opción del menú:

```java
int opcion = MyScanner.nextInt();

switch (opcion) {
    case 1:
        System.out.println("Registrar vehículo");
        break;

    case 2:
        System.out.println("Registrar servicio");
        break;

    case 3:
        System.out.println("Asignar servicio");
        break;

    case 4:
        System.out.println("Mostrar vehículos");
        break;

    case 5:
        System.out.println("Salir del sistema");
        break;

    default:
        System.out.println("Opción no válida, intenta nuevamente");
        break;
}
```

---

# 💡 ¿Cuándo usar un `switch`?

✔ Cuando tienes una variable que puede tomar un conjunto fijo de valores  
✔ Cuando gestionas **menús**, **estados**, **opciones**, **categorías**  
✔ Cuando quieres un código más limpio que múltiples `if-else`  

Evítalo cuando:  
✖ Tu condición depende de rangos complejos  
✖ necesitas validar condiciones booleanas múltiples

---

# 🧠 Consejos finales

- Coloca siempre el `break` a menos que *intencionalmente* quieras un "fall-through".  
- Pon `default` para manejar errores o entradas inesperadas.  
- El `switch` funciona con:  
  - `int`, `byte`, `short`  
  - `char`  
  - `String`  
  - `enum`  
- Para menús es la opción **más limpia y profesional**.

---

¡Y eso es todo! Ahora sabes cómo funciona un `switch` con `case`, `break` y `default` y cómo aplicarlo correctamente en tus proyectos.
