public class HillClimbing {
    public static double function(double x) {
    return Math.pow(x, 2) - (5 * x) + 7;
}

public static void main(String[] args) {
    double x = 0; //initial guess
    double f = function(x);
    double dx = 0.1; //step size
    int maxIterations = 100;

    for (int i = 0; i < maxIterations; i++) {
        double fNew = function(x + dx);
        if (fNew < f) {
            x += dx;
            f = fNew;
        } else {
            fNew = function(x - dx);
            if (fNew < f) {
                x -= dx;
                f = fNew;
            } else {
                dx *= 0.95; // reduce step size gradually
            }
        }
    }

    System.out.println("Local minimum found at x = " + x + " with f(x) = " + f);
}
}