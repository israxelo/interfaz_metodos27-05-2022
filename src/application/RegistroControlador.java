package application;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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

public class RegistroControlador extends inicialControlador{
	private String aux1;
	private String aux2;
	@FXML
	private Button botoniniciar;
	@FXML
	private Text cerrar;
	@FXML
	private Button botonregistrarme;
	@FXML
	private Text textomuestra;
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
		aux1 = txt_correo.getText();
		aux2 = txt_contra.getText();
		boolean aux =registro(aux1,aux2);
		if(aux ==true) {
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
	}
	boolean registro(String correo,String contra) {
		try {
			bbdd.Registro(correo, contra);
			return true;
		} catch (SQLIntegrityConstraintViolationException e1) {
			textomuestra.setText("¡Ya existe una cuenta registrada con este email!");
			return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Object cerrar() {
		return null;
	}

}