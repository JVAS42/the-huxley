package tarefas;

import java.io.*;
import java.util.*;

public class ConstruirHeapMaximaHux578 {
public static void sort(int arr[]) {
		
		int n = arr.length;
		if(n == 1) {
			System.out.print("Resultado Final: ");
			printArray(arr);
		}
		
		for(int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
			
			if(i == 0) {
				System.out.print("Estado Atual: ");
				printArray(arr);
				System.out.print("Resultado Final: ");
				printArray(arr);
			} else {
				System.out.print("Estado Atual: ");
				printArray(arr);
			}
		}
		for(int i=n-1; i > 0; i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp; 
			
			heapify(arr, i, 0);
		}
	}
	
	static void heapify(int arr[], int n, int  i) 
	{
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2; 
		
		if(l < n && arr[l] > arr [largest])
			largest = l;
		
		if(r < n && arr[r] > arr [largest])
			largest = r;
		
		if(largest != i) 
		{
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, n, largest);
		}
	}
	
	static void printArray(int arr[]) {
		int k = arr.length;
		for(int i = 0; i < k; ++i) {
			if(i == k - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + " | ");
			}
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] valores = input.split(" ");
		
		int[] arr = new int[valores.length];
		int i;
		
		for(i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(valores[i]);
		}
		System.out.print("Estado inicial: ");
		printArray(arr);
		
		sort(arr);
	}
}
