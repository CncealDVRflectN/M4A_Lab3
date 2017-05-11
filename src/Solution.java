public class Solution {
    private static final double epsilon = 0.000001;

    public static void main(String[] args) {
        double x0 = 3.75;
        double xcur;
        double xnext = 3.556548540294219;
        int iterations = 0;
        System.out.println("Начальное приближение: " + x0);
        do {
            xcur = xnext;
            xnext = xcur - calculateF(xcur) * (xcur - x0) / (calculateF(xcur) - calculateF(x0));
            iterations++;
        } while (Math.abs(xnext - xcur) >= epsilon);
        System.out.println("Решение: " + xnext);
        System.out.println("Невязка: " + Math.abs(calculateF(xnext)));
        System.out.println("Количество итераций: " + iterations);
        System.out.println("const: " + (-calculateFSecondDeriv(xnext) / (2 * calculateFDeriv(xnext))));
    }

    private static double calculateF(double x) {
        return Math.pow(Math.E, x) + Math.log(x) - 10 * x;
    }

    private static double calculateFDeriv(double x) {
        return Math.pow(Math.E, x) + 1 / x - 10;
    }

    private static double calculateFSecondDeriv(double x) {
        return Math.pow(Math.E, x) - 1 / Math.pow(x, 2);
    }
}
