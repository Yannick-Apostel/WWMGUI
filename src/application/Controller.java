package application;


import java.io.IOException;

import application.WWM.Stufe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root2;
	
	private int countBestätigen=0;
	@FXML ToggleGroup   VBox; 
	 
	
	
	
	
	
	
	
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
		 
	
	
	
	
	public void ssBestaetigen(ActionEvent e) throws IOException {
		countBestätigen++;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("prevMenu.fxml"));
		Parent root = loader.load();
		
		
		
		
		RadioButton selectedRadioButton = (RadioButton) VBox.getSelectedToggle();
		String toogleGroupValue = selectedRadioButton.getText();
	
            Stufe stufe = new Stufe();
            if (selectedRadioButton.getText().equals("50€"))        {
                stufe = new Stufe(1);
            } else if (selectedRadioButton.getText().equals("100€")) {
                stufe = new Stufe(2);
            } else if (selectedRadioButton.getText().equals("200€")) {
                stufe = new Stufe(3);
            } else if (selectedRadioButton.getText().equals("300€")) {
                stufe = new Stufe(4);
            } else if (selectedRadioButton.getText().equals("500€")) {
                stufe = new Stufe(5);
            } else if (selectedRadioButton.getText().equals("1.000€")) {
                stufe = new Stufe(6);
            } else if (selectedRadioButton.getText().equals("2.000€")) {
                stufe = new Stufe(7);
            } else if (selectedRadioButton.getText().equals("4.000€")) {
                stufe = new Stufe(8);
            } else if (selectedRadioButton.getText().equals("8.000€")) {
                stufe = new Stufe(9);
            } else if (selectedRadioButton.getText().equals("16.000€")) {
                stufe = new Stufe(10);
            } else if (selectedRadioButton.getText().equals("32.000€")) {
                stufe = new Stufe(11);
            } else if (selectedRadioButton.getText().equals("64.000€")) {
                stufe = new Stufe(12);
            } else if (selectedRadioButton.getText().equals("125.000€")) {
                stufe = new Stufe(13);
            } else if (selectedRadioButton.getText().equals("500.000€")) {
                stufe = new Stufe(14);
            } else if (selectedRadioButton.getText().equals("1.000.000€")) {
                stufe = new Stufe(15);
            } else {
            	stufe = new Stufe(0);
            	System.out.println("Lol");
            }
            
            
            
            Main.ssSetzen(stufe);
            if(countBestätigen ==2) {
            	switchToGameView(e);
            }
	}
	
	
	public void switchToGameView(ActionEvent event) throws IOException {
		FXMLLoader scene2Loader = new FXMLLoader(getClass().getResource("Game.fxml"));
		Parent root4 = scene2Loader.load();
		gameviewController scene2Controller = scene2Loader.getController();
		
		scene2Controller.zeigeFrage();
		
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root4);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
			
		
		
		//Main.naechsteFrage(lblQuestion);
	}
	
	public void switchToMenu(ActionEvent event) throws IOException {
		root2 = FXMLLoader.load(getClass().getResource("Main.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root2);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
	
	
	
	

}
