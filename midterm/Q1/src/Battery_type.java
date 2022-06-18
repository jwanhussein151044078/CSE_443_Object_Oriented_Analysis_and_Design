public enum Battery_type {
    Lithium_Boron , Lithium_Ion , Lithium_Cobalt;

    @Override
    public String toString() {
        switch (this){
            case Lithium_Boron:return "Lithium_Boron";
            case Lithium_Ion:return "Lithium_Ion";
            case Lithium_Cobalt:return "Lithium_Cobalt";
            default:return null;
        }
    }
}
