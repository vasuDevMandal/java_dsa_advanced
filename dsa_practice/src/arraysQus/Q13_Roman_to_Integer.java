package arraysQus;

import java.util.HashMap;

public class Q13_Roman_to_Integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] chars = s.toCharArray();
//        starting with last element of the char array
        int result = map.get(chars[chars.length - 1]);

//        last char already taken into account so running loop to length - 1
        for (int i = 0; i < chars.length - 1; i++) {
            if(map.get(chars[i]) < map.get(chars[i+1])){
                result = result - map.get(chars[i]);
            }else{
                result = result + map.get(chars[i]);
            }
        }
        return result;
    }
}
