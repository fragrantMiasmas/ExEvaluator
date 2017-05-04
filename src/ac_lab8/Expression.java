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
    
    public Expression(int user_input) { //direct input, counts for all operators
        wholeString = "" + user_input;
        answer = user_input;
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
        operation = t1.operation;
        answer = t1.answer;   
        wholeString = t1.wholeString;
    }

    //add two operators with lit and var attached
    public Expression(Operator op1, Expression ex2, Operator op3) { //concat any operators together

        root = op1;
        operation = ex2.operation;
        rootPrint = ex2.operation;
        wholeString = op1.print + ex2.operation + op3.print;
        Operator newop = new Operator(ex2, op1, op3); //debug
        answer = newop.answer;
    }

    public Expression(Expression ex1, Expression ex2, Expression ex3) { //concat any operators together
 
        root = ex2; //just the operation
        left = ex1;
        right = ex3;
        operation = ex2.operation;
        wholeString = "(" + ex1.wholeString + operation + ex3.wholeString + ")";
//        wholeString = ex1.wholeString + operation + ex3.wholeString; 
        if(operation != ">" && operation != "<"){
            System.out.println("operation = " + operation);
            Operator newop = new Operator(ex2, ex1, ex3);
            answer = newop.answer; //debug
        }
        else{
            Evaluator newev = new Evaluator(ex2, ex1, ex3);
            answer = newev.answer; //debug
        }
           
    }
}
