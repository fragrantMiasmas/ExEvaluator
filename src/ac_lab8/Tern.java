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
public class Tern extends Expression{
    
    String wholeString;
    String questionMark = "?";
    String colon = ":";
    Expression ifsub; //main condition with ? mark
    Expression thensub;
    Expression elsesub;
    
    public Tern(){
        
    }
    
    public Tern(Expression ex1, Expression ex2, Expression ex3){
        ifsub = ex1;
        thensub = ex2;
        elsesub = ex3;
        wholeString = ifsub.print + questionMark + thensub.print + colon + elsesub.print;
    }
    
//     public Tern(String q, Expression ex1, Expression ex2, String c, Expression ex3){
//        questionMark = q;
//        ifsub = ex1;
//        thensub = ex2;
//        colon = c;
//        elsesub = ex3;
//        wholeString = ifsub + q + thensub + c + elsesub;
//    }
     
     public static Tern makeTern(Expression user){ //example input: "(x < 4) ? (y + 2) : 7"
           String input = user.wholeString;
           
           String[] ifelse = input.split("\\:");
           String[] conditions = ifelse[0].split("\\?");
//           for(int i = 0; i< conditions.length; i++){
               String ifsub = conditions[0]; //if condition, (x < 4)
               String thensub = conditions[1]; //then (y + 2)
               String elsesub= ifelse[1]; //else 7
               
               Expression ifCondition = new Expression(ifsub);
               Expression thenCondition = new Expression(thensub);
               Expression elseCondition = new Expression(elsesub);
               Tern tern1 = new Tern(ifCondition, thenCondition, elseCondition);
//            }
            return tern1;
        }
}
