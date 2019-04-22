package task2;

abstract class LoanCalculator {
    private int loan;

    LoanCalculator(int loan){
        this.loan = loan;
    }

    abstract int getCalculatedLoan(int age, int income);

    int getLoan(){
        return this.loan;
    }

    void increaseLoan(int value){
        this.loan += value;
    }
}
