import java.text.NumberFormat;

public class CalculatePayment {

    private byte years;
    private int principal;
    private float annualInterestRate;
    private CalculateMortgage calculator;

    public CalculatePayment(float annualInterestRate, int principal, byte years) {
        this.annualInterestRate = annualInterestRate;
        this.principal = principal;
        this.years = years;

    }

       public  void printPaymentSchedule() {
           calculator = new CalculateMortgage((float) (annualInterestRate), (int) (principal), (byte) (years));
           System.out.println();
           System.out.println("PAYMENTS SCHEDULED");
           System.out.println("------------------");
           for (double balance : calculator.getRemainingBalances())
           System.out.println(NumberFormat.getCurrencyInstance().format(balance));

       }

    public void printMotgage() {
        var calculator = new CalculateMortgage((float) (annualInterestRate),(int) (principal),(byte) (years));
        double motgage = calculator.calculateMortgage();
        String motgageFormatted = NumberFormat.getCurrencyInstance().format(motgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + motgageFormatted);
    }
}
