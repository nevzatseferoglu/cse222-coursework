import edu.gtu.util.LinkedArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static final boolean _test_list_function = true;
    public static final boolean _test_iterator = true;
    public static final boolean _test_collection_constructor = true;

    public static void main( String[] argv ) {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Constant array size which inside node is 3");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if( _test_collection_constructor ) {
            System.out.println("\nLinkedArrayList - java.util.Collection Constructor Test");
            System.out.println("-----------------------------");

            LinkedList<String> student = new LinkedList<>();
            System.out.println("LinkedList<String> student = new LinkedList<>();");
            System.out.println("Java utility legacy LinkedList which keeps student info created with no parameter constructor.\n");

            System.out.println("add(\"Nevzat\")");
            student.add("Nevzat");

            System.out.println("add(\"171044024\")");
            student.add("171044024");

            LinkedArrayList<String> studentInMyList = new LinkedArrayList<>( student );
            System.out.println("\nLinkedArrayList<String> studentInMyList = new LinkedArrayList<>( student );");
            System.out.println("List which keeps stundent info as String created with using Collection include constructor .\n");

            System.out.println(studentInMyList + "\n");

            System.out.println("- clear() ");
            studentInMyList.clear();
            System.out.println("Size of list = " + studentInMyList.size());
            System.out.println(studentInMyList);
            System.out.println("~~~~~~~\n");

            System.out.println("~~~~_test_list_constructor~~~END~~~~");

        }
        if( _test_list_function ) {

            System.out.println("\nLinkedArrayList - Method Test");
            System.out.println("-----------------------------");


            LinkedArrayList<String> cities = new LinkedArrayList<>();
            System.out.println("List which keeps cities created with no parameter constructor.\n");

            System.out.println("- size()");
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- add( \"Adana\" ) ");
            cities.add("Adana");
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- add( \"Istanbul\" ) ");
            cities.add("Istanbul");
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- add( \"Tokat\" ) ");
            cities.add("Tokat");
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- add( \"Antalya\" ) ");
            cities.add("Antalya");
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- get( 0 ) ");
            System.out.println(cities.get(0));
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- get( cities.size() - 1 ) ");
            System.out.println(cities.get( cities.size() - 1 ));
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- set( 0 ,\" Kocaeli \" ) ");
            cities.set( 0,"Kocaeli" );
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- remove( \"Istanbul\" ) ");
            cities.remove( "Istanbul" );
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- add( 1 , \"Izmir\" ) ");
            cities.add( 1 , "Izmir" );
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- remove( 1 ) ");
            cities.remove( 1 );
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- indexOf(\"Antalya\") ");
            System.out.println(cities.indexOf("Antalya"));
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- add( \"Tokat\" ) ");
            cities.add("Tokat");
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- add( \"Chicago\" ) ");
            cities.add("Chicago");
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- lastIndexOf( \"Tokat\" ) ");
            System.out.println(cities.lastIndexOf("Tokat"));
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");


            System.out.println("- hashCode() ");
            System.out.println(cities.hashCode());
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("- clear() ");
            cities.clear();
            System.out.println("Size of list = " + cities.size());
            System.out.println(cities);
            System.out.println("~~~~~~~\n");

            System.out.println("~~~~_test_list_function~~~END~~~~");

        }
        if( _test_iterator ) {
            System.out.println("\nLinkedArrayList - Iterator Test");
            System.out.println("-----------------------------");


            LinkedArrayList<String> countries = new LinkedArrayList<>();
            System.out.println("List which keeps countries created with no parameter constructor.\n");

            System.out.println("- size()");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("ListIterator has been declared with name 'iter'.");
            System.out.println("- ListIterator<String> iter = listIterator(\"0\")\n");
            ListIterator<String> iter = countries.listIterator(0);

            System.out.println("- add(\"Canada\")");
            iter.add("Canada");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- add(\"USA\")");
            iter.add("USA");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- add(\"China\")");
            iter.add("China");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- add(\"England\")");
            iter.add("England");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- add(\"Poland\")");
            iter.add("Poland");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- hasNext() ");
            System.out.println(iter.hasNext());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- hasPrevious() ");
            System.out.println(iter.hasPrevious());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- hasPrevious() ");
            System.out.println(iter.hasPrevious());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- next() ");
            System.out.println(iter.next());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- add(\"India\") ");
            iter.add("India");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- next() ");
            System.out.println(iter.next());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- next() ");
            System.out.println(iter.next());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- add(\"Brazil\") ");
            iter.add("Brazil");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- next() ");
            System.out.println(iter.next());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- add(\"Italy\") ");
            iter.add("Italy");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- remove() ");
            iter.remove();
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- next() ");
            System.out.println(iter.next());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- remove() ");
            iter.remove();
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previous() ");
            System.out.println(iter.previous());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- nextIndex() ");
            System.out.println(iter.nextIndex());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- previousIndex() ");
            System.out.println(iter.previousIndex());
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- set(\"Peru\") ");
            iter.set("Peru");
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("- clear() ");
            countries.clear();
            System.out.println("Size of list = " + countries.size());
            System.out.println(countries);
            System.out.println("~~~~~~~\n");

            System.out.println("~~~~_test_list_iterator~~~END~~~~");

        }

    }
}