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
public class Compiler {
    
    Parser ps = new Parser();
    
    //need stack of instructions
    
    public Compiler(){
        
    }
       
    //for data and copy
    public void getCode(Expression tree){
        System.out.println(tree.code);
    }
}
