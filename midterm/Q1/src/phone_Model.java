public enum phone_Model {
    MaximumEffort , IflasDeluxe , I_I_Aman_Iflas ;

    @Override
    public String toString() {
        switch (this){
            case IflasDeluxe:return "IflasDeluxe";
            case MaximumEffort:return "MaximumEffort";
            case I_I_Aman_Iflas:return "I-I-Aman-Iflas";
            default:return null ;
        }
    }
}
