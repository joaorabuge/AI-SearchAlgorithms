package search_algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

/**
 * BreadthFirst class implements the Breadth-First Search (BFS) algorithm.
 * It extends the SearchAlgorithm class and provides the logic for searching
 * through a graph using BFS.
 * 
 * @author Joao Rabuge
 */
public class BreadthFirst extends SearchAlgorithm {

    // Instance of the graph on which the BFS algorithm will operate
    private Graph graph;
    
    // Flag to indicate if the target node has been found
    boolean encontrado = false;

    /**
     * Constructor for the BreadthFirst class.
     * Initializes the graph object.
     * 
     * @param graph The graph object on which the search is performed.
     */
    public BreadthFirst(Graph graph) {
        super(graph); // Call the constructor of the parent class SearchAlgorithm
        this.graph = graph;
    }

    /**
     * Method to start the BFS search.
     * 
     * @param n_initial The starting node of the search.
     * @param n_final The goal node of the search.
     * @return A list of nodes representing the path from the start node to the goal node.
     */
    @Override
    public List<Node> start(Node n_initial, Node n_final) {
        return breadthFirst(n_initial, n_final); // Calls the breadthFirst method to perform the search
    }

    /**
     * The Breadth-First Search (BFS) algorithm implementation.
     * 
     * @param n_initial The starting node.
     * @param n_final The goal node.
     * @return A list of nodes representing the path from the initial node to the final node.
     *         Returns an ordered list of nodes that forms the path to the goal.
     */
    private List<Node> breadthFirst(Node n_initial, Node n_final) {

        // Queue to manage nodes to be evaluated in a FIFO (First In, First Out) manner
        Queue<Node> ligacoes = new LinkedList<Node>();

        // Add the initial node to the queue to start the search
        ligacoes.add(n_initial);

        // Array of booleans to track visited nodes, initialized with the size of the graph's nodes
        boolean[] foiVisitado = new boolean[graph.numberOfNodes()];

        // Array to store parent nodes for path reconstruction
        Node[] pai = new Node[graph.numberOfNodes()];

        // Loop while there are nodes left to process in the queue
        while (!ligacoes.isEmpty()) {

            // Poll the first node from the queue to process it
            Node atual = ligacoes.poll();
            
            // Get the adjacency list for the current node
            List<Edge> lista = graph.getAdjacencyList().get(atual);

            // Mark the current node as visited
            foiVisitado[Integer.parseInt(atual.getLabel()) - 1] = true;

            // Iterate through each edge in the adjacency list of the current node
            for (Edge i : lista) {

                // Get the adjacent node from the current edge
                Node node = i.getN1();

                // Set the parent of the adjacent node to the current node
                pai[Integer.parseInt(node.getLabel()) - 1] = atual;

                // If the adjacent node is the goal node, set the encontrado flag to true
                if (node.equals(n_final)) {
                    encontrado = true;
                    break; // Exit the for loop as the goal has been found
                }

                // Add the adjacent node to the queue for further processing
                ligacoes.add(node);
            }

            // If the goal node has been found, exit the while loop
            if (encontrado) {
                break;
            }
        }

        // Create a list to store the path from the initial node to the final node
        List<Node> caminho = new ArrayList<Node>();

        // Start with the final node's index
        int indice = Integer.parseInt(n_final.getLabel()) - 1;

        // Add the final node to the path list
        caminho.add(n_final);

        // Reconstruct the path using the parent array
        while (pai[indice] != null) {
            caminho.add(pai[indice]); // Add the parent node to the path
            indice = Integer.parseInt(pai[indice].getLabel()) - 1; // Move to the next parent node
        }

        // Return the ordered path list using the porOrdem method
        return porOrdem(caminho);
    }
}
