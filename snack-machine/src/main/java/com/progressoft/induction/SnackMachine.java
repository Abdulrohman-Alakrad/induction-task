package com.progressoft.induction;

public class SnackMachine {

    private Money inside = Money.ZERO;
    private Money transaction = Money.ZERO;
    public static final int DEFAULT_QUANTITY = 1;
    private Snack gums = new Snack(DEFAULT_QUANTITY, Money.HALF_DINAR, SnackType.CHEWING_GUM);
    private Snack chips = new Snack(DEFAULT_QUANTITY, Money.DINAR, SnackType.CHIPS);
    private Snack chocolates = new Snack(DEFAULT_QUANTITY, Money.DINAR.add(Money.DINAR), SnackType.CHOCOLATE);


    public Money moneyInside() {
        return inside;
    }

    public void insertMoney(Money insertedMoney) {
        if ( insertedMoney != null &&
                (insertedMoney.equals(Money.QUARTER_DINAR) ||
                insertedMoney.equals(Money.HALF_DINAR) ||
                insertedMoney.equals(Money.DINAR) ||
                insertedMoney.equals(Money.FIVE_DINAR) ||
                insertedMoney.equals(Money.TEN_DINAR))) {

            this.transaction = this.transaction.add(insertedMoney);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Money moneyInTransaction() {
        return transaction;
    }

    public Snack chewingGums() {
        return gums;
    }

    public Snack chips() {
        return chips;
    }

    public Snack chocolates() {
        return chocolates;
    }

    public Money buySnack(SnackType snackType) {
        if (transaction.equals(Money.ZERO)) {
            throw new IllegalStateException();
        }
        if(snackType == SnackType.CHEWING_GUM && gums.quantity() != 0 && !transaction.isLessThan(gums.price())) {
            this.inside = this.inside.add(gums.price());
            this.transaction = this.transaction.subtract(gums.price());
            gums.setQuantity(gums.quantity() - 1);

        } else if (snackType == SnackType.CHIPS && chips.quantity() != 0 && !transaction.isLessThan(chips.price())){
            this.inside = this.inside.add(chips.price());
            this.transaction = this.transaction.subtract(chips.price());
            chips.setQuantity(chips.quantity() - 1);

        } else if (snackType == SnackType.CHOCOLATE && chocolates.quantity() != 0 && !transaction.isLessThan(chocolates.price())){
            this.inside = this.inside.add(chocolates.price());
            this.transaction = this.transaction.subtract(chocolates.price());
            chocolates.setQuantity(chocolates.quantity() - 1);
        } else {
            throw new IllegalStateException();
        }
        return transaction;
    }

}
