import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topologicalSorting_KahnAlgo {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static ArrayList<Edge>[] createGraph() {
        ArrayList<Edge>[] graph = new ArrayList[6];

        for(int i = 0; i < 6; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        return graph;
    }

    public static void kahnAlgo(ArrayList<Edge>[] graph) {

        // Calculating inDegree of each vertex
        int[] inDeg = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].size(); j++) {
                inDeg[graph[i].get(j).dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDeg.length; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        kahnAlgo(graph);
    }
}
