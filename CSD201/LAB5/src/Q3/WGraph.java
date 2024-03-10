/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author Admin
 */
public class WGraph {

    int[][] a;
    int n;

    public WGraph() {
        int[][] b = {
            {0, 14, 4, 5, 0, 0, 0, 0},
            {14, 0, 2, 0, 9, 0, 0, 0},
            {4, 2, 0, 6, 10, 0, 0, 0},
            {5, 0, 6, 0, 0, 7, 0, 12},
            {0, 9, 10, 0, 0, 15, 8, 0},
            {0, 0, 0, 7, 15, 0, 11, 22},
            {0, 0, 0, 0, 8, 11, 0, 0},
            {0, 0, 0, 12, 0, 22, 0, 0}
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
                System.out.printf(" %2d", a[i][j]);
            }
        }
        System.out.println("");
    }

    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < n; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[i][parent[i]]);
        }
    }

    void primMST() {
        int parent[] = new int[n];
        int key[] = new int[n];
        Boolean mstSet[] = new Boolean[n];
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < n; v++) {
                if (a[u][v] != 0 && mstSet[v] == false && a[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = a[u][v];
                }
            }
        }
        printMST(parent, a);
    }
}

class Main {

    public static void main(String[] args) {
        WGraph w = new WGraph();
        w.displayW();
        w.primMST();
    }
}
