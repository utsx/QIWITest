package ru.qiwi.demo.Contexts;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)

public class Valute {
    @XmlElement(name="NumCode")
    private Long numCode;
    @XmlElement(name="CharCode")
    private String charCode;
    @XmlElement(name="Nominal")
    private Long nominal;
    @XmlElement(name="Name")
    private String name;
    @XmlElement(name="Value")
    private double value;


}
