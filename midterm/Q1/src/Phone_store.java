/**
 * abstract class Phone_store
 */
public abstract class Phone_store {
    /**
     * the method is responsible for creating a phone
     * it mean that it is asking for the phone components from the abstract factory depending on the phone model and the region .
     * @param model phone model .
     * @return
     */
    abstract PHONE createPhone(phone_Model model);

    /**
     *
     * @param model phone model .
     */
    void orderPhone(phone_Model model){
        PHONE phone = createPhone(model);
        if(phone != null) {
            phone.prepare();
            phone.attach_CPU_RAM();
            phone.attach_Display();
            phone.attach_Battery();
            phone.attach_Storage();
            phone.attach_Camera();
            phone.enclose_Phone_Case();
        }
    }
}
