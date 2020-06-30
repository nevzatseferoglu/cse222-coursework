package edu.gtu.Expression;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class which represent tree from given prefix and postfix
 * expression.
 */
public class ExpressionTree extends BinaryTree<String> {

    /**
     * Keep the type of given expression tree.
     */
    private static boolean isPrefix;

    /**
     * Keeps given expression.
     */
    private static String curExpression = null;

    /**
     * Constructor that takes take
     * @param data operand or operator
     * @param leftTree tree that will be a left sub-tree of newly created tree.
     * @param rightTree tree that will be a right sub-tree of newly created tree.
     */
    private ExpressionTree( String data , ExpressionTree leftTree , ExpressionTree rightTree) {
        super( data ,leftTree , rightTree);
    }

    /**
     * Read the given prefix expression as Scanner , return a tree of it.
     * @param scan Scanner version of given expression.
     * @return newly created tree.
     */
    private static ExpressionTree readPrefixExpressionTree( Scanner scan ) {

        String data;

        if( !scan.hasNext() ) {
            return null;
        }
        else {
            data = scan.next();
        }

        if( isNumeric( data )) {
            return new ExpressionTree( data , null , null );
        }
        else {
            ExpressionTree leftTree = readPrefixExpressionTree(scan);
            ExpressionTree rightTree = readPrefixExpressionTree(scan);
            return new ExpressionTree( data , leftTree ,rightTree );
        }
    }

    /**
     * Read the given postfix expression as Scanner , return a tree of it.
     * @param scan Scanner version of given expression.
     * @return newly created tree.
     */
    private static ExpressionTree readPostfixExpressionTree( Scanner scan ) {

        int used = 0 , initialCapacity = 10;
        String[] convertArr = new String[ initialCapacity ];

        String item = null;

        try {
            while ( scan.hasNext() ) {
                item = scan.next();

                if( isOperator( item )) {

                    String tempStr = " " + item + " " + convertArr[ used - 2 ] + " " + convertArr[ used - 1 ] + " " ;
                    convertArr[ used - 1 ] = null;
                    convertArr[ used - 2 ] = null;
                    used -= 2;

                    convertArr[ used ] = tempStr;
                    ++used;

                }
                else if( isNumeric( item )){
                    convertArr = ensureExtraCapacity( convertArr , used );
                    convertArr[ used ] = item;
                    ++used;
                }
            }

            item = convertArr[ 0 ];
        }
        catch ( Exception ex ) {
            System.out.println("Invalid expression : " + curExpression );
            System.exit( 1 );
        }

        return readPrefixExpressionTree( new Scanner( item ) );
    }


    /**
     * Determine whether given String is an operator.
     * @param str String that will be checked.
     * @return true if string represents operator otherwise return false.
     */
    private static boolean isOperator( String str ) {
        return str.equals("+") ||
                str.equals("-") ||
                str.equals("/") ||
                str.equals("*");
    }

    /**
     * Determine whether given String represents and integer.
     * @param str String that will be checked.
     * @return true if string represents integer otherwise return false.
     */
    private static boolean isNumeric( String str ) {
        try {
            Integer.parseInt( str );
            return true;

        } catch( NumberFormatException e ){
            return false;
        }
    }

    /**
     * Analyze the given string whether it is valid.
     * @param expression String that represents expression.
     */
    private static void analyzeExpression( String expression ) {
        String str;
        Scanner tempScanner = new Scanner( expression );
        int operatorNum = 0 , operandNum = 0;

        try {
            for( int i = 0 ; tempScanner.hasNext() ; ++i ) {
                str = tempScanner.next();

                if( isNumeric( str ) ) {
                    if( i == 0 ) {
                        isPrefix = false;
                    }
                    ++operandNum;
                }
                else if( isOperator( str ) ) {
                    if( i == 0 ) {
                        isPrefix = true;
                    }
                    ++operatorNum;
                }
                else {
                    throw new Exception();
                }
            }

            if( operatorNum + 1 != operandNum ) {
                throw new Exception();
            }
        }
        catch ( Exception ex ) {
            System.out.println("Invalid expression : " + expression );
            System.exit( 1 );
        }
    }

