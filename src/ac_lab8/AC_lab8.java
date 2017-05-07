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
public class AC_lab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parser ev = new Parser();               
//        Expression literal1 = new Expression(new Lit("3"));
//        Expression literal2 = new Expression(new  Lit("4"));
//        Expression literal3 = new Expression(new Lit("2"));
//        Expression literal4 = new Expression(new  Lit("5"));
//        
//        Expression plus = new Expression(new Operator("+"));
//        Expression minus = new Expression(new Operator("-"));
//        Expression mult = new Expression(new Operator("*"));
//        Expression div = new Expression(new Operator("/"));
//        
//        Set setter = new Set("x", 6);
//        Expression var1 = new Expression(new Var(setter));
//        System.out.println("var " + var1.wholeString + "=" + var1.answer);
//        Expression op1 = new Expression(new Operator(mult,var1,literal2));   
//        Expression op4 = new Expression(new Operator(minus, literal3, literal4));
//
//        Evaluator ev1 = new Evaluator(">", var1, literal3);
//        Expression eval = new Expression(ev1);
//        Expression e2 = new Expression(op1,plus,op4); //use for lab 9
//     
//        Operator op5 = new Operator(mult, literal3, literal4);
//        Operator op2 = new Operator(plus, literal1, var1); 
//        Expression a = new Expression(op2);
//        Expression b = new Expression(op5);
//        
//        Tern t1 = new Tern(eval, op1, op4);        
//        Expression ternary1 = new Expression(t1);

        
        //output  
//        System.out.println("Ternary = " + ternary1.wholeString + "=" + ternary1.answer);
//        System.out.println("ev = " + ev1.wholeString + "=" + ev1.answer);
//        System.out.println("Expression = " + e2.wholeString + "=" + e2.answer);
//        System.out.println(out.wholeString + " = " + out.answer);
        
        //lab 9 portion
        String ex = "3 * 5 & 1 > 0"; //"(3*(5&(1>0)))"; = 3
        String exx = "4 > 3";
        String exxx = "x * x++ + 10 - x = 3";
        String lab9 = "read + 1 + 2 * 5"; //direct string output
        String example = "3 + x + 2 * 5 < 7"; //direct string output
        String max = "a > b ? a : b";
        
        //output
//        System.out.println("Example 1: " + example);

//        System.out.println("");
//        
//        System.out.println("Example 2 :" + lab9);

//        
//        System.out.println("");
        //must be super careful with spaces in conditionals
        String ex2 = "x < 4 ?y + 2 :10"; 
        ev.parseCondition2(ex2);
        
        //lab 10 portion
        Compiler cm = new Compiler();
        String treeString = "5+2";
//        ev.printTree(treeString);
//        Expression lit1 = new Expression(new Lit("5"));
//        Expression lit2 = new Expression(new Lit("2"));
//        Expression plus = new Expression(new Operator("+"));
//        Expression subtree = new Expression(lit1,plus,lit2);
//        Expression lit3 = new Expression(new Lit("4"));
//        Expression tree = new Expression(lit3,plus,subtree);
//        Operator o1 = new Operator(plus,lit1,lit2);
//        Expression lab10 = new Expression(o1);
//        cm.getCode(tree);

            ev.makeTree("3 + 6 + 2 * 5");
        
//        String grade1 = (x >= 90) ? "A"
//        : (x >= 80) ? "B"
//        : (x >= 70) ? "C"
//        : (x > -60) ? "D"
//        : "F";
//        
//         String grade = "(x>=90)?A:(x >= 80)?B: (x >= 70)?C:(x>-60)?D:F";
////         ev.parse(grade);             
    }
    
}
