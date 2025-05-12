public class Main {

    public static void main(String[] args) {
       int principal = (int) Console.readNumber( "principal:", 1000, 1_000_000);
       float annualInterestRate = (float) Console.readNumber( "annualInterestRate:", 1, 30);
       byte years = (byte) Console.readNumber( "Period (years):", 1, 10);

       var mortgage = new CalculateMortgage((float) annualInterestRate, (int) principal, (byte) years);
       mortgage.calculateMortgage();
       new CalculatePayment((int) principal,(int)
               (annualInterestRate), (byte) years).printMotgage();

       var payment = new CalculatePayment(principal,(int) (annualInterestRate), years);
        payment.printPaymentSchedule();
    }


}


