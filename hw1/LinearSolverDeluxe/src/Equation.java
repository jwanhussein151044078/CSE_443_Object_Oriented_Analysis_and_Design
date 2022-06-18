import java.util.HashMap;
import java.util.Set;

/**
 *  Equation class
 *
 */
public class Equation {

    private HashMap<String,Double> equation ;
    private int VarNum ;

    /**
     * Class constructor.
     * @param equation a formated string of the form "+a1x1 +a2x2 +.........+anxn +C".
     */
    public Equation(String equation){

        try {
            this.VarNum = 0 ;
            this.equation = this.convertStringTOList(equation.toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * returns the entire map.
     * @return returns the entire map.
     */
    public HashMap<String,Double> getCoefficients(){
        return this.equation;
    }

    /**
     * returns the number of the equation's variables .
     * @return returns the number of the equation's variables .
     */
    public int getVarNum() {
        return VarNum;
    }
    /**
     * Returns the value to which the specified variable is mapped, or null if this map contains no mapping for the variable.
     * @param variable the variable whose associated value is to be returned.
     * @return the value to which the specified variable is mapped, or null if this map contains no mapping for the variable.
     */
    public Double getCoefficientof(String variable){
        return this.equation.get(variable.toLowerCase());
    }

    /**
     * Returns a Set view of the value contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
     * @return a set view of the value contained in this map.
     */
    public Set<String> getVariables(){
        return this.equation.keySet();
    }

    /**
     * return the map which include all variable associated with it's value.
     * @param line a formated string of the form "+a1x1 +a2x2 +.........+anxn +C".
     * @return  return the map which include all variable associated with it's value.
     * @throws Exception if the input is not well formatted .
     */
    private HashMap<String,Double> convertStringTOList(String line)throws Exception{
        HashMap<String,Double> equation = new HashMap<String,Double>();
        String[] tokens = line.split(" ");
        int indexofX = -1 ;
        boolean is_const = false;
        for(int i = 0 ; i < tokens.length ; i++){
            //System.out.println(tokens[i]);
            indexofX = this.IndexOfFirstLetter(tokens[i]);
            if(indexofX == -1){
                if(this.checkConstant(tokens[i])){
                    is_const = true ;
                    equation.put("",-Double.valueOf(tokens[i]));
                }else{
                    throw new Exception("expected input :: \"+a1x1 +a2x2 +.........+anxn +C\".\tactual input : \""+line+"\"");
                }
            }else{
                double temp = 1;
                if(indexofX != 1) {
                    temp = Double.valueOf(tokens[i].substring(0, indexofX));
                }else if (tokens[i].charAt(0) == '-'){
                    temp = -1 ;
                }
                Double coff = temp ;
                String name = tokens[i].substring(indexofX);
                if(this.checkTerm(tokens[i],indexofX)){
                    if(equation.get(name) != null){
                        equation.replace(name,coff+equation.get(name));
                    }else{
                        if(coff != 0) {
                            equation.put(name, coff);
                            this.VarNum++;
                        }

                    }
                }else{
                    throw new Exception("expected input :: \"+a1x1 +a2x2 +.........+anxn +C\".\tactual input : \""+line+"\"");
                }
            }
        }
        if(!is_const){
            equation.put("",0.0);
        }
        return equation ;
    }

    /**
     * checks the constant term , looking for any typo.
     * @param term the term to be checked.
     * @return true if no typo was detected , otherwise false is returned.
     */
    private boolean checkConstant(String term){
        int len = term.length();
        if(term.charAt(0) != '+' && term.charAt(0) != '-'){
            return false;
        }
        for(int i = 1 ; i < len ; i++){
            char ch = term.charAt(i);
            if((ch > '9' || ch < '0')){
                if(ch != '.') {
                    return false;
                }
            }
        }
        return true ;
    }

    /**
     * returns the index of the first letter , which indicate the end of the coefficient and the start of the variable name.if no letter were found then returns -1.
     * if -1 were returned mean no variable were found in the term , so it is treated as a Constant .
     * @param term the term .
     * @return returns the index of the first letter , which indicate the end of the coefficient and the start of the variable name , if no letter were found then returns -1.
     */
    private int IndexOfFirstLetter(String term){
        int len = term.length();
        for (int i = 0 ; i < len ; i++){
            char ch = term.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                return i ;
            }
        }
        return -1 ;
    }

    /**
     * checks a term , looking for any typo.
     * @param term the term to be checked.
     * @param ind the index where the variable name start from .
     * @return true if no typo was detected , otherwise false is returned.
     */
    private boolean checkTerm(String term , int ind){
        int len = term.length();
        String coff = term.substring(0,ind);
        String variablename = term.substring(ind,len);
        if(checkConstant(coff)){
            for(int i = ind ; i < len ; i++){
                char ch = term.charAt(i);
                if(ch < 'a' || ch > 'z' ){
                    return false ;
                }
            }
            return true;
        }
        return false;
    }

    public String toString(){
        return this.equation.toString();
    }
}

