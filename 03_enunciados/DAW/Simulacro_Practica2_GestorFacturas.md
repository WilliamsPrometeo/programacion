# 🧩 Simulacro Práctica 2 – Gestor de Facturas

## 📘 Nivel
1º DAW — Asignatura: *Ampliación de Programación (Java)*  
Duración estimada: 1 hora  
Trabajo individual

---

## 🎯 Objetivo
Aplicar **clases**, **atributos**, **constructores** y **métodos** en un programa modular de Java.  
Practicar **entrada de datos con `MyScanner`**, encapsulación básica y operaciones aritméticas.

---

## ⚙️ Descripción del ejercicio
Crea una pequeña aplicación que permita calcular el **importe total de una factura** teniendo en cuenta el precio base, el IVA y un posible descuento aplicado al cliente.

El programa debe:

1. Pedir al usuario los siguientes datos:  
   - Nombre del cliente  
   - Importe base de la factura  
   - Porcentaje de IVA  
   - Porcentaje de descuento  

2. Calcular el total a pagar aplicando:  
   ```
   total = precioBase + (precioBase * IVA/100) - (precioBase * descuento/100)
   ```

3. Mostrar un resumen formateado con todos los datos del cliente y el resultado final.  

---

## 🧠 Estructura esperada

Tu proyecto debe tener **dos clases**:

| Clase | Descripción |
|--------|--------------|
| `Factura` | Contendrá los atributos, constructor, y el método de cálculo. |
| `Main` | Clase principal para la interacción con el usuario. |

---

### 🧩 Clase `Factura.java`

```java
public class Factura {
    // Atributos
    private String cliente;
    private double importeBase;
    private double iva;
    private double descuento;

    // Constructor
    public Factura(String cliente, double importeBase, double iva, double descuento) {
        this.cliente = cliente;
        this.importeBase = importeBase;
        this.iva = iva;
        this.descuento = descuento;
    }

    // Método para calcular el total
    public double calcularTotal() {
        double totalIVA = importeBase * (iva / 100);
        double totalDescuento = importeBase * (descuento / 100);
        return importeBase + totalIVA - totalDescuento;
    }

    // Método para mostrar la información de la factura
    public void mostrarResumen() {
        System.out.println("----- RESUMEN DE FACTURA -----");
        System.out.println("Cliente: " + cliente);
        System.out.println("Importe base: " + importeBase + " €");
        System.out.println("IVA aplicado: " + iva + " %");
        System.out.println("Descuento aplicado: " + descuento + " %");
        System.out.printf("Total a pagar: %.2f €%n", calcularTotal());
    }
}
```

---

### 💻 Clase `Main.java`

```java
public class Main {
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        System.out.println("=== GESTOR DE FACTURAS ===");

        String cliente = sc.pedirTexto("Introduce el nombre del cliente: ");
        double base = sc.pedirDecimal("Introduce el importe base (€): ");
        double iva = sc.pedirDecimal("Introduce el porcentaje de IVA: ");
        double descuento = sc.pedirDecimal("Introduce el porcentaje de descuento: ");

        // Crear objeto Factura
        Factura factura = new Factura(cliente, base, iva, descuento);

        // Mostrar resumen
        factura.mostrarResumen();

        sc.cerrar();
    }
}
```

---

## 📋 Rúbrica de evaluación (10 puntos)

| Criterio | Descripción | Puntos |
|-----------|-------------|--------|
| Definición correcta de clase y constructor | Se define la clase `Factura` con atributos y constructor completo | 3 |
| Método de cálculo funcional | `calcularTotal()` devuelve el valor correcto | 3 |
| Interacción con el usuario | Pide datos y muestra salida clara y ordenada | 3 |
| Código legible y comentado | Código limpio, identado y comprensible | 1 |

---

## 📗 Objetivo pedagógico
- Reforzar la programación orientada a objetos en Java.  
- Aplicar correctamente el uso de constructores, atributos y métodos.  
- Fomentar la legibilidad del código y la validación de entrada.
