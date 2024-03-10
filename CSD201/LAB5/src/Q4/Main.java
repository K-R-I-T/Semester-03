/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] b = {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 1, 0}};
        g.setAMatrix(b, 5);
        g.setColor();
    }
}

class Graph {

    int[][] a;
    int n;

    void setAMatrix(int[][] b, int m) {
        n = m;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(b[i], 0, a[i], 0, n);
        }
    }
    
    void setColor() {
        int[] color = new int[n];
        for (int i : color) {
            i = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (color[j] == color[i] && a[i][j] == 1) {
                    color[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " --->  Color " + color[i]);
        }
    }
}
