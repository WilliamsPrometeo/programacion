# 📝 Simulacro Alternativo – Gestor de Películas (ArrayList)

## 📘 Descripción
Este simulacro permite practicar clases y el uso de colecciones ArrayList.  
El alumno debe gestionar una colección de películas.

---

## 🎯 Objetivo del simulacro
Construir un programa que gestione una filmoteca, permitiendo almacenar películas, listarlas y realizar búsquedas.  
En este simulacro no debe pedirse ningún dato al usuario: todas las películas se crearán dentro del código.

---

## 📂 Tareas del simulacro

### 1. Crear la clase Pelicula
Debe incluir los siguientes elementos:

- Atributos privados:
    - titulo
    - director
    - duracion (En Minutos)
- Constructor con los tres parámetros
- Métodos getters y setters
- Método toString que muestre una línea con:
  Título: ... | Director: ... | Duracion: ... min

---

### 2. Crear la clase filmoteca
Debe contener:

- Un atributo:
  ArrayList<Pelicula> catalogo
- Inicializar el ArrayList en el constructor
- Métodos obligatorios:

  • añadirPelicula(Pelicula p): añade una película al catálogo  
  • listarPeliculas(): muestra todas las películas almacenadas  
  • buscarPorDuracion(int minimo, int maximo): muestra todas las películas cuya duración esté dentro del rango  
  • buscarPorDirector(String director): muestra todas las películas cuyo director coincida con el indicado

---

### 3. Crear la clase principal GestorPeliculas
Debe realizar las siguientes acciones:

1. Crear un objeto filmoteca
2. Crear al menos cuatro películas directamente en el código
3. Añadir todas las películas al catálogo
4. Mostrar:
    - El catálogo completo
    - Las películas dentro de un rango de duración (por ejemplo, 90 a 130 minutos)
    - Las películas de un director concreto

---

## 🧮 Ejemplo orientativo de salida (no es una solución real)

=== CATALOGO COMPLETO ===  
Titulo: Matrix | Director: Wachowski | Duracion: 136 min  
Titulo: Interstellar | Director: Christopher Nolan | Duracion: 169 min  
Titulo: Alien | Director: Ridley Scott | Duracion: 117 min  
Titulo: Toy Story | Director: John Lasseter | Duracion: 81 min

=== PELICULAS ENTRE 100 Y 150 MIN ===  
Titulo: Alien | Director: Ridley Scott | Duracion: 117 min

=== PELICULAS DE RIDLEY SCOTT ===  
Titulo: Alien | Director: Ridley Scott | Duracion: 117 min

---

## 💡 Recomendaciones
- Utilizar siempre el método toString para mostrar información de un objeto.
- Recorrer el ArrayList mediante un bucle for-each.
- Organizar bien el código para que el main solo coordine operaciones.
- Evitar código duplicado mediante métodos bien definidos.

---

🕒 Duración estimada: 45 a 60 minutos  
🎯 Competencias: colecciones, clases básicas, métodos, recorridos y búsquedas.
