import java.util.Scanner;

public class ShapeCalculator {
    public static double calculateSubtractArea() {
        Scanner scanner = new Scanner(System.in);
        double totalArea = 0.0;

        //System.out.print("Enter the number of shapes to calculate: ");
        //int numberOfShapes = scanner.nextInt();
        int numberOfShapes = readNonNegativeInt(scanner, "Enter the number of shapes to calculate: ");

        for (int i = 0; i < numberOfShapes; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            System.out.println("Select the shape type:");
            System.out.println("1. Quadrilateral (e.g., Window)");
            System.out.println("2. Circle (e.g., Round Vent)");
            System.out.println("3. Triangle (e.g., Decorative Element)");
            System.out.println("4. Trapezoid (e.g., Angled Window)");
            System.out.println("5. Ellipse (e.g., Oval Decorative Element)");
            System.out.println("6. An object you know the area of (e.g., Something that is oddly shaped)");
            //int choice = scanner.nextInt();
            int choice = readNonNegativeInt(scanner,"");
            if (choice>6){
                System.out.println("Invalid input. Please enter a value from 1-6:");
                choice = readNonNegativeInt(scanner,"");
            }

            switch (choice) {
                case 1: // quadrilateral
                    //System.out.print("Enter width: ");
                    //double width = scanner.nextDouble();
                    double width = readNonNegativeDouble(scanner,"Enter width: ");
                    //System.out.print("Enter height: ");
                    //double height = scanner.nextDouble();
                    double height = readNonNegativeDouble(scanner,"Enter height: ");
                    totalArea += width * height;
                    break;
                case 2: // Circle
                    //System.out.print("Enter radius: ");
                    //double radius = scanner.nextDouble();
                    double radius = readNonNegativeDouble(scanner,"Enter radius: ");
                    totalArea += Math.PI * radius * radius;
                    break;
                case 3: // Triangle
                    //System.out.print("Enter base: ");
                    //double base = scanner.nextDouble();
                    double base = readNonNegativeDouble(scanner,"Enter base: ");
                    //System.out.print("Enter height: ");
                    //double triangleHeight = scanner.nextDouble();
                    double triangleHeight = readNonNegativeDouble(scanner,"Enter height: ");
                    totalArea += 0.5 * base * triangleHeight;
                    break;
                case 4: // Trapezoid
                    //System.out.print("Enter base 1 length: ");
                    //double base1 = scanner.nextDouble();
                    double base1 = readNonNegativeDouble(scanner,"Enter base 1 length: ");
                    //System.out.print("Enter base 2 length: ");
                    //double base2 = scanner.nextDouble();
                    double base2 = readNonNegativeDouble(scanner,"Enter base 2 length: ");
                    //System.out.print("Enter height: ");
                    //double trapezoidHeight = scanner.nextDouble();
                    double trapezoidHeight = readNonNegativeDouble(scanner,"Enter height: ");
                    totalArea += 0.5 * (base1 + base2) * trapezoidHeight;
                    break;
                case 5: // Ellipse
                    //System.out.print("Enter semi-major axis length: ");
                    //double semiMajorAxis = scanner.nextDouble();
                    double semiMajorAxis = readNonNegativeDouble(scanner,"Enter semi-major axis length: ");
                    //System.out.print("Enter semi-minor axis length: ");
                    //double semiMinorAxis = scanner.nextDouble();
                    double semiMinorAxis = readNonNegativeDouble(scanner,"Enter semi-minor axis length: ");
                    totalArea += Math.PI * semiMajorAxis * semiMinorAxis;
                    break;
                case 6: // Direct Input
                    //System.out.print("Enter the area of the object: ");
                    //double objectArea = scanner.nextDouble();
                    double objectArea = readNonNegativeDouble(scanner,"Enter the area of the object: ");
                    totalArea += objectArea;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        return totalArea;
    }
    private static double readNonNegativeDouble(Scanner scanner, String prompt) {
        double value = -1;
        while (value < 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value < 0) {
                    System.out.println("Please enter a non-negative value:");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value:");
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }
    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        int value = -1;
        while (value < 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("Please enter a non-negative value:");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value:");
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }
}