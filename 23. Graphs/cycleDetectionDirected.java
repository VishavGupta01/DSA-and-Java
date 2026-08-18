import java.util.ArrayList;

public class cycleDetectionDirected {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static ArrayList<Edge>[] createAcyclicGraph() {
        ArrayList<Edge>[] graph = new ArrayList[4];

        for(int i = 0; i < 4; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));

        return graph;
    }

    public static ArrayList<Edge>[] createCyclicGraph() {
        ArrayList<Edge>[] graph = new ArrayList[4];

        for(int i = 0; i < 4; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

        return graph;
    }

    public static boolean cycleDetectionDirected(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] recStack = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                if(dfsUtil(graph, i, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] recStack) {
        visited[curr] = true;
        recStack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]) {
                if(dfsUtil(graph, e.dest, visited, recStack)) {
                    return true;
                }
            } else if(recStack[e.dest]) {
                return true;
            }
        }
        recStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createAcyclicGraph();

        System.out.println(cycleDetectionDirected(graph));
    }
}
