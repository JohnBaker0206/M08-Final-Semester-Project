package Views;

//Import JavaFX
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

//Creates a screen that will display a button for either Stock or Real Estate
public class Options extends GridPane {
    //Creates label
    private Label whereToInvest;
    //Creates button
    private Button stock, realEstate;

    //Constructor that initializes all the variables and sets private fields in the grid pane
    
    public Options() {
        whereToInvest = new Label("Where do you want to Invest?");
        whereToInvest.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        stock = new Button("Stock");
        realEstate = new Button("Real Estate");

        stock.setPrefWidth(180);
        stock.setPrefHeight(75);

        realEstate.setPrefWidth(180);
        realEstate.setPrefHeight(75);

        stock.setStyle("-fx-font-size: 15px");
        realEstate.setStyle("-fx-font-size: 15px");

        add(whereToInvest, 0, 0);
        add(stock, 0, 1);
        add(realEstate, 1, 1);

        setAlignment(Pos.CENTER);
        setHgap(15);
        setVgap(15);
        
        //If the real estate button is clicked, it will show the real estate screen
        realEstate.setOnAction(actionEvent -> {
            Root.setAtCenter(new RealEstateView());
        });
        //If the stock button is clicked, it will show the stock screen
        stock.setOnAction(actionEvent -> {
            Root.setAtCenter(new StockView());
        });
    }

}
