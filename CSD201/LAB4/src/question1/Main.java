/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.clear();
        System.out.println("Is tree Empty? " + tree.isEmpty());
        System.out.println("");
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(80);
        tree.insert(60);
        
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
        
        tree.delete(20);
        System.out.print("Inorder traversal after deleting 20:");
        tree.inorder(tree.root);
        System.out.println("");
        
        System.out.println("Min value in the tree: " + tree.min().key);
        System.out.println("Max value in the tree: " + tree.max().key);
        System.out.println("Sum of all values: " + tree.sum());
        System.out.println("Average of all values: " + tree.avg());
        System.out.println("");
        
        System.out.println("Tree height: " + tree.height());
        System.out.println("Max path cost: " + tree.maxPath());
        System.out.println("");
        
        System.out.println("Is AVL tree? " + tree.isAVL());
        System.out.println("Is heap? " + tree.isHeap());
        System.out.println("");
        
        System.out.println("Output:" + tree.mystery(tree.root));
    }
}
