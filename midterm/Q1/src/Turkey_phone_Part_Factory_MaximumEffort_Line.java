/**
 * class Turkey_phone_Part_Factory_MaximumEffort_Line .
 * responsible for produce components for the MaximumEffort model in turkey .
 */
public class Turkey_phone_Part_Factory_MaximumEffort_Line implements Phone_Parts_Factory{
    @Override
    public Display produce_Display() {
        return new phone_Display(screenSize._5_5,screenBit._24);
    }

    @Override
    public Battery produce_Battery() {
        return new phone_Battery(Battery_type.Lithium_Cobalt,Battery_cap._3600,Battery_time._27);
    }

    @Override
    public CPU_RAM produce_CPU_RAM() {
        return new phone_CPU_RAM(phoneCPU._2_8,phoneRAM._8,phoneCORE._8);
    }

    @Override
    public Storage produce_Storage() {
        return new phoneStorage(phoneSupport._64 , phoneMAXsupport._64);
    }

    @Override
    public Camera produce_Camera() {
        return new phoneCamera(phoneFrontcam._12 , phoneRearcam._8,phoneCamZoom._3);
    }

    @Override
    public Case produce_Case() {
        return new phoneCase(phoneCaseMaterial.aluminum ,phoneCaseSize._151x73x7_7 ,true , true , 100 );
    }
}
