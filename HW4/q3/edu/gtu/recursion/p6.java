package edu.gtu.recursion;

/**
 * Generate a new string representation of 2D array
 * which lined up like snail.
 */
public class p6 {

    /**
     * Return snail output.
     * @param arr array , which is has to be 2D , is used for snail output.
     * @param <E> generic type of given array.
     * @return snail representation of given array as a String.
     */
    public static <E> String snail( E[][] arr ) {

        try {

            if( arr == null || arr.length == 0 ) {
                throw new Exception();
            }

            StringBuilder str = new StringBuilder();
            boolean[][] checkArr = new boolean[ arr.length ][arr[ 0 ].length];

            return snailWrapper( arr , 0 , 0 , 0 , arr[ 0 ].length - 1 ,  0 , checkArr , str );

        }
        catch ( Exception exceptionPocket ) {
            System.out.println("Invalid input array");
            System.exit( 1 );
        }

        return null;
    }

    /**
     * Wrapper also a recursive method of snail function.
     * @param arr array
     * @param xInitial initial x index.
     * @param xFinal final x index.
     * @param yInitial initial y index.
     * @param yFinal final y index.
     * @param taskCode unique task index code of set of task array.
     * @param checkArr array which will be used for checking whether all element is gotten over.
     * @param str initiate a String that represent snail output.
     * @param <E> generic type of given array.
     * @return snail representation of given array as a String.
     */
    private static<E> String snailWrapper( E[][] arr , int xInitial , int xFinal , int yInitial , int yFinal , int taskCode , boolean[][] checkArr , StringBuilder str ) {

        if( isTrackFilled( checkArr ) ) {
            return str.toString();
        }

        if( xInitial > xFinal ) {
            for( int i = xInitial ; i >= xFinal ; --i ) {
                checkArr[ i ][ yInitial ] = true;
                str.append( arr[ i ][ yInitial ] ).append( " " );
            }
        }
        else if( xInitial != xFinal ) {
            for( int i = xInitial ; i <= xFinal ; ++i ) {
                checkArr[ i ][ yInitial ] = true;
                str.append( arr[ i ][ yInitial ] ).append( " " );
            }
        }
        else if( yInitial > yFinal ) {
            for( int j = yInitial ; j >= yFinal ; --j ) {
                checkArr[ xInitial ][ j ] = true;
                str.append( arr[ xInitial ][ j ] ).append( " " );
            }
        }
        else if( yInitial != yFinal ) {
            for( int j = yInitial ; j <= yFinal ; ++j ) {
                checkArr[ xInitial ][ j ] = true;
                str.append( arr[ xInitial ][ j ] ).append( " " );
            }
        }
        else {
            checkArr[ xInitial ][ yInitial ] = true;
            str.append( arr[ xInitial ][ yInitial ] ).append( " " );
        }

        Integer[] xTaskArr = new Integer[]{ 1 , 2 , 3 , 2 };
        Integer[] yTaskArr = new Integer[]{ 1 , 2 , 1 , 3 };

        switch ( xTaskArr[taskCode] ) {
            case 1 :
                xInitial += 1;
                xFinal = arr.length - xInitial;
                break;
            case 2 :
                xInitial = xFinal;
                break;
            case 3 :
                xInitial -= 1;
                xFinal = arr.length - xFinal;
                break;
        }

        switch ( yTaskArr[taskCode] ) {
            case 1 :
                yInitial = yFinal;
                break;
            case 2 :
                yInitial -= 1;
                yFinal = arr[0].length - yFinal - 1;
                break;
            case 3 :
                yInitial += 1;
                yFinal = arr[0].length - yInitial - 1;
                break;
        }

        ++taskCode;
        if( taskCode == 4 ) {
            taskCode = 0;
        }

        return snailWrapper( arr , xInitial, xFinal , yInitial , yFinal , taskCode , checkArr , str );
    }


    /**
     * Check whether all element is gotten over.
     * @param arr array
     * @return true if all elements of array are gotten over otherwise return false.
     */
    private static boolean isTrackFilled( boolean[][] arr ) {

        for ( boolean[] booleans : arr ) {
            for ( int j = 0; j < arr[0].length; ++j ) {
                if ( !booleans[j] )
                    return false;
            }
        }
        return true;
    }
}
