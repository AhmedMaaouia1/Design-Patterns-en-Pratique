
public abstract class Transporteur {
    protected CalculerFrais manierCalcul;

    // M�thode pour cr�er un transporteur en utilisant l'enum TypeTrans
    public static Transporteur createTrans(TypeTrans type) {
        switch(type) {
            case STANDARD:
                return new Standard();
            case EXPRESS:
                return new Express();
            case ECO:
                return new Eco();
            default:
                return null;
        }
    }

    // M�thode pour d�finir la strat�gie de calcul des frais
    public void setCalcul(CalculerFrais calcul) {
        this.manierCalcul = calcul;
    }

    // M�thode pour calculer les frais selon la strat�gie d�finie
    public double calculerFrais(double poids, double distance) {
        if (manierCalcul == null) {
            throw new IllegalStateException("Aucune strat�gie de calcul d�finie");
        }
        return manierCalcul.calcul(poids, distance);
    }
}
