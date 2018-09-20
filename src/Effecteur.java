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
		
		return env.Aspiration(posX,posY);
		
	}
	public boolean Prendre(int posX, int posY)
	{
		return env.PrendreBijoux(posX,posY);
		
	}
	
	public ArrayList<String> ChoisirAction(int posX, int posY)
	{
		ArrayList<String> ListeAction = new ArrayList<String>();
		ListeAction.add("Deplacer");
		
		if(env.cases[posX][posY].bijou==true)
			ListeAction.add("Attraper");
		if(env.cases[posX][posY].poussiere==true)
			ListeAction.add("Aspirer");
			
		return ListeAction;
	}
}
