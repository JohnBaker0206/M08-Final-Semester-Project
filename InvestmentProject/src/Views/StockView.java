package Views;

//My imports
import Enums.StockType;
import Main.Driver;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import Model.Stock;

//This class shows the stock view screen
public class StockView extends GridPane {
    //Private labels , text fields, and buttons
    private Label stockLbl, annualAppreciationLbl, costLbl, tickerSymbolLbl,
            numOfSharesLbl, stockExchangeLbl;
    private TextField annualAppreciationTf, costTf, tickerSymbolTf, numOfSharesTf;
    private RadioButton NYSE, NASDAQ;
    private ToggleGroup tg;
    private Button continueBtn;
    
    //Constructor that will initialize all of the values and set the names of the labels as well as setup all of the items in the grid pane
    public StockView() {
        stockLbl = new Label("Stock");
        stockLbl.setStyle("-fx-font-size: 18;");
        annualAppreciationLbl = new Label("Annual Appreciation: ");
        costLbl = new Label("Cost: ");
        tickerSymbolLbl = new Label("Ticker symbol: ");
        numOfSharesLbl = new Label("Number of shares: ");
        stockExchangeLbl = new Label("Stock Exchange: ");

        annualAppreciationTf = new TextField();
        costTf = new TextField();
        tickerSymbolTf = new TextField();
        numOfSharesTf = new TextField();

        NYSE = new RadioButton("NYSE");
        NASDAQ = new RadioButton("NASDAQ");
        tg = new ToggleGroup();
        NYSE.setToggleGroup(tg);
        NASDAQ.setToggleGroup(tg);

        continueBtn = new Button("Continue");

        setVgap(10);
        setHgap(10);
        setAlignment(Pos.CENTER);

        add(stockLbl, 0, 0);
        add(annualAppreciationLbl, 0, 1);
        add(annualAppreciationTf, 1, 1);
        add(costLbl, 2, 1);
        add(costTf, 3, 1);
        add(tickerSymbolLbl, 0, 2);
        add(tickerSymbolTf, 1, 2);
        add(numOfSharesLbl, 2, 2);
        add(numOfSharesTf, 3, 2);
        add(stockExchangeLbl, 0, 3);
        add(NYSE, 1, 3);
        add(NASDAQ, 2, 3);
        add(continueBtn, 3, 4);

        NYSE.setSelected(true);

        //For when the continue button is bressed
        continueBtn.setOnAction(actionEvent -> {
            //Checks to see if any of the text fields are empty
            if (annualAppreciationTf.getText().equals("") || costTf.getText().equals("") ||
                    tickerSymbolTf.getText().equals("") || numOfSharesTf.getText().equals("")) {
                //Shows error if any of the fields are empty
                Driver.showDialog("Please fill all fields", 0);
            } else {

                //If not, data is added to the object
                if (NYSE.isSelected()) {
                    Driver.stock = new Stock(Double.parseDouble(annualAppreciationTf.getText()),
                            Double.parseDouble(costTf.getText()), tickerSymbolTf.getText(),
                            Double.parseDouble(numOfSharesTf.getText()), 0, StockType.NYSE);
                } else {
                    Driver.stock = new Stock(Double.parseDouble(annualAppreciationTf.getText()),
                            Double.parseDouble(costTf.getText()), tickerSymbolTf.getText(),
                            Double.parseDouble(numOfSharesTf.getText()), 0, StockType.NASDAQ);
                }
                //Calculates the net worth of the user
                Driver.NET_WORTH += calculateNetWorth(Driver.stock.getCost(), Driver.stock.getAnnualAppreciation());
                Root.setAtCenter(new StockResults());
            }
        });

    }

    //Function that calculates the net worth of the User
    private double calculateNetWorth(double cost, double annualAppreciation) {
        double value = (Driver.user.getYearlyIncome() / cost)
                * annualAppreciation;
        return (Driver.user.getMoneyInHand() + value) - Driver.user.getDebt();
    }
}
