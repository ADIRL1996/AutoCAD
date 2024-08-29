public class Rectangle extends Parallelogram{

    public Rectangle (int id ,String color ,double x1, double y1 , double x2,double y2) {
        super(id, color, x1, y1, x1, y2, x2, y2);
    }

    public Rectangle (int id ,String color ,Dot D1, Dot D2) {
        super(id, color, D1, new Dot(D1.getx(), D2.gety()), D2);
    }

    public Rectangle copy(int id, double axisX, double axisY)
    {
        Rectangle newRectangle = new Rectangle(id, this.getColor(), p1.copy(), p2.copy());
        newRectangle.move(axisX, axisY);
        return newRectangle;
    }
}

