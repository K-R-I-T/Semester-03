/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mystackandqueue;

public class Main {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        String s1 = "mystacksandqueues";
        for (int i=0; i<=s1.length()-1; i++) {
            ms.push(s1.charAt(i));
        }
        String rs1 = "";
        while(!ms.isEmpty()) rs1 += ms.pop();
        System.out.println(rs1);
        
        MyQueue mq = new MyQueue();
        String s2 = "mystacksandqueues";
        for (int i=0; i<=s2.length()-1; i++) {
            mq.enqueue(s2.charAt(i));
        }
        String rs2 = "";
        while(!mq.isEmpty()) rs2 += mq.dequeue();
        System.out.println(rs2);
    }
}
