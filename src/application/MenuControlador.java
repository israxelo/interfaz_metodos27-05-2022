package application;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class MenuControlador {
    @FXML
    private Text cerrar;
    @FXML
    void close(MouseEvent event) {
    	System.exit(0);
    }
}
