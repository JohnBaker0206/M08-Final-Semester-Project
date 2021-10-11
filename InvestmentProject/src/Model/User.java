package Model;

//Creates User class
public class User {
    
	//My private fields
    private String firstName;
    private String lastName;
    private double assets;
    private double debt;
    private double moneyInHand;
    private double yearlyIncome;

    //Below is my constructor
    public User(String firstName, String lastName, double assets, double debt, double moneyInHand, double yearlyIncome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.assets = assets;
        this.debt = debt;
        this.moneyInHand = moneyInHand;
        this.yearlyIncome = yearlyIncome;
    }

    //Below are my setters and getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAssets() {
        return assets;
    }

    public void setAssets(double assets) {
        this.assets = assets;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public double getMoneyInHand() {
        return moneyInHand;
    }

    public void setMoneyInHand(double moneyInHand) {
        this.moneyInHand = moneyInHand;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }
}
