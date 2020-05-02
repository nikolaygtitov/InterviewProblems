package Graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GraphDFS {
    private Graph<Integer> graph;

    public GraphDFS(Graph<Integer> graph) {
        this.graph = graph;
        this.graph.addEdge(0, 1);
        this.graph.addEdge(0, 2);
        this.graph.addEdge(1, 2);
        this.graph.addEdge(2, 0);
        this.graph.addEdge(2, 3);
        this.graph.addEdge(3, 3);
    }

    public void graphDFS(int startingVertex) throws IllegalArgumentException {
        if (!graph.hasVertex(startingVertex)) {
            throw new IllegalArgumentException("There is no " + startingVertex + " starting vertex!");
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.add(startingVertex);
        visited.add(startingVertex);

        System.out.println("Graph DFS starting from vertex " + startingVertex + ":");
        System.out.println(stack.peek());

        traverseDFS(stack, visited);
    }

    private void traverseDFS(Stack<Integer> stack, Set<Integer> visited) {
        while (!stack.isEmpty()) {
            if (graph.getAdjacentVertexes(stack.peek()).isEmpty()) {
                stack.pop();
            } else {
                for (Integer i : graph.getAdjacentVertexes(stack.peek())) {
                    if (!visited.contains(i)) {
                        System.out.println(i);
                        visited.add(i);
                        stack.push(i);
                        traverseDFS(stack, visited);
                    }
                }
            }
            stack.pop();
        }
    }
}
