package CommonProblems;

import java.util.*;

public class LongestSubstring {
    private String s = "abcabcdabccceabcd";
    public LongestSubstring() {}

    public void findLongestSubstringWithoutRepeatingCharacter() {
        bruteForce();
        slidingWindow();
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
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                String result = "";
                for (Character c : set) {
                    result += c;
                }
                return result;
            }
        }
        return "";
    }

    private void slidingWindow() {
        Map<Character, Integer> map = new HashMap<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (result.length() < map.size()) {
                    result = s.substring(map.get(s.charAt(i)), i);
                }
            }
            map.put(s.charAt(i), i);
            //System.out.println(Arrays.toString(map.keySet().toArray()));
        }
        System.out.println("The answer is \"" + result + "\", with the length of " + result.length());
    }

}
