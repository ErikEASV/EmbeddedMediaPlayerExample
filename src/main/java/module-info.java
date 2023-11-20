module com.example.embeddedmediaplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.embeddedmediaplayer to javafx.fxml;
    exports com.example.embeddedmediaplayer;
}