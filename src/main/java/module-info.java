module com.example.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires java.xml;
    requires org.yaml.snakeyaml;


    opens com.example.lab3 to javafx.fxml;
    opens com.example.lab3.parsers to org.yaml.snakeyaml;
    exports com.example.lab3;
    exports com.example.lab3.parsers;
    exports com.example.lab3.reactor;
    opens com.example.lab3.reactor to org.yaml.snakeyaml;
}