/**
 * interface Phone_Parts_Factory.
 * abstract phone components factory .
 */
public interface Phone_Parts_Factory {
    /**
     * produce a Display tool .
     * @return Display object.
     */
    public  Display produce_Display();

    /**
     * produce the Battery of the phone .
     * @return battery object .
     */
    public  Battery produce_Battery();

    /**
     * produce CPU&RAM .
     * @return return the CPU&RAM object .
     */
    public  CPU_RAM produce_CPU_RAM();

    /**
     * produce the Storage component .
     * @return return a Storage object .
     */
    public  Storage produce_Storage();

    /**
     * produce the Camera of the phone .
     * @return Camera object .
     */
    public  Camera  produce_Camera ();

    /**
     * produce the Case of the phone .
     * @return Case object .
     */
    public  Case    produce_Case   ();
}
