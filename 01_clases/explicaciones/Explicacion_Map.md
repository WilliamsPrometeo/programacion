# 🗺️ Explicación de `Map` en Java

El interfaz **Map** en Java permite almacenar pares **clave–valor**, donde cada clave es única.  
Es fundamental para relacionar objetos, como “vehículo → servicio realizado”.

---

# ⭐ ¿Qué es un `Map`?

Un `Map` es una colección que almacena elementos en pares:

```
clave → valor
```

Ejemplos reales:

- DNI → Cliente  
- Matrícula → Vehículo  
- Usuario → Libro prestado  
- Vehículo → Servicio asignado  

Cada clave **solo puede aparecer una vez**.

---

# 🧱 Implementaciones más comunes

Java ofrece varias implementaciones:

| Implementación  | Característica principal           |
|-----------------|------------------------------------|
| `HashMap`       | Muy rápido, no garantiza orden     |
| `LinkedHashMap` | Mantiene el **orden de inserción** |

---

# 🏗️ Declaración y creación de un Map

```java
Map<String, Vehiculo> mapa = new HashMap<>();
```

o usando una clase como clave:

```java
Map<Vehiculo, Servicio> trabajos = new LinkedHashMap<>();
```

---

# 🔑 Insertar elementos (put)

```java
trabajos.put(vehiculo, servicio);
```

Si la clave ya existía, el valor anterior es reemplazado.

---

# 🔍 Obtener un valor (get)

```java
Servicio s = trabajos.get(vehiculo);
```

Si la clave no existe, devuelve `null`.

---

# ✔️ Comprobar si existe una clave

```java
if (trabajos.containsKey(vehiculo)) {
    System.out.println("Este vehículo ya tiene un servicio asignado.");
}
```

---

# ❌ Eliminar un elemento

```java
trabajos.remove(vehiculo);
```

---

# 🔄 Recorrer un `Map`

Forma 1: con entrySet (la más completa)

```java
for (Map.Entry<Vehiculo, Servicio> e : trabajos.entrySet()) {
    Vehiculo v = e.getKey();
    Servicio s = e.getValue();
    System.out.printf("%s → %s%n", v, s);
}
```

Forma 2: claves y valores por separado

```java
for (Vehiculo v : trabajos.keySet()) {
    System.out.println("Vehículo: " + v);
}
for (Servicio s : trabajos.values()) {
    System.out.println("Servicio: " + s);
}
```

---

# 🧠 ¿Por qué usar un `Map`?

✔ Acceso rápido mediante claves  
✔ Perfecto para representar relaciones 1 a 1  
✔ Útil cuando necesitas buscar un valor mediante un identificador único  
✔ Ideal para proyectos educativos como biblioteca, gimnasio o taller mecánico

---

# 💡 Importante: equals() y hashCode()

Cuando usas **objetos como clave** (por ejemplo `Vehiculo` o `Usuario`), debes sobrescribir:

- `equals()`  
- `hashCode()`

Esto permite que el Map identifique correctamente las claves.

Ejemplo típico:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Producto producto = (Producto) o;

    return this.nombre != null ? this.nombre.equals(producto.nombre) : producto.nombre == null;
}

@Override
public int hashCode() {
    return nombre != null ? nombre.hashCode() : 0;
}
```
---

# 🎯 Conclusión

Un `Map` es una estructura poderosa para:

- Guardar asociaciones clave–valor  
- Acceder a información rápidamente  
- Relacionar objetos de forma ordenada  

Es ideal para proyectos de gestión y es una habilidad esencial en Java.

