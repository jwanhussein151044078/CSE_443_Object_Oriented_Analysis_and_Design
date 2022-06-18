public class PAymentusingModern implements ModernPayment{

    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("this payment is done using the Modern system");
        return 0 ;
    }
}
