package task2;

public class HouseLoanCalculator extends LoanCalculator {
    private static final int AGE_OF_30 = 30;

    HouseLoanCalculator(int loan){
        super(loan);
    }

    @Override
    int getCalculatedLoan(int age, int income) {
        if (age > AGE_OF_30 && income > getLoan() / 2) {
            increaseLoan(getLoan());
        }
        return IncomeMultiplier.multiply(getLoan(), income);
    }
}
