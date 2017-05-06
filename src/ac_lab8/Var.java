package ac_lab8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ElizabethReed PC
 */
public class Var extends Expression{
    
    Set setter = new Set();
    
    Expression ex;
    String varName;
    String rootPrint;
    String code;
    int val;
    
    public Var(){
        
    }
    
    public Var(String var){ //ex x, y, a, b
        varName = var;
        val = setter.hm.get(var);
        rootPrint = Integer.toString(val);
    }
        
    public Var(Set setter){ //ex x, y, a, b
        varName = setter.varName;
        val = 0;
        val = setter.hm.get(varName);
        rootPrint = Integer.toString(val);
        code = setter.code;
    }
    
    public Var(Expression ex1){
        ex = ex1;
        varName = ex.wholeString;
        val = setter.hm.get(varName);
        rootPrint = Integer.toString(val);
    }
    public String compile(){
        String code = "DATA #" + varName;
        return code;
    }
}
