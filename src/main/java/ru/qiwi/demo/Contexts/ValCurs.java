package ru.qiwi.demo.Contexts;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {
    @XmlAttribute(name = "Date")
    private String date;
    @XmlAttribute(name = "Name")
    private String name;
    @XmlElementWrapper(name = "ValCurs")
    @XmlElement(name="Valute")
    List<Valute> valuteList;
}
