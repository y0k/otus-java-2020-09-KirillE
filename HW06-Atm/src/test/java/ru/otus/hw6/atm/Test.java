package ru.otus.hw6.atm;

public class Test {
    public static void main(String[] args) {
        Atm atm = new Atm();

        atm.addMoney(Nominal.TEN, 4);
        atm.addMoney(Nominal.FIFTY, 4);
        atm.addMoney(Nominal.HUNDRED, 3);
        atm.addMoney(Nominal.FIVE_HUNDRED, 2);
        atm.addMoney(Nominal.THOUSAND, 1);
        System.out.println(atm.getTotal());
        atm.getMoney(20);
        System.out.println(atm.getTotal());
        atm.getMoney(60);
        System.out.println(atm.getTotal());
        atm.getMoney(300);
        System.out.println(atm.getTotal());
        atm.getMoney(1560);
        System.out.println(atm.getTotal());
        atm.getMoney(500);
        System.out.println(atm.getTotal());
        atm.getMoney(100);
        System.out.println(atm.getTotal());
        atm.getMoney(100);
        System.out.println(atm.getTotal());

    }
}
