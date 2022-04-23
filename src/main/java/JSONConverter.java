import java.io.*;
import java.util.*;

public class JSONConverter {

    Scanner scanner;
    String jsonString;

    public String getJsonString() {
        return jsonString;
    }

    public JSONConverter() throws IOException {
        File file = new File("src/main/java/test-file.json");

        scanner = new Scanner(file);

        StringBuffer stringBuffer = new StringBuffer();

        while(scanner.hasNext()){
            stringBuffer.append(scanner.nextLine());
        }

        scanner.close();

        this.jsonString=stringBuffer.toString();
    }

    public TreeMap<String, List<String>> getJSONObjectsFromJSONString(String jsonString){
        if (jsonString==null)
            return null;
        jsonString= jsonString.trim();
        jsonString= jsonString.replaceAll(" ","");

        String[] separatedByAttributes,attributeNames,attributeData;

        separatedByAttributes = jsonString.split("],");

        TreeMap<String, List<String>> values = new TreeMap<>();

        for (int i = 0; i < separatedByAttributes.length; i++) {
            separatedByAttributes[i]=separatedByAttributes[i].replaceAll("\\{","").replaceAll("\\}","").replaceAll("\\[","").replaceAll("\\]","").replaceAll("\"","");
            attributeNames = separatedByAttributes[i].split(":");
            attributeData = attributeNames[1].split(",");
            values.put(attributeNames[0], Arrays.asList(attributeData));
        }

        return values;
    }


    public void printJSON(TreeMap<String,List<String>> values){
        int maxLength=0;
        for (Map.Entry<String, List<String>> key: values.entrySet()) {
            System.out.format("%16s", key.getKey());
            if(key.getValue().size()>maxLength)
                maxLength=key.getValue().size();
        }
        System.out.println();

        for (int i = 0; i < maxLength; i++) {
            for (Map.Entry<String, List<String>> element : values.entrySet()) {
                List<String> value = element.getValue();
                if (value.size() > i)
                    System.out.format("%16s", value.get(i));
                else System.out.format("%16s", "");
            }
            System.out.println();
        }

    }

}

