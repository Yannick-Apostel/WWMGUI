package application;

import java.io.IOException;

import application.WWM.Frage;
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
	
	@FXML Button btnAnswA; 
	@FXML Button btnAnswB; 
	@FXML Button btnAnswC; 
	@FXML Button btnAnswD; 
	@FXML Label label1;
	
	Frage aktuelleFrage;
	public void zeigeFrage(Frage frage) {
		aktuelleFrage = frage;
		label1.setText(frage.getText());
		btnAnswA.setText(frage.getAntwortenListe().get(0).getText());
		btnAnswB.setText(frage.getAntwortenListe().get(1).getText());
		btnAnswC.setText(frage.getAntwortenListe().get(2).getText());
		btnAnswD.setText(frage.getAntwortenListe().get(3).getText());
	}
	
	public void btndown_AnswA(ActionEvent e) {
		Main.antwortAuswertung(aktuelleFrage, 0);
	}
	public void btndown_AnswB(ActionEvent e) {
		Main.antwortAuswertung(aktuelleFrage, 1);
	}
	public void btndown_AnswC(ActionEvent e) {
		Main.antwortAuswertung(aktuelleFrage, 2);
	}
	public void btndown_AnswD(ActionEvent e) {
		Main.antwortAuswertung(aktuelleFrage, 3);
	}
	
public void switchToJoker(ActionEvent event) throws IOException {
		
	    root2 = FXMLLoader.load(getClass().getResource("Joker.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root2);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        System.out.println("Succed!");
	 } 
}
