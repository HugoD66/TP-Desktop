package com.example.financemanager.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Income {
    private final LocalDate date;
    private final float total;

    private final float salary;
    private final float aids;
    private final float freelance;
    private final float passiveIncome;
    private final float others;

    private final static String PRICE_FORMAT = "%.2f €";

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMMM yyyy");

    public Income(LocalDate date, float salary, float aids, float freelance, float passiveIncome, float others) {
        this.date = date;
        this.total = salary + aids + freelance + passiveIncome + others;
        this.salary = salary;
        this.aids = aids;
        this.freelance = freelance;
        this.passiveIncome = passiveIncome;
        this.others = others;
    }

    public StringProperty totalProperty() {
        return formatAmount(total);
    }

    public StringProperty dateProperty() {
        return new SimpleStringProperty(date.format(DATE_FORMAT));
    }

    private SimpleStringProperty formatAmount(float amount) {
        return new SimpleStringProperty(String.format(PRICE_FORMAT, amount));
    }

    public StringProperty salaryProperty() {
        return formatAmount(salary);
    }

    public StringProperty aidsProperty() {
        return formatAmount(aids);
    }

    public StringProperty freelanceProperty() {
        return formatAmount(freelance);
    }

    public StringProperty passiveIncomeProperty() {
        return formatAmount(passiveIncome);
    }

    public StringProperty othersProperty() {
        return formatAmount(others);
    }

    public LocalDate getDate() {
        return date;
    }

    public float getSalary() {
        return salary;
    }

    public float getAids() {
        return aids;
    }

    public float getTotal() {
        return total;
    }


    public float getFreelance() {
        return freelance;
    }

    public float getPassiveIncome() {
        return passiveIncome;
    }

    public float getOthers() {
        return others;
    }

    @Override
    public String toString() {
        return "Income{" +
                "date=" + date +
                ", salary=" + salary +
                ", aids=" + aids +
                ", freelance=" + freelance +
                ", passiveIncome=" + passiveIncome +
                ", others=" + others +
                '}';
    }

    public int compareTo(Income income) {
        return this.date.compareTo(income.date);
    }
}


