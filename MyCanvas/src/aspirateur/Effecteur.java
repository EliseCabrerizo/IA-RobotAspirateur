package aspirateur;

import java.util.ArrayList;
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
		int[] posPoussiere = null;
		while (!trouverProche) {
			//Verification emplacement
			if(MyCanvas.environnement.getCase(posX, posY).getPoussiere())
			{
				trouverProche = true;
				posPoussiere = new int[] { posX, posY };
			}
			// Verification poussière à droite
			if (posX + couche + 1 < MyCanvas.environnement.getTaille()&&!trouverProche)
				if (MyCanvas.environnement.getCase(posX + couche + 1, posY).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX + couche + 1, posY };
				}
			// Verification poussière à gauche
			if (posX - couche - 1 >= 0 && !trouverProche)
				if (MyCanvas.environnement.getCase(posX - couche - 1, posY).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX - couche - 1, posY };

				}
			// Verification poussière en bas
			if (posY + couche + 1 < MyCanvas.environnement.getTaille() && !trouverProche)
				if (MyCanvas.environnement.getCase(posX, posY + couche + 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX, posY + couche + 1 };
				}
			// Verification poussière en haut
			if (posY - couche - 1 >= 0 && !trouverProche)
				if (MyCanvas.environnement.getCase(posX, posY - couche - 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX, posY - couche - 1 };
				}
			// Verification diagonale haut droite
			if (posX + couche + 1 < MyCanvas.environnement.getTaille() && posY - couche - 1 >= 0 && !trouverProche)
				if (MyCanvas.environnement.getCase(posX + couche + 1, posY - couche - 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX + couche + 1, posY - couche - 1 };
				}
			// Verification diagonale haut gauche
			if (posX - couche - 1 >= 0 && posY - couche - 1 >= 0 && !trouverProche)
				if (MyCanvas.environnement.getCase(posX - couche - 1, posY - couche - 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX - couche - 1, posY - couche - 1 };
				}
			// Verification diagonale bas droit
			if (posX + couche + 1 < MyCanvas.environnement.getTaille()
					&& posY + couche + 1 < MyCanvas.environnement.getTaille() && !trouverProche)
				if (MyCanvas.environnement.getCase(posX + couche + 1, posY + couche + 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX + couche + 1, posY + couche + 1 };
				}
			// Verification diagonale bas gauche
			if (posX - couche - 1 >= 0 && posY + couche + 1 < MyCanvas.environnement.getTaille() && !trouverProche)
				if (MyCanvas.environnement.getCase(posX - couche - 1, posY + couche + 1).getPoussiere()) {
					trouverProche = true;
					posPoussiere = new int[] { posX - couche - 1, posY + couche + 1 };
				}
			couche++;
		}

		return posPoussiere;
	}

	public ArrayList<String> CreationIntentions(int posX, int posY,int posXP, int posYP) {
		ArrayList<String> ListeAction = new ArrayList<String>();
		if (posX != posXP) {
			if (posX < posXP) {
				while (posX < posXP) {
					ListeAction.add("D");
					posX++;
				}
			} else {
				while (posX > posXP) {
					ListeAction.add("G");
					posX--;
				}
			}
		}
		if (posY != posYP) {
			if (posY < posYP) {
				while (posY < posYP) {
					ListeAction.add("B");
					posY++;
				}
			} else {
				while (posY > posYP) {
					ListeAction.add("H");
					posY--;
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
