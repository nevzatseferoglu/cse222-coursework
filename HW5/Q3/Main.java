import edu.gtu.AgaData.*;


public class Main {

    public static void main( String[] argv ) {
        System.out.println();
        System.out.println("AgeData and AgeSearchTree Testing");
        System.out.println("=================================\n");

        System.out.println("Creating tree with constructor.");
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();
        System.out.println();

        System.out.println("Adding ages to AgeSearchTree.");
        System.out.println("- add( new AgeData(10) )");
        System.out.println("- add( new AgeData(20) )");
        System.out.println("- add( new AgeData(5) )");
        System.out.println("- add( new AgeData(15) )");
        System.out.println("- add( new AgeData(10) )");
        System.out.println("- add( new AgeData(9) )");
        System.out.println("- add( new AgeData(25) )");
        System.out.println("- add( new AgeData(16) )");
        System.out.println("- add( new AgeData(18) )");
        ageTree.add( new AgeData( 10 ));
        ageTree.add( new AgeData( 20 ));
        ageTree.add( new AgeData( 5 ));
        ageTree.add( new AgeData( 15 ));
        ageTree.add( new AgeData( 10 ));
        ageTree.add( new AgeData( 9 ));
        ageTree.add( new AgeData( 25 ));
        ageTree.add( new AgeData( 16 ));
        ageTree.add( new AgeData( 18 ));
        System.out.println("--------------");
        System.out.println("Current Tree : ");
        System.out.println( ageTree );
        System.out.println();

        System.out.println("- find( new AgeData( 10 )).toString() ");
        if( ageTree.find( new AgeData(10) ) == null ) {
            System.out.println("Given item has not been found in tree.");
        } else {
            System.out.println( ageTree.find( new AgeData(10) ).toString() );
        }
        System.out.println();

        System.out.println("- find( new AgeData( 18 )).toString() ");
        if( ageTree.find( new AgeData(18) ) == null ) {
            System.out.println("Given item has not been found in tree.");
        } else {
            System.out.println( ageTree.find( new AgeData(18) ).toString() );
        }
        System.out.println();

        System.out.println("- find( new AgeData( 7 )).toString() ");
        if( ageTree.find( new AgeData(7) ) == null ) {
            System.out.println("Given item has not been found in tree.");
        } else {
            System.out.println( ageTree.find( new AgeData(7) ).toString() );
        }
        System.out.println();

        System.out.println("- youngerThan( 15 )");
        System.out.println( ageTree.youngerThan( 15 ));
        System.out.println();

        System.out.println("- olderThan( 10 )");
        System.out.println( ageTree.olderThan( 10 ));
        System.out.println();


        System.out.println("- remove( new AgeData( 9 ) )");
        if( !ageTree.remove( new AgeData( 9 )) ) {
            System.out.println("Item cannot be found and removed.");
        }
        System.out.println("--------------");
        System.out.println("Current Tree : ");
        System.out.println( ageTree );
        System.out.println();

        System.out.println("- remove( new AgeData( 10 ) )");
        if( !ageTree.remove( new AgeData( 10 )) ) {
            System.out.println("Item cannot be found and removed.");
        }
        System.out.println("--------------");
        System.out.println("Current Tree : ");
        System.out.println( ageTree );
        System.out.println();

        System.out.println("- remove( new AgeData( 7 ) )");
        if( !ageTree.remove( new AgeData( 7 )) ) {
            System.out.println("Item cannot be found and removed.");
        }
        System.out.println("--------------");
        System.out.println("Current Tree : ");
        System.out.println( ageTree );
        System.out.println();
    }
}
