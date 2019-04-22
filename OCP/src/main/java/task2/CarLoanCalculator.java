package task2;


public class CarLoanCalculator extends LoanCalculator {
    private static final int VALUE_OVER_50_YEARS = 1500;
    private static final int VALUE_OVER_30_YEARS = 1000;
    private static final int AGE_OF_30 = 30;
    private static final int AGE_OF_50 = 50;

     CarLoanCalculator(int loan){
       super(loan);
     }

     @Override
     int getCalculatedLoan(int age, int income) {
         if (age > AGE_OF_50) {
             increaseLoan(VALUE_OVER_50_YEARS);
         } else if (age > AGE_OF_30) {
             increaseLoan(VALUE_OVER_30_YEARS);
         }
         return IncomeMultiplier.multiply(getLoan(), income);
     }
}
