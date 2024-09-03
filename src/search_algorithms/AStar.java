package search_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

/**
 * AStar class implements the A* search algorithm.
 * It extends the SearchAlgorithm class and provides the logic for pathfinding
 * using the A* heuristic.
 * 
 * @author Joao Rabuge
 */
public class AStar extends SearchAlgorithm {

    // Instance of the graph on which the A* algorithm will operate
    private Graph graph;

    /**
     * Constructor for the AStar class.
     * Initializes the graph object.
     * 
     * @param graph The graph object on which the search is performed.
     */
    public AStar(Graph graph) {
        super(graph); // Call the constructor of the parent class SearchAlgorithm
        this.graph = graph;
    }

    /**
     * Method to start the A* search.
     * 
     * @param n_initial The starting node of the search.
     * @param n_final The goal node of the search.
     * @return A list of nodes representing the path from the start node to the goal node.
     */
    @Override
    public List<Node> start(Node n_initial, Node n_final) {
        return aStar(n_initial, n_final); // Calls the A* algorithm method to perform the search
    }

    /**
     * The A* search algorithm implementation.
     * 
     * @param n_initial The starting node.
     * @param n_final The goal node.
     * @return A list of nodes that represents the path from the initial node to the final node.
     *         Returns null if no path is found.
     */
    private List<Node> aStar(Node n_initial, Node n_final) {

        // Stack to manage nodes to be evaluated (LIFO: Last In, First Out)
        Stack<Node> q = new Stack<Node>();

        // List to store the path from start to goal node
        List<Node> caminho = new ArrayList<Node>();

        // Initialize the search by adding the starting node to the stack and path list
        q.add(n_initial);
        caminho.add(n_initial);

        // Loop until the initial node becomes the goal node
        while (n_initial != n_final) {

            // If there are no adjacent nodes for the node at the top of the stack
            if (graph.getAdjacencyList().get(q.peek()) == null) {
                q.pop(); // Remove the node from the stack
            }

            // Iterate through the edges of the node currently being processed
            for (Edge i : graph.getAdjacencyList().get(q.pop())) {

                // If the cost + heuristic of the current node is greater than that of an adjacent node
                if (n_initial.getF() > i.getN1().getF()) {
                    // Update the cost of the adjacent node
                    i.getN1().setCost(i.getCost() + n_initial.getCost());

                    // Add the adjacent node to the path list
                    caminho.add(i.getN1());

                    // Update the initial node to be the current adjacent node
                    n_initial = i.getN1();

                    // If the updated initial node is the goal node, exit the loop
                    if (n_initial == n_final)
                        break;

                    // Add the current node back to the stack for further processing
                    q.add(n_initial);
                }

                // Check if the goal node has been reached
                if (n_initial == n_final) {
                    q.add(n_initial); // Add the goal node to the stack
                    return caminho; // Return the path list as the result
                }
            }

            // If the stack is empty and no path is found, return null
            if (q.size() == 0)
                return null;
        }

        return caminho; // Return the final path once the goal is reached
    }
}
