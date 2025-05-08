// Do not change the line below. It lets Gradle find your 
// Classes to build the project

package a1template;

public class DynamicArray<T> implements IndexAccess<T> {
    
    // The underlying array storage
    private T[] arr;
    // The default offset used when calling get(int)
    private int defaultOffset;
    
    /** Constructor to create a new DynamicArray object from an array.
     * @param offset default offset for index operations
     * @param array the underlying array to store
     */
    public DynamicArray(int offset, T[] array) {
         this.defaultOffset = offset;
         this.arr = array;
    }
    
    /** Helper method to adjust the index using a given offset.
     * It wraps around using modulo arithmetic.
     */
    private int adjustIndex(int i, int offset) {
         int len = arr.length;
         int index = (i + offset) % len;
         if (index < 0) {
             index += len;
         }
         return index;
    }
    
    /** Returns the value stored at a given index adjusted by the default offset.
     * @param i index of element to read
     * @return value stored at the given index
     */
    public T get(int i) {
         return arr[adjustIndex(i, this.defaultOffset)];
    }
    
    /** Returns the value stored at a given index adjusted by the provided offset.
     * @param i index of element to read
     * @param offset adjust index by this value
     * @return value stored at the given index
     */
    public T get(int i, int offset) {
         return arr[adjustIndex(i, offset)];
    }
    
    /** Stores the given value at the given index (using the default offset).
     * @param i index of location to store
     * @param val value to store at given index
     */
    public void set(int i, T val) {
         arr[adjustIndex(i, this.defaultOffset)] = val;
    }
}
