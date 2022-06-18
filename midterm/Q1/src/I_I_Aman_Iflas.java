/**
 * class I_I_Aman_Iflas
 */
public class I_I_Aman_Iflas extends PHONE {
    private Phone_Parts_Factory factory ;

    /**
     * class constructor .
     * @param factory abstract factory method .
     */
    public I_I_Aman_Iflas(Phone_Parts_Factory factory){
        this.factory = factory ;
    }

    @Override
    public void prepare() {
        System.out.println("preparing "+this.getModel());
        display = factory.produce_Display();
        cpu_ram = factory.produce_CPU_RAM();
        storage = factory.produce_Storage();
        _cam    = factory.produce_Camera();
        _case   = factory.produce_Case();
        battery = factory.produce_Battery();
    }
}
