package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CatalogoControlador extends inicialControlador {
	@FXML
	private Button Volver;
	@FXML
	private Button BotonAccion;

	@FXML
	private Button BotonAventura;

	@FXML
	private Button BotonCarrera;

	@FXML
	private Button BotonDeporte;

	@FXML
	private Button BotonRol;
	@FXML
    private TextArea txt_Visor;

	@FXML
	private Button BotonTerror;

	@FXML
	private Button BotonTodos;

	@FXML
	void VolverInicio(MouseEvent event) {
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
			Stage mystage = (Stage) this.Volver.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
    void Todos(MouseEvent event) {
		Ver_Catalogo(0);
    }
	@FXML
    void Acccion(MouseEvent event) {
		Ver_Catalogo(1);
    }@FXML
    void Terror(MouseEvent event) {
    	Ver_Catalogo(6);
    }@FXML
    void Carrera(MouseEvent event) {
    	Ver_Catalogo(3);
    }@FXML
    void Deporte(MouseEvent event) {
    	Ver_Catalogo(4);
    }@FXML
    void Aventura(MouseEvent event) {
    	Ver_Catalogo(2);
    }@FXML
    void Rol(MouseEvent event) {
    	Ver_Catalogo(5);
    }
	
	void Ver_Catalogo(int a) {
		String aux = bbdd.ver_todo(a);
		txt_Visor.setText(aux);
	}

}
