package GeneralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class GeneralTree<T> {
    public Node root;

    public GeneralTree(T name) {
        root = new Node(name);
    }

    public void insertStringNode(Node node, T name, boolean add) {
        Node child;
        Node newNode = new Node(add);
        String childName;
        String newNodeName = (String) name;

        Queue<Node> queue = new LinkedList();

        for (Object n : node.children) {
            queue.add((Node) n);
        }

        while (!queue.isEmpty()) {
            child = queue.poll();
            childName = (String) child.name;
            if (newNodeName.length() < childName.length()) {
                // One of the child names is greater than the new node
                // Create new node and add child node as the child of new node
                if (childName.substring(0, newNodeName.length()).equals(newNodeName)) {
                    if (newNode.name == null) {
                        newNode.name = name;
                        root.children.add(newNode);
                    }
                    newNode.children.add(child);
                    root.children.remove(child);
                }
            } else {
                // New node name is greater than child name. Just append as another child.
                if (newNodeName.substring(0, childName.length()).equals(childName)) {
                    insertStringNode(child, name, add);
                    newNode.name = "dummy";
                }
            }
        }
        if (newNode.name == null) {
            newNode.name = name;
            node.children.add(newNode);
        }
    }

    public int numberOfChildren(String name) {
        Queue<Node> queue = new LinkedList();
        Node node = null;
        boolean childNotFound = true;

        for (Object n : root.children) {
            queue.add((Node) n);
        }

        while (childNotFound) {
            node = queue.poll();
            if (node.name.equals(name)) {
                queue.clear();
                childNotFound = false;
            } else {
                for (Object childNode : node.children) {
                    queue.add((Node) childNode);
                }
            }
        }

        for (Object n : node.children) {
            queue.add((Node) n);
        }
        int count = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.add) {
                count++;
            }
            for (Object n : node.children) {
                queue.add((Node) n);
            }
        }
        return count;
    }

    public void print() {
        System.out.println("Tree with root: " + root.name);

        Queue<Node> queue = new LinkedList();
        ArrayList<Node> list;
        queue.add(root);

        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.remove());
            }

            for (Node node : list) {
                System.out.println(node.name + " has children: ");
                for (int i = 0; i < node.children.size(); i++) {
                    Node n = (Node) node.children.get(i);
                    System.out.print(n.name + ", ");
                    queue.add(n);
                }
            }
            System.out.println();
        }
    }
}

class Node<T> {
    public T name;
    public ArrayList<Node> children;
    public boolean add;

    public Node() {
        this.name = null;
        this.children = new ArrayList<>();
    }

    public Node(boolean add) {
        this.name = null;
        this.children = new ArrayList<>();
        this.add = add;
    }

    public Node(T name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.add = false;
    }
/**
    public Node(T name, Node child) {
        this.name = name;
        if (prefix) {
            this.children = new ArrayList<>();
        } else {
            this.children = null;
        }
    }*/
}