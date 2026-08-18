import java.util.ArrayList;

public class cycleDetectionUndirected {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static ArrayList<Edge>[] createGraph() {
        ArrayList<Edge>[] graph = new ArrayList[7];

        for(int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

        return graph;
    }

    public static boolean solution(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                if(dfsUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsUtil(ArrayList<Edge>[] graph, boolean[] visited, int src, int parent) {
        visited[src] = true;

        for(int i = 0; i < graph[src].size(); i++) {
            int neighbour = graph[src].get(i).dest;
            if(!visited[neighbour]) {
                if(dfsUtil(graph, visited, neighbour, src)) {
                    return true;
                }
            } else if(neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        System.out.println(solution(graph));
    }
}
