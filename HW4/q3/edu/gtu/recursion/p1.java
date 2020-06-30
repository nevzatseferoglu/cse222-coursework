package edu.gtu.recursion;

/**
 * Reverse given input in terms of words.
 */
public class p1 {

    /**
     * Reverse given input.
     * @param str string that will be reversed.
     * @return reversed string representation.
     */
    public static String reverseSentence( String str ) {

        int index = str.indexOf(" ");

        if( index == -1 ) {
            return str;
        }
        else {
            return reverseSentence( str.substring( index + 1 ) ) + " " + str.substring(0,index);
        }
    }
}
