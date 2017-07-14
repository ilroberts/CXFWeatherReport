package com.ilroberts.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "NewDataSet")
public class NewDataSetDTO implements Serializable {

    @XmlElement
    private List<TableDTO> Table;

    public NewDataSetDTO() {
        Table = new ArrayList<>();
    }

    public List<TableDTO> getTable() {
        return Table;
    }

    public void setTable(List<TableDTO> table){
        this.Table = table;
    }

}
