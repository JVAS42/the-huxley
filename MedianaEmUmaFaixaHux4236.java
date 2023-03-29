package tarefas;

import java.io.*;
import java.util.*;

public class MedianaEmUmaFaixaHux4236 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] valoresStr = sc.nextLine().split(",");
        int[] valores = new int[valoresStr.length];
        for (int i = 0; i < valoresStr.length; i++) {
            valores[i] = Integer.parseInt(valoresStr[i]);
        }
        int minimo = sc.nextInt();
        int maximo = sc.nextInt();

        List<Integer> valoresFiltrados = new ArrayList<Integer>();
        for (int v : valores) {
            if (v >= minimo && v <= maximo) {
                valoresFiltrados.add(v);
            }
        }
        Collections.sort(valoresFiltrados);

        int tamanho = valoresFiltrados.size();
        double mediana;
        if (tamanho % 2 == 0) {
            mediana = (valoresFiltrados.get(tamanho / 2 - 1) + valoresFiltrados.get(tamanho / 2)) / 2.0;
        } else {
            mediana = valoresFiltrados.get(tamanho / 2);
        }

        for (int i = 0; i < tamanho; i++) {
            System.out.print(valoresFiltrados.get(i));
            if (i < tamanho - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.printf("%.2f\n", mediana);

        sc.close();
    }
}
