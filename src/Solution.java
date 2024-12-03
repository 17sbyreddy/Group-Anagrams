import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // We will create a hashmap with the key being the sorted word and the value being the unsorted word. If the next sorted word matches the key then we put that in the list of unsorted word that correspond to the sorted word. If the word is completly diffrent its sorted word gets put in as a new key and the value is an empty list which will then get its first unsorted word inserted in.

        HashMap<Object, Object> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            // sorting the word and storing it in a string value
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // method
            map.putIfAbsent(key, new ArrayList<>());

            // have to use this to add values to a list if the value in the map is a list type
            map.get(key).add(str);

        }

        // converting it to a list of lists like List<List<String>>
        return new ArrayList<>(map.values());

    }
}
