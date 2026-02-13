
# 🧩 Guía de Uso de Javadoc en Java

## 📘 ¿Qué es Javadoc?
**Javadoc** es una herramienta incluida en el JDK (Java Development Kit) que permite generar documentación automáticamente a partir del código fuente de Java.  
La documentación se genera en formato **HTML**, a partir de los comentarios especiales colocados en el código.

Estos comentarios ayudan a **describir el propósito de las clases, métodos, atributos y parámetros**, facilitando el trabajo en equipo y el mantenimiento del código.

---

## 📝 ¿Cómo se escriben los comentarios Javadoc?

Los comentarios Javadoc comienzan con `/**` y terminan con `*/`.

```java
/**
 * Esto es un comentario Javadoc.
 * Describe qué hace la clase, método o atributo.
 */
```

### ✳️ Ejemplo básico en una clase
```java
/**
 * La clase Calculadora realiza operaciones matemáticas básicas.
 * @author Nombre del Alumno
 * @version 1.0
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     * @param a primer número
     * @param b segundo número
     * @return la suma de a y b
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Divide dos números.
     * @param a dividendo
     * @param b divisor
     * @return resultado de la división
     * @throws ArithmeticException si b es cero
     */
    public double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }
}
```

---

## 🧾 Etiquetas más comunes en Javadoc

| Etiqueta | Descripción |
|-----------|--------------|
| `@author` | Indica el autor del código. |
| `@version` | Especifica la versión del archivo o clase. |
| `@param` | Describe los parámetros de un método. |
| `@return` | Explica lo que devuelve un método. |
| `@throws` o `@exception` | Indica qué excepción puede lanzar el método. |
| `@see` | Hace referencia a otra clase, método o documento. |
| `@deprecated` | Indica que un método o clase está obsoleto. |
| `@since` | Indica desde qué versión del programa existe el elemento. |

---

## ⚙️ Cómo generar la documentación HTML

1. Abre una terminal en la carpeta del proyecto que contiene tus archivos `.java`.
2. Ejecuta el comando:

```bash
  javadoc -d doc NombreArchivo.java
```

- `-d doc` → crea una carpeta llamada `doc` donde se guardará la documentación.  
- `NombreArchivo.java` → es el archivo fuente que contiene los comentarios Javadoc.

Ejemplo:
```bash
  javadoc -d doc Calculadora.java
```

Esto generará varios archivos HTML en la carpeta `doc`, incluyendo un `index.html` que puedes abrir en tu navegador.

---

## 🌐 Visualización
La documentación generada incluye:
- Un índice con las clases documentadas.
- Listado de métodos, atributos y constructores.
- Descripciones tomadas directamente de los comentarios Javadoc.

---

## 💡 Buenas prácticas
- Siempre documenta **todas las clases y métodos públicos**.
- Describe **qué hace** un método, no **cómo lo hace**.
- Usa un **lenguaje claro y conciso**.
- Incluye autor y versión en cada clase principal.
- Mantén la documentación actualizada cuando cambies el código.

---

> ✨ **Conclusión:** Javadoc es una herramienta profesional que no solo mejora la comprensión del código, sino que también demuestra buenas prácticas de desarrollo.
