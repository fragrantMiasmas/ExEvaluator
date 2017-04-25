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
public class Expression {
    
    String expr; //the expression, can be user input
    Expression ex; 
    
    public Expression(){
        
    }
        
    public Expression(Operator op1){ //+,-,*,/
        ex = op1;
        expr = op1.operation;
    }
    
    public Expression(Evaluator ev1){ //=, !=, <,> etc
        ex = ev1;
        expr = ev1.operator;
    }
    
    //add two operators with lit and var attached
    public Expression(Operator op1, Operator op2, Operator op3){ //=, !=, <,> etc
        expr = op1.wholeString + op2.operation + op3.wholeString;
    }
    
    public Expression(Plus p1){
        ex = p1;
        expr = p1.wholeString;
    }
    
    public Expression(String user_input){ //direct input, counts for all operators
        expr = user_input;
    }       
 
    //conditional statements inorder alternative
//    public void Express(Expression user){ //takes in whole expression
//        String input = user.expr; //example input: "(x < 4) ? (y + 2) : 7"
//        String mult = "x";
//        String lessthan = "<";
//        
//        Tern ternEx = Tern.makeTern(user);
//        String ifCondition = ternEx.ifsub.expr;
//        String thenCondition = ternEx.thensub.expr;
//        String elseCondition = ternEx.elsesub.expr;
//        
//        Expression ex1 = new Expression(ifCondition);
//        Expression ex2 = new Expression(thenCondition);
//        Expression ex3 = new Expression(elseCondition);
//        
//        Evaluator eval1 = Evaluator.makeEvaluator(lessthan,ex1);
//        Operator op1 = Operator.makeOperator(mult,ex2);
//        
//        Expression variable = eval1.var;
//        Expression variable2 = op1.var;
//        
//        Var var1 = new Var(variable);
//        Var var2 = new Var(variable2);
//        
//        Expression literal1 = eval1.lit;
//        Expression literal2 = op1.lit;
//        
//        Lit lit1 = new Lit(literal1);
//        Lit lit2 = new Lit(literal2);
//        Lit finalElse = new Lit(ex3);   
//        
//    }
}
