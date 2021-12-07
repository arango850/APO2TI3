package ui;

import java.io.IOException;

import extra.ContadorCargador;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class ChargeWindow extends Stage {

	private ProgressBar progress;
	private Label label;
	
	public ChargeWindow() throws IOException {
	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChargeWindow.fxml"));
		Parent root = loader.load();
		
		progress= (ProgressBar) loader.getNamespace().get("progress");
		label= (Label) loader.getNamespace().get("label");
		
		Scene scene= new Scene(root, 1200,600);
		setScene(scene);
		
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		progress.setProgress(0.1);
		ContadorCargador c=  new ContadorCargador(this);
		c.start();
	}

	

	public void tell(int i, String mMensaje) {
		// TODO Auto-generated method stub
		double ii=(double) i/10;
		// TODO Auto-generated method stub
		Platform.runLater(
				()->{
					progress.setProgress(ii);
					label.setText(mMensaje);
					if(i==10) {
						InicioWindow sc;
						try {
							sc = new InicioWindow();
							sc.show();
							this.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
	}
	
}
