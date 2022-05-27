package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegistroControlador {
	private String correo;
	private String contra;
    @FXML
    private Button botoniniciar;
    @FXML
    private Text cerrar;
    @FXML
    private Button botonregistrarme;
    @FXML
    private TextField txt_correo;
    @FXML
    private TextField txt_contra;

    @FXML
    void close(MouseEvent event) {
    	System.exit(0);
    }
    @FXML
    void cambiar(MouseEvent event) {
    	correo = txt_correo.getText();
    	contra = txt_contra.getText();
    	bbdd.Registro(correo, contra);
    	try {
    	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("inicial.fxml"));
			Parent root = loader.load();
			inicialControlador controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.cerrar());
			Stage mystage = (Stage) this.botoniniciar.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void iniciar(MouseEvent event) {
    	try {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("inicial.fxml"));
			Parent root = loader.load();
			inicialControlador controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.cerrar());
			Stage mystage = (Stage) this.botonregistrarme.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public Object cerrar() {
		return null;
	}

}