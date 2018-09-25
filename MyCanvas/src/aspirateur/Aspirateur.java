package aspirateur;
import environnement.*;

import java.util.ArrayList;

public class Aspirateur 
{
	//ajouter BDI ? 
	int poussieresAspirees;
	int bijouxAttrapes;
	int posX;
	int posY;
	int energie;
	int nbAction;
	int score;
	double alpha;
	Capteur c;
	Effecteur eff;
	
	public Aspirateur(Environnement e)
	{
		poussieresAspirees = 0;
		bijouxAttrapes=0;
		posX=0;
		posY=0;
		energie=0;
		nbAction=30;
		score=0;
		alpha=0.15;
		c = new Capteur(e);
		eff = new Effecteur(e);
	}
	
	//Accesseurs
	public int getPoussieresAspirees() {return poussieresAspirees;}
	public void setPoussieresAspirees(int value) {poussieresAspirees=value;}
	
	public int getBijouxAttrapes() {return bijouxAttrapes;}
	public void setBijouxAttrapes(int value) {bijouxAttrapes=value;}
	
	public int getPosX() {return posX;}
	public void setPosXs(int value) {posX=value;}
	
	public int getPosY() {return posY;}
	public void setPosY(int value) {posY=value;}
	
	public int getEnergie() {return energie;}
	public void setEnergie(int value) {energie=value;}

	public int getNbAction() {return nbAction;}
	public void setNbAction(int value) {nbAction=value;}

	public int getScore() {return score;}
	public void setScore(int value) {score=value;}
	public double getAlpha() {return alpha;}
	public void setAlpha(int value) {alpha=value;}

	
	
	
	//Methodes
	public void Boucle() throws InterruptedException
	{
		//Observer l'element
		int[]poussierePos=c.TrouverPoussiere(posX,posY);
		
		//Changer l'etat
		////A faire
		
		//Choisir les actions
		ArrayList<String> ListeAction = eff.ChoisirAction(poussierePos[0], poussierePos[1]);
		
		//Faire les actions
		if(ListeAction.contains( "Deplacer"))
			Deplacement(poussierePos[0],poussierePos[1]);
		if(ListeAction.contains( "Attraper"))
		{
			if(eff.Prendre(posX, posY))
				bijouxAttrapes+=1;
			energie+=1;
		}
		if(ListeAction.contains( "Aspirer"))
		{
			if(eff.Aspirer(posX, posY))
				poussieresAspirees+=1;
			energie+=1;
		}
		
	}
	public void Deplacement(int posXFinale,int posYFinale) throws InterruptedException
	{
		
			while(posX!=posXFinale)
		{
			if(posX>posXFinale)
			{
				posX--;
				energie+=1;
			}
			else 
			{
				posX++;
				energie+=1;
			}

			Thread.sleep(500);
		}
		while(posY!=posYFinale)
		{
			if(posX>posYFinale)
			{
				posY--;
				energie+=1;;
			}
			else 
			{
				posY++;
				energie+=1;

			}

			Thread.sleep(500);
		}
	}
	public void newSubGame()
	{
		setBijouxAttrapes(0);
		setEnergie(0);

	}
	public void apprentissage()
	{
		// ici on prend le nombre d'action max qu'a le droit de faire le robot, son précédent score, son score actuel et la quantité d'énergie dépensée pour déterminer la nouvelle limite d'action.
		int newAction = (int)Math.floor(getNbAction()+getAlpha()*((getScore()+15)-c.getScore(getEnergie(),getBijouxAttrapes()))*getEnergie()); // fonction du perceptron
		setScore(c.getScore(getEnergie(),getBijouxAttrapes())); // on actualise le score du robot
		setNbAction(newAction); // on actualise le nombre max d'action
		newSubGame(); // on reset le nombre de bijoux attrapé et l'enrgie dépensée

	}

}
