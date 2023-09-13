/*
 * Robert Fudala
 * 9/8/23
 * Object-Oriented Programming
 * 
 * Determines the area of the walls and ceiling and the 
 * total area of all 8 rectengular studio aprtments that 
 * needs paint and primer. It also determines the ammount
 * and cost of the paint and primer required for the appartments 
 * and the total cost.
 */

//Math.ceil(double num) rounds up

package AppartmentPainterHomework;

public class AppartmentPainterHomework 
{
    public static void main(String[] args)
    {
        //Creates variables of information that is provided
        int numberOfUnits = 8;
        int lengthOfCeiling = 10;
        double longWallsWidth = 32.75;
        double narrowWallsWidth =25.62;
        double windowBankWidth = 14.4;
        double windowBankHeight = 5.5;
        double doorWidth = 3.25;
        double doorHeight = 8;

        //Calculates information that is needed
        double longWallArea = longWallsWidth * lengthOfCeiling;
        double narrowWallArea = narrowWallsWidth * lengthOfCeiling;
        double ceilingArea = longWallsWidth * narrowWallsWidth;
        double windowArea = windowBankWidth * windowBankHeight;
        double doorArea = doorWidth * doorHeight;
        double wallAreaPerUnit = (((longWallArea*2) + (narrowWallArea*2)) - windowArea - doorArea);
        double totalAreaPerUnit = wallAreaPerUnit + ceilingArea;
        double totalAreaToPaintAndPrime = totalAreaPerUnit*numberOfUnits;
        double ammountOfPaintNeeded = (int)Math.ceil(totalAreaToPaintAndPrime/400);
        double ammountOfPrimerNeeded = (int)Math.ceil(totalAreaToPaintAndPrime/300);
        double priceOfPaint = ammountOfPaintNeeded * 34.99;
        double priceOfPrimer = ammountOfPrimerNeeded * 24.49;

        //Prints out the entire appartment painter statement
        System.out.println("**********************************************************");
        System.out.printf("%-40s%10.2f\n", "Wall area per unit", wallAreaPerUnit);
        System.out.printf("%-40s%10.2f\n", "Ceiling area per unit", ceilingArea);
        System.out.printf("%-40s%10.2f\n\n", "Total area to paint and prime", totalAreaToPaintAndPrime);
        System.out.printf("%s%2.0f%s%4.2f%s\n", "You must purchase ", ammountOfPaintNeeded, " gallons of paint for $", priceOfPaint, ".");
        System.out.printf("%s%2.0f%s%4.2f%s\n\n", "You must purchase ", ammountOfPrimerNeeded, " gallons of primer for $", priceOfPrimer, ".");
        System.out.printf("%s%4.2f%s\n", "Your total cost to paint and prime all untis is $", (priceOfPaint + priceOfPrimer), ".");
        System.out.println("**********************************************************");

    }
}
