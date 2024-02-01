package application;

import java.io.IOException;

import application.WWM.Stufe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root2;
	
	@FXML ToggleGroup   VBox; 
	
	
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
	
	public void ssBestaetigen(ActionEvent e) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("prevMenu.fxml"));
		Parent root = loader.load();
		
		RadioButton selectedRadioButton = (RadioButton) VBox.getSelectedToggle();
		String toogleGroupValue = selectedRadioButton.getText();
		System.out.print(toogleGroupValue);
	
            Stufe stufe = new Stufe();
            if (selectedRadioButton.getText().equals("50€"))        {
                stufe = new Stufe(1);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(2);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(3);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(4);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(5);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(6);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(7);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(8);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(9);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(10);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(11);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(12);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(13);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(14);
            } else if (selectedRadioButton.getText().equals("50€")) {
                stufe = new Stufe(15);
            }
            /*if (aktuellesSpiel.getSicherheitsStufe1()==null) {
                if (stufe.getLevel()!=0 && stufe.getGeld()!=0 && stufe.getGeldString()!=null) {
                    aktuellesSpiel.setSicherheitsStufe1(stufe);
                    
				}
          	}*/
            Main.ssSetzen(stufe);
	}

}
