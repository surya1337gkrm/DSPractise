package DSA.Hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Hashing {
    // takes a string as an input and prints the frequency of each character in the
    // string
    public void hashString(String string) {
        // Hashmap sorts the data. use LinkedHashMap to preserve the order of the
        // inserted data. Also unordered hashmaps has less time complexity -> avg,best case:O(1)
        // worst case: O(n)

        //where as hashedmap has worst/best/avg case: O(log n)
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (map.containsKey(string.charAt(i))) {
                map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
            } else {
                map.put(string.charAt(i), 1);
            }
        }
        System.out.println(map);

        displayMap(map);
    }

    private void displayMap(Map<Character, Integer> map) {
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
