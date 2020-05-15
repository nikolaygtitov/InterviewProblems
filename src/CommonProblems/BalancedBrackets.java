package CommonProblems;

import com.sun.source.doctree.SerialTree;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
    private Map<Character, Character> map;
    private String s = "{[()]}()()()[[[[[[[[[[(((((((((((({{{{{{{{{{{{{{}}}}}}}}}}}}}}))))))))))))]]]]]]]]]]";
    public BalancedBrackets() {
        map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        System.out.println(isBalanced());
    }

    private boolean isBalanced() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
