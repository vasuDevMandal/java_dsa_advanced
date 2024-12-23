package dsa_practice.strings;

public class SkipCharsRecursion {
    public static void main(String[] args) {

        System.out.println(skip( "aagaaoatraewacfavaajadda"));

        String str = "erghrthcarretregtr";
        System.out.println(skipWord(str,"car"));

        str = "gdfgdfh_appl_dgdgfg__apple";
        System.out.println(skipAppleNotApp(str));
    }

//    static void skip(String p, String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//
//        char ch = up.charAt(0);
//        if(ch== 'a'){
//            skip(p, up.substring(1));
//        }else{
//            skip(p+ch,up.substring(1));
//        }
//
//    }

    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);
        if(ch== 'a'){
           return skip(up.substring(1));
        }else{
            return ch + skip(up.substring(1));
        }

    }

    static String skipWord(String up,String target){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith(target)){
            return skipWord(up.substring(target.length()-1), target);
        }else{
            return up.charAt(0) + skipWord(up.substring(1),target);
        }
    }


    static String skipAppleNotApp(String up){
        if(up.isEmpty()){
            return "";
        }
        if( up.startsWith("app") && !up.startsWith("apple")){
            return skipAppleNotApp(up.substring(3));
        }else{
            return up.charAt(0) + skipAppleNotApp(up.substring(1));
        }
    }



}
