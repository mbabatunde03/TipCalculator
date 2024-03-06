package bcs.csc311.tipcalculator;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {

    @FXML
    private TextField amountTF;
    @FXML
    private TextField tipTF;
    @FXML
    private TextField totalTF;
    @FXML
    private RadioButton rb15;
    @FXML
    private RadioButton rb20;
    @FXML
    private RadioButton rb25;
    @FXML
    private Button calculateButton;
    private ToggleGroup tipPercentageGroup;

    double tipPercentage = 0;

    public void initialize() {
        tipPercentageGroup = new ToggleGroup();
        this.rb15.setToggleGroup(tipPercentageGroup);
        this.rb20.setToggleGroup(tipPercentageGroup);
        this.rb25.setToggleGroup(tipPercentageGroup);

        rb15.setUserData(15.0);
        rb20.setUserData(20.0);
        rb25.setUserData(25.0);
    }

    @FXML
    private void getSelectedTipPercentage(ActionEvent event) {
        tipPercentage = (double)tipPercentageGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void calculateButtonHandler(ActionEvent event) {
        getSelectedTipPercentage(event);
        String amt = amountTF.getText();
        double amount = Double.parseDouble(amt);
        double tip = amount * tipPercentage / 100;
        double total = amount + tip;
        tipTF.setText(String.format("%.2f", tip));
        totalTF.setText(String.format("%.2f", total));
    }
}