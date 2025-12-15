
# Simulacro Práctica 4 – Ampliación de Programación (DAM 1)

## Gestión de Usuarios con Excepciones Personalizadas

### **Descripción General**
Desarrolla un programa en Java que simule un sistema de gestión de usuarios. El objetivo es evaluar el uso de:

- Bucles  
- Condicionales  
- Estructuras de control  
- Switch  
- Operador ternario  
- Métodos de `String` (`contains`, `matches`)  
- Excepciones personalizadas **verificadas** heredadas de `Exception`

El programa debe mostrar un menú interactivo que permita registrar usuarios, buscar, validar contraseñas y aplicar filtros.

---

## **1. Menú Principal**
El sistema mostrará repetidamente el siguiente menú hasta que el usuario decida salir:

```
===== GESTIÓN DE USUARIOS =====
1. Registrar usuario
2. Buscar usuario
3. Iniciar con usuario
4. Salir
Seleccione una opción:
```

El control de flujo debe implementarse con un **switch**.

---

## **2. Registro de Usuario**
El usuario deberá introducir un nombre y contraseña.  
Se deben validar mediante métodos independientes que **lancen excepciones personalizadas** si hay errores.

### Validaciones del nombre de usuario
- No puede estar vacío.
- Debe tener mínimo 3 caracteres.
- Debe ser alfanumérico → `.matches("[A-Za-z0-9]+")`
- Si no es válido → lanzar `InvalidUsernameException`.

### Validaciones de contraseña
- Mínimo 6 caracteres.
- Debe contener un número → `.matches(".*[0-9].*")`
- Debe contener una letra mayúscula → `.matches(".*[A-Z].*")`
- Si no es válida → lanzar `InvalidPasswordException`.

Si se produce una excepción, debe mostrarse el mensaje y repetirse el proceso usando un **bucle**.

---

## **3. Búsqueda de Usuarios**
El usuario introduce un texto.  
El sistema mostrará los nombres que **contengan** dicho texto mediante `.contains()`.

Si no existen coincidencias → lanzar `UserNotFoundException`.

---

## **4. Iniciar con Usuario**
El programa solicita:

- Nombre de usuario  
- Contraseña  

Si el usuario no existe → lanzar `UserNotFoundException`.

Tras validar la contraseña, debe mostrarse el resultado usando un **operador ternario**:

```java
String mensaje = esCorrecta ? "Acceso permitido" : "Contraseña incorrecta";
```

---

## **5. Excepciones Personalizadas Requeridas**
El alumno debe implementar:

### ✔ `InvalidUsernameException`  
Lanzada al registrar un usuario con nombre inválido.

### ✔ `InvalidPasswordException`  
Lanzada al registrar una contraseña inválida.

### ✔ `UserNotFoundException`  
Lanzada al buscar usuarios o validar contraseñas de usuarios inexistentes.

Cada una debe **extender de `Exception`** (excepción verificada).

---

## **Objetivo del Ejercicio**
Este simulacro permite evaluar:

- Competencia en estructuras de control y lógica  
- Manejo de Strings y expresiones regulares  
- Uso correcto de excepciones personalizadas  
- Buena modularización mediante métodos  
- Implementación organizada con menús y validaciones
