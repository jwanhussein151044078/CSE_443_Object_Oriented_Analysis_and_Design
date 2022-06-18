/**
 * class Global_Phone_Store
 * responsible for sales in the global region .
 */
public class Global_Phone_Store extends Phone_store {
    @Override
    PHONE createPhone(phone_Model model) {
        PHONE ph ;
        switch (model){
            case MaximumEffort:
                ph = new MaximumEffort(new Global_phone_Part_Factory_MaximumEffort_Line());
                ph.setModel(model);
                return ph;
            case IflasDeluxe:
                ph = new IflasDeluxe(new Global_phone_Part_Factory_IflasDeluxe_Line());
                ph.setModel(model);
                return ph;
            case I_I_Aman_Iflas:
                ph = new I_I_Aman_Iflas(new Global_phone_Part_Factory_I_I_Aman_Iflas_Line());
                ph.setModel(model);
                return ph ;
            default: return null;


        }
    }
}
