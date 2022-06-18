/**
 * MATRIX OPERATION CLASS
 */
public class MATRIX_OPERATION {
    /**
     * multiply the row specified by row2 by a non zero number and add the result with the row specified by row1 .
     * @param matrix the matrix .
     * @param row1 Row1 .
     * @param row2 Row2 .
     * @param coff the multiplier .
     * @return return the matrix after the multiplication is done .
     */
    public static Double[][] AddRow(Double[][] matrix , int row1 , int row2 , double coff ){
        int size = matrix[row1].length;
        for(int i = 0 ; i < size ; i++ ){
            matrix[row1][i] += coff*matrix[row2][i];
        }
        return matrix;
    }

    /**
     * convert the given matrix to upper triangular matrix .
     * @param matrix the matrix .
     * @return return the converted matrix .
     */
    public static Double[][] ConvertToUpperTriangular(Double[][] matrix){
       int R = matrix.length;
       int C = matrix[0].length;
       Double temp = -1.0;
       for (int i = 0 ; i<R ; i++){
           if(matrix[i][i] == 0 ){
               for(int j = i+1 ; j < R ; j++){
                    if(matrix[j][i] != 0.0){
                        MATRIX_OPERATION.SwitchRow(matrix,i,j);
                        break;
                    }
               }
           }
           for (int j = i+1 ; j<R ; j++){
               matrix = AddRow(matrix, j, i, -matrix[j][i] / matrix[i][i]);
           }
       }
       return matrix;
    }

    /**
     * converts the given matrix to lower triangular matrix .
     * @param matrix the matrix .
     * @return return the converted matrix .
     */
    public static Double[][] ConvertToLowerTriangular(Double[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        for (int i = 1 ; i<R ; i++){
            for (int j = 0 ; j<i ; j++){
                if(matrix[i][i] != 0.0) {
                    matrix = AddRow(matrix, j, i, -matrix[j][i] / matrix[i][i]);
                }
            }
        }
        return matrix;
    }

    /**
     * print a matrix.
     * @param matrix the matrix.
     * @param message message to be written as a title of the matrix .
     */
    public static void PrintMatrix(Double[][] matrix , String message){
        int R = matrix.length;
        int C = matrix[0].length;

        System.out.printf("%s---------------\n",message);

        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                System.out.printf("%10.2f",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------\n");
    }

    /**
     * Multiply each element in the specified row by multiplier(non_zero) .
     * @param matrix the matrix .
     * @param Row the row number which to be multiplied .
     * @param multiplier the multiplier .
     * @return returns the same matrix but after the specified row was multiplied by the multiplier , or null if the multiplier was zero .
     */
    public static Double[][] MultiplyRow(Double[][] matrix , int Row , double multiplier){
        int R = matrix.length;

        if(R <= Row || multiplier == 0 || Row < 0){
            return null;
        }

        int C = matrix[0].length;
        for(int i = 0 ; i < C ; i++){
            matrix[Row][i] *= multiplier;
        }
        return matrix;
    }

    /**
     * Interchange two rows in the matrix .
     * @param matrix the matrix
     * @param Row1 the number of the first row .
     * @param Row2 the number of the second row .
     * @return returns the same matrix but after interchange the tow rows , null is returned if the row numbers are out of the matrix bound .
     */
    public static Double[][] SwitchRow(Double[][] matrix , int Row1 , int Row2){
        int R = matrix.length;
        int C = matrix[0].length;
        Double temp ;
        if( R <= Row1 || R <= Row2){
            return null ;
        }
        for (int i = 0 ; i < C ;i++ ){
            temp = matrix[Row1][i];
            matrix[Row1][i] = matrix[Row2][i];
            matrix[Row2][i] = temp ;
        }
        return matrix;
    }

    /**
     * returns the value of the matrix's determinant.
     * @param matrix the matrix .
     * @return the value of the matrix's determinant , or null if the matrix is not a square matrix .
     */
    public static Double DeterminantOfMatrix(Double[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        Double res= 1.0;
        Double[][] temp ;
        if(R != C){
            System.out.println("the matrix is not a square matrix can not find determent value !!");
            return null;
        }
        temp = new Double[R][C];
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                temp[i][j] = matrix[i][j];
            }
        }
        temp = MATRIX_OPERATION.ConvertToUpperTriangular(temp);
        for(int i = 0;i<R;i++){
            res *= temp[i][i];
        }
        return res ;
    }

    /**
     * returns the inverse matrix of the matrix given as input .
     * @param matrix the matrix .
     * @return returns the inverse matrix of the matrix given as input ,  or null if the matrix is not a square matrix .
     */
    public static Double[][] InverseOf(Double[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        Double[][] temp , res ;
        Double det ;
        if(R != C){
            return null;
        }
        det = MATRIX_OPERATION.DeterminantOfMatrix(matrix);
        if(det == 0){
            System.out.println("the matrix is not invertable , the value of the matrix determinant is zero !!");
            return null ;
        }

        temp = new Double[R][2*C];
        res = new Double[R][C];

        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                temp[i][j] = matrix[i][j];
                if(i==j){
                    temp[i][j+C] = 1.0;
                }else{
                    temp[i][j+C] = 0.0;
                }
            }
        }
        //MATRIX_OPERATION.PrintMatrix(temp,"temp1");
        temp = MATRIX_OPERATION.ConvertToUpperTriangular(temp);
        temp = MATRIX_OPERATION.ConvertToLowerTriangular(temp);
        //MATRIX_OPERATION.PrintMatrix(temp,"temp2");
        for(int i = 0 ; i < R ; i++){
            if(temp[i][i] != 0.0) {
                temp =MATRIX_OPERATION.MultiplyRow(temp, i, 1.0 / temp[i][i]);
            }

        }
        //MATRIX_OPERATION.PrintMatrix(temp,"temp3");
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                res[i][j] = temp[i][j+C];
            }
        }
        return res ;
    }

    public static Double[][] MatrixMult( Double[][] matrix1 , Double[][] matrix2 ){
        int R1 = matrix1.length;
        int R2 = matrix2.length;
        int C1 = matrix1[0].length;
        int C2 = matrix2[0].length;

        Double[][] res ;
        if(C1 != R2){
            System.out.println("can not multiply the two matrices !!");
            return null ;
        }

        res = new Double[R1][C2];


        for (int i = 0; i < R1; i++) {
            for (int j = 0; j < C2; j++) {
                res[i][j] = 0.0 ;
                for (int k = 0; k < R2; k++){
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return res ;
    }
}
