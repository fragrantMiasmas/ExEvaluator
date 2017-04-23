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

    int theValue;

    public Lit() {

    }

    public Lit(Expression ex) {

    }
    
    public Lit(Bin bin1) {
         theValue = Integer.parseInt(bin1.lit.toString());
    }
    
    public Lit(Tern tern1) {
         theValue = Integer.parseInt(tern1.elsesub.toString());
    }

    public int valueOf() {
        return theValue;
    }

    public String toString() {
        return "" + theValue;
    }

}
