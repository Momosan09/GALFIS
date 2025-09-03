package application;
	
import application.fisica.MRU;
import application.fisica.Movil;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	private MRU mru = new MRU();
	private Movil m1 = new Movil(-1f, 10);
	private Movil m2 = new Movil(1f,0);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			

			System.out.println("La velocidad del movil es de " + m1.getVelocidad() + " m/s");
			
			System.out.println("Los moviles se encontraron a los "+mru.calcularMomentoDeEncuentro(m1, m2)+" segundos");
			
			System.out.println("Los moviles se encontraron en el punto " + mru.calcularPuntoDeEncuentro(m1, m2));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
