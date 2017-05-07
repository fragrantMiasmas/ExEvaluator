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
        opOrder.put("=", 0); //where higher values mean higher precedence
        opOrder.put("+", 1); 
        opOrder.put("-", 1);
        opOrder.put("/", 2);
        opOrder.put("*", 2);
        opOrder.put("&", 2);
        opOrder.put("++", 3);
        opOrder.put("--", 3);
        opOrder.put("<", 3);
        opOrder.put(">", 3);
        opOrder.put("<=", 3);
        opOrder.put(">=", 3);
    }
        
    public boolean isOperator(char i){
        return i == '=' || i == '+' || i == '-' || i == '*' || i=='&' ||i== '/' || i == '>' || i == '<';
    }    
   
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
    
     public void forInc(Expression currEx) { //for incrementing only
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
                prev.right = new Expression();
                prev.left = argStack.remove();
                Expression subtree = new Expression(prev.left, prev, prev.right);
                argStack.add(subtree);
                
                opStack.add(currEx);
            } else if (current == previous) {
                opStack.add(currEx);
            }

        }
    }
   
    public Expression makeTree(String str){ //expression as a string input
        
        StringBuilder sb = new StringBuilder();      
        String[] user_input = str.split("\\s"); //split by spaces
    
        for(int i = 0; i < user_input.length; i++){
            String curr = user_input[i]; 
            Expression currEx = new Expression(curr); //new expression
            char nextChar = curr.charAt(0);
            
            if(curr.length() == 1 && isOperator(nextChar))
                tokenizer(currEx);
            else if(curr.length() == 2 && isOperator(curr.charAt(1))){
                System.out.println("incrementer here");
                forInc(currEx);
            }
            else if(nextChar =='r' || nextChar =='R'){ //doesn't match strings??
                Read reader = new Read();
                currEx.answer = reader.answer;
                Expression readin = new Expression(reader.answer);
                argStack.add(readin);
            }
            else if(nextChar =='x' || nextChar =='y'){ //doesn't match strings??
                Read reader = new Read(nextChar);
                currEx.answer = reader.answer;
                Expression readin = new Expression(reader.answer);
                argStack.add(readin);
            }
            else if(nextChar >=48 || nextChar <= 57){ // ascii value range for ints
//                int toInt = Integer.parseInt(currEx.wholeString);
                Expression intEx = new Expression(Integer.parseInt(currEx.wholeString));
                argStack.add(intEx);
            } 
            else{
                System.out.println("String contains an invalid input");
            }
        }
        
        //when string iteration is done, subtree expressions are created
         while(!opStack.isEmpty()){ //transfer operations to output
            Expression curr = opStack.remove();
            curr.right = argStack.remove();
            if(!argStack.isEmpty()) //usually this case
                curr.left = argStack.remove();
            else //for incrementers, create empty left
                curr.left = new Expression();
            Expression subtree = new Expression(curr.left, curr,curr.right);
//            System.out.println(subtree.answer); //for debugging
            argStack.add(subtree); 

        }
         Expression myTree = argStack.top;
         System.out.println("Expression = " + myTree.wholeString + " = " + myTree.answer);
         return myTree;

    }
     
    public Expression parseCondition(String input){ //only three parts        
        //example input: "(x < 4) ? (y + 2) : 7"
        String[] component = input.split("\\:");
  
        //split (x < 4) ? (y + 2)
        String ifelseCondition = component[0];
        String[] elses = ifelseCondition.split("\\?");
        Expression ifCondition = new Expression(elses[0]); //(x < 4)     
        ifCondition = makeTree(ifCondition.wholeString);
        
        Expression elseCondition = new Expression(elses[1]);  //y+2  
        elseCondition = makeTree(elseCondition.wholeString);
        
        Expression finalElse = new Expression(component[1]); //7
        finalElse = makeTree(finalElse.wholeString);
        
        //initialize new ternary expression
        Tern t1 = new Tern(ifCondition,elseCondition,finalElse);
        System.out.println("Conditional: " + t1.wholeString + " = " + t1.answer);
        return t1;
    } 
}
