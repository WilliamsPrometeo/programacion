
# 🚗 Simulacro de Proyecto: Gestor de Parking

## 🅿️ Descripción general
Vas a desarrollar una aplicación de consola en **Java** que gestione un **parking de vehículos**.  
El programa debe permitir **registrar**, **listar**, **buscar** y **eliminar** vehículos por su **ID**.

La aplicación debe usar **ejemplos_clase.clases**, **métodos parametrizados**, **ArrayList**, **condicionales**, **bucles**, **excepciones** y mostrar la información formateada con `printf`.

---

## 🎯 Objetivos de aprendizaje
Durante el simulacro deberás demostrar:

- Creación y uso de **ejemplos_clase.clases** y **atributos estáticos**.  
- Implementación de **métodos con parámetros y retorno**.  
- Uso correcto de **ArrayList** para almacenar objetos.  
- Aplicación de **condicionales** y **bucles**.  
- Formateo de datos con `printf`.  
- Control de excepciones (**excepción personalizada**).

---

## 🚙 Estructura básica de ejemplos_clase.clases

### 🏢 Clase `Parking`
```java
import java.util.ArrayList;

public class Parking {
    /*
        Atributos:
            listaVehiculos - Lista de Vehículos
    */

    // Constructor vacío donde inicializamos la lista
    
    // Getters y Setters

    // Métodos
    /*
        registrarVehiculo
            - Añade un vehículo
        @params Vehiculo
     */

    /*
        listarVehiculo
            - Muestra la lista de vehículos
     */
    
    /*
        buscarPorId
            - Busca un vehículo por ID
        @params id
        @return Vehiculo
     */

    /*
        eliminarPorId
            - Elimina un vehículo por ID
        @params id
        @return boolean
     */
}
```

---

### 🚗 Clase `Vehiculo`
```java
public class Vehiculo {
    /*
        Atributos:
            id - Único auto-incremental
            matricula - Cadena de caracteres
            marca - Texto
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

## 🧾 Criterios de evaluación (5 puntos)

| Criterio | Descripción | Puntos |
|-----------|--------------|--------|
| **Estructura y organización** | Código limpio, comentado y ordenado. | 1 |
| **Clases y métodos** | Correcta definición y uso de ejemplos_clase.clases y métodos. | 1 |
| **Uso de ArrayList** | Manipulación eficiente de la lista de vehículos. | 1 |
| **Control de excepciones** | Manejo de errores de entrada y excepción personalizada. | 1 |
| **Salida formateada y funcionalidad** | Uso de `printf`, menú claro y resultados correctos. | 1 |

**Total: 5 puntos**
