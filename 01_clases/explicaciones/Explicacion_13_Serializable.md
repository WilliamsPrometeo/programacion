# 💾 `Serializable` en Java

## 1️⃣ ¿Qué es `Serializable`?

`Serializable` es una **interfaz marcadora** del paquete:

```java
import java.io.Serializable;
```

Se usa para indicar que una clase puede convertirse en una secuencia de bytes.

👉 Es decir, permite **guardar objetos en archivos** o enviarlos por red.

---

# 🧠 2️⃣ ¿Qué significa serializar?

Serializar = Convertir un objeto en bytes.

Deserializar = Reconstruir el objeto a partir de bytes.

Flujo conceptual:

Objeto → Bytes → Archivo (.dat) → Bytes → Objeto

---

# 🏗 3️⃣ Cómo hacer una clase serializable

```java
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String autor;
}
```

## 🔎 Puntos importantes

- Se implementa la interfaz `Serializable`
- No tiene métodos
- Se recomienda declarar `serialVersionUID`

---

# 🆔 4️⃣ ¿Qué es `serialVersionUID`?

Es un identificador de versión de la clase.

```java
private static final long serialVersionUID = 1L;
```

Sirve para:

- Verificar compatibilidad al deserializar
- Evitar errores si la clase cambia

Si no se declara, Java lo genera automáticamente (pero no es buena práctica).

---

# 📤 5️⃣ Serializar un objeto

Necesitamos:

- `FileOutputStream`
- `ObjectOutputStream`

```java
try (ObjectOutputStream oos =
        new ObjectOutputStream(
            new FileOutputStream("libros.dat"))) {

    Libro libro = new Libro("Clean Code", "Robert C. Martin");
    oos.writeObject(libro);
}
```

Flujo:

Objeto → ObjectOutputStream → FileOutputStream → Archivo

---

# 📥 6️⃣ Deserializar un objeto

Necesitamos:

- `FileInputStream`
- `ObjectInputStream`

```java
try (ObjectInputStream ois =
        new ObjectInputStream(
            new FileInputStream("libros.dat"))) {

    Libro libro = (Libro) ois.readObject();
}
```

Flujo:

Archivo → FileInputStream → ObjectInputStream → Objeto

⚠️ `readObject()` devuelve `Object`, por eso hay que hacer casting.

---

# 🧩 7️⃣ Serializar colecciones

También podemos guardar listas completas:

```java
List<Libro> libros = new ArrayList<>();

oos.writeObject(libros);
```

Siempre que:

- La colección sea serializable (ArrayList lo es)
- Los objetos dentro también lo sean

---

# 🚫 8️⃣ Palabra clave `transient`

Si no queremos que un atributo se serialice:

```java
private transient String password;
```

Se usa para:

- Datos sensibles
- Campos temporales
- Valores calculados

---

# 🏗 9️⃣ Uso en arquitectura MVC

En tus proyectos:

## 📌 En el Modelo

```java
public class Libro implements Serializable
```

El modelo debe ser serializable si se va a persistir en archivo binario.

---

# ⚠️ 1️⃣0️⃣ Buenas prácticas

✅ Declarar siempre `serialVersionUID`

✅ Usar `try-with-resources`

✅ Mantener la lógica de serialización fuera del modelo

❌ No usar serialización como sustituto de base de datos en proyectos grandes

---

# 🎯 1️⃣1️⃣ Resumen final

`Serializable`:

- Permite convertir objetos en bytes
- Es una interfaz sin métodos
- Se usa con `ObjectOutputStream` y `ObjectInputStream`
- Se utiliza para persistencia binaria

---

# 📌 Idea clave

> `Serializable` no guarda datos por sí solo.
>
> Solo indica que el objeto puede transformarse en bytes.
>
> Los flujos (`ObjectOutputStream`) son los que realmente escriben el archivo.


