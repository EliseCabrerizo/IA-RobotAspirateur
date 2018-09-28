package aspirateur;

import environnement.*;
import mycanvas.MyCanvas;

public class Capteur {

	public Capteur() {
	}

	public Environnement Observer() {
		return MyCanvas.environnement;
	}

	public int getScore(int energie, int bijoux) {
		return MyCanvas.environnement.calculScore(energie, bijoux);
	}

}
