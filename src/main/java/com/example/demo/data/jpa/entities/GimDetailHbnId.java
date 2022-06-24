package com.example.demo.data.jpa.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
@ToString
public class GimDetailHbnId implements Serializable {
    private static final long serialVersionUID = 7195108638435657405L;
    @Column(name = "GIM_TYPE", nullable = false, length = 50)
    private String gimType;

    @Column(name = "GIM_CD", nullable = false, length = 500)
    private String gimCd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GimDetailHbnId entity = (GimDetailHbnId) o;
        return Objects.equals(this.gimCd, entity.gimCd) &&
                Objects.equals(this.gimType, entity.gimType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gimCd, gimType);
    }

}