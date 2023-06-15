package helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static enumerator.ConstantValues.ONE_MILLION_THOUSAND_ELEMENTS;
import static enumerator.ConstantValues.THOUSAND_ELEMENTS;

public class ListHelper {

    /**
     * Método para gerar uma lista de X números inteiros aleatórios;
     * O tamanho da lista pode possuir os valores constantes da classe ConstantValues:
     * THOUSAND_ELEMENTS, TEN_THOUSAND_ELEMENTS, FIFTY_THOUSAND_ELEMENTS,
     * FIVE_HUNDRED_THOUSAND_ELEMENTS, ONE_MILLION_THOUSAND_ELEMENTS
     *
     * @return lista de números inteiros
     */
    public static List<Integer> randomElementsList() {
        int quantityOfElements = THOUSAND_ELEMENTS.getValue();
        List<Integer> list = new ArrayList<>(quantityOfElements);

        for (int index = 1; index <= quantityOfElements; index++) {
            list.add(index);
        }
        Collections.shuffle(list);
        return list;
    }

    /**
     * Método para gerar uma lista de X números inteiros ordenados.
     * O tamanho da lista pode possuir os valores constantes da classe ConstantValues:
     * THOUSAND_ELEMENTS, TEN_THOUSAND_ELEMENTS, FIFTY_THOUSAND_ELEMENTS,
     * FIVE_HUNDRED_THOUSAND_ELEMENTS, ONE_MILLION_THOUSAND_ELEMENTS
     *
     * @return lista de números inteiros ordenados
     */
    public static List<Integer> orderedElementsList() {
        int quantityOfElements = THOUSAND_ELEMENTS.getValue();
        List<Integer> list = new ArrayList<>(quantityOfElements);

        for (int index = 1; index <= quantityOfElements; index++) {
            list.add(index);
        }
        return list;
    }

    /**
     * Método para gerar uma lista de X números inteiros inversamente ordenados.
     * O tamanho da lista pode possuir os valores constantes da classe ConstantValues:
     * THOUSAND_ELEMENTS, TEN_THOUSAND_ELEMENTS, FIFTY_THOUSAND_ELEMENTS,
     * FIVE_HUNDRED_THOUSAND_ELEMENTS, ONE_MILLION_THOUSAND_ELEMENTS
     *
     * @return lista de números inteiros inversamente ordenados
     */
    public static List<Integer> reverseOrderedElementsList() {
        int quantityOfElements = THOUSAND_ELEMENTS.getValue();
        List<Integer> list = new ArrayList<>(quantityOfElements);

        for (int index = quantityOfElements; index >= 1; index--) {
            list.add(index);
        }
        return list;
    }

    /**
     * Método para gerar uma lista de X números inteiros quase ordenados.
     * O tamanho da lista pode possuir os valores constantes da classe ConstantValues:
     * THOUSAND_ELEMENTS, TEN_THOUSAND_ELEMENTS, FIFTY_THOUSAND_ELEMENTS,
     * FIVE_HUNDRED_THOUSAND_ELEMENTS, ONE_MILLION_THOUSAND_ELEMENTS
     *
     * @return lista de números inteiros quase ordenados
     */
    public static List<Integer> nearlyOrderedElementsList() {
        int quantityOfElements = THOUSAND_ELEMENTS.getValue();
        List<Integer> list = new ArrayList<>(quantityOfElements);
        int index = 1;
        boolean skip = false;
        while (list.size() < quantityOfElements) {
            list.add(index);
            if (skip) {
                index += 2;
            } else {
                index += 1;
            }
            skip = !skip;
        }
        return list;
    }
}
