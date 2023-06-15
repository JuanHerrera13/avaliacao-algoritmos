package optimizedVersions;

import java.util.ArrayList;
import java.util.List;

import static helper.ListHelper.randomElementsList;

public class OptimizedMergeSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Merge Sort otimizado e
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
     * Agora, nessa versão do algoritmo, foi aplicada a otimização de fusão: antes de realizar a fusão,
     * compara-se o último elemento da sublista esquerda com o primeiro elemento da sublista direita.
     * Se o último elemento da sublista esquerda for menor ou igual ao primeiro elemento do sublista
     * direita, pode-se concluir que os subarrays já estão ordenados e evitar a etapa de fusão.
     *
     * @param elementsList
     * @param leftHalf
     * @param rightHalf
     */
    private static void merge(List<Integer> elementsList, List<Integer> leftHalf, List<Integer> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();
        int i = 0, j = 0, k = 0;
        if (leftHalf.get(leftSize - 1) <= rightHalf.get(0)) {
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
            return;
        }
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
