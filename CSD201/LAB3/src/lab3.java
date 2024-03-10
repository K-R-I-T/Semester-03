/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class Node {
    int dta;
    Node left = null, right = null;
    Node(int dta) {
        this.dta = dta;
    }
}

public class lab3 {
    //1
    int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
    //2
    int findmin(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return Integer.min(a[n - 1], findmin(a, n - 1));
    }
    //3
    int findsum(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return a[n - 1] + findsum(a, n - 1);
    }
    //4
    int ispalindrome(char c[], int n) {
        if (n == 0) {
            return 1;
        }
        if (c[n - 1 - (n - 1)] != c[n - 1]) {
            return 0;
        } else {
            ispalindrome(c, n - 1);
        }
        return 1;
    }
    //5
    int search(int a[], int s, int x) {
        int m = (s - 1) / 2;
        if (a[m] == x) {
            return m;
        }
        if (a[m] > x) {
            return search(a, s - 1, x);
        } else {
            return search(a, s + 1, x);
        }
    }
    
    void sort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] >= a[j]) {
                    a[i] = a[j] + a[i] - (a[j] = a[i]);
                }
            }
        }
    }
    //6
    int GCD(int m, int n) {
        if (n > 0) {
            return GCD(n, m % n);
        }
        return m;
    }
    //7
    int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return (x * power(x, n - 1));
    }
    //8
    int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
    //9
    int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    //10
    double addReciprocals(int n) {
        if (n == 1) {
            return (double) 1;
        }
        return (double)(1.0 / n) + addReciprocals(n - 1);
    }
    //11
    int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Integer.max(height(root.left), height(root.right));
    }
    //12
    int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
    
    public static void main(String[] args) {
        lab3 l = new lab3();
        System.out.println(l.sum(5));
        int[] a = {44, 31, 12, 50, 24, 10};
        System.out.println(l.findmin(a, 5));
        System.out.println(l.findsum(a, 3));
        char c[] = {'H', 'a', 'h', 'a', 'H'};
        System.out.println(l.ispalindrome(c, 5));
        l.sort(a);
        System.out.println(l.search(a, 6, 44));
        System.out.println(l.GCD(50, 15));
        System.out.println(l.power(2, 3));
        System.out.println(l.fact(6));
        System.out.println(l.fib(10));
        System.out.println(l.addReciprocals(2));
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        System.out.println(l.height(root));
        System.out.println(l.size(root));
    }
}
