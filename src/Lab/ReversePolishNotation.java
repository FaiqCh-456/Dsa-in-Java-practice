package Lab;

import java.util.Stack;

public class ReversePolishNotation {

    public static int calculate(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("+")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 + op2);
            } else if (t.equals("-")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 - op2);
            } else if (t.equals("*")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 * op2);
            } else if (t.equals("/")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 / op2);
            } else {
                s.push(Integer.parseInt(t));
            }
        }

        return s.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*" ,"33","12","/","+"};
        int result = calculate(tokens);
        System.out.println("Result: " + result);
    }
}
