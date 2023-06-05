import java.io.*;
import java.util.*;

public class MenorCaminhoEmUmGrafoHux2415 {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertice = sc.nextInt();
        int aresta = sc.nextInt();

        int[][] grafo = new int[vertice][vertice];
        for (int i = 0; i < aresta; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            grafo[v1][v2] = 1;
        }

        int s = sc.nextInt();
        int e = sc.nextInt();

        int[] distancia = new int[vertice];
        for (int i = 0; i < vertice; i++) {
            if (i == s) {
                distancia[i] = 0;
            } else {
                distancia[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] visitado = new boolean[vertice];
        for (int i = 0; i < vertice; i++) {
            int u = -1;
            for (int j = 0; j < vertice; j++) {
                if (!visitado[j] && (u == -1 || distancia[j] < distancia[u])) {
                    u = j;
                }
            }
            visitado[u] = true;
            for (int v = 0; v < vertice; v++) {
                if (grafo[u][v] == 1) { 
                    int dist = distancia[u] + 1; 
                    if (dist < distancia[v]) { 
                        distancia[v] = dist;
                    }
                }
            }
        }

        System.out.println("Tamanho do menor caminho de G: " + distancia[e]);
    }
}