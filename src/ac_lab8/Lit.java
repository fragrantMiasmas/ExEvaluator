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
    String value;
    String rootPrint;
    Lit next; //for shunting yard algorithm
    
    public Lit() {

    }
    
    public Lit(String number) {
         value = number;
         theValue = Integer.parseInt(number);
    }
     
     public Lit(int number) {
         theValue = number;
         rootPrint = Integer.toString(theValue);
    }

}
