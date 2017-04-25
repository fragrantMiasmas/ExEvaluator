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
        wholeString = variable1.varName +  op + variable2.varName;
    }
    
    public Operator(String op, Var variable1, Lit lit1){
        operation = op;
        var = variable1;
        lit = lit1;
        wholeString = variable1.varName +  op + lit1.value;
    }
    
//    public int findAnswer(String op, Var variable1, Lit lit1){
//        int ans = 0;
//        switch(op){
//            case "+": ans = variable1.val + lit1.theValue;
//                break;
//            case "-": ans = variable1.val - lit1.theValue;
//                break;
//            case "*": ans = variable1.val * lit1.theValue;
//                break;
//            case "/": ans = variable1.val / lit1.theValue;
//                break;
//            case "%": ans = variable1.val % lit1.theValue;
//        }
//        return ans;        
//    }
       
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
