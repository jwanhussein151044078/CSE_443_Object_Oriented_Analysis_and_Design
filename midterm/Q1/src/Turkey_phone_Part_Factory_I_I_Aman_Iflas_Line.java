/**
 * class Turkey_phone_Part_Factory_I_I_Aman_Iflas_Line .
 * responsible for produce components for the I_I_Aman_Iflas model in turkey .
 */
public class Turkey_phone_Part_Factory_I_I_Aman_Iflas_Line implements Phone_Parts_Factory{
    @Override
    public Display produce_Display() {
        return new phone_Display(screenSize._4_5,screenBit._24);
    }

    @Override
    public Battery produce_Battery() {
        return new phone_Battery(Battery_type.Lithium_Cobalt,Battery_cap._2000,Battery_time._16);
    }

    @Override
    public CPU_RAM produce_CPU_RAM() {
        return new phone_CPU_RAM(phoneCPU._2_2,phoneRAM._4,phoneCORE._4);
    }

    @Override
    public Storage produce_Storage() {
        return new phoneStorage(phoneSupport._16 , phoneMAXsupport._32);
    }

    @Override
    public Camera produce_Camera() {
        return new phoneCamera(phoneFrontcam._8 , phoneRearcam._5,phoneCamZoom._3);
    }

    @Override
    public Case produce_Case() {
        return new phoneCase(phoneCaseMaterial.plastic ,phoneCaseSize._143x69x7_3 ,true , false , 100 );
    }
}