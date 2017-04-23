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
public class Node {
    
    Node lc;
    Node mc;
    Node rc;
    String op;
    int item;
//    char op;
      
    public Node(String op, Node lc, Node rc){ //binary
        this.lc = null;
        this.rc = null;
        this.op = op;
    }
    
    public Node(String op, Node lc, Node mc, Node rc){ //ternary conditional
        this.lc = null;
        this.mc = null;
        this.rc = null;
        this.op = op;
    }
    
    
//    Node mynode = new Node(item, lc, rc){
//        
//    }
}
