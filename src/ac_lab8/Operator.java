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
public class Operator extends Expression{
    
    String wholeString; //whole operation inlcuding var and lit
    String print;
    String operation;
    Expression ex;
    Expression var;
    Expression lit;
    int answer;
    
    public Operator(){
        
    }
    
    public Operator(String op){ //direct input
        operation = op;
    }
    
    public Operator(String op, Expression ex1, Expression ex2){ //genreic
        operation = op;
        var = ex1;
        lit = ex2;
    }
    
    public Operator(String op, Var variable1, Var variable2){
        operation = op;
        var = variable1;
        lit = variable2;
        answer = findAnswer(op,variable1.val,variable2.val);
        print = variable1.varName +  op + variable2.varName;
        wholeString = variable1.varName +  op + variable2.varName + "=" + answer;
    }
    
    public Operator(String op, Var variable1, Lit lit1){
        operation = op;
        var = variable1;
        lit = lit1;
        answer = findAnswer(op, variable1.val, lit1.theValue);
        print = variable1.varName +  op + lit1.value;
        wholeString = variable1.varName +  op + lit1.value + "=" + answer;
    }
    
    public Operator(String op, Lit lit1, Lit lit2){
        operation = op;
        var = lit1;
        lit = lit2;
        answer = findAnswer(op, lit1.theValue, lit2.theValue);
        print = lit1.value +  op + lit2.value;
        wholeString = lit1.value +  op + lit2.value + "=" + answer;
    }
    
    public Operator(String op, int lit1, int lit2){
        operation = op;
        var = new Lit(lit1);
        lit = new Lit (lit2);
        answer = findAnswer(op, lit1, lit2);
        print = lit1 +  op + lit2;
        wholeString = lit1 +  op + lit2 + "=" + answer;
    }
    public int findAnswer(String op, int int1, int int2){
        int ans = 0;
        switch(op){
            case "+": ans = int1 + int2;
                break;
            case "-": ans = int1 - int2;;
                break;
            case "*": ans = int1 * int2;
                break;
            case "/": ans = int1 / int2;
                break;
            case "%": ans = int1 % int2;
                break;
        }
        return ans;        
    }
       
//similar to binary expression, may get rid of binary    
    public static Operator makeOperator(String op, Expression ex1){ //ie (y+2)
        String input = ex1.expr;
           
           String splitter = "\\" + op;
           String[] component = input.split("\\+"); //ie op = +
           String var1 = component[0];
           String lit1 = component[1];
           
           Var varEx = new Var(var1);
           Lit litEx = new Lit(lit1);
           
           Operator op1 = new Operator(op, varEx, litEx); //change later to include general case
           return op1;
    }    
    
}
