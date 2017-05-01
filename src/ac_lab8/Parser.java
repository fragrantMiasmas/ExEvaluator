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
public class Parser {

    Argument_stack output = new Argument_stack();
    Operator_stack opStack = new Operator_stack();
    Tern ternary = new Tern();
    
    
    public void String2Tree(Expression express){ //expression as a string input
        String str = express.wholeString; //extract string from expression
//        String[] component = str.split("\\:");
//        int n = component.length - 1;
        char[] charA = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            Expression currEx = new Expression("" + curr); //new expression
            if(isOperator(curr)){
                opStack.add(currEx);
            }
        }
    }

     public boolean isOperator(char i){
        return i == '=' || i == '+' || i == '-' || i == '*' || i== '/';
    }
        
    public void traverse(Expression input) {
        StringBuilder sb = new StringBuilder();
        Expression curr = input;
        while (curr !=null) {
            
            if(curr.isInt(curr.rootPrint) || curr.isVar(curr.rootPrint)) 
                output.add(curr); //if node is an int, goes straight to output
            else
                opStack.add(curr); //if node is an operation, goes to operator stack
         
            if(curr.hasRight(curr)){ //move to next node
                curr = curr.right;
                traverse(curr);
            }   
            else
                break;
            if(curr.hasLeft(curr)){ //move to next node
                curr = curr.left;
                traverse(curr);
            }   
            else
                break;
        }
        while(!opStack.isEmpty()){ //transfer operations to output
            curr =  opStack.remove();
            output.add(curr);
//            curr = curr.next;
        }

        while(!output.isEmpty()){
            curr =  output.remove();
            sb.append(curr.rootPrint);
        }
         System.out.println(sb);
    }
    
   public void parse(String input) { //example input: "(x < 4) ? (y + 2) : 7"

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
