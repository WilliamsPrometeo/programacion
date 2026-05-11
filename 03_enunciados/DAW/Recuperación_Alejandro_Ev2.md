# 🧩 Enunciado del Proyecto: Aplicación de Gestión de Eventos en Java

## 📌 Descripción General
Desarrollar una aplicación en Java que permita gestionar eventos (como reuniones, conferencias o citas), incluyendo la creación, modificación, eliminación y almacenamiento persistente de los datos.

La aplicación deberá implementar conceptos fundamentales de programación orientada a objetos, manejo de estructuras dinámicas, fechas y persistencia en archivos de texto.

---

## 🎯 Objetivos
El proyecto debe incluir el uso de los siguientes elementos:

- Uso de **ArrayList** para almacenar colecciones de objetos.
- Manejo de **fechas** (clases como `LocalDate` o `LocalDateTime`).
- Implementación de **herencia** entre clases.
- Uso de **enumeraciones (enum)**.
- **Lectura y escritura en archivos de texto** para persistir datos.

---

## 🏗️ Requisitos Funcionales

La aplicación debe permitir:

1. **Crear un evento**
2. **Listar eventos**
3. **Modificar un evento existente**
4. **Eliminar un evento**
5. **Guardar los eventos en un archivo de texto**
6. **Cargar los eventos desde un archivo al iniciar la aplicación**

---

## 🧱 Diseño de Clases

### 🔹 Clase base: `Evento`
Debe contener:

- `id` (int)
- `titulo` (String)
- `descripcion` (String)
- `fecha` (LocalDateTime)
- `tipo` (enum)

---

### 🔹 Enumeración: `TipoEvento`
Debe incluir al menos:

- PERSONAL
- LABORAL
- URGENTE

---

### 🔹 Herencia
Crear al menos una subclase de `Evento`, por ejemplo:

#### `EventoOnline` (hereda de Evento)
- `url` (String)

#### `EventoPresencial` (hereda de Evento)
- `ubicacion` (String)

---

## 📦 Estructura de Datos

- Utilizar un `ArrayList<Evento>` para almacenar todos los eventos en memoria.

---

## 💾 Persistencia de Datos

Implementar:

- Escritura en archivo de texto (`.txt`) para guardar los eventos.
- Lectura del archivo para reconstruir los objetos al iniciar la aplicación.

📌 Formato sugerido:

```
id|titulo|descripcion|fecha|tipo|extra
```

Donde `extra` dependerá del tipo de evento (URL o ubicación).

---

## 🖥️ Interfaz de Usuario

Puede ser:

- Consola (menú interactivo)

Ejemplo de menú:

```
1. Crear evento
2. Listar eventos
3. Modificar evento
4. Eliminar evento
5. Guardar datos
6. Salir
```

---

## ⚙️ Requisitos Técnicos

- Lenguaje: Java
- Uso de `ArrayList`
- Uso de `LocalDate` o `LocalDateTime`
- Uso de herencia (`extends`)
- Uso de `enum`
- Manejo de archivos (`FileWriter`, `BufferedReader`, etc.)

---

## 📊 Criterios de Evaluación

- Correcto uso de POO (herencia, encapsulación)
- Uso adecuado de estructuras dinámicas
- Implementación funcional de lectura/escritura en archivos
- Organización y claridad del código
- Correcta utilización de enums y fechas

---

## 💡 Nota Final

Se valorará especialmente la claridad del código, la modularidad y el uso correcto de los conceptos solicitados.
Al ser un examen de minimos, si se llega a superar, se recuperará la evaluación con un 5. 

