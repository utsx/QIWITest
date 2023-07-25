package ru.qiwi.demo.Contexts;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)

public class Valute {
    @XmlAttribute(name = "ID")
    private String id;
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
