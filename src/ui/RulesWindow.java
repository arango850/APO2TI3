package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RulesWindow extends Stage {

		private Button go;
		private Button back;
	
		public RulesWindow() throws IOException{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RulesWindoe.fxml"));
			Parent root= loader.load();
			go= (Button) loader.getNamespace().get("go");
			back= (Button) loader.getNamespace().get("back");
			Scene scene= new Scene(root,1200,600);
			setScene(scene);
			
			init();
		}

		public void init() {
			// TODO Auto-generated method stub
			go.setOnAction(event->{
				ExcerciseWindow ew= new ExcerciseWindow();
				ew.show();
				this.close();
				
			});
			
			back.setOnAction(event->{
				InicioWindow iw;
				try {
					iw = new InicioWindow();
					iw.show();
					this.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
		}
	
}
