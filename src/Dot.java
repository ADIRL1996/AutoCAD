import java.lang.Math;

public class Dot {

    private double x;
    private double y;

    public Dot (double x, double y ) {
        this.x = x;
        this.y = y;

    }

//get function
    public double getx() {
         return this.x;
    }

    public double gety() {
        return this.y;
    }

    public double distance (Dot other) {

        double temp_x=(this.x - other.x);
        double temp_y=(this.y - other.y);

        double distance_between_point =Math.sqrt(temp_x*temp_x + temp_y*temp_y);
        return distance_between_point;
    }
    public String toString()
    {
    return "(" + this.x + ", " + this.y + ")";
    }

    public Dot center(Dot other)
    {
        return new Dot((this.x + other.getx()) / 2, (this.y + other.gety()) / 2);
    }

    public void move(double axisX, double axisY)
    {
        this.x -= axisX;
        this.y += axisY;
    }


    public Dot copy()
    {
        return new Dot(this.x, this.y);
    }
}
