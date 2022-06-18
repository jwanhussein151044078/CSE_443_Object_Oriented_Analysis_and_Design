import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * the Gaussian elimination class
 */
public class Gaussian_elimination implements LINEARCALCULATOR{
    /**
     * returns a map which include the solution of the linear system , or null if no solution where found .
     * @param system array of Equation ,the system to be calculated .
     * @return returns a map which include the solution of the linear system , or null if no solution where found .
     */
    @Override
    public HashMap<String, Double> Findsolution(ArrayList<Equation> system) {
        System.out.println("this calcuation is done using Gaussian elimination method !!");
        Double[][] matrix ;
        int row , column ,counter=0;
        HashSet<String> variables = new HashSet<>();  // the set that will contains every variable in the system
        HashMap<String,Double> solution ;
        row = system.size();
        for(int i = 0 ; i < row ; i++){
            variables.addAll(system.get(i).getVariables());
        }
        column = variables.size();
        if(row != column-1){
            System.out.println("the number of variable and the number of equations are not matched!!\nthe system can not be solved using Gaussian elimination method!!");
            System.out.println(system);
            return null;
        }
        matrix = new Double[row][column];
        Iterator<String> it = variables.iterator();
        while(it.hasNext()){
            String var = it.next();
            if(var.length()!=0){
                for (int i = 0; i < row; i++) {
                    Double coff = system.get(i).getCoefficientof(var);
                    if (coff != null) {
                        matrix[i][counter] = coff;
                    } else {
                        matrix[i][counter] = 0.0;
                    }
                }
            }else{
                for (int i = 0; i < row; i++) {
                    Double coff = system.get(i).getCoefficientof(var);
                    if (coff != null) {
                        matrix[i][column-1] = coff;
                    } else {
                        matrix[i][column-1] = 0.0;
                    }
                }
                counter--;
            }
            counter++;
        }
        MATRIX_OPERATION.PrintMatrix(matrix,"MATRIX");

        MATRIX_OPERATION.ConvertToUpperTriangular(matrix);

        MATRIX_OPERATION.PrintMatrix(matrix,"UPPER TRIANGULAR MATRIX");

        MATRIX_OPERATION.ConvertToLowerTriangular(matrix);
        MATRIX_OPERATION.PrintMatrix(matrix,"DIAGONAL MATRIX");

        /* convert the matrix to a diagonal matrix  */
        for(int i = 0 ; i < row ; i++){
            if(matrix[i][i] != 0.0) {
                MATRIX_OPERATION.MultiplyRow(matrix, i, 1.0 / matrix[i][i]);
            }
        }
        MATRIX_OPERATION.PrintMatrix(matrix,"RESULTANCE MATRIX");
        /* check  */
        for(int i = 0 ; i < row ; i++){
            if(matrix[i][i] == 0 && matrix[i][column-1] != 0) {
                System.out.println("Gaussian elimination method could not find a solution for the linear system !!");
                return null;
            }
            for(int j = 0 ; j < row ; j++){
                if(j!=i && matrix[i][j] != 0){
                    System.out.println("Gaussian elimination method could not find a solution for the linear system !!");
                    return null;
                }
            }
        }

        it = variables.iterator();
        counter = 0;
        solution = new HashMap<String, Double>();
        while (it.hasNext()){
            String var = it.next();
            if(!var.equals("")){
                solution.put(var,matrix[counter][column-1]);
                counter++;
            }
        }
        return solution;
    }

}
