package ac_lab8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ElizabethReed PC
 */
public class Var extends Expression{
    
    Expression ex;
    String varName;
    int val;
    
    public Var(){
        
    }
    
    public Var(String var){ //ex x, y, a, b
        varName = var;
        val = hm.put(var, val);
    }
    
    public Var(Expression ex1){
        ex = ex1;
        varName = ex.wholeString;
        val = hm.put(varName, val);
    }
    
}
