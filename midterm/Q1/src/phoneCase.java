/**
 * class phoneCase .
 */
public class phoneCase implements Case {
    private phoneCaseMaterial material ;
    private phoneCaseSize size ;
    private boolean iswaterproof ;
    private boolean isdustproof ;
    private int waterproofupto ;

    /**
     * class constructor
     * @param material the material of the case .
     * @param size size of the case .
     * @param iswaterproof
     * @param isdustproof
     * @param waterproofupto
     */
    public phoneCase(phoneCaseMaterial material , phoneCaseSize size ,boolean iswaterproof , boolean isdustproof , int waterproofupto  ){
        this.isdustproof = isdustproof;
        this.iswaterproof = iswaterproof ;
        this.material = material ;
        this.size = size ;
        if(iswaterproof) {
            this.waterproofupto = waterproofupto;
        }else{
            this.waterproofupto = 0 ;
        }
    }

    @Override
    public phoneCaseMaterial getMaterial() {
        return this.material;
    }

    @Override
    public phoneCaseSize getSize() {
        return this.size;
    }

    @Override
    public boolean isDustproof() {
        return this.isdustproof;
    }

    @Override
    public boolean iswaterproof() {
        return this.iswaterproof;
    }

    @Override
    public int waterproofUpTo() {
        return this.waterproofupto;
    }
}
