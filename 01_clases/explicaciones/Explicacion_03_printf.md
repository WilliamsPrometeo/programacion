# 🖨️ Uso de `printf` en Java

El método `System.out.printf()` se usa para **mostrar texto formateado por pantalla**, permitiendo controlar **cómo se muestran los valores** (números, cadenas, decimales, etc.).

> 🔹 `printf` significa **print formatted** (“imprimir con formato”).

A diferencia de `System.out.println()`, que simplemente imprime texto y salta de línea, `printf()` permite **incluir variables dentro del texto** usando **marcadores de formato**.

---

## 🧩 Sintaxis general

```java
System.out.printf("texto con formato", valores);
```

Los **marcadores de formato** (placeholders) se sustituyen por los valores proporcionados.

---

## 📋 Marcadores más comunes

| Marcador | Tipo de dato | Ejemplo | Resultado |
|-----------|--------------|----------|------------|
| `%d` | Entero (`int`) | `System.out.printf("Edad: %d", 25);` | Edad: 25 |
| `%f` | Decimal (`float` o `double`) | `System.out.printf("Nota: %.2f", 8.5678);` | Nota: 8.57 |
| `%s` | Cadena (`String`) | `System.out.printf("Hola %s", "Carlos");` | Hola Carlos |
| `%c` | Carácter (`char`) | `System.out.printf("Letra: %c", 'A');` | Letra: A |
| `%%` | Símbolo de porcentaje | `System.out.printf("Progreso: 100%%");` | Progreso: 100% |

---

## 💡 Ejemplo completo

```java
public class EjemploPrintf {
    public static void main(String[] args) {
        String nombre = "Lucía";
        int edad = 22;
        double nota = 8.6789;

        System.out.printf("👋 Hola %s, tienes %d años y tu nota media es %.2f%n",
                          nombre, edad, nota);
    }
}
```

**Salida:**

```
👋 Hola Lucía, tienes 22 años y tu nota media es 8.68
```

🧠 **Explicación:**
- `%s` → se reemplaza por el nombre.  
- `%d` → se reemplaza por la edad.  
- `%.2f` → muestra el número decimal con **2 cifras después del punto**.  
- `%n` → salto de línea (equivalente a `\n`, pero más compatible entre sistemas).

---

## ⚙️ Otros ejemplos útiles

```java
System.out.printf("Precio del producto: %.2f €%n", 12.5);  
System.out.printf("Número con espacios: %5d%n", 42);  // Alineado a la derecha
System.out.printf("Texto alineado: %-10s Fin%n", "Hola");  // Alineado a la izquierda
```

**Salida:**

```
Precio del producto: 12.50 €
Número con espacios:    42
Texto alineado: Hola       Fin
```

---

## 🧩 Ventajas de usar `printf()`

✅ Mayor control sobre el formato de salida.  
✅ Perfecto para mostrar datos en columnas o con decimales fijos.  
✅ Hace el código más legible en programas que imprimen tablas o reportes.


---

# 🧠 Explicación detallada de ejemplos de formato

```java
System.out.printf("Precio del producto: %.2f €%n", 12.5);  
System.out.printf("Número con espacios: %5d%n", 42);  
System.out.printf("Texto alineado: %-10s Fin%n", "Hola");
```

### 🔹 1️⃣ `System.out.printf("Precio del producto: %.2f €%n", 12.5);`

- **`%.2f`** → Muestra un número decimal (`float` o `double`) con **2 cifras decimales**.  
- El valor `12.5` se mostrará como `12.50`.  
- **`%n`** → Salto de línea (más compatible que `\n`).  

**Salida:**
```
Precio del producto: 12.50 €
```

---

### 🔹 2️⃣ `System.out.printf("Número con espacios: %5d%n", 42);`

- **`%d`** → Muestra un número entero.  
- **`%5d`** → Reserva **5 espacios** para el número.  
  - Si el número tiene menos cifras, se rellenan **espacios a la izquierda** (alineado a la derecha).  

**Salida (espacios marcados con · para visualizar):**
```
Número con espacios: ····42
```

💡 Ideal para alinear columnas de números.

---

### 🔹 3️⃣ `System.out.printf("Texto alineado: %-10s Fin%n", "Hola");`

- **`%s`** → Muestra una cadena de texto (`String`).  
- **`%-10s`** → Reserva **10 espacios** y alinea el texto **a la izquierda**.  
  - El `-` indica que los espacios sobrantes irán **a la derecha**.  

**Salida (espacios marcados con · para visualizar):**
```
Texto alineado: Hola········Fin
```

💡 Muy útil para imprimir textos o tablas con formato legible.

---

## 📘 Resumen visual

| Código | Significado | Ejemplo de salida |
|---------|--------------|------------------|
| `%.2f` | Decimal con 2 cifras | `12.50` |
| `%5d` | Entero con ancho de 5 (alineado derecha) | `···42` |
| `%-10s` | Texto con ancho de 10 (alineado izquierda) | `Hola······` |
| `%n` | Salto de línea | — |

---
