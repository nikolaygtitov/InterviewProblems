package Graphs;

public class GraphTest {
    public static void main(String[] args) {
        GraphImplementation<Integer> graph = new GraphImplementation<>(true);

        // Edges are added.
        // Since the graph is bidirectional, so boolean bidirectional is true
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the graph
        System.out.println("Graph:\n" + graph.toString());

        // Gives the no of vertices in the graph.
        graph.getVertexCount();

        // Gives the no of edges in the graph.
        graph.getEdgesCount();

        // Tells whether vertex is present or not
        graph.hasVertex(5);

        // Tells whether the edge is present or not.
        graph.hasEdge(3, 4);

    }
}
