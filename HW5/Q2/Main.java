import edu.gtu.Expression.ExpressionTree;
import java.util.Scanner;

public class Main {

    public static final boolean testPrefixInput = true;
    public static final boolean testPostfixInput = true;
    public static final boolean testExceptionInput = true;

    public static void main(String[] argv) {

        if (testPrefixInput) {

            System.out.println();
            System.out.println("ExpressionTree Class Prefix Input Test");
            System.out.println("======================================\n");

            System.out.println("Creating expression tree with constructor");
            ExpressionTree tree1 = new ExpressionTree("+ + 10 * 5 15 20");
            System.out.println("tree = + + 10 * 5 15 20 ");
            System.out.println("Expression tree successfully constructed");
            System.out.println();

            System.out.println("-eval()");
            System.out.println("Result : " + tree1.eval());
            System.out.println();

            System.out.println("-toString()");
            System.out.println("Result : " + tree1.toString());
            System.out.println();

            System.out.println("-toString2()");
            System.out.println("Result : " + tree1.toString2());
            System.out.println();

            System.out.println("Creating new expression tree with constructor");
            ExpressionTree tree2 = new ExpressionTree("/ + + * - 3 5 3 7 11 6");
            System.out.println("tree = / + + * - 3 5 3 7 11 6 ");
            System.out.println("Expression tree successfully constructed");
            System.out.println();

            System.out.println("-eval()");
            System.out.println("Result : " + tree2.eval());
            System.out.println();

            System.out.println("-toString()");
            System.out.println("Result : " + tree2.toString());
            System.out.println();

            System.out.println("-toString2()");
            System.out.println("Result : " + tree2.toString2());
            System.out.println();


            System.out.println("Creating Scanner with \"- / * + 1 3 4 2 3\" expression");
            Scanner scan = new Scanner("- / * + 1 3 4 2 3");
            System.out.println();

            System.out.println("readExpressionTree( scan )");
            ExpressionTree tree3 = ExpressionTree.readBinaryTree(scan);

            System.out.println("-eval()");
            System.out.println("Result : " + tree3.eval());
            System.out.println();

            System.out.println("-toString()");
            System.out.println("Result : " + tree3.toString());
            System.out.println();

            System.out.println("-toString2()");
            System.out.println("Result : " + tree3.toString2());
            System.out.println();

        }

        if (testPostfixInput) {

            System.out.println();
            System.out.println("ExpressionTree Class Postfix Input Test");
            System.out.println("======================================\n");

            System.out.println("Creating expression tree with constructor");
            ExpressionTree tree1 = new ExpressionTree("10 5 15 * + 20 +");
            System.out.println("tree = 10 5 15 * + 20 + ");
            System.out.println("Expression tree successfully constructed");
            System.out.println();

            System.out.println("-eval()");
            System.out.println("Result : " + tree1.eval());
            System.out.println();

            System.out.println("-toString()");
            System.out.println("Result : " + tree1.toString());
            System.out.println();

            System.out.println("-toString2()");
            System.out.println("Result : " + tree1.toString2());
            System.out.println();

            System.out.println("Creating new expression tree with constructor");
            ExpressionTree tree2 = new ExpressionTree("3 5 - 3 * 7 + 11 + 6 /");
            System.out.println("tree = 3 5 - 3 * 7 + 11 + 6 / ");
            System.out.println("Expression tree successfully constructed");
            System.out.println();

            System.out.println("-eval()");
            System.out.println("Result : " + tree2.eval());
            System.out.println();

            System.out.println("-toString()");
            System.out.println("Result : " + tree2.toString());
            System.out.println();

            System.out.println("-toString2()");
            System.out.println("Result : " + tree2.toString2());
            System.out.println();


            System.out.println("Creating Scanner with \"1 3 + 4 * 2 / 3 -\" expression");
            Scanner scan = new Scanner("1 3 + 4 * 2 / 3 -");
            System.out.println();

            System.out.println("readExpressionTree( scan )");
            ExpressionTree tree3 = ExpressionTree.readBinaryTree(scan);

            System.out.println("-eval()");
            System.out.println("Result : " + tree3.eval());
            System.out.println();

            System.out.println("-toString()");
            System.out.println("Result : " + tree3.toString());
            System.out.println();

            System.out.println("-toString2()");
            System.out.println("Result : " + tree3.toString2());
            System.out.println();

        }

        if (testExceptionInput) {
            System.out.println();
            System.out.println("ExpressionTree Invalid Input Testing");
            System.out.println("====================================\n");

            System.out.println("Attempt to build tree with invalid input");
            ExpressionTree tree;


            try {
                System.out.println("tree = - + - g t u 4 6 ");
                tree = new ExpressionTree("- + - g t u 4 6");
            }
            catch( Exception ex ) {
                System.out.println("Exception catch the invalid input : " + "- + - g t u 4 6" );
            }

        }
    }
}
