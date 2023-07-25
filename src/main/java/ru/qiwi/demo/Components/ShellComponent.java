package ru.qiwi.demo.Components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.xml.bind.JAXBException;

@org.springframework.shell.standard.ShellComponent
public class ShellComponent {

    final MainComponent mainComponent;

    public ShellComponent(MainComponent mainComponent) {
        this.mainComponent = mainComponent;
    }

    @ShellMethod(value = "Get rates")
    public String currency_rates(@ShellOption({"-C", "--code", "code"}) String code, @ShellOption({"-D", "--date", "date"}) String date) throws JAXBException {
        return mainComponent.getCurrentRate(code.substring(5), date.substring(5));
    }
}
