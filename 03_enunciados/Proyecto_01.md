
# 🎮 Proyecto: Gestor de Tienda de Videojuegos

## 🧩 Descripción del proyecto
En este proyecto desarrollarás una aplicación de consola en **Java** que permita gestionar el **catálogo de videojuegos** de una tienda.

El sistema permitirá:
- Agregar nuevos videojuegos al catálogo.  
- Listar todos los videojuegos registrados.  
- Buscar un videojuego por su **ID**.  
- Eliminar un videojuego del catálogo por **ID**.  

El objetivo principal es **integrar todo lo aprendido** hasta ahora: clases, objetos, métodos, excepciones, colecciones y estructuras de control.

---

## 🎯 Objetivos de aprendizaje

Durante la realización del proyecto, el alumnado deberá demostrar su capacidad para:

- Declarar e inicializar variables (tanto locales como estáticas).  
- Crear clases con atributos, constructores y métodos bien estructurados.  
- Implementar **métodos parametrizados** (con y sin retorno).  
- Utilizar correctamente `System.out.println` y `System.out.printf`.  
- Aplicar **condicionales** (`if`, `switch`) y **bucles** (`while`, `for`).  
- Manejar **excepciones**, incluyendo la creación de una **excepción personalizada**.  
- Trabajar con **ArrayList** para almacenar y manipular datos.  

---

## 🧩 Estructura básica de las clases

### 🏪 Clase `Tienda.java`
```java
import java.util.ArrayList;

public class Tienda {
    /*
        Atributos:
            catalogo - Lista de Videojuegos
    */

    // Constructor vacío donde inicializamos el catálogo

    // Getters y Setters
   
    // Métodos

    /*
         agregar
            - Añade un videojuego al catálogo
         @params Videojuego
     */

    /*
         listar
            - Muestra todos los videojuegos
     */

    /*
        buscarPorId
            - Busca un videojuego por su ID
         @params id
         @return Videojuego
     */
    
    /*
         eliminarPorId
            - Elimina un videojuego por su ID
         @params id
         @return boolean
     */

}
```

---

### 🎮 Clase `Videojuego.java`
```java
public class Videojuego {
    /*
         Atributos:
            id - Único auto-incremental - Número entero
            titulo - Texto
            precio - Decimal
    */
    // Constructor/es (Mínimo 2)

    // Getters y Setters

    // Métodos
    /*
       toString
           - Texto formateado
    */
}
```

---

## 🧠 Instrucciones para el alumnado

1. **Crea un nuevo proyecto Java** en IntelliJ o VS Code.  
2. Implementa las clases necesarias (Tienda y Videojuego).  
3. Crea un `Main.java` con un menú que permita:
   - Agregar videojuegos (pidiendo datos al usuario).
   - Listar todos los videojuegos.
   - Eliminar un videojuego por **ID**.
   - Salir del programa.
4. Controla posibles errores:
   - Al intentar crear un videojuego con un precio negativo (usa tu excepción personalizada).
5. Usa correctamente `println` y `printf` para mostrar los datos formateados.  
6. Al finalizar, **sube tu código al repositorio de GitHub**.

---

## ⚙️ Requisitos mínimos

- Uso de **ArrayList** para almacenar los videojuegos.  
- Métodos bien definidos (con parámetros y retorno cuando sea necesario).  
- Uso de **variables estáticas** (para el ID autoincremental).  
- Control de **Excepciones**.  
- Creación de **una excepción personalizada**.  
- Correcta **encapsulación** y legibilidad del código.  
- Uso del formato `printf` o `String.format` para mostrar datos de forma alineada.

---

## 🧾 Criterios de evaluación (Rúbrica)

| Criterio | Descripción | Puntuación |
|-----------|--------------|------------|
| **Estructura y organización del código** | El código está ordenado, con nombres claros y comentarios relevantes. | 2 pts |
| **Uso de clases y objetos** | Implementa correctamente las clases `Videojuego` y `Tienda`. | 2 pts |
| **Métodos parametrizados y retornos** | Crea métodos bien definidos, reutilizables y funcionales. | 1 pt |
| **Uso de condicionales y bucles** | Utiliza estructuras de control adecuadas para los menús y validaciones. | 1 pt |
| **Control de excepciones** | Maneja excepciones correctamente e incluye una personalizada. | 2 pts |
| **Colecciones (ArrayList)** | Usa `ArrayList` de forma eficiente para almacenar y recorrer objetos. | 1 pt |
| **Formato de salida y experiencia de usuario** | Usa `printf` o `String.format` para mostrar datos de forma clara. | 1 pt |

**Total: 10 puntos**

---

## 💡 Sugerencias
- Puedes añadir mejoras opcionales, como ordenar la lista por precio o género.  
- Se valorará la **creatividad** en la presentación de los datos.  
- Usa los comentarios del código para explicar tus decisiones de diseño.  

---

## 🏁 Entrega
- Fecha límite: *(05/11/2025 11:30)*
- Entregar a través de: *(GitHub)*  
- Nombre del proyecto:
  ```
  Apellido_Nombre_ProyectoTienda.java
  ```

---

> ✨ *Recuerda:* no se evalúa solo que el programa funcione, sino **cómo está construido y estructurado**.
