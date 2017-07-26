/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Samrat
 */
@Entity
@Table(name = "semester_account_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SemesterAccountDetails.findAll", query = "SELECT s FROM SemesterAccountDetails s")
    , @NamedQuery(name = "SemesterAccountDetails.findById", query = "SELECT s FROM SemesterAccountDetails s WHERE s.id = :id")
    , @NamedQuery(name = "SemesterAccountDetails.findBySemesterFee", query = "SELECT s FROM SemesterAccountDetails s WHERE s.semesterFee = :semesterFee")})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class SemesterAccountDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "semester_fee")
    private BigInteger semesterFee;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    //@JsonBackReference(value = "account-list")
    private Account accountId;
    @JoinColumn(name = "semester_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    //@JsonBackReference(value = "semester-list")
    private Semester semesterId;
    
    public SemesterAccountDetails() {
    }

    public SemesterAccountDetails(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getSemesterFee() {
        return semesterFee;
    }

    public void setSemesterFee(BigInteger semesterFee) {
        this.semesterFee = semesterFee;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Semester getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Semester semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemesterAccountDetails)) {
            return false;
        }
        SemesterAccountDetails other = (SemesterAccountDetails) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.administration.Administration.models.SemesterAccountDetails[ id=" + id + " ]";
    }
    
}
