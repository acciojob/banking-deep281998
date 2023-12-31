package com.driver;

import java.sql.SQLOutput;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        if(digits*9>sum){
            throw new Exception("Account Number can not be generated");
        }
        StringBuilder str = new StringBuilder();
        while(digits-->0){
            if(sum>=9){
                str.append(9);
                sum-=9;
            }else{
                str.append(sum);
                sum=0;
            }
        }
        return str.toString();

        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

    }

    public void deposit(double amount) {
        this.balance+=amount;
        //add amount to balance
    }

    public void withdraw(double amount) throws Exception {
            if (this.balance - amount >= minBalance) {
                this.balance -= amount;
            } else {
                throw new Exception("Insufficient Balance");
            }

        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }

}