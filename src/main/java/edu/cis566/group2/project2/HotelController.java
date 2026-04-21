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
        // 2. HotelController receives the user's bid price (i.e., $300)
        //    from the bid field (on the GUI) after the user presses the bid button.
        String text = bid_field.getText();
        try {
            float bid_price = Float.parseFloat(text);

            // 3. HotelController calls the first handler's (SuiteRoom)
            //    request handler method (SuiteRoom.handleBid) to process the bid.
            String result = this.handler.handleBid(bid_price, false);

            // 10. HotelController displays the message returned from the last handler (StandardRoom)
            //     to the user in the GUI's outcome text area, which now says "We are sold out!"
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
