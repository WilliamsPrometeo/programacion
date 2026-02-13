package segunda_evaluacion.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(MainApp.class.getResource("/segunda_evaluacion/javafx/view/libro-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/segunda_evaluacion/javafx/view/libro-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        stage.setTitle("Gestion de Libros");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
