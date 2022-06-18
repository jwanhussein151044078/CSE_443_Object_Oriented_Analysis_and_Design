import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */
public class Matrix_inversion implements LINEARCALCULATOR {
    /**
     * returns a map which include the solution of the linear system , or null if no solution where found .
     * @param system array of Equation ,the system to be calculated .
     * @return returns a map which include the solution of the linear system , or null if no solution where found .
     */
    @Override
    public HashMap<String, Double> Findsolution(ArrayList<Equation> system) {
        System.out.println("this calcuation is done using Matrix inversion method !!");
        Double[][] A , inverseA ;
        Double[][] B , result;
        Double detA ;
        HashMap<String,Double> res ;
        int row , column , counter=0;
        HashSet<String> variables = new HashSet<>();  // the set that will contains every variable in the system
        row = system.size();
        for(int i = 0 ; i < row ; i++){
            variables.addAll(system.get(i).getVariables());
        }
        column = variables.size();
        if(row != column-1){
            System.out.println("the number of variable and the number of equations are not matched!!\nthe system can not be solved using matrix inversion method!!");
            System.out.println(system);
            return null;
        }
        A = new Double[row][column-1];
        B = new Double[row][1];
        Iterator<String> it = variables.iterator();
        while(it.hasNext()){
            String var = it.next();
            if(var.length()!=0){
                for (int i = 0; i < row; i++) {
                    Double coff = system.get(i).getCoefficientof(var);
                    if (coff != null) {
                        A[i][counter] = coff;
                    } else {
                        A[i][counter] = 0.0;
                    }
                }
            }else{
                for (int i = 0; i < row; i++) {
                    Double coff = system.get(i).getCoefficientof(var);
                    if (coff != null) {
                        B[i][0] = coff;
                    } else {
                        B[i][0] = 0.0;
                    }
                }
                counter--;
            }
            counter++;
        }
        MATRIX_OPERATION.PrintMatrix(A,"A");
        MATRIX_OPERATION.PrintMatrix(B,"B");

        inverseA = MATRIX_OPERATION.InverseOf(A);
        if(inverseA == null){
            System.out.println("the matrix is not invertable , can not find solution !!");
            return null ;
        }
        MATRIX_OPERATION.PrintMatrix(inverseA,"inverseA");

        result = MATRIX_OPERATION.MatrixMult(inverseA,B);
        MATRIX_OPERATION.PrintMatrix(result,"result");
        res = new HashMap<String, Double>();
        it = variables.iterator();
        counter = 0;
        while(it.hasNext()){
            String var = it.next();
            if(!var.equals("")){
                res.put(var,result[counter][0]);
                counter++;
            }
        }
        return res;
    }
}
