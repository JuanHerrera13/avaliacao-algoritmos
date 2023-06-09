package enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConstantValues {

    THOUSAND_ELEMENTS(1000),
    TEN_THOUSAND_ELEMENTS(10000),
    FIFTY_THOUSAND_ELEMENTS(50000),
    FIVE_HUNDRED_THOUSAND_ELEMENTS(500000),
    ONE_MILLION_THOUSAND_ELEMENTS(1000000);

    private final int value;
}
