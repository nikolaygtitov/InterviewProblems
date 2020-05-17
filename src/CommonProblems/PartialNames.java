package CommonProblems;

import GeneralTree.GeneralTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class PartialNames {
    private String[][] input = {
            {"add", "hack"},
            {"add", "hackerrank"},
            {"find", "hac"},
            {"find", "hak"}
            //{"find", "ha"}
    };
    private Map<Character, GeneralTree> map;

    public PartialNames() {
        map = new HashMap<>();
    }

    public void findPartialNames() {
        System.out.println(Arrays.toString(storeResultInArray()));
    }

    private int[] storeResultInArray() {
        ArrayList<String> addList = new ArrayList();
        ArrayList<String> findList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j].equals("add")) {
                    addList.add(input[i][++j]);
                } else if (input[i][j].equals("find")) {
                    String findString = input[i][++j];
                    if (map.containsKey(findString.charAt(0))) {
                        map.get(findString.charAt(0)).insertStringNode(map.get(findString.charAt(0)).root, findString, false);
                    } else {
                        GeneralTree generalTree = new GeneralTree(findString.charAt(0));
                        generalTree.insertStringNode(generalTree.root, findString, false);
                        map.put(findString.charAt(0), generalTree);
                    }
                    findList.add(findString);
                    count++;
                }
            }
        }

        for (String name : addList) {
            if (map.containsKey(name.charAt(0))) {
                map.get(name.charAt(0)).insertStringNode(map.get(name.charAt(0)).root, name, true);
            } else {
                GeneralTree generalTree = new GeneralTree(name.charAt(0));
                generalTree.insertStringNode(generalTree.root, name, true);
                map.put(name.charAt(0), generalTree);
            }
        }

        /**
        for (Map.Entry<Character, GeneralTree> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " --> ");
                entry.getValue().print();
        }*/
        int[] result = new int[count];
        count = 0;

        for (String findName : findList) {
            result[count++] = findChildren(findName);
        }

        return result;
    }

    private int findChildren(String name) {
        if (map.containsKey(name.charAt(0))) {
            return map.get(name.charAt(0)).numberOfChildren(name);
        } else {
            return 0;
        }

    }
}
