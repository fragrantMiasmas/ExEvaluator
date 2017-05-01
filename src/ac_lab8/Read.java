/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac_lab8;

import java.util.Scanner;

/**
 *
 * @author ElizabethReed PC
 */
public class Read extends Expression{
    
    Scanner kb = new Scanner(System.in);
    String wholeString;
    int answer;
    
    public Read(){
        System.out.println("Please enter in a decimal number: ");
        int dec = kb.nextInt();
        answer = dec;
        wholeString = "You entered " + dec;
    }
}
