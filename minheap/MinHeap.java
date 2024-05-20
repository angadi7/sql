package minheap;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    
    private int parent(int index) {
        return (index - 1) / 2;
    }

    
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

   
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    
    public void insert(int element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

 
    public int deleteMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int minElement = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return minElement;
    }

   
    public int getMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap.get(0);
    }

    
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(13);
        minHeap.insert(11);
        minHeap.insert(16);
        minHeap.insert(15);
        minHeap.insert(12);
        minHeap.insert(14);

        System.out.println("Heap elements: ");
        minHeap.printHeap();

        System.out.println("Minimum element: " + minHeap.getMin());

        System.out.println("Deleted minimum element: " + minHeap.deleteMin());
        System.out.println("Heap elements after deletion: ");
        minHeap.printHeap();
    }
}

