/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Node {

    public Student dta;
    public Node next;

    public Node(Student dta, Node next) {
        this.dta = dta;
        this.next = next;
    }

    public Node(Student dta) {
        this.dta = dta;
        next = null;
    }
}
