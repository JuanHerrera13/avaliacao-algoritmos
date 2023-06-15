package optimizedVersions;

import java.util.List;
import java.util.ArrayList;

import static helper.ListHelper.randomElementsList;

public class OptimizedHeapSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Heap Sort otimizado
     * o seu tempo de execução.
     *
     * Para configurar o padrão de geração de dados, altere a chamada do método da classe helper para:
     * randomElementsList(), orderedElementsList(), reverseOrderedElementsList() ou nearlyOrderedElementsList()
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Heap Sort-----");
        List<Integer> elementsList = randomElementsList();
        System.out.println("\nLista de elementos antes do Heap Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        sort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Heap Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Aqui, foi implementado o Heap Maximal, um tipo de heap onde cada nó pai é maior ou igual aos
     * seus filhos.
     *
     * @param elementsList a lista de elementos a ser ordenada
     */
    public static void sort(List<Integer> elementsList) {
        int listSize = elementsList.size();
        for (int index = listSize / 2 - 1; index >= 0; index--)
            heapify(elementsList, listSize, index);
        List<Integer> heap = new ArrayList<>(elementsList);
        for (int index = listSize - 1; index > 0; index--) {
            int temp = heap.get(0);
            heap.set(0, heap.get(index));
            heap.set(index, temp);
            heapify(heap, index, 0);
        }
        elementsList.clear();
        elementsList.addAll(heap);
    }

    /**
     * Agora é passado o tamanho atual do heap para evitar acessar os elementos
     * desnecessários no final da lista.
     *
     * @param elementsList a lista de elementos que representa o heap
     * @param listSize     o tamanho atual do heap
     * @param index        o índice a partir do qual iniciar a manutenção do heap
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
