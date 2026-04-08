package edu.cis566.group2.project2;

import edu.cis566.group2.project2.room.HotelRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HotelController {
    HotelRoom handler;

    @FXML
    private Button bid_btn;

    @FXML
    private TextField bid_field;

    @FXML
    private TextArea outcome_field;

    @FXML
    void handleBid(ActionEvent event) {
        String text = bid_field.getText();
        try {
            float bid_price = Float.parseFloat(text);
            String result = this.handler.handleRequest(bid_price, false);
            outcome_field.setText(result);
        } catch (NumberFormatException e) {
            String message = "ERROR: \"" + text + "\" is not a price!";
            outcome_field.setText(message);
        }
    }

    public void setHandler(HotelRoom handler) {
        this.handler = handler;
    }
}
