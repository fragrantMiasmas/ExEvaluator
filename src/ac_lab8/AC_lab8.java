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
        //output                 
        Lit literal1 = new Lit("3");
        Lit literal2 = new Lit("4");
        Operator op1 = new Operator("*",literal1,literal2);
        Operator minus = new Operator("-");
        Operator op3 = new Operator("+", new Lit("2"), new Lit("6"));
        
        Expression ex2 = new Expression(op1, minus, op3);
        System.out.println(ex2.expr);
        System.out.println(ex2.answer);
        
        
        //lab 9 portion
//        cond.Express(cond);
//        cond.Express2(cond);
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
