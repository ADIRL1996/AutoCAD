
public class Parallelogram extends Shape {


    protected Dot p1;
    protected Dot p2;
    protected Dot p3;
    protected Dot p4;




    public Parallelogram (int id ,String color ,double x1, double y1 , double x2,double y2,double x3, double y3) {

        super(id, color );
        this.p1 = new Dot(x1,y1);
        this.p2 = new Dot(x2,y2);
        this.p3 = new Dot(x3,y3);
        this.p4 = find_fourth();// calc the fourth point.

    }

    public Parallelogram (int id ,String color ,Dot D1, Dot D2 , Dot D3 ) {

        super(id, color );
        this.p1 = D1;
        this.p2 = D2;
        this.p3 = D3;
        this.p4 = find_fourth();// calc the fourth point.

    }
   private Dot find_fourth()
   {
        Dot fourth_point = new Dot(
                                this.p3.getx()+(this.p1.getx()- this.p2.getx()),
                                this.p3.gety()+(this.p1.gety() - this.p2.gety())
                                );
        return  fourth_point;
   }


    public double area (){ // TODO code duplication

        double vector1_x = this.p2.getx() -this.p1.getx() ;
        double vector1_y = this.p2.gety() -this.p1.gety() ;

        double vector2_x = this.p2.getx() -this.p3.getx();
        double vector2_y = this.p2.gety() -this.p3.gety() ;

        double det_result= vector1_x*vector2_y - vector2_x*vector1_y;

        return Math.abs(det_result);
    }

    public double circumference (){
        double result= p1.distance(p2);
        result+= p2.distance(p3);
        result*=2;
        return  result;

    }

    public void move(double axisX, double axisY)
    {
        this.p1.move(axisX, axisY);
        this.p2.move(axisX, axisY);
        this.p3.move(axisX, axisY);
        this.p4.move(axisX, axisY);
    }


    public Parallelogram copy(int id, double axisX, double axisY)
    {
        Parallelogram newParallelogram = new Parallelogram(id, this.getColor(), p1.copy(), p2.copy(),p3.copy());
        newParallelogram.move(axisX, axisY);
        return newParallelogram;
    }

    public boolean isInside(double x , double y) {
        Dot pointToCheck = new Dot(x, y);
        int tempID = -1;
        String tempColor = "";
        Triangle t1=new Triangle(tempID,tempColor,this.p1,this.p2 ,this.p3);
        Triangle t2=new Triangle(tempID,tempColor,this.p1,this.p4 ,this.p3);
        boolean isInside= t1.isInside(x,y) || t2.isInside(x,y) ;
        return isInside;
    }



}
