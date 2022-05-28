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

public class MenuControlador extends inicialControlador{
	@FXML
	private Text cerrar;
	@FXML
	private Button BotonCatalogo;
	@FXML
	private Button botonReparar;
    @FXML
    private Button Pedido;
	@FXML
	void close(MouseEvent event) {
		System.exit(0);
	}
	@FXML
	void Reparar(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsolaRota.fxml"));
			Parent root = loader.load();
			ConsolaControlador controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.cerrar());
			Stage mystage = (Stage) this.botonReparar.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
    void MenuCatalogo(MouseEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Catalogo.fxml"));
			Parent root = loader.load();
			CatalogoControlador controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.cerrar());
			Stage mystage = (Stage) this.BotonCatalogo.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void MenuPedido(MouseEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Pedidos.fxml"));
			Parent root = loader.load();
			PedidosControlador controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.cerrar());
			Stage mystage = (Stage) this.Pedido.getScene().getWindow();
			mystage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public Object cerrar() {
		return null;
	}
}
