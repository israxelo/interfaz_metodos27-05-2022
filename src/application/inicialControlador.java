package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class inicialControlador {
	private String aux1;
	private String aux2;
	static Conexion_y_metodos bbdd = new Conexion_y_metodos();
	@FXML
	private Button Cambio;
	@FXML
    private Text Resultado;

    @FXML
    private PasswordField txt_Contra;
	@FXML
	private Text cerrar;
	@FXML
	private Button iniciar;

	@FXML
	private TextField txt_IniciarSesion;
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
		aux1 = txt_IniciarSesion.getText();
		aux2 = txt_Contra.getText();
		int a =bbdd.Iniciar_Sesion(aux1, aux2);
		if(a ==1) {
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
		else {
			Resultado.setText("¡No existe una cuenta con este correo!");
		}

	}
	Object cerrar() {
		return null;
	}

}
