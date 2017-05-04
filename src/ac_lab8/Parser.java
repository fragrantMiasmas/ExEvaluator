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
        opOrder.put("&", 1);
        opOrder.put("<", 2);
        opOrder.put(">", 2);
        opOrder.put("<=", 2);
        opOrder.put(">=", 2);
    }
        
    public boolean isOperator(char i){
        return i == '=' || i == '+' || i == '-' || i == '*' || i=='&' ||i== '/' || i == '>' || i == '<';
    }    
    
//    public boolean isEvaluator(char i){
//       return i== '/' || i == '>' || i == '<';
//    }
//    public boolean isOperator2(String i){
//        return i == "=" || i == "+" || i == "-" || i == "*" || i== "/" || i == ">" || i == "<" || i=="&";
//    }    
    
    public void tokenizer(Expression currEx) {
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
   
     public void printTree(String str){ //expression as a string input
        
        StringBuilder sb = new StringBuilder();      
        String[] user_input = str.split("\\s"); //split by spaces
    
        for(int i = 0; i < user_input.length; i++){
            String curr = user_input[i]; 
            Expression currEx = new Expression(curr); //new expression
            if(isOperator(curr.charAt(0)))
                tokenizer(currEx);
            else if(curr.charAt(0) =='r' || curr.charAt(0) =='R'){ //doesn't match strings??
                Read reader = new Read();
                currEx.answer = reader.answer;
                Expression readin = new Expression(reader.answer);
                argStack.add(readin);
            }
            else{
//                int toInt = Integer.parseInt(currEx.wholeString);
                Expression intEx = new Expression(Integer.parseInt(currEx.wholeString));
                argStack.add(intEx);
            }     
        }
        
        //when string iteration is done, subtree expressions are created
         while(!opStack.isEmpty()){ //transfer operations to output
            Expression curr = opStack.remove();
            curr.right = argStack.remove();
            curr.left = argStack.remove();
            Expression subtree = new Expression(curr.left, curr,curr.right);
//            System.out.println(subtree.answer); //for debugging
            argStack.add(subtree); 

            String component = subtree.wholeString;            
            if(opStack.isEmpty()){
                sb.append(component + " = " + subtree.answer);
            }
        }
         System.out.println("Tree = " + sb);
    }
 
    public void parseCondition(String input){ //only three parts 
        
        //example input: "(x < 4) ? (y + 2) : 7"
        String[] component = input.split("\\:");
  
        //split (x < 4) ? (y + 2)
        String ifelseCondition = component[0];
        String[] elses = ifelseCondition.split("\\?");
        Expression ifCondition = new Expression(elses[0]);      
        Expression elseCondition = new Expression(elses[1]);         
        Expression finalElse = new Expression(component[1]);
        
        Tern t1 = new Tern(ifCondition,elseCondition,finalElse);
        System.out.println("Conditional: " + t1.wholeString + "=" + t1.answer);
    }    
}
