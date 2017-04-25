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
    String print;
    String operator;
    Expression var;
    Expression lit;
    boolean answer; //true or false
    
    public Evaluator(){
        
    }
    
     public Evaluator(String op, Expression ex1, Expression ex2){
        operator = op;
        var = ex1;
        lit = ex2;
    }
    
    public Evaluator(String op, Var variable1, Lit lit1){
        operator = op;
        var = variable1;
        lit = lit1;
        wholeString = variable1.varName +  op + lit1.value;
    }
//   public Evaluator equalto(Var variable1, Lit lit1){
//        String op = "=";
//        operator = op;
//        var = variable1;
//        lit = lit1;
//        wholeString = variable1.varName +  op + lit1.value;
//    }
    
    public boolean findAnswer(String op, int int1, int int2){      
        switch(op){
            case ">": answer = int1 > int2;
                break;
            case "<": answer = int1 < int2;;
                break;
            case ">=": answer = int1 >= int2;
                break;
            case "<=": answer = int1 <= int2;
                break;
            case "=": answer = int1 == int2;
                break;
            case "!=": answer = int1 != int2;
                break;
        }
        return answer;        
    }
    
    public static Evaluator makeEvaluator(String ex, Expression ex1){ //ie (x<4)
        String input = ex1.expr;
           
           String splitter = "\\" + ex; //won't accept this... for split
           String[] component = input.split("\\<"); //operator
           String var = component[0];
           String lit = component[1];
           
           Expression varEx = new Expression(var);
           Expression litEx = new Expression(lit);
           
           Evaluator ev1 = new Evaluator(ex, varEx, litEx); //change later to include general case
           return ev1;
    }
}
