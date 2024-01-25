public class Wall {
    private double height;
    private double width;
    private String colour;
    private double pricePerCan;
    private double volumePerCan;
    private double subtractArea;
    private int numberOfCoats;
    private double coveragePerLitre;

    public Wall(double height, double width, String colour, double pricePerCan, double volumePerCan, double subtractArea, int numberOfCoats, double coveragePerLitre) {
        this.height = height;
        this.width = width;
        this.colour = colour;
        this.pricePerCan = pricePerCan;
        this.volumePerCan = volumePerCan;
        this.subtractArea = subtractArea;
        this.numberOfCoats = numberOfCoats;
        this.coveragePerLitre= coveragePerLitre;
    }

    public double calculatePaintArea() {
        return (height * width - subtractArea) * numberOfCoats;
    }

    public double calculateCansRequired() {
        double paintArea = calculatePaintArea();
        return (int) Math.ceil(paintArea / volumePerCan*coveragePerLitre);
    }

    public double calculateCost() {

        return calculateCansRequired() * pricePerCan;
    }

    public String getColour() {

        return colour;
    }
}
