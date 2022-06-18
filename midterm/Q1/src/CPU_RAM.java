public interface CPU_RAM {
    /**
     * returns the RAM size .
     * @return returns the RAM size .
     */
    public phoneRAM  getRAM();

    /**
     * returns the CPU clock speed .
     * @return returns the CPU clock speed .
     */
    public phoneCPU  getCPU();

    /**
     * returns the number of cores in the CPU .
     * @return returns the number of cores in the CPU .
     */
    public phoneCORE getCORE();
}
