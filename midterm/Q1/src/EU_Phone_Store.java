/**
 * class EU_Phone_Store
 */
public class EU_Phone_Store extends Phone_store {
    @Override
    PHONE createPhone(phone_Model model) {
        PHONE ph;
        switch (model){
            case MaximumEffort:
                ph = new MaximumEffort(new EU_phone_Part_Factory_MaximumEffort_Line());
                ph.setModel(model);
                return ph;
            case IflasDeluxe:
                ph = new IflasDeluxe(new EU_phone_Part_Factory_IflasDeluxe_Line());
                ph.setModel(model);
                return ph;
            case I_I_Aman_Iflas:
                ph = new I_I_Aman_Iflas(new EU_phone_Part_Factory_I_I_Aman_Iflas_Line());
                ph.setModel(model);
                return ph ;
            default: return null;
        }
    }
}
