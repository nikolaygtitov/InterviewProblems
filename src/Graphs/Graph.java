package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

/**
 * The Graph Class is implemented using HashMap in Java. As we know HashMap contains a key and a value, we represent
 * nodes as keys and their adjancency list in values in the graph.
 * @param <T>
 */
public class Graph<T> {
    private Map<T, List<T>> map;
    private boolean bidirectional;

    public Graph(boolean bidirectional) {
        map = new HashMap<>();
        this.bidirectional = bidirectional;
    }

    public void addEdge(T firstVertex, T secondVertex) {
        if (!map.containsKey(firstVertex)) {
            addVertex(firstVertex);
        }
        if (!map.containsKey(secondVertex)) {
            addVertex(secondVertex);
        }
        map.get(firstVertex).add(secondVertex);
        if (bidirectional) {
            map.get(secondVertex).add(firstVertex);
        }
    }

    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

    public void getVertexCount() {
        System.out.println("Graph has " + map.keySet().size() + " vertexes!");
    }

    public void getEdgesCount() {
        int count = 0;
        for (T vertex : map.keySet()) {
            count += map.get(vertex).size();
        }
        System.out.println("Graph has " + (bidirectional ? count / 2 : count) + " edges!");
    }

    public boolean hasVertex(int vertex) {
        if (map.containsKey(vertex)) {
            return true;
        }
        return false;
    }

    public void hasEdge(int firstVertex, int secondVertex) {
        if (map.containsKey(firstVertex)) {
            if (map.get(firstVertex).contains(secondVertex) && bidirectional) {
                System.out.println("Graph has the edge " + firstVertex + " <-> " + secondVertex);
            } else {
                System.out.println("Graph has the edge " + firstVertex + " -> " + secondVertex);
            }
        } else if (map.containsKey(secondVertex)) {
            System.out.println("Graph has the edge " + secondVertex + " -> " + firstVertex);
        } else {
            System.out.println("Graph does NOT have the edge " + firstVertex + " <-> " + secondVertex);
        }
    }

    public List<T> getAdjacentVertexes(int vertex) {
        return map.get(vertex);
    }


    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<T, List<T>> entry : map.entrySet()) {
            result += ("Vertex " + entry.getKey() + ": " + Arrays.toString(entry.getValue().toArray()) + "\n");
        }
        return result;
    }
}
