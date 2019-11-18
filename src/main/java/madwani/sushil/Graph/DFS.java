package madwani.sushil.Graph;

import madwani.sushil.model.Graph;
import madwani.sushil.model.Node;
import madwani.sushil.service.GraphService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {

    List<Node> nodes = new ArrayList<>();

    // to keep track of nodes which are visited
    HashMap<Node, Boolean> visited = new HashMap<>();

    public void dfs(Graph g){

        if(g.getAdjacencyMap() !=null) {

            // read all the nodes
            nodes = new ArrayList<>(g.getAdjacencyMap().keySet());

            // initialize all nodes as false for visited
            initializeVisited();

            // actual algo
            // root node to start the bfs
            Node root = new Node(3,"three");
            doDfs(g, root);
        }
    }

    private void doDfs(Graph g, Node root) {
       // mark node as visited
        visited.put(root, true);

        // print for visibility
        System.out.print(root.getN() + " -> ");

        //
        for (Node n : g.getAdjacencyMap().get(root)) {
            if(!visited.containsKey(n) || !visited.get(n)){
                doDfs(g,n);
            }
        }

    }

    public void initializeVisited() {
        for(Node n: nodes) {
            visited.put(n, false);
        }
    }

    public static void main(String[] args) {
        GraphService service = new GraphService();
        List<Graph> graphs = service.getSampleGraphs();
        DFS dfs = new DFS();
        dfs.dfs(graphs.get(0));
    }

}
