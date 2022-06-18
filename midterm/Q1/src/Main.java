public class Main {

    public static void main(String[] args) {
        Phone_store trstore = new Turkey_Phone_Store();
        Phone_store eustore = new EU_Phone_Store();
        Phone_store globalstore = new Global_Phone_Store();

        trstore.orderPhone(phone_Model.IflasDeluxe);
        eustore.orderPhone(phone_Model.IflasDeluxe);
        globalstore.orderPhone(phone_Model.IflasDeluxe);
        System.out.println("\n");

        trstore.orderPhone(phone_Model.MaximumEffort);
        eustore.orderPhone(phone_Model.MaximumEffort);
        globalstore.orderPhone(phone_Model.MaximumEffort);
        System.out.println("\n");

        trstore.orderPhone(phone_Model.I_I_Aman_Iflas);
        eustore.orderPhone(phone_Model.I_I_Aman_Iflas);
        globalstore.orderPhone(phone_Model.I_I_Aman_Iflas);





    }
}
