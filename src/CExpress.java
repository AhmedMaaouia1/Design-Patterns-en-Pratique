
public class CExpress implements CalculerFrais {
	@Override
    public double calcul(double poids, double distance) {
        return (2.5 * distance) + (0.5 * poids);
    }
}
