package madwani.sushil.Graph;

import madwani.sushil.model.Graph;
import madwani.sushil.model.Node;
import madwani.sushil.service.GraphService;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {

    List<Node> nodes = new ArrayList<>();

    // to keep track of neighboring node
    Queue<Node> nodeQueue = new ArrayBlockingQueue<>(200);

    // to keep track of nodes which are visited
    HashMap<Node, Boolean> visited = new HashMap<>();

    public void bfs(Graph g){

        if(g.getAdjacencyMap() !=null) {

            // read all the nodes
            nodes = new ArrayList<>(g.getAdjacencyMap().keySet());

            // initialize all nodes as false for visited
            initializeVisited();

            //actual algo
            doBfs(g);
        }
    }

    public void doBfs(Graph g){

        // root node to start the bfs, push to queue
        nodeQueue.add(new Node(3,"three"));

        // poll the queue and run algo till queue is empty
        do {
            Node initialNode = nodeQueue.poll();

            // get all the adjacent nodes of the polled node
            LinkedList<Node> adjacentNodes = g.getAdjacencyMap().get(initialNode) == null ?
                    new LinkedList<>():g.getAdjacencyMap().get(initialNode);

            // if not visited, get all adjacent nodes
            // print it for visibility purpose
            // mark it visited
            if(!visited.containsKey(initialNode) || !visited.get(initialNode)) {
                for (Node node: adjacentNodes){
                    nodeQueue.add(node);
                }
                System.out.print(initialNode.getN() + "   ");
                visited.put(initialNode, true);
            }
        } while (!nodeQueue.isEmpty());
    }

    public void initializeVisited() {
        for(Node n: nodes) {
            visited.put(n, false);
        }
    }

    public static void main(String[] args) {
        GraphService service = new GraphService();
        List<Graph> graphs = service.getSampleGraphs();
        BFS bfs = new BFS();
        bfs.bfs(graphs.get(0));
    }
}
