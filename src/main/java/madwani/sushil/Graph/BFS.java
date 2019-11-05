package madwani.sushil.Graph;

import madwani.sushil.model.Graph;
import madwani.sushil.model.Node;
import madwani.sushil.service.GraphService;

public class BFS {

    public static void main(String[] args) {
        Graph g = new Graph(false);
        GraphService service = new GraphService();
        Node _0 = new Node(0,"zero");
        Node _1 = new Node(1,"one");
        Node _2 = new Node(2,"two");
        Node _3 = new Node(3,"three");
        Node _4 = new Node(4,"four");
        Node _5 = new Node(5,"five");
        service.addEdge(g,_0,_1);
        service.addEdge(g,_0,_2);
        service.addEdge(g,_1,_3);
        service.addEdge(g,_1,_2);
        service.addEdge(g,_1,_4);
        service.addEdge(g,_2,_4);
        service.addEdge(g,_2,_3);
        service.addEdge(g,_4,_5);
        service.print(g);
    }
}
