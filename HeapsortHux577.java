package tarefas;

import java.util.*;
import java.io.*;

public class HeapsortHux577 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        sc.close(); //27 17 3 16 13 10 1 5 7 12 4 8 9 0
        
        System.out.print("Estado inicial: ");
        printHeap(arr);

        heapsort(arr);
        
        System.out.print("Resultado Final: ");
        printHeap(arr);
    }
	
	public static void heapsort(int[] arr) {
	    buildMaxHeap(arr);
	    int heapSize = arr.length;
	    for (int i = arr.length - 1; i > 0; i--) {
	        System.out.print("Estado Atual da Heap: ");
	        printHeap(Arrays.copyOfRange(arr, 0, heapSize));
	        System.out.print("Maior elemento neste passo: " + arr[0] + "\n");
	        swap(arr, 0, i);
	        maxHeapify(arr, 0, --heapSize);
	    }
	    System.out.print("Estado Atual da Heap: ");
        printHeap(Arrays.copyOfRange(arr, 0, heapSize));
	}
	

    public static void buildMaxHeap(int[] arr) {
        int heapSize = arr.length;
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    public static void maxHeapify(int[] arr, int i, int heapSize) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < heapSize && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
}