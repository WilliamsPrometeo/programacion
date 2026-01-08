# Try-with-resources en Java

## ¿Qué es try-with-resources?

El **try-with-resources** es una estructura introducida en **Java 7** que permite **gestionar automáticamente recursos** como archivos, flujos de datos o conexiones, asegurando que se cierren correctamente al finalizar su uso.

Un *recurso* es cualquier objeto que implementa la interfaz `AutoCloseable`.

Ejemplos comunes de recursos:
- `Scanner`
- `FileReader`
- `BufferedReader`
- `FileWriter`
- `BufferedWriter`
- `InputStream`
- `OutputStream`

---

## Problema del try-catch tradicional

Antes de `try-with-resources`, los recursos debían cerrarse manualmente usando `finally`.

### Ejemplo tradicional

```java
FileReader fr = null;

try {
    fr = new FileReader("datos.txt");
    // Leer archivo
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (fr != null) {
            fr.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

### Problemas de este enfoque
- Código largo y repetitivo
- Fácil olvidar cerrar el recurso
- Mayor posibilidad de errores

---

## Solución: try-with-resources

Con `try-with-resources`, Java se encarga automáticamente de cerrar los recursos cuando termina el bloque `try`.

### Sintaxis básica

```java
try (Recurso recurso = new Recurso()) {
    // Usar el recurso
} catch (Exception e) {
    // Manejo de excepciones
}
```

👉 El recurso se cierra automáticamente al salir del `try`, incluso si ocurre una excepción.

---

## Ejemplo con FileReader

```java
try (FileReader fr = new FileReader("datos.txt")) {
    int caracter;
    while ((caracter = fr.read()) != -1) {
        System.out.print((char) caracter);
    }
} catch (IOException e) {
    System.out.println("Error al leer el archivo");
}
```

✔ No es necesario cerrar el `FileReader`  
✔ Código más limpio y seguro

---

## Ejemplo con BufferedReader

```java
try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## Varios recursos en un mismo try

Se pueden declarar **varios recursos**, separados por punto y coma (`;`).

```java
try (
    FileReader fr = new FileReader("datos.txt");
    BufferedReader br = new BufferedReader(fr)
) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

Los recursos se cierran **en orden inverso** al que fueron declarados.

---

## ¿Qué es AutoCloseable?

Para que un objeto pueda usarse en `try-with-resources`, debe implementar la interfaz:

```java
AutoCloseable
```

Esto obliga a implementar el método:

```java
void close() throws Exception;
```

Muchas clases estándar de Java ya lo implementan.

---

## Ejemplo con Scanner

```java
try (Scanner sc = new Scanner(System.in)) {
    System.out.println("Introduce un número:");
    int n = sc.nextInt();
    System.out.println("Número: " + n);
}
```

⚠ Aunque `Scanner(System.in)` se cierra automáticamente, **no suele recomendarse cerrarlo** si se va a seguir usando la entrada estándar en el programa.

---

## Ventajas del try-with-resources

✅ Cierre automático de recursos  
✅ Código más limpio y legible  
✅ Menos errores  
✅ Manejo correcto de excepciones  
✅ Buenas prácticas profesionales

---

## Cuándo usar try-with-resources

Usa **siempre try-with-resources** cuando trabajes con:
- Archivos
- Streams
- Lectura / escritura de datos
- Recursos externos

Es la forma **recomendada y moderna** en Java.

---

## Resumen

- Introducido en Java 7
- Cierra recursos automáticamente
- Sustituye al `finally` para cierre de recursos
- Requiere que el recurso implemente `AutoCloseable`
- Mejora la calidad del código

---

📌 **Conclusión:**  
Si usas recursos en Java, **usa siempre try-with-resources**.

