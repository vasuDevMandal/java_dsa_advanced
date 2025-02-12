package leetcodeProblems;

import java.util.Stack;

public class ValidParenthesis {

//LC 20
    boolean checkParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else {
                if(ch == ')'){
                    if(stack.isEmpty() || stack.pop() != '(' ){
                        return false;
                    }
                }
                if(ch == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
                if(ch == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParenthesis cp = new ValidParenthesis();
        String str1 = "[[{(())}]]";//correct
        String str2 = "[[(()}]]";//wrong

        System.out.println(str1 +" | isValid: " + cp.checkParenthesis(str1));
        System.out.println(str2 +" | isValid: " + cp.checkParenthesis(str2));
    }

}


