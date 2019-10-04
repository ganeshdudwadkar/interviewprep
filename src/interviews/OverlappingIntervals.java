package interviews;

// check if the given intervals are overlapping or not
class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public boolean isValid(){
        return this.start <= this.end;
    }
}

public class OverlappingIntervals {

    public boolean isOverlapping(Interval i1, Interval i2){
        if (i1 == null || i2 == null) throw new IllegalArgumentException("Invalid Intervals");
        if (!i1.isValid() || !i2.isValid()) throw new IllegalArgumentException("Invalid Intervals");
        if (i1.start < i2.start){
            return i1.end > i2.start;
        } else {
            return i2.end > i1.start;
        }
    }

    public static void main(String[] args) {
        OverlappingIntervals obj = new OverlappingIntervals();

        System.out.println(obj.isOverlapping(new Interval(7,8), new Interval(2,10)));
        System.out.println(obj.isOverlapping(new Interval(2,5), new Interval(7,8)));
        System.out.println(obj.isOverlapping(new Interval(2,8), new Interval(7,8)));
        System.out.println(obj.isOverlapping(new Interval(7,8), new Interval(2,5)));
        System.out.println(obj.isOverlapping(new Interval(3,8), new Interval(2,10)));
        // System.out.println(obj.isOverlapping(new Interval(8,7), new Interval(2,10)));

    }
}
