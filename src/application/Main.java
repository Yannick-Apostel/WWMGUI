package application;

	
import application.WWM.altGUI;
import application.WWM.Stufe;
import application.WWM.WWM;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root1 = FXMLLoader.load(getClass().getResource("prevMenu.fxml"));
			Scene scene = new Scene(root1);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args) {
		launch(args);
	}*/

	
	private static WWM wwm;

	public static void main(String[] args) {
		wwm = new WWM();
		wwm.erstelleSpiel();
		launch(args);
	}
	
	public static void ssSetzen(Stufe stufe) {
		if (wwm.getAktuellesSpiel().getSicherheitsStufe1()==null) {
            if (stufe.getLevel()!=0 && stufe.getGeld()!=0 && stufe.getGeldString()!=null) {
                wwm.getAktuellesSpiel().setSicherheitsStufe1(stufe);
			}
      	}
	}
}
