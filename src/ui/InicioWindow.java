package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.NodeScore;
import model.Player;
import model.TreeName;
import model.TreeeScore;

public class InicioWindow extends Stage {

	private TextField nameTF;
	private Button button;
	
	TreeeScore nodeTreeScore= new TreeeScore();
	TreeName treeName= new TreeName();
	
	ExcerciseWindow ew= new ExcerciseWindow();
	
	public InicioWindow() throws IOException {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("InicioWindow.fxml"));
		Parent root= loader.load();
		
		nameTF= (TextField) loader.getNamespace().get("nameTF");
		button= (Button) loader.getNamespace().get("button");
		
		Scene scene = new Scene(root,1200,600);
		setScene(scene);
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		button.setOnAction(
				event->{
						if(nameTF.getText().equals("")) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Error");
							alert.setHeaderText("No se ingresó un nombre de usuario");
							alert.setContentText("Vuelvalo a interalo");

							alert.showAndWait();
						}else {
							String name= nameTF.getText();
							Player p= new Player(0,name);
							treeName.insert(name,p);
							
							RulesWindow rw;
							try {
								rw = new RulesWindow();
								rw.show();
								this.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
		}
				);
	}

	public TextField getNameTF() {
		return nameTF;
	}

	public void setNameTF(TextField nameTF) {
		this.nameTF = nameTF;
	}
	
}
