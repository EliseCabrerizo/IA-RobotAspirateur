package aspirateur;
import environnement.*;

public class Capteur {

	Environnement env;
	
	public Capteur(Environnement e)
	{
		env=e;	
	}

	public Environnement getEnvironnement() {return env;}
	public void setEnvironnements(Environnement value) {env=value;}
	
	public Environnement Observer()
	{
		return env;
	}
	
	
	public int getScore(int energie,int bijoux)
	{
		return env.calculScore(energie,bijoux);
	}
		
}
	
