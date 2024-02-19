// --== CS400 Project One HashtableMap.java ==--
// Name: <Kevin Zeng>
// CSL Username: <kzeng>
// Email: <kzeng9@wisc.edu>
// Lecture #: <003 @2:25pm>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashtableMap<KeyType, ValueType> implements IterableMapADT<KeyType, ValueType> {
    private int capacity;
    private int size;
    protected LinkedList<Entry<KeyType, ValueType>>[] hashtable;

    /**
     * Constructor for HashtableMap
     *
     * @param capacity   the initial capacity of the map
     * @param loadFactor the load factor of the map
     */
    @SuppressWarnings("unchecked")
    public HashtableMap(int capacity) {
        this.capacity = capacity;
        hashtable = (LinkedList<Entry<KeyType, ValueType>>[]) new LinkedList[this.capacity];
    }

    /**
     * Constructor for HashtableMap
     *
     * @param capacity   the initial capacity of the map
     * @param loadFactor the load factor of the map
     */
    @SuppressWarnings("unchecked")
    public HashtableMap() {
        this.capacity = 15;
        hashtable = (LinkedList<Entry<KeyType, ValueType>>[]) new LinkedList[this.capacity];
    }

    /**
     * Inserts a new (key, value) pair into the map if the map does not
     * contain a value mapped to key yet.
     *
     * @param key   the key of the (key, value) pair to store
     * @param value the value that the key will map to
     * @return true if the (key, value) pair was inserted into the map,
     *         false if a mapping for key already exists and the
     *         new (key, value) pair could not be inserted
     */
    public boolean put(KeyType key, ValueType value) {
        // check the validity of key
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        Entry<KeyType, ValueType> entry = new Entry<KeyType, ValueType>(key, value);
        // check for collision
        int index = Math.abs(key.hashCode()) % capacity;
        if (hashtable[index] == null) {
            LinkedList<Entry<KeyType, ValueType>> list = new LinkedList<Entry<KeyType, ValueType>>();
            list.add(entry);
            hashtable[index] = list;
            size++;
            rehash();
            return true;
        } else {
            // check if key already exists
            LinkedList<Entry<KeyType, ValueType>> list = hashtable[index];
            int count = 0;
            while (count < list.size()) {
                if (list.get(count).getKey().equals(key))
                    return false;
                count++;
            }
            list.add(entry);
            size++;
            rehash();
            return true;
        }
    }

    /**
     * A private helper method that rehashes the map when the load factor is
     * reached.
     *
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        // double the capacity
        if (size / (double) capacity >= 0.70) {
            LinkedList<Entry<KeyType, ValueType>>[] temp = (LinkedList<Entry<KeyType, ValueType>>[]) new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                temp[i] = hashtable[i];
            }
            capacity = capacity * 2;
            size = 0;
            hashtable = (LinkedList<Entry<KeyType, ValueType>>[]) new LinkedList[capacity];
            // rehash the map
            for (LinkedList<Entry<KeyType, ValueType>> n : temp) {
                int i = 0;
                while (n != null && i < n.size()) {
                    put(n.get(i).getKey(), n.get(i).getValue());
                    i++;
                }
            }
        }
    }

    /**
     * A private helper method to bind the key to an index in the map.
     *
     * @param key   the key to be bound
     * @param value the value to be bound
     * @return the index of the key and value
     *
     */
    class Entry<KeyType, ValueType> {
        private KeyType key;
        private ValueType value;

        public Entry(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
        }

        public ValueType getValue() {
            return value;
        }

        public KeyType getKey() {
            return key;
        }
    }

    /**
     * Returns the value mapped to a key if the map contains such a mapping.
     *
     * @param key the key for which to look up the value
     * @return the value mapped to the key
     * @throws NoSuchElementException if the map does not contain a mapping
     *                                for the key
     */
    public ValueType get(KeyType key) throws NoSuchElementException {
                int index = key.hashCode() % capacity;
                if(index < 0) {
                  index *= -1;
                }
                LinkedList<Entry<KeyType, ValueType>> result = hashtable[index];
                //throw NoSuchElementException if the index is empty
                if (result == null)
                        throw new NoSuchElementException();
                // get the value of the key
                int i = 0;
                while (i < result.size()) {
                        if (result.get(i).getKey() == key)
                                return result.get(i).getValue();
                        i++;
                }
                //throw NoSuchElementException if the key is not found
                throw new NoSuchElementException();
    }

    /**
     * Removes a key and its value from the map.
     *
     * @param key the key for the (key, value) pair to remove
     * @return the value for the (key, value) pair that was removed,
     *         or null if the map did not contain a mapping for key
     */
    public ValueType remove(KeyType key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (!containsKey(key)) {
            return null;
        }
        int index = Math.abs(key.hashCode()) % capacity;
        // remove the entry from the linked list
        for (Entry<KeyType, ValueType> entry : hashtable[index]) {
            if (entry.getKey().equals(key)) {
                ValueType value = entry.getValue();
                hashtable[index].remove(entry);
                size--;
                return value;
            }
        }
        return null;
    }

    /**
     * Checks if a key is stored in the map.
     *
     * @param key the key to check for
     * @return true if the key is stored (mapped to a value) by the map
     *         and false otherwise
     */
    public boolean containsKey(KeyType key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int index = Math.abs(key.hashCode()) % capacity;
        if (hashtable[index] == null) {
            return false;
        }
        for (Entry<KeyType, ValueType> entry : hashtable[index]) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of (key, value) pairs stored in the map.
     *
     * @return the number of (key, value) pairs stored in the map
     */
    public int size() {
        return size;
    }

    /**
     * Removes all (key, value) pairs from the map.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        size = 0;
        hashtable = new LinkedList[capacity];
    }

    /**
     * create an iterator for the map
     * @return an iterator for the map
     *
     */
    public java.util.Iterator<ValueType> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements java.util.Iterator<ValueType> {
        private int index;
        private int count;
        private LinkedList<Entry<KeyType, ValueType>> list;

        // constructor
        public MyIterator() {
            index = 0;
            count = 0;
            if(hashtable[index]!= null) {
            list = new LinkedList<Entry<KeyType, ValueType>>(hashtable[index]);
            }
            System.out.println("size : " + size);
        }

        // check if there is a next element
        public boolean hasNext() {
            if (count < size) {
                return true;
            }
            return false;
        }

        // return the next element
        public ValueType next() {
            // if the list is empty, move to the next list       
            while (list == null || list.size() == 0) {
                index++;
                //System.out.println(index);
                //System.out.println("table length = " + hashtable.length);
                //System.out.println(index == hashtable.length);
                if(index == hashtable.length) {
                  count = size;
                  return null;
                }
                if(hashtable[index]!=null) {
                list = new LinkedList<Entry<KeyType, ValueType>>(hashtable[index]);
                }
            }
            
            // get the value of the entry
            ValueType value = list.get(0).getValue();
            list.remove(0);
            count++;
            return value;
        }
    }
}
