import edu.gtu.TreeAndList.BTree;
import edu.gtu.TreeAndList.BinarySearchTree;
import edu.gtu.TreeAndList.RedBlackTree;
import edu.gtu.TreeAndList.SkipList;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main {


    public static final boolean REGULAR_BINARY_TREE = true;
    public static final boolean RED_BLACK_TREE_BOOK = true;
    public static final boolean RED_BLACK_TREE_JAVA = true;
    public static final boolean B_TREE_BOOK = true;
    public static final boolean SKIP_LIST_BOOK = true;
    public static final boolean SKIP_LIST_JAVA = true;

    public static void main( String[] argv ) {

        Instant start;
        Instant end;
        Random random = new Random();

        if( REGULAR_BINARY_TREE ) {

            System.out.println("====Regular BinarySearchTree-Test======");
            System.out.println();

            BinarySearchTree<Integer> binarySearchTree10K = null;
            BinarySearchTree<Integer> binarySearchTree20K = null;
            BinarySearchTree<Integer> binarySearchTree40K = null;
            BinarySearchTree<Integer> binarySearchTree80K = null;
            BinarySearchTree<Integer> binarySearchTreeBuilt;


            for( int i = 0 ; i < 10 ; ++i ) {
                binarySearchTree10K = new BinarySearchTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 10000 ; ++j ) {
                    binarySearchTree10K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BinarySearchTree " + (i+1) +"." + " 10K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                binarySearchTree20K = new BinarySearchTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 20000 ; ++j ) {
                    binarySearchTree20K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BinarySearchTree " + (i+1) +"." + " 20K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                binarySearchTree40K = new BinarySearchTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 40000 ; ++j ) {
                    binarySearchTree40K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BinarySearchTree " + (i+1) +"." + " 40K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                binarySearchTree80K = new BinarySearchTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 80000 ; ++j ) {
                    binarySearchTree80K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BinarySearchTree " + (i+1) +"." + " 80K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            System.out.println();
            System.out.println("Built-Validation Test");
            binarySearchTreeBuilt = new BinarySearchTree<>();
            for( int j = 0 ; j < 50 ; ++j ) {
                binarySearchTreeBuilt.add( random.nextInt(50) );
            }
            System.out.print("Built Tree : ");
            System.out.println(binarySearchTreeBuilt);
            System.out.println();

            int extraNumber = -1;

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (binarySearchTree10K.contains( extraNumber = random.nextInt() )); );
                binarySearchTree10K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 10K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (binarySearchTree20K.contains( extraNumber = random.nextInt() )); );
                binarySearchTree20K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 20K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (binarySearchTree40K.contains( extraNumber = random.nextInt() )); );
                binarySearchTree40K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 40K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (binarySearchTree80K.contains( extraNumber = random.nextInt() )); );
                binarySearchTree80K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 80K insertion : " + Duration.between( start , end ).toNanos() + " ns.");
            System.out.println();

            int deletion = 0;
            int deletedItem = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( binarySearchTree10K.find( deletedItem = random.nextInt()) != null ) {
                    binarySearchTree10K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 10K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( binarySearchTree20K.find( deletedItem = random.nextInt()) != null ) {
                    binarySearchTree20K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 20K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( binarySearchTree40K.find( deletedItem = random.nextInt()) != null ) {
                    binarySearchTree40K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 40K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( binarySearchTree80K.find( deletedItem = random.nextInt()) != null ) {
                    binarySearchTree80K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 80K size: " + Duration.between( start , end ).toMillis() + " ms.");

            System.out.println();
            System.out.println("====Regular BinarySearchTree-Test-End======");

        }

        if( RED_BLACK_TREE_BOOK ) {
            System.out.println("====RedBlackTree-Test======");
            System.out.println();

            RedBlackTree<Integer> redBlackTree10K = null;
            RedBlackTree<Integer> redBlackTree20K = null;
            RedBlackTree<Integer> redBlackTree40K = null;
            RedBlackTree<Integer> redBlackTree80K = null;
            RedBlackTree<Integer> redBlackTreeBuilt;


            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTree10K = new RedBlackTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 10000 ; ++j ) {
                    redBlackTree10K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTree " + (i+1) +"." + " 10K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTree20K = new RedBlackTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 20000 ; ++j ) {
                    redBlackTree20K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTree " + (i+1) +"." + " 20K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTree40K = new RedBlackTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 40000 ; ++j ) {
                    redBlackTree40K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTree " + (i+1) +"." + " 40K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTree80K = new RedBlackTree<>();
                start = Instant.now();
                for( int j = 0 ; j < 80000 ; ++j ) {
                    redBlackTree80K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTree " + (i+1) +"." + " 80K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            System.out.println();
            System.out.println("Built-Validation Test");
            redBlackTreeBuilt = new RedBlackTree<>();
            for( int j = 0 ; j < 50 ; ++j ) {
                redBlackTreeBuilt.add( random.nextInt(50) );
            }
            System.out.print("Built Tree : ");
            System.out.println(redBlackTreeBuilt);
            System.out.println();

            int extraNumber = -1;

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTree10K.contains( extraNumber = random.nextInt() )); );
                redBlackTree10K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 10K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTree20K.contains( extraNumber = random.nextInt() )); );
                redBlackTree20K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 20K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTree40K.contains( extraNumber = random.nextInt() )); );
                redBlackTree40K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 40K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTree80K.contains( extraNumber = random.nextInt() )); );
                redBlackTree80K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 80K insertion : " + Duration.between( start , end ).toNanos() + " ns.");
            System.out.println();

            int deletion = 0;
            int deletedItem = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTree10K.find( deletedItem = random.nextInt()) != null ) {
                    redBlackTree10K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 10K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTree20K.find( deletedItem = random.nextInt()) != null ) {
                    redBlackTree20K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 20K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTree40K.find( deletedItem = random.nextInt()) != null ) {
                    redBlackTree40K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 40K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTree80K.find( deletedItem = random.nextInt()) != null ) {
                    redBlackTree80K.delete( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 80K size: " + Duration.between( start , end ).toMillis() + " ms.");

            System.out.println();
            System.out.println("====RedBlackTree-Test-End======");
        }

        if( RED_BLACK_TREE_JAVA) {
            System.out.println("====RedBlackTreeJava-Test======");
            System.out.println();

            TreeSet<Integer> redBlackTreeJava10K = null;
            TreeSet<Integer> redBlackTreeJava20K = null;
            TreeSet<Integer> redBlackTreeJava40K = null;
            TreeSet<Integer> redBlackTreeJava80K = null;
            TreeSet<Integer> redBlackTreeJavaBuilt;


            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTreeJava10K = new TreeSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 10000 ; ++j ) {
                    redBlackTreeJava10K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTreeJava " + (i+1) +"." + " 10K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTreeJava20K = new TreeSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 20000 ; ++j ) {
                    redBlackTreeJava20K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTreeJava " + (i+1) +"." + " 20K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTreeJava40K = new TreeSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 40000 ; ++j ) {
                    redBlackTreeJava40K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTreeJava " + (i+1) +"." + " 40K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                redBlackTreeJava80K = new TreeSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 80000 ; ++j ) {
                    redBlackTreeJava80K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("RedBlackTreeJava " + (i+1) +"." + " 80K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            System.out.println();
            System.out.println("Built-Validation Test");
            redBlackTreeJavaBuilt = new TreeSet<>();
            for( int j = 0 ; j < 50 ; ++j ) {
                redBlackTreeJavaBuilt.add( random.nextInt(50) );
            }
            System.out.print("Built Tree : ");
            System.out.println(redBlackTreeJavaBuilt);
            System.out.println();

            int extraNumber = -1;

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTreeJava10K.contains( extraNumber = random.nextInt() )); );
                redBlackTreeJava10K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 10K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTreeJava20K.contains( extraNumber = random.nextInt() )); );
                redBlackTreeJava20K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 20K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTreeJava40K.contains( extraNumber = random.nextInt() )); );
                redBlackTreeJava40K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 40K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (redBlackTreeJava80K.contains( extraNumber = random.nextInt() )); );
                redBlackTreeJava80K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 80K insertion : " + Duration.between( start , end ).toNanos() + " ns.");
            System.out.println();

            int deletion = 0;
            int deletedItem = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTreeJava10K.contains( deletedItem = random.nextInt() ) ) {
                    redBlackTreeJava10K.remove( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 10K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTreeJava20K.contains( deletedItem = random.nextInt() ) ) {
                    redBlackTreeJava20K.remove( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 20K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTreeJava40K.contains( deletedItem = random.nextInt() ) ) {
                    redBlackTreeJava40K.remove( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 40K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( redBlackTreeJava80K.contains( deletedItem = random.nextInt() ) ) {
                    redBlackTreeJava80K.remove( deletedItem );
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 80K size: " + Duration.between( start , end ).toMillis() + " ms.");

            System.out.println();
            System.out.println("====RedBlackTreeJava-Test-End======");
        }

        if( B_TREE_BOOK ) {
            System.out.println("====BTree-Test======");
            System.out.println();

            BTree<Integer> bTree10K = null;
            BTree<Integer> bTree20K = null;
            BTree<Integer> bTree40K = null;
            BTree<Integer> bTree80K = null;
            BTree<Integer> bTreeBuilt;


            for( int i = 0 ; i < 10 ; ++i ) {
                bTree10K = new BTree<>(3);
                start = Instant.now();
                for( int j = 0 ; j < 10000 ; ++j ) {
                    bTree10K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BTree " + (i+1) +"." + " 10K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                bTree20K = new BTree<>(3);
                start = Instant.now();
                for( int j = 0 ; j < 20000 ; ++j ) {
                    bTree20K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BTree " + (i+1) +"." + " 20K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                bTree40K = new BTree<>(3);
                start = Instant.now();
                for( int j = 0 ; j < 40000 ; ++j ) {
                    bTree40K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BTree " + (i+1) +"." + " 40K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                bTree80K = new BTree<>(3);
                start = Instant.now();
                for( int j = 0 ; j < 80000 ; ++j ) {
                    bTree80K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("BTree " + (i+1) +"." + " 80K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            System.out.println();
            System.out.println("Built-Validation Test");
            bTreeBuilt = new BTree<>(3);
            for( int j = 0 ; j < 50 ; ++j ) {
                bTreeBuilt.add( random.nextInt(50) );
            }
            System.out.print("Built Tree : ");
            System.out.println(bTreeBuilt.toList());
            System.out.println();

            int extraNumber = -1;

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (bTree10K.contains( extraNumber = random.nextInt() )); );
                bTree10K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 10K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (bTree20K.contains( extraNumber = random.nextInt() )); );
                bTree20K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 20K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (bTree40K.contains( extraNumber = random.nextInt() )); );
                bTree40K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 40K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (bTree80K.contains( extraNumber = random.nextInt() )); );
                bTree80K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 80K insertion : " + Duration.between( start , end ).toNanos() + " ns.");
            System.out.println();

            System.out.println();
            System.out.println("====BTree-Test-End====");
        }

        if( SKIP_LIST_BOOK ) {
            System.out.println("====SkipListBook-Test======");
            System.out.println();

            SkipList<Integer> skipList10K = null;
            SkipList<Integer> skipList20K = null;
            SkipList<Integer> skipList40K = null;
            SkipList<Integer> skipList80K = null;
            SkipList<Integer> skipListBuilt;


            for( int i = 0 ; i < 10 ; ++i ) {
                skipList10K = new SkipList<>();
                start = Instant.now();
                for( int j = 0 ; j < 10000 ; ++j ) {
                    skipList10K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListBook " + (i+1) +"." + " 10K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                skipList20K = new SkipList<>();
                start = Instant.now();
                for( int j = 0 ; j < 20000 ; ++j ) {
                    skipList20K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListBook " + (i+1) +"." + " 20K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                skipList40K = new SkipList<>();
                start = Instant.now();
                for( int j = 0 ; j < 40000 ; ++j ) {
                    skipList40K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListBook " + (i+1) +"." + " 40K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                skipList80K = new SkipList<>();
                start = Instant.now();
                for( int j = 0 ; j < 80000 ; ++j ) {
                    skipList80K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListBook " + (i+1) +"." + " 80K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            System.out.println();
            System.out.println("Built-Validation Test");
            skipListBuilt = new SkipList<>();
            for( int j = 0 ; j < 50 ; ++j ) {
                skipListBuilt.add( random.nextInt(50) );
            }
            System.out.println("Built Skip-List : ");
            System.out.println(skipListBuilt);
            System.out.println();

            int extraNumber = -1;

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipList10K.find( extraNumber = random.nextInt() ) != null ); );
                skipList10K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 10K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipList20K.find( extraNumber = random.nextInt() ) != null ); );
                skipList20K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 20K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipList40K.find( extraNumber = random.nextInt() ) != null ); );
                skipList40K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 40K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipList80K.find( extraNumber = random.nextInt() ) != null ); );
                skipList80K.add( extraNumber );
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 80K insertion : " + Duration.between( start , end ).toNanos() + " ns.");
            System.out.println();

            int deletion = 0;
            int deletedItem = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipList10K.find( deletedItem = random.nextInt()) != null ) {
                    skipList10K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 10K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipList20K.find( deletedItem = random.nextInt()) != null ) {
                    skipList20K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 20K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipList40K.find( deletedItem = random.nextInt()) != null ) {
                    skipList40K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 40K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipList80K.find( deletedItem = random.nextInt()) != null ) {
                    skipList80K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 80K size: " + Duration.between( start , end ).toMillis() + " ms.");

            System.out.println();
            System.out.println("====SkipList-Test-End======");
        }

        if( SKIP_LIST_JAVA ) {
            System.out.println("====SkipListJava-Test======");
            System.out.println();

            ConcurrentSkipListSet<Integer> skipListJava10K = null;
            ConcurrentSkipListSet<Integer> skipListJava20K = null;
            ConcurrentSkipListSet<Integer> skipListJava40K = null;
            ConcurrentSkipListSet<Integer> skipListJava80K = null;
            ConcurrentSkipListSet<Integer> skipListJavaBuilt;


            for( int i = 0 ; i < 10 ; ++i ) {
                skipListJava10K = new ConcurrentSkipListSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 10000 ; ++j ) {
                    skipListJava10K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListJava " + (i+1) +"." + " 10K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                skipListJava20K = new ConcurrentSkipListSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 20000 ; ++j ) {
                    skipListJava20K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListJava " + (i+1) +"." + " 20K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                skipListJava40K = new ConcurrentSkipListSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 40000 ; ++j ) {
                    skipListJava40K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListJava " + (i+1) +"." + " 40K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            for( int i = 0 ; i < 10 ; ++i ) {
                skipListJava80K = new ConcurrentSkipListSet<>();
                start = Instant.now();
                for( int j = 0 ; j < 80000 ; ++j ) {
                    skipListJava80K.add( random.nextInt() );
                }
                end = Instant.now();
                System.out.println("SkipListJava " + (i+1) +"." + " 80K insertion: " + Duration.between( start , end ).toMillis() + " ms.");
            }
            System.out.println();

            System.out.println();
            System.out.println("Built-Validation Test");
            skipListJavaBuilt = new ConcurrentSkipListSet<>();
            for( int j = 0 ; j < 50 ; ++j ) {
                skipListJavaBuilt.add( random.nextInt(50) );
            }
            System.out.print("Built Tree : ");
            System.out.println(skipListJavaBuilt);
            System.out.println();

            int extraNumber = -1;

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipListJava10K.contains( extraNumber = random.nextInt() )); );
                skipListJava10K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 10K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipListJava20K.contains( extraNumber = random.nextInt() )); );
                skipListJava20K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 20K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipListJava40K.contains( extraNumber = random.nextInt() )); );
                skipListJava40K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 40K insertion : " + Duration.between( start , end ).toNanos() + " ns.");

            start = Instant.now();
            for( int i = 0 ; i < 10 ; ++i ) {
                for (  ; (skipListJava80K.contains( extraNumber = random.nextInt() )); );
                skipListJava80K.add(extraNumber);
            }
            end = Instant.now();
            System.out.println("10 extra random non-existing number insertion for 80K insertion : " + Duration.between( start , end ).toNanos() + " ns.");
            System.out.println();

            int deletion = 0;
            int deletedItem = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipListJava10K.contains(deletedItem = random.nextInt()) ) {
                    skipListJava10K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 10K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipListJava20K.contains(deletedItem = random.nextInt()) ) {
                    skipListJava20K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 20K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipListJava40K.contains(deletedItem = random.nextInt()) ) {
                    skipListJava40K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 40K size: " + Duration.between( start , end ).toMillis() + " ms.");

            deletion = 0;

            start = Instant.now();
            for( ; deletion != 10;  ) {
                if( skipListJava80K.contains(deletedItem = random.nextInt()) ) {
                    skipListJava80K.remove(deletedItem);
                    ++deletion;
                }
            }
            end = Instant.now();
            System.out.println("10 random existing number deletion from 80K size: " + Duration.between( start , end ).toMillis() + " ms.");

            System.out.println();
            System.out.println("====SkipListJava-Test-End======");
        }

    }
}
