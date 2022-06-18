/**
 * class phone_Display
 */
public class phone_Display implements Display {
    private screenSize Size ;
    private screenBit  Bit ;

    /**
     * class constructor .
     * @param size the size of the screen .
     * @param bit the bit of the screen .
     */
    public phone_Display(screenSize size , screenBit bit){
        this.Size = size ;
        this.Bit = bit ;
    }
    @Override
    public screenSize getInches() {
        return this.Size;
    }

    @Override
    public screenBit getBit() {
        return this.Bit;
    }
}
