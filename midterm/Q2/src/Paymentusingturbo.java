public class Paymentusingturbo implements TurboPayment {
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("this payment is done using the Turbo system");
        return 0;
    }
}
