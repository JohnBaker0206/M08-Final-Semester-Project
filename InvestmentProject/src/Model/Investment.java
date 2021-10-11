package Model;

 //Below is my investment Super class for the Stock and Real Estate

public class Investment {
	//My private fields
    private double annualAppreciation;
    private double cost;

    //Constructor
    public Investment(double annualAppreciation, double cost) {
        this.annualAppreciation = annualAppreciation;
        this.cost = cost;
    }

    //Setters and getters
    public double getAnnualAppreciation() {
        return annualAppreciation;
    }

    public void setAnnualAppreciation(double annualAppreciation) {
        this.annualAppreciation = annualAppreciation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
