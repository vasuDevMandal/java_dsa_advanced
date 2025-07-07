package strings;

public class SkipChars {
    public static void main(String[] args) {
        String str = "ababbababbab";

        skip("", str);
        System.out.println(skip2('a',"", str));

        System.out.println(skip3(str));

        System.out.println(removeApple("","ababappleabba"));
    }

    //skip all 'a' chars, p = processed string, up = un-processed
    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip( p, up.substring(1));
        }else{
            skip(p + ch, up.substring(1) );
        }
    }

    static String skip3(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skip3(up.substring(1));
        }else{
            return ch + skip3(up.substring(1) );
        }
    }

    static String skip2(char toRemove, String p, String up){
        if(up.isEmpty()){
            return p;
        }
        char ch = up.charAt(0);
        if(ch == toRemove){
            return skip2(toRemove, p, up.substring(1));
        }else{
            return skip2(toRemove,p + ch, up.substring(1) );
        }
    }

    static String removeApple( String p, String up){
        if(up.isEmpty()){
            return p;
        }
        char ch = up.charAt(0);
        if(up.startsWith("apple")){
            return removeApple( p, up.substring(5));
        }else{
            return removeApple(p + ch, up.substring(1) );
        }
    }

}
