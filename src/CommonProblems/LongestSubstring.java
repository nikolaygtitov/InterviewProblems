package CommonProblems;

import java.util.*;

public class LongestSubstring {
    private String s = "abcabcdabccceabcd";
    //private String s = "abcddeabcd";
    public LongestSubstring() {}

    public void findLongestSubstringWithoutRepeatingCharacter() {
        bruteForce();
        slidingWindow();
        slidingWindowOptimized();
    }

    private void bruteForce() {
        // O(n^3)
        String result = "";
        String tempResult;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                tempResult = allUniqueCharacters(i, j);
                if (result.length() < tempResult.length()) {
                    result = tempResult;
                }
            }
        }
        System.out.println("The answer is \"" + result + "\", with the length of " + result.length());
    }

    private String allUniqueCharacters(int start, int end) {
        //System.out.println(s.substring(start, end));
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return s.substring(start, i);
            } else {
                set.add(s.charAt(i));
            }
        }
        return s.substring(start, end);
    }

    private void slidingWindow() {
        Set<Character> set = new HashSet<>();
        String result = "";
        int i, j;
        i = j = 0;

        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                if (result.length() < j - i) {
                    result = s.substring(i, j);
                }
            }
        }
        System.out.println("The answer is \"" + result + "\", with the length of " + result.length());
    }

    private void slidingWindowOptimized() {
        Map<Character, Integer> map = new HashMap<>();
        String result = "";

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                if (i < map.get(s.charAt(j))) {
                    i = map.get(s.charAt(j));
                }
            }
            if (result.length() < j - i + 1) {
                result = s.substring(i, j + 1);
            }
            map.put(s.charAt(j), j + 1);
        }
        System.out.println("The answer is \"" + result + "\", with the length of " + result.length());
    }

}
