package application;

import java.io.IOException;

import application.WWM.WWM;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class tryAgainController {
	private Stage stage;
	private Scene scene;
	private Parent root2;

	public void btndown_Close(ActionEvent e) {
		
		Platform.exit();
		System.exit(0);
	}
	public void btndown_New(ActionEvent event) throws IOException {
		
		Main.neuesSpiel();
		root2 = FXMLLoader.load(getClass().getResource("Main.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root2);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
}
