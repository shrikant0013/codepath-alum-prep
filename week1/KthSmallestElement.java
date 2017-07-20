package week1;

import java.util.List;

public class KthSmallestElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> a, int k) {
        int[] heap = new int[k + 1];

        int index = 0;
        for (int i : a) {
            if (index < k) {
                heap[++index] = i;
                swimUp(heap, index);
            } else {
                if (heap[1] > i) {
                    heap[1] = i;
                    sinkDown(heap);
                }
            }
        }
        return heap[1];
    }

    private void swimUp(int[] heap, int ptr) {
        while (ptr > 1) { //Check upto root
            //k/2 points to parent of k and we check if parent is greater else exit
            if (heap[ptr / 2] > heap[ptr]) break; // Exit condition, because max heap
            swap(heap, ptr / 2, ptr);
            ptr = ptr / 2;
        }
    }

    private void sinkDown(int[] heap) {
        int currentParentIndex = 1;

        while (currentParentIndex * 2 < heap.length) {
            int childPtr = currentParentIndex * 2;
            if (childPtr < heap.length - 1 && heap[childPtr] < heap[childPtr + 1]) {
                childPtr++; //Choose greater child
            }

            if (heap[currentParentIndex] > heap[childPtr]) {
                break; // Exit condition parent is greater than child, heap property maintained
            }
            swap(heap, currentParentIndex, childPtr);
            currentParentIndex = childPtr; //move to next heap
        }
    }

    private void swap(int[] heap, int indexOne, int indexOther) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexOther];
        heap[indexOther] = temp;
    }
}
