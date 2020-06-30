package edu.gtu.HashTable;

/**
 * Hashtable implementation with chaining technique.
 * @param <K> Key
 * @param <V> Value
 */
public class HashtableChain<K extends Comparable<K>,V> implements KWHashMap<K,V>{


    private BinarySearchTree< Entry<K,V> >[] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key value pairs for a hash table. */
    private static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {

        /** The key */
        private final K key;

        /** The value
         */
        private V value;

        /** Creates a new key value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        @Override
        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override
        public int compareTo(Entry<K, V> kvEntry) {
            return this.getKey().compareTo(kvEntry.getKey());
        }
    }

    /**
     * Rehash the given tree structure with creating new tree.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        // Save a reference to oldTable.

         BinarySearchTree<Entry<K, V>>[] oldTable = table;

        // Double capacity of this table.
        table = new BinarySearchTree[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;

        for (int i = 0; i < oldTable.length; i++) {

            while ( oldTable[i] != null && oldTable[i] .root != null ) {

                K key = oldTable[i].getData().getKey();
                V value = oldTable[i].getData().getValue();

                put(key, value);
                oldTable[i].delete( oldTable[i].getData() );

            }
        }
    }


    /**
     * Constructor
     */
    // Constructor
    @SuppressWarnings("unchecked")
    public HashtableChain() {
        table = new BinarySearchTree[CAPACITY];

    }

    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {

        int index = key.hashCode() % table.length;

        if (index < 0)
            index += table.length;

        if (table[index] == null)
            return null;

        Entry<K,V> returnedEntryOfKey = table[index].find(new Entry<K,V>( key,null));

        if( returnedEntryOfKey != null ) {
            return returnedEntryOfKey.getValue();
        }
        return null;
    }

    /**
     * Check whether it is empty
     * @return true if it is empty otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /** Method put for class HashtableChain.
      This key value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {

        int index = key.hashCode() % table.length;

        if (index < 0)
            index += table.length;

        if (table[index] == null) {
            table[index] = new BinarySearchTree<>();
        }

        Entry<K,V> returnedEntryOfKey = new Entry<>( key , value );
        returnedEntryOfKey = table[index].find( returnedEntryOfKey);

        if( returnedEntryOfKey != null ) {
            V oldVal = returnedEntryOfKey.getValue();
            returnedEntryOfKey.setValue(value);
            return oldVal;
        }
        table[index].add(new Entry<>(key, value));
        numKeys++;

        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            rehash();
        }

        return null;
    }

    /**
     * Remove the given key from the hashtable
     * @param key key
     * @return if key does exist , return it otherwise return false.
     */
    @SuppressWarnings("unchecked")
    @Override
    public V remove(K key) {
        int index = key.hashCode() % table.length;

        if( index < 0 ) {
            index += table.length;
        }

        if( table[index] == null ) {
            return null;
        }

        Entry<K,V> removedKeyOfEntry = new Entry<>(key , null);
        removedKeyOfEntry = table[index].find( removedKeyOfEntry);

        if( removedKeyOfEntry != null ) {

            Entry<K,V> entry = table[index].delete(removedKeyOfEntry);
            --numKeys;

            return entry.getValue();

        } else {
            return null;
        }

    }

    /**
     * Size of the hashtable
     * @return size
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * String representation of hashtable
     * @return string
     */
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        int counter = 0;

        str.append("{");
        for( int i = 0 ; i < table.length ; ++i ) {
            if ( table[i] != null ) {

                if( counter < numKeys - 1 ) {
                    str.append( table[i].toString()).append(", ");
                } else {
                    str.append( table[i].toString());
                }

                ++counter;
            }
        }
        str.append("}");

        return str.toString();
    }
}
