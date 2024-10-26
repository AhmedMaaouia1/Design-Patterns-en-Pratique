
public class CStandard implements CalculerFrais {
    @Override
    public double calcul(double poids, double distance) {
        return (1.5 * distance) + (0.2 * poids);
    }
}
