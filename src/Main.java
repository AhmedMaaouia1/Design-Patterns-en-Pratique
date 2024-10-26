
public class Main {
    public static void main(String[] args) {
        // Cr�er un transporteur de type STANDARD
        Transporteur transporteur = Transporteur.createTrans(TypeTrans.STANDARD);

        // Calculer les frais d'exp�dition
        double frais = transporteur.calculerFrais(10.0, 100.0);
        System.out.println("Frais d'exp�dition : " + frais);
    }
}

