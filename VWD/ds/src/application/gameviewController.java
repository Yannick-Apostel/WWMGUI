package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import application.WWM.Frage;
import application.WWM.Spiel;
import application.WWM.WWM;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class gameviewController {

	private Stage stage;
	private Scene scene;
	private Parent root2;

	@FXML
	Button btnAnswA;
	@FXML
	Button btnAnswB;
	@FXML
	Button btnAnswC;
	@FXML
	Button btnAnswD;
	@FXML
	Button btnLeave;
	@FXML
	Button btnPJ;
	@FXML
	Button btnFFJ;
	@FXML
	Button btnTJ;
	@FXML
	Button btnRestart;
	@FXML
	Label label1;
	
	private Frage aktuelleFrage;

	public void zeigeFrage(Object frage) {
		try {
			aktuelleFrage = (Frage) frage;
		label1.setText(((Frage) frage).getText());
		btnAnswA.setText("A: " + ((Frage) frage).getAntwortenListe().get(0).getText());
		btnAnswB.setText("B: " + ((Frage) frage).getAntwortenListe().get(1).getText());
		btnAnswC.setText("C: " + ((Frage) frage).getAntwortenListe().get(2).getText());
		btnAnswD.setText("D: " + ((Frage) frage).getAntwortenListe().get(3).getText());
		if (Main.getAktuellesSpiel().getFiftyfiftyjoker() == false) {
			btnAnswA.setVisible(true);
			btnAnswB.setVisible(true);
			btnAnswC.setVisible(true);
			btnAnswD.setVisible(true);
		}
		}catch (Exception e) {
			btnRestart.setVisible(true);
			label1.setText("Sie haben gewonnen");
			btnAnswA.setVisible(false);
			btnAnswB.setVisible(false);
			btnAnswC.setVisible(false);
			btnAnswD.setVisible(false);
			btnPJ.setVisible(false);
			btnFFJ.setVisible(false);
			btnTJ.setVisible(false);
		}
		
	}
	
	public void setzeFrage() {
		try {
			zeigeFrage((Frage)(Main.getAktuelleFrage()));
		}catch(Exception e) {
			// Anahme es wurde gewonnen
			
		}
		
	}

	public void btndown_AnswA(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 0) == false) {
			if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe2().getLevel())-1) {
				Main.setGeld(Main.getAktuellesSpiel().getSicherheitsStufe2().getGeld());
				System.out.println("Sicherheitstufe 2");
			}else if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe1().getLevel())-1) {
				System.out.println("Sicherheitstufe 1");
				Main.setGeld(Main.getAktuellesSpiel().getSicherheitsStufe1().getGeld());
			}
			switchToTryAgain(e);
			
		} else {
			nächsteFrage();
		}
		;
		
		
	}
