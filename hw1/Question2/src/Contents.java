/**
 * Contents Enumerator .
 */
public enum Contents {
    Text ,
    Photograph ,
    Audio ;

    public String toString(){
        switch(this){
            case Text :
                return "Text";

            case Photograph:
                return "Photograph";

            case Audio :
                return "Audio";

            default: return "Unknown!!" ;

        }
    }
}
