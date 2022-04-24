package com.example.lab3.parsers;


import com.example.lab3.Controller;
import com.example.lab3.parsers.JsonPars;
import com.example.lab3.parsers.XmlPars;
import com.example.lab3.parsers.YamlPars;
import com.example.lab3.reactor.Reactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Parser {

    private final ArrayList<Reactor> reactorArrayList = new ArrayList<>();

    public Parser(File file) throws FileNotFoundException {
        if (file.getAbsolutePath().endsWith(".json")) {
            JsonPars jsonPars = new JsonPars();
            jsonPars.parse(file, reactorArrayList);
        } else if (file.getAbsolutePath().endsWith(".xml")) {
            XmlPars xmlPars = new XmlPars();
            xmlPars.parse(file, reactorArrayList);
        } else if (file.getAbsolutePath().endsWith(".yaml")) {
            YamlPars yamlPars = new YamlPars();
            yamlPars.parse(file, reactorArrayList);
        } else {
            Controller.error();
        }
    }

    public ArrayList<Reactor> getReactorArrayList() {
        return reactorArrayList;
    }
}



