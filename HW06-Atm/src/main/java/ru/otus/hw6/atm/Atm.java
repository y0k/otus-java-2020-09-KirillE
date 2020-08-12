package ru.otus.hw6.atm;


import java.util.*;

public class Atm implements AtmFunc {
    private final Collection<Cassete> cas = new TreeSet<>();

    public Atm() {
        for (Nominal nominal : Nominal.values()) {
            cas.add(new Cassete(nominal));
        }
    }

    @Override
    public int getTotal() {
        return cas.stream().map(x -> x.getTotalMoney()).reduce(0, Integer::sum);
    }

    @Override
    public void addMoney(Nominal nominal, int count) {
        cas.stream().filter(cassete -> cassete.getNominalValue() == nominal.value)
                .forEach(cassete -> cassete.addNominal(count));
    }

    @Override
    public void getMoney(int count) {
        int takenCount = count;
        Map takenNominal = new HashMap<Nominal, Integer>();
        for (Cassete cassete : cas) {
            int countNominal = 0;
            for (int i = cassete.getCountMoney(); i > 0 && cassete.getNominalValue() <= takenCount; i--) {
                takenNominal.put(cassete.getNominalValue(), ++countNominal);
                takenCount = takenCount - cassete.getNominalValue();
            }
        }

        if (takenCount == 0) {
            for (Cassete cassete : cas) {
                int nominalValue = cassete.getNominalValue();
                if (takenNominal.containsKey(nominalValue)) {
                    cassete.rmvNominal((Integer) takenNominal.get(nominalValue));
                }
            }
            System.out.println("Take: " + count);
            System.out.println("Used nominals:" + takenNominal);
        } else {
            System.out.println("Has no money");
        }
    }

    @Override
    public String toString() {
        return "Atm{" + "cas=" + cas + '}';
    }
}
