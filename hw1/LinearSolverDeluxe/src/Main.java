import java.util.ArrayList;

public class Main {

    public static void main(String[] args){


        LINEARCALCULATOR method = new Matrix_inversion();
        LINEARCALCULATOR method2 = new Gaussian_elimination();

        LinearSystem l = new LinearSystem("src/input.txt",method);
        System.out.println("RESULT\n"+l.calculate());
        l.setCalculationMethod(method2);
        System.out.println("\n\n");
        System.out.println("RESULT\n"+l.calculate());



    }
}
