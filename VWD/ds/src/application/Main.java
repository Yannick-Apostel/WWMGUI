package application;

	
import application.WWM.altGUI;

import java.sql.SQLException;

import application.WWM.Frage;
import application.WWM.Spiel;
import application.WWM.Stufe;
import application.WWM.WWM;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root1 = FXMLLoader.load(getClass().getResource("Main.fxml"));
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		wwm = new WWM();
		wwm.erstelleSpiel();
		launch(args);
	}
	
	public static void ssSetzen(Stufe stufe) {
		if (wwm.getAktuellesSpiel().getSicherheitsStufe1()==null && stufe.getLevel()!=0) {
                wwm.getAktuellesSpiel().setSicherheitsStufe1(stufe);
                System.out.println(wwm.getAktuellesSpiel().getSicherheitsStufe1().getGeld());
      	} else if (wwm.getAktuellesSpiel().getSicherheitsStufe2()==null && stufe.getGeld()>=wwm.getAktuellesSpiel().getSicherheitsStufe1().getGeld() && stufe.getLevel()!=0) {
      		wwm.getAktuellesSpiel().setSicherheitsStufe2(stufe);
      		System.out.println(wwm.getAktuellesSpiel().getSicherheitsStufe2().getGeld());
      		
      	}
	}
	
	public static Object nF() {
		if(wwm.getAktuellesSpiel().getAktuelleFrage()<14) {
			 return wwm.getAktuellesSpiel().getNächsteFrage();
		}else {
			System.out.println("Spiel vorbei - Gewonnen");
		}
		return null;
	}
	public static Object getAktuelleFrage() {
		if(wwm.getAktuellesSpiel().getAktuelleFrage()<15) {
			return wwm.getAktuellesSpiel().getFrageNr(wwm.getAktuellesSpiel().getAktuelleFrage());
		}
		else {
			System.out.println("Spiel vorbei - Gewonnen");
		}
		return null;
	}
	
	public static Spiel getAktuellesSpiel() {
		return wwm.getAktuellesSpiel();
	}
	
	public static boolean antwortAuswertung(Frage aktuelleFrage, int antwort) {
        if (aktuelleFrage.getAntwortenListe().get(antwort).getIstRichtig()==true) {
        	System.out.print("Richtig");
            return true;
        } else {
        	System.out.print("Falsch");
            return false;
        }
    }
	
	public static void neuesSpiel() {
		wwm.addSpielToSpielHistorie(wwm.getAktuellesSpiel());
		wwm.erstelleSpiel();
	}
	public static int getGeld() {
		return wwm.getGewonnenesGeld();
	}
	public static void setGeld(int geld) {
		wwm.setGewonnenesgeld(geld);
	}
	
}
