package application.controladores;

import application.fisica.MRU;
import application.fisica.Movil;
import application.utiles.Config;
import application.utiles.mru.AyudaMRU;
import application.utiles.mru.ValoresMRU;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PantallaMRUController {

	@FXML private ChoiceBox<String> choiceCalcularSimple, choiceCalcularComplejo1;
	@FXML private TextField txfSimple1, txfSimple2, txfComplejoM11, txfComplejoM12, txfComplejoM21, txfComplejoM22, txfTiempo;
	@FXML private Label lblResultadoSimple, lblRefSimple1, lblRefSimple2, lblComplejoM11, lblComplejoM12, lblComplejoM21, lblComplejoM22, lblComplejoResult;
	
	
	private float valor1, valor2, tiempoEncuentro, valorM11, valorM12, valorM21, valorM22;
	private ValoresMRU aCalcular, aCalcularComplejo;
	private Movil m1, m2;
	private MRU mru;
	
	@FXML
	public void initialize() {

		mru = new MRU();
		
		setUpMRUSimple();
		setUpMRUComplejo();
	}
	
	private void setUpMRUSimple() {
		choiceCalcularSimple.getItems().setAll(AyudaMRU.variablesMRU);
		lblRefSimple1.setText("* Selecccione una variable a calcular");
		lblRefSimple2.setText("* Selecccione una variable a calcular");
		
		choiceCalcularSimple.setOnAction(e->{
			String valor = choiceCalcularSimple.getValue();
			
			switch (valor) {
			case "Tiempo":
				this.aCalcular = ValoresMRU.TIEMPO;
				lblRefSimple1.setText(ValoresMRU.DISTANCIA.getNombre());
				lblRefSimple2.setText(ValoresMRU.VELOCIDAD.getNombre());
				break;

			case "Distancia":
				this.aCalcular = ValoresMRU.DISTANCIA;
				lblRefSimple1.setText(ValoresMRU.TIEMPO.getNombre());
				lblRefSimple2.setText(ValoresMRU.VELOCIDAD.getNombre());
				break;
			case "Velocidad":
				this.aCalcular = ValoresMRU.VELOCIDAD;
				lblRefSimple1.setText(ValoresMRU.DISTANCIA.getNombre());
				lblRefSimple2.setText(ValoresMRU.TIEMPO.getNombre());
				break;
			
			case "":
				lblRefSimple1.setText("Selecccione una variable a calcular");
				lblRefSimple2.setText("Selecccione una variable a calcular");
				break;
			}
		
			lblResultadoSimple.setText("");
			txfSimple1.clear();
			txfSimple2.clear();
		});
		
		txfSimple1.setOnKeyReleased(e ->{
			valor1 = Float.valueOf(txfSimple1.getText());
			calcularMRUSimple();
		});
		
		txfSimple2.setOnKeyReleased(e ->{
			valor2 = Float.valueOf(txfSimple2.getText());
			calcularMRUSimple();
		});
		
	}
	
	private void calcularMRUSimple() {
		if(!txfSimple1.getText().isBlank() && !txfSimple2.getText().isBlank()) {
			float resultado;
			switch (aCalcular) {
			case DISTANCIA:
				
				resultado = mru.calcularPosicion(valor2, valor1);
				lblResultadoSimple.setText("La distancia es de " + resultado + "Mts.");
				break;

			case TIEMPO:
				resultado = mru.calcularTiempo(valor1, valor2);
				lblResultadoSimple.setText("Tardo " + resultado + " segundos en recorrer " + valor1+ "Mts.");
				break;
			
			case VELOCIDAD:
				resultado = mru.calcularVelocidad(valor1, valor2);
				lblResultadoSimple.setText("La velocidad del movil es " + resultado + "m/s. ");
				break;
				
				
			}
			

		}
	}
	
	
	private void setUpMRUComplejo() {
		choiceCalcularComplejo1.getItems().setAll(AyudaMRU.variablesMRU);
		
		choiceCalcularComplejo1.setOnAction(e->{
			String valor = choiceCalcularComplejo1.getValue();
			txfTiempo.setDisable(false);
			m1 = new Movil();
			m2 = new Movil();
			switch (valor) {
			case "Tiempo":
				this.aCalcularComplejo = ValoresMRU.TIEMPO;
				txfTiempo.setDisable(true);
				lblComplejoM11.setText(ValoresMRU.POSI.getNombre());
				lblComplejoM12.setText(ValoresMRU.VELOCIDAD.getNombre());
				lblComplejoM21.setText(ValoresMRU.POSI.getNombre());
				lblComplejoM22.setText(ValoresMRU.VELOCIDAD.getNombre());
				break;

			case "Distancia":
				this.aCalcularComplejo = ValoresMRU.DISTANCIA;
				lblComplejoM11.setText(ValoresMRU.POSI.getNombre());
				lblComplejoM12.setText(ValoresMRU.VELOCIDAD.getNombre());
				lblComplejoM21.setText(ValoresMRU.POSI.getNombre());
				lblComplejoM22.setText(ValoresMRU.VELOCIDAD.getNombre());
			
				
				break;
			case "Velocidad":
				this.aCalcularComplejo = ValoresMRU.VELOCIDAD;
				lblComplejoM11.setText(ValoresMRU.POSI.getNombre());
				lblComplejoM12.setText(ValoresMRU.TIEMPO.getNombre());
				lblComplejoM21.setText(ValoresMRU.POSI.getNombre());
				lblComplejoM22.setText("Ingrese el tiempo en el otro campo de texto");
				break;
			
			case "":

				break;
			}
			
			calcularMRUComplejo();
		});
		
		txfComplejoM11.setOnKeyReleased(e->{
			valorM11 = Float.valueOf(txfComplejoM11.getText());
			calcularMRUComplejo();
		});
		
		txfComplejoM12.setOnKeyReleased(e->{
			valorM12 = Float.valueOf(txfComplejoM12.getText());
			calcularMRUComplejo();
		});
		
		txfComplejoM21.setOnKeyReleased(e->{
			valorM21 = Float.valueOf(txfComplejoM21.getText());
			calcularMRUComplejo();
		});
		
		txfComplejoM22.setOnKeyReleased(e->{
			valorM22 = Float.valueOf(txfComplejoM22.getText());
			calcularMRUComplejo();
		});
		
		txfTiempo.setOnKeyReleased(e->{
			if(!txfTiempo.getText().isBlank()) {				
			tiempoEncuentro = Float.valueOf(txfTiempo.getText());
			}
		});
	}
	
	private void calcularMRUComplejo() {
		if((!txfComplejoM11.getText().isBlank() && !txfComplejoM12.getText().isBlank()) && (!txfComplejoM21.getText().isBlank() && !txfComplejoM22.getText().isBlank())) {
			float resultado;
			
			
			switch (aCalcularComplejo) {
			case DISTANCIA:
				
				m1.setPos(valorM11);
				m1.setVel(valorM12);
				m2.setPos(valorM21);
				m2.setVel(valorM22);
				float tiempoE = mru.calcularMomentoDeEncuentro(m1, m2);
				resultado = mru.calcularPuntoDeEncuentro(m1, m2);
				lblComplejoResult.setText("Los moviles se encuentran en " + resultado + "Mts y tardaron " + tiempoE + "s.");
				break;

			case TIEMPO:
				m1.setPos(valorM11);
				m1.setVel(valorM12);
				m2.setPos(valorM21);
				m2.setVel(valorM22);
				
				resultado = mru.calcularMomentoDeEncuentro(m1, m2);
				lblComplejoResult.setText("Los moviles se encuentran a los " + resultado + "s.");
				break;
			
			case VELOCIDAD:
				resultado = mru.calcularVelocidad(valor1, valor2);
				lblResultadoSimple.setText("La velocidad del movil es " + resultado + "m/s. ");
				break;
				
				
			}
			

		}
	}
	
	
}
