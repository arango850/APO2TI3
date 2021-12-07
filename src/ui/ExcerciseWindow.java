package ui;

import java.io.IOException;

import extra.ContadorJuego;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Player;
import model.Random;
import model.TreeName;
import model.TreeeScore;


public class ExcerciseWindow extends Stage{

	private Label time;
	private Label ex;
	private Button b1;
	private Button saltar;
	private Button b2;
	private Button b3;
	private Button b4;
	private Label player;
	
	
	private TreeName nameTree;
	private TreeeScore scoreTree;
	private InicioWindow iw;
	private Player playerr;
	
	private int puntaje =0;

	
	public ExcerciseWindow()  {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ExcerciseWindow .fxml"));
		Parent root= loader.load();
		
		time= (Label) loader.getNamespace().get("time");
		ex= (Label) loader.getNamespace().get("ex");
		b1= (Button) loader.getNamespace().get("b1");
		saltar= (Button) loader.getNamespace().get("saltar");
		b2= (Button) loader.getNamespace().get("b2");
		b3= (Button) loader.getNamespace().get("b3");
		b4= (Button) loader.getNamespace().get("b4");
		player= (Label) loader.getNamespace().get("player");
		
		
		Scene scene = new Scene(root, 1200,600);
		setScene(scene);
		
		init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void init() {
		// TODO Auto-generated method stub
		ContadorJuego j= new ContadorJuego(this);
		j.start();
		crearEjercicio();
		

		saltar.setOnAction(event->{
			crearEjercicio();
		});
		
		
	}

	

	public void tell(int i) {
		// TODO Auto-generated method stub
		String ii= String.valueOf(i);
		Platform.runLater(
				()->{
					time.setText(ii);
					if(i==0) {
						
						GameOver go= new GameOver();
						go.show();
						this.close();
						
					}
				});
	}

	private void crearEjercicio() {
		// TODO Auto-generated method stub
		Random numeros=new Random(0,99);
		Random operadorr= new Random(1,4);
		
		String msg2="";		
		String msg="";
		String operador="";
		int n1=0;
		int n2=0;
		int answer=0;
		
		int aux1= numeros.getRandom();
		int aux2= numeros.getRandom();
		
		int opracion= operadorr.getRandom();
		
		switch(opracion) {
		case 1:
			n1=aux1;
			n2=aux2;
			operador= "+";
			answer=n1+n2;
			crearFakeAnswers(answer);
			break;
		case 2:
			answer= aux1;
			n2=aux2;
			operador="-";
			n1= answer+n2;
			crearFakeAnswers(answer);
			break;
		case 3:
			n1= aux1;
			n2= aux2;
			operador="*";
			answer= n1*n2;
			crearFakeAnswers(answer);
			break;
		default: 
			answer= aux1;
			n2= aux2;
			operador= "/";
			n1= answer*n2;
			crearFakeAnswers(answer);
			break;
		}
	msg2= String.valueOf(answer); 
	msg= n1+operador+n2;
	
	ex.setText(msg);
	
	}

	public void crearFakeAnswers(int answer) {
		// TODO Auto-generated method stub
		Random numeros=new Random(0,10);
		Random numerosesp= new Random(0,answer);
		int fakeAnswer1=0;
		int fakeAnswer2=0;
		int fakeAnswer3=0;
		
		fakeAnswer1= answer+ numeros.getRandom();
		fakeAnswer2= answer- numeros.getRandom();
		fakeAnswer3= answer + numeros.getRandom();
		
		if(fakeAnswer1!=answer && fakeAnswer2!=answer && fakeAnswer3!=answer) {
			laRadomnizacion(answer,fakeAnswer1,fakeAnswer2,fakeAnswer3);
		}else {
			crearFakeAnswers(answer);
		}
		
		
	}

	public void laRadomnizacion(int answer, int fakeAnswer1, int fakeAnswer2, int fakeAnswer3) {
		// TODO Auto-generated method stub
		String msgCorrect= String.valueOf(answer);
		String msgFake1= String.valueOf(fakeAnswer1);
		String msgFake2= String.valueOf(fakeAnswer2);
		String msgFake3= String.valueOf(fakeAnswer3);
		Random org= new Random(1,4);
		int num= org.getRandom();
		
		switch(num) {
			case 1:
				b1.setText(msgCorrect);
				b2.setText(msgFake1);
				b3.setText(msgFake2);
				b4.setText(msgFake3);
				break;
			case 2:
				b1.setText(msgFake1);
				b2.setText(msgCorrect);
				b3.setText(msgFake2);
				b4.setText(msgFake3);
				break;
			case 3:
				b1.setText(msgFake1);
				b2.setText(msgFake2);
				b3.setText(msgCorrect);
				b4.setText(msgFake3);
				break;
			case 4:
				b1.setText(msgFake1);
				b2.setText(msgFake2);
				b3.setText(msgFake3);
				b4.setText(msgCorrect);
				break;
		}
		juego(msgCorrect);
		
	}
	

	
	
	public void juego(String msgCorrect) {
		// TODO Auto-generated method stub
		
		String puntajeString= String.valueOf(puntaje);
		b1.setOnAction(event->{
			if(b1.getText().equals(msgCorrect)) {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje+10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
					
				
			}else {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje-10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
			}
		});
		b2.setOnAction(event->{
			if(b2.getText().equals(msgCorrect)) {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje+10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
				
				
			}else {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje-10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
			}
		});
		b3.setOnAction(event->{
			if(b3.getText().equals(msgCorrect)) {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje+10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
			}else {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje-10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
			}
		});
		b4.setOnAction(event->{
			if(b4.getText().equals(msgCorrect)) {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje+10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
			}else {
				ContadorJuego j= new ContadorJuego(this);
				j.stop();
				puntaje=puntaje-10;
				player.setText(puntajeString);
				
				crearEjercicio();
				j.start();
				
			}
		});
	}

	

	
	
	
	
}
