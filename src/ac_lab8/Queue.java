/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_lab8;

/**
 *
 * @author ElizabethReed PC
 */
public class Queue {
    Expression head;
    Expression tail;
    
    public Queue(){
        
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void enq(Expression lit1){
        if(isEmpty()){
            head = lit1;
            tail = head;
        }
        else{
            tail.next = lit1;
            tail = lit1;
        }
    }
    
    public Expression deq(){
        Expression node = head;
        head = head.next; //should solve the null head, why is head.next null? How to connect to hm?
        if(head == null){
//            System.out.println("Q empty!");
        }
        return(node);
    }
}
