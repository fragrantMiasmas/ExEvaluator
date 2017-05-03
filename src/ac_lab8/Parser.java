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
public class Parser {

    Argument_stack argStack = new Argument_stack();
    Operator_stack opStack = new Operator_stack();
    HashMap<String, Integer> opOrder = new HashMap<String, Integer>();
    Tern ternary = new Tern();
    
    public void order(){
        opOrder.put("+", 0); //where higher values mean higher precedence
        opOrder.put("-", 0);
        opOrder.put("/", 1);
        opOrder.put("*", 1);
    }
        
    public boolean isOperator(char i){
        return i == '=' || i == '+' || i == '-' || i == '*' || i== '/' || i == '>' || i == '<' || i=='=';
    }  
      
   public void printTree(Expression express){ //expression as a string input
        StringBuilder sb = new StringBuilder();
        String str = express.wholeString;
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i); 
            Expression currEx = new Expression("" + curr); //new expression
            if(isOperator(curr)){
                opStack.add(currEx);
            }  
            else
                argStack.add(currEx);
        }
        
        //when string iteration is done, subtree expressions are created
         while(!opStack.isEmpty()){ //transfer operations to output
            Expression curr = opStack.remove();
            curr.right = argStack.remove();
            curr.left = argStack.remove();
            Expression subtree = new Expression(curr.left, curr,curr.right);
            argStack.add(subtree); 
            //below works
            String component = subtree.wholeString;            
            if(opStack.isEmpty()){
                sb.append(component + " = " + subtree.answer);
            }
        }
         System.out.println("StringBuilder = " + sb);
    }

   public void parse(Expression expr) { //example input: "(x < 4) ? (y + 2) : 7"
        String input = expr.wholeString;
        String[] component = input.split("\\:");
        int n = component.length - 1;

        for (int i = 0; i < n; i++) {
            String elseCondition = component[i];
            String[] elses = elseCondition.split("\\?");
            for (int j = 1; j < elses.length; j++) {
                String ifCondition = elses[0]; //if condition
                String x = "\\";
                String splitter = x + ternary.operation;
                String[] ev = ifCondition.split(splitter);//find evaluator expression ie <
                System.out.println("IF:" + ev[0] + ternary.operation + ev[1]);

                String then = elses[1];
                String split2 = x + ternary.elsesub.operation;
                String[] op = then.split("\\+");//find operator ie +
                System.out.println("THEN: " + op[0] + " + " + op[1]);
            }
        }
        String finalElse = component[n];
        System.out.println("ELSE: " + finalElse);

    }
   
    public void precedence(Expression currEx) {
        order(); //set hashmap

        if (opStack.isEmpty()) {
            opStack.add(currEx);
        } else { //if stack is not empty
            int current = opOrder.get(currEx.wholeString); //get operator precedence
            String temp = opStack.top.wholeString;
            int previous = opOrder.get(temp); //operator of prev

            if (opStack.hasLeft() || current > previous) { //or has lower precedence)
                opStack.add(currEx);
            } else if (current < previous) { //if previous operator is higher precedence
                Expression prev = opStack.remove();
                prev.right = argStack.remove();
                prev.left = argStack.remove();
                Expression subtree = new Expression(prev.left, prev, prev.right);
                argStack.add(subtree);
                opStack.add(currEx);
            } else if (current == previous) {
                opStack.add(currEx);
            }

        }
    }
   
   public void printTree2(Expression express){ //expression as a string input
        StringBuilder sb = new StringBuilder();
        String str = express.wholeString;
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i); 
            Expression currEx = new Expression("" + curr); //new expression
            if(isOperator(curr)){
                precedence(currEx);
//                opStack.add(currEx);
            }  
            else
                argStack.add(currEx);
        }
        
        //when string iteration is done, subtree expressions are created
         while(!opStack.isEmpty()){ //transfer operations to output
            Expression curr = opStack.remove();
            curr.right = argStack.remove();
            curr.left = argStack.remove();
            Expression subtree = new Expression(curr.left, curr,curr.right);
            argStack.add(subtree); 
            //below works
            String component = subtree.wholeString;            
            if(opStack.isEmpty()){
                sb.append(component + " = " + subtree.answer);
            }
        }
         System.out.println("StringBuilder = " + sb);
    }
   
//    public int char2int(char input) { //char to ascii
//
//        int digit = (int) input;
//        if (digit >= 48 && digit <= 57) {
//            digit = digit - 48; //only accounts for digits 0-9
//        } else if (digit >= 65 && digit <= 90) {
//            digit = digit - 55; //capitol letters
//        } else {
//            System.out.println("Out of range!");
//        }
//        return digit;
//    }
//    
//    public char int2char(int i) {
//        if (i >= 0 && i <= 9) {
//            return (char) (i + 48); //returns digits 0-9
//        } else {
//            return (char) (i + 55); //returns a letter
//        }
//    }

}