public void btndown_Restart(ActionEvent event) throws IOException {
		
		Main.neuesSpiel();
		root2 = FXMLLoader.load(getClass().getResource("Main.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root2);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
	
	public void btndown_btnFFJ(ActionEvent e) throws IOException {
		if (Main.getAktuellesSpiel().getFiftyfiftyjoker()) {
		int counter=0;
		int rnd = -1;
		int firstRnd = rnd;
		while(counter !=2) {
			if(counter == 1 && aktuelleFrage.getAntwortenListe().get(rnd).getIstRichtig() == false) {
				firstRnd = rnd;
			}
			rnd = (int)(Math.random()*4);
			if (rnd != firstRnd) {
				if(aktuelleFrage.getAntwortenListe().get(rnd).getIstRichtig() == false) {
					counter++;
					String tmp = aktuelleFrage.getAntwortenListe().get(rnd).getText();
					String tmpA = "A: " + tmp;
					String tmpB = "B: " + tmp;
					String tmpC = "C: " + tmp;
					String tmpD = "D: " + tmp;
					
					if (tmpA.equals(btnAnswA.getText())) {
						btnAnswA.setVisible(false);
					} else if (tmpB.equals(btnAnswB.getText())) {
						btnAnswB.setVisible(false);
					} else if (tmpC.equals(btnAnswC.getText())) {
						btnAnswC.setVisible(false);
					} else if (tmpD.equals(btnAnswD.getText())) {
						btnAnswD.setVisible(false);
					}
				}
			}
		}
		btnFFJ.setVisible(false);
		Main.getAktuellesSpiel().setFiftyfiftyjoker(false);
		}
	}
	
	public void btndown_btnPJ(ActionEvent e) throws IOException {
		//btnPJ.setVisible(false);
		// TODO: nach pj auf true abfragen und pf am ende auf false setzen + pj button verstecken
		int counterA=0;
		int counterB=0;
		int counterC=0;
		int counterD=0;
		
		int rngRichtigeAntwort = (int)(Math.random() * ((75 - 25) + 1) + 25); // int rng = (int)(Math.random() * ((max - min) + 1) + min)
        int rngFalscheAntwort1 = (int)(Math.random() * ((100 - rngRichtigeAntwort) + 1));
        int rngFalscheAntwort2 = (int)(Math.random() * ((100 - rngRichtigeAntwort - rngFalscheAntwort1) + 1));
        int rngFalscheAntwort3 = 100 - rngRichtigeAntwort - rngFalscheAntwort1 - rngFalscheAntwort2;
		
        int rIndex = 0;
        for (int i = 0 ; i<aktuelleFrage.getAntwortenListe().size() ; i++) {
            if (aktuelleFrage.getAntwortenListe().get(i).getIstRichtig()) {
            	switch(i) {
                case 0: counterA = rngRichtigeAntwort; break;
                case 1: counterB = rngRichtigeAntwort; break;
                case 2: counterC = rngRichtigeAntwort; break;
                case 3: counterD = rngRichtigeAntwort; break;
            	}
            }
            else {
            	switch (rIndex) {
            		case 0: switch (i) {
            			case 0: counterA = rngFalscheAntwort1; break;
            			case 1: counterB = rngFalscheAntwort1; break;
            			case 2: counterC = rngFalscheAntwort1; break;
            			case 3: counterD = rngFalscheAntwort1; break;
            		}; break;
            		case 1: switch (i) {
            			case 0: counterA = rngFalscheAntwort2; break;
            			case 1: counterB = rngFalscheAntwort2; break;
            			case 2: counterC = rngFalscheAntwort2; break;
            			case 3: counterD = rngFalscheAntwort2; break;
            		}; break;
            		case 2: switch (i) {
            			case 0: counterA = rngFalscheAntwort3; break;
            			case 1: counterB = rngFalscheAntwort3; break;
            			case 2: counterC = rngFalscheAntwort3; break;
            			case 3: counterD = rngFalscheAntwort3; break;
            		}; break;
            	}
            	rIndex++;
            }
        }
        
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PJ_BarChart.fxml"));
		Parent root1 = (Parent)fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.show();
		BarChartController sceneController = fxmlLoader.getController();
		
		sceneController.erstelle(counterA, counterB, counterC, counterD);
	}
	public void btndown_btnTJ(ActionEvent e) throws IOException {
		if (Main.getAktuellesSpiel().getTelefonjoker()) {
			Main.getAktuellesSpiel().setTelefonjoker(false);
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelefonJoker.fxml"));
			Parent root1 = (Parent)fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
			
			btnTJ.setVisible(false);
		}
	}
	

	public void btndown_AnswB(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 1) == false) {
			if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe2().getLevel())-1) {
				Main.setGeld(Main.getAktuellesSpiel().getSicherheitsStufe2().getGeld());
				System.out.println("Sicherheitstufe 2");
			}else if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe1().getLevel())-1) {
				System.out.println("Sicherheitstufe 1");
				Main.setGeld(Main.getAktuellesSpiel().getSicherheitsStufe1().getGeld());
			}
			switchToTryAgain(e);
		} else {
			nächsteFrage();
		}
		;
	}

	public void btndown_AnswC(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 2) == false) {
			if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe2().getLevel())-1) {
				Main.setGeld(Main.getAktuellesSpiel().getSicherheitsStufe2().getGeld());
				System.out.println("Sicherheitstufe 2");
			}else if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe1().getLevel())-1) {
				System.out.println("Sicherheitstufe 1");
				Main.setGeld(Main.getAktuellesSpiel().getSicherheitsStufe1().getGeld());
			}
			switchToTryAgain(e);
		} else {
			nächsteFrage();
		}
		;
	}

	public void btndown_AnswD(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 3) == false) {
			if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe2().getLevel())-1) {
				Main.setGeld(((Main.getAktuellesSpiel().getSicherheitsStufe2())).getGeld());
				System.out.println("Sicherheitstufe 2");
			}else if(((Frage)(Main.getAktuelleFrage())).getStufe().getLevel() >= (Main.getAktuellesSpiel().getSicherheitsStufe1().getLevel())-1) {
				System.out.println("Sicherheitstufe 1");
				Main.setGeld(Main.getAktuellesSpiel().getSicherheitsStufe1().getGeld());
			}
			switchToTryAgain(e);
		} else {
			nächsteFrage();
		};
	}

	public void btndown_leave(ActionEvent e) throws IOException {
		Platform.exit();
		System.exit(0);
	}

	public void nächsteFrage() {

		zeigeFrage(Main.nF());
	}

	public void switchToJoker(ActionEvent event) throws IOException {
		root2 = FXMLLoader.load(getClass().getResource("Joker.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root2);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		System.out.println("Succed!");
	}

	public void switchToTryAgain(ActionEvent event) throws IOException {
		root2 = FXMLLoader.load(getClass().getResource("tryAgain.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root2);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		FXMLLoader scene2Loader = new FXMLLoader(getClass().getResource("tryAgain.fxml"));
		root2 = scene2Loader.load();
		tryAgainController sceneController = scene2Loader.getController();
		stage.show();
		sceneController.setzeText();
		

	}
}
