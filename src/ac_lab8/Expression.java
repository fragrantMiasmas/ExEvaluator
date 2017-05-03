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
public class Expression {

    String wholeString; //the expression, can be user input
    String operation;
    String rootPrint;
    Expression root;
    Expression left;
    Expression right;
    Expression parent;
    int answer;

    Expression next;

    public Expression() {

    }
    
    public Expression(Expression expr) { //expression calls itself fr stack of expressions
        root = expr;
        left = expr.left;
        right = expr.right;
        wholeString = expr.left.wholeString + expr.operation + expr.right.wholeString;
        answer = expr.answer;
    }

    public Expression(String user_input) { //direct input, counts for all operators
        wholeString = user_input;
        operation = user_input;
    }

    public Expression(Lit literal1) {
        answer = literal1.theValue;
        wholeString = literal1.value;
        rootPrint = literal1.value;
    }

    public Expression(Var var1) {

        answer = var1.val;
        rootPrint = var1.varName;
        wholeString = var1.varName;
    }
    
    public Expression(Set set1){
        answer = set1.value;
        wholeString = set1.varName + " = " + set1.value;
    }

    public Expression(Operator op1) { //+,-,*,/

        root = op1;
        left = op1.left;
        right = op1.right;
        rootPrint = op1.operation;
        operation = op1.operation;
        wholeString = op1.wholeString;
        answer = op1.answer;
    }

    public Expression(Evaluator ev1) { //=, !=, <,> etc

        root = ev1;
        left = ev1.left;
        right = ev1.right;
        rootPrint = ev1.operation;
        operation = ev1.operation;
        wholeString = ev1.wholeString;
        answer = ev1.answer;
    }

    public Expression(Tern t1) {
        answer = t1.answer;   
        wholeString = t1.wholeString;
    }

    //add two operators with lit and var attached
    public Expression(Operator op1, Expression ex2, Operator op3) { //concat any operators together

        root = op1;
        operation = ex2.operation;
        rootPrint = ex2.operation;
        wholeString = op1.print + ex2.operation + op3.print;
        answer = new Operator(ex2, op1, op3).answer; //debug
    }

    public Expression(Expression ex1, Expression ex2, Expression ex3) { //concat any operators together
 
        root = ex2; //just the operation
        left = ex1;
        right = ex3;
        rootPrint = ex2.operation;
        operation = ex2.operation;
        wholeString = "(" + ex1.wholeString + operation + ex3.wholeString + ")";
        answer = new Operator(ex2, ex1, ex3).answer; //debug
    }
    
    public boolean hasLeft(Expression exp){
        return exp.left !=null;
    }
    
    public boolean hasRight(Expression exp){
        return exp.right !=null;
    }
    
    public boolean isInt(String str) {
        char i = str.charAt(0);
        return (int) i >= 48 && (int) i <= 57;
    }
       public boolean isVar(String str) {
        char i = str.charAt(0);
        //upper and lower case letters
        return ((int) i >= 65 && (int) i <= 90) || ((int) i >= 97 && (int) i <= 122);        
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
