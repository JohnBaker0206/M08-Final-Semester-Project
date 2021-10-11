package Views;

//Imports
import Enums.RealEstateType;
import Main.Driver;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import Model.RealEstate;

//Class that shows RealEstate screen
public class RealEstateView extends GridPane {
    //Private fields labels , text files, and buttons
    private Label realEstateLbl, annualAppreciationLbl, costLbl, cashFLowLbl, typeLbl;
    private TextField annualAppreciationTf, costTf, cashFlowTf;
    private RadioButton residential, commercial;
    private ToggleGroup tg;
    private Button continueBtn;

    //Constructor that will initialize all the values and set the names of the label then setup all the things in the grid pane
    public RealEstateView() {
        realEstateLbl = new Label("Real Estate");
        realEstateLbl.setStyle("-fx-font-size: 18;");
        annualAppreciationLbl = new Label("Annual Appreciation: ");
        costLbl = new Label("Cost: ");
        typeLbl = new Label("Type of Real Estate: ");
        cashFLowLbl = new Label("Cash Flow: ");
        cashFlowTf = new TextField();

        annualAppreciationTf = new TextField();
        costTf = new TextField();

        residential = new RadioButton("Residential");
        commercial = new RadioButton("Commercial");
        tg = new ToggleGroup();
        residential.setToggleGroup(tg);
        commercial.setToggleGroup(tg);

        continueBtn = new Button("Continue");

        setVgap(10);
        setHgap(10);
        setAlignment(Pos.CENTER);

        add(realEstateLbl, 0, 0);
        add(annualAppreciationLbl, 0, 1);
        add(annualAppreciationTf, 1, 1);
        add(costLbl, 0, 2);
        add(costTf, 1, 2);
        add(cashFLowLbl, 2, 2);
        add(cashFlowTf, 3, 2);
        add(typeLbl, 0, 3);
        add(residential, 1, 3);
        add(commercial, 2, 3);
        add(continueBtn, 2, 4);

        residential.setSelected(true);
        //Action for when the user presses continue
        continueBtn.setOnAction(actionEvent -> {
            //Checks to see if any of the fields were left empty
            if (annualAppreciationTf.getText().equals("") || costTf.getText().equals("") ||
                    cashFlowTf.getText().equals("")) {
                //Shows error if any are empty
                Driver.showDialog("Please fill all fields", 0);
            } else {
                //If not, it will add data in the object
                if (residential.isSelected()) {
                    Driver.realEstate = new RealEstate(Double.parseDouble(annualAppreciationTf.getText()),
                            Double.parseDouble(costTf.getText()), RealEstateType.RESIDENTIAL,
                            Double.parseDouble(cashFlowTf.getText()));
                } else {
                    Driver.realEstate = new RealEstate(Double.parseDouble(annualAppreciationTf.getText()),
                            Double.parseDouble(costTf.getText()), RealEstateType.COMMERCIAL,
                            Double.parseDouble(cashFlowTf.getText()));
                }
                //Update the User money in hand
                double money = Driver.user.getMoneyInHand();
                Driver.user.setMoneyInHand(money + Driver.realEstate.getCashFlow());
                //Calculates the net worth and saves it
                Driver.NET_WORTH += calculateNetWorth(Driver.realEstate.getCost(), Driver.realEstate.getAnnualAppreciation());
                //Shows the next window
                Root.setAtCenter(new Results());
            }
        });
    }

    //Function used to calculate net worth
    public static double calculateNetWorth(double cost, double annualAppreciation) {
        double value = (Driver.user.getYearlyIncome() / cost)
                * annualAppreciation;
        return (Driver.user.getMoneyInHand() + value) - Driver.user.getDebt();
    }

}
