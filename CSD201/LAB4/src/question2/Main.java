/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        
        tree.insert("HA");
        tree.insert("AH");
        tree.insert("HAH");
        tree.clear();
        System.out.println("Is tree Empty? " + tree.isEmpty());
        System.out.println("");
        
        tree.insert("Thuc");
        tree.insert("Hieu");
        tree.insert("Phuong");
        tree.insert("Dat");
        tree.insert("Tuyet");
        tree.insert("Nam");
        tree.insert("Phuc");
        
        System.out.print("Breadth-first traversal:");
        tree.breadth();
        System.out.println("");
        
        System.out.print("Preorder traversal:");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Inorder traversal:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal:");
        tree.postorder(tree.root);
        System.out.println();
        
        System.out.println("Number nodes of tree: " + tree.count());
        System.out.println("");
        
        tree.delete("Thuc");
        System.out.print("Inorder traversal after deleting Thuc:");
        tree.inorder(tree.root);
        System.out.println("");
        
        System.out.println("Min value in the tree: " + tree.min().key);
        System.out.println("Max value in the tree: " + tree.max().key);
        System.out.println("");
        
        System.out.println("Tree height: " + tree.height());
        System.out.println("");
        
        System.out.println("Is AVL tree? " + tree.isAVL());
        System.out.println("Is heap? " + tree.isHeap());
        System.out.println("");
    }
}
