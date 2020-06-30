import edu.gtu.textEditor.SimpleTextEditorArrayList;
import edu.gtu.textEditor.SimpleTextEditorLinkedList;

import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    /**
     * Calculate the elapsed-time for each given test cases.
     */
    public static class Test {

        private int fileSize;
        private long startTime;
        private long endTime;
        private String filepath;

        public Test( String filepath ) {
            this.filepath = filepath;

            LinkedListTest();
            ArrayListTest();
        }

        /* Keeps the elapsed-time for each method in LinkedListSimpleTextEditor */
        private long readTimeLinkedList;
        private long readWithIteratorLinkedList;

        private long addTimeLinkedList;
        private long addWithIteratorLinkedList;

        private long findTimeLinkedList;
        private long findWithIteratorLinkedList;

        private long replaceTimeLinkedList;
        private long replaceIteratorLinkedList;
        /*End*/

        /* Keeps the elapsed-time for each method in ArrayListSimpleTextEditor */
        private long readTimeArrayList;
        private long readWithIteratorArrayList;

        private long addTimeArrayList;
        private long addWithIteratorArrayList;

        private long findTimeArrayList;
        private long findWithIteratorArrayList;

        private long replaceTimeArrayList;
        private long replaceIteratorArrayList;
        /*End*/

        private void LinkedListTest( ) {

             System.out.println("Simple Text Editor LinkedList Implementation Testing");
             System.out.println("~~~~~~~~~~~~~~~~~"+filepath+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

             System.out.println("-Initializing editor");
             SimpleTextEditorLinkedList editor = new SimpleTextEditorLinkedList();

             startTime = System.nanoTime();
             System.out.println("-read( " +filepath+ " )");
             editor.read(filepath);
             fileSize = editor.size();
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             readTimeLinkedList = (endTime - startTime);

             startTime = System.nanoTime();
             System.out.println("-readWithIterator( " +filepath+ " )");
             editor.readWithIterator(filepath);
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             readWithIteratorLinkedList = (endTime - startTime);

             startTime = System.nanoTime();
             System.out.println("-add( 5,\"GTU\" )");
             editor.add(5,"GTU");
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             addTimeLinkedList = (endTime - startTime);

             startTime = System.nanoTime();
             System.out.println("-addWithIterator( 18,\"CSE\" )");
             editor.addWithIterator(18,"CSE");
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             addWithIteratorLinkedList = (endTime - startTime);

             startTime = System.nanoTime();
             System.out.println("-find( \"GTU\" )");
             System.out.println(editor.find("GTU"));
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             findTimeLinkedList = (endTime - startTime);

             startTime = System.nanoTime();
             System.out.println("-findWithIterator( \"CSE\" )");
             System.out.println(editor.findWithIterator("CSE"));
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             findWithIteratorLinkedList = (endTime - startTime);

             startTime = System.nanoTime();
             System.out.println("- replace() , replacing all number character with '_' ");
             for( char i = '1' ; i <= '9' ; ++i ){
                 editor.replace(i , '_');
             }
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             replaceTimeLinkedList = (endTime - startTime);

             startTime = System.nanoTime();
             System.out.println("- replaceWithIterator() , replacing all occurrence of '_' with '*' ");
             editor.replaceWithIterator('_' , '*');
             System.out.println("==="+filepath+"===");
             System.out.println( editor );
             System.out.println("Size of text : " + editor.size());
             System.out.println("~~~~~\n");
             endTime = System.nanoTime();
             replaceIteratorLinkedList = (endTime - startTime);

             System.out.println("========END-LinkedList=========\n");

         }
        private void ArrayListTest( ) {
            System.out.println("Simple Text Editor ArrayList Implementation Testing");
            System.out.println("~~~~~~~~~~~~~~~~~"+filepath+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

            System.out.println("-Initializing editor");
            SimpleTextEditorArrayList editor = new SimpleTextEditorArrayList();

            startTime = System.nanoTime();
            System.out.println("-read( " +filepath+ " )");
            editor.read(filepath);
            fileSize = editor.size();
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            readTimeArrayList = (endTime - startTime);

            startTime = System.nanoTime();
            System.out.println("-readWithIterator( " +filepath+ " )");
            editor.readWithIterator(filepath);
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            readWithIteratorArrayList = (endTime - startTime);

            startTime = System.nanoTime();
            System.out.println("-add( 5,\"GTU\" )");
            editor.add(5,"GTU");
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            addTimeArrayList = (endTime - startTime);

            startTime = System.nanoTime();
            System.out.println("-addWithIterator( 18,\"CSE\" )");
            editor.addWithIterator(18,"CSE");
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            addWithIteratorArrayList = (endTime - startTime);

            startTime = System.nanoTime();
            System.out.println("-find( \"GTU\" )");
            System.out.println(editor.find("GTU"));
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            findTimeArrayList = (endTime - startTime);

            startTime = System.nanoTime();
            System.out.println("-findWithIterator( \"CSE\" )");
            System.out.println(editor.findWithIterator("CSE"));
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            findWithIteratorArrayList = (endTime - startTime);

            startTime = System.nanoTime();
            System.out.println("- replace() , replacing all number character with '_' ");
            for( char i = '1' ; i <= '9' ; ++i ){
                editor.replace(i , '_');
            }
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            replaceTimeArrayList = (endTime - startTime);

            startTime = System.nanoTime();
            System.out.println("- replaceWithIterator() , replacing all occurrence of '_' with '*' ");
            editor.replaceWithIterator('_' , '*');
            System.out.println("==="+filepath+"===");
            System.out.println( editor );
            System.out.println("Size of text : " + editor.size());
            System.out.println("~~~~~\n");
            endTime = System.nanoTime();
            replaceIteratorArrayList = (endTime - startTime);

            System.out.println("========END-ArrayList=========\n");
        }

        public long getAddTimeArrayList() {
            return addTimeArrayList;
        }
        public long getAddTimeLinkedList() {
            return addTimeLinkedList;
        }

        public long getAddWithIteratorArrayList() {
            return addWithIteratorArrayList;
        }
        public long getAddWithIteratorLinkedList() {
            return addWithIteratorLinkedList;
        }

        public long getReadTimeArrayList() {
            return readTimeArrayList;
        }
        public long getReadTimeLinkedList() {
            return readTimeLinkedList;
        }

        public long getReadWithIteratorArrayList() {
            return readWithIteratorArrayList;
        }
        public long getReadWithIteratorLinkedList() {
            return readWithIteratorLinkedList;
        }

        public long getFindTimeArrayList() {
            return findTimeArrayList;
        }
        public long getFindTimeLinkedList() {
            return findTimeLinkedList;
        }

        public long getFindWithIteratorArrayList() {
            return findWithIteratorArrayList;
        }
        public long getFindWithIteratorLinkedList() {
            return findWithIteratorLinkedList;
        }

        public long getReplaceTimeArrayList() {
            return replaceTimeArrayList;
        }
        public long getReplaceTimeLinkedList() {
            return replaceTimeLinkedList;
        }

        public long getReplaceIteratorLinkedList() {
            return replaceIteratorLinkedList;
        }
        public long getReplaceIteratorArrayList() {
            return replaceIteratorArrayList;
        }

        @Override
        public String toString() {
            String ArrayListOutput = "";
            String LinkedListOutput = "";

            ArrayListOutput += "\nArrayList-Result" + "File Size : " + fileSize + "\n";
            ArrayListOutput += "===============================\n";

            ArrayListOutput += "Read-Time            :" + readTimeArrayList + "ns" + "\t\t";
            ArrayListOutput += "ReadWithIterator-Time:" + "\t\t" + readWithIteratorArrayList + "ns" + "\n\n";

            ArrayListOutput += "Add-Time             :" + addTimeArrayList + "ns" + "\t\t";
            ArrayListOutput += "AddWithIterator-Time :" + "\t\t" + addWithIteratorArrayList + "ns" + "\n\n";

            ArrayListOutput += "Find-Time            :" + findTimeArrayList + "ns" + "\t\t";
            ArrayListOutput += "FindWithIterator-Time:" + "\t\t" + findTimeArrayList + "ns" + "\n\n";

            ArrayListOutput += "Find-Time            :" + findTimeArrayList+ "ns" + "\t\t";
            ArrayListOutput += "FindWithIterator-Time:" + "\t\t" + findWithIteratorArrayList + "ns" + "\n\n";

            ArrayListOutput += "Replace-Time         :" + replaceTimeArrayList + "ns" + "\t\t";
            ArrayListOutput += "ReplaceWithIterator-Time:   " + replaceIteratorArrayList + "ns" + "\n\n";
            ArrayListOutput += "=========================================================================\n";


            /*---------------------------------------------------------------------------*/

            LinkedListOutput += "\nLinkedList-Result" + "File Size : " + fileSize + "\n";
            LinkedListOutput += "===============================\n";

            LinkedListOutput += "Read-Time            :" + readTimeLinkedList + "ns" + "\t\t";
            LinkedListOutput += "ReadWithIterator-Time:" + "\t\t" + readWithIteratorLinkedList + "ns" + "\n\n";

            LinkedListOutput += "Add-Time             :" + addTimeLinkedList + "ns" + "\t\t";
            LinkedListOutput += "AddWithIterator-Time :" + "\t\t" + addWithIteratorLinkedList + "ns" + "\n\n";

            LinkedListOutput += "Find-Time            :" + findTimeLinkedList + "ns" + "\t\t";
            LinkedListOutput += "FindWithIterator-Time:" + "\t\t" + findTimeLinkedList + "ns" + "\n\n";

            LinkedListOutput += "Find-Time            :" + findTimeLinkedList+ "ns" + "\t\t";
            LinkedListOutput += "FindWithIterator-Time:" + "\t\t" + findWithIteratorLinkedList + "ns" + "\n\n";

            LinkedListOutput += "Replace-Time         :" + replaceTimeLinkedList + "ns" + "\t\t";
            LinkedListOutput += "ReplaceWithIterator-Time:   " + replaceIteratorLinkedList + "ns" + "\n\n";
            LinkedListOutput += "=========================================================================\n";

            return "Timing Analyze : \n" + LinkedListOutput + "\n" + ArrayListOutput + "\n" + "END-OF-" + filepath + "\n";
        }
    }


    public static void main( String[] argv ) {

        try {

            Logger logger = Logger.getLogger("logfile");
            FileHandler fh = new FileHandler("logfile.log");
            logger.addHandler(fh);

            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            Test test1 = new Test("test_1.txt");
            Test test2 = new Test("test_2.txt");

            FileWriter fw = new FileWriter("experimentalTime.txt");
            fw.write(test1.toString() + test2.toString());
            logger.info(test1.toString() + test2.toString());
            fw.close();

        }
        catch (Exception exceptionPacket) {
            exceptionPacket.printStackTrace();
        }
    }
}
