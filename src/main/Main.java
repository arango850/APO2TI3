package main;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.ChargeWindow;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ChargeWindow ch= new ChargeWindow();
		ch.show();
	}

}
