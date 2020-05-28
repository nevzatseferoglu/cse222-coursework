import edu.gtu.Sorting.*;

import java.util.LinkedList;
import java.util.List;

class SortingTest
{
    public static void Test_MyMergeSort() {

        System.out.println("---------------MyMerge-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        LinkedList<Integer> K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = (LinkedList<Integer>) ListGenerator.GenerateList(10000 , true );
            MyMergeSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += MyMergeSort.getRunTime();
            MyMergeSort.clearStat();
        }

        K_10 = (LinkedList<Integer>) ListGenerator.GenerateList(10000 , false );
        MyMergeSort.sort(  K_10 );
        averageRunningTimeOf_K_10 += MyMergeSort.getRunTime();
        MyMergeSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("MyMerge-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");
        LinkedList<Integer> K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_40 = (LinkedList<Integer>) ListGenerator.GenerateList(40000 , true );
            MyMergeSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += MyMergeSort.getRunTime();
            MyMergeSort.clearStat();
        }

        K_40 = (LinkedList<Integer>) ListGenerator.GenerateList(40000 , false );
        MyMergeSort.sort(  K_40 );
        averageRunningTimeOf_K_40 += MyMergeSort.getRunTime();
        MyMergeSort.clearStat();

        averageRunningTimeOf_K_40 /= 21;

