package simpleSorting;

import java.util.List;

import static helper.ListHelper.randomElementsList;

public class InsertionSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Insertion Sort e
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
     * Método que implementa o algoritmo Insertion Sort, comparando o elemento atual com o
     * seu predecessor e inserindo cada elemento na sua posição correta.
     *
     * @param elements
     */
    private static void insertionSort(List<Integer> elements) {
        int aux, j;
        for (int index = 1; index < elements.size(); index++) {
            aux = elements.get(index);
            j = index - 1;
            while (j >= 0 && elements.get(j) > aux) {
                elements.set(j + 1, elements.get(j));
                j = j - 1;
            }
            elements.set(j + 1, aux);
        }
    }
}
