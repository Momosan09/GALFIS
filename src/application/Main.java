package application;
	
import application.fisica.MRU;
import application.fisica.Movil;
import application.utiles.Config;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	private MRU mru = new MRU();
	private Movil m1 = new Movil(-1f, 10);
	private Movil m2 = new Movil(1f,0);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			
			
			AnchorPane pantallaPrincipal = FXMLLoader.load(getClass().getResource("/application/res/pantallaPrincipal.fxml"));
			root.setCenter(pantallaPrincipal);
			Scene scene = new Scene(root,600,400);
			Config.scene = scene;
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
