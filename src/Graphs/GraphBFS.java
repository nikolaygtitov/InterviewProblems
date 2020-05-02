package Graphs;

import java.util.*;

public class GraphBFS<T> {
    private Graph<Integer> graph;

    public GraphBFS(Graph<Integer> graph) {
        this.graph = graph;
        this.graph.addEdge(0, 1);
        this.graph.addEdge(0, 2);
        this.graph.addEdge(1, 2);
        this.graph.addEdge(2, 0);
        this.graph.addEdge(2, 3);
        this.graph.addEdge(3, 3);
    }

    public void graphBFS(int startingVertex) throws IllegalArgumentException {
        if (!graph.hasVertex(startingVertex)) {
            throw new IllegalArgumentException("There is no " + startingVertex + " starting vertex!");
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingVertex);
        System.out.println("Graph BFS starting from vertex " + startingVertex + ":");
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            visited.add(queue.peek());
            for (Integer i : graph.getAdjacentVertexes(queue.poll())) {
                if (!visited.contains(i)) {
                    queue.add(i);
                }
            }
        }
    }
}
