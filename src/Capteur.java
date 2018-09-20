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
		
		for (int i=0; i<env.cases.length&&distanceMin!=1;i++)
			for(int j=0;j<env.cases[i].length&&distanceMin!=1;j++)
			{
				if(env.cases[i][j].poussiere==true)
				{
					if(CalculDistance(posX,i,posY,j)<distanceMin)
					{
						int[]temp= {i,j};
						distanceMin=CalculDistance(posX,i,posY,j);
						posPoussiere=temp;
					}
				}
			}
		
		return posPoussiere;
	}
	
	public int CalculDistance(int posX,int i,int posY, int j)
	{
		return (posX-i)+(posY-j);
	}
	
	
		
}
	
