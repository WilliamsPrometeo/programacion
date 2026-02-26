# 📘 FXML en JavaFX

## 🎯 ¿Qué es FXML?

**FXML** es un archivo en formato **XML** que se utiliza en JavaFX para definir la **interfaz gráfica (Vista)** de una aplicación.

Permite separar:

- 🖼️ Vista → Archivo `.fxml`
- 🎮 Controlador → Clase Java
- 📦 Modelo → Clases de datos

Esto facilita aplicar correctamente el patrón **MVC (Modelo – Vista – Controlador)**.

---

# 🧠 ¿Por qué usar FXML?

Sin FXML, la interfaz se crea directamente en código Java.

Con FXML:

- La vista queda separada de la lógica
- Es más limpia y mantenible
- Se parece a cómo funcionan las vistas en aplicaciones web
- Permite trabajar en equipo (uno diseña vista, otro programa lógica)

---

# 🏗️ Estructura básica de un archivo FXML (hecho a mano)

Un archivo FXML se puede crear manualmente como un archivo normal:

```
New → File → nombre.fxml
```

Ejemplo mínimo funcional:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.VBox?>

<VBox xmlns:fx="http://javafx.com/fxml"
      fx:controller="paquete.controller.MiController"
      spacing="10"
      alignment="CENTER">

    <Label text="Hola JavaFX" />

    <Button text="Pulsar" onAction="#accionBoton" />

</VBox>
```

---

# 🔍 Explicación línea por línea

## 1️⃣ Declaración XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
```
Indica que el archivo es XML.

---

## 2️⃣ Imports

```xml
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.VBox?>
```
Permiten usar componentes JavaFX dentro del archivo.

---

## 3️⃣ Contenedor raíz

```xml
<VBox>
```

Siempre debe existir un nodo raíz.
Puede ser:

- VBox
- HBox
- BorderPane
- AnchorPane
- GridPane

---

## 4️⃣ Enlace con el Controller

```xml
fx:controller="paquete.controller.MiController"
```

Conecta la vista con su clase controladora.

Debe coincidir exactamente con el paquete y nombre de la clase.

---

## 5️⃣ Componentes internos

Ejemplo:

```xml
<TextField fx:id="nombreField" />
<Button onAction="#guardar" />
```

### 🔹 fx:id
Permite que el componente se inyecte en el Controller con `@FXML`.

### 🔹 onAction
Llama a un método del Controller.

---

# 🔄 Cómo se conecta con Java

En el Controller:

```java
@FXML
private TextField nombreField;

@FXML
private void guardar() {
    System.out.println(nombreField.getText());
}
```

En el Main:

```java
FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/ruta/vista.fxml")
);

Scene scene = new Scene(loader.load());
```

Cuando se ejecuta:

1. Java carga el archivo FXML
2. Crea los objetos gráficos
3. Inyecta los componentes en el Controller
4. Conecta los eventos

---

# 📦 Resumen conceptual

```
FXML → Define la Vista
Controller → Gestiona eventos
Modelo → Contiene datos
```

FXML NO contiene lógica.
Solo estructura visual.

---

# RECURSOS NECESARIOS
```xml
    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>21.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>21.0.2</version>
        </dependency>
    </dependencies>
```
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>0.0.8</version>
            <configuration>
                <mainClass>
                    segunda_evaluacion.javafx.MainApp
                </mainClass>
            </configuration>
        </plugin>
    </plugins>
</build>
```

# ⚠️ Errores comunes al hacerlo a mano

❌ Ruta incorrecta en getResource()
❌ El fx:controller no coincide con el paquete
❌ El método del botón no existe
❌ Falta la anotación @FXML

---

# 🏁 Conclusión

FXML es la forma profesional de construir interfaces en JavaFX.

Permite:

- Separación real de responsabilidades
- Aplicar correctamente MVC
- Evolucionar hacia arquitecturas más limpias

Es el primer paso para pasar de aplicaciones de consola a aplicaciones con interfaz gráfica bien estructurada.

