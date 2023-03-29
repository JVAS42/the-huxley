package tarefas;

import java.io.*;
import java.util.*;

public class MedianaDeTresHux3605 {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String lista;
        lista = sc.nextLine();
        String[] listaNumeros =  lista.split(" ");
        int[] numeros = new int[listaNumeros.length];


        for (int i = 0; i < listaNumeros.length; i++) {
        	numeros[i] = Integer.parseInt(listaNumeros[i]);
        }

        particao(numeros, 0, numeros.length - 1);

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }

    private static void troca(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static int particao(int[] A, int inicio, int fim){

        int meio = (inicio + fim)/2;
        int numInicio = A[inicio];
        int numMeio = A[meio];
        int numFinal = A[fim];
        int mediana;

        if(numInicio < numMeio){
            if(numMeio < numFinal){
            	mediana = meio;
            }else{
                if(numInicio < numFinal){
                	mediana = fim;
                }else{
                	mediana = inicio;
                }
            }
        }else{
            if(numFinal < numMeio){
            	mediana = meio;
            }else{
                if(numFinal < numInicio){
                	mediana = fim;
                }else{
                	mediana = inicio;
                }
            }
        }

        troca(A, mediana, fim);


        int pivot = A[fim];
        int i = inicio - 1;
        System.out.println(pivot);

        for(int j = inicio; j <= fim - 1; j++){
            if(A[j] <= pivot){
                i = i + 1;
                troca(A, i, j);
            }
        }

        troca(A, i + 1, fim);
        return i + 1;
    }
}
