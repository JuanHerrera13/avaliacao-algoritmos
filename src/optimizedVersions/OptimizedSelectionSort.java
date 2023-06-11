package optimizedVersions;

import java.util.List;

import static helper.ListHelper.elementsList;

public class OptimizedSelectionSort {

    public static void main(String[] args) {
        System.out.println("-----Algoritmo Selection Sort-----");
        List<Integer> elementsList = elementsList();
        System.out.println("\nLista de elementos antes do Selection Sort: " + elementsList);
        double timeBeginning = System.currentTimeMillis();
        selectionSort(elementsList);
        double timeEnding = System.currentTimeMillis();
        double totalTime = (timeEnding - timeBeginning) / 1000;
        System.out.println("\nLista de elementos após o Selection Sort: " + elementsList);
        System.out.println("\nTempo de execução em segundos: " + totalTime);
    }

    /**
     * Nessa versão, evitamos a troca desnecessária ao adicionar uma verificação antes de realizar a troca.
     *
     * @param elements
     */
    public static void selectionSort(List<Integer> elements) {
        for (int index = 0; index < elements.size(); index++) {
            int minorPosition = index;
            for (int j = index + 1; j < elements.size(); j++) {
                if (elements.get(j) < elements.get(minorPosition)) {
                    minorPosition = j;
                }
            }
            if (minorPosition != index) {
                int aux = elements.get(minorPosition);
                elements.set(minorPosition, elements.get(index));
                elements.set(index, aux);
            }
        }
    }
}
