package tarefas;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortHux3931 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê os números a serem ordenados
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Encontra o maior número do array
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Cria um array de contagem
        int[] count = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        // Imprime o array de contagem
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();

        // Ordena o array original
        int[] sorted = new int[nums.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[index] = i;
                index++;
            }
        }

        // Imprime o array ordenado
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
        System.out.println();
    }
}
