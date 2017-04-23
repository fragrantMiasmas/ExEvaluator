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
public class Expression {
    
    String expr;
    Expression ex; //user input
    
    public Expression(){
        
    }
    
    public Expression(Expression ex1){
        ex = ex1;
    }
    
    public Expression(String user_input){
        expr = user_input;
    }       
//       public void makeBin(Expression user){ //ie (x<4)
//           String input = user.expr;
//              
//           String[] component = input.split("\\<"); //operator
//           String var = component[0];
//           String lit = component[2];
//           
//           Expression varEx = new Expression(var);
//           Expression litEx = new Expression(lit);
//           
//           Bin bin1 = new Bin("<", varEx, litEx);
//       }
//       
//       public Tern makeTern(Expression user){
//           String input = user.expr;
//           
//           String[] ifelse = input.split(":");
//           String[] conditions = ifelse[0].split("?");
////           for(int i = 0; i< conditions.length; i++){
//               String ifsub = conditions[0]; //if condition, left child
//               String thensub = conditions[1];
//               String elsesub= ifelse[1];
//               
//               Expression ifCondition = new Expression(ifsub);
//               Expression thenCondition = new Expression(thensub);
//               Expression elseCondition = new Expression(elsesub);
//               Tern tern1 = new Tern("?", ifCondition, thenCondition, elseCondition);
////            }
//            return tern1;
//        }
       
        
//        public void Exp2(Expression user){ //takes in whole expression
//        String input = user.expr; //example input: "(x < 4) ? (y + 2) : 7"
//        
//        Tern ternEx = makeTern(user);
//        String ifCondition = ternEx.ifsub.expr;
//        String thenCondition = ternEx.thensub.expr;
//        String elseCondition = ternEx.elsesub.expr;
//        
//        Expression ex1 = new Expression(ifCondition);
//        Expression ex2 = new Expression(thenCondition);
//        Expression ex3 = new Expression(elseCondition);
//        
//        makeBin(ex1);
//        makeBin(ex2);
//    }
    
    public void Exp2(Expression user){ //takes in whole expression
        String input = user.expr; //example input: "(x < 4) ? (y + 2) : 7"
        
        Tern ternEx = Tern.makeTern(user);
        String ifCondition = ternEx.ifsub.expr;
        String thenCondition = ternEx.thensub.expr;
        String elseCondition = ternEx.elsesub.expr;
        
        Expression ex1 = new Expression(ifCondition);
        Expression ex2 = new Expression(thenCondition);
        Expression ex3 = new Expression(elseCondition);
        
        Bin bin1 = Bin.makeBin(ex1);
        Bin bin2 = Bin.makeBin(ex2);
        
        Expression variable = bin1.var;
        Expression variable2 = bin2.var;
        
        Var var1 = new Var(variable);
        Var var2 = new Var(variable2);
        
        Expression literal1 = bin1.lit;
        Expression literal2 = bin2.lit;
        
        Lit lit1 = new Lit(literal1);
        Lit lit2 = new Lit(literal2);
        
        
    }
}
