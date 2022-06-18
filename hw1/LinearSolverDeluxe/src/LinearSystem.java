import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * LinearSystem class .
 */
public class LinearSystem {
    private ArrayList<Equation> system ;
    private LINEARCALCULATOR cal ;
    private int EquationNum ;

    /**
     * Class constructor.
     * @param File the file wich contains the system .
     * @param method the method that will be used to calculate the solution .
     */
    public LinearSystem(String File , LINEARCALCULATOR method){
        this.cal = method ;
        this.EquationNum = 0 ;
        this.system = this.ReadFile(File);
    }

    /**
     * Class constructor.
     * @param File the file wich contains the system .
     */
    public LinearSystem(String File){
        this.EquationNum = 0 ;
        this.system = this.ReadFile(File);
    }

    /**
     * returns the solution as a map object , where each variable of the system is assigned to it's value.
     * @return returns the solution as a map object , where each variable of the system is assigned to it's value.
     */
    public HashMap<String, Double> calculate(){
        return cal.Findsolution(this.system);
    }

    /**
     *  set the calculation method .
     * @param method the method that will be used to calculate the solution .
     */
    public void setCalculationMethod(LINEARCALCULATOR method){
        this.cal = method ;
    }

    /**
     * reteuns an ArrayList of Equations which represents the system .
     * @return reteuns an ArrayList of Equations which represents the system .
     * @see Equation .
     */
    public ArrayList<Equation> getSystem(){
        return this.system;
    }

    /**
     *
     * @param FileName
     * @return
     */
    private ArrayList<Equation> ReadFile(String FileName){
        ArrayList<Equation> temp = new ArrayList<Equation>();
        try {
            File myObj = new File(FileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(line.length()>0) {
                    temp.add(new Equation(line));
                }
                this.EquationNum++ ;
            }
            myReader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return temp ;
    }

}
