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
public class Write extends Expression{
    
    
    Scanner kb = new Scanner(System.in);
    String wholeString;
    String code;
    int answer;
    
    public Write(){
        System.out.println("Please enter in a decimal number: ");
        int dec = kb.nextInt();
        answer = dec;
        wholeString = "WRITE =  " + dec;
        System.out.println(wholeString);
    }
    
    public Write(char variable){ //set x,y
        System.out.println("Please enter in a decimal number: ");
        int dec = kb.nextInt();
        answer = dec;
        wholeString = variable + "=" + dec;
        System.out.println(wholeString);
        code = compile();
    }
    
    public String compile(){
        String code = "WRITE R0," + answer;
        return code;
    }
}
