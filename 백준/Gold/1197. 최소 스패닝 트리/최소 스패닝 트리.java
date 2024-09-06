import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost == o.cost) {
            return 0;
        } else {
            return 1;
        }
    }
}
public class Main {

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x==y) return false;

        if (x>y) parent[x] = y;
        else parent[y] = x;

        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static int[] parent;
    static List<Edge> edgeList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        edgeList = new ArrayList<>();

        for (int i=0; i<e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edgeList.add(new Edge(a,b,c));
        }
        parent = new int[v+1];
        for (int i=1; i<=v; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0;
        for (int i=0; i<edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (union(edge.v1, edge.v2)) {
                sum += edge.cost;
            }
        }
        System.out.println(sum);
    }
}
