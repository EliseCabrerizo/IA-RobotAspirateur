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
	
	public int[] TrouverPoussiere(int posX, int posY)
	{
		int distanceMin=1000;
		int[] posPoussiere=null;
		
		for (int i=0; i<env.getTaille()&&distanceMin!=1;i++)
			for(int j=0;j<env.getTaille()&&distanceMin!=1;j++)
			{
				if(env.getCase(j,i).getPoussiere()==true)
				{
					if(CalculDistance(posX,j,posY,i)<distanceMin)
					{
						int[]temp= {j,i};
						distanceMin=CalculDistance(posX,j,posY,i);
						posPoussiere=temp;
					}
				}
			}
		
		return posPoussiere;
	}
	
	public int CalculDistance(int posX,int j,int posY, int i)
	{
		return (posX-j)+(posY-i);
	}
	
	
		
}
	
