package CommonProblems;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListInReverse {
    LinkedList<Integer> listOne;
    LinkedList<Integer> listTwo;

    public LinkedListInReverse() {
        listOne = new LinkedList<>(Arrays.asList(2, 4, 3, 1, 6, 5, 4));
        listTwo = new LinkedList<>(Arrays.asList(5, 6, 4, 2, 1));
    }

    public void addTwoLists() {
        addTwoListsWithStrings();
        addTwoListsByNumbers();
    }

    private void addTwoListsWithStrings() {
        String string1 = "";
        String string2 = "";
        Iterator<Integer> iterator = listOne.descendingIterator();
        while(iterator.hasNext()) {
            string1 += iterator.next().toString();
        }
        iterator = listTwo.descendingIterator();
        while(iterator.hasNext()) {
            string2 += iterator.next().toString();
        }
        int resultInt = Integer.parseInt(string1) + Integer.parseInt(string2);
        String resultString = "" + resultInt;
        char character;
        LinkedList<Integer> resultList = new LinkedList();
        for (int i = resultString.length() - 1; i >= 0; i--) {
            character = resultString.charAt(i);
            resultList.add(Integer.parseInt(String.valueOf(character)));
        }

        System.out.println(Arrays.toString(resultList.toArray()));
    }

    private void addTwoListsByNumbers() {
        ListNode listNodeOne = buildNodes(listOne, listTwo.size());
        ListNode listNodeTwo = buildNodes(listTwo, listOne.size());

        int carry = 0;
        int sum;
        LinkedList<Integer> resultList = new LinkedList<>();
        ListNode temp1 = listNodeOne;
        ListNode temp2 = listNodeTwo;
        while (temp1 != null || temp2 != null) {
            sum = carry + temp1.value + temp2.value;
            carry = sum / 10;
            resultList.add(sum % 10);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (carry > 0) {
            resultList.add(carry);
        }

        System.out.println(Arrays.toString(resultList.toArray()));
    }

    private ListNode buildNodes(LinkedList<Integer> list, int sizeofOtherList) {
        ListNode dummyHead = new ListNode(new ListNode());
        ListNode temp = dummyHead.next;
        int count = 0;
        for (Integer i : list) {
            temp.value = i;
            if (++count < list.size()) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        int sizeDifference = sizeofOtherList - list.size();
        if (sizeDifference > 0) {
            while (sizeDifference-- > 0) {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}

class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {}
    public ListNode(int value) {
        this.value = value;
    }
    public ListNode(ListNode next) {
        this.next = next;
    }

    public void print() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}