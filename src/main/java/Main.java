import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        System.out.print("Task 1\n");

        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacciCalculator.getFibonacci(i)+"\t");
        }

        System.out.println();
        System.out.println();
        System.out.print("Task 2\n");

        JSONConverter jsonConverter = new JSONConverter();
        TreeMap<String, List<String>> treeMap = jsonConverter.getJSONObjectsFromJSONString(jsonConverter.getJsonString());
        jsonConverter.printJSON(treeMap);

    }
}
