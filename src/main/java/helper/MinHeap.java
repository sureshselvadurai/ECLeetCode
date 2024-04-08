package helper;

public class MinHeap {
    private int[] heap; // the array to store the heap
    private int maxsize; // the size of the array
    private int size; // the current number of elements in the array

    /**
     * Constructor for the min heap
     * @param max the maximum size of the heap
     */
    public MinHeap(int max) {
        maxsize = max;
        heap = new int[maxsize];
        size = 0;
        heap[0] = Integer.MIN_VALUE;
        // Note: no actual data is stored at heap[0].
        // Assigned MIN_VALUE so that it's easier to bubble up
    }

    /** Return the index of the left child of the element at index pos
     *
     * @param pos the index of the element in the heap array
     * @return the index of the left child
     */
    private int leftChild(int pos) {
        return 2 * pos;
    }

    /** Return the index of the right child
     *
     * @param pos the index of the element in the heap array
     * @return the index of the right child
     */
    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    /** Return the index of the parent
     *
     * @param pos the index of the element in the heap array
     * @return the index of the parent
     */
    private int parent(int pos) {
        return pos / 2;
    }

    /** Returns true if the node in a given position is a leaf
     *
     * @param pos the index of the element in the heap array
     * @return true if the node is a leaf, false otherwise
     */
    private boolean isLeaf(int pos) {
        return ((pos > size / 2) && (pos <= size));
    }

    /** Swap given elements: one at index pos1, another at index pos2
     *
     * @param pos1 the index of the first element in the heap
     * @param pos2 the index of the second element in the heap
     */
    private void swap(int pos1, int pos2) {
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    /** Insert an element into the heap
     *
     * @param elem the element to insert
     */
    public void insert(int elem) {
        size++;
        heap[size] = elem;

        int current = size;
        // FILL IN CODE: bubble up if the value of current < value of the parent
        while (heap[current]<heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }

    }

    /** Print the array that stores the heap */
    public void print() {
        int i;
        for (i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    /** Remove minimum element (it is at the top of the minHeap)
     *
     * @return the smallest element in the heap
     */
    public int removeMin() {
        swap(1, size); // swap the end of the heap into the root
        size--;  	   // removed the end of the heap
        // fix the heap property - push down as needed
        if (size != 0)
            pushdown(1);
        return heap[size + 1];
    }

    /** Push the value down the heap if it does not satisfy the heap property
     *
     * @param position the index of the element in the heap
     */
    private void pushdown(int position) {
        int smallestChild;
        while (!isLeaf(position)) {
            smallestChild = leftChild(position);
            if(smallestChild+1<=size){
                if(heap[smallestChild+1]<heap[smallestChild]){
                    smallestChild = smallestChild+1;
                }
            }
            if(heap[position]<heap[smallestChild]){
                return;
            }
            swap(position,smallestChild);
            position = smallestChild;

        }
        // set the index of the smallest child to left child
        // if the right child exists and
        // the right child is smaller than left, smallestChild = right child

        //  if  the value of the smallest child is less than value of current,
        // the heap is already valid - return
        // If not, swap the value of the smallest child with the

    }

    /** Check if the heap is empty
     *
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

}

