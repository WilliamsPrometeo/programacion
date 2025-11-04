# 📚 Explicación de los `ArrayList` en Java

## 🧩 ¿Qué es un `ArrayList`?

Un **`ArrayList`** es una ejemplos_clase en Java que permite **almacenar una lista de elementos de forma dinámica**, es decir, su tamaño **puede crecer o disminuir** durante la ejecución del programa.

A diferencia de los **arrays tradicionales**, los `ArrayList` **no tienen un tamaño fijo**. Puedes agregar, eliminar o modificar elementos fácilmente.

Para usar `ArrayList`, debes importar la ejemplos_clase desde el paquete `java.util`:

```java
import java.util.ArrayList;
```

---

## 🧠 Características principales

- Permite **almacenar varios elementos** del mismo tipo.
- El tamaño **se ajusta automáticamente** al agregar o eliminar elementos.
- Se puede acceder a los elementos por su **índice** (posición).
- No permite tipos primitivos directamente (`int`, `double`, etc.); se usan sus **ejemplos_clase.clases envolventes** (`Integer`, `Double`, ...).

---

## 💡 Ejemplo básico

```java
import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {
        // Crear un ArrayList de nombres
        ArrayList<String> nombres = new ArrayList<>();

        // Agregar elementos
        nombres.add("Lucía");
        nombres.add("Carlos");
        nombres.add("Ana");

        // Mostrar la lista completa
        System.out.println("Lista de nombres: " + nombres);

        // Acceder a un elemento
        System.out.println("Primer nombre: " + nombres.get(0));

        // Modificar un elemento
        nombres.set(1, "Marcos");

        // Eliminar un elemento
        nombres.remove("Ana");

        // Mostrar tamaño y contenido final
        System.out.println("Tamaño: " + nombres.size());
        System.out.println("Lista final: " + nombres);
    }
}
```

### 🖨️ Salida:
```
Lista de nombres: [Lucía, Carlos, Ana]
Primer nombre: Lucía
Tamaño: 2
Lista final: [Lucía, Marcos]
```

---

## 🔁 Recorrer un ArrayList con bucles

### 🔸 Usando un **for tradicional**
```java
for (int i = 0; i < nombres.size(); i++) {
    System.out.println(nombres.get(i));
}
```

### 🔸 Usando un **for-each**
```java
for (String nombre : nombres) {
    System.out.println(nombre);
}
```

---

## 🧰 Métodos más usados

| Método | Descripción |
|---------|--------------|
| `add(elemento)` | Agrega un elemento al final. |
| `add(posición, elemento)` | Inserta un elemento en una posición específica. |
| `get(posición)` | Devuelve el elemento en esa posición. |
| `set(posición, elemento)` | Reemplaza el elemento en esa posición. |
| `remove(posición o elemento)` | Elimina un elemento. |
| `clear()` | Vacía la lista. |
| `size()` | Devuelve el número de elementos. |
| `isEmpty()` | Comprueba si está vacía. |
| `contains(elemento)` | Verifica si un elemento existe. |

---

## 🧩 Ejemplo práctico: notas de alumnos

```java
import java.util.ArrayList;
import java.util.Scanner;

public class NotasArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> notas = new ArrayList<>();
        
        System.out.println("Introduce las notas (introduce -1 para terminar):");
        double nota;
        
        do {
            nota = sc.nextDouble();
            if (nota != -1) {
                notas.add(nota);
            }
        } while (nota != -1);
        
        // Mostrar todas las notas
        System.out.println("Notas introducidas: " + notas);
        
        // Calcular la media
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        
        double media = suma / notas.size();
        System.out.printf("Media de notas: %.2f%n", media);
        
        sc.close();
    }
}
```

### 🖨️ Ejemplo de salida:
```
Introduce las notas (introduce -1 para terminar):
7.5
8.2
6.0
-1
Notas introducidas: [7.5, 8.2, 6.0]
Media de notas: 7.23
```

---

## 🎯 Conclusión

Los `ArrayList` son una herramienta **fundamental en Java** para manejar listas dinámicas.  
Permiten **agregar, eliminar y recorrer elementos fácilmente**, haciéndolos muy útiles para programas donde el número de datos no se conoce de antemano.
