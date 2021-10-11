package Views;

//My import libraries
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import Main.Driver;
import Model.User;

//This class will show the home screen of the application
public class Root {
    //Private fields
    private static BorderPane borderPane;
    private GridPane gridPane;
    private Label firstNameLbl, lastNameLbl, assetsLbl, debtLbl, moneyInHandLbl, makeInYearLbl;
    private TextField firstNameTf, lastNameTf, assetsTf, debtTf, moneyInHandTf, makeInYearTf;
    private Button continueBtn;

    //Constructor that will initialize all of the private fields and add them into the grid pane

    public Root() {
        borderPane = new BorderPane();

        gridPane = new GridPane();
        firstNameLbl = new Label("Enter first name: ");
        lastNameLbl = new Label("Enter last name: ");
        assetsLbl = new Label("Assets: ");
        debtLbl = new Label("Debt: ");
        moneyInHandLbl = new Label("Money in hand: ");
        makeInYearLbl = new Label("Make in a year: ");

        firstNameTf = new TextField();
        lastNameTf = new TextField();
        assetsTf = new TextField();
        debtTf = new TextField();
        moneyInHandTf = new TextField();
        makeInYearTf = new TextField();

        continueBtn = new Button("Continue");
        setupThings();
        borderPane.setPadding(new Insets(10));
        borderPane.setCenter(gridPane);
        
        //When the user click continue button
        continueBtn.setOnAction(action -> {
            //Checks to see if there's any empty text fields
            if (firstNameTf.getText().equals("") || lastNameTf.getText().equals("") ||
                    assetsTf.getText().equals("") || debtTf.getText().equals("") ||
                    moneyInHandTf.getText().equals("") || makeInYearTf.getText().equals("")) {
                //Shows error if true
                Driver.showDialog("Please fill all fields", 0);
            } else {
                //If not, it adds data in the object
                Driver.user = new User(firstNameTf.getText(), lastNameTf.getText(),
                        Double.parseDouble(assetsTf.getText()), Double.parseDouble(debtTf.getText()),
                        Double.parseDouble(moneyInHandTf.getText()), Double.parseDouble(makeInYearTf.getText()));
                //Updates the user's net worth
                Driver.NET_WORTH = Double.parseDouble(assetsTf.getText()) - Double.parseDouble(debtTf.getText());
                borderPane.setCenter(new Options());
            }
        });
    }

    //Adds all the data into a grid pane
    private void setupThings() {
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(firstNameLbl, 0, 0);
        gridPane.add(firstNameTf, 1, 0);
        gridPane.add(lastNameLbl, 2, 0);
        gridPane.add(lastNameTf, 3, 0);
        gridPane.add(assetsLbl, 0, 1);
        gridPane.add(assetsTf, 1, 1);
        gridPane.add(debtLbl, 2, 1);
        gridPane.add(debtTf, 3, 1);
        gridPane.add(moneyInHandLbl, 0, 2);
        gridPane.add(moneyInHandTf, 1, 2);
        gridPane.add(makeInYearLbl, 2, 2);
        gridPane.add(makeInYearTf, 3, 2);
        gridPane.add(continueBtn, 3, 3);
    }

    //My setters and getters for my border pane
    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        Root.borderPane = borderPane;
    }

    public static void setAtCenter(Node node) {
        borderPane.setCenter(node);
    }
}
