module adamobrien.javashopimageeditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens adamobrien.javashopimageeditor to javafx.fxml;
    exports adamobrien.javashopimageeditor;
}