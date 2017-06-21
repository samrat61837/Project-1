/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Samrat
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id")
    , @NamedQuery(name = "Account.findByBillNo", query = "SELECT a FROM Account a WHERE a.billNo = :billNo")
    , @NamedQuery(name = "Account.findByAmountPaid", query = "SELECT a FROM Account a WHERE a.amountPaid = :amountPaid")
    , @NamedQuery(name = "Account.findByAmountDue", query = "SELECT a FROM Account a WHERE a.amountDue = :amountDue")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bill_no")
    private long billNo;
    @Column(name = "amount_paid")
    private BigInteger amountPaid;
    @Column(name = "amount_due")
    private BigInteger amountDue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<SemesterAccountDetails> semesterAccountDetailsList;
    @JoinColumn(name = "student_faculty_enrollment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudentFacultyEnrollment studentFacultyEnrollmentId;

    public Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    public Account(Long id, long billNo) {
        this.id = id;
        this.billNo = billNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBillNo() {
        return billNo;
    }

    public void setBillNo(long billNo) {
        this.billNo = billNo;
    }

    public BigInteger getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigInteger amountPaid) {
        this.amountPaid = amountPaid;
    }

    public BigInteger getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigInteger amountDue) {
        this.amountDue = amountDue;
    }

    @XmlTransient
    public List<SemesterAccountDetails> getSemesterAccountDetailsList() {
        return semesterAccountDetailsList;
    }

    public void setSemesterAccountDetailsList(List<SemesterAccountDetails> semesterAccountDetailsList) {
        this.semesterAccountDetailsList = semesterAccountDetailsList;
    }

    public StudentFacultyEnrollment getStudentFacultyEnrollmentId() {
        return studentFacultyEnrollmentId;
    }

    public void setStudentFacultyEnrollmentId(StudentFacultyEnrollment studentFacultyEnrollmentId) {
        this.studentFacultyEnrollmentId = studentFacultyEnrollmentId;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.Administration.models.Account[ id=" + id + " ]";
    }
    
}
