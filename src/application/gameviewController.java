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

public class gameviewController {
	
	private Stage stage;
	private Scene scene;
	private Parent root2;
	@FXML 
	Button btnAnswA; 
	@FXML Label label1;
	
	public void zeigeFrage() {
		System.out.print("Ha");
		label1.setText("Hallo");
	}
	
public void btndown_AnswA(ActionEvent e) {
		
	}
	public void btndown_AnswB(ActionEvent e) {
		
	}
	public void btndown_AnswC(ActionEvent e) {
	
	}
	public void btndown_AnswD(ActionEvent e) {
	
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
