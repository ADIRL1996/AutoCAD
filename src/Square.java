public class Square extends Rectangle{

    public Square (int id ,String color ,double x, double y, double length) {
        super(
                id,
                color,
                x - length / 2,
                y + length / 2,
                x + length / 2,
                y - length / 2
                );
    }
    public Dot getCenter()
    {
        return this.p1.center(this.p3);
    }

    public double getLength()
    {
        return this.p1.distance(this.p4);
    }

    public Square copy(int id, double axisX, double axisY)
    {
        Dot center = this.getCenter();
        Square newSquare = new Square(id, this.getColor(), center.getx(), center.gety(), this.getLength());
        newSquare.move(axisX, axisY);
        return newSquare;
    }


}
