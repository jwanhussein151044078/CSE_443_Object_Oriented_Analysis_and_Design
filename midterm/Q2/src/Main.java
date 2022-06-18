public class Main {

    public static void main(String[] args) {
        TurboPayment t = new Paymentusingturbo();
        t.payInTurbo(null,0,null,null);
        System.out.println("\n");
        TurboPayment m = new adaptor(new PAymentusingModern());
        m.payInTurbo(null,0,null,null);

    }
}
