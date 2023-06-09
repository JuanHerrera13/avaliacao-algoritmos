package simpleSorting;

import java.util.List;

import static helper.ListHelper.elementsList;

public class BubbleSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Bubble Sort e
     * o seu tempo de execução.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Bubble Sort-----");
        List<Integer> elementsList = elementsList();
        System.out.println("\nLista de elementos antes do Bubble Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        bubbleSort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Bubble Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Método que implementa o algoritmo Bubble Sort, comparando e trocando os elementos
     * adjacentes até que a lista esteja ordenada.
     *
     * @param elements
     */
    public static void bubbleSort(List<Integer> elements) {
        int aux;
        boolean control;

        for (int index = 0; index < elements.size(); index++) {
            control = true;
            for (int j = 0; j < (elements.size() - 1); j++) {
                if (elements.get(j) > elements.get(j + 1)) {
                    aux = elements.get(j);
                    elements.set(j, elements.get(j + 1));
                    elements.set(j + 1, aux);
                    control = false;
                }
            }
            if (control) {
                break;
            }
        }
    }
}
