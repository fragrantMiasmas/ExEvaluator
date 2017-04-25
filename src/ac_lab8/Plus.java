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
public class Plus extends Operator{
    
    String wholeString; //whole operation inlcuding var and lit
    String print; //operation with var and lit
    String operation = "+";
    Var var1;
    Var var2;
    Lit literal1;
    Lit literal2;
    int answer;
    
   
    public Plus(Var variable1, Var variable2){
        var1 = variable1;
        var2 = variable2;
        answer = variable1.val + variable2.val;
        print = variable1.varName +  operation + variable2.varName;
        wholeString = variable1.varName +  operation + variable2.varName+ " = " + answer;
    }
    
    public Plus(Var variable1, Lit lit1){
        var1 = variable1;
        literal1 = lit1;
        answer = variable1.val + lit1.theValue;
        print = variable1.varName +  operation + lit1.value;
        wholeString = variable1.varName +  operation + lit1.value+ " = " + answer;
    }
    
    public Plus(Lit lit1, Lit lit2){ //add two ints
        literal1 = lit1;
        literal1 = lit2;
        answer = lit1.theValue + lit2.theValue;
        print = lit1.value +  operation + lit2.value;
        wholeString = lit1.value +  operation + lit2.value+ " = " + answer;
    }
}
