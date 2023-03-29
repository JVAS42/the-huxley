package tarefas;

import java.io.*;
import java.util.*;

public class OrdenarListaEncadeadaEmOrdemCresenteHux266 {
	public static <T extends Comparable<? super T>> LinkedList<T> sorting(LinkedList<T> listaOrdenada) {
        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
            int menorValor = i;
            for (int j = i + 1; j < listaOrdenada.size(); j++) {
                if (listaOrdenada.get(j).compareTo(listaOrdenada.get(menorValor)) < 0) {
                	menorValor = j;
                }
            }
            if (menorValor != i) {
                T temp = listaOrdenada.get(i);
                listaOrdenada.set(i, listaOrdenada.get(menorValor));
                listaOrdenada.set(menorValor, temp);
            }
        }
        return listaOrdenada;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> listaOrdenada = new LinkedList<>();
        String entrada = sc.nextLine();
        String[] saida = entrada.split(" ");

        for (String valor : saida) {
        	listaOrdenada.add(Integer.parseInt(valor));
        }
        sorting(listaOrdenada);
        for (Integer ordenada : listaOrdenada) {
            System.out.print(ordenada + " ");
        }
    }
}
