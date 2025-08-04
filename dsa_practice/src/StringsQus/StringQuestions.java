package StringsQus;

import java.util.Arrays;

public class StringQuestions {
    public static void main(String[] args) {
//        String address = "1.1.1.1";
//        System.out.println(defangIPaddr(address));
//        System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
    //1859. Sorting the Sentence
    static String sortSentence(String s) {
        String[] wordArr = s.split(" ");
        String[] newArr = new String[wordArr.length];
        for (int i = 0; i < wordArr.length; i++) {
            System.out.print(wordArr[i]);
            int index =  wordArr[i].charAt(wordArr[i].length()-1) - '1' ;
            System.out.print(" | index: "+ index);
            String str = wordArr[i].substring(0,wordArr[i].length()-1);
            System.out.println( " | word: " + str);
            newArr[index] = str;
        }
        return String.join(" ", newArr);
    }
    //1678. Goal Parser Interpretation
    static String interpret(String command) {
//        return command.replace("()", "o").replace("(al)","al");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i) == 'G'){
                sb.append('G');
            }else if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                sb.append('o');
                i++;
            }else if(command.charAt(i) == '(' && command.charAt(i+1) == 'a'){
                sb.append("al");
                i+=3;
            }
        }
        return sb.toString();
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
