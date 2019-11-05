package madwani.sushil.service;

import madwani.sushil.model.Graph;
import madwani.sushil.model.Node;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphService {

    public static void main(String[] args) {
        GraphService service = new GraphService();
        service.print(service.getSampleGraph());
    }

    public void addEdge(Graph graph, Node src, Node dest) {
        HashMap<Node, LinkedList<Node>> adjMap = graph.getAdjacencyMap();
        LinkedList<Node> nodes = adjMap.get(src);
        if(nodes == null){
            nodes = new LinkedList<>();
            nodes.add(dest);
        }
        if(!nodes.contains(dest)) {
            nodes.add(dest);
        }
        adjMap.put(src,nodes);
        graph.setAdjacencyMap(adjMap);
    }

    public void print(Graph graph){
        for (Node n: graph.getAdjacencyMap().keySet()){

            LinkedList<Node> list = graph.getAdjacencyMap().get(n);
            if(list !=null && list.size()!=0) {
                System.out.print( n.getN() + " -> ");
                list.stream().forEach(e-> System.out.print(e.getN() + " -> "));
                System.out.print("null");
                System.out.println();
            }
        }
    }

    public Graph getSampleGraph(){
        Graph g = new Graph(false);
        Node _0 = new Node(0,"zero");
        Node _1 = new Node(1,"one");
        Node _2 = new Node(2,"two");
        Node _3 = new Node(3,"three");
        Node _4 = new Node(4,"four");
        Node _5 = new Node(5,"five");

        addEdge(g,_0,_1);
        addEdge(g,_0,_2);
        addEdge(g,_1,_3);
        addEdge(g,_1,_2);
        addEdge(g,_1,_4);
        addEdge(g,_2,_4);
        addEdge(g,_2,_3);
        addEdge(g,_4,_5);
        return g;
    }
}
