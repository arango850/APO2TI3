package extra;

import ui.ChargeWindow;

public class ContadorCargador extends Thread {

	private ChargeWindow chargeWindow;
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			String t= mMensaje();
			chargeWindow.tell(i,t);
			
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String mMensaje() {
		// TODO Auto-generated method stub
		String out= "";
		
		int n=0;
		n= 1+(int) (Math.random()*6+1);
		if(n==1) {
			out = "La división entre 0\n es indefinida";
			return out;
		}else if(n==2) {
			out= "Multiplicar unos siempre te da\n"+
					"números palindrómicos";
			return out;
		}else if(n==3) {
			out= "El número más curioso es el 142857";
			return out;
		}else if(n==4) {
			out= "El número 5 tiene el mismo\n número de letras que expresa:\n cinco";
			return out;
		}else if(n==5) {
			out= "El cero fue descubierto en la India\n los árabes lo trasladaron a Europa\n"+
					 "Proviene de la palabra árabe sifr que significa vacía";
			return out;
		}else if(n==6) {
			out= "La palabra “multiplicar” viene del latín multiplicare\n y significa “aumentar el número de la misma cosa”\n.";
		}
		return out;
	}

	public ContadorCargador(ChargeWindow chargeWindow) {
		this.chargeWindow=chargeWindow;
	}
}
