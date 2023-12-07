package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root2;
	
	
	
	public void btndown_AnswA(ActionEvent e) {
		
	}
	public void btndown_AnswB(ActionEvent e) {
		
	}
	public void btndown_AnswC(ActionEvent e) {
	
	}
	public void btndown_AnswD(ActionEvent e) {
	
	}
	
	
	
	public void switchToSetJoker(ActionEvent event) throws IOException {
		
		    root2 = FXMLLoader.load(getClass().getResource("prevMenu.fxml"));
		    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root2);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        stage.setScene(scene);
	        stage.show();
	        System.out.println("Succed!");
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
		 
	public void switchToGameView(ActionEvent event) throws IOException {
		root2 = FXMLLoader.load(getClass().getResource("Game.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root2);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

}
