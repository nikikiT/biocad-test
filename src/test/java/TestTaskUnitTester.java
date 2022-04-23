import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestTaskUnitTester {

    FibonacciCalculator fibonacciCalculator;
    private List<Long> fibonacciNumbers;
    private List<Long> actual;

    public TestTaskUnitTester(){
        fibonacciCalculator = new FibonacciCalculator();
        fibonacciNumbers = new ArrayList<Long>();
        actual = new ArrayList<Long>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/test-coverage.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");

                fibonacciNumbers.add(Long.parseLong(values[0]));
                actual.add(Long.parseLong(values[1]));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    //1 1 2 3 5 8 13 21 34 55 89 ...
    @ParameterizedTest
    @ValueSource(
            ints = {0,1,2,3,4,5}
    )
    void checkTestCoverage(int n){
        Assertions.assertEquals(this.actual.get(n),fibonacciCalculator.getFibonacci(Math.toIntExact(fibonacciNumbers.get(n))));
    }
}
