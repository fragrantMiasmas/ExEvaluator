/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_lab8;
import java.util.HashMap;

/**
 *
 * @author ElizabethReed PC
 */
public class ExTree {
    
    Node root;
//    HashMap<Integer, Node> hm1 = new HashMap<Integer, Node>();
    HashMap<Character, Node> hm = new HashMap<Character, Node>();
    
    public ExTree(){
        
    }
    
    public ExTree(Node root, char op){
        hm.put(root.op, root);
    }
    
    public ExTree(int item){
        
    }
    
    public void add(char pinfo){
        Node parent = hm.get(pinfo);
        Node curr = parent.lc;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
}
