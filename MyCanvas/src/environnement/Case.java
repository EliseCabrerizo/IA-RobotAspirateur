package environnement;

public class Case {

    private boolean Bijoux;
    private boolean Poussiere;

    /**
     *
     * @param poussiere
     * @param bijoux
     */
    public Case(boolean poussiere, boolean bijoux) {
        this.setBijoux(bijoux);
        this.setPoussiere(poussiere);
    }

    public boolean getBijoux() {
        // TODO - implement Case.getBijoux
        return this.Bijoux;
    }

    /**
     *
     * @param Bijoux
     */
    public void setBijoux(boolean Bijoux) {
        // TODO - implement Case.setBijoux
        this.Bijoux=Bijoux;
    }

    public boolean getPoussiere() {
        // TODO - implement Case.getPoussiere
        return this.Poussiere;
    }

    /**
     *
     * @param Poussiere
     */
    public void setPoussiere(boolean Poussiere) {
        // TODO - implement Case.setPoussiere
        this.Poussiere=Poussiere;
    }
}