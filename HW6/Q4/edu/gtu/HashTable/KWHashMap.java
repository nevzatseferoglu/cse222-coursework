package edu.gtu.HashTable;

/**
 * KW hashMap interface
 * @param <K> key
 * @param <V> value
 */
public interface KWHashMap<K,V> {

    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    V get( K key );

    /**
     * Check whether it is empty
     * @return true if it is empty otherwise return false
     */
    boolean isEmpty();

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
    V put(K key , V value);

    /**
     * Remove the given key from the hashtable
     * @param key key
     * @return if key does exist , return it otherwise return false.
     */
    V remove(K key);

    /**
     * Size of the hashtable
     * @return size
     */
    int size();

}
