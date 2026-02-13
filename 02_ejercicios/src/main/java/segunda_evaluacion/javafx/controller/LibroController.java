package segunda_evaluacion.javafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import segunda_evaluacion.javafx.model.Libro;


public class LibroController {

    @FXML
    private TextField tituloField;

    @FXML
    private TextField autorField;

    @FXML
    private ListView<Libro> listaLibros;

    private ObservableList<Libro> libros = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        listaLibros.setItems(libros);
    }

    @FXML
    private void agregarLibro() {
        String titulo = tituloField.getText();
        String autor = autorField.getText();

        if (!titulo.isEmpty() && !autor.isEmpty()) {
            Libro libro = new Libro(titulo, autor);
            libros.add(libro);

            tituloField.setText("");
            autorField.setText("");
        }
    }
}
