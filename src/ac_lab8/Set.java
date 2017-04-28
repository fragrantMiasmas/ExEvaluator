/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_lab8;

import java.util.*;

/**
 *
 * @author ElizabethReed PC
 */
public class Set extends Expression{
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    String wholeString;
    String varName;
    int value;
    
    public Set(){
        
    }
    
//    public Set(String var1, Lit l1){
//        varName = var1;
//        value = l1.theValue;
//        hm.put(varName, value);
//    }
    
    public Set(String var1, Expression l1){
        varName = var1;
        value = l1.answer;
        hm.put(varName, value);
    }
    
    public Set(String var1, int l1){
        varName = var1;
        value = l1;
        hm.put(varName, value);
    }
    
}
