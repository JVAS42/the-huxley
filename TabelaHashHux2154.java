import java.io.*;
import java.util.*;

public class TabelaHashHux2154 {
    private List<List<Integer>> table;
    private int size;

    public TabelaHashHux2154(int capacity) {
        table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
        size = 0;
    }

    private int hash(int key) {
        return key % table.size();
    }

    public void insert(int key) {
        int index = hash(key);
        List<Integer> list = table.get(index);
        int i;
        for (i = 0; i < list.size(); i++) {
            if (key <= list.get(i)) {
                break;
            }
        }
        list.add(i, key);
        size++;
    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> list = table.get(index);
        if (list.remove(Integer.valueOf(key))) {
            size--;
        }
    }

    public void printTable() {
        System.out.println("imprimindo tabela hash:");
        for (int i = 0; i < table.size(); i++) {
            List<Integer> list = table.get(i);
            System.out.print("[" + i + "]:");
            if (list.isEmpty()) {
                System.out.println("Lista vazia!");
            } else {
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j));
                    if (j < list.size()) {
                        System.out.print("=>");
                    }
                }
                System.out.println();
            }
        }
    }

    public void search(int key) {
        int index = hash(key);
        List<Integer> list = table.get(index);
        int comparisons = 0;
        for (int i = 0; i < list.size(); i++) {
            comparisons++;
            if (list.get(i) == key) {
                System.out.println("BUSCA POR " + key);
                System.out.println("numero de elementos da tabela hash: " + size);
                System.out.println("elemento " + key + " encontrado!");
                System.out.println("numero de elementos acessados na tabela hash: " + comparisons);
                return;
            }
        }
        System.out.println("BUSCA POR " + key);
        System.out.println("numero de elementos da tabela hash: " + size);
        System.out.println("elemento nao encontrado!");
        System.out.println("numero de elementos acessados na tabela hash: " + comparisons);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        System.out.println();

        TabelaHashHux2154 hashTable = new TabelaHashHux2154(m);

        while (true) {
            String command = scanner.next();
            if (command.equals("a")) {
                int key = Integer.parseInt(scanner.next());
                hashTable.insert(key);
            } else if (command.equals("r")) {
                int key = Integer.parseInt(scanner.next());
                hashTable.remove(key);
            } else if (command.equals("i")) {
                hashTable.printTable();
            } else if (command.equals("p")) {
                int key = Integer.parseInt(scanner.next());
                hashTable.search(key);
            } else if (command.equals("f")) {
                break;
            }
        }
    }
}
