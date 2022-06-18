/**
 * class phone_CPU_RAM
 */
public class phone_CPU_RAM implements CPU_RAM {
    private phoneCORE CORE ;
    private phoneCPU CPU ;
    private phoneRAM RAM ;

    /**
     * class constructor .
     * @param CPU the cpu speed .
     * @param RAM ram size .
     * @param CORE number of cores .
     */
    public phone_CPU_RAM(phoneCPU CPU , phoneRAM RAM , phoneCORE CORE){
        this.CPU = CPU ;
        this.RAM = RAM ;
        this.CORE = CORE ;
    }

    @Override
    public phoneRAM getRAM() {
        return this.RAM;
    }

    @Override
    public phoneCPU getCPU() {
        return this.CPU;
    }

    @Override
    public phoneCORE getCORE() {
        return this.CORE;
    }
}
