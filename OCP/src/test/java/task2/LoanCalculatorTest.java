package task2;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoanCalculatorTest {

    @Test
    public void studentLoanForYoungPoorPerson() {
        assertThat(new StudentLoanCalculator(100).getCalculatedLoan(18, 100), is(100));
    }

    @Test
    public void studentLoanForOldPerson() {
        assertThat(new StudentLoanCalculator(100).getCalculatedLoan(21, 100), is(250));
    }

    @Test
    public void studentLoanForRichPerson() {
        assertThat(new StudentLoanCalculator(100).getCalculatedLoan(18, 2_000), is(200));
    }

    @Test
    public void carLoanForYoungPoorPerson() {
        assertThat(new CarLoanCalculator(2000).getCalculatedLoan(20, 500), is(2_000));
    }

    @Test
    public void carLoanForAdultPoorPerson() {
        assertThat(new CarLoanCalculator(2000).getCalculatedLoan(45, 500), is(3_000));
    }

    @Test
    public void carLoanForOldPoorPerson() {
        assertThat(new CarLoanCalculator(2000).getCalculatedLoan(60, 500), is(3_500));
    }

    @Test
    public void carLoanForYoungRichPerson() {
        assertThat(new CarLoanCalculator(2000).getCalculatedLoan(20, 2_000), is(4_000));
    }

    @Test
    public void carLoanForAdultRichPerson() {
        assertThat(new CarLoanCalculator(2000).getCalculatedLoan(45, 2_000), is(6_000));
    }

    @Test
    public void carLoanForOldRichPerson() {
        assertThat(new CarLoanCalculator(2000).getCalculatedLoan(60, 2_000), is(7_000));
    }

    @Test
    public void houseLoanForYoungPoorPerson() {
        assertThat(new HouseLoanCalculator(100000).getCalculatedLoan(20, 500), is(100_000));
    }

    @Test
    public void houseLoanForOldPoorPerson() {
        assertThat(new HouseLoanCalculator(100000).getCalculatedLoan(60, 500), is(100_000));
    }

    @Test
    public void houseLoanForYoungRichPerson() {
        assertThat(new HouseLoanCalculator(100000).getCalculatedLoan(20, 65_000), is(200_000));
    }

    @Test
    public void houseLoanForOldRichPerson() {
        assertThat(new HouseLoanCalculator(100000).getCalculatedLoan(60, 65_000), is(400_000));
    }
}
