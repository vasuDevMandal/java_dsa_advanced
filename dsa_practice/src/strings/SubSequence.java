package strings;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {

        subseq("", "abc");

        System.out.println(subSeqRet("", "abc"));
    }

    static void subseq( String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1) );
        subseq(p, up.substring(1));

    }

    static ArrayList<String> subSeqRet(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            System.out.println(p);
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeqRet(p + ch, up.substring(1) );
        ArrayList<String> right = subSeqRet(p, up.substring(1));

        left.addAll(right);

        return left;
    }
}
