package Views;

//My imports
import Main.Driver;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

//Class that will show the result page
public class Results extends GridPane {
    // Private fields labels and button
    private Label firstNameLbl, lastNameLbl, assetsLbl, debtLbl, moneyInHandLbl, makeInYearLbl;
    private Label annualAppreciationLbl, costLbl, cashFLowLbl, typeLbl, netWorthLbl;
    private Button simulation;

    //Constructor that will initialize all the private fields and set the names of the labels and add them into the grid pane

    public Results() {
        firstNameLbl = new Label("First name: " + Driver.user.getFirstName());
        firstNameLbl.setStyle("-fx-font-size: 16px;");

        lastNameLbl = new Label("Last name: " + Driver.user.getLastName());
        lastNameLbl.setStyle("-fx-font-size: 16px;");

        assetsLbl = new Label("Assets: " + Driver.user.getAssets());
        assetsLbl.setStyle("-fx-font-size: 16px;");

        debtLbl = new Label("Debt: " + Driver.user.getDebt());
        debtLbl.setStyle("-fx-font-size: 16px;");

        moneyInHandLbl = new Label("Money in hand: " + Driver.user.getMoneyInHand());
        moneyInHandLbl.setStyle("-fx-font-size: 16px;");

        makeInYearLbl = new Label("Make in year: " + Driver.user.getYearlyIncome());
        makeInYearLbl.setStyle("-fx-font-size: 16px;");

        annualAppreciationLbl = new Label("Annual Appreciation: " + Driver.realEstate.getAnnualAppreciation());
        annualAppreciationLbl.setStyle("-fx-font-size: 16px;");

        costLbl = new Label("Cost: " + Driver.realEstate.getCost());
        costLbl.setStyle("-fx-font-size: 16px;");

        cashFLowLbl = new Label("Cash flow: " + Driver.realEstate.getCashFlow());
        cashFLowLbl.setStyle("-fx-font-size: 16px;");

        typeLbl = new Label("Type: " + Driver.realEstate.getRealEstateType());
        typeLbl.setStyle("-fx-font-size: 16px;");

        netWorthLbl = new Label("Net worth: " + String.format("%.3f", Driver.NET_WORTH));
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
        add(cashFLowLbl, 0, 4);
        add(typeLbl, 1, 4);
        add(netWorthLbl, 0, 5);
        add(simulation, 1, 6);
        
        //Calls the doSimulation function when the simulation button is pressed
        simulation.setOnAction(actionEvent -> {
            doSimulation();
        });

    }

    //This function does the calculations again and updates the results of the labels such as money in hand, cash flow, and cost
    public void doSimulation() {
        Driver.realEstate.setCashFlow(Double.parseDouble(cashFLowLbl.getText().split(" ")[2]));
        Driver.realEstate.setAnnualAppreciation(Double.parseDouble(annualAppreciationLbl.getText().split(" ")[2]));
        Driver.realEstate.setCost(Double.parseDouble(costLbl.getText().split(" ")[1]));
        Driver.NET_WORTH += RealEstateView.calculateNetWorth(Driver.realEstate.getCost(),
                Driver.realEstate.getAnnualAppreciation());
        double money = Driver.user.getMoneyInHand();
        Driver.user.setMoneyInHand(money + Driver.realEstate.getCashFlow());
        moneyInHandLbl.setText("Money in hand: " + Driver.user.getMoneyInHand());
        netWorthLbl.setText("Net worth: " + String.format("%.3f", Driver.NET_WORTH));
    }

}
