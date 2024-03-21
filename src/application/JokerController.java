package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JokerController {
	private Stage stage;
	private Scene scene;
	private Parent root2;

	@FXML
	Button btnPSJ;
	@FXML
	Button btnTNJ;
	@FXML
	Button btnFFJ;
	@FXML
	Label lblJoker;

	@FXML
	Button btnLeave;
	
	
	public void btndown_FFJ(ActionEvent e) throws IOException {
		FXMLLoader scene2Loader = new FXMLLoader(getClass().getResource("Game.fxml"));
		Parent root2 = scene2Loader.load();
		gameviewController sceneController = scene2Loader.getController();
		
		sceneController.zeigeFrage(Main.nF());
		
		int counter=0;
		while(counter !=2) {
			int rnd = (int)(Math.random()*3);
			if(sceneController.aktuelleFrage.getAntwortenListe().get(rnd).getIstRichtig()) {
				
			}else {
				counter++;
				String tmp = sceneController.aktuelleFrage.getAntwortenListe().get(rnd).getText();
					   if (tmp.equals(sceneController.btnAnswA.getText())) {
						   sceneController.btnAnswA.setVisible(false);
					// Button A unsichtbar machen
						   System.out.println("A");
				} else if (tmp.equals(sceneController.btnAnswB.getText())) {
					// Button B unsichtbar machen
					System.out.println("B");
					sceneController.btnAnswB.setVisible(false);
				} else if (tmp.equals(sceneController.btnAnswC.getText())) {
					// Button C unsichtbar machen
					System.out.println("C");
					sceneController.btnAnswC.setVisible(false);
				} else if (tmp.equals(sceneController.btnAnswD.getText())) {
					// Button D unsichtbar machen
					sceneController.btnAnswD.setVisible(false);
					System.out.println("D");
				}
				
			}
		}
		
		btndown_Leave(e);
		
		
		
		
	}
	
public void btndown_Leave(ActionEvent event) throws IOException {
	root2 = FXMLLoader.load(getClass().getResource("Game.fxml"));
	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	scene = new Scene(root2);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	stage.setScene(scene);
	FXMLLoader scene2Loader = new FXMLLoader(getClass().getResource("Game.fxml"));
	root2 = scene2Loader.load();
	gameviewController sceneController = scene2Loader.getController();
	
	stage.show();

	sceneController.setzeFrage();
	
	
	
	}
}
