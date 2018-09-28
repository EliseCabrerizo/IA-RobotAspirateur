package aspirateur;

import java.util.ArrayList;

import environnement.Environnement;
import mycanvas.MyCanvas;

public class Effecteur {

	public Effecteur() {
	}

	public boolean Aspirer(int posX, int posY) {
		return MyCanvas.environnement.aspiration(posX, posY);
	}

	public boolean Prendre(int posX, int posY) {
		return MyCanvas.environnement.prendreBijoux(posX, posY);
	}

	public int[] TrouverPoussiere(int posX, int posY) {
		int couche = 0;
		boolean trouverProche = false;
		int[] posPoussiere = new int[] {0, 0};
		while (!trouverProche && couche<MyCanvas.environnement.getTaille()) {
			//Verification emplacement
			if(MyCanvas.environnement.getCase(posX, posY).getPoussiere())
			{
				trouverProche = true;
				posPoussiere = new int[] { posX, posY };
			}
			// Verification poussiere à droite
			if (posX + couche + 1 < MyCanvas.environnement.getTaille()&&!trouverProche)
				if (MyCanvas.environnement.getCase(posX + couche + 1, posY).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX + couche + 1, posY };
				}
			// Verification poussiere à gauche
			if (posX - couche - 1 >= 0 && !trouverProche)
				if (MyCanvas.environnement.getCase(posX - couche - 1, posY).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX - couche - 1, posY };

				}
			// Verification poussiere en bas
			if (posY + couche + 1 < MyCanvas.environnement.getTaille() && !trouverProche)
				if (MyCanvas.environnement.getCase(posX, posY + couche + 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX, posY + couche + 1 };
				}
			// Verification poussiere en haut
			if (posY - couche - 1 >= 0 && !trouverProche)
				if (MyCanvas.environnement.getCase(posX, posY - couche - 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX, posY - couche - 1 };
				}
			
			//Verification diagonale
			if(couche>=1)
			{
				// Verification diagonale haut droite
				if (posX + couche < MyCanvas.environnement.getTaille() && posY - couche >= 0 && !trouverProche)
					if (MyCanvas.environnement.getCase(posX + couche, posY - couche).getPoussiere()) {
						trouverProche = true;
						posPoussiere = new int[] { posX + couche, posY - couche };
					}
				// Verification diagonale haut gauche
				if (posX - couche >= 0 && posY - couche >= 0 && !trouverProche)
					if (MyCanvas.environnement.getCase(posX - couche, posY - couche).getPoussiere()) {
						trouverProche = true;
						posPoussiere = new int[] { posX - couche, posY - couche };
					}
				// Verification diagonale bas droit
				if (posX + couche < MyCanvas.environnement.getTaille()
						&& posY + couche < MyCanvas.environnement.getTaille() && !trouverProche)
					if (MyCanvas.environnement.getCase(posX + couche, posY + couche).getPoussiere()) {
						trouverProche = true;
						posPoussiere = new int[] { posX + couche, posY + couche};
					}
				// Verification diagonale bas gauche
				if (posX - couche>= 0 && posY + couche < MyCanvas.environnement.getTaille() && !trouverProche)
					if (MyCanvas.environnement.getCase(posX - couche , posY + couche).getPoussiere()) {
						trouverProche = true;
						posPoussiere = new int[] { posX - couche, posY + couche};
					}
			}
			
			couche++;
		}

		return posPoussiere;
	}

	
	public ArrayList<String> CreationIntentions(int posX, int posY,int posXP, int posYP) {
		ArrayList<String> ListeAction = new ArrayList<String>();
		Environnement env = MyCanvas.environnement;
		if (posX != posXP) {
			if (posX < posXP) {
				while (posX < posXP) {
					ListeAction.add("D");
					posX++;
					if(env.getCase(posX, posY).getBijoux())
						ListeAction.add("R");
				}
			} else {
				while (posX > posXP) {
					ListeAction.add("G");
					posX--;
					if(env.getCase(posX, posY).getBijoux())
						ListeAction.add("R");
				}
			}
		}
		if (posY != posYP) {
			if (posY < posYP) {
				while (posY < posYP) {
					ListeAction.add("B");
					posY++;
					if(env.getCase(posX, posY).getBijoux())
						ListeAction.add("R");
				}
			} else {
				while (posY > posYP) {
					ListeAction.add("H");
					posY--;
					if(env.getCase(posX, posY).getBijoux())
						ListeAction.add("R");
				}
			}
		}
		if (MyCanvas.environnement.getCase(MyCanvas.aspirateur.getPosX(), MyCanvas.aspirateur.getPosY()).getBijoux() == true)
			ListeAction.add("R");
		if (MyCanvas.environnement.getCase(MyCanvas.aspirateur.getPosX(), MyCanvas.aspirateur.getPosY()).getPoussiere() == true)
			ListeAction.add("A");

		return ListeAction;
	}

}
