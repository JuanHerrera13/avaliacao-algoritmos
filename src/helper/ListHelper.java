package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static enumerator.ConstantValues.THOUSAND_ELEMENTS;
import static enumerator.ConstantValues.TEN_THOUSAND_ELEMENTS;
import static enumerator.ConstantValues.FIFTY_THOUSAND_ELEMENTS;
import static enumerator.ConstantValues.FIVE_HUNDRED_THOUSAND_ELEMENTS;
import static enumerator.ConstantValues.ONE_MILLION_THOUSAND_ELEMENTS;

public class ListHelper {

    /**
     * Método para gerar uma lista de X números inteiros;
     * O tamanho da lista pode possuir os valores constantes da classe ConstantValues:
     * THOUSAND_ELEMENTS, TEN_THOUSAND_ELEMENTS, FIFTY_THOUSAND_ELEMENTS,
     * FIVE_HUNDRED_THOUSAND_ELEMENTS, ONE_MILLION_THOUSAND_ELEMENTS
     *
     * @return lista de números inteiros
     */
    public static List<Integer> elementsList() {
        ArrayList<Integer> elementsList = new ArrayList<>();
        Random randomNumber = new Random();
        do {
            int number = randomNumber.nextInt(THOUSAND_ELEMENTS.getValue()) + 1;
            if (!elementsList.contains(number)) {
                elementsList.add(number);
            }
        } while (elementsList.size() != THOUSAND_ELEMENTS.getValue());
        return elementsList;
    }
}
