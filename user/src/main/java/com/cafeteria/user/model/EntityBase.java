package com.cafeteria.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntityBase {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date createdDate;

    @Column
    @CreatedBy
    private UUID createdBy;

    @Column
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date lastModifiedDate;

    @Column
    @LastModifiedBy
    private UUID lastModifiedBy;

    /*** Temporary until Audit and login is implemented **/
    @PrePersist
    void preInsert() {
        Date dateNow = new Date();
        this.createdDate = dateNow;
        this.lastModifiedDate =dateNow;
        this.createdBy = UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6");
        this.lastModifiedBy = UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6");
    }
    @PreUpdate
    void onPreUpdate() {
        this.lastModifiedDate = new Date();
        this.createdBy = UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6");
        this.lastModifiedBy = UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6");
    }
    /*** Temporary until Audit and login is implemented **/
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(UUID lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
