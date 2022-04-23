public class FibonacciCalculator {

    public long getFibonacci(int n){
        long a = 1;
        long b = 1;
        long tmp;

        for (int i = 1; i < n; i++) {
            tmp = b;
            b=b+a;
            a=tmp;
        }
        return b;
    }
}
