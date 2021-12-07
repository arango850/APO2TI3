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
			out = "La divisi�n entre 0\n es indefinida";
			return out;
		}else if(n==2) {
			out= "Multiplicar unos siempre te da\n"+
					"n�meros palindr�micos";
			return out;
		}else if(n==3) {
			out= "El n�mero m�s curioso es el 142857";
			return out;
		}else if(n==4) {
			out= "El n�mero 5 tiene el mismo\n n�mero de letras que expresa:\n cinco";
			return out;
		}else if(n==5) {
			out= "El cero fue descubierto en la India\n los �rabes lo trasladaron a Europa\n"+
					 "Proviene de la palabra �rabe sifr que significa vac�a";
			return out;
		}else if(n==6) {
			out= "La palabra �multiplicar� viene del lat�n multiplicare\n y significa �aumentar el n�mero de la misma cosa�\n.";
		}
		return out;
	}

	public ContadorCargador(ChargeWindow chargeWindow) {
		this.chargeWindow=chargeWindow;
	}
}
