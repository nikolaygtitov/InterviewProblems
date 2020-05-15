package CommonProblems;

import java.util.Stack;

public class LongestPalindromic {
    private String s = "xyzabcbffaffbcbazyx";
    //private String s = "babad";
    //private String s = "abcdcbejklolkjeb";
    private String rightString = "";
    private Stack<Character> workingStack, answerStack;

    public LongestPalindromic() {
        workingStack = new Stack();
        answerStack = new Stack<>();
    }

    public void findLongestPalindromicSubstring() {
        workingStack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (workingStack.peek() == s.charAt(i)) {
                // Need to start popping from working stack
                popIntoAnswerStack(i);
            } else if (i + 1 < s.length() && workingStack.peek() == s.charAt(i + 1)) {
                workingStack.push(s.charAt(i++));
                popIntoAnswerStack(i);
            }
            workingStack.push(s.charAt(i));
        }

        // Print answer
        String leftString = "";
        while (!answerStack.isEmpty()) {
            leftString += answerStack.pop();
        }
        System.out.println("The longest palindromic substring is: \"" + leftString.concat(rightString) + "\"");
    }

    private void popIntoAnswerStack(int index) {
        Stack<Character> tempStack = new Stack<>();
        String tempString = "";
        if (workingStack.peek() != s.charAt(index)) {
            tempStack.push(workingStack.pop());
        }
        while (!workingStack.isEmpty() && index < s.length() && workingStack.peek() == s.charAt(index++)) {
            char c = workingStack.pop();
            tempString += c;
            tempStack.push(c);
        }
        if (answerStack.size() < tempStack.size()) {
            rightString = tempString;
            answerStack = tempStack;
        }
        workingStack.clear();
    }
}
