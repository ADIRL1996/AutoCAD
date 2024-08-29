public class Circle extends Ellipse{


    private final double r;

    public  Circle (int id, String color, double x, double y, double radius) {
        super(id,color, x, y, x, y, radius * 2);
        this.r = radius;
    }

    public double circumference()
    {
       return 2 * Math.PI * this.r;
    }

    public Circle copy(int id, double axisX, double axisY)
    {
        Dot center = this.p2.copy();
        Circle newCircle = new Circle(id, this.getColor(), center.getx(), center.gety(),  this.D );
        this.move(axisX, axisY);
        return newCircle;
    }

}
