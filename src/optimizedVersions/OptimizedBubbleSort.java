package optimizedVersions;

import java.util.List;

import static helper.ListHelper.elementsList;

public class OptimizedBubbleSort {

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
     * Nessa proposta de melhoria, o limite superior do loop externo é diminuído em index a cada repetiçao.
     * Logo, após a primeira repetição, o maior elemento estará na posição esperada, no final da lista.
     * Nas iterações subsequentes, não é necessário comparar de novo os elementos já ordenados no final
     * da lista.
     *
     * @param elements
     */
    public static void bubbleSort(List<Integer> elements) {
        for (int index = 0; index < elements.size() - 1; index++) {
            boolean swapped = false;
            for (int j = 0; j < elements.size() - 1 - index; j++) {
                if (elements.get(j) > elements.get(j + 1)) {
                    int temp = elements.get(j);
                    elements.set(j, elements.get(j + 1));
                    elements.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
