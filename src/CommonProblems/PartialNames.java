package CommonProblems;

import Trie.Trie;
import Trie.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class PartialNames {
    private String[][] input = {
            //{"add", "hack"},
            //{"add", "hackerrank"},
            //{"find", "hac"},
            //{"find", "hak"},
            //{"find", "ha"}
            {"add", "s"},
            {"add", "ss"},
            {"add", "sss"},
            {"add", "ssss"},
            {"add", "sssss"},
            {"find", "s"},
            {"find", "ss"},
            {"find", "sss"},
            {"find", "ssss"},
            {"find", "sssss"},
            {"find", "ssssss"}
    };

    public PartialNames() {}

    public void useTrieFindPartialNames() {
        System.out.println(Arrays.toString(storeResultInArray()));
    }

    private int[] storeResultInArray() {
        Trie trie = new Trie();
        ArrayList<String> findList = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j].equals("add")) {
                    trie.insert(input[i][++j]);
                } else if (input[i][j].equals("find")) {
                    findList.add(input[i][++j]);
                }
            }
        }

        int[] result = new int[findList.size()];
        int count = 0;
        Node node;

        for (String findName : findList) {
            node = trie.getLastNode(findName);
            if (node == null) {
                result[count++] = 0;
            } else {
                result[count++] = node.numOfChildren;
            }
        }

        return result;
    }

    public void useHashMapFindPartialNames() {
        System.out.println(Arrays.toString(storeResultInArrayV2()));
    }


    private int[] storeResultInArrayV2() {
        Map<Character, ArrayList<String>> hashMap= new HashMap<>();
        ArrayList<String> findList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j].equals("add")) {
                    if (hashMap.containsKey(input[i][j + 1].charAt(0))) {
                        hashMap.get(input[i][j + 1].charAt(0)).add(input[i][j + 1]);
                    } else {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(input[i][j + 1]);
                        hashMap.put(input[i][j + 1].charAt(0), list);
                    }
                } else if (input[i][j].equals("find")) {
                    findList.add(input[i][j + 1]);
                    count++;
                }
            }
        }
        int[] result = new int[count];
        count = 0;

        for (String findName : findList) {
            result[count] = 0;
            if (hashMap.containsKey(findName.charAt(0))) {
                for (String addName : hashMap.get(findName.charAt(0))) {
                    if (findName.length() <= addName.length()) {
                        if (addName.substring(0, findName.length()).equals(findName)) {
                            result[count]++;
                        }
                    }
                }
            }
            count++;
        }
        return result;
    }


}
