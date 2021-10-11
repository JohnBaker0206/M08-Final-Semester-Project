package Model;

//Import my RealEstateType enum
import Enums.RealEstateType;

//Creates RealEstate class that inherits from Investment class
public class RealEstate extends Investment {
    
	//My private fields
    private RealEstateType realEstateType;
    private double cashFlow;

    //My constructor
    public RealEstate(double annualAppreciation, double cost,
                      RealEstateType realEstateType, double cashFlow) {
        super(annualAppreciation, cost);
        this.realEstateType = realEstateType;
        this.cashFlow = cashFlow;
    }

    //My setters and getters
    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }

    public double getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(double cashFlow) {
        this.cashFlow = cashFlow;
    }
}
