import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class BFSTest {

    ArrayList<ArrayList<Integer>> createGraph_0(){
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        BFSearch.addEdge(adj, 1, 2);
        BFSearch.addEdge(adj, 1, 5);
        BFSearch.addEdge(adj, 1, 6);
        BFSearch.addEdge(adj, 2, 4);
        BFSearch.addEdge(adj, 2, 5);
        BFSearch.addEdge(adj, 2, 6);
        BFSearch.addEdge(adj, 3, 5);
        BFSearch.addEdge(adj, 4, 6);
        BFSearch.addEdge(adj, 4, 7);
        BFSearch.addEdge(adj, 5, 6);
        return adj;
    }

    ArrayList<ArrayList<Integer>> createGraph_1(){
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        BFSearch.addEdge(adj, 0, 1);
        BFSearch.addEdge(adj, 0, 2);
        BFSearch.addEdge(adj, 0, 3);
        BFSearch.addEdge(adj, 1, 3);
        BFSearch.addEdge(adj, 2, 6);
        BFSearch.addEdge(adj, 3, 5);
        BFSearch.addEdge(adj, 3, 7);
        BFSearch.addEdge(adj, 4, 6);
        BFSearch.addEdge(adj, 4, 7);
        BFSearch.addEdge(adj, 5, 6);
        BFSearch.addEdge(adj, 6, 7);
        return adj;
    }

    @Test
    @DisplayName("UnconnectedNodes")
    void testUnconnectedNodes() {
        ArrayList<ArrayList<Integer>> adj = createGraph_0();
        int source = 7, dest = 0;
        assertThrows(NotConnectedNodes.class, () -> BFSearch.getPathBFS(adj, source, dest, adj.size()));
    }

    @Test
    @DisplayName("Graph_0[3;7]")
    void testGraph0_3_7() {
        ArrayList<ArrayList<Integer>> adj = createGraph_0();
        int source = 3, dest = 7;
        LinkedList<Integer> answer = new LinkedList<>(Arrays.asList(3, 5, 2, 4, 7));
        try {
            assertEquals(answer, BFSearch.getPathBFS(adj, source, dest, adj.size()));
        } catch (NotConnectedNodes notConnectedNodes) {
            notConnectedNodes.printStackTrace();
        }
    }

    @Test
    @DisplayName("Graph_0[1;7]")
    void testGraph0_1_7() {
        ArrayList<ArrayList<Integer>> adj = createGraph_0();
        int source = 1, dest = 7;
        LinkedList<Integer> answer = new LinkedList<>(Arrays.asList(1, 2, 4, 7));
        try {
            assertEquals(answer, BFSearch.getPathBFS(adj, source, dest, adj.size()));
        } catch (NotConnectedNodes notConnectedNodes) {
            notConnectedNodes.printStackTrace();
        }
    }

    @Test
    @DisplayName("Graph_1[6;1]")
    void testGraph1_6_1() {
        ArrayList<ArrayList<Integer>> adj = createGraph_1();
        int source = 6, dest = 1;
        LinkedList<Integer> answer = new LinkedList<>(Arrays.asList(6, 2, 0, 1));
        try {
            assertEquals(answer, BFSearch.getPathBFS(adj, source, dest, adj.size()));
        } catch (NotConnectedNodes notConnectedNodes) {
            notConnectedNodes.printStackTrace();
        }
    }

    @Test
    @DisplayName("Graph_1[4;1]")
    void testGraph1_4_1() {
        ArrayList<ArrayList<Integer>> adj = createGraph_1();
        int source = 4, dest = 1;
        LinkedList<Integer> answer = new LinkedList<>(Arrays.asList(4, 7, 3, 1));
        try {
            assertEquals(answer, BFSearch.getPathBFS(adj, source, dest, adj.size()));
        } catch (NotConnectedNodes notConnectedNodes) {
            notConnectedNodes.printStackTrace();
        }
    }
}
