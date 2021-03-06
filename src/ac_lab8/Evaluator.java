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
public class Evaluator extends Expression{
    
    String wholeString; //whole operation inlcuding var and lit and answer
    String code;
    String rootPrint; //print center node
    String operator;
    Expression root;
    Expression var;
    Expression lit;
    boolean trueFalse; //true or false
    int answer;
    
    public Evaluator(){
        
    }
    
    public int bool2int(boolean tf){
        int boolval;
        if(tf)
            boolval =1;
        else
            boolval = 0;
        return boolval;
    }
    public Evaluator(String op, Expression ex1, Expression ex2){
        root = new Expression(op);
        operator = op;
        var = ex1;
        lit = ex2;
        trueFalse = findAnswer(op, ex1.answer, ex2.answer);
        answer = bool2int(trueFalse);
        rootPrint = op;
        wholeString = ex1.wholeString +  op + ex2.wholeString;
        code = lit.code + "\n" + var.code + "\n";
    }
    
    public Evaluator(Expression op, Expression ex1, Expression ex2){
        root = new Expression(op);
        operator = op.operation;
        var = ex1;
        lit = ex2;
        trueFalse = findAnswer(op.operation, ex1.answer, ex2.answer);
        answer = bool2int(trueFalse);
        rootPrint = op.operation;
        wholeString = ex1.wholeString +  op + ex2.wholeString;
        code = lit.code + "\n" + var.code + "\n";
    }
    
    public Evaluator(String op, Var variable1, Lit lit1){
        root = new Expression(op);
        operator = op;
        var = variable1;
        lit = lit1;
        trueFalse = findAnswer(op, variable1.val, lit1.theValue);
        rootPrint = variable1.varName +  op + lit1.value;
        wholeString = variable1.varName +  op + lit1.value;
        code = lit.code + "\n" + var.code + "\n";
    }
    
    public Evaluator(Expression op, Var variable1, Lit lit1){
        root = op;
        operator = op.operation;
        var = variable1;
        lit = lit1;
        trueFalse = findAnswer(op.operation, variable1.val, lit1.theValue);
        rootPrint = variable1.varName +  op + lit1.value;
        wholeString = variable1.varName +  op + lit1.value;
        code = right.code + "\n" + left.code + "\n";
    }
    
    public boolean findAnswer(String op, int int1, int int2){      
        switch(op){
            case ">": trueFalse = int1 > int2;
                break;
            case "<": trueFalse = int1 < int2;;
                break;
            case ">=": trueFalse = int1 >= int2;
                break;
            case "<=": trueFalse = int1 <= int2;
                break;
            case "==": trueFalse = int1 == int2;
                break;
            case "!=": trueFalse = int1 != int2;
                break;
//            case "&": trueFalse = int1 & int2;
//                break;
        }
        return trueFalse;        
    }
    
    public String compile(String op){
        String code = op;
        return code;
    }
}
