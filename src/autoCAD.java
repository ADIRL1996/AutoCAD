import java.util.HashMap;
import java.util.Scanner;

public class autoCAD {

    private HashMap<Integer,Shape> shapes;
    private int avilibleID;
    public autoCAD(){

        this.avilibleID=0;
        this.shapes= new HashMap<Integer,Shape>();
    }

    public void run(){
        Scanner reader =new Scanner(System.in);

        while (true) {
            String line= reader.nextLine();
            line= line.toLowerCase();
            String[] lineArray = line.split(" ");
            try {
                if (lineArray[0].equals("exit"))
                    break;
                else if (lineArray[0].equals("new")) {
                    this.createNewShape(lineArray);


                } else if (lineArray[0].equals("move")) {
                    this.move(lineArray);

                } else if (lineArray[0].equals("copy")) {
                    this.copy(lineArray);

                } else if (lineArray[0].equals("area")) {
                    this.area(lineArray);

                } else if (lineArray[0].equals("color")) {
                    this.changeColor(lineArray);

                } else if (lineArray[0].equals("is_inside")) {
                    this.isInside(lineArray);

                } else if (lineArray[0].equals("circumference")) {
                    this.circumference(lineArray);

                } else if (lineArray[0].equals("delete")) {
                    int id = Integer.parseInt(lineArray[1]);
                    this.shapes.remove(id);
                }
            }
            catch (Exception e)
            {
                System.out.println("wrong!");
                System.out.println(e.getCause());
            }
        }




    }
    // lineArray hold the command splited i.e.[command , Shape , color ...]
    private void createNewShape (String [] lineArray){
        Shape newShape = null;
        String Color = lineArray[2];
        if(lineArray[1].equals("ellipse")) {
            double x1 = Double.parseDouble(lineArray[3]),y1 = Double.parseDouble(lineArray[4]);
            double x2 = Double.parseDouble(lineArray[5]),y2 = Double.parseDouble(lineArray[6]);
            double D = Double.parseDouble(lineArray[7]);
            newShape  = new Ellipse(this.avilibleID,Color, x1, y1, x2, y2, D);
        }
        else if (lineArray[1].equals("circle")) {
            double x = Double.parseDouble(lineArray[3]), y = Double.parseDouble(lineArray[4]);
            double r = Double.parseDouble(lineArray[5]);
            newShape = new Circle(this.avilibleID, Color, x, y, r);
        }
        else if(lineArray[1].equals("triangle")) {
            double x1 = Double.parseDouble(lineArray[3]) , y1 = Double.parseDouble(lineArray[4]);
            double x2= Double.parseDouble(lineArray[5]) , y2 = Double.parseDouble(lineArray[6]);
            double x3 = Double.parseDouble(lineArray[7]),  y3 = Double.parseDouble(lineArray[8]);
            newShape = new Triangle(this.avilibleID, Color, x1, y1, x2, y2, x3, y3);
        }
        else if(lineArray[1].equals("parallelogram"))
        {
            double x1 = Double.parseDouble(lineArray[3]) ,  y1 = Double.parseDouble(lineArray[4]);
            double x2 = Double.parseDouble(lineArray[5]),   y2 = Double.parseDouble(lineArray[6]);
            double x3 = Double.parseDouble(lineArray[7]),  y3 = Double.parseDouble(lineArray[8]);
            newShape = new Parallelogram(this.avilibleID, Color, x1, y1, x2, y2, x3, y3);
        }
        else if (lineArray[1].equals("rectangle")) {
            double x1 = Double.parseDouble(lineArray[3]) , y1 = Double.parseDouble(lineArray[4]);
            double x2 = Double.parseDouble(lineArray[5]) , y2 = Double.parseDouble(lineArray[6]);
            newShape = new Rectangle(this.avilibleID, Color, x1, y1, x2, y2);
        }
        else if(lineArray[1].equals("square")) {
            double x1 = Double.parseDouble(lineArray[3]), y1 = Double.parseDouble(lineArray[4]);
            double l = Double.parseDouble(lineArray[5]);
            newShape = new Square(this.avilibleID, Color, x1, y1, l);
        }
        else {
            System.out.println("wrong command");
            return;
        }
        this.shapes.put(this.avilibleID, newShape);
        System.out.println(this.avilibleID);
        this.avilibleID++;
    }

    private void move(String[] lineArray)// lineArray hold the command splited i.e.[command , id ...]
    {
        int id  = Integer.parseInt(lineArray[1]);
        double axisX = Double.parseDouble(lineArray[2]);
        double axisY = Double.parseDouble(lineArray[3]);
        this.shapes.get(id).move(axisX, axisY);
    }

    private  void copy(String[] lineArray) // lineArray hold the command splited i.e.[command , id ...]
    {
        int id  = Integer.parseInt(lineArray[1]);
        double axisX = Double.parseDouble(lineArray[2]);
        double axisY = Double.parseDouble(lineArray[3]);

        Shape copyShape=this.shapes.get(id).copy(avilibleID,axisX, axisY);
        this.shapes.put(this.avilibleID,copyShape);
        System.out.println(this.avilibleID);
        avilibleID++;

    }

    private  void area(String[] lineArray){// lineArray hold the command splited i.e.[command , color]

        double sumOfAreas=0;
        for (Integer key : shapes.keySet()) {
            Shape currentShape = shapes.get(key);
            if(currentShape.getColor().equals(lineArray[1]))
            {
                sumOfAreas+= currentShape.area();
            }
        }

        System.out.printf("%.2f\n", sumOfAreas);
    }

    private  void circumference(String[] lineArray){// lineArray hold the command splited i.e.[command , color]

        double sumOfPerimeter=0;
        for (Integer key : shapes.keySet()) {
            Shape currentShape = shapes.get(key);
            if(currentShape.getColor().equals(lineArray[1]))
            {
                sumOfPerimeter+= currentShape.circumference();
            }
        }

        System.out.printf("%.2f\n", sumOfPerimeter);
    }



    private  void changeColor(String[] lineArray){// lineArray hold the command splited i.e.[command , color ...]

        int id =Integer.parseInt(lineArray[2]);
        Shape currentShape=shapes.get(id);
        currentShape.setColor(lineArray[1]);

    }


    private  void isInside(String[] lineArray){ // lineArray hold the command splited i.e.[command , color ...]

        int id =Integer.parseInt(lineArray[1]);
        double x = Double.parseDouble(lineArray[2]);
        double y = Double.parseDouble(lineArray[3]);
        Shape currentShape=shapes.get(id);
        if(currentShape.isInside(x, y))
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }
    }

}
