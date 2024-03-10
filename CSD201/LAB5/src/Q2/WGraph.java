/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author Admin
 */
public class WGraph {

    int[][] a;
    int n;
    char[] vertex = "ABCDEFGH".toCharArray();
    final int INF = 99;

    public WGraph() {
        int[][] b = {
            {0, 14, 4, 5, INF, INF, INF, INF},
            {14, 0, 2, INF, 9, INF, INF, INF},
            {4, 2, 0, 6, 10, INF, INF, INF},
            {5, INF, 6, 0, INF, 7, INF, 12},
            {INF, 9, 10, INF, 0, 15, 8, INF},
            {INF, INF, INF, 7, 15, 0, 11, 22},
            {INF, INF, INF, INF, 8, 11, 0, INF},
            {INF, INF, INF, 12, INF, 22, INF, 0}
        };
        a = b;
        n = a.length;
    }

    void displayW() {
        System.out.println("- The weighted matrix of the graph:");
        System.out.print("---------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                if (a[i][j] == INF) {
                    System.out.printf(" INF");
                } else {
                    System.out.printf(" %3d", a[i][j]);
                }
            }
        }
        System.out.println("");
    }

    void dijkstra(int u, int v) {
        boolean[] c = new boolean[n];
        int[] s = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = u;
            d[i] = a[u][i];
        }
        int curr = u;
        while (curr != v) {
            int k = -1, min = INF;
            for (int i = 0; i < n; i++) {
                if (d[i] < min && !c[i]) {
                    min = d[i];
                    k = i;
                }
            }
            if (min == INF) {
                System.out.println("Shortest path from u to v not found");
                return;
            }
            curr = k;
            c[k] = true;
            for (int i = 0; i < n; i++) {
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    s[i] = k;
                }
            }
        }
        System.out.println("Shortest path from u to v is " + d[v]);
        int[] h = new int[n];
        int hn = 0;
        h[hn] = v;
        int[] w = new int[n];
        int wn = 0;
        int x, y = v;
        while (u != v) {
            v = s[v];
            h[++hn] = v;
        }
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[wn] = a[x][y];
            wn++;
        }
        int k = 1;
        System.out.print(vertex[h[hn]]);
        for (int i = hn - 1; i >= 0; i--) {
            System.out.print("->" + vertex[h[i]] + "(" + d[h[i]] + ")");
        }
        System.out.println("");
    }
}

class Main {

    public static void main(String[] args) {
        WGraph w = new WGraph();
        w.displayW();
        w.dijkstra(0, 7);
    }
}
