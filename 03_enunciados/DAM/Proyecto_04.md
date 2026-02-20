# 🦁 PROYECTO 04 - GESTIÓN DE UN ZOO

## 🎯 Objetivo del proyecto

Desarrollar una aplicación en Java para la gestión básica de un Zoo aplicando el patrón **MVC (Modelo – Vista – Controlador)** en un entorno de consola.

⚠️ Importante:
- No se utilizará entorno gráfico.
- La "Vista" estará integrada dentro del Controller (MVC formativo).
- Los datos deberán poder guardarse y cargarse desde archivo binario (.dat).

---

## 📌 Requisitos funcionales

La aplicación deberá permitir:

1. Registrar animales.
2. Listar todos los animales.
3. Buscar un animal por su ID.
4. Eliminar un animal por su ID.
5. Guardar los datos en archivo binario (.dat).
6. Cargar los datos desde archivo binario (.dat).

El menú deberá repetirse hasta que el usuario elija la opción de salir.

---

## 🏗 Estructura obligatoria del proyecto

El proyecto deberá respetar la siguiente estructura de paquetes:

```
zoo
 ├── controller
 ├── dao
 ├── exceptions
 ├── models
 │    └── enums
 ├── repository
 ├── service
 └── AppZoo.java
```

---

## 🧠 Requisitos técnicos obligatorios

### 1️⃣ MVC Formativo

- El Controller pedirá los datos por consola.
- El Service contendrá la lógica de negocio.
- El Repository será el contrato que seguirá el Service.
- El DAO gestionará la persistencia en archivo.
- El App ejecutará la aplicación y contendrá el menú.

---

### 2️⃣ Uso de Map

Los animales deberán almacenarse en memoria utilizando un Map cuya **clave sea el propio objeto Animal**.

Esta estructura se utilizará para guardar la ubicación del animal:

```
Map<Animal, Habitat> ubicaciones
```

Donde:
- La clave será el objeto Animal.
- El atributo `id` del Animal deberá identificarlo de manera única. 
- El valor Habitat será un ENUM en el que estén predefinidos los habitats permitidos

Ejemplo de ENUM:

* SELVA
* ACUARIO
* GRANJA

⚠️ IMPORTANTE:

Para que esto funcione correctamente será obligatorio:

- Sobrescribir `equals()`
- Sobrescribir `hashCode()`

Ambos métodos deberán basarse únicamente en el atributo `id`.

Si no se implementan correctamente, el Map no funcionará de manera adecuada (no detectará duplicados ni podrá recuperar objetos correctamente).

No se permite usar únicamente ArrayList como estructura principal.

---

### 3️⃣ Herencia

Debe existir:

- Una clase abstracta `Animal`
- Al menos dos clases que hereden de ella (por ejemplo: Mamifero y Ave)

La clase Animal deberá contener:
- id (alfanumérico obligatorio con el siguiente formato: 3 letras seguidas de 2 números. Ejemplo válido: ABC12)
- fecha de registro
- método abstracto que identifique el tipo

El ID deberá validarse mediante una comprobación (por ejemplo, utilizando expresiones regulares). Si no cumple el formato, se deberá lanzar una excepción personalizada verificable.

Cada subclase deberá contener:
- atributo propio
- implementación correcta del método abstracto

---

### 4️⃣ Serializable

Todos los modelos deberán implementar `Serializable`.

Se deberá:
- Definir `serialVersionUID`
- Poder guardar y recuperar los datos correctamente

---

### 5️⃣ Persistencia (.dat)

Se deberá crear:

- Una interfaz DAO
- Una implementación que guarde y cargue usando:
  - ObjectOutputStream
  - ObjectInputStream

El archivo deberá llamarse:

```
zoo.dat
```

Deberá guardarse en la siguiente ruta:
```
Desktop/DAM/Proyetos/Zoológico
```

---

### 6️⃣ Excepciones personalizadas verificadas

Se deberán crear al menos:

- InvalidAnimalException
- InvalidDateException

Las excepciones deberán:

- Extender de Exception (NO RuntimeException)

Ejemplo de validaciones:

- ID vacío o nulo
- Fecha superior a la actual

---

## 📋 Funcionamiento esperado

Ejemplo de menú:

```
1. Registrar animal
2. Listar animales
3. Buscar animal
4. Eliminar animal
5. Guardar datos
6. Cargar datos
0. Salir
```

El programa no debe finalizar si ocurre una excepción controlada.

Las excepciones deberán mostrarse por pantalla con mensajes claros.

---
## 💡 Consejo

Antes de programar:

1. Diseña el modelo.
2. Piensa las validaciones.
3. Implementa primero el Repository.
4. Después el Service.
5. Finalmente el Controller y la persistencia.

---
## Rúbrica de evaluación

> ⚠️ Nota importante:
> Se consideran **requisitos mínimos obligatorios** (no evaluables directamente en la tabla, pero penalizables si están mal implementados):
>
> * Estructura básica de clases correcta.
> * Sobreescritura adecuada de `equals()` y `hashCode()`.
> * Uso correcto de excepciones personalizadas.
> * Uso correcto de `Map<Animal, Habitat>`.
> * Modelado correcto mediante herencia.
> * Uso adecuado de ENUM (`Habitat`).
>
> Cualquier error grave en estos apartados podrá suponer penalización directa sobre la nota final.

### 📊 Tabla de evaluación (10 puntos)

| Criterio evaluable                                      | Descripción                                                                                                                                                         | Puntos |
|---------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| **Aplicación rigurosa del patrón MVC**                  | Separación estricta de responsabilidades entre Controller, Service, Repository y DAO. No existen mezclas indebidas de lógica. Arquitectura coherente y profesional. | 3      |
| **Persistencia robusta en archivo .dat**                | Implementación completamente funcional del guardado y carga mediante serialización. Control adecuado de errores de E/S y correcta gestión de recursos.              | 2.5    |
| **Validaciones de negocio avanzadas en Service**        | Validaciones completas, coherentes y centralizadas exclusivamente en la capa Service (formato de ID, fechas válidas, coherencia del dominio).                       | 2      |
| **Diseño orientado al dominio y coherencia del modelo** | El diseño refleja comprensión real del dominio (Zoo). Decisiones justificadas, encapsulación adecuada y ausencia de lógica mal ubicada.                             | 1      |
| **Control de flujo y robustez del menú**                | Aplicación estable ante errores de usuario. No finaliza inesperadamente. Gestión clara de excepciones sin bloquear el programa.                                     | 0.5    |
| **Calidad técnica del código**                          | Código limpio, bien estructurado, nombres coherentes, sin duplicidades innecesarias y con buenas prácticas generales.                                               | 1      |

---

### 📝 Penalizaciones automáticas (hasta -3 puntos)

Se aplicarán penalizaciones por:

* Incumplimiento de requisitos mínimos obligatorios.
* Mala implementación de `equals()` o `hashCode()`.
* Uso incorrecto del `Map` como estructura principal.
* Herencia mal diseñada o innecesaria.
* Uso indebido de ENUM (sustituido por String o mal implementado).
* Estructura de paquetes incorrecta.
* Archivo no guardado en la ruta obligatoria.

---

### 🏁 Nota final

La nota final se calculará sobre 10 puntos, aplicando en su caso las penalizaciones correspondientes.

Esta rúbrica evalúa no solo que el programa funcione, sino que esté correctamente diseñado desde el punto de vista arquitectónico y orientado a objetos.
