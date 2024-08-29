package ex4;
import java.lang.Math;

public class ComplexNumber {

	 private final double real_part;
	 private final double imaginary_part;
	 private static final double EPSILON =0.001;
	
	
	 // Constructor 
    public ComplexNumber (double realPart, double imaginaryPart) {
        this.real_part = realPart;
        this.imaginary_part = imaginaryPart;
    }
	
    
    // gets function
    public double getRealPart() {
        return this.real_part;
    }
    
    public double getImaginaryPart() {
        return this.imaginary_part;
    }    
    
    public double getRadius() {
    	double squareRealPart= real_part*real_part;
    	double squareImaginaryPart= imaginary_part*imaginary_part;
    	double result= Math.sqrt(squareRealPart+squareImaginaryPart);
    	return result;
    }
    
    public double getArgument() {
    	double result=Math.atan2(imaginary_part, real_part);
        return result;
    }
    
    
	
    // sets function

    
   // module function
       
    public ComplexNumber plus(ComplexNumber other) {
    	ComplexNumber new_number = new ComplexNumber(this.real_part + other.real_part, this.imaginary_part + other.imaginary_part);
       	return new_number;
    }
    
    
    public ComplexNumber minus(ComplexNumber other) {
    	ComplexNumber new_number = new ComplexNumber(this.real_part - other.real_part, this.imaginary_part - other.imaginary_part);
       	return new new_number;
    }
    
    
    public ComplexNumber times(ComplexNumber other) {
        return new ComplexNumber(this.real_part * other.real_part - this.imaginary_part * other.imaginary_part,
                                this.real_part * other.imaginary_part + this.imaginary_part * other.real_part);
    }

    
    public ComplexNumber divide(ComplexNumber other) {
    	// builed  the dominator= divisor
        double divisor = other.real_part * other.real_part + other.imaginary_part * other.imaginary_part;
       //calc
        double result_real_part=(this.real_part * other.real_part + this.imaginary_part * other.imaginary_part) / divisor;
        double result_imaginary_part=(this.imaginary_part * other.real_part - this.real_part * other.imaginary_part) / divisor;
        
        return new ComplexNumber(result_real_part,result_imaginary_part);
    }
    
    
    public boolean almostEquals(ComplexNumber other) {
        ComplexNumber difference = this.minus(other);
        double radius = difference.getRadius();
        return radius < EPSILON;
    }
    
    
    public static ComplexNumber fromPolarCoordinates(double radius, double argument) {
        double realPart=radius * Math.cos(argument);
    	double imagPart=radius * Math.sin(argument);
    	return new ComplexNumber(realPart,imagPart);	
    }
    	
    	
    	public string toString( ){
        
    	
    }

}
