package com.example.demo.feature.master.gim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GimHeaderSearchResultDTO {
    private String gimType;
    private String gimDesc;
    private Integer cdLength;
    private String field1Label;
    private String field2Label;
    private String field3Label;
    private String activeFlag;
    private String modifiedBy;
    private Date modifiedDt;
}
