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
public class Condition extends Tern{
    
    String wholeString;
    String q = "?";
    String c = ":";
    Evaluator eval;
    Lit literal;
    
    public Condition(String direct_input){
        
    }
    
    public Condition(Evaluator ev1, Expression ex, Lit lit1){ //"(x < 4) ? (y + 2) : 7"
        eval = ev1;  //(x < 4)
        literal = lit1; //7
    }
    
    public Condition(Evaluator ev1, Expression ex, Expression ex2){ //"(x < 4) ? (y + 2) : 7"
        eval = ev1;  //(x < 4)
    }
}
