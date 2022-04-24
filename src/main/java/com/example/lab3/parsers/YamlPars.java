package com.example.lab3.parsers;

import com.example.lab3.reactor.Reactor;
import com.example.lab3.reactor.ReactorType;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class YamlPars {

    public void parse(File file, ArrayList<Reactor> reactorArrayList) throws FileNotFoundException {

        InputStream inputStream = new FileInputStream(file);
        Yaml yaml = new Yaml(new Constructor(ReactorType.class)); //используем экземпляр класса коструктор с типом reactortype
        ReactorType data = yaml.load(inputStream); //метод load() теперь возвращает экземпляр типа reactortype
        reactorArrayList.addAll(data.getReactorType()); //добавляем экземпляр в список реакторов

    }
}

