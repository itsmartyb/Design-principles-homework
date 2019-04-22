package task2;

public class StudentLoanCalculator extends LoanCalculator {
    private static final int VALUE_OVER_21_YEARS = 150;
    private static final int AGE_OF_21 = 21;

    StudentLoanCalculator(int loan){
        super(loan);
    }

    @Override
    int getCalculatedLoan(int age, int income) {
        if (age >= AGE_OF_21) {
            increaseLoan(VALUE_OVER_21_YEARS);
        }

        return IncomeMultiplier.multiply(getLoan(), income);
    }


}