        System.out.println("MyMerge-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");
        LinkedList<Integer> K_100 = null;
        long averageRunningTimeOf_K_100 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_100 = (LinkedList<Integer>) ListGenerator.GenerateList(100000 , true );
            MyMergeSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += MyMergeSort.getRunTime();
            MyMergeSort.clearStat();
        }

        K_100 = (LinkedList<Integer>) ListGenerator.GenerateList(100000 , false );
        MyMergeSort.sort(  K_100 );
        averageRunningTimeOf_K_100 += MyMergeSort.getRunTime();
        MyMergeSort.clearStat();

        averageRunningTimeOf_K_100 /= 21;

        System.out.println("MyMerge-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        LinkedList<Integer> K_150 = null;
        long averageRunningTimeOf_K_150 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_150 = (LinkedList<Integer>) ListGenerator.GenerateList(150000 , true );
            MyMergeSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += MyMergeSort.getRunTime();
            MyMergeSort.clearStat();
        }

        K_150 = (LinkedList<Integer>) ListGenerator.GenerateList(150000 , false );
        MyMergeSort.sort(  K_150 );
        averageRunningTimeOf_K_150 += MyMergeSort.getRunTime();
        MyMergeSort.clearStat();

        averageRunningTimeOf_K_150 /= 21;

        System.out.println("MyMerge-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        LinkedList<Integer> K_180;
        long averageRunningTimeOf_K_180 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_180 = (LinkedList<Integer>) ListGenerator.GenerateList(180000 , true );
            MyMergeSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += MyMergeSort.getRunTime();
            MyMergeSort.clearStat();
        }

        K_180 = (LinkedList<Integer>) ListGenerator.GenerateList(180000 , false );
        MyMergeSort.sort(  K_180 );
        averageRunningTimeOf_K_180 += MyMergeSort.getRunTime();
        MyMergeSort.clearStat();

        averageRunningTimeOf_K_180 /= 21;

        System.out.println("MyMerge-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/
    }

    public static void Test_MyQuickSort() {
        System.out.println("---------------MyQuick-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        List<Integer> K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateList(10000 , true );
            MyQuickSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += MyQuickSort.getRunTime();
            MyQuickSort.clearStat();
        }

        K_10 = ListGenerator.GenerateList(10000 , false );
        MyQuickSort.sort( K_10 );
        averageRunningTimeOf_K_10 += MyQuickSort.getRunTime();
        MyQuickSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("MyQuick-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.exit(1);

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            BubbleSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        BubbleSort.sort( K_40 );
        averageRunningTimeOf_K_40 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_40 /= 4;

        System.out.println("Bubble-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            BubbleSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        BubbleSort.sort( K_100 );
        averageRunningTimeOf_K_100 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_100 /= 4;

        System.out.println("Bubble-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            BubbleSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        BubbleSort.sort( K_150 );
        averageRunningTimeOf_K_150 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_150 /= 4;

        System.out.println("Bubble-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            BubbleSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        BubbleSort.sort( K_180 );
        averageRunningTimeOf_K_180 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_180 /= 4;

        System.out.println("Bubble-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Bubble-Sort-Test-End--------------------------");

        /*===============================================================================================*/
    }

    public static void Test_MergeSort() {
        System.out.println("---------------Merge-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        Integer[] K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateArray(10000 , true );
            MergeSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += MergeSort.getRunTime();
            MergeSort.clearStat();
        }

        K_10 = ListGenerator.GenerateArray(10000 , false );
        MergeSort.sort( K_10 );
        averageRunningTimeOf_K_10 += MergeSort.getRunTime();
        MergeSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("Merge-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            MergeSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += MergeSort.getRunTime();
            MergeSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        MergeSort.sort( K_40 );
        averageRunningTimeOf_K_40 += MergeSort.getRunTime();
        MergeSort.clearStat();

        averageRunningTimeOf_K_40 /= 21;

        System.out.println("Merge-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            MergeSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += MergeSort.getRunTime();
            MergeSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        MergeSort.sort( K_100 );
        averageRunningTimeOf_K_100 += MergeSort.getRunTime();
        MergeSort.clearStat();

        averageRunningTimeOf_K_100 /= 21;

        System.out.println("Merge-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            MergeSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += MergeSort.getRunTime();
            MergeSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        MergeSort.sort( K_150 );
        averageRunningTimeOf_K_150 += MergeSort.getRunTime();
        MergeSort.clearStat();

        averageRunningTimeOf_K_150 /= 21;

        System.out.println("Merge-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            MergeSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += MergeSort.getRunTime();
            MergeSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        MergeSort.sort( K_180 );
        averageRunningTimeOf_K_180 += MergeSort.getRunTime();
        MergeSort.clearStat();

        averageRunningTimeOf_K_180 /= 21;

        System.out.println("Merge-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Merge-Sort-Test-End--------------------------");

        /*===============================================================================================*/
    }

    public static void Test_QuickSort(){
        System.out.println("---------------Quick-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        Integer[] K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateArray(10000 , true );
            QuickSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += QuickSort.getRunTime();
            QuickSort.clearStat();
        }

        K_10 = ListGenerator.GenerateArray(10000 , false );
        QuickSort.sort( K_10 );
        averageRunningTimeOf_K_10 += QuickSort.getRunTime();
        QuickSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("Quick-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            QuickSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += QuickSort.getRunTime();
            QuickSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        QuickSort.sort( K_40 );
        averageRunningTimeOf_K_40 += QuickSort.getRunTime();
        QuickSort.clearStat();

        averageRunningTimeOf_K_40 /= 21;

        System.out.println("Quick-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            QuickSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += QuickSort.getRunTime();
            QuickSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        QuickSort.sort( K_100 );
        averageRunningTimeOf_K_100 += QuickSort.getRunTime();
        QuickSort.clearStat();

        averageRunningTimeOf_K_100 /= 21;

        System.out.println("Quick-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            QuickSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += QuickSort.getRunTime();
            QuickSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        QuickSort.sort( K_150 );
        averageRunningTimeOf_K_150 += QuickSort.getRunTime();
        QuickSort.clearStat();

        averageRunningTimeOf_K_150 /= 21;

        System.out.println("Quick-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            QuickSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += QuickSort.getRunTime();
            QuickSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        QuickSort.sort( K_180 );
        averageRunningTimeOf_K_180 += QuickSort.getRunTime();
        QuickSort.clearStat();

        averageRunningTimeOf_K_180 /= 21;

        System.out.println("Quick-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Quick-Sort-Test-End--------------------------");

        /*===============================================================================================*/
    }

    public static void Test_BubbleSort() {

        System.out.println("---------------Bubble-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        Integer[] K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateArray(10000 , true );
            BubbleSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += BubbleSort.getRunTime();
            BubbleSort.clearStat();
        }

        K_10 = ListGenerator.GenerateArray(10000 , false );
        BubbleSort.sort( K_10 );
        averageRunningTimeOf_K_10 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("Bubble-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            BubbleSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        BubbleSort.sort( K_40 );
        averageRunningTimeOf_K_40 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_40 /= 4;

        System.out.println("Bubble-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            BubbleSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        BubbleSort.sort( K_100 );
        averageRunningTimeOf_K_100 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_100 /= 4;

        System.out.println("Bubble-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            BubbleSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        BubbleSort.sort( K_150 );
        averageRunningTimeOf_K_150 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_150 /= 4;

        System.out.println("Bubble-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            BubbleSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += BubbleSort.getRunTime();
            BubbleSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        BubbleSort.sort( K_180 );
        averageRunningTimeOf_K_180 += BubbleSort.getRunTime();
        BubbleSort.clearStat();

        averageRunningTimeOf_K_180 /= 4;

        System.out.println("Bubble-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Bubble-Sort-Test-End--------------------------");

        /*===============================================================================================*/

    }

    public static void Test_HeapSort() {
        System.out.println("---------------Heap-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        Integer[] K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateArray(10000 , true );
            HeapSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += HeapSort.getRunTime();
            HeapSort.clearStat();
        }

        K_10 = ListGenerator.GenerateArray(10000 , false );
        HeapSort.sort( K_10 );
        averageRunningTimeOf_K_10 += HeapSort.getRunTime();
        HeapSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("Heap-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            HeapSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += HeapSort.getRunTime();
            HeapSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        HeapSort.sort( K_40 );
        averageRunningTimeOf_K_40 += HeapSort.getRunTime();
        HeapSort.clearStat();

        averageRunningTimeOf_K_40 /= 21;

        System.out.println("Heap-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            HeapSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += HeapSort.getRunTime();
            HeapSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        HeapSort.sort( K_100 );
        averageRunningTimeOf_K_100 += HeapSort.getRunTime();
        HeapSort.clearStat();

        averageRunningTimeOf_K_100 /= 21;

        System.out.println("Heap-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            HeapSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += HeapSort.getRunTime();
            HeapSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        HeapSort.sort( K_150 );
        averageRunningTimeOf_K_150 += HeapSort.getRunTime();
        HeapSort.clearStat();

        averageRunningTimeOf_K_150 /= 21;

        System.out.println("Heap-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            HeapSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += HeapSort.getRunTime();
            HeapSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        HeapSort.sort( K_180 );
        averageRunningTimeOf_K_180 += HeapSort.getRunTime();
        HeapSort.clearStat();

        averageRunningTimeOf_K_180 /= 21;

        System.out.println("Heap-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Heap-Sort-Test-End--------------------------");

        /*===============================================================================================*/
    }

    public static void Test_InsertionSort() {

        System.out.println("---------------Insertion-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        Integer[] K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateArray(10000 , true );
            InsertionSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += InsertionSort.getRunTime();
            InsertionSort.clearStat();

        }

        K_10 = ListGenerator.GenerateArray(10000 , false );
        InsertionSort.sort( K_10 );
        averageRunningTimeOf_K_10 += InsertionSort.getRunTime();
        InsertionSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("Insertion-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            InsertionSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += InsertionSort.getRunTime();
            InsertionSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        InsertionSort.sort( K_40 );
        averageRunningTimeOf_K_40 += InsertionSort.getRunTime();
        InsertionSort.clearStat();

        averageRunningTimeOf_K_40 /= 4;

        System.out.println("Insertion-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            InsertionSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += InsertionSort.getRunTime();
            InsertionSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        InsertionSort.sort( K_100 );
        averageRunningTimeOf_K_100 += InsertionSort.getRunTime();
        InsertionSort.clearStat();

        averageRunningTimeOf_K_100 /= 4;

        System.out.println("Insertion-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            InsertionSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += InsertionSort.getRunTime();
            InsertionSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        InsertionSort.sort( K_150 );
        averageRunningTimeOf_K_150 += InsertionSort.getRunTime();
        InsertionSort.clearStat();

        averageRunningTimeOf_K_150 /= 4;

        System.out.println("Insertion-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            InsertionSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += InsertionSort.getRunTime();
            InsertionSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        InsertionSort.sort( K_180 );
        averageRunningTimeOf_K_180 += InsertionSort.getRunTime();
        InsertionSort.clearStat();

        averageRunningTimeOf_K_180 /= 4;

        System.out.println("Insertion-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Insertion-Sort-Test-End--------------------------");

        /*===============================================================================================*/
    }

    public static void Test_SelectionSort() {
        System.out.println("---------------Selection-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        Integer[] K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateArray(10000 , true );
            SelectionSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += SelectionSort.getRunTime();
            SelectionSort.clearStat();
        }

        K_10 = ListGenerator.GenerateArray(10000 , false );
        SelectionSort.sort( K_10 );
        averageRunningTimeOf_K_10 += SelectionSort.getRunTime();
        SelectionSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("Selection-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 10 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            SelectionSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += SelectionSort.getRunTime();
            SelectionSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        SelectionSort.sort( K_40 );
        averageRunningTimeOf_K_40 += SelectionSort.getRunTime();
        SelectionSort.clearStat();

        averageRunningTimeOf_K_40 /= 11;

        System.out.println("Selection-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 2 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            SelectionSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += SelectionSort.getRunTime();
            SelectionSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        SelectionSort.sort( K_100 );
        averageRunningTimeOf_K_100 += SelectionSort.getRunTime();
        SelectionSort.clearStat();

        averageRunningTimeOf_K_100 /= 3;

        System.out.println("Selection-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 1 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            SelectionSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += SelectionSort.getRunTime();
            SelectionSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        SelectionSort.sort( K_150 );
        averageRunningTimeOf_K_150 += SelectionSort.getRunTime();
        SelectionSort.clearStat();

        averageRunningTimeOf_K_150 /= 2;

        System.out.println("Selection-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 1 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            SelectionSort.sort(  K_180 );
            averageRunningTimeOf_K_180 += SelectionSort.getRunTime();
            SelectionSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        SelectionSort.sort( K_180 );
        averageRunningTimeOf_K_180 += SelectionSort.getRunTime();
        SelectionSort.clearStat();

        averageRunningTimeOf_K_180 /= 2;

        System.out.println("Selection-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Selection-Sort-Test-End--------------------------");

        /*===============================================================================================*/
    }

    public static void Test_ShellSort() {
        System.out.println("---------------Shell-Sort Test---------------");
        System.out.println();

        System.out.println("---------------------------10K-Begin-------------------------");
        Integer[] K_10 = null;
        long averageRunningTimeOf_K_10 = 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_10 = ListGenerator.GenerateArray(10000 , true );
            ShellSort.sort(  K_10 );
            averageRunningTimeOf_K_10 += ShellSort.getRunTime();
            ShellSort.clearStat();
        }

        K_10 = ListGenerator.GenerateArray(10000 , false );
        ShellSort.sort( K_10 );
        averageRunningTimeOf_K_10 += ShellSort.getRunTime();
        ShellSort.clearStat();

        averageRunningTimeOf_K_10 /= 21;

        System.out.println("Shell-Sort , running time for 10K : " + averageRunningTimeOf_K_10 +
                " millisecond.");
        K_10 = null;
        System.out.println("--------------------10K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------40K-Begin-------------------------");

        Integer[] K_40 = null;
        long averageRunningTimeOf_K_40 = 0;

        for( int i = 0 ; i < 3 ; ++i ) {

            K_40 = ListGenerator.GenerateArray(40000 , true );
            ShellSort.sort(  K_40 );
            averageRunningTimeOf_K_40 += ShellSort.getRunTime();
            ShellSort.clearStat();

        }

        K_40 = ListGenerator.GenerateArray(40000 , false );
        ShellSort.sort( K_40 );
        averageRunningTimeOf_K_40 += ShellSort.getRunTime();
        ShellSort.clearStat();

        averageRunningTimeOf_K_40 /= 4;

        System.out.println("Shell-Sort , running time for 40K : " + averageRunningTimeOf_K_40 +
                " millisecond.");
        K_40 = null;
        System.out.println("--------------------40K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/


        System.out.println("---------------------------100K-Begin-------------------------");

        Integer[] K_100 = null;
        long averageRunningTimeOf_K_100= 0;

        for( int i = 0 ; i < 2 ; ++i ) {

            K_100 = ListGenerator.GenerateArray(100000 , true );
            ShellSort.sort(  K_100 );
            averageRunningTimeOf_K_100 += ShellSort.getRunTime();
            ShellSort.clearStat();

        }

        K_100 = ListGenerator.GenerateArray(100000 , false );
        ShellSort.sort( K_100 );
        averageRunningTimeOf_K_100 += ShellSort.getRunTime();
        ShellSort.clearStat();

        averageRunningTimeOf_K_100 /= 3;

        System.out.println("Shell-Sort , running time for 100K : " + averageRunningTimeOf_K_100 +
                " millisecond.");
        K_100 = null;
        System.out.println("--------------------100K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------150K-Begin-------------------------");
        Integer[] K_150 = null;
        long averageRunningTimeOf_K_150= 0;

        for( int i = 0 ; i < 1 ; ++i ) {

            K_150 = ListGenerator.GenerateArray(150000 , true );
            ShellSort.sort(  K_150 );
            averageRunningTimeOf_K_150 += ShellSort.getRunTime();
            ShellSort.clearStat();

        }

        K_150 = ListGenerator.GenerateArray(150000 , false );
        ShellSort.sort( K_150 );
        averageRunningTimeOf_K_150 += ShellSort.getRunTime();
        ShellSort.clearStat();

        averageRunningTimeOf_K_150 /= 2;

        System.out.println("Shell-Sort , running time for 150K : " + averageRunningTimeOf_K_150 +
                " millisecond.");
        K_150 = null;
        System.out.println("--------------------150K-End----------------------------------------");
        System.out.println();

        /*===============================================================================================*/

        System.out.println("---------------------------180K-Begin-------------------------");
        Integer[] K_180 = null;
        long averageRunningTimeOf_K_180= 0;

        for( int i = 0 ; i < 20 ; ++i ) {

            K_180 = ListGenerator.GenerateArray(180000 , true );
            ShellSort.sort( K_180 );

            averageRunningTimeOf_K_180 += ShellSort.getRunTime();
            ShellSort.clearStat();

        }

        K_180 = ListGenerator.GenerateArray(180000 , false );
        ShellSort.sort( K_180 );
        averageRunningTimeOf_K_180 += ShellSort.getRunTime();
        ShellSort.clearStat();

        averageRunningTimeOf_K_180 /= 21;

        System.out.println("Shell-Sort , running time for 180K : " + averageRunningTimeOf_K_180 +
                " millisecond.");
        K_180 = null;
        System.out.println("--------------------180K-End----------------------------------------");
        System.out.println();

        System.out.println("--------------------Shell-Sort-Test-End--------------------------");

        /*===============================================================================================*/
    }

    /* Only ont soring algorithm can be tested at a time */
    public static boolean Test_MyMergeSort      = true;
    public static boolean Test_MyQuickSort      = true;

    public static boolean Test_MergeSort        = true;
    public static boolean Test_QuickSort        = true;
    public static boolean Test_BubbleSort       = true;
    public static boolean Test_HeapSort         = true;
    public static boolean Test_InsertionSort    = true;
    public static boolean Test_SelectionSort    = true;
    public static boolean Test_ShellSort        = true;
    /*---------------------------------------------------*/


    public static void main( String[] argv ) {


        if( Test_ShellSort ) {
            Test_QuickSort();
        }

        if( Test_InsertionSort ) {
            Test_MyMergeSort();
        }

        if( Test_BubbleSort ) {
            Test_MyQuickSort();
        }

        if( Test_SelectionSort ) {
            Test_MergeSort();
        }

        if( Test_HeapSort ) {
            Test_BubbleSort();
        }

        if( Test_MergeSort ) {
            Test_HeapSort();
        }

        if( Test_QuickSort ) {
            Test_InsertionSort();
        }

        if( Test_MergeSort ) {
            Test_SelectionSort();
        }

        if( Test_MyQuickSort ) {
            Test_ShellSort();
        }

    }
} 