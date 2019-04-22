package com.epam.engx.cleandesign;

public class SalaryCalculator implements ISalaryCalculator {

    private static final double SENIOR_SALARY_FACTOR = 1.2;

    @Override
    public Double calculateSalary(Worker worker, Double area) {
        int days = (int) Math.ceil(area / worker.getAmountPerDay());
        double baseSalary = worker.getDailyRate() * days;
        if (worker.isJunior())
            return baseSalary;
        return baseSalary * SENIOR_SALARY_FACTOR;
    }
}
