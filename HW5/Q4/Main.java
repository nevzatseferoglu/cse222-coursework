
import edu.gtu.AgeData.*;
import edu.gtu.Heap.*;

public class Main {

    public static void main( String[] argv ) {

        System.out.println();
        System.out.println("MaxHeap and AgeData Testing");
        System.out.println("=================================\n");

        System.out.println("Creating heap with constructor.");
        MaxHeap<AgeData> ageHeap = new MaxHeap<AgeData>();
        System.out.println();

        System.out.println("Adding ages to Heap.");
        System.out.println("- add( new AgeData(10) )");
        System.out.println("- add( new AgeData(20) )");
        System.out.println("- add( new AgeData(5) )");
        System.out.println("- add( new AgeData(15) )");
        System.out.println("- add( new AgeData(10) )");
        System.out.println("- add( new AgeData(9) )");
        System.out.println("- add( new AgeData(25) )");
        System.out.println("- add( new AgeData(16) )");
        System.out.println("- add( new AgeData(18) )");
        System.out.println("- add( new AgeData(20) )");
        System.out.println("- add( new AgeData(9) )");
        System.out.println("- add( new AgeData(9) )");
        ageHeap.add( new AgeData( 10 ));
        ageHeap.add( new AgeData( 20 ));
        ageHeap.add( new AgeData( 5 ));
        ageHeap.add( new AgeData( 15 ));
        ageHeap.add( new AgeData( 10 ));
        ageHeap.add( new AgeData( 9 ));
        ageHeap.add( new AgeData( 25 ));
        ageHeap.add( new AgeData( 16 ));
        ageHeap.add( new AgeData( 18 ));
        ageHeap.add( new AgeData( 20 ));
        ageHeap.add( new AgeData( 9 ));
        ageHeap.add( new AgeData( 9 ));
        System.out.println("--------------");
        System.out.println("Current Heap : ");
        System.out.println( ageHeap );
        System.out.println();

        System.out.println("- find( new AgeData( 10 )).toString() ");
        if( ageHeap.find( new AgeData(10) ) == null ) {
            System.out.println("Given item has not been found in heap.");
        } else {
            System.out.println( ageHeap.find( new AgeData(10) ).toString() );
        }
        System.out.println();

        System.out.println("- find( new AgeData( 18 )).toString() ");
        if( ageHeap.find( new AgeData(18) ) == null ) {
            System.out.println("Given item has not been found in heap.");
        } else {
            System.out.println( ageHeap.find( new AgeData(18) ).toString() );
        }
        System.out.println();

        System.out.println("- find( new AgeData( 7 )).toString() ");
        if( ageHeap.find( new AgeData(7) ) == null ) {
            System.out.println("Given item has not been found in heap.");
        } else {
            System.out.println( ageHeap.find( new AgeData(7) ).toString() );
        }
        System.out.println();

        System.out.println("- youngerThan( 15 )");
        System.out.println( ageHeap.youngerThan( 15 ));
        System.out.println();

        System.out.println("- olderThan( 10 )");
        System.out.println( ageHeap.olderThan( 10 ));
        System.out.println();


        System.out.println("- remove( new AgeData( 9 ) )");
        if( !ageHeap.remove( new AgeData( 9 )) ) {
            System.out.println("Item cannot be found and removed.");
        }
        System.out.println("--------------");
        System.out.println("Current Heap : ");
        System.out.println( ageHeap );
        System.out.println();

        System.out.println("- remove( new AgeData( 10 ) )");
        if( !ageHeap.remove( new AgeData( 10 )) ) {
            System.out.println("Item cannot be found and removed.");
        }
        System.out.println("--------------");
        System.out.println("Current heap : ");
        System.out.println( ageHeap );
        System.out.println();

        System.out.println("- remove( new AgeData( 7 ) )");
        if( !ageHeap.remove( new AgeData( 7 )) ) {
            System.out.println("Item cannot be found and removed.");
        }
        System.out.println("--------------");
        System.out.println("Current Heap : ");
        System.out.println( ageHeap );
        System.out.println();

    }
}