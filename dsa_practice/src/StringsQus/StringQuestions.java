package StringsQus;

import java.util.Arrays;

public class StringQuestions {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
        System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
    }

    //1528. Shuffle String
    static String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return String.valueOf(ch);
    }

    //1108. Defanging an IP Address
    static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.'){
                sb.append("[.]");
            }else{
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}
