public class Solution {
    private static final double epsilon = 0.00001;

    public static void main(String[] args) {
        double x0 = 6.25;
        double xcur;
        double xnext = 5.350019946106768;
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
    }

    private static double calculateF(double x) {
        return Math.pow(Math.E, x) + Math.log(x) - 10 * x;
    }
}
