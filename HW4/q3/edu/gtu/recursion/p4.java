package edu.gtu.recursion;

import java.util.Stack;

/**
 * Evaluation process of prefix expression.
 */
public class p4 {

    /**
     * Checking the given string whether it is numeric.
     * @param str string that will be checked.
     * @return true if given string is numeric otherwise return false.
     */
    private static boolean isNumeric( String str ) {
        try {

            Double.parseDouble(str);
            return true;

        } catch( NumberFormatException e ){

            return false;
        }
    }

    /**
     * Reverse given input.
     * @param str string that will be reversed.
     * @return reversed string representation.
     */
    private static String reverse( String str ) {

        int index = str.indexOf(" ");

        if( index == -1 ) {
            return str;
        }

        return reverse(str.substring( index + 1 )) + " " + str.substring( 0 , index ) ;
    }

    /**
     * Wrapper method of actual public prefixEvaluate method.
     * @param input prefix expression as a String.
     * @param stack abstract data type that can handle operands and operators.
     */
    private static void prefixWrapper(String input , Stack<String> stack ) {

        try
        {
            double i,j;
            int index = input.indexOf(" ");

            if( index == -1 && input.length() == 0 ) {
                return ;
            }
            else if( index == -1 ) {
                index += 2;
            }

            switch ( input.substring( 0 , index ) ) {

                case "+":

                    i =  Double.parseDouble( stack.pop() );
                    j =  Double.parseDouble( stack.pop() );
                    stack.push( Double.toString( i + j ) );

                    break;

                case "-":

                    i =  Double.parseDouble( stack.pop() );
                    j =  Double.parseDouble( stack.pop() );
                    stack.push( Double.toString( i - j ) );

                    break;

                case "*":

                    i =  Double.parseDouble( stack.pop() );
                    j =  Double.parseDouble( stack.pop() );
                    stack.push( Double.toString( i * j ) );

                    break;

                case "/":

                    i =  Double.parseDouble( stack.pop() );
                    j =  Double.parseDouble( stack.pop() );
                    stack.push( Double.toString( i / j ) );

                    break;

                default:

                    if( isNumeric( input.substring( 0 , index ) )) {
                        stack.push( input.substring( 0 , index) );
                        break;
                    }
                    throw new SyntaxErrorException("Invalid prefix input , " + " '" + input.substring( 0 , index ) + "' " + " is undefined." );
            }

            if( input.length() != 1 )
                prefixWrapper( input.substring( index + 1 )  , stack );
            else
                prefixWrapper( input.substring( index )  , stack );

        }
        catch ( SyntaxErrorException syntaxError ) {
            System.out.println( syntaxError.getMessage() );
            System.exit(1);
        }
        catch ( Exception exception ) {
            System.out.println("Operands/operators are not in correct order or missing.");
            System.exit(1);
        }

    }


    /**
     * Evaluate the given expression and return the result.
     * @param input prefix expression as a String.
     * @return result of evaluation of given prefix expression as double.
     */
    public static double prefixEvaluate( String input ) {

        input = reverse( input );
        Stack<String> stack = new Stack<>();
        prefixWrapper( input , stack );

        return Double.parseDouble( stack.pop() );

    }

    /**
     * Syntax error catcher.
     */
    private static class SyntaxErrorException extends Exception {
        public SyntaxErrorException( String message ) {
            super( message );
        }
    }
}
