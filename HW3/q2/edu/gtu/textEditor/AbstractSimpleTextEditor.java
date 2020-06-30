package edu.gtu.textEditor;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

/**
 * <tt>Simple text-editor class that can carry out tasks on text that is formed
 * from the given file.</tt>
 */
public class AbstractSimpleTextEditor {

    /**
     * <tt>Java legacy utility collection that keeps
     * the file content in it. </tt>
     */
    private List<Character> characterStream;

    /**
     * <tt>To generate concrete class with constructor.</tt>
     * @param concreteList <tt>Actual concrete class collection reference.</tt>
     */
    protected AbstractSimpleTextEditor( List<Character> concreteList ) {
        characterStream = concreteList;
    }

    /**
     * <tt>Read the file by given path.</tt>
     * @param filepath <tt>Path that includes file.</tt>
     */
    public void read( final String filepath ) {

        characterStream.clear();

        try
        {
            File file = new File(filepath);
            if( !file.canRead() || !file.canWrite() ) {
                throw new Exception();
            }

            FileReader fr = new FileReader(file);
            BufferedReader textReader = new BufferedReader(fr);

            for( int c = 0 ; ( (c = textReader.read()) != -1 ) ; ) {
                characterStream.add( (char)c );
            }

            textReader.close();
        }
        catch ( Exception exceptionPacket ) {
            System.out.println("Error , file could not be read");
        }

    }

    /**
     * <tt>Same effect with read method.</tt>
     * <tt>Internal implementation based on list-iterator.</tt>
     * @param filepath <tt>Path that includes file.</tt>
     */
    public void readWithIterator( final String filepath ) {

        characterStream.clear();

        try
        {
            File file = new File(filepath);
            if( !file.canRead() || !file.canWrite() ) {
                throw new Exception();
            }

            FileReader fr = new FileReader(file);
            BufferedReader textReader = new BufferedReader(fr);

            ListIterator<Character> iter = characterStream.listIterator();

            for( int c = 0 ; ( (c = textReader.read()) != -1 ) ;  ) {
                iter.add( (char)c );
            }

            textReader.close();
        }
        catch ( Exception exceptionPacket ) {
            System.out.println("Error , file could not be read");
        }
    }

    /**
     * <<tt> Add a string at given index </tt>
     * @param index  <tt> Index that is point given index </tt>
     * @param givenString <tt> String that will be inserted to internal text </tt>
     * @throws IndexOutOfBoundsException -
     */
    public void add( int index , final String givenString ) {

        for( int i = givenString.length() - 1 ; i >= 0   ; --i ) {
            characterStream.add( index , givenString.charAt( i ));
        }
    }

    /**
     * <tt>Same effect with add method.</tt>
     * <<tt> Internal implementation based on list-iterator .</tt>
     * @param index  <tt> Index that is point given index </tt>
     * @param givenString <tt> String that will be inserted to internal text </tt>
     * @throws IndexOutOfBoundsException -
     */
    public void addWithIterator( int index , final String givenString ) {

        ListIterator<Character> iter = characterStream.listIterator(index);

        for( int i = 0 ; i < givenString.length() ; ++i ) {
            iter.add( givenString.charAt( i ) );
        }
    }

    /**
     * <tt>Find the given string through internal text.</tt>
     * @param searchedGroup <tt>Searched group of character as string.</tt>
     * @return <tt>If success , first occurrence index , If not , -1.</tt>
     */
    public int find( final String searchedGroup ) {

        for( int i = 0 , counter = 0 ; i < characterStream.size() ; ++i ) {
            for( int j = 0 ; j < searchedGroup.length() ;  ++j ) {
                if( characterStream.get(i) == searchedGroup.charAt(j) ) {
                    ++i;
                    ++counter;
                }
                if( counter == searchedGroup.length() ) {
                    return i - counter;
                }
            }
            i -= counter;
            counter = 0;
        }

        return -1;
    }

    /**
     * <tt>Same effect with find method.</tt>
     * <tt>Internal implementation based on list-iterator</tt>
     * @param searchedGroup <tt>Searched group of character as string.</tt>
     * @return <tt>If success , first occurrence index , If not , -1.</tt>
     */
    public int findWithIterator( final String searchedGroup ) {

        int index = -1;
        ListIterator<Character> iter = characterStream.listIterator();

        for( int counter = 0 ; iter.hasNext()  ; ) {
            for( int j = 0 ; j < searchedGroup.length() ;  ++j ) {
                if( iter.hasNext() && iter.next() == searchedGroup.charAt(j) ) {
                    if( j == 0 ) {
                        index = iter.previousIndex();
                    }
                    ++counter;
                }
                if( counter == searchedGroup.length() ) {
                    return index;
                }
            }
            iter = characterStream.listIterator(++index);
            counter = 0;
        }
        index = -1;

        return index;
    }

    /**
     * <tt>Replace the all given character as prev with given as next </tt>
     * @param prev Character that will be replaced with new one.
     * @param next Character that will be taken part as new.
     */
    public void replace( Character prev , Character next ) {

        for( int i = 0 ; i < characterStream.size()  ; ++i ) {
            if( characterStream.get( i ) == prev ) {
                characterStream.set( i , next );
            }
        }
    }

    /**
     * <tt>Same effect with replace method.</tt>
     * <tt>Internal implementation based on list-iterator</tt>
     * @param prev Character that will be replaced with new one.
     * @param next Character that will be taken part as new.
     */
    public void replaceWithIterator( Character prev , Character next  ) {

        ListIterator<Character> iter = characterStream.listIterator();
        for( ; iter.hasNext() ; ) {
            if( iter.next() == prev ) {
                iter.set(next);
            }
        }
    }

    /**
     * <tt>Size of internal text.</tt>
     * @return <tt>Size as an int.</tt>
     */
    public int size() {
        return characterStream.size();
    }

    /**
     * String representation of inner text.
     * @return <tt>Inner text as String</tt>
     */
    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        ListIterator<Character> iter = characterStream.listIterator();
        for( ; iter.hasNext() ;) {
            string.append(iter.next());
        }

        return string.toString();
    }

    /**
     * Check whether inner texts are equals.
     * @param obj Object
     * @return If equals true , otherwise false.
     */
    @Override
    public boolean equals(Object obj) {

        if( obj == this )
            return true;

        if( !(obj instanceof AbstractSimpleTextEditor) )
            return false;

        return ((AbstractSimpleTextEditor) obj).characterStream.equals(characterStream);

    }

}
