public interface Case {
    /**
     * return the material of the case .
     * @return return the material of the case .
     */
    public phoneCaseMaterial getMaterial();

    /**
     * returns the size of the case .
     * @return returns the size of the case .
     */
    public phoneCaseSize getSize();

    /**
     * returns true if the case is dustproof , false if not .
     * @return returns true if the case is dustproof , false if not .
     */
    public boolean isDustproof();

    /**
     * returns true if the case is waterproof , false if not .
     * @return returns true if the case is waterproof , false if not .
     */
    public boolean iswaterproof();

    /**
     * return the water resistance in CM.
     * @return return the water resistance in CM.
     */
    public int waterproofUpTo();
}
