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
        Expression literal1 = new Expression(new Lit("3"));
        Expression literal2 = new Expression(new  Lit("4"));
        Expression literal3 = new Expression(new Lit("2"));
        Expression literal4 = new Expression(new  Lit("5"));
        
        Expression plus = new Expression(new Operator("+"));
        Expression minus = new Expression(new Operator("-"));
        Expression mult = new Expression(new Operator("*"));
        Expression div = new Expression(new Operator("/"));
        
        Set setter = new Set("x", 6);
        Expression var1 = new Expression(new Var(setter));
        System.out.println("var " + var1.wholeString + "=" + var1.answer);
        Expression op1 = new Expression(new Operator(mult,var1,literal2));   
        Expression op4 = new Expression(new Operator(minus, literal3, literal4));

        Expression e2 = new Expression(op1,plus,op4);
     
        Operator op5 = new Operator(plus, literal3, literal4);
        Operator op2 = new Operator(plus, literal1, var1); 
        Expression a = new Expression(op2);
        Expression b = new Expression(op5);
        
        Expression out = new Expression(a, mult, b);
        //output  
        System.out.println("Expression = " + e2.wholeString + "=" + e2.answer);
        System.out.println(out.wholeString + " = " + out.answer);
        
        //lab 9 portion
//        ev.postOrder2(out);


//        String ex = "(3*(5&(1>0)))";
//        int x = 1;
//        int y = 8;
//        int xy = (x < 4) ? (y + 2) : 7;
//        String ex2 = "(x<4)?(y+2):7";
//        ev.parse(ex2);
//        System.out.println("");
//        int a = 1;
//        int b = 2;
//        int max = (a > b) ? a : b;
////        System.out.println("max = " + max);
////        System.out.println("xy = " + xy);
//        
//        System.out.println("");
//        String grade1 = (x >= 90) ? "A"
//        : (x >= 80) ? "B"
//        : (x >= 70) ? "C"
//        : (x > -60) ? "D"
//        : "F";
//        
//         String grade = "(x>=90)?A:(x >= 80)?B: (x >= 70)?C:(x>-60)?D:F";
////         ev.parse(grade);
//        String one = "1";
//        char two = '+' | '-' | '*' | '/';
//        String newString = one + two;
//        System.out.println(newString);

//          Expression myExpr = new PlusExpr( new MultExpr( new VarExpr("x"), new LitExpr(3)),
//                                new PlusExpr( new LitExpr(5), new SetExpr("x", new LitExpr(7))));

                
    }
    
}
