package optimizedVersions;

import java.util.List;

import static helper.ListHelper.randomElementsList;

public class OptimizedInsertionSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Inserion Sort otimizado e
     * o seu tempo de execução.
     *
     * Para configurar o padrão de geração de dados, altere a chamada do método da classe helper para:
     * randomElementsList(), orderedElementsList(), reverseOrderedElementsList() ou nearlyOrderedElementsList()
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Insertion Sort-----");
        List<Integer> elementsList = randomElementsList();
        System.out.println("\nLista de elementos antes do Insertion Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        insertionSort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Insertion Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Nesta versão otimizada, a única alteração feita foi substituir j = j - 1 por j--
     * para decrementar o valor de j diretamente. Essa alteração simplifica o código e
     * torna a iteração do loop mais eficiente.
     *
     * @param elements a lista de elementos a ser ordenada
     */
    private static void insertionSort(List<Integer> elements) {
        int n = elements.size();
        for (int i = 1; i < n; i++) {
            int key = elements.get(i);
            int j = i - 1;
            while (j >= 0 && elements.get(j) > key) {
                elements.set(j + 1, elements.get(j));
                j--;
            }
            elements.set(j + 1, key);
        }
    }
}
