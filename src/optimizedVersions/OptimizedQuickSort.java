package optimizedVersions;

import java.util.List;

import static helper.ListHelper.elementsList;

public class OptimizedQuickSort {

    public static void main(String[] args) {
        System.out.println("-----Algoritmo Quick Sort-----");
        List<Integer> elementsList = elementsList();
        System.out.println("\nLista de elementos antes do Quick Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        quickSort(elementsList, 0, elementsList.size() - 1);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Quick Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    private static void quickSort(List<Integer> elementsList, int beginning, int ending) {
        if (beginning < ending) {
            int pivotPosition = separate(elementsList, beginning, ending);
            quickSort(elementsList, beginning, pivotPosition - 1);
            quickSort(elementsList, pivotPosition + 1, ending);
        }
    }

    /**
     * Método responsável por retornar um pivô, o elemento divisível entre as duas listas.
     * Nesta versão do código, o pivot é escolhido como o elemento do meio, já que da maneira como estava antes,
     * pode ser problemático se a lista estiver ordenada ou quase ordenada.
     *
     * @param elementsList
     * @param beginning
     * @param ending
     * @return pivotPosition
     */
    private static int separate(List<Integer> elementsList, int beginning, int ending) {
        int middle = beginning + (ending - beginning) / 2;
        int pivot = elementsList.get(middle);

        // Colocar o pivô na posição correta
        swap(elementsList, middle, ending);

        int i = beginning;
        for (int j = beginning; j < ending; j++) {
            if (elementsList.get(j) < pivot) {
                swap(elementsList, i, j);
                i++;
            }
        }

        // Colocar o pivô na posição correta
        swap(elementsList, i, ending);

        return i;
    }

    /**
     * Método auxiliar para trocar dois elementos em uma lista.
     *
     * @param elementsList
     * @param i
     * @param j
     */
    private static void swap(List<Integer> elementsList, int i, int j) {
        int temp = elementsList.get(i);
        elementsList.set(i, elementsList.get(j));
        elementsList.set(j, temp);
    }
}
