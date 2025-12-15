# 📘Proyecto 3: Gestión de Acceso a una Plataforma

## 📝 Enunciado

Se desea desarrollar una aplicación en **Java** que permita gestionar y validar los **datos de acceso a una plataforma online**.  
La aplicación funcionará a través de un **menú interactivo por consola**, desde el cual el usuario podrá seleccionar distintas opciones relacionadas con la validación de credenciales.

El programa deberá ejecutarse de forma continua hasta que el usuario decida salir explícitamente.

---

## 📋 Funcionalidades del programa

El sistema mostrará un menú con las siguientes opciones:

1. **Validar identificador de acceso**
2. **Validar clave de seguridad**
3. **Salir**

El usuario deberá introducir una opción numérica.  
Si se introduce un valor no numérico, el programa deberá capturar la excepción correspondiente y mostrar un mensaje de error adecuado.

---

## 🔐 Validación del identificador de acceso

Al seleccionar esta opción, el programa solicitará al usuario un **identificador de acceso** que deberá cumplir las siguientes condiciones:

- Tener **al menos 3 caracteres**
- Contener únicamente **letras y números**

Si el identificador cumple los requisitos, se mostrará el mensaje:

> *Validación correcta*

En caso contrario, se deberá lanzar una **excepción personalizada**, mostrar el mensaje de error y considerar la validación como incorrecta.

---

## 🔑 Validación de la clave de seguridad

Al seleccionar esta opción, el programa pedirá al usuario una **clave de seguridad** que deberá cumplir los siguientes criterios:

- Tener una longitud mínima de **6 caracteres**
- Contener **al menos un número**
- Contener **al menos una letra mayúscula**

Si la clave es válida, se indicará correctamente por pantalla.  
Si no cumple las condiciones, se lanzará una **excepción personalizada** explicando el motivo del error.

---

## ⚙️ Requisitos técnicos

- Uso de **menú interactivo** con estructura repetitiva
- Uso de la clase `Scanner` para la entrada de datos
- Control de errores mediante **excepciones personalizadas**
- Manejo de excepciones estándar como `InputMismatchException`
- Uso de **expresiones regulares** para validar los datos
- Organización correcta del código en métodos

---

## 📊 Rúbrica de evaluación (10 puntos)

| Criterio                                                         | Puntuación    |
|------------------------------------------------------------------|---------------|
| Implementación correcta del menú interactivo                     | 2 puntos      |
| Validación correcta del identificador de acceso                  | 2 puntos      |
| Validación correcta de la clave de seguridad                     | 2 puntos      |
| Uso adecuado de excepciones personalizadas                       | 2 puntos      |
| Manejo correcto de errores de entrada (`InputMismatchException`) | 1 punto       |
| Uso correcto de expresiones regulares                            | 1 punto       |
| **TOTAL**                                                        | **10 puntos** |

---

📌 *Se valorará la claridad del código, el uso adecuado de métodos y la correcta gestión de excepciones.*
