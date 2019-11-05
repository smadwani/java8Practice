package madwani.sushil.model;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public HashMap<Node, LinkedList<Node>> getAdjacencyMap() {
        return adjacencyMap;
    }

    public void setAdjacencyMap(HashMap<Node, LinkedList<Node>> adjacencyMap) {
        this.adjacencyMap = adjacencyMap;
    }
}
