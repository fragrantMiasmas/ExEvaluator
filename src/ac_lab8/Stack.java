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
public class Stack {
    
    Expression top;
    
    public Stack(){
        
    }
    
     public boolean isEmpty() {
        return top == null;
    }
     
    public void add(Expression op1) {
//        Expression node2 = new Expression(op);
        top = op1;
    }
    
    public Expression remove() {
        Expression pop = top;
        top = top.next;
        return pop;
    }
}
