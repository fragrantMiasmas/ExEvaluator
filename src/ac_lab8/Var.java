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
    
    String varName;
    
    public Var(){
        
    }
    
    public Var(String var){
        varName = var;
    }
    
    public Var(Bin bin1){
        varName = bin1.var.toString();
    }
    
    public Var(Expression ex1){
        varName = ex1.expr;
    }
    
}
