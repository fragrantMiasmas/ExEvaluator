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
    HashMap<String, Node> hm = new HashMap<String, Node>();
    
    public ExTree(){
        
    }
    
    public ExTree(Node root, char op){
        hm.put(root.op, root);
    }
        
    public void add(String pinfo){
        Node parent = hm.get(pinfo);
        Node leftc = parent.lc;
        Node middlec = parent.mc;
        Node rightc = parent.rc;
        
        hm.put(pinfo, root);
        
        if(parent.mc == null){
            parent.mc = middlec;
        }
        else if(parent.lc == null && parent.mc != null){
            parent.lc = leftc;
        }
        else if(parent.lc != null && parent.rc == null && parent.mc != null){
            parent.rc = rightc;
        }
        
    }
    
    public void inorder(){
        
    }
    public boolean isEmpty() {
        return root == null;
    }
}
