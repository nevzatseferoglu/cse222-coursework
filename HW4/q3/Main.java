import edu.gtu.recursion.p1;
import edu.gtu.recursion.p2;
import edu.gtu.recursion.p3;
import edu.gtu.recursion.p4;
import edu.gtu.recursion.p5;
import edu.gtu.recursion.p6;

public class Main {

    public static final boolean p1_test = true;
    public static final boolean p2_test = true;
    public static final boolean p3_test = true;
    public static final boolean p4_test = true;
    public static final boolean p5_test = true;
    public static final boolean p6_test = true;

    public static void main( String[] argv ) {


        if( p1_test ) {
            System.out.println("~~~~~~~~~~~~Part1-Test~~~~~~~~~~~~");
            System.out.println();

            System.out.println("Given sentence : \"this function writes the sentence in reverse\" ");
            System.out.println("Result : " + p1.reverseSentence("this function writes the sentence in reverse") );
            System.out.println();

            System.out.println("Given sentence : \"I am a student at Gebze Technical University\"");
            System.out.println("Result : " + p1.reverseSentence("I am a student at Gebze Technical University") );
            System.out.println();

            System.out.println("Given sentence : \"024 044 171\" ");
            System.out.println("Result : " + p1.reverseSentence("024 044 171") );
            System.out.println();

            System.out.println("~~~~~~~~~~~~Part1-Test-End~~~~~~~~");
            System.out.println();
        }

        if( p2_test ) {
            System.out.println("~~~~~~~~~~~~Part2-Test~~~~~~~~~~~~");
            System.out.println();

            System.out.println("Test : \"elfish\" ");
            System.out.println( p2.isElfish("elfish"));
            System.out.println();

            System.out.println("Test : \"car\" ");
            System.out.println( p2.isElfish("car"));
            System.out.println();

            System.out.println("Test : \"whiteleaf\" ");
            System.out.println( p2.isElfish("whiteleaf"));
            System.out.println();

            System.out.println("Test : \"GTU\" ");
            System.out.println( p2.isElfish("car"));
            System.out.println();

            System.out.println("Test : \"tasteful\" ");
            System.out.println( p2.isElfish("tasteful"));
            System.out.println();

            System.out.println("Test : \"computer\" ");
            System.out.println( p2.isElfish("computer"));
            System.out.println();

            System.out.println("Test : \"unfriendly\" ");
            System.out.println( p2.isElfish("unfriendly"));
            System.out.println();

            System.out.println("Test : \"waffles \" ");
            System.out.println( p2.isElfish("waffles "));
            System.out.println();

            System.out.println("~~~~~~~~~~~~Part2-Test-End~~~~~~~~");
            System.out.println();
        }

        if( p3_test ) {
            System.out.println("~~~~~~~~~~~~Part3-Test~~~~~~~~~~~~");
            System.out.println();

            Integer[] arr = null;

            System.out.println("Initialization of array : ");
            arr = new Integer[]{-1,2,-3,4,6,9};
            System.out.println("Unsorted form : -1 2 -3 4 6 9");
            p3.selectionSort(arr);
            System.out.print("Sorted   form : " );
            for (Integer integer : arr) {
                System.out.print(integer + " ");
            }
            System.out.println("\n");

            System.out.println("Initialization of array : ");
            arr = new Integer[]{1,7,1,0,4,4,0,2,4};
            System.out.println("Unsorted form : 1 7 1 0 4 4 0 2 4");
            p3.selectionSort(arr);
            System.out.print("Sorted   form : " );
            for (Integer integer : arr) {
                System.out.print(integer + " ");
            }
            System.out.println("\n");

            System.out.println("Initialization of array : ");
            arr = new Integer[]{9,-1,8,-2,7,-3,6,-4,5};
            System.out.println("Unsorted form : 9 -1 8 -2 7 -3 6 -4 5");
            p3.selectionSort(arr);
            System.out.print("Sorted   form : " );
            for (Integer integer : arr) {
                System.out.print(integer + " ");
            }
            System.out.println("\n");

            System.out.println("Initialization of array : ");
            arr = new Integer[]{1,5,2,3,4,-6,7,-1,-4,8,2,1,23,1,33,93,-65};
            System.out.println("Unsorted form : 1 5 2 3 4 -6 7 -1 -4 8 2 1 23 1 33 93 -65");
            p3.selectionSort(arr);
            System.out.print("Sorted   form : " );
            for (Integer integer : arr) {
                System.out.print(integer + " ");
            }
            System.out.println("\n");

            System.out.println("~~~~~~~~~~~~Part3-Test-End~~~~~~~~");
            System.out.println();
        }

        if( p4_test ) {
            System.out.println("~~~~~~~~~~~~Part4-Test~~~~~~~~~~~~");
            System.out.println();

            System.out.println("Rules of function that can evaluate prefix expression : ");
            System.out.println("1-) Expression form have to be a String.");
            System.out.println("2-) There must be a space among the elements of the expression.");
            System.out.println("3-) If an expression invalid , function given an error as String about invalid input.");
            System.out.println("4-) Evaluation precision can extend until type double.");
            System.out.println();

            System.out.println("Prefix Expression : ");
            System.out.println("- + + 5 / - 4 * 2 1 2 3 / 7 1");
            System.out.println("Evaluation Result : " + p4.prefixEvaluate("- + + 5 / - 4 * 2 1 2 3 / 7 1"));
            System.out.println();

            System.out.println("Prefix Expression : ");
            System.out.println("+ / + 2 * 3 2 4 2");
            System.out.println("Evaluation Result : " + p4.prefixEvaluate("+ / + 2 * 3 2 4 2"));
            System.out.println();

            System.out.println("Prefix Expression : ");
            System.out.println("+ / + 2 * 3 -2 4 2");
            System.out.println("Evaluation Result : " + p4.prefixEvaluate("+ / + 2 * 3 -2 4 2"));
            System.out.println();

            System.out.println("Prefix Expression : ");
            System.out.println("/ + / * - 1 3 2 2 5 -3");
            System.out.println("Evaluation Result : " + p4.prefixEvaluate("/ + / * - 1 3 2 2 5 -3"));
            System.out.println();

            System.out.println("~~~~~~~~~~~~Part4-Test-End~~~~~~~~");
            System.out.println();
        }

        if( p5_test ) {
            System.out.println("~~~~~~~~~~~~Part5-Test~~~~~~~~~~~~");
            System.out.println();

            System.out.println("Rules of function that can evaluate postfix expression : ");
            System.out.println("1-) Expression form have to be a String.");
            System.out.println("2-) There must be a space among the elements of the expression.");
            System.out.println("3-) If an expression invalid , function given an error as String about invalid input.");
            System.out.println("4-) Evaluation precision can extend until type double.");
            System.out.println();

            System.out.println("Postfix Expression : ");
            System.out.println("5 4 2 1 * - 2 / + 3 + 7 1 / -");
            System.out.println("Evaluation Result : " + p5.postfixEvaluate("5 4 2 1 * - 2 / + 3 + 7 1 / -"));
            System.out.println();

            System.out.println("Postfix Expression : ");
            System.out.println("1 3 + 2 * 8 / 1 2 + -");
            System.out.println("Evaluation Result : " + p5.postfixEvaluate("1 3 + 2 * 8 / 1 2 + -"));
            System.out.println();

            System.out.println("Postfix Expression : ");
            System.out.println("10 5 + 3 / 2 3 - 4 * +");
            System.out.println("Evaluation Result : " + p5.postfixEvaluate("10 5 + 3 / 2 3 - 4 * +"));
            System.out.println();

            System.out.println("Postfix Expression : ");
            System.out.println("1 4 - 3 * 10 +");
            System.out.println("Evaluation Result : " + p5.postfixEvaluate("1 4 - 3 * 10 +"));
            System.out.println();

            System.out.println("~~~~~~~~~~~~Part5-Test-End~~~~~~~~");
            System.out.println();
        }

        if( p6_test ) {
            System.out.println("~~~~~~~~~~~~Part6-Test~~~~~~~~~~~~");
            System.out.println();

            Integer[][] intArr;
            Character[][] charArr;

            System.out.println("Input array : ");
            intArr = new Integer[][] {
                {1 , 2 , 3 , 4},
                {5 , 6 , 7 , 8},
                {9 , 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
            };
            for (Integer[] integers : intArr) {
                for (int j = 0; j < intArr[0].length; ++j) {
                    System.out.printf("%-3d ",integers[j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Snail output :");
            System.out.println( p6.snail(intArr ));
            System.out.println();

            System.out.println("Input array : ");
            intArr = new Integer[][] {
                {1 , 2 , 3 , 4},
                {5 , 6 , 7 , 8}
            };
            for (Integer[] integers : intArr) {
                for (int j = 0; j < intArr[0].length; ++j) {
                    System.out.printf("%-3d ",integers[j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Snail output :");
            System.out.println( p6.snail(intArr ));
            System.out.println();

            System.out.println("Input array : ");
            intArr = new Integer[][] {
                { 1  , 2  },
                { 3  , 4  },
                { 5  , 6  },
                { 7  , 8  },
                { 9  , 10 },
                { 11 , 12 }
            };
            for (Integer[] integers : intArr) {
                for (int j = 0; j < intArr[0].length; ++j) {
                    System.out.printf("%-3d ",integers[j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Snail output :");
            System.out.println( p6.snail(intArr ));
            System.out.println();

            System.out.println("Input array : ");
            charArr = new Character[][] {
                    { 'a'  , 'b'  , 'c' },
                    { 'd'  , 'e'  , 'f' },
                    { 'g'  , 'h'  , 'i' },
                    { 'j'  , 'k'  , 'l' },
                    { 'm'  , 'n'  , 'o' },
                    { 'p'  , 'q'  , 'r' },
                    { 's'  , 't'  , 'u' },
                    { 'v'  , 'w'  , 'x' },
                    { 'y'  , 'z'  , '~' },
            };
            for (Character[] characters : charArr) {
                for (int j = 0; j < charArr[0].length; ++j) {
                    System.out.printf("%-3c ",characters[j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Snail output :");
            System.out.println( p6.snail(charArr ));
            System.out.println();

            System.out.println("Input array : ");
            charArr = new Character[][] {
                    { '1'  , '2'  , '3' },
                    { '4'  , '5'  , '*' },
                    { '7'  , '8'  , 'G' },
                    { 'a'  , 'b'  , 'T' },
                    { 'c'  , '*'  , 'U' }
            };
            for (Character[] characters : charArr) {
                for (int j = 0; j < charArr[0].length; ++j) {
                    System.out.printf("%-3c ",characters[j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Snail output :");
            System.out.println( p6.snail(charArr ));
            System.out.println();

            System.out.println("Input array : ");
            charArr = new Character[][] {
                    { 'a'  , 'b'  , 'c' , 'd' },
                    { 'e'  , 'f'  , 'g' , 'h' },
                    { 'i'  , 'j'  , 'k' , 'l' },
            };
            for (Character[] characters : charArr) {
                for (int j = 0; j < charArr[0].length; ++j) {
                    System.out.printf("%-3c ",characters[j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Snail output :");
            System.out.println( p6.snail(charArr ));
            System.out.println();

            System.out.println("~~~~~~~~~~~~Part6-Test-End~~~~~~~~");
            System.out.println();
        }

    }
}
