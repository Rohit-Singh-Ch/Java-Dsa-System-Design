import java.util.HashMap;
import java.util.Map;

public class string {
    public static void main(String[] args) {
        String name = "afhtgpque";
        Map<Character, Integer> mapKey = new HashMap<>(name.length());
        for (int i=0 ;i<name.length(); i++){
            if(!mapKey.containsKey(name.charAt(i)))
                mapKey.put(name.charAt(i), 1);
            else {
                mapKey.put(name.charAt(i), mapKey.get(name.charAt(i)) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> item : mapKey.entrySet()) {
            count = item.getValue() + count;
        }
        if(mapKey.size() > 8){
            int extraPush = (mapKey.size() - 8) + 1;
            count = count + extraPush;
        }
        System.out.println(count);
    }
}
