package tests;

import graph_utils.*;
import search_algorithms.*;

public class SolutionAstar {
	public static void main(String[] args) {
		/*
		 * TO DO Aqui deves: 
		 * 		- criar a instancia do grafo que representa o mapa das
		 * 		masmorras (ver classe Exemplo.java) e explicar a funcao heuristica escolhida
		 * 		bem como os custos associados aos arcos (edges) 
		 * 		- colocar o c�digo para testar o algoritmo criado
		 * 
		 */




		Graph graph = new Graph();
		AStar star = new AStar(graph);

		Node n1 = new Node("1",3);
		Node n2 = new Node("2",3);
		Node n3 = new Node("3",4);
		Node n4 = new Node("4",1);
		Node n5 = new Node("5",2);
		Node n6 = new Node("6",2);
		Node n7 = new Node("7",6);
		Node n8 = new Node("8",3);
		Node n9 = new Node("9",8);
		Node n10 = new Node("10",1);
		Node n11 = new Node("11",0);

		graph.addEdge(n6, n10,2);
		graph.addEdge(n10, n4,4);
		graph.addEdge(n4, n3,10);
		graph.addEdge(n4, n8,11);
		graph.addEdge(n3, n9,22);
		graph.addEdge(n3, n11,25);
		graph.addEdge(n9, n7,1);
		graph.addEdge(n8, n5,15);
		graph.addEdge(n5, n2,1);
		graph.addEdge(n5, n1,9);
		graph.addEdge(n5, n11,13);


		System.out.println("-------------------A* Algorithm--------------------");
		System.out.println("\r\n");
		System.out.println("Initial node: " + n6.getLabel());
		System.out.println("Final node: " + n11.getLabel());
		System.out.println("\r\n");
		star.printResult(star.startSearch(n6, n11));
		System.out.println("----------------End of A* Algorithm----------------");
		System.out.println("\r\n");
		System.out.println("\r\n");

	}
}
