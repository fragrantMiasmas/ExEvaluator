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
       
     public void parse(String input){ //example input: "(x < 4) ? (y + 2) : 7"

            String[] component = input.split("\\:");
            int n = component.length-1;
            
            for(int i = 0; i< n;i++){
                String elseCondition = component[i];
                String[] elses = elseCondition.split("\\?");
                for(int j=1; j<elses.length;j++){
                    String ifCondition = elses[0]; //if condition
                    String x = "\\";
                    String newx = x + operator();
                    String[] ev = ifCondition.split("\\<");//find evaluator expression ie <
                    System.out.println("IF:" + ev[0] + " < " + ev[1]);
                    
                    String then = elses[1];
                    String[] op = then.split("\\+");//find operator ie +
                    System.out.println("THEN: " + op[0] + " + " + op[1]);
                }
            }
            String finalElse = component[n]; 
            System.out.println("ELSE: "+ finalElse);

    }
    
     public char operator(){
         return '+' | '-' | '*' | '/';
     }
   
    
       
     public char[] expression(String input) { //evaluates numerical expression sans parenthases
        char[] charA = input.toCharArray();
        return charA;
    }
    
    public boolean isInt(char i){
        return (int)i >= 48 && (int)i<=57;
    }
    
    public boolean isVar(char i){
        //upper and lower case letters
        return ((int)i >= 65 && (int)i<=90) || ((int)i >= 97 && (int)i<=122); 
    }
    public boolean isOperator(char op)
    {
        // * 42, + 43, - 45, /47
        return op == '+' || op == '-' || op == '*' || op == '/';
    }
    
     public boolean isCondition(String con)
    {
        return con == ">" || con == "<" || con == ">=" || con == "<=" || con == "==" || con == "!=";
    }
     
    public boolean isEvaluator(char eval){
        return eval == '?' || eval == ':';
    }
    
     public int char2int(char input) { //char to ascii

        int digit = (int) input;
        if (digit >= 48 && digit <= 57) {
            digit = digit - 48; //only accounts for digits 0-9
        } else if (digit >= 65 && digit <= 90) {
            digit = digit - 55; //capitol letters
        } else {
            System.out.println("Out of range!");
        }
        return digit;
    }

    public char int2char(int i) {
        if (i >= 0 && i <= 9) {
            return (char) (i + 48); //returns digits 0-9
        } else {
            return (char) (i + 55); //returns a letter
        }
    }
  
    public boolean isLeft(char par){
        return par == '(';
    }
    
    public boolean isRight(char par){
        return par == ')';
    }

}
