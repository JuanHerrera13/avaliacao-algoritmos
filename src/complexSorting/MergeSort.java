package complexSorting;

import java.util.ArrayList;
import java.util.List;

import static helper.ListHelper.randomElementsList;

public class MergeSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Merge Sort e
     * o seu tempo de execução.
     *
     * Para configurar o padrão de geração de dados, altere a chamada do método da classe helper para:
     * randomElementsList(), orderedElementsList(), reverseOrderedElementsList() ou nearlyOrderedElementsList()
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Merge Sort-----");
        List<Integer> elementsList = randomElementsList();
        System.out.println("\nLista de elementos antes do Merge Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        mergeSort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Merge Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Método que implementa o algoritmo Merge Sort,
     * dividindo recursivamente a lista original em partes menores.
     *
     * @param elementsList
     */
    private static void mergeSort(List<Integer> elementsList) {
        int listSize = elementsList.size();
        if (listSize < 2) {
            return;
        }
        int middleIndex = listSize / 2;
        List<Integer> leftHalf = new ArrayList<>(elementsList.subList(0, middleIndex));
        List<Integer> rightHalf = new ArrayList<>(elementsList.subList(middleIndex, listSize));
        for (int index = 0; index < middleIndex; index++) {
            leftHalf.set(index, elementsList.get(index));
        }
        for (int index = middleIndex; index < listSize; index++) {
            rightHalf.set(index - middleIndex, elementsList.get(index));
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(elementsList, leftHalf, rightHalf);
    }

    /**
     * Método auxiliar responsável por mesclar duas metades ordenadas.
     *
     * @param elementsList
     * @param leftHalf
     * @param rightHalf
     */
    private static void merge(List<Integer> elementsList, List<Integer> leftHalf, List<Integer> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftHalf.get(i) <= rightHalf.get(j)) {
                elementsList.set(k, leftHalf.get(i));
                i++;
            } else {
                elementsList.set(k, rightHalf.get(j));
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            elementsList.set(k, leftHalf.get(i));
            i++;
            k++;
        }
        while (j < rightSize) {
            elementsList.set(k, rightHalf.get(j));
            j++;
            k++;
        }
    }
}
