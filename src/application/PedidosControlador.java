package application;

import java.io.IOException;

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

public class PedidosControlador extends inicialControlador {

	@FXML
	private Button VolverMenu;
	@FXML
	private Button BotonAlquilar;
	@FXML
	private Text Resultado;
	@FXML
    private TextArea Todos;
	@FXML
	private Button BotonComprar;
	@FXML
	private TextField txt_Alquiler;
	@FXML
	private TextField txt_Compra;
	ObservableList<Integer> mainDepartmentList = FXCollections.observableArrayList
			(10,15,20);
	@FXML
	private ComboBox<Integer> ComboboxDias;
	@FXML
	private void initialize() {
		ComboboxDias.setValue(10);
		ComboboxDias.setValue(15);
		ComboboxDias.setValue(20);
		ComboboxDias.setItems(mainDepartmentList);
	}
	@FXML
	void close(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	void VolverMenu(MouseEvent event) {
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
			Stage mystage = (Stage) this.VolverMenu.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	void Comprar(MouseEvent event) {
		boolean aux;
		String cod = txt_Compra.getText();
		aux = bbdd.HacerPedidos(cod,"COMPRA",0);
		if (aux == true) {
			Resultado.setText("¡Compra realizada con exito!");
		}
		else {
			Resultado.setText("¡Datos incorrectos!");
		}
	}
	@FXML
	void Alquilar(MouseEvent event) {
		boolean aux;
		String cod = txt_Alquiler.getText();
		int dias = ComboboxDias.getValue();
		aux = bbdd.HacerPedidos(cod,"ALQUILER",dias);
		if (aux == true) {
			Resultado.setText("¡Alquiler realizado con exito!");
		}
		else {
			Resultado.setText("¡Datos incorrectos!");
		}
	}
	  @FXML
	    void VerTodos(MouseEvent event) {
		  Todos.setText(bbdd.ListaPedidos());
	    }
	public Object cerrar() {
		return null;
	}

}
