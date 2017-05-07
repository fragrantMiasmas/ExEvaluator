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
    int literal;
    Expression left;
    Expression right;
    
    public Condition(String direct_input){
        
    }
    
    public Condition(Evaluator ev1, Expression ex, Lit lit1){ //"(x < 4) ? (y + 2) : 7"
        eval = ev1;  //(x < 4)
        literal = lit1.theValue; //7
        wholeString = ev1.wholeString + q + ex.wholeString + c + lit1.wholeString;
    }
    
    public Condition(Evaluator ev1, Expression ex, Expression ex2){ //"(x < 4) ? (y + 2) : 7"
        eval = ev1;  //(x < 4)
        answer = ev1.answer;
        code = ex2.code + ex.code + ev1.code + "\n";
    }
    
    public Condition(Expression ev1, Expression ex, Expression ex2){ //"(x < 4) ? (y + 2) : 7"
//        eval = ev1;  //(x < 4)
            ex = left;
            ex2 = right;
            code = ex2.code + ex.code + ev1.code + "\n";
    }
}
