package optimizedVersions;

import java.util.List;

import static helper.ListHelper.randomElementsList;

public class OptimizedSelectionSort {

    /**
     * Método que apresenta a lista antes e após o algoritmo Selection Sort otimizado e
     * o seu tempo de execução.
     *
     * Para configurar o padrão de geração de dados, altere a chamada do método da classe helper para:
     * randomElementsList(), orderedElementsList(), reverseOrderedElementsList() ou nearlyOrderedElementsList()
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----Algoritmo Selection Sort-----");
        List<Integer> elementsList = randomElementsList();
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
