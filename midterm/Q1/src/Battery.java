/**
 * Battery interface
 */

public interface Battery {
    /**
     * returns the type of the battery .
     * @return returns the type of the battery .
     */
    public Battery_type getType();

    /**
     * returns the capacity of the battery .
     * @return returns the capacity of the battery .
     */
    public Battery_cap  getCap ();

    /**
     * returns the time of one cycle of the battery in hours .
     * @return returns the time of one cycle of the battery in hours .
     */
    public Battery_time getTime();
}
