
public abstract class Transporteur {
    protected CalculerFrais manierCalcul;

    // Méthode pour créer un transporteur en utilisant l'enum TypeTrans
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

    // Méthode pour définir la stratégie de calcul des frais
    public void setCalcul(CalculerFrais calcul) {
        this.manierCalcul = calcul;
    }

    // Méthode pour calculer les frais selon la stratégie définie
    public double calculerFrais(double poids, double distance) {
        if (manierCalcul == null) {
            throw new IllegalStateException("Aucune stratégie de calcul définie");
        }
        return manierCalcul.calcul(poids, distance);
    }
}
