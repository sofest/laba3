package com.example.lab3;

import com.example.lab3.parsers.Parser;
import com.example.lab3.reactor.Reactor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Button importBut;

    @FXML
    private TreeView<String> treeReactors;

    @FXML
    void importFile(ActionEvent event) {

        try {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);
            Parser parser = new Parser(file);
            buildtree(parser.getReactorArrayList());
        } catch (Exception e) {
            error();
        }
    }

    public void buildtree(ArrayList<Reactor> reactorArrayList) {

        TreeItem<String> root = new TreeItem<>("Error");
        if (reactorArrayList.size() != 0) {

            root = new TreeItem<>("Reactors");

            for (Reactor reactor : reactorArrayList) {

                TreeItem<String> branch = new TreeItem<>(reactor.getName());

                TreeItem<String> leaf1 = new TreeItem<>("name : " + reactor.getName());
                TreeItem<String> leaf2 = new TreeItem<>("burnup : " + reactor.getBurnup());
                TreeItem<String> leaf3 = new TreeItem<>("kpd : " + reactor.getKpd());
                TreeItem<String> leaf4 = new TreeItem<>("enrichment : " + reactor.getEnrichment());
                TreeItem<String> leaf5 = new TreeItem<>("termal_capacity : " + reactor.getTermal_capacity());
                TreeItem<String> leaf6 = new TreeItem<>("electrical_capacity : " + reactor.getElectrical_capacity());
                TreeItem<String> leaf7 = new TreeItem<>("life_time : " + reactor.getLife_time());
                TreeItem<String> leaf8 = new TreeItem<>("first_load : " + reactor.getFirst_load());
                TreeItem<String> leaf9 = new TreeItem<>("source : " + reactor.getSource());

                branch.getChildren().addAll(leaf1, leaf2, leaf3, leaf4,
                        leaf5, leaf6, leaf7, leaf8, leaf9);
                root.getChildren().add(branch);
            }
        }
        treeReactors.setRoot(root);
    }

    public static void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Error");
        alert.showAndWait();
    }
}
