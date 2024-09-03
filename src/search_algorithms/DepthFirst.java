package search_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

/**
 * DepthFirst class implements the Depth-First Search (DFS) algorithm.
 * It extends the SearchAlgorithm class and provides the logic for searching
 * through a graph using DFS.
 * 
 * @author Joao Rabuge
 */
public class DepthFirst extends SearchAlgorithm {

    // Instance of the graph on which the DFS algorithm will operate
    private Graph graph;

    /**
     * Constructor for the DepthFirst class.
     * Initializes the graph object.
     * 
     * @param graph The graph object on which the search is performed.
     */
    public DepthFirst(Graph graph) {
        super(graph); // Call the constructor of the parent class SearchAlgorithm
        this.graph = graph;
    }

    /**
     * Method to start the DFS search.
     * 
     * @param n_initial The starting node of the search.
     * @param n_final The goal node of the search.
     * @return A list of nodes representing the path from the start node to the goal node.
     */
    @Override
    public List<Node> start(Node n_initial, Node n_final) {
        return depthFirst(n_initial, n_final); // Calls the depthFirst method to perform the search
    }

    /**
     * The Depth-First Search (DFS) algorithm implementation.
     * 
     * @param n_initial The starting node.
     * @param n_final The goal node.
     * @return A list of nodes that represents the path from the initial node to the final node.
     *         Returns an ordered list of nodes that forms the path to the goal.
     */
    private List<Node> depthFirst(Node n_initial, Node n_final) {

        // Number of nodes in the graph
        int numeroDeNodes = graph.numberOfNodes();

        // Array to store parent nodes for path reconstruction
        Node[] pai = new Node[numeroDeNodes];

        // Array of booleans to track visited nodes
        boolean[] foiVisitado = new boolean[numeroDeNodes];

        // Recursively find the path from the initial node to the final node
        List<Node> resultado = recursaoDepthFirst(n_initial, foiVisitado, n_final, pai);

        // List to store the final path of nodes
        List<Node> caminho = new ArrayList<>();

        // Add the final node to the path list
        caminho.add(n_final);

        // Start with the final node's index
        int indice = Integer.parseInt(n_final.getLabel()) - 1;

        // Filter the result to build the path in order
        while (resultado.get(indice) != null) {
            caminho.add(resultado.get(indice));
            indice = Integer.parseInt(resultado.get(indice).getLabel()) - 1;
        }

        // Return the ordered path list using the porOrdem method
        return porOrdem(caminho);
    }

    /**
     * Recursive implementation of the DFS algorithm.
     * 
     * @param atual The current node being explored.
     * @param foiVisitado Boolean array tracking visited nodes.
     * @param n_final The goal node.
     * @param pai Array of nodes storing parent-child relationships.
     * @return A list of nodes that represents the path from the initial node to the final node.
     */
    List<Node> recursaoDepthFirst(Node atual, boolean[] foiVisitado, Node n_final, Node[] pai) {

        // List to store the DFS path
        List<Node> caminho = new ArrayList<Node>();

        // Add elements to the path and parent arrays
        adicionarElementos(caminho, pai);

        // Mark the current node as visited
        foiVisitado[Integer.parseInt(atual.getLabel()) - 1] = true;

        // Check if there are no adjacent nodes or if the current node is the goal
        if (graph.getAdjacencyList().get(atual) == null) {
            return Arrays.asList(pai); // Return the parent nodes list
        } else if (atual.equals(n_final)) {
            return Arrays.asList(pai); // Return the parent nodes list
        }

        // Iterate through the adjacency list of the current node
        for (Edge i : graph.getAdjacencyList().get(atual)) {

            // If the adjacent node has not been visited
            if (!foiVisitado[Integer.parseInt(i.getN1().getLabel()) - 1]) {

                // Set the parent of the adjacent node
                pai[Integer.parseInt(i.getN1().getLabel()) - 1] = i.getN0();

                // If the adjacent node is the goal node, set it as the current node
                if (i.getN1().equals(n_final)) {
                    pai[Integer.parseInt(i.getN1().getLabel()) - 1] = atual;
                    return Arrays.asList(pai); // Return the parent nodes list
                }

                // Recursively call DFS on the adjacent node
                caminho = recursaoDepthFirst(i.getN1(), foiVisitado, n_final, pai);
            }
        }

        return caminho; // Return the path list
    }
}
