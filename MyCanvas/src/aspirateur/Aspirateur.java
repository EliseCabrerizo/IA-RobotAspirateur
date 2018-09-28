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
	Environnement env;
	
	public Aspirateur(Environnement e)
	{
		poussieresAspirees = 0;
		bijouxAttrapes=0;
		posX=0;
		posY=0;
		energie=0;
		c = new Capteur(e);
		eff = new Effecteur(e);
		env=e;
		
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
		//Belief
		//Observer l'element B
		env=c.Observer();
		//Faire les actions I
		// I : Trouver poussiere, se deplacer dans tableau
		int[]poussierePos= eff.TrouverPoussiere(posX, posY);
		ArrayList<String> Intentions = eff.CreationIntentions(posX, posY, poussierePos[0], poussierePos[1]);
		while(Intentions.size()!=0)
		{
			ExecuteIntention(Intentions.get(0));
			Intentions.remove(0);
			
		}
		
		// B observation matrice
		// D optionnel : meilleur score
		// I : Trouver poussiere, se deplacer dans tableau 
		
		
	}
	public void ExecuteIntention(String Intention)
	{
		if(Intention.equals("G"))
			{
				if(posX>0)
				{
					posX--;
					energie+=1;
				}
			}
			if(Intention.equals("D"))
			{
				if(posX<env.getTaille()-1)
				{
					posX++;
					energie+=1;
				}
			}
			if(Intention.equals("H"))
			{
				if(posY>0)
				{
					posY--;
					energie+=1;
				}
					
			}
			if(Intention.equals("B"))
			{
				if(posY<env.getTaille()-1)
				{
					posY++;
					energie+=1;
				}
					
			}
			if(Intention.equals("R"))
			{
				if(eff.Prendre(posX, posY))
					bijouxAttrapes+=1;
				energie+=1;
			}
			if(Intention.equals("A"))
			{
				if(eff.Aspirer(posX, posY))
					poussieresAspirees+=1;
				energie+=1;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
