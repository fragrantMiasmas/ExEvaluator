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
public class Div extends Expression{
    
    String wholeString; //whole operation inlcuding var and lit
    String operation = "/";
    Var var1;
    Var var2;
    Lit literal1;
    Lit literal2;
    int answer;
    
   
    public Div(Var variable1, Var variable2){
        var1 = variable1;
        var2 = variable2;
        wholeString = variable1.varName +  operation + variable2.varName;
        answer = variable1.val / variable1.val;
    }
    
    public Div(Var variable1, Lit lit1){
        var1 = variable1;
        literal1 = lit1;
        wholeString = variable1.varName +  operation + lit1.value;
        answer = variable1.val / lit1.theValue;
    }
    
    public Div(Lit lit1, Lit lit2){
        literal1 = lit1;
        literal1 = lit2;
        wholeString = lit1.value +  operation + lit2.value;
        answer = lit1.theValue / lit2.theValue;
    }
}
