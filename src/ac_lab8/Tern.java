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
    int answer;
    
    public Tern(){
        
    }
    
    public Tern(Expression ex1, Expression ex2, Expression ex3){
        ifsub = ex1;
        thensub = ex2;
        elsesub = ex3;
        wholeString = ifsub.wholeString + questionMark + thensub.wholeString + colon + elsesub.wholeString;
        if(ex1.answer == 1){
            answer = ex2.answer;
        }
        else
            answer = ex3.answer;
    }
    
    public Tern(Evaluator ev1, Condition cond1, Condition cond2){
        ifsub = ev1;
        thensub = cond1;
        elsesub = cond2;
        wholeString = ifsub.wholeString + questionMark + thensub.wholeString + colon + elsesub.wholeString;
           if(ev1.answer == 1){
            answer = cond1.answer;
        }
        else
            answer = cond2.answer;
    }
     
//     public static Tern makeTern(Expression user){ //example input: "(x < 4) ? (y + 2) : 7"
//           String input = user.wholeString;
//           
//           String[] ifelse = input.split("\\:");
//           String[] conditions = ifelse[0].split("\\?");
////           for(int i = 0; i< conditions.length; i++){
//               String ifsub = conditions[0]; //if condition, (x < 4)
//               String thensub = conditions[1]; //then (y + 2)
//               String elsesub= ifelse[1]; //else 7
//               
//               Expression ifCondition = new Expression(ifsub);
//               Expression thenCondition = new Expression(thensub);
//               Expression elseCondition = new Expression(elsesub);
//               Tern tern1 = new Tern(ifCondition, thenCondition, elseCondition);
////            }
//            return tern1;
//        }
}
