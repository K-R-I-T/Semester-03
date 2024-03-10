/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Administrator
 */

class Node{
    String key;
    Node left , right ;

    public Node(String key) {
        this.key = key;
        left = right = null ;
    }
}

public class BST {
     Node root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Node search(String x) {
        return search(root, x);
    }

    private Node search(Node node, String x) {
        if (node == null || node.key.equals(x)) {
            return node;
        }
        if (x.compareTo(node.key) < 0) {
            return search(node.left, x);
        } else {
            return search(node.right, x);
        }
    }

    public void insert(String x) {
        root = insert(root, x);
    }

    private Node insert(Node node, String x) {
        if (node == null) {
            return new Node(x);
        }
        if (x.compareTo(node.key) < 0) {
            node.left = insert(node.left, x);
        } else if (x.compareTo(node.key) > 0) {
            node.right = insert(node.right, x);
        }
        return node;
    }

    public void breadth() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.key + " ");
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public int count() {
        return count(root);
    }

    private int count(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

    public void delete(String x) {
        root = delete(root, x);
    }

    private Node delete(Node node, String x) {
        if (node == null) {
            return node;
        }
        if (x.compareTo(node.key) < 0) {
            node.left = delete(node.left, x);
        } else if (x.compareTo(node.key) > 0) {
            node.right = delete(node.right, x);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            node.key = min(node.right);
            node.right = delete(node.right, node.key);
        }

        return node;
    }

    private String min(Node node) {
        String min = node.key;
        while (node.left != null) {
            min = node.left.key;
            node = node.left;
        }
        return min;
    }

    public Node min() {
        return minNode(root);
    }

    private Node minNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node max() {
        return maxNode(root);
    }

    private Node maxNode(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }

    public boolean isAVL() {
        return isAVL(root);
    }

    private boolean isAVL(Node node) {
        if (node == null) {
            return true;
        }
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) <= 1 && isAVL(node.left) && isAVL(node.right)) {
            return true;
        }
        return false;
    }

    public boolean isHeap() {
        return isHeap(root);
    }

    private boolean isHeap(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.left.key.compareTo(node.key) > 0) {
            return false;
        }
        if (node.right != null && node.right.key.compareTo(node.key) < 0) {
            return false;
        }
        return isHeap(node.left) && isHeap(node.right);
    }
}
