package helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int quantityOfElements = THOUSAND_ELEMENTS.getValue();
        List<Integer> list = new ArrayList<>(quantityOfElements);

        for (int index = 1; index <= quantityOfElements; index++) {
            list.add(index);
        }
        Collections.shuffle(list);
        return list;
    }
}
