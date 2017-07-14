package com.ilroberts.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "NewDataSet")
public class NewDataSetDTO implements Serializable {

    @XmlElement(name = "Table")
    private List<TableDTO> table;

    public NewDataSetDTO() {
        table = new ArrayList<>();
    }

    public List<TableDTO> getTable() {
        return table;
    }

    public void setTable(List<TableDTO> table){
        this.table = table;
    }

}
