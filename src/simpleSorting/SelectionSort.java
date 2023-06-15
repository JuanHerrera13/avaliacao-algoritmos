package simpleSorting;

import java.util.List;

import static helper.ListHelper.randomElementsList;

public class SelectionSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Selection Sort e
     * o seu tempo de execução.
     *
     * Para configurar o padrão de geração de dados, altere a chamada do método da classe helper para:
     * randomElementsList(), orderedElementsList(), reverseOrderedElementsList() ou nearlyOrderedElementsList()
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Selection Sort-----");
        List<Integer> elementsList = randomElementsList();
        System.out.println("\nLista de elementos antes do Selection Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        selectionSort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Selection Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Método que implementa o algoritmo Selection Sort, algoritmo que divide a lista em
     * duas partes, uma sublista ordenada e outra não ordenada. A cada iteração, encontra o
     * elemento mínimo na sublista não ordenada e o coloca na posição correta da sublista
     * ordenada.
     *
     * @param elements
     */
    public static void selectionSort(List<Integer> elements) {
        int minorPosition, aux;
        for (int index = 0; index < elements.size(); index++) {
            minorPosition = index;
            for (int j = index + 1; j < elements.size(); j++) {
                if (elements.get(j) < elements.get(minorPosition)) {
                    minorPosition = j;
                }
            }
            aux = elements.get(minorPosition);
            elements.set(minorPosition, elements.get(index));
            elements.set(index, aux);
        }
    }
}
