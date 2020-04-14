import edu.gtu.util.deque.GtuDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

    public static final boolean test_constructor = true;
    public static final boolean test_methods = true;
    public static final boolean test_iterator = true;


    public static void main( String[] argv ) {

        if( test_constructor ) {

            System.out.println();
            System.out.println("Constructor-Test");
            System.out.println("~~~~~~~~~~~~~~~~");
            System.out.println();

            System.out.println("There is two different king of constructor for this collection");
            System.out.println("1-) Constructor that takes java util collection interface as an argument.");
            System.out.println("2-) No parameter constructor that initialize an empty collection.");
            System.out.println();

            System.out.println("Constructor-1");
            System.out.println("~~~~~~~~~~~~~");
            System.out.println();

            System.out.println("Java util Linked-List used for collection takes constructor of my unique collection");
            System.out.println("Initialization an empty Linked-List which is content : ");
            System.out.println("Java-List = [ 3, 2, 1 ]");
            LinkedList<Integer> javaList = new LinkedList<>();
            javaList.add(3);
            javaList.add(2);
            javaList.add(1);
            System.out.println();

            System.out.println("My collection takes this java collection as an argument.");
            GtuDeque<Integer> myCollection = new GtuDeque<>( javaList );
            System.out.println("My collection content exactly same as java util linked-list which" +
                    "is taken as a paramter of constructor.");
            System.out.println("My-Collection = ");
            System.out.println( myCollection );
            System.out.println();

            System.out.println("~~Constructor-1-End~~");
            System.out.println();

            System.out.println("Constructor-2");
            System.out.println("~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Initialization an empty deque collection.");

            GtuDeque<Integer> c = new GtuDeque<>();
            System.out.println("Size : " + c.size());
            System.out.println("Empty deque collection initialized.");
            System.out.println();

            System.out.println("~~Constructor-2-End~~");
            System.out.println();

            System.out.println("Constructor-Test-End");
            System.out.println("~~~~~~~~~~~~~~~~");

        }

        if( test_methods ) {
            System.out.println();
            System.out.println("Method-Testing");
            System.out.println("~~~~~~~~~~~~~~");

            System.out.println("For the purpose of illustrate the collection methods functionality , " +
                    "\ni used a simulation of purchasing a ticket.\n" +
                    "Each element of collection represent a unique identifier that belongs to person.");
            System.out.println();

            System.out.println("Initializing empty collection : ");
            GtuDeque<String> deque = new GtuDeque<>();
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println();

            System.out.println("- add(\"A1\") ");
            deque.add("A1");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- addFirst(\"A2\") ");
            deque.addFirst("A2");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- addLast(\"A3\") ");
            deque.addLast("A3");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- contains(\"A3\") ");
            System.out.println(deque.contains("A3"));
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- contains(\"A4\") ");
            System.out.println(deque.contains("A4"));
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- element() ");
            System.out.println( deque.element() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- clear() ");
            deque.clear();
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            try {
                System.out.println("- element() ");
                System.out.println( deque.element() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            System.out.println("- add(\"A2\") ");
            System.out.println("- add(\"A1\") ");
            System.out.println("- add(\"A3\") ");
            deque.add("A2");
            deque.add("A1");
            deque.add("A3");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- getFirst() ");
            System.out.println( deque.getFirst() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- clear() ");
            deque.clear();
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            try {
                System.out.println("- getFirst() ");
                System.out.println( deque.getFirst() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println("- getLast() ");
                System.out.println( deque.getLast() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            System.out.println("- offer(\"A2\") ");
            System.out.println("- offer(\"A1\") ");
            System.out.println("- offer(\"A3\") ");
            deque.offer("A2");
            deque.offer("A1");
            deque.offer("A3");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- offerFirst(\"A4\") ");
            deque.offerFirst("A4");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- offerLast(\"A5\") ");
            deque.offerLast("A5");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- peek() ");
            System.out.println( deque.peek() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- clear() ");
            deque.clear();
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- peek() ");
            System.out.println( deque.peek() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- peekFirst() ");
            System.out.println( deque.peekFirst() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- peekLast() ");
            System.out.println( deque.peekLast() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            try {
                System.out.println("- poll() ");
                System.out.println( deque.poll() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println("- pollFirst() ");
                System.out.println( deque.pollFirst() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println("- pollLast() ");
                System.out.println( deque.pollLast() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println("- pop() ");
                System.out.println( deque.pop() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println("- remove() ");
                System.out.println( deque.remove() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println("- removeFirst() ");
                System.out.println( deque.removeFirst() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println("- removeLast() ");
                System.out.println( deque.removeLast() );
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            System.out.println("- add(\"A1\") ");
            System.out.println("- add(\"A2\") ");
            System.out.println("- add(\"A3\") ");
            System.out.println("- add(\"B1\") ");
            System.out.println("- add(\"B2\") ");
            System.out.println("- add(\"B3\") ");
            deque.add("A1");
            deque.add("A2");
            deque.add("A3");
            deque.add("B1");
            deque.add("B2");
            deque.add("B3");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- peekFirst() ");
            System.out.println( deque.peekFirst() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- peekLast() ");
            System.out.println( deque.peekLast() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- poll() ");
            System.out.println( deque.poll() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- pollFirst() ");
            System.out.println( deque.pollFirst() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- pollLast() ");
            System.out.println( deque.pollLast() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- pop() ");
            System.out.println( deque.pop() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- push(\"C3\") ");
            System.out.println("- push(\"C2\") ");
            System.out.println("- push(\"C3\") ");
            System.out.println("- push(\"C1\") ");
            deque.push("C3");
            deque.push("C2");
            deque.push("C3");
            deque.push("C1");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- remove() ");
            System.out.println( deque.remove() );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- remove(\"C3\") ");
            System.out.println( deque.remove("C3") );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- remove(\"C7\") ");
            System.out.println( deque.remove("C7") );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- add(\"D1\") ");
            System.out.println("- add(\"D2\") ");
            System.out.println("- add(\"D3\") ");
            System.out.println("- add(\"D3\") ");
            System.out.println("- add(\"D2\") ");
            System.out.println("- add(\"D1\") ");
            deque.add("D1");
            deque.add("D2");
            deque.add("D3");
            deque.add("D3");
            deque.add("D2");
            deque.add("D1");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- removeFirstOccurrence(\"D1\") ");
            System.out.println( deque.removeFirstOccurrence("D1") );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- removeLastOccurrence(\"D2\") ");
            System.out.println( deque.removeLastOccurrence("D2") );
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("");
            System.out.println("Method-Testing-End");
            System.out.println("~~~~~~~~~~~~~~");
        }

        if( test_iterator ) {

            System.out.println();
            System.out.println("Iterator-Test");
            System.out.println("~~~~~~~~~~~~~~");
            System.out.println();

            System.out.println("Initializing empty deque collection.");
            GtuDeque<String> deque = new GtuDeque<>();
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();


            System.out.println("- iterator()");
            System.out.println("Iterator initialized");
            Iterator<String> iter = deque.iterator();
            System.out.println();

            System.out.println("- hasNext()");
            System.out.println(iter.hasNext());
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();


            try {
                System.out.println(" - next()");
                System.out.println(iter.next());
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println(" - remove()");
                iter.remove();
            }
            catch ( IllegalStateException exception ) {
                System.out.println("IllegalStateException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            System.out.println("- add(\"F1\") ");
            System.out.println("- add(\"F2\") ");
            System.out.println("- add(\"F3\") ");
            deque.add("F1");
            deque.add("F2");
            deque.add("F3");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- iterator()");
            System.out.println("Iterator initialized again");
            iter = deque.iterator();
            System.out.println();

            System.out.println("- hasNext()");
            System.out.println(iter.hasNext());
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            try {
                System.out.println(" - next()");
                System.out.println(iter.next());
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println(" - remove()");
                iter.remove();
            }
            catch ( IllegalStateException exception ) {
                System.out.println("IllegalStateException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            System.out.println("- clear() ");
            deque.clear();
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- descendingIterator()");
            System.out.println("Descending iterator initialized");
            Iterator<String> desIter = deque.descendingIterator();
            System.out.println();

            System.out.println("- hasNext()");
            System.out.println(desIter.hasNext());
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();


            try {
                System.out.println(" - next()");
                System.out.println(desIter.next());
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println(" - remove()");
                desIter.remove();
            }
            catch ( IllegalStateException exception ) {
                System.out.println("IllegalStateException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            System.out.println("- add(\"F1\") ");
            System.out.println("- add(\"F2\") ");
            System.out.println("- add(\"F3\") ");
            deque.add("F1");
            deque.add("F2");
            deque.add("F3");
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            System.out.println("- descendingIterator()");
            System.out.println("Descending iterator initialized again");
            desIter = deque.descendingIterator();
            System.out.println();

            System.out.println("- hasNext()");
            System.out.println(desIter.hasNext());
            System.out.println("Size  : " + deque.size());
            System.out.println("Deque : " + deque.toString());
            System.out.println("Garbage node number : " + deque.garbageListSize());
            System.out.println();

            try {
                System.out.println(" - next()");
                System.out.println(desIter.next());
            }
            catch ( NoSuchElementException exception ) {
                System.out.println("NoSuchElementException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            try {
                System.out.println(" - remove()");
                desIter.remove();
            }
            catch ( IllegalStateException exception ) {
                System.out.println("IllegalStateException was catched.");
            }
            finally {
                System.out.println("Size  : " + deque.size());
                System.out.println("Deque : " + deque.toString());
                System.out.println("Garbage node number : " + deque.garbageListSize());
                System.out.println();
            }

            System.out.println();
            System.out.println("Iterator-Test-End");
            System.out.println("~~~~~~~~~~~~~~");
        }
    }
}
