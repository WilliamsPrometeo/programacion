# 🕒 Fechas y Horas en Java
# `LocalDate`, `LocalTime` y `LocalDateTime`

Estas clases pertenecen al paquete moderno de fechas introducido en Java 8:

```java
import java.time.*;
```

Forman parte de la API **java.time**, que reemplaza a las antiguas `Date` y `Calendar`.

---

# 🧠 1️⃣ ¿Por qué usar `java.time`?

Antes de Java 8:

- `Date` era mutable ❌
- `Calendar` era complejo ❌
- Eran propensas a errores ❌

Con `java.time`:

- Son inmutables ✅
- Más claras y legibles ✅
- Más seguras y modernas ✅

---

# 📅 2️⃣ `LocalDate`

Representa **una fecha sin hora**.

Ejemplo: `2026-02-13`

## Crear una fecha

```java
LocalDate hoy = LocalDate.now();
LocalDate fecha = LocalDate.of(2026, 2, 13);
LocalDate parseada = LocalDate.parse("2026-02-13");
```

---

## Métodos principales

```java
hoy.getYear();
hoy.getMonth();
hoy.getDayOfMonth();
hoy.getDayOfWeek();

hoy.plusDays(5);
hoy.minusMonths(1);

hoy.isAfter(fecha);
hoy.isBefore(fecha);
```

⚠️ Recuerda: es inmutable → cada operación devuelve un nuevo objeto.

---

# ⏰ 3️⃣ `LocalTime`

Representa **una hora sin fecha**.

Ejemplo: `18:30:15`

## Crear una hora

```java
LocalTime ahora = LocalTime.now();
LocalTime hora = LocalTime.of(18, 30);
LocalTime parseada = LocalTime.parse("18:30:00");
```

---

## Métodos principales

```java
ahora.getHour();
ahora.getMinute();
ahora.getSecond();

ahora.plusHours(2);
ahora.minusMinutes(30);

ahora.isAfter(hora);
ahora.isBefore(hora);
```

---

# 📅⏰ 4️⃣ `LocalDateTime`

Combina fecha y hora.

Ejemplo: `2026-02-13T18:30:00`

## Crear un LocalDateTime

```java
LocalDateTime ahora = LocalDateTime.now();

LocalDateTime fechaHora = LocalDateTime.of(
    2026, 2, 13,
    18, 30
);

LocalDateTime parseado = LocalDateTime.parse("2026-02-13T18:30:00");
```

---

## Métodos principales

```java
ahora.toLocalDate();
ahora.toLocalTime();

ahora.plusDays(1);
ahora.minusHours(3);
```

---

# 🔄 5️⃣ Formateo de fechas

Para mostrar fechas correctamente usamos:

```java
import java.time.format.DateTimeFormatter;
```

## Ejemplo

```java
DateTimeFormatter formato =
    DateTimeFormatter.ofPattern("dd/MM/yyyy");

String fechaFormateada = hoy.format(formato);
```

Patrones comunes:

- `dd` → día
- `MM` → mes
- `yyyy` → año
- `HH` → hora 24h
- `mm` → minutos

---

# 🏗 6️⃣ Uso en arquitectura MVC

En tus proyectos:

## 📌 En el Modelo

```java
private LocalDate fechaPublicacion;
private LocalDateTime fechaCreacion;
```

El modelo debe almacenar fechas usando `LocalDate` en lugar de `String`.

---

## 📌 En el Controller

Se puede parsear lo que introduce el usuario:

```java
LocalDate fecha = LocalDate.parse(input);
```

---

## 📌 En filtros

Ejemplo de filtro por año:

```java
if (reserva.getFecha().getYear() == 2026) {
    // lógica
}
```

Esto conecta directamente con los filtros por fecha que ya trabajas en clase.

---

# ⚠️ 7️⃣ Buenas prácticas

✅ No usar `String` para guardar fechas.

❌ Evitar usar `Date` y `Calendar` en proyectos nuevos.

✅ Usar `DateTimeFormatter` para mostrar datos.

✅ Recordar que son inmutables.

---

# 🎯 8️⃣ Resumen comparativo

| Clase | Representa | Ejemplo |
|--------|------------|----------|
| `LocalDate` | Solo fecha | 2026-02-13 |
| `LocalTime` | Solo hora | 18:30:00 |
| `LocalDateTime` | Fecha + hora | 2026-02-13T18:30:00 |

---

# 📌 Idea clave 

> `LocalDate` → ¿Qué día?
>
> `LocalTime` → ¿Qué hora?
>
> `LocalDateTime` → ¿Qué día y a qué hora?


