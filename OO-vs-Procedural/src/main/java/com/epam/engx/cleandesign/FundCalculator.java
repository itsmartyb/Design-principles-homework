package com.epam.engx.cleandesign;

import java.util.List;

import static com.epam.engx.cleandesign.CalculationUtil.summing;

public class FundCalculator implements IFundCalculator {
    private SalaryCalculator salaryCalculator = new SalaryCalculator();
    private BillCalculator billCalculator = new BillCalculator();

    @Override
    public double getFundBalance(List<Assignment> assignments){
        double salaries = 0.0;
        double bill = 0.0;
        for (Assignment ass : assignments) {
            double totalArea = summing(ass.getZones(), Zone::getZoneArea);
            salaries += (salaryCalculator.calculateSalary(ass.getWorker(), totalArea) + ass.getAssignmentBonus());
            bill += summing(ass.getZones(), Zone::calculateZoneBillPrice);
        }
        return bill - salaries;
    }

    public void setBillCalculator(BillCalculator billCalculator) {
        this.billCalculator = billCalculator;
    }
}
