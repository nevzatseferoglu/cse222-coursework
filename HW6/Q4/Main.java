import edu.gtu.HashTable.HashtableChain;

import java.util.Random;

import java.time.Duration;
import java.time.Instant;

public class Main {

    /* There is only chaining technique assignment in this homework */

    private static long runtime10KCreating = 0;
    private static long runtime10KGet = 0;
    private static long runtime10KPut = 0;
    private static long runtime10KRemove = 0;

    private static long runtime50KCreating = 0;
    private static long runtime50KGet = 0;
    private static long runtime50KPut = 0;
    private static long runtime50KRemove = 0;

    private static long runtime100KCreating = 0;
    private static long runtime100KGet = 0;
    private static long runtime100KPut = 0;
    private static long runtime100KRemove = 0;


    public static boolean test_HashtableChain = true;
    public static boolean test_SIZE_10K = true;
    public static boolean test_SIZE_50K = true;
    public static boolean test_SIZE_100K = true;


    public static void main( String[] argv ) {

        if( test_HashtableChain ) {

            System.out.println("--------Hashtable-with-Chaining-Technique-Start----------");
            System.out.println("============================================================");
            System.out.println();

            HashtableChain<Integer,String> hashTable = new HashtableChain<>();

            System.out.println("put(1 , \"A\");");
            System.out.println("put(1 , \"B\");");
            System.out.println("put(1 , \"A\");");
            System.out.println("put(1 , \"C\");");
            hashTable.put(1,"A");
            hashTable.put(1,"B");
            hashTable.put(1,"A");
            hashTable.put(1,"C");
            System.out.println("Size : " + hashTable.size());
            System.out.println("Current hashtable : ");
            System.out.println(hashTable);
            System.out.println();

            System.out.println("put(2 , \"A\");");
            System.out.println("put(2 , \"B\");");
            System.out.println("put(2 , \"A\");");
            System.out.println("put(2 , \"C\");");
            hashTable.put(2,"A");
            hashTable.put(2,"B");
            hashTable.put(2,"A");
            hashTable.put(2,"C");
            System.out.println("Size : " + hashTable.size());
            System.out.println("Current hashtable : ");
            System.out.println(hashTable);
            System.out.println();

            System.out.println("put(3 , \"A\");");
            System.out.println("put(3 , \"B\");");
            System.out.println("put(3 , \"A\");");
            System.out.println("put(3 , \"C\");");
            hashTable.put(3,"A");
            hashTable.put(3,"B");
            hashTable.put(3,"A");
            hashTable.put(3,"C");
            System.out.println("Size : " + hashTable.size());
            System.out.println("Current hashtable : ");
            System.out.println(hashTable);
            System.out.println();


            System.out.println("-> get(1) = " + hashTable.get(1));
            System.out.println("-> get(2) = " + hashTable.get(2));
            System.out.println("-> get(3) = " + hashTable.get(3));
            System.out.println("isEmpty() = " + hashTable.isEmpty());
            System.out.println();

            System.out.println("remove(1)");
            hashTable.remove(1);
            System.out.println("Size : " + hashTable.size());
            System.out.println("Current hashtable : ");
            System.out.println(hashTable);
            System.out.println();

            System.out.println("remove(2)");
            hashTable.remove(2);
            System.out.println("Size : " + hashTable.size());
            System.out.println("Current hashtable : ");
            System.out.println(hashTable);
            System.out.println();

            System.out.println("remove(3)");
            hashTable.remove(3);
            System.out.println("Size : " + hashTable.size());
            System.out.println("Current hashtable : ");
            System.out.println(hashTable);
            System.out.println();

            Random random = new Random();

            if( test_SIZE_10K ) {

                HashtableChain<Integer,Integer> hashTable10K = new HashtableChain<>();

                Instant start1 = Instant.now();

                Integer randomKey = 0;

                for( int i = 0 ; i < 10000 ; ++i ) {

                    randomKey = random.nextInt();
                    hashTable10K.put(randomKey  , random.nextInt());
                }

                Instant end1 = Instant.now();
                runtime10KCreating = Duration.between(start1 , end1).toNanos();

                Instant start2 = Instant.now();
                System.out.println("-> get(randomKey) = " + hashTable10K.get(randomKey));
                Instant end2 = Instant.now();
                runtime10KGet = Duration.between(start2 , end2).toNanos();

                Instant start3 = Instant.now();
                hashTable10K.remove(randomKey);
                Instant end3 = Instant.now();
                runtime10KRemove = Duration.between(start3 , end3).toNanos();

                Instant start4 = Instant.now();
                hashTable10K.put(randomKey , 50);
                Instant end4 = Instant.now();
                runtime10KPut = Duration.between(start4 , end4).toNanos();

                System.out.println();
                System.out.println("-------------------------");
                System.out.println("10K size analyzing...");
                System.out.println("Creating runtime =  " + runtime10KCreating + " ns " );
                System.out.println("get( ) runTime =  " + runtime10KGet + " ns " );
                System.out.println("remove( ) runTime =  " + runtime10KRemove + " ns " );
                System.out.println("put( ) runTime =  " + runtime10KPut + " ns " );
                System.out.println();

            }

            if( test_SIZE_50K ) {

                HashtableChain<Integer,Integer> hashTable50K = new HashtableChain<>();

                Instant start1 = Instant.now();

                Integer randomKey = 0;

                for( int i = 0 ; i < 50000 ; ++i ) {
                    randomKey = random.nextInt();
                    hashTable50K.put(randomKey , random.nextInt());
                }

                Instant end1 = Instant.now();
                runtime50KCreating = Duration.between(start1 , end1).toNanos();

                Instant start2 = Instant.now();
                System.out.println("-> get(randomKey) = " + hashTable50K.get(randomKey));
                Instant end2 = Instant.now();
                runtime50KGet = Duration.between(start2 , end2).toNanos();

                Instant start3 = Instant.now();
                hashTable50K.remove(randomKey);
                Instant end3 = Instant.now();
                runtime50KRemove = Duration.between(start3 , end3).toNanos();

                Instant start4 = Instant.now();
                hashTable50K.put(randomKey , 50);
                Instant end4 = Instant.now();
                runtime50KPut = Duration.between(start4 , end4).toNanos();

                System.out.println();
                System.out.println("-------------------------");
                System.out.println("50K size analyzing...");
                System.out.println("Creating runtime =  " + runtime50KCreating + " ns " );
                System.out.println("get( ) runTime =  " + runtime50KGet + " ns " );
                System.out.println("remove( ) runTime =  " + runtime50KRemove + " ns " );
                System.out.println("put( ) runTime =  " + runtime50KPut + " ns " );
                System.out.println();

            }

            if( test_SIZE_100K ) {
                HashtableChain<Integer,Integer> hashTable100K = new HashtableChain<>();

                Instant start1 = Instant.now();

                Integer randomKey = 0;

                for( int i = 0 ; i < 100000 ; ++i ) {
                    randomKey = random.nextInt();
                    hashTable100K.put(randomKey , random.nextInt());
                }

                Instant end1 = Instant.now();
                runtime100KCreating = Duration.between(start1 , end1).toNanos();

                Instant start2 = Instant.now();
                System.out.println("-> get(randomKey) = " + hashTable100K.get(randomKey));
                Instant end2 = Instant.now();
                runtime100KGet = Duration.between(start2 , end2).toNanos();

                Instant start3 = Instant.now();
                hashTable100K.remove(randomKey);
                Instant end3 = Instant.now();
                runtime100KRemove = Duration.between(start3 , end3).toNanos();

                Instant start4 = Instant.now();
                hashTable100K.put(randomKey , 50);
                Instant end4 = Instant.now();
                runtime100KPut = Duration.between(start4 , end4).toNanos();

                System.out.println();
                System.out.println("-------------------------");
                System.out.println("100K size analyzing...");
                System.out.println("Creating runtime =  " + runtime100KCreating + " ns " );
                System.out.println("get( ) runTime =  " + runtime100KGet + " ns ");
                System.out.println("remove( ) runTime =  " + runtime100KRemove + " ns ");
                System.out.println("put( ) runTime =  " + runtime100KPut + " ns ");
                System.out.println();
            }

            System.out.println();
            System.out.println("--------Hashtable-with-Chaining-Technique-End----------");
            System.out.println("=======================================================");
        }
    }

}
