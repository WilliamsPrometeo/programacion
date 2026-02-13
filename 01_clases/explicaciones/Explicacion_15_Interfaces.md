# 🧩 Interfaces en Arquitectura: El Contrato de los Service

## 🎯 Objetivo
Entender qué es una **interfaz** y por qué la usamos como **contrato** que deben cumplir las clases `Service`, preparando el camino hacia una futura estructura API.

---

# 1️⃣ ¿Qué es una interfaz?

Una **interfaz** define un conjunto de métodos que una clase debe implementar.

No contiene lógica (en el enfoque clásico), solo:

- Qué métodos existen
- Qué parámetros reciben
- Qué devuelven

👉 Es un **contrato obligatorio**.

Si una clase implementa la interfaz, está obligada a cumplir ese contrato.

---

# 2️⃣ ¿Por qué usar interfaces en la capa Service?

En una arquitectura por capas:

```
Controller → Service → Repository → Persistencia
```

El **Service** contiene la lógica de negocio.

Pero en lugar de usar directamente una clase concreta como:

```java
LibroService service = new LibroService();
```

Trabajamos contra el contrato:

```java
LibroService service = new LibroServiceImpl();
```

Donde:

```java
public interface LibroService {
    void guardar(Libro libro);
    List<Libro> obtenerTodos();
    Libro buscarPorIsbn(String isbn);
    void eliminar(String isbn);
}
```

Y la implementación:

```java
public class LibroServiceImpl implements LibroService {
    
    @Override
    public void guardar(Libro libro) {
        // lógica de negocio
    }

    @Override
    public List<Libro> obtenerTodos() {
        // implementación
    }
}
```

---

# 3️⃣ ¿Qué significa que es un contrato?

Significa que cualquier clase que implemente la interfaz:

```java
implements LibroService
```

Está obligada a implementar **todos los métodos definidos**.

Si no lo hace → error de compilación.

💡 La interfaz define el "qué".
💡 La clase define el "cómo".

---

# 4️⃣ Ventajas arquitectónicas

## ✅ 1. Bajo acoplamiento
El Controller no depende de una clase concreta, sino del contrato.

## ✅ 2. Sustitución sencilla
Mañana puedes cambiar:

- `LibroServiceImplMemoria`
- `LibroServiceImplJSON`
- `LibroServiceImplBD`

Sin tocar el Controller.

## ✅ 3. Preparación para APIs reales
Cuando trabajes con Spring o una API REST real:

```java
@Service
public class LibroServiceImpl implements LibroService
```

El contrato seguirá siendo el mismo.

La API solo usará el Service a través de su interfaz.

---

# 5️⃣ Relación con el principio SOLID

Especialmente con:

## 🔹 D — Dependency Inversion Principle

> Los módulos de alto nivel no deben depender de módulos de bajo nivel.
> Ambos deben depender de abstracciones.

El Controller (alto nivel) depende de:

```
LibroService (abstracción)
```

No de:

```
LibroServiceImpl (concreto)
```

---

# 6️⃣ ¿Por qué hacerlo antes de crear una API real?

Porque cuando pasemos a:

- Spring Boot
- @RestController
- Inyección de dependencias

La estructura ya estará preparada.

No habrá que refactorizar todo.

Solo añadiremos:

- Anotaciones
- Configuración
- Dependencias Maven/Gradle

La arquitectura ya será profesional.

---

# 7️⃣ Esquema mental final

```
INTERFAZ  →  Define reglas (contrato)
CLASE     →  Implementa esas reglas
CONTROLLER→  Solo conoce la interfaz
```

---

# 🏁 Conclusión

Las interfaces no son "código extra".

Son la base de una arquitectura:

- Escalable
- Mantenible
- Preparada para APIs reales
- Alineada con buenas prácticas profesionales

Primero aprendemos a separar responsabilidades.
Después convertimos esa estructura en una API real.

Ese es el paso natural hacia una arquitectura profesional 🚀

