/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.util.LinkedList;

/**
 *
 * @author Admin
 */

class Graph {

    int[][] a;
    String[] lable;
    int n;

    void clear() {
        a = null;
        n = 0;
    }

    void setAMatrix(int[][] b, int m) {
        n = m;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(b[i], 0, a[i], 0, n);
        }
    }

    void setLable(String[] c) {
        lable = new String[n];
        System.arraycopy(c, 0, lable, 0, n);
    }

    void visit(int i) {
        System.out.print(lable[i] + " ");
    }

    void BFT(int i, boolean enqueued[]) {
        MyQueue q = new MyQueue();
        q.enqueue(i);
        enqueued[i] = true;
        while (!q.isEmpty()) {
            int r = q.dequeue();
            visit(r);
            for (int j = 0; j < n; j++) {
                if (!enqueued[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    enqueued[j] = true;
                }
            }
        }
    }

    void BFT(int k) {
        boolean[] enqueued = new boolean[n];
        System.out.println("Breadth-first traversal from the vertex " + lable[k] + ":");
        BFT(k, enqueued);
        for (int i = 0; i < n; i++) {
            if (!enqueued[i]) {
                BFT(i, enqueued);
            }
        }
        System.out.println("");
    }

    void DFT(int k, boolean c[]) {
        c[k] = true;
        visit(k);
        for (int i = 0; i < n; i++) {
            if (!c[i] && a[k][i] > 0) {
                DFT(i, c);
            }
        }
    }

    void DFT(int k) {
        boolean c[] = new boolean[n];
        System.out.println("Depth-first traversal from the vertex " + lable[k] + ":");
        DFT(k, c);
        for (int i = 0; i < n; i++) {
            if (!c[i]) {
                DFT(i, c);
            }
        }
        System.out.println("");
    }
}

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] b = {
            {0, 1, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},};
        String[] c = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        g.setAMatrix(b, 9);
        g.setLable(c);
        g.BFT(0);
        g.DFT(0);
    }
}

class MyQueue {

    LinkedList<Integer> q = new LinkedList<>();

    boolean isEmpty() {
        return q.isEmpty();
    }

    void enqueue(int x) {
        q.add(x);
    }

    int dequeue() {
        return q.removeFirst();
    }
}
