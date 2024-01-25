import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator {
    private List<Wall> walls;

    public PaintCalculator() {
        this.walls = new ArrayList<>();
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }

    public void calculateTotal() {
        double totalPaintArea = 0;
        double totalCost = 0;

        for (Wall wall : walls) {
            double wallPaintArea = wall.calculatePaintArea();
            double wallCost = wall.calculateCost();
            int cansRequired = (int) wall.calculateCansRequired();
            //PROBLEM: CALCULATES WALL INDEPENDENTLY SOLVE WITH HASHMAP OR SOMETHING
            //CAUSE KEY VALUE
            //OR FIX PROBLEM BY MAKING AN ARRAYLIST THAT CHECKS IF THERe'S A DUPLICATE PAINT NAME
            //shits out wall colour, paint area, cans required and cost of painting the wall itself
            System.out.println("Wall (" + wall.getColour() + "): Paint Area = " + wallPaintArea + ", " + cansRequired +
                    " cans required, Cost = " + wallCost);
            totalPaintArea += wallPaintArea;
            totalCost += wallCost;
        }

        System.out.println("Total Paint Area: " + totalPaintArea);
        System.out.println("Total Cost: " + totalCost);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to my paint calculator program!");
        Scanner scanner = new Scanner(System.in);
        PaintCalculator calculator = new PaintCalculator();

        System.out.println("Enter the number of walls to be painted:");
        int numberOfWalls = -1;
        while (numberOfWalls <= 0) {
            if (scanner.hasNextInt()) {
                numberOfWalls = scanner.nextInt();
                if (numberOfWalls <= 0) {
                    System.out.println("Please enter a positive number:");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value:");
                scanner.next();
            }
        }
        scanner.nextLine();

        for (int i = 0; i < numberOfWalls; i++) {
            System.out.println("Wall " + (i + 1) + ":");
            double height = -1, width = -1, subtractArea = -1, pricePerCan = -1, volumePerCan = -1, coveragePerLitre = -1;
            int numberOfCoats = 0;

            height = readPositiveDouble(scanner, "Enter height: ");
            width = readPositiveDouble(scanner, "Enter width: ");
            subtractArea = readNonNegativeDouble(scanner, "Enter number of objects to be subtracted from the wall(for windows, doors, etc.): ");
            if (subtractArea!=0) {
                subtractArea = ShapeCalculator.calculateSubtractArea();
            }
            else{
                subtractArea=0;
            }
            if (subtractArea>(height*width)){
                System.out.println("Error, the object is bigger than the wall.");
                break;
            }
            numberOfCoats = readPositiveInt(scanner, "Enter number of coats: ");
            String colour = readString(scanner, "Enter colour: ");
            pricePerCan = readPositiveDouble(scanner, "Enter price per can: ");
            volumePerCan = readPositiveDouble(scanner, "Enter volume (in litres) per can: ");
            coveragePerLitre = readPositiveDouble(scanner, "Enter area coverage per litre: ");

            calculator.addWall(new Wall(height, width, colour, pricePerCan, volumePerCan, subtractArea, numberOfCoats, coveragePerLitre));
        }

        scanner.close();
        calculator.calculateTotal();
    }
    private static double readPositiveDouble(Scanner scanner, String prompt) {
        double value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Please enter a positive value:");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value:");
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
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

    private static int readPositiveInt(Scanner scanner, String prompt) {
        int value = 0;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("Please enter a positive number:");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value:");
                scanner.next();
            }
        }
        scanner.nextLine();
        return value;
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
/*
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PaintCalculator calculator = new PaintCalculator();

        System.out.println("Enter the number of walls to be painted:");
        int numberOfWalls = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfWalls; i++) {
            System.out.println("Wall " + (i + 1) + ":");

            System.out.print("Enter height: ");
            double height = scanner.nextDouble();

            System.out.print("Enter width: ");
            double width = scanner.nextDouble();

            scanner.nextLine();

            System.out.println("Enter number of objects to be subtracted from the wall(for windows, doors, etc.): ");
            double subtractArea = ShapeCalculator.calculateSubtractArea();

            System.out.print("Enter number of coats: ");
            int numberOfCoats = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Enter colour: ");
            String colour = scanner.nextLine();

            System.out.print("Enter price per can: ");
            double pricePerCan = scanner.nextDouble();

            System.out.print("Enter volume (in litres) per can: ");
            double volumePerCan = scanner.nextDouble();

            System.out.print("Enter area coverage per litre: ");
            double coveragePerLitre = scanner.nextDouble();

            scanner.nextLine();

            calculator.addWall(new Wall(height, width, colour, pricePerCan, volumePerCan, subtractArea, numberOfCoats, coveragePerLitre));
        }

        scanner.close();

        calculator.calculateTotal();

    }
 */
}