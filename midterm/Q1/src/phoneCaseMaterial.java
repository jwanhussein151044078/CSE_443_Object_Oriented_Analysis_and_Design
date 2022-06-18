public enum phoneCaseMaterial {
    aluminum , plastic ;

    @Override
    public String toString() {
        switch (this){
            case plastic:return "plastic";
            case aluminum: return "aluminum";
            default:return null ;
        }
    }
}
