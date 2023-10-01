/*
 * Robert Fudala
 * 9/25/2023
 * 
 * Prints a welcome banner and then asks the user
 * which shape they would like to compute.
 * When they choose a shape the program asks for 
 * the nessecary information in order to 
 * compute the area and perimeter of the shape
 * that was chosen. It repeats until the user quits
 * and then prints a thank you message.
 */

package ShapeCalculatorProgram;
import java.util.Scanner;

public class ShapeCalculator 
{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        //Prints out the welcome banner
        printWelcomeBanner(); 

        //Asks the user for a shape to enter and takes that input 
        //and puts it into the while loop
        System.out.print("Enter C for circle, R for rectangle, or T for triangle: ");
        String response = scan.nextLine().trim().toUpperCase();

        /* This while loop goes until the user enters Q to quit
         * but otherwise it computes the shape the user has asked for
         * with the user given information.
         * If the shape is invalid then it will tell the user
         * it is an invalid shape.
         */
        while (!(response.equals("Q")))
        {
            if (response.equals("C"))
            {
                System.out.print("Enter the radius: ");
                double radius = scan.nextDouble();
                scan.nextLine();
                System.out.printf("The area of the circle is %.2f, and the circumference is %.2f.\n",computeCircleArea(radius) ,computeCircleCircumference(radius));
            }
            else if (response.equals("R"))
            {
                System.out.print("Enter the length and width: ");
                double length = scan.nextDouble();
                double width = scan.nextDouble();
                scan.nextLine();
                System.out.printf("The area of the rectangle is %.2f, and the perimeter is %.2f.\n", computeRectangleArea(length,width), computeRectanglePerimeter(length, width));
            }
            else if (response.equals("T"))
            {
                System.out.print("Enter the lengths of the three sides: ");
                double side1,side2,side3;
                side1 = scan.nextDouble();
                side2 = scan.nextDouble();
                side3 = scan.nextDouble();
                scan.nextLine();
                System.out.printf("The area of the triangle is %.2f, and the perimeter is %.2f.\n", computeTriangleArea(side1,side2,side3), computeTrianglePerimeter(side1,side2,side3));
            }
            else
                System.out.println("That is not a recognized shape.");
            System.out.print("Enter C for circle, R for rectangle, or T for triangle: ");
            response = scan.nextLine().trim().toUpperCase();
        }
        //Prints a thank you message when the user quits out of the loop
        System.out.println("Thank you for using Shape Calculator!");
    }
    
    /**
     * 
     * @param radius is the radius of the circle
     * @return returns the area of a circle
     * with the radius given from the parameter
     * as a double
     */
    public static double computeCircleArea(double radius)
    {
        return (Math.pow(radius,2) * Math.PI);
    }
    /**
     * 
     * @param radius is the radius of the circle
     * @return returns the circumference of a circle
     * with the radius given from the parameter
     * as a double
     */
    public static double computeCircleCircumference(double radius)
    {
        return ((radius*2)*Math.PI);
    }
    /**
     * 
     * @param length is the length of the rectangle
     * @param width is the width of the rectangle
     * @return returns the area of a rectangle
     * with the length and width given from the parameters
     * as a double
     */
    public static double computeRectangleArea(double length, double width)
    {
        return (length*width);
    }
    /**
     * 
     * @param length is the length of the rectangle
     * @param width is the width of the rectangle
     * @return returns the perimeter of a rectangle 
     * with the length and width given from the parameters
     * as a double
     */
    public static double computeRectanglePerimeter(double length, double width)
    {
        return ((2*length) + (2*width));
    }
    /**
     * 
     * @param side1 is the first side of the triangle
     * @param side2 is the second side of the triangle
     * @param side3 is the third side of the triangle
     * @return returns the area for a triangle 
     * with the 3 sides that were given as parameters
     * as a double
     */
    public static double computeTriangleArea(double side1, double side2, double side3)
    {
        double s = ((side1+side2+side3)/2);
        return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
    }
    /**
     * 
     * @param side1 is the first side of the triangle
     * @param side2 is the second side of the triangle
     * @param side3 is the third side of the triangle
     * @return returns the perimeter for a triangle 
     * with the 3 sides that were given as parameters
     * as a double
     */
    public static double computeTrianglePerimeter(double side1, double side2, double side3)
    {
        return (side1+side2+side3);
    }
    /**
     * Prints out the welcome banner with no parameters or return
     */
    public static void printWelcomeBanner()
    {
        String star = "*";
        System.out.println(star.repeat(65));
        System.out.printf("%39s\n", "SHAPE CALCULATOR");
        System.out.println(star.repeat(65));
        System.out.println();
    }
}
