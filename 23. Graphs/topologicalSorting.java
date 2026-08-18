import java.util.ArrayList;
import java.util.Stack;

public class topologicalSorting {
    // Only applicable on Directed Acyclic Graphs (DAG).
    // Dependancy Graphs, sorting vertices (nodes) by dependancies.
    // Multiple Answers may exist.

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

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                dfsUtil(graph, i, visited, stack);
            }
        }

        System.out.print("Topological Sorted: ");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited, stack);
            }
        }

        stack.push(curr);
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        topologicalSort(graph);
    }
}
