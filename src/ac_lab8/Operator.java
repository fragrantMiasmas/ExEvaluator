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
        wholeString = op;
    }
    
    public Operator(Expression op, Expression ex1, Expression ex2){ //genreic
        root = op;
        operation = op.operation;
        rootPrint = op.operation;
        left = ex1;
        right = ex2;
        answer = findAnswer(op.operation,ex1.answer,ex2.answer);
//        print = op.operation;
        wholeString = ex1.wholeString +  op.operation + ex2.wholeString;
        code = right.code + "\n" + left.code + "\n" + compile(ex1.answer, operation, ex2.answer)+ "\n";
    }

    public Operator(Expression op, Var variable1, Lit lit1){
        operation = op.operation;
//        print = op.operation;
        left = variable1;
        right = lit1;
        answer = findAnswer(op.operation, variable1.val, lit1.theValue);
        print = op.operation;
        wholeString = variable1.varName +  op + lit1.value;
        code = right.code + "\n" + left.code + "\n" + compile(variable1.answer, operation, lit1.theValue)+ "\n";
    }
    
    public Operator(Expression op, Lit lit1, Lit lit2){
        operation = op.operation;
        print = op.operation;
        left = lit1;
        right = lit2;
        answer = findAnswer(op.operation, lit1.theValue, lit2.theValue);
        wholeString = lit1.value +  op.operation + lit2.value;
        code = right.code + "\n" + left.code + "\n" + compile(lit1.theValue, operation, lit2.theValue)+ "\n";
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
            case "&": ans = int1 & int2;
                break;
            case "++": ans = int1 +1;
                break;
            case "--": ans = int1 -1;
                break;
        }
        return ans;        
    }
    
    public String compile(int int1, String op, int int2){
        String code = "";
        switch(op){
            case "+": code = "ADD R0,R1 ";
                break;
            case "-": code =  "SUB R0,R1";
                break;
            case "*": for(int i = 0; i< int2; i++){
                code = code + "\n" + "INC R0 " + int1;
            }
                break;
            case "/": code = ""; //loop
                break;
            case "%": code = "MOD";
                break;
            case "&": code = "AND R0,R1";
                break;
        }
        return code;        
    }
}
