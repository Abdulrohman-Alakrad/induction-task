package com.progressoft.induction;

import java.math.BigDecimal;

public class Money {

    public static final Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static final Money HALF_DINAR = new Money(BigDecimal.valueOf(0.5));
    public static final Money DINAR = new Money(BigDecimal.valueOf(1));
    public static final Money FIVE_DINAR = new Money(BigDecimal.valueOf(5));
    public static final Money TEN_DINAR = new Money(BigDecimal.valueOf(10));

    private BigDecimal value;
    public static final Money ZERO = new Money(BigDecimal.ZERO);

    public Money(BigDecimal value){
        //(this.isLessThan(ZERO))
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money add(Money halfDinar) {
        return new Money( value.add(halfDinar.getValue()));
    }


    @Override
    public boolean equals(Object obj) {
        return this.value.compareTo(((Money)obj).value) == 0;
    }


    public boolean isLessThan(Money money) {
        return money != null && this.value.compareTo(money.value) < 0;
    }

    public Money subtract(Money money) {
        if (this.isLessThan(money)) {
            throw new IllegalArgumentException();
        }
        return new Money(this.value.subtract(money.value));
    }
}
