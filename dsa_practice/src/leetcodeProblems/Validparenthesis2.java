package leetcodeProblems;

import java.util.Stack;

class Validparenthesis2 {
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
    public int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }else{
                if( !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
         return stack.size();

    }

    public static void main(String[] args) {
        Validparenthesis2 vp2 = new Validparenthesis2();

        String str1 = "(((((())))))";//valid
        String str2 = "((())))))";//invalid

        System.out.println(vp2.minAddToMakeValid(str1));
        System.out.println(vp2.minAddToMakeValid(str2));
    }
}
