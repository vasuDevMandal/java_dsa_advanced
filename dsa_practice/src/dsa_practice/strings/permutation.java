package dsa_practice.strings;

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {

        permutations("","abc");

        System.out.println(permutationsAL("","def"));
    }

    static void permutations(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {

            String f = p.substring(0,i);
            String s = p.substring(i, p.length());

            permutations(f + ch + s, up.substring(1) );
        }
    }

    static ArrayList<String> permutationsAL(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
         }

        char ch = up.charAt(0);

        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {

            String f = p.substring(0,i);
            String s = p.substring(i, p.length());

            answer.addAll(permutationsAL(f + ch + s, up.substring(1) ));
        }

        return answer;
    }
}
