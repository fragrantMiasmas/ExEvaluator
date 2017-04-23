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
    Node rc;
    int item;
    char op;
    
    public Node(int item, Node lc, Node rc){
        this.lc = null;
        this.rc = null;
        this.item = item;
    }
    
    public Node(char op, Node lc, Node rc){
        this.lc = null;
        this.rc = null;
        this.op = op;
    }
    
    Node mynode = new Node(item, lc, rc){
        
    }
}
