# 📘 Práctica: Gestión de Inventario con Map y Excepciones

## 📝 Descripción del ejercicio

Crea un programa en Java que permita gestionar un inventario básico de productos utilizando un **Map**.  
El objetivo es practicar:

- Uso de colecciones (`Map`)
- Control de excepciones personalizadas
- Validación de datos de entrada
- Menús interactivos por consola

El inventario estará compuesto por pares **código del producto → precio**, donde:

- El **código** es un `String`
- El **precio** es un `Double`

El programa deberá ejecutarse mediante un menú repetitivo hasta que el usuario decida salir.

---

## 🎯 Funcionalidades obligatorias

Tu programa debe contener un menú con las siguientes opciones:

```
==== GESTIÓN DE INVENTARIO ====
1. Añadir producto
2. Buscar producto
3. Actualizar precio
4. Mostrar inventario
5. Salir
```

### 1. Añadir producto

El usuario introducirá un **código** y un **precio**.  
Antes de añadirlo al inventario, se deben validar los datos:

#### ✔ Validación del código

Debe cumplir:

- Mínimo 3 caracteres
- Solo mayúsculas y números

Si algo no se cumple → `CodigoInvalidoException`

### 2. Buscar producto

- Si el producto existe, mostrar su código y precio.
- Si no existe → `ProductoNoEncontradoException`

### 3. Actualizar precio

- El producto debe existir.  
  Si no → `ProductoNoEncontradoException`
- El precio debe ser mayor que 0.  
  Si no → `PrecioInvalidoException`

### 4. Mostrar inventario

- Si está vacío → mostrar mensaje.
- Si no → listar todos los productos en formato:

```
Código: XXX | Precio: YYY
```

### 5. Salir

Finaliza la ejecución del programa.

---

## 🚨 Excepciones obligatorias

Debes crear tres clases:

- `CodigoInvalidoException`
- `PrecioInvalidoException`
- `ProductoNoEncontradoException`

Todas deben heredar de `Exception`.

---

## 🚦 Requisitos técnicos

- Un solo archivo principal con toda la lógica (salvo excepciones)
- Uso de `Map<String, Double>`
- Uso de `Scanner`
- Manejo de `InputMismatchException`
- Validaciones en métodos separados

---

## 🎓 Objetivo educativo

Este ejercicio te ayudará a dominar:

- Colecciones en Java
- Excepciones personalizadas
- Diseño de menús
- Validación de datos

---

# 📊 Rúbrica de Evaluación — Práctica: Gestión de Inventario

| **Criterio**                   | **Descripción**                                                                           | **Puntuación máxima** |
|--------------------------------|-------------------------------------------------------------------------------------------|-----------------------|
| **Funcionamiento del menú**    | El menú funciona correctamente, controla errores de entrada y permite navegar sin fallos. | **2 pts**             |
| **Añadir producto**            | Valida código y precio, y almacena el producto correctamente en el Map.                   | **2 pts**             |
| **Buscar producto**            | Busca productos correctamente y gestiona excepciones cuando no existen.                   | **1.5 pts**           |
| **Actualizar precio**          | Actualiza correctamente el precio y valida la entrada.                                    | **1.5 pts**           |
| **Mostrar inventario**         | Muestra correctamente todos los productos o un mensaje si está vacío.                     | **1 pt**              |
| **Validaciones y excepciones** | Validaciones implementadas correctamente y uso adecuado de excepciones personalizadas.    | **1 pt**              |
| **Calidad del código**         | Código claro, organizado, con métodos separados y buena indentación.                      | **1 pt**              |

### **Documentación obligatoria con JavaDoc**
## **Total máximo: 10 puntos**
