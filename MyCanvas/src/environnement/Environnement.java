package environnement;

public class Environnement {

    private Case[][] Case;
    private int bijouxAbs;
    private int poussiereRest;
    private int score;
    private int taille;

    public int getTaille(){
        return this.taille;
    }

    public Case getCase(int x, int y) {
        if(x >=0 && x < this.getTaille() && y >=0 && y < this.getTaille())
        {
            return this.Case[x][y];
        }
        else
        {
            return null;
        }
    }

    /**
     *
     * @param x
     */
    public void setCase(int x, int y, boolean poussiere, boolean bijoux) {
        // TODO - implement Environnement.setCase
        if(x >0 && x < this.getTaille() && y >0 && y < this.getTaille())
        {
            this.Case[x][y].setBijoux(bijoux);
            this.Case[x][y].setPoussiere(poussiere);
        }
        else
        {
            throw new UnsupportedOperationException();
        }
    }

    public int getBijoux_Abs() {
        // TODO - implement Environnement.getBijoux_Abs
        return this.bijouxAbs;
    }

    /**
     *
     * @param bijouxAbs
     */
    public void setBijouxAbs(int bijouxAbs) {
        // TODO - implement Environnement.setBijoux_Abs
        this.bijouxAbs=bijouxAbs;
    }

    public int getPoussiere_rest() {
        // TODO - implement Environnement.getPoussiere_rest
        return this.poussiereRest;
    }

    /**
     *
     * @param poussiere_rest
     */
    public void setPoussiereRrest(int poussiere_rest) {
        // TODO - implement Environnement.setPoussiere_rest
        this.poussiereRest=poussiere_rest;
    }

    public int getScore() {
        // TODO - implement Environnement.getScore
        return this.score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @param nbCase
     */
    public Environnement(int nbCase) {
        // TODO - implement Environnement.Environnement
        if(nbCase > 0)
        {
            this.taille=nbCase;
            this.Case=new Case[nbCase][nbCase];
            boolean randomP=true;
            boolean randomB=true;
            int randomN=0;
            this.setPoussiereRrest(0);
            this.setBijouxAbs(0);
            this.setScore(0);
            for(int i=0;i<nbCase;i++)
            {
                for(int j=0;j<nbCase;j++) // on créer le premier set de case, avec des valeurs aléatoire
                {
                    randomN= (int)(1+(Math.random()*(10 - 1))); // on tire un nombre aléatoire entre 1 et 10
                    if(randomN > 7)   // si il est supérieur à 7, on met une pourrsière (30% de taux d'apparition)
                    {
                        randomP=true;
                        this.setPoussiereRrest(this.getPoussiere_rest()+1);
                    }
                    else
                    {
                        randomP=false;     // sinon on la met à false
                    }
                    randomN= (int)(1+(Math.random()*(10 - 1)));
                    if(randomN > 8) // si il est supérieur à 8, on met un bijou (20% de taux d'apparition)
                    {
                        randomB=true;
                    }
                    else
                    {
                        randomB=false;
                    }
                    this.Case[i][j]=new Case(randomP,randomB);
                }
            }
        }
    }

    public int[] Generation() // génère aléatoirement de la poussière et des bijoux sur une case aléatoire.
    {

        int randomX= (int)(1+(Math.random()*(this.getTaille() - 1)));
        int randomY= (int)(1+(Math.random()*(this.getTaille() - 1)));
        while(this.getCase(randomX,randomY).getPoussiere() || this.getCase(randomX,randomY).getBijoux())
        {
            randomX= (int)(1+(Math.random()*(this.getTaille() - 1)));
            randomY= (int)(1+(Math.random()*(this.getTaille() - 1)));
        }
        int randomN= (int)(1+(Math.random()*(10 - 1)));
        int[] tab = {randomX, randomY};
        boolean randomP = true;
        boolean randomB = true;
        if(randomN%2 > 0)   // si il est impaire alors on met la poussière à true
        {
            randomP=true;
            this.setPoussiereRrest(this.getPoussiere_rest()+1);
        }
        else
        {
            randomP=false;     // sinon on la met à false
        }
        randomN= (int)(1+(Math.random()*(10 - 1))); // idem pour les bijoux
        if(randomN%2 > 0)
        {
            randomB=true;
        }
        else
        {
            randomB=false;
        }
        this.getCase(randomX,randomY).setPoussiere(randomP);
        this.getCase(randomX,randomY).setBijoux(randomB);
        
        return tab;
    }
    public boolean prendreBijoux(int x, int y)
    {
        if(x >0 && x < this.getTaille() && y >0 && y < this.getTaille())
        {
            if(this.getCase(x,y).getBijoux()== true)
            {
                this.getCase(x,y).setBijoux(false);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            throw new UnsupportedOperationException();
        }
    }

    public boolean aspiration(int x, int y)
    {
        if(x >0 && x < this.getTaille() && y >0 && y < this.getTaille())
        {
            if(this.getCase(x,y).getBijoux()== true)
            {
                this.getCase(x,y).setBijoux(false);
                this.setBijouxAbs(this.getBijoux_Abs()+1);
            }
            if(this.getCase(x,y).getPoussiere()== true)
            {
                this.getCase(x,y).setPoussiere(false);
                this.setPoussiereRrest(this.getPoussiere_rest()-1);
                this.setScore(this.getScore()+10);
                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {
            throw new UnsupportedOperationException();
        }
    }

    public int calculScore(int energie, int bijoux)
    {
        // score = 15*bijoux _attrapé + 10*poussière_aspi - 20*bijoux_abs - 5*poussière_rest - energie
        this.setScore(Math.abs(bijoux)*15+this.getScore()-(20*this.getBijoux_Abs())-(5*this.getPoussiere_rest())-Math.abs(energie));
        return this.getScore();
    }



}