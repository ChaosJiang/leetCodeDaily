import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Project Name: leetcode
 * File Name: No150_EvaluateReversePolishNotation
 * Created by Chiangsir.
 * Date: AD 2021/03/07
 */
public class No150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            int result = 0;
            switch (token) {
                case "+":
                    result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "-":
                    int toNegate = stack.pop();
                    result = stack.pop() - toNegate;
                    stack.push(result);
                    break;
                case "*":
                    int toMulti = stack.pop();
                    result = stack.pop() * toMulti;
                    stack.push(result);
                    break;
                case "/":
                    int toDivide = stack.pop();
                    result = stack.pop() / toDivide;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }

        }
        return stack.pop();
    }
}
