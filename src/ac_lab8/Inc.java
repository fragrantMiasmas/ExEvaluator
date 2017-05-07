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
public class Inc extends Expression{
    
    Expression left;
    String wholeString;
    String code; //compiler code
    int answer;
    
    public Inc(){
        
    }
    
    public Inc(Expression prev, String str){
        left = prev;
        int prevInt = prev.answer;
        if(str == "++"){
            answer = prevInt + 1;
        }
        else{
            answer = prevInt -1;
        }
        code = "INC ";
    }
        
}
