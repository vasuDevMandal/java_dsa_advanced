package leetcodeProblems;

import java.util.ArrayList;

public class Q17_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
//        String s = "1";
//        char c = s.charAt(0);
//        System.out.println(c);
//        System.out.println(c-'0');//convert string to number

//        phoneCombo("","12");
//        System.out.println(phoneComboCount("", "12"));
        System.out.println(phoneComboRet("", "23"));

    }

    static ArrayList<String> phoneComboRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';//convert string num into integer, '2' into 2;
        ArrayList<String> list = new ArrayList<>();
        for (int i = (digit-1)*3; i < digit*3 ; i++) {
            char ch = (char)('a' + i);
            list.addAll(phoneComboRet(p+ch, up.substring(1)));
        }
        return list;
    }

    static int phoneComboCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';
        for (int i = (digit+1)*3; i < digit*3-2 ; i++) {
            char ch = (char)('a' + i);
            count = count + phoneComboCount(p+ch, up.substring(1));
        }

        return count;
    }

    static void phoneCombo(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';//convert string num into integer, '2' into 2;

        for (int i = (digit-1)*3; i < digit*3 ; i++) {
            char ch = (char)('a' + i);
            phoneCombo(p+ch, up.substring(1));
        }
    }



}
