public class Triangle extends Shape{


    private Dot p1;
    private Dot p2;
    private Dot p3;
    public Triangle (int id ,String color ,double x1, double y1 , double x2,double y2,double x3, double y3) {

        super(id, color);
        this.p1 = new Dot(x1, y1);
        this.p2 = new Dot(x2, y2);
        this.p3 = new Dot(x3, y3);
    }
    public Triangle (int id ,String color ,Dot D1 ,Dot D2 , Dot D3) {

        super(id, color);
        this.p1 = D1;
        this.p2 = D2;
        this.p3 = D3;
    }

    public double area()
    {
        double vector1_x = this.p2.getx() -this.p1.getx() ;
        double vector1_y = this.p2.gety() -this.p1.gety() ;

        double vector2_x = this.p2.getx() -this.p3.getx();
        double vector2_y = this.p2.gety() -this.p3.gety() ;

        double det_result= vector1_x*vector2_y - vector2_x*vector1_y;
        return Math.abs(det_result) / 2;
    }

    public double circumference (){

        double result= this.p1.distance(this.p2);
        result+= this.p2.distance(this.p3);
        result+= this.p3.distance(this.p1);;

        return  result;

    }

    public void move(double axisX, double axisY)
    {
        this.p1.move(axisX, axisY);
        this.p2.move(axisX, axisY);
        this.p3.move(axisX, axisY);
    }


    public Triangle copy(int id, double axisX, double axisY){


        Triangle newTringle=  new Triangle(id, this.getColor(), this.p1.copy(), this.p2.copy(), this.p3.copy());
        newTringle.move(axisX, axisY);
        return newTringle;

    }
    public boolean isInside(double x , double y) {
        Dot pointToCheck = new Dot(x, y);
        int tempID=-1;
        String tempColor="";

        Triangle t1= new Triangle(tempID,tempColor,this.p1, this.p2, pointToCheck);
        Triangle t2= new Triangle(tempID,tempColor,this.p2, this.p3, pointToCheck);
        Triangle t3= new Triangle(tempID,tempColor,this.p3, this.p1, pointToCheck);

        double sumOfAreas=t1.area() + t1.area() +t3.area();
        return (Math.abs(this.area()- sumOfAreas))<= EPSILON;


    }

}