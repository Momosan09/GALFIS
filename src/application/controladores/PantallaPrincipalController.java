package application.controladores;

import java.io.IOException;

import application.utiles.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class PantallaPrincipalController {

	
	@FXML private Button mruBtn;
	@FXML private Button mruvBtn;
	@FXML private Button mcuBtn;
	@FXML private Button mcuvBtn;
	
	
	@FXML
	public void initialize() {
		
		mruBtn.setOnAction(e ->{
			cambiarPantalla("mru.fxml");
		});
		
		mruvBtn.setOnAction(e ->{
			System.out.println("hola2");
//			cambiarPantalla("mruv.fxml");
		});
		
		mcuBtn.setOnAction(e ->{
			System.out.println("hola3");
		});
		
		mcuvBtn.setOnAction(e ->{
			System.out.println("hola4");
		});
		
	}
	
	
	private void cambiarPantalla(String nombre) {
		try {
			AnchorPane pantalla;
			pantalla = FXMLLoader.load(getClass().getResource("/application/res/"+ nombre));
			((BorderPane) Config.scene.getRoot()).setCenter(pantalla);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	
}
