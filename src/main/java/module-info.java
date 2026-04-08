module edu.cis566.group2.project2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.cis566.group2.project2 to javafx.fxml;
    exports edu.cis566.group2.project2;
}