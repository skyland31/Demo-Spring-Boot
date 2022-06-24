package com.example.demo.data.jpa.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TB_M_GIM_H")
@Setter
@Getter
@ToString
public class GimHeaderHbn {
    @Id
    @Column(name = "GIM_TYPE", nullable = false, length = 50)
    private String id;

    @Column(name = "GIM_DESC", nullable = false, length = 200)
    private String gimDesc;

    @Column(name = "CD_LENGTH", nullable = false)
    private Integer cdLength;

    @Column(name = "FIELD1_LABEL", nullable = false, length = 50)
    private String field1Label;

    @Column(name = "FIELD2_LABEL", nullable = false, length = 50)
    private String field2Label;

    @Column(name = "FIELD3_LABEL", nullable = false, length = 50)
    private String field3Label;

    @Column(name = "ACTIVE_FLAG", nullable = false)
    private String activeFlag;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DT", nullable = false)
    private Date createdDt;

    @Column(name = "MODIFIED_BY", nullable = false)
    private String modifiedBy;

    @Column(name = "MODIFIED_DT", nullable = false)
    private Date modifiedDt;
}