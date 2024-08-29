public abstract class Shape {

    protected final double EPSILON = 0.00001;
    private final int id;
    private String color;

    public Shape (int id, String color){
        this.id=id;
        this.color=color;

    }


    public int getId(){
        return this.id;
    }

    public String getColor(){
        return this.color;
    }
    public void setColor(String new_color){
         this.color=new_color;
    }


    public abstract void move(double axisX, double axisY);



    public abstract Shape copy(int id, double axisX, double axisY);

    public abstract boolean isInside(double x , double y) ;

    public abstract double circumference();

    public abstract double area ();


  }



