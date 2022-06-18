public class adaptor implements TurboPayment{
    ModernPayment payment ;

    public adaptor(ModernPayment payment){
        this.payment = payment ;
    }

    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        payment.pay(turboCardNo,turboAmount,destinationTurboOfCourse,installmentsButInTurbo);
        return 0;
    }
}
