package Model;

//Imports my StockType enum
import Enums.StockType;

//Creates class Stock that inherits from Investment
public class Stock extends Investment {
    
	//My private fields
    private String tickerSymbol;
    private StockType stockExchange;
    private double amountOfSharesPurchased;
    private double yearlyDividendPayout;

    //My constructor
    public Stock(double annualAppreciation, double cost, String tickerSymbol,
                 double amountOfSharesPurchased, double yearlyDividendPayout, StockType stockExchange) {
        super(annualAppreciation, cost);
        this.tickerSymbol = tickerSymbol;
        this.amountOfSharesPurchased = amountOfSharesPurchased;
        this.yearlyDividendPayout = yearlyDividendPayout;
        this.stockExchange = stockExchange;
    }

    //My setters and getters
    public StockType getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockType stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public double getAmountOfSharesPurchased() {
        return amountOfSharesPurchased;
    }

    public void setAmountOfSharesPurchased(double amountOfSharesPurchased) {
        this.amountOfSharesPurchased = amountOfSharesPurchased;
    }

    public double getYearlyDividendPayout() {
        return yearlyDividendPayout;
    }

    public void setYearlyDividendPayout(double yearlyDividendPayout) {
        this.yearlyDividendPayout = yearlyDividendPayout;
    }
}
