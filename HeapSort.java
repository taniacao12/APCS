// Tania Cao
// APCS2 pd2
// HW#51 -- Heaping Piles of Sordidness
// 2018-05-20

import java.io.*;
import java.util.*;

public class HeapSort {
    //Sorting in non decreasing order
    public static int[] heapsort(int arr[]) {
        int N = arr.length;
        //creating a heap
        MaxHeap heap = createHeap(arr, N);
        //Repeating the below steps till the size of the heap is 1.
        while(heap.len > 1) {
            //Replacing largest element with the last item of the heap
            swap(heap, 0, heap.len - 1);
            heap.len--;//Reducing the heap size by 1
            heapify(heap, 0);
        }
        return heap.arr;
    }
    
    public static MaxHeap createHeap(int arr[], int N) {
        MaxHeap maxheap = new MaxHeap(N, arr);
        int i = (maxheap.len - 2) / 2;
        while(i >= 0) {
            maxheap = heapify(maxheap, i);
            i--;
        }
        return maxheap;
    }
    
    public static MaxHeap heapify(MaxHeap maxheap, int N) {
        int largest = N;
        int left = 2 * N + 1; //index of left child
        int right = 2 * N + 2; //index of right child
        if(left < maxheap.len && maxheap.arr[left] > maxheap.arr[largest]) {
            largest = left;
        }
        if(right < maxheap.len && maxheap.arr[right] > maxheap.arr[largest]) {
            largest = right;
        }
        if(largest != N) {
            swap(maxheap, largest, N);
            heapify(maxheap, largest);
        }
        return maxheap;
    }

    public static void swap(MaxHeap maxheap, int i, int j) {
        int temp;
        temp = maxheap.arr[i];
        maxheap.arr[i] = maxheap.arr[j];
        maxheap.arr[j] = temp;
    }
    
    public static class MaxHeap {
        int len;
        int arr[];
        MaxHeap(int l, int a[]) {
            len = l;
            arr = a;
        }
    }
    
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Initializing array
        int arr[] = {9, 4, 8, 3, 1, 2, 5};
        System.out.print("Initial Array  : ");
        printArray(arr);
        arr = heapsort(arr);
        System.out.print("After Sorting  : ") ;
        printArray(arr);
    }
}
