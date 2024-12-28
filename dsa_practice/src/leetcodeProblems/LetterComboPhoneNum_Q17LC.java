package leetcodeProblems;

import java.util.ArrayList;
//similar DICECombo
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterComboPhoneNum_Q17LC {
    public static void main(String[] args) {
        comboNum("","12");

        System.out.println(comboNumAL("","23"));
    }

    static void comboNum(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; //this will covert [string] '2' into [number] 2
        for (int i = ((digit-1) * 3) ; i < (digit*3) ; i++) {
            char ch = (char) ('a' + i);
            comboNum(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> comboNumAL(String p, String up){
        if(up.isEmpty()){
//            System.out.println(p);
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        int digit = up.charAt(0) - '0'; //this will covert [string] '2' into [number] 2
        for (int i = ((digit-1) * 3) ; i < (digit*3) ; i++) {
            char ch = (char) ('a' + i);
            ans.addAll( comboNumAL(p + ch, up.substring(1)) );
        }
        return ans;
    }


    static int comboNumCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        ArrayList<String> ans = new ArrayList<>();

        int digit = up.charAt(0) - '0'; //this will covert [string] '2' into [number] 2
        for (int i = ((digit-1) * 3) ; i < (digit*3) ; i++) {
            char ch = (char) ('a' + i);
            count = count + comboNumCount(p + ch, up.substring(1)) ;
        }
        return count;
    }
}