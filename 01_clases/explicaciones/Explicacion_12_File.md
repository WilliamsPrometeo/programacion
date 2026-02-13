# 📁 Clase `File` en Java

## 1️⃣ ¿Qué es `File`?

La clase `File` pertenece al paquete:

```java
import java.io.File;
```

Representa **una ruta del sistema de archivos** (archivo o carpeta), pero ⚠️ **no gestiona directamente el contenido del archivo**.

Es decir:

- ✅ Permite crear, borrar y consultar archivos/directorios.
- ❌ No sirve para leer o escribir datos (eso lo hacen los flujos como `FileReader`, `FileWriter`, `BufferedReader`, etc.).

---

# 🧠 2️⃣ Concepto clave

`File` representa:

- Una ruta lógica
- Un archivo físico
- Un directorio

Pero **no representa el flujo de datos**.

Para trabajar con datos necesitamos combinarlo con:

- Flujos de entrada (Input)
- Flujos de salida (Output)

---

# 🏗 3️⃣ Crear un objeto File

```java
File archivo = new File("datos.txt");
File carpeta = new File("./documentos");
```

También se puede usar ruta absoluta:

```java
File archivo = new File("C:/Users/Williams/Desktop/datos.txt");
```

---

# 🔎 4️⃣ Métodos principales de `File`

## 📌 Información del archivo

```java
archivo.exists();        // ¿Existe?
archivo.isFile();        // ¿Es archivo?
archivo.isDirectory();   // ¿Es carpeta?
archivo.getName();       // Nombre
archivo.getPath();       // Ruta
archivo.getAbsolutePath();
archivo.length();        // Tamaño en bytes
```

---

## 📌 Crear y borrar

```java
archivo.createNewFile(); // Crea archivo
archivo.delete();        // Borra archivo
carpeta.mkdir();         // Crea carpeta
carpeta.mkdirs();        // Crea carpetas anidadas
```

⚠ `createNewFile()` lanza excepción → necesita try/catch.

---

## 📌 Listar contenido de una carpeta

```java
File carpeta = new File("./documentos");
File[] archivos = carpeta.listFiles();

for (File f : archivos) {
    System.out.println(f.getName());
}
```

---

# 🔄 5️⃣ File y el flujo de datos

Aquí está lo importante 👇

`File` se usa como **puente entre el programa y el flujo**.

## 📥 Lectura de datos

```java
File archivo = new File("datos.txt");
FileReader fr = new FileReader(archivo);
BufferedReader br = new BufferedReader(fr);

String linea = br.readLine();

br.close();
```

Flujo:

Archivo físico → File → FileReader → BufferedReader → Programa

---

## 📤 Escritura de datos

```java
File archivo = new File("datos.txt");
FileWriter fw = new FileWriter(archivo);
BufferedWriter bw = new BufferedWriter(fw);

bw.write("Hola mundo");

bw.close();
```

Flujo:

Programa → BufferedWriter → FileWriter → File → Archivo físico

---

# 🧩 6️⃣ Buenas prácticas

✅ Usar siempre `try-with-resources`

```java
try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
    System.out.println(br.readLine());
}
```

✅ Separar responsabilidad:

- `File` → representa ruta
- Flujos → manejan datos

---

# 🎯️ 7️⃣ Resumen final

`File`:

- Representa archivos y directorios
- Permite consultar información
- Permite crear y borrar
- No maneja directamente datos
- Se combina con flujos para leer/escribir

---

# 📌 Idea clave

> `File` no mueve datos.
>
> `File` señala dónde están los datos.
>
> Los flujos son los que realmente transportan la información.

