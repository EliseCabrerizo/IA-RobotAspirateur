import java.util.ArrayList;
package aspirateur;
import environnement.*;

public class Effecteur {

	Environnement env;
	
	public Effecteur (Environnement e)
	{
		env=e;	
	}
	
	public Environnement getEnvironnement() {return env;}
	public void setEnvironnements(Environnement value) {env=value;}
	
	public boolean Aspirer(int posX, int posY)
	{
		
		return env.aspiration(posX,posY);
		
	}
	public boolean Prendre(int posX, int posY)
	{
		return env.prendreBijoux(posX,posY);
		
	}
    
	
	
	public int[] TrouverPoussiere(int posX, int posY)	
	{
		int couche=0;
		boolean trouverProche=false;
		int[] posPoussiere=null;
		while (!trouverProche)
		{
			//Verification poussière à droite
			if(posX+couche+1<env.getTaille())
				if(env.getCase(posX+couche+1, posY).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX+couche+1, posY};
				}
			//Verification poussière à gauche
			if(posX-couche-1>=0&&!trouverProche)
				if(env.getCase(posX-couche-1, posY).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX-couche-1, posY};
			
				}
			//Verification poussière en bas
			if(posY+couche+1<env.getTaille()&&!trouverProche)
				if(env.getCase(posX, posY+couche+1).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX, posY+couche+1};
				}
			//Verification poussière en haut
			if(posY-couche-1>=0&&!trouverProche)
				if(env.getCase(posX, posY-couche-1).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX, posY-couche-1};
				}
			//Verification diagonale haut droite 
			if(posX+couche+1<env.getTaille()&&posY-couche-1>=0&&!trouverProche)
				if(env.getCase(posX+couche+1, posY-couche-1).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX+couche+1, posY-couche-1};
				}
			//Verification diagonale haut gauche 
			if(posX-couche-1>=0&&posY-couche-1>=0&&!trouverProche)
				if(env.getCase(posX-couche-1, posY-couche-1).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX-couche-1, posY-couche-1};
				}
			//Verification diagonale bas droit
			if(posX+couche+1<env.getTaille()&&posY+couche+1<env.getTaille()&&!trouverProche)
				if(env.getCase(posX+couche+1, posY+couche+1).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX+couche+1, posY+couche+1};
				}
			//Verification diagonale bas gauche
			if(posX-couche-1>=0&&posY+couche+1<env.getTaille()&&!trouverProche)
				if(env.getCase(posX-couche-1, posY+couche+1).getPoussiere())
				{
					trouverProche=true;
					posPoussiere= new int[] {posX-couche-1, posY+couche+1};
				}
			couche++;
		}
			

			return posPoussiere;
		}
	
	public ArrayList<String> CreationIntentions(int posX, int posY,int posXP, int posYP)
	{
		ArrayList<String> ListeAction = new ArrayList<String>();
		if(posX!=posXP)
		{
			if(posX<posXP)
			{
				while(posX<posXP)
				{
					ListeAction.add("D");
					posX++;
				}
			}
			else 
			{
				while(posX>posXP)
				{
					ListeAction.add("G");
					posX--;
				}
			}
		}
		if(posY!=posYP)
		{
			if(posY<posYP)
			{
				while(posY<posYP)
				{
					ListeAction.add("B");
					posX++;
				}
			}
			else 
			{
				while(posY>posYP)
				{
					ListeAction.add("H");
					posX--;
				}
			}
		}
		if(env.getCase(posX,posY).getBijoux()==true)
			ListeAction.add("A");
		if(env.getCase(posX,posY).getPoussiere()==true)
			ListeAction.add("Aspirer");
			
		return ListeAction;
	}
	
}
