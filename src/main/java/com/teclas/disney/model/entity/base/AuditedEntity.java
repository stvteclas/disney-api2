package com.teclas.disney.model.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
@JsonIgnoreProperties( value = { "createdAt", "createdBy", "updatedAt", "updatedBy" } )
public class AuditedEntity {

    @CreatedDate
    @Column( updatable = false )
    private LocalDateTime createdAt;

    @CreatedBy
    @Column( updatable = false )
    private String createdBy;

    @LastModifiedDate
    @Column( insertable = false )
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column( insertable = false )
    private String updatedBy;
}
