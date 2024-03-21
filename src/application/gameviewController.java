package application;

import java.io.IOException;

import application.WWM.Frage;
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
	Label label1;

	Frage aktuelleFrage;

	public void zeigeFrage(Frage frage) {
		aktuelleFrage = frage;
		label1.setText(frage.getText());
		btnAnswA.setText(frage.getAntwortenListe().get(0).getText());
		btnAnswB.setText(frage.getAntwortenListe().get(1).getText());
		btnAnswC.setText(frage.getAntwortenListe().get(2).getText());
		btnAnswD.setText(frage.getAntwortenListe().get(3).getText());
	}
	
	public void setzeFrage() {
		zeigeFrage(Main.getAktuelleFrage());
	}

	public void btndown_AnswA(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 0) == false) {
			switchToTryAgain(e);
		} else {
			nächsteFrage();
		}
		;
	}
	public void btndown_btnFFJ(ActionEvent e) throws IOException {
		int counter=0;
		while(counter !=2) {
			int rnd = (int)(Math.random()*4);
			if(aktuelleFrage.getAntwortenListe().get(rnd).getIstRichtig()) {
				
			}else {
				counter++;
				String tmp = aktuelleFrage.getAntwortenListe().get(rnd).getText();
					   if (tmp.equals(btnAnswA.getText())) {
						   btnAnswA.setVisible(false);
					// Button A unsichtbar machen
						   System.out.println("A");
				} else if (tmp.equals(btnAnswB.getText())) {
					// Button B unsichtbar machen
					System.out.println("B");
					btnAnswB.setVisible(false);
				} else if (tmp.equals(btnAnswC.getText())) {
					// Button C unsichtbar machen
					System.out.println("C");
					btnAnswC.setVisible(false);
				} else if (tmp.equals(btnAnswD.getText())) {
					// Button D unsichtbar machen
					btnAnswD.setVisible(false);
					System.out.println("D");
				}
				
			}}
		btnFFJ.setVisible(false);
	}

	public void btndown_AnswB(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 1) == false) {
			switchToTryAgain(e);
		} else {
			nächsteFrage();
		}
		;
	}

	public void btndown_AnswC(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 2) == false) {
			switchToTryAgain(e);
		} else {
			nächsteFrage();
		}
		;
	}

	public void btndown_AnswD(ActionEvent e) throws IOException {
		if (Main.antwortAuswertung(aktuelleFrage, 3) == false) {
			switchToTryAgain(e);
		} else {
			nächsteFrage();
		}
		;
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
		stage.show();

	}
}
