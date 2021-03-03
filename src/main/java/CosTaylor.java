public class CosTaylor {

    public double compCos(double x, double accuracy) throws NoSuchValueException, UnreachableResultException {
        if (accuracy < 0){
            throw new UnreachableResultException("The accuracy below zero");
        }
        double x_norm = Math.abs(x);
        if (x_norm < 0 || x_norm > 2*Math.PI){
            throw new NoSuchValueException("The angle must be between [-2PI; 2PI]");
        }
        double result = 1;
        double step = 1;
        int i;
        for (i = 1; step > accuracy && i != Integer.MAX_VALUE; i++){
            step = step*x_norm*x_norm/(2*i-1)/(2*i);
            if (i % 2 == 1){
                result -= step;
            } else {
                result += step;
            }
        }
        return result;
    }
}
