package edu.gtu.textEditor;
import java.util.ArrayList;

/**
 * <tt>Concrete version of abstract AbstractSimpleTextEditor class.</tt>
 * <tt>File content has been kept in java.util ArrayList collection.</tt>
 * @see AbstractSimpleTextEditor
 * @see ArrayList
 */
public class SimpleTextEditorArrayList extends AbstractSimpleTextEditor {

    /**
     * <tt>Collection itself.</tt>
     */
    private static ArrayList<Character> actualList = new ArrayList<>();

    /**
     * <tt>No parameter constructor.</tt>
     */
    public  SimpleTextEditorArrayList() {
        super(actualList);
    }

}
