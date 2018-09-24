package aspirateur;
import environnement.*;

import java.util.ArrayList;

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
	
	public ArrayList<String> ChoisirAction(int posX, int posY)
	{
		ArrayList<String> ListeAction = new ArrayList<String>();
		ListeAction.add("Deplacer");
		
		if(env.getCase(posX,posY).getBijoux()==true)
			ListeAction.add("Attraper");
		if(env.getCase(posX,posY).getPoussiere()==true)
			ListeAction.add("Aspirer");
			
		return ListeAction;
	}
}
