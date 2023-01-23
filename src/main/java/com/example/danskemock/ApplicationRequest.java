package com.example.danskemock;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement()
public class ApplicationRequest {
    @JacksonXmlProperty(localName = "Command")
    private String command;

}
