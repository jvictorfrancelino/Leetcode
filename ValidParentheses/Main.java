package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(ValidParentheses2("([)]"));
    }

    public static boolean ValidParentheses(String s) {
        HashMap<String, Integer> hashString = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(!hashString.containsKey(ch)){
                hashString.put(String.valueOf(ch), 1);
            }else{
                hashString.put(String.valueOf(ch), hashString.get(ch).intValue() + 1);
            }
        }
        try {
            if (hashString.get("(").intValue() == hashString.get(")").intValue()) {
                return true;
            }
            if (hashString.get("[").intValue() == hashString.get("]").intValue()) {
                return true;
            }
            if (hashString.get("{").intValue() == hashString.get("}").intValue()) {
                return true;
            }
        }catch (Exception ex){
            return false;
        }
        return false;
    }
    public static boolean ValidParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}