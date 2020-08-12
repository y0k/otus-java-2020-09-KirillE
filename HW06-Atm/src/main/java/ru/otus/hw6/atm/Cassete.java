package ru.otus.hw6.atm;


public class Cassete implements Comparable<Cassete> {
    private final Nominal nominal;
    private final int nominalValue;
    private int countMoney = 0;

    public Cassete(Nominal nominal) {
        this.nominal = nominal;
        this.nominalValue = nominal.value;
    }

    public void addNominal(int count) { this.countMoney = this.countMoney + count; }

    public void rmvNominal(int count) {
        if(countMoney - count >= 0) {
            this.countMoney = this.countMoney - count;
        } else {
            System.out.println("Has no some nominal");
        }
    }

    public int getNominalValue() { return nominalValue; }

    public int getTotalMoney() { return countMoney * nominalValue; }

    public int getCountMoney() { return countMoney; }

    @Override
    public int compareTo(Cassete o) { return  (o.getNominalValue() - this.getNominalValue()); }

    @Override
    public String toString() {
        return "Cassete{" +"Nominal=" + nominal + " nominalValue=" + nominalValue + " countMoney=" + countMoney + '}';
    }
}
