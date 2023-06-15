package complexSorting;

import java.util.List;

import static helper.ListHelper.*;

public class QuickSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Quick Sort e
     * o seu tempo de execução;
     *
     * Para configurar o padrão de geração de dados, altere a chamada do método da classe helper para:
     * randomElementsList(), orderedElementsList(), reverseOrderedElementsList() ou nearlyOrderedElementsList()
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Quick Sort-----");
        List<Integer> elementsList = randomElementsList();
        System.out.println("\nLista de elementos antes do Quick Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        quickSort(elementsList, 0, elementsList.size() - 1);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Quick Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Responsável pelo processo de separação interna dentro da sublista, até que
     * todos os elementos estejam ordenados.
     *
     * @param elementsList
     * @param beginning
     * @param ending
     */
    private static void quickSort(List<Integer> elementsList, int beginning, int ending) {
        if (beginning < ending) {
            int pivotPosition = separate(elementsList, beginning, ending);
            quickSort(elementsList, beginning, pivotPosition - 1);
            quickSort(elementsList, pivotPosition + 1, ending);
        }
    }

    /**
     * Método responsável por retornar um pivô, o elemento divisível entre as duas listas.
     *
     * @param elementsList
     * @param beginning
     * @param ending
     * @return pivot
     */
    private static int separate(List<Integer> elementsList, int beginning, int ending) {
        int pivot = elementsList.get(beginning);
        int i = beginning + 1, f = ending;
        while (i <= f) {
            if (elementsList.get(i) <= pivot)
                i++;
            else if (pivot < elementsList.get(f))
                f--;
            else {
                int replacement = elementsList.get(i);
                elementsList.set(i, elementsList.get(f));
                elementsList.set(f, replacement);
                i++;
                f--;
            }
        }
        elementsList.set(beginning, elementsList.get(f));
        elementsList.set(f, pivot);
        return f;
    }
}
