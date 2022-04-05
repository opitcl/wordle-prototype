import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Olivia Pitcl
 *
 * Implements a set backed by a Java array. Uses 
 * null objects and doubles the array size when it
 * gets exceeded. A potential issue is using removeAll
 * to empty an array instead if clear, which reduces
 * the size of the array back to 10.
 * 
 */


public class ArraySet<E> extends AbstractSet<E> {
	
	private Object[] myArray;
	private int size;
	
	public ArraySet() {
		this.myArray = new Object[10];
		this.size = 0;
		for (int i = 0; i < 10; i++) {
    		this.myArray[i] = null;
    	}
	}
	
	
    @Override
    /**
     * Adds an element to the set by adding it to the end of
     * our array. Doubles the size if needed.
     * 
     * @param E value, the value to add to the set
     * 
     * @return boolean, false if the array already contains
     * this value or if the value is null, true otherwise
     */
    public boolean add(E value) {
    	// Do not add if already in
    	if (this.contains(value)) {
    		return false;
    	}
    	// Do not add if null
    	if (value == null) {
    		return false;
    	}
    	
    	// Add otherwise by placing at end of list
    	// Double list size if we hit our maximum
    	if (this.size >= this.myArray.length) {
    		Object[] arr = new Object[this.myArray.length * 2];
    		// Replace the elements
    		for (int i = 0; i < this.size; i++) {
    			arr[i] = this.myArray[i];
    		}
    		for (int i = this.size; i < this.myArray.length * 2; i++) {
    			arr[i] = null;
    		}
    		this.myArray = arr.clone();
    	}
    	this.myArray[size] = value;
    	size += 1;
    	
    	return true;
    }
    
    @Override
    /**
     * Returns the size of the set.
     * 
     * @return int, size of set
     */
    public int size() {
    	return this.size;
    }
    
    @Override
    /**
     * Returns whether the set is empty based off of the size.
     * 
     * @return boolean, whether size is zero
     */
    public boolean isEmpty() {
    	return (this.size == 0);
    }
    
    @Override
    /**
     * Adds every element of a given collection to the set and
     * returns whether the set changes as a result.
     * 
     * @param Collection c, the collection with elements to add
     * 
     * @return boolean, whether the set was changed
     */
    public boolean addAll(Collection<? extends E> c) {
    	if (c.isEmpty()) {
    		return false;
    	}
    	boolean start = false;
    	for (E elem: c) {
    		// The set will be changed, return true
    		if (!this.contains(elem)) {
    			start = true;
    		}
    		// Add will also take care of duplicates
    		this.add(elem);
    	}
    	return start;
    }
    
    @Override
    /**
     * Empties the set by changing the array to null
     * elements of size 10.
     */
    public void clear() {
    	// Make a new empty one. Better to use this
    	// than removeAll, which does not change
    	// the size of the array
    	this.myArray = new Object[10];
    	for (int i = 0; i < 10; i++) {
    		this.myArray[i] = null;
    	}
    	this.size = 0;
    }
    
    @Override
    /**
     * Returns whether the set contains the given object.
     * 
     * @param Object o, the object to reference against all 
     * set elements
     * 
     * @return boolean, whether the object is in the set
     */
    public boolean contains(Object o) {
    	if (o == null) {
    		return false;
    	}
    	
    	// Not in if nothing is
    	if (this.isEmpty()) {
    		return false;
    	}
    	
    	// Find the object
    	for (int i = 0; i < this.size; i++) {
    		if (o.equals(this.myArray[i])) {
    			return true;
    		}
    	}
    	return false;
    }
    
    @Override
    /**
     * Returns whether the set contains every object in the given
     * collection.
     * 
     * @param Colection c, collection with elements to check to 
     * our set
     * 
     * @return boolean, whether all elements are within
     */
    public boolean containsAll(Collection<?> c) {
    	// If any element is not in our set, return false
    	Iterator i = c.iterator();
    	while (i.hasNext()) {
    		if (!this.contains(i.next())) {
    			return false;
    		}
    	}
    	return true;
    }
    

