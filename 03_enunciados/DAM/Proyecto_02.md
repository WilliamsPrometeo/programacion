# 📘 Proyecto 2 — Sistema de Gestión de un Taller Mecánico

## 🎯 Objetivos de aprendizaje
Durante este proyecto deberás demostrar:

- Creación y uso de **clases**, constructores y encapsulación.  
- Implementación de métodos con parámetros y retorno.  
- Correcto uso de **ArrayList** y **Map** para almacenar y relacionar objetos.  
- Aplicación de **condicionales**, bucles, `switch`, operador **ternario** y filtrados.  
- Uso de **Enums** para clasificaciones.  
- Obtención de la fecha y hora actual mediante **LocalDateTime**, formateada adecuadamente.  
- Control de errores mediante una **excepción personalizada (VehiculoNoEncontrado)**.  
- Formateo de texto con `printf` y `String.formatted()`.  
- Uso obligatorio de la clase **MyScanner** para la entrada de datos del usuario.  
- Documentación obligatoria mediante **JavaDoc**.

---

# 🔧 Descripción general del proyecto
Desarrollarás un sistema de gestión para un **taller mecánico**, que permitirá:

- Registrar vehículos  
- Registrar servicios mecánicos  
- Asignar servicios a vehículos  
- Consultar vehículos registrados  
- Consultar servicios realizados  

Todo el sistema funciona por consola usando **MyScanner**.

---

# 🧱 Estructura de clases requerida

## 🚗 Clase `Vehiculo`
- `String matricula`  
- `String modelo`  
- `TipoVehiculo tipo`  

Requisitos:
- Constructor  
- Getters/setters  
- `toString()`  
- `equals()` y `hashCode()` basados solo en la matrícula  
- Será clave del Map de trabajos realizados  

---

## 🏷️ Enum `TipoVehiculo`
Debe incluir:
- TURISMO  
- MOTOCICLETA  
- FURGONETA  
- CAMION  

---

## 🛠️ Clase `Servicio`
- `String descripcion`  
- `String mecanico`  
- `TipoServicio tipo`  

Constructor, getters, setters y `toString()`.

---

## 🏷️ Enum `TipoServicio`
- MANTENIMIENTO  
- CAMBIO_ACEITE  
- PINTURA  
- FRENOS  
- ELECTRICIDAD  

---

## 🏭 Clase Taller — Métodos y Especificaciones

La clase **Taller** será el núcleo principal del proyecto. A continuación se detallan sus atributos, constructor y métodos obligatorios.

### 🔧 Atributos obligatorios

- `ArrayList<Vehiculo> vehiculos`
- `ArrayList<Servicio> catalogoServicios`
- `Map<Vehiculo, Servicio> trabajosRealizados`

### 🏗️ Constructor

**Constructor vacío**  
Debe inicializar todas las colecciones anteriores.

### 🧰 Métodos obligatorios

1. **`registrarVehiculo()`**

   - Solicita matrícula, modelo y tipo mediante **MyScanner**.
   - Valida que la matrícula tenga **7 caracteres alfanuméricos**.
       - Si no cumple: mostrar mensaje de error y repetir.
   - Crea el vehículo y lo añade a la lista.

2. **`registrarServicio()`**

   - Solicita descripción.
   - Solicita nombre del mecánico.
   - Muestra un menú para elegir `TipoServicio` mediante **switch**.
   - Crea el servicio y lo añade al catálogo.

3. **`asignarServicio()`**

   - Solicita matrícula del vehículo.
   - Llama internamente a `buscarVehiculo()`.
       - Si no existe → lanzar **VehiculoNoEncontrado**.
   - Solicita descripción del servicio.
   - Busca el servicio en el catálogo.
   - Usa un **operador ternario** para indicar si el servicio existe o no.
   - Si existe:
       - Registrar en `trabajosRealizados`.
       - Mostrar fecha y hora con **LocalDateTime**.

4. **`mostrarVehiculos()`**

   - Muestra todos los vehículos registrados.
   - Ofrece la opción de filtrar por `TipoVehiculo`.

5. **`mostrarTrabajos()`**

   - Muestra el contenido del `Map` con formato mediante **printf**.

6. **`buscarVehiculo(String matricula)`**

   - Devuelve el vehículo si existe.
   - Si no, lanza **VehiculoNoEncontrado**.

7. **`buscarServicio(String descripcion)`**

   - Devuelve el servicio solicitado o `null` si no existe.

---

## ❗ Excepción personalizada `VehiculoNoEncontrado`
Debe extender de Exception.

---

## ⌨️ Uso obligatorio de MyScanner
Toda entrada debe realizarse mediante **MyScanner**.

---

# ▶️ Clase Main
Menú con opciones:

1. Registrar vehículo  
2. Registrar servicio  
3. Asignar servicio  
4. Mostrar vehículos  
5. Mostrar trabajos  
6. Salir  

Con switch y bucle.

---

# ✨ Requisitos adicionales
- Uso de equals/hashCode correctamente  
- Uso de un operador ternario  
- Uso de LocalDateTime formateado  
- Uso de printf  
- JavaDoc completo  
- Código limpio y ordenado  

---
# 📊 Rúbrica de Evaluación del Proyecto (sobre 10 puntos)
| Criterio                                | Descripción                                                                                    | Puntuación Máxima | Condición                                                                     |
|-----------------------------------------|------------------------------------------------------------------------------------------------|-------------------|-------------------------------------------------------------------------------|
| **Documentación JavaDoc (OBLIGATORIA)** | Todas las clases y métodos principales incluyen JavaDoc completo y correcto.                   | **0 / 1**         | **Si este apartado no se cumple, el proyecto NO se evalúa (nota final = 0).** |
| **Estructura de clases**                | Clases correctamente creadas, atributos adecuados, constructores, getters/setters.             | 1                 | Se evalúa solo si hay JavaDoc.                                                |
| **Enums y uso adecuado**                | Uso correcto de todas las enumeraciones requeridas.                                            | 0.5               | —                                                                             |
| **Métodos y lógica interna**            | Métodos obligatorios implementados correctamente, validaciones, búsquedas, control de errores. | 2                 | —                                                                             |
| **Colecciones (ArrayList / Map)**       | Uso correcto, especialmente el Map con claves válidas (equals/hashCode).                       | 1.5               | —                                                                             |
| **Excepción personalizada**             | Implementación y utilización de `VehiculoNoEncontrado`.                                        | 1                 | —                                                                             |
| **Operador ternario**                   | Uso correcto de al menos un operador ternario.                                                 | 0.5               | —                                                                             |
| **LocalDateTime**                       | Obtención y formateo correcto de fecha y hora.                                                 | 0.5               | —                                                                             |
| **Formato de salida (printf)**          | Uso correcto de `printf.                                                                       | 0.5               | —                                                                             |
| **Uso obligatorio de MyScanner**        | Todas las entradas del usuario pasan por MyScanner.                                            | 1                 | —                                                                             |
| **Menú principal funcional**            | Menú con bucle + switch correctamente implementado.                                            | 0.5               | —                                                                             |
| **Calidad del código**                  | Claridad, organización, legibilidad.                                                           | 0.5               | —                                                                             |
| **PUNTUACIÓN TOTAL**                    |                                                                                                | **10 puntos**     | —                                                                             |
