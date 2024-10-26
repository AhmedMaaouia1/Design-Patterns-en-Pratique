
public class CEco implements CalculerFrais {
    @Override
    public double calcul(double poids, double distance) {
        return (1.0 * distance) + (0.1 * poids);
    }
}
