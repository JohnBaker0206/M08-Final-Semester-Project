package Views;

import Main.Driver;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

//This class shows the Stock result screen to the user
public class StockResults extends GridPane {
    //My private field labels and buttons
    private Label firstNameLbl, lastNameLbl, assetsLbl, debtLbl, moneyInHandLbl, makeInYearLbl;
    private Label annualAppreciationLbl, costLbl, tickerSymbolLbl,
            numOfSharesLbl, stockExchangeLbl, netWorthLbl;
    private Button simulation;

    //Constructor that initializes all of the values and adds them to the grid pane.
    public StockResults() {
        firstNameLbl = new Label("First name: " + Driver.user.getFirstName());
        firstNameLbl.setStyle("-fx-font-size: 16px;");

        lastNameLbl = new Label("Last name: " + Driver.user.getLastName());
        lastNameLbl.setStyle("-fx-font-size: 16px;");

        assetsLbl = new Label("Assets: " + String.valueOf(Driver.user.getAssets()));
        assetsLbl.setStyle("-fx-font-size: 16px;");

        debtLbl = new Label("Debt: " + String.valueOf(Driver.user.getDebt()));
        debtLbl.setStyle("-fx-font-size: 16px;");

        moneyInHandLbl = new Label("Money in hand: " + Driver.user.getMoneyInHand());
        moneyInHandLbl.setStyle("-fx-font-size: 16px;");

        makeInYearLbl = new Label("Make in year: " + Driver.user.getYearlyIncome());
        makeInYearLbl.setStyle("-fx-font-size: 16px;");

        annualAppreciationLbl = new Label("Annual Appreciation: " + Driver.stock.getAnnualAppreciation());
        annualAppreciationLbl.setStyle("-fx-font-size: 16px;");

        costLbl = new Label("Cost: " + Driver.stock.getCost());
        costLbl.setStyle("-fx-font-size: 16px;");

        tickerSymbolLbl = new Label("Ticker symbol: " + Driver.stock.getTickerSymbol());
        tickerSymbolLbl.setStyle("-fx-font-size: 16px;");

        numOfSharesLbl = new Label("Number of shares: " + Driver.stock.getAmountOfSharesPurchased());
        numOfSharesLbl.setStyle("-fx-font-size: 16px;");

        stockExchangeLbl = new Label("Stock Exchange: " + Driver.stock.getStockExchange());

        netWorthLbl = new Label("Net Worth: " + String.format("%.3f", Driver.NET_WORTH));
        netWorthLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        simulation = new Button("Simulation");


        setVgap(10);
        setHgap(10);
        setAlignment(Pos.CENTER);

        add(firstNameLbl, 0, 0);
        add(lastNameLbl, 1, 0);
        add(assetsLbl, 0, 1);
        add(debtLbl, 1, 1);
        add(moneyInHandLbl, 0, 2);
        add(makeInYearLbl, 1, 2);
        add(annualAppreciationLbl, 0, 3);
        add(costLbl, 1, 3);
        add(tickerSymbolLbl, 0, 4);
        add(numOfSharesLbl, 1, 4);
        add(stockExchangeLbl, 2, 4);
        add(netWorthLbl,0,5);
        add(simulation, 1, 6);
        
        //Calls the doSimulation function when the user hits the simulation button
        simulation.setOnAction(actionEvent -> {
            doSimulation();
        });

    }

  //This function does the calculations again and updates the results of the labels such as money in hand, cash flow, and cost
    public void doSimulation() {
        Driver.stock.setAnnualAppreciation(Double.parseDouble(annualAppreciationLbl.getText().split(" ")[2]));
        Driver.stock.setCost(Double.parseDouble(costLbl.getText().split(" ")[1]));
        Driver.NET_WORTH += RealEstateView.calculateNetWorth(Driver.stock.getCost(),
                Driver.stock.getAnnualAppreciation());
        netWorthLbl.setText("Net worth: " + String.format("%.3f", Driver.NET_WORTH));
    }
}
