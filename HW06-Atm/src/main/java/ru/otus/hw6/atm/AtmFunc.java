package ru.otus.hw6.atm;

public interface AtmFunc {
    int getTotal();
    void addMoney (Nominal nominal, int count);
    void getMoney (int count);
}
