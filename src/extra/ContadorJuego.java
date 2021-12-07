package extra;

import ui.ExcerciseWindow;

public class ContadorJuego extends Thread {

	private ExcerciseWindow excerciseWindow;
	
	public ContadorJuego(ExcerciseWindow excerciseWindow) {
		this.excerciseWindow=excerciseWindow;
	}
	
	@Override
	public void run() {
		for(int i=30; i>=0; i--) {
			excerciseWindow.tell(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
