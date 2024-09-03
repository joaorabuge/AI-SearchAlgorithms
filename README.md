# Artificial Intelligence – Search Algorithms

## 2nd Semester 2021/22

### Project Overview

This project is focused on implementing search algorithms to solve a problem inspired by the **Dungeons & Dragons** game. The player starts in dungeon 6 and must find a path to dungeon 11 using various search algorithms. The project will be implemented in Java, and the final submission should be a compressed folder extracted directly from Eclipse (or an equivalent IDE).


### Problem Description

In this project, you will implement search algorithms to help a player navigate through a map of dungeons and corridors. The player begins in dungeon 6, with the goal of reaching dungeon 11. The map contains corridors, dungeons numbered from 1 to 11, and doors. The initial map was randomly generated using the following link: [Random Dungeon Generator](https://donjon.bin.sh/fantasy/dungeon/).

### Project Tasks

1. **Graph Representation**:
    - Convert the map into a graph that represents the problem's search space.
    - Create an instance of the graph using the provided Java classes (`Graph.java`, `Node.java`, `Edge.java`) and place it in the appropriate package (e.g., `tests`).
    - Include an image of the graph representation in the project folder before exporting it for submission.

2. **Implementation of Search Algorithms**:
    - Implement the Breadth-First Search (BFS) and Depth-First Search (DFS) algorithms.
    - These algorithms should extend the abstract class `SearchAlgorithm.java` and be placed in the `search_algorithm` package.
    - The abstract class includes attributes and methods to manage a graph and its adjacency list. Use these to create BFS and DFS classes that override the abstract method `start(Node nInitial, Node nFinal)`.
    - Test both algorithms using the class `SolutionBreadthDepth.java` to find a path from dungeon 6 to dungeon 11.

3. **Implementation of A* Algorithm**:
    - Implement the A* search algorithm, which should also extend `SearchAlgorithm.java` and be included in the `search_algorithms` package.
    - Create a heuristic function and assign a heuristic value to each node using:
        - `Node.setHeuristic(int heuristic)` or
        - `Node(String label, int heuristic)` constructor.
    - Assign a cost to each edge between nodes using:
        - `Edge(Node n0, Node n1, int cost)` constructor or
        - `Graph.addEdges(Node n0, Node n1, int cost)` method.
    - Document the heuristic function and the cost associated with each edge in the code comments.

### Testing

- Use the class `SolutionBreadthDepth.java` to run and test both BFS and DFS algorithms.
- Implement tests for the A* algorithm to validate that the player can find the optimal path from dungeon 6 to dungeon 11.

### Additional Notes

- You may modify the provided code, add methods, and attributes as necessary. However, you must document any changes and justify them within the code comments.
- The structure of the classes `Graph.java`, `Node.java`, and `Edge.java` should not be altered.
