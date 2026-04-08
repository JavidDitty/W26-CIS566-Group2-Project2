package edu.cis566.group2.project2;

import edu.cis566.group2.project2.room.DeluxeRoom;
import edu.cis566.group2.project2.room.StandardRoom;
import edu.cis566.group2.project2.room.SuiteRoom;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SuiteRoom suiteRoom = new SuiteRoom();
        DeluxeRoom deluxeRoom = new DeluxeRoom();
        StandardRoom standardRoom = new StandardRoom();
        suiteRoom.setSuccessor(deluxeRoom);
        deluxeRoom.setSuccessor(standardRoom);

        FXMLLoader fxmlLoader = new FXMLLoader(HotelApplication.class.getResource("bid.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hotel Room Bidding System");
        stage.setScene(scene);

        HotelController controller = fxmlLoader.getController();
        controller.setHandler(suiteRoom);

        stage.show();
    }
}
