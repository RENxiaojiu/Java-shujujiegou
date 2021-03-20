package Test0310;

import java.util.Stack;

public class Test {

    // LeetCode 20. 有效的括号
    // 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '{' || a == '[' || a == '(') {
                stack.push(a);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character top = stack.pop();
            if (top == '(' && a == ')') {
                continue;
            }
            if (top == '[' && a == ']') {
                continue;
            }
            if (top == '{' && a == '}') {
                continue;
            }
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Test t = new Test();
        String s = "()[]{}";
        boolean a = t.isValid(s);
        System.out.println(a);
    }

}
