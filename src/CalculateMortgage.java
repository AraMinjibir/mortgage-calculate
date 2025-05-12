public class CalculateMortgage {
    public final static byte percentage = 100;
    private final static byte MONTH_IN_YEAR = 12;
    private int principal;
    private float annualInterestRate;
    public byte years;

    public CalculateMortgage(float annualInterestRate, int principal, byte years) {
        this.annualInterestRate = annualInterestRate;
        this.principal = principal;
        this.years = years;
    }
    public  double calculateMortgage(){
        short numberOfPayment = (short) getNumberOfPayment();
        float monthlyInterestRate = getMonthlyInterestRate();
        double motgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayment)) /
                ( Math.pow(1 + monthlyInterestRate, numberOfPayment) - 1);
        return motgage;
    }

    public   double calculateBalance(
            short numberOfPaymentsMaid){
        short numberOfPayment = (short) getNumberOfPayment();
        float monthlyInterestRate = getMonthlyInterestRate();
        double balance = principal * (Math.pow(1 + monthlyInterestRate, numberOfPayment) -
                Math.pow(1 + monthlyInterestRate, numberOfPaymentsMaid)) / (Math.pow(1 + monthlyInterestRate, numberOfPayment) - 1);

        return balance;
    }
    private int getNumberOfPayment() {
        return years * MONTH_IN_YEAR;
    }
    private float getMonthlyInterestRate() {
        return annualInterestRate / percentage / MONTH_IN_YEAR;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayment()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }
}
