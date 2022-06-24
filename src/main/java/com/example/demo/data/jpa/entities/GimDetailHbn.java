package com.example.demo.data.jpa.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TB_M_GIM_D")
@Getter
@Setter
@ToString
public class GimDetailHbn {
    @EmbeddedId
    private GimDetailHbnId id;

    @Column(name = "GIM_VALUE", nullable = false, length = 2000)
    private String gimValue;

    @Column(name = "FIELD1", length = 4000)
    private String field1;

    @Column(name = "FIELD2", length = 4000)
    private String field2;

    @Column(name = "FIELD3", length = 4000)
    private String field3;

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