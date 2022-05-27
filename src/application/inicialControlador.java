package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class inicialControlador {
    @FXML
    private Button Cambio;
    @FXML
    private Text cerrar;
    @FXML
    private Button iniciar;
    @FXML
    void close(MouseEvent event) {
    	System.exit(0);
    }
    @FXML
    void cambiar(MouseEvent event) {
    	try {
    	  		FXMLLoader loader = new FXMLLoader(getClass().getResource("Registro.fxml"));
    	  				Parent root = loader.load();
    	  				RegistroControlador controlador = loader.getController();
    	  				Scene scene = new Scene(root);
    	  				Stage stage = new Stage();
    	  				stage.setScene(scene);
    	  				stage.initStyle(StageStyle.UNDECORATED);
    	  				stage.show();
    	  				stage.setOnCloseRequest(e -> controlador.cerrar());
    	  				Stage mystage = (Stage) this.Cambio.getScene().getWindow();
    	  				mystage.close();
    	  			} catch (IOException e) {
    	  				e.printStackTrace();
    	  			}
    }
    @FXML
    void iniciar(MouseEvent event) {
    	
    	try {
    	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
			Parent root = loader.load();
			MenuControlador controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.cerrar());
			Stage mystage = (Stage) this.iniciar.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	Object cerrar() {
		return null;
	}

}