    /**
     * Convert the given Scanner to string.
     * @param scan Scanner
     * @return String representation of given Scanner.
     */
    private static String scannerToString( Scanner scan ) {

        StringBuilder str = new StringBuilder( );

        if( scan == null ) {
            return str.toString();
        }

        for( int i = 0 ; scan.hasNext() ; ++i ) {
            if( i != 0) {
                str.append(" ");
            }
            str.append( scan.next() );
        }

        return str.toString();
    }

    /**
     * Ensure extra capacity of  given String array capacity .
     * @param convertArr Array that will be ensured.
     * @param used used index amount of given array.
     * @return Depending on status of the given array , may return a newly created array or given array itself.
     */
    private static String[] ensureExtraCapacity( String[] convertArr , int used ) {

        if( convertArr.length == used ) {
            convertArr =  Arrays.copyOf( convertArr , used * 2);
        }

        return convertArr;
    }

    /**
     * Evaluate constructed tree , return result.
     * <p> Evaluating has done by post order traversing , because
     * for evaluation we need to reach the end of the tree which is the most subchild node or nodes.</p>
     * @param node Start node of evaluation.
     * @param result Avtual result of evaluation.
     * @return result of evaluation of current tree.
     */
    private int eval( Node<String> node , int result ) {

        if( node == null ) {
            return 0;
        }

        if( isNumeric( node.data ) ) {
            return Integer.parseInt( node.data );
        }

        if( isOperator( node.data ) ) {
            result = makeOperation( node.data , eval( node.leftTree , result ), eval( node.rightTree , result ) );
            node.data = Integer.toString( result );
        }

        return Integer.parseInt( node.data );

    }

    /**
     * Make an operation and return the result of it.
     * @param operator Operator that will be applied on operands as String.
     * @param left A left operand.
     * @param right A right operand.
     * @return Evaluation result of given operator and operands.
     */
    private int makeOperation( String operator , int left , int right ) {

        int result = 0;

        try {
            switch ( operator ) {

                case "+":
                    result = left + right;
                    break;

                case "-":
                    result = left - right;
                    break;

                case "*":
                    result = left * right;
                    break;

                case "/":
                    result = left / right;
                    break;

                default:
                    throw new Exception("Invalid operator");
            }
        }
        catch ( Exception ex ) {
            System.out.println("Invalid operator processing");
            System.exit( 1 );
        }

        return result;
    }

    /**
     * Create and StringBuilder formed according to post order traversing.
     * <p> It is postorder traversing method , firstly we go through the end of the tree and then
     * perform the task for each node.</p>
     * @param node Start node of traversing.
     * @param sb StringBuilder that will be constructed.
     */
    protected void postOrderTraverse( Node<String> node , StringBuilder sb ) {

        if( node != null ) {

            postOrderTraverse( node.leftTree , sb );
            postOrderTraverse( node.rightTree , sb );
            sb.append( node.toString() ).append(" ");

        }
    }

    /**
     * Constructor that build a tree from given prefix or postfix expression.
     * @param expression String that represents an expression.
     */
    public ExpressionTree( String expression ) {
        super();

        Scanner scan = new Scanner( expression );

        ExpressionTree newTree = readBinaryTree( scan );
        root = newTree.root;
    }

    /**
     * Build an ExpressionTree form given Scanner.
     * @param scan Scanner that represents expression as postfix or prefix.
     * @return Newly built ExpressionTree of given expression as scanner.
     */
    public static ExpressionTree readBinaryTree( Scanner scan ) {

        ExpressionTree tree = null;

        try {

            curExpression = scannerToString(scan);
            analyzeExpression( curExpression );
            scan = new Scanner( curExpression );

            if( isPrefix ) {
                tree = readPrefixExpressionTree( scan );
            } else {
                tree = readPostfixExpressionTree( scan );
            }
        }
        catch ( Exception ex ) {
            System.out.println("Invalid expression : ");
            System.exit(1);
        }

        return tree;
    }

    /**
     * Return an evaluation of constructed tree.
     * @return Return an evaluation of constructed tree.
     */
    public int eval() {
        int result = 0;

        ExpressionTree newTree = new ExpressionTree( curExpression );

        try {
            result = eval( newTree.root , result );
        } catch ( ArithmeticException ex ) {
            System.out.println("Division by zero is undefined");
        }

        return result;
    }

    /**
     * Return postfix constructed string representation of the tree.
     * @return String representation of current tree.
     */
    public String toString2() {

        StringBuilder sb = new StringBuilder();
        postOrderTraverse( root , sb );
        return sb.toString();

    }

}
