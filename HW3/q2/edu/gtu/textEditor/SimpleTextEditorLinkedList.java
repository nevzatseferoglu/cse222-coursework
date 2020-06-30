package edu.gtu.textEditor;
import java.util.LinkedList;

/**
 * <tt>Concrete version of abstract AbstractSimpleTextEditor class.</tt>
 * <tt>File content has been kept in java.util LinkedList collection.</tt>
 * @see AbstractSimpleTextEditor
 * @see LinkedList
 */
public class SimpleTextEditorLinkedList extends AbstractSimpleTextEditor {

    /**
     * <tt>Collection itself.</tt>
     */
    private static LinkedList<Character> actualList = new LinkedList<>();

    /**
     * <tt>No parameter constructor.</tt>
     */
    public  SimpleTextEditorLinkedList() {
        super(actualList);
    }

}