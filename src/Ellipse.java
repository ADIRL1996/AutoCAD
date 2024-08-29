import jdk.jshell.spi.ExecutionControl;

public class Ellipse extends Shape {

    private final int N = 10;

    protected Dot p1;
    protected Dot p2;
    protected   double D;
    private double a;
    private double b;

    public Ellipse(int id, String color, double x1, double y1, double x2, double y2, double D) {

        super(id, color);
        this.p1 = new Dot(x1, y1);
        this.p2 = new Dot(x2, y2);
        this.D=D;

        double center = this.p1.distance(p2) / 2;
        this.a = this.D / 2;
        this.b = Math.sqrt(Math.pow(this.D/2, 2) - Math.pow(center, 2));
    }
    public Ellipse(int id, String color, Dot D1, Dot D2, double D)
    {
        super(id, color);
        this.p1 = D1;
        this.p2 = D2;
        this.D = D;

        double center = this.p1.distance(p2) / 2;
        this.a = this.D / 2;
        this.b = Math.sqrt(Math.pow(this.D/2, 2) - Math.pow(center, 2));

    }

    public double area()
    {
        return Math.PI * this.a * this.b;
    }

    private int fact(int n)
    {
       int f = 1;
       for(int i = n; i >= 1;i--)
       {
           f *= i;
       }
       return f;
    }
    private int doubleFact(int n)
    {
       if (n <= 2)
       {
           return n;
       }
       else
       {
            return n * doubleFact(n-2);
       }
    }


    private double  perimaterSeries(){
        double s = 0;
        double h = (this.a - this.b) /(this.a + this.b);
        for(int n = 1; n <= N; n++)
        {//the equation id circumference
            s += Math.pow((this.doubleFact(2 * n -1) / (Math.pow(2, n) * this.fact(n))), 2) *
                    (Math.pow(h, n) / (Math.pow(2 * n - 1, 2)));
        }
        return 0;
    }

    public double circumference()
    {
        return Math.PI * (a + b) *(1 + this.perimaterSeries());
    }

    public void move(double axisX, double axisY)
    {
        this.p1.move(axisX, axisY);
        this.p2.move(axisX, axisY);
    }

    public Ellipse copy(int id, double axisX, double axisY)
    {
        Ellipse newEllipse = new Ellipse(id, this.getColor(), this.p1.copy(), this.p2.copy(), this.D );
        newEllipse.move(axisX, axisY);
        return newEllipse;
    }

    public boolean isInside(double x , double y){
        Dot pointToCheck =new Dot(x,y);

        double sumDistance =this.p1.distance(pointToCheck);
        sumDistance+= this.p2.distance(pointToCheck);
        System.out.println("dist: " + sumDistance);
        if (this.D - sumDistance >= EPSILON){
            return true;
        }
        return  false;
    }




}