    @Override
    /**
     * Returns whether the given object is equal to the set
     * by a) ensuring it is a set and b) ensuring the two share
     * the same elements.
     * 
     * @param Object o, a potential set to compare to this set
     * 
     * @return boolean, whether they are equal as described above
     */
    public boolean equals(Object o) {
    	// Must be a Set at the very least
    	if (o instanceof Set) {
    		// Cast
    		Set<E> other = (Set<E>) o;
    		// Good preliminary
    		if (other.size() != this.size) {
    			return false;
    		}
    		
    		for (E elem : other) {
    			if (!this.contains(elem)) {
    				return false;
    			}
    		}
    		return true;
    	}
    	return false;
    }
    

    @Override
    /**
     * Given an object to take out, removes that object and
     * returns whether any change occurred.
     * 
     * @param Object o, the object to remove (note that type
     * comparison is not possible)
     * 
     * @return boolean, whether the set changed
     */
    public boolean remove(Object o) {
    	if (o == null) {
    		return false;
    	}
    	if (!this.contains(o)) {
    		return false;
    	}
    	int j = 0;
    	boolean found = false;
    	for (int i = 0; i < this.size; i++) {
    		if (this.myArray[i].equals(o)) {
    			j = i;
    			found = true;
    		} else if (found) {
    			this.myArray[j] = this.myArray[i];
    		}
    	}
    	this.myArray[size - 1] = null;
    	this.size -= 1;
    	return true;
    }


    @Override
    /**
     * Removes all elements in a given collection.
     * 
     * @param Collection c, the collection whose elements
     * must be removed
     * 
     * @return boolean, whether the set changed
     */
    public boolean removeAll(Collection<?> c) {
    	Iterator i = c.iterator();
    	boolean change = false;
    	
    	while (i.hasNext()) {
    		Object o = i.next();
    		if (this.contains(o)) {
    			this.remove(o);
    			change = true;
    		}
    	}
    	return change;
    }

    @Override
    /**
     * Keeps all elements from a given collection, much like a symmetric
     * difference.
     * 
     * @param Collection c, the collection whose elements must be kept if
     * in the current set
     * 
     * @return boolean, whether the set was changed
     */
    public boolean retainAll(Collection<?> c) {
    	ArraySetIterator i = (ArraySet<E>.ArraySetIterator<E>) this.iterator();
    	boolean change = false;
    	
    	while (i.hasNext()) {
    		Object o = i.next();
    		if (!c.contains(o)) {
    			i.remove();
    			change = true;
    		}
    	}
    	return change;
    }
    
    @Override
    /**
     * Gives array which backs the current set. Contains
     * null objects.
     * 
     * @return Object[], array behind this set
     */
    public Object[] toArray() {
    	return this.myArray;
    }
    
    @Override
    /**
     * Gives the iterator specific to this class (ArraySetIterator).
     * 
     * @return ArraySetIterator, iterator for getting
     * the elements in the set
     */
    public Iterator<E> iterator() {
    	return new ArraySetIterator<E>();
    }
    
    /**
     * @author Olivia Pitcl
     *
     * ArraySetIterator class which allows us to access and
     * step through the elements in this set implementation.
     * 
     */
    private class ArraySetIterator<T> implements Iterator<T> {
    	
    	// represents the current index in the array
    	private int cur;
    	private boolean ready;
    	
    	public ArraySetIterator() {
    		cur = -1;
    		ready = false;
    	}
    	
        @Override
        /**
         * Notes whether another element exists in the set.
         * 
         * @return boolean, whether the set's next element is
         * null
         */
        public boolean hasNext() {
        	return (ArraySet.this.myArray[cur + 1] != null);
        }
        
        @Override
        /**
         * Returns the next element in the set, whether null or not.
         * 
         * @return next element in set
         */
        public T next() {
        	cur += 1;
        	ready = true;
        	return (T) ArraySet.this.myArray[cur];
        }

        @Override
        /**
         * Removes the object the iterator is currently
         * "placed" on. Can only occur after one call of
         * next.
         */
        public void remove() throws IllegalStateException {
        	if (ready) {
        		ArraySet.this.remove(myArray[cur]);
        		ready = false;
            	cur -= 1;
        	} else {
        		throw new IllegalStateException();
        	}
        }
    }
}