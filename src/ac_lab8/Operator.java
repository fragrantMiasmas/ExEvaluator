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
    String print; //prints sequence without answer
    String operation; //just the operation
    String rootPrint;
    Expression root;
    Expression left;
    Expression right;
    int answer;
  
    
    public Operator(){
        
    }
    
    public Operator(String op){ //direct input
        operation = op;
        root = new Expression(op);
    }
    
    public Operator(Expression op, Expression ex1, Expression ex2){ //genreic
        root = op;
        operation = op.operation;
        rootPrint = op.operation;
        left = ex1;
        right = ex2;
        answer = findAnswer(op.operation,ex1.answer,ex2.answer);
        print = op.operation;
        wholeString = ex1.wholeString +  op.operation + ex2.wholeString;
    }

    public Operator(Expression op, Var variable1, Lit lit1){
        operation = op.operation;
        print = op.operation;
        left = variable1;
        right = lit1;
        answer = findAnswer(op.operation, variable1.val, lit1.theValue);
        print = op.operation;
        wholeString = variable1.varName +  op + lit1.value;
    }
    
    public Operator(Expression op, Lit lit1, Lit lit2){
        operation = op.operation;
        print = op.operation;
        left = lit1;
        right = lit2;
        answer = findAnswer(op.operation, lit1.theValue, lit2.theValue);
        print = op.operation;
        wholeString = lit1.value +  op.operation + lit2.value;
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
//    public static Operator makeOperator(String op, Expression ex1){ //ie (y+2)
//        String input = ex1.expr;
//           
//           String splitter = "\\" + op;
//           String[] component = input.split("\\+"); //ie op = +
//           String var1 = component[0];
//           String lit1 = component[1];
//           
//           Var varEx = new Var(var1);
//           Lit litEx = new Lit(lit1);
//           
//           Operator op1 = new Operator(op, varEx, litEx); //change later to include general case
//           return op1;
//    }    
//    
}
