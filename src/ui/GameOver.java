package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.TreeName;

public class GameOver extends Stage {

	private Label x;
	private TreeName tn;
	
	
	public GameOver() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
		Parent root = loader.load();
		
		x= (Label) loader.getNamespace().get("x");
		
		Scene scene = new Scene(root,1200,600);
		setScene(scene);
		
		init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
}
