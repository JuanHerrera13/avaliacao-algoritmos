package optimizedVersions;

import java.util.List;

import static helper.ListHelper.elementsList;

public class OptimizedInsertionSort {

    public static void main(String[] args) {
        System.out.println("-----Algoritmo Insertion Sort-----");
        List<Integer> elementsList = elementsList();
        System.out.println("\nLista de elementos antes do Insertion Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        insertionSort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Insertion Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Na seguinte proposta de melhoria, o código foi otimizado ao utilizar o método List.subList()
     * para obter uma sublista e movê-la de uma vez para a direita, ao invés de fazermos
     * atribuições individuais.
     *
     * @param elements
     */
    private static void insertionSort(List<Integer> elements) {
        for (int index = 1; index < elements.size(); index++) {
            int aux = elements.get(index);
            int j = index - 1;
            while (j >= 0 && elements.get(j) > aux) {
                elements.subList(j + 1, index + 1).clear();
                elements.add(j + 1, aux);
                j--;
            }
        }
    }
}
