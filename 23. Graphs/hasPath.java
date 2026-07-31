import java.util.ArrayList;

public class hasPath {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public String toString() {
            return "(" + src + "->" + dest + ", wt:" + wt + ")";
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

    public static boolean solution(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String path) {
        if(src == dest) {
            System.out.println("Path: " + path + dest);
            return true;
        }

        visited[src] = true;

        for(int i = 0; i < graph[src].size(); i++) {
            int neighbour = graph[src].get(i).dest;

            if(!visited[neighbour]) {
                if(solution(graph, neighbour, dest, visited, path + src + " -> ")) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        int src = 0;
        int dest = 5;

        System.out.print("Does the Path exists? " + solution(graph, src, dest, new boolean[graph.length], ""));
    }
}
