package complexSorting;

import java.util.List;

import static helper.ListHelper.elementsList;

public class HeapSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Heap Sort e
     * o seu tempo de execução.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Heap Sort-----");
        List<Integer> elementsList = elementsList();
        System.out.println("\nLista de elementos antes do Heap Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        sort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Heap Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Método que implementa o algoritmo Heap Sort, ordenando em ordem crescente.
     *
     * @param elementsList
     */
    public static void sort(List<Integer> elementsList) {
        int listSize = elementsList.size();
        for (int index = listSize / 2 - 1; index >= 0; index--)
            heapify(elementsList, listSize, index);
        for (int index = listSize - 1; index > 0; index--) {
            int temp = elementsList.get(0);
            elementsList.set(0, elementsList.get(index));
            elementsList.set(index, temp);
            heapify(elementsList, index, 0);
        }
    }

    /**
     * Método que empilha uma sublista com o nó index, garantindo que o maior elemento
     * esteja na posição correta.
     *
     * @param elementsList
     * @param listSize
     * @param index
     */
    public static void heapify(List<Integer> elementsList, int listSize, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < listSize && elementsList.get(left) > elementsList.get(largest))
            largest = left;
        if (right < listSize && elementsList.get(right) > elementsList.get(largest))
            largest = right;
        if (largest != index) {
            int swap = elementsList.get(index);
            elementsList.set(index, elementsList.get(largest));
            elementsList.set(largest, swap);
            heapify(elementsList, listSize, largest);
        }
    }
}
