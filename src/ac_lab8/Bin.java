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
public class Bin extends Expression{ //expressions with operators ie +, -, *, /
    
    String operator;
    Expression var;
    Expression lit;
    
    public Bin(){
        
    }
    
    public Bin(String op){
        operator = op;
    }
    
    public Bin(String op, Expression ex1, Expression ex2){
        operator = op;
        var = ex1;
        lit = ex2;
    }
    
    public static Bin makeBin(Expression ex1){ //ie (x<4)
        String input = ex1.expr;
              
           String[] component = input.split("\\<"); //operator
           String var = component[0];
           String lit = component[2];
           
           Expression varEx = new Expression(var);
           Expression litEx = new Expression(lit);
           
           Bin bin1 = new Bin("<", varEx, litEx);
           return bin1;
    }
    
        
}
