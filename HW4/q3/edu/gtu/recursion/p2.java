package edu.gtu.recursion;

/**
 * Determine the given string is elfish or not.
 */
public class p2 {

    /**
     * Wrapper method for elfish.
     * @param str given string
     * @param in searching string that include character.
     * @param arrBool array that check whether covering
     * @return true if given string elfish otherwise return false.
     */
    private static boolean elfishWrapper( String str , String in, boolean[] arrBool ) {

        if( str == null || str.length() == 0 || in == null ) {
            return false;
        }

        update( str , in , arrBool , 0 );

        if( isCover( arrBool , 0 ) ) {
            return true;
        }

        return elfishWrapper( str.substring( 1 ) , in , arrBool );
    }

    /**
     * Check the given letter whether match specific index of the given string.
     * @param arrBool boolean array
     * @param index index
     * @return
     */
    private static boolean isCover( boolean[] arrBool , int index ) {

        if( index == arrBool.length ) {
            return true;
        }

        if( !arrBool[ index ] )
            return false;

        return isCover( arrBool , index + 1 );
    }

    /**
     * Update the status of the process for each recursion.
     * @param str given string
     * @param in searching string that include character.
     * @param arrBool array that check whether covering
     * @param index index
     */
    private static void update( String str , String in, boolean[] arrBool , int  index ) {

        if( index >= in.length() )
            return;

        if( str.charAt( 0 ) == in.charAt( index ) ) {
            arrBool[ index ] = true;
            index += arrBool.length;
        }

        update( str , in , arrBool , index + 1 );
    }

    /**
     * Check 'elfishity' of the given input.
     * @param str String that will be checked in terms of 'elfishity'.
     * @return true if given word is elfish otherwise return false.
     */
    public static boolean isElfish( String str ) {
        boolean[] arrBool = new boolean[ "elf".length() ];
        return elfishWrapper( str , "elf" , arrBool );
    }

}