import java.io.*;
import java.util.*;
public class LastNameFreqClass {
    public static void main(String[] args)
            throws IOException{
        Map<String,String> map =
                readMap("LastnameFrequencies.csv");
        writeSortedMap(map, "SortedLastnameFrequecies.csv");
    }
    public static Map<String,String> readMap(String filename)
            throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(filename));
        String s = null;
        Map<String,String> m =
                new HashMap<String,String>(100000);
// With a TreeMap we don't need to sort a list
        String[] values;
        while ((s = reader.readLine()) !=null) {
            values = s.split(",");
            if (values.length == 2) {
                m.put(values[0], values[1]);
            }
        }
        reader.close();
        return m;
    }
    public static void writeSortedMap(Map<String,String> map,
                                      String filename) throws IOException {
        List<String> listKeys =
                new ArrayList<String>(map.keySet());
        Collections.sort(listKeys);
        PrintWriter writer =
                new PrintWriter(new FileWriter(filename));
        for (String s : listKeys) {
            writer.println(s + "," + map.get(s));
        }
        writer.close();
    }
}