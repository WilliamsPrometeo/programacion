# Comprobación dinámica de tipos en Java

## ¿Qué es la comprobación dinámica de tipos?

La **comprobación dinámica de tipos** (*dynamic type checking*) en Java es el mecanismo mediante el cual el **tipo real de un objeto se determina en tiempo de ejecución**, y no en tiempo de compilación.

Esto ocurre principalmente cuando:
- Trabajamos con **polimorfismo**
- Usamos **herencia**
- Referenciamos objetos mediante **tipos padre o interfaces**

---

## Tipos en tiempo de compilación vs tiempo de ejecución

En Java hay que distinguir claramente entre dos conceptos:

### 1. Tipo en tiempo de compilación
Es el tipo de la **referencia**, es decir, el declarado en el código.

```java
Animal a;
```

Aquí, el tipo en compilación es `Animal`.

---

### 2. Tipo en tiempo de ejecución
Es el tipo **real del objeto** al que apunta la referencia.

```java
a = new Perro();
```

En ejecución, el objeto es de tipo `Perro`.

👉 **La comprobación dinámica se basa siempre en el tipo real del objeto**, no en el tipo de la referencia.

---

## Polimorfismo y comprobación dinámica

La comprobación dinámica de tipos es clave para el **polimorfismo**.

### Ejemplo

```java
class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El perro ladra");
    }
}
```

```java
Animal a = new Perro();
a.hacerSonido();
```

### ¿Qué ocurre aquí?

- En compilación: Java solo sabe que `a` es un `Animal`
- En ejecución: Java detecta que el objeto es un `Perro`
- Resultado:

```text
El perro ladra
```

✔️ **El método ejecutado se decide dinámicamente**

---

## El operador `instanceof`

Java permite comprobar el tipo real de un objeto en tiempo de ejecución con `instanceof`.

### Sintaxis

```java
objeto instanceof Tipo
```

Devuelve:
- `true` si el objeto es de ese tipo o de una subclase
- `false` en caso contrario

### Ejemplo

```java
Animal a = new Perro();

if (a instanceof Perro) {
    System.out.println("Es un perro");
}
```

---

## Casting y comprobación dinámica

### Casting correcto

```java
Animal a = new Perro();
Perro p = (Perro) a; // Correcto
```

### Casting incorrecto (error en ejecución)

```java
Animal a = new Animal();
Perro p = (Perro) a; // ClassCastException
```

⚠️ Este error **no se detecta en compilación**, sino en **tiempo de ejecución**.

---

## Prevención de errores con `instanceof`

```java
if (a instanceof Perro) {
    Perro p = (Perro) a;
    p.hacerSonido();
}
```

---

## Comprobación dinámica vs comprobación estática

| Característica | Comprobación estática | Comprobación dinámica |
|---------------|----------------------|-----------------------|
| Cuándo ocurre | Compilación | Ejecución |
| Qué valida | Tipos de referencia | Tipo real del objeto |
| Ejemplo | Errores de sintaxis | `ClassCastException` |
| Relación con POO | Limitada | Fundamental |

---

## Ventajas de la comprobación dinámica

- Permite **polimorfismo real**
- Código más **flexible y reutilizable**
- Uso de **interfaces y clases abstractas**

---

## Inconvenientes

- Errores detectados tarde (en ejecución)
- Abusar de `instanceof` indica mal diseño
- Puede dificultar el mantenimiento

---

## Buenas prácticas

- Priorizar **polimorfismo** frente a `instanceof`
- Usar `instanceof` solo cuando sea necesario
- Diseñar bien la jerarquía de clases
- Evitar castings innecesarios

---

## Resumen final

- Java combina comprobación **estática y dinámica**
- El tipo real del objeto se decide en **tiempo de ejecución**
- Es esencial para el **polimorfismo**
- Los métodos sobrescritos se resuelven dinámicamente

> 📌 **Idea clave**: el método que se ejecuta depende del objeto real, no del tipo de la referencia.

