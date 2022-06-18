import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {
    North , South , East , West , NorthEast , NorthWest , SouthEast , SouthWest;

    private static final List<Direction> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();


    @Override
    public String toString() {
        switch (this){
            case North:return "North";
            case South:return "South";
            case East :return "East";
            case West :return "West";
            case NorthEast:return "NorthEast";
            case NorthWest:return "NorthWest";
            case SouthEast:return "SouthEast";
            case SouthWest:return "SouthWest";
            default:return null;
        }
    }

    public static Direction getDirection(Direction direction){
        if(direction == null){
            return VALUES.get(RANDOM.nextInt(SIZE));
        }else if (direction == Direction.East || direction == Direction.West || direction == Direction.South || direction == Direction.North){
            Direction temp = VALUES.get(RANDOM.nextInt(SIZE));
            while(temp.toString().contains(direction.toString())){
                temp = VALUES.get(RANDOM.nextInt(SIZE));
            }
            return temp ;
        }else if(direction == Direction.NorthEast || direction == Direction.NorthWest || direction == Direction.SouthEast || direction == Direction.SouthWest ){
            Direction temp = VALUES.get(RANDOM.nextInt(SIZE));
            while(direction.toString().contains(temp.toString())){
                temp = VALUES.get(RANDOM.nextInt(SIZE));
            }
            return temp ;
        }
        return Direction.East;
    }
}
