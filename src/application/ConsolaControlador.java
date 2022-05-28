package application;


import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConsolaControlador extends inicialControlador {
	String ModeloAux = null;
	String DescripcionAux = null;
	String DireccionAux = null;

	ObservableList<String> mainDepartmentList = FXCollections.observableArrayList
			("PlayStation®4","PlayStation®5","Nintendo Switch","XboxOne","Xbox Series X");
	@FXML
	private ComboBox<String> Modelos;
	@FXML
	private void initialize() {

		Modelos.setValue("PlayStation®4");
		Modelos.setValue("PlayStation®5");
		Modelos.setValue("Nintendo Switch");
		Modelos.setValue("XboxOne");
		Modelos.setValue("Xbox Series X");
		Modelos.setItems(mainDepartmentList);
	}
	@FXML
	private Button Confirmar;

	@FXML
	private Button Volver;

	@FXML
	private Text cerrar;
	@FXML
	private Text Estado;

	@FXML
	private TextArea txt_Descripcion;

	@FXML
	private Button MisPedidos;

	@FXML
	private TextField txt_Direccion;
	@FXML
	void close(MouseEvent event) {

		System.exit(0);
	}
	@FXML
	void CambiarMenu(MouseEvent event) {
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
	void Insertar(MouseEvent event) {
		ModeloAux = Modelos.getValue();
		DescripcionAux = txt_Descripcion.getText();
		DireccionAux = txt_Direccion.getText();
		if(DescripcionAux.equals("")||DireccionAux.equals("")) {
			Estado.setText("¡FALTAN CAMPOS POR RELLENAR!");
		}
		else {
			try {
				bbdd.ConsolasInsertar(ModeloAux, DescripcionAux, DireccionAux);
				Estado.setText("¡CORRECTO!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	@FXML
	void VerPedidos(MouseEvent event) {
		String auxi = bbdd.VerPedidos();
		txt_Descripcion.setText(auxi);
	}

	Object cerrar() {
		return null;
	}

}
