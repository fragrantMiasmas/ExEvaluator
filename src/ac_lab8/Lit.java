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
public class Lit extends Expression {
    Expression ex; //parent
    int theValue;
    int answer;
    String value;
    String rootPrint;
    String code;
    Lit next; //for shunting yard algorithm
    
    public Lit() {

    }
    
    public Lit(String number) {
         value = number;
         theValue = Integer.parseInt(number);
         answer = theValue;
         code = compile(value);
    }
     
     public Lit(int number) {
         theValue = number;
         value = Integer.toString(theValue);
         answer = theValue;
         code = compile(value);
    }
     
     public String compile(String number){
         String code = "DATA " + number + "\n" + "COPY R1";
         return code;
     }
}
