/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Samrat
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id")
    , @NamedQuery(name = "Student.findByFname", query = "SELECT s FROM Student s WHERE s.fname = :fname")
    , @NamedQuery(name = "Student.findByLname", query = "SELECT s FROM Student s WHERE s.lname = :lname")
    , @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
    , @NamedQuery(name = "Student.findByDateofbirth", query = "SELECT s FROM Student s WHERE s.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Student.findByConatct", query = "SELECT s FROM Student s WHERE s.conatct = :conatct")
    , @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")
    , @NamedQuery(name = "Student.findByRegistration", query = "SELECT s FROM Student s WHERE s.registration = :registration")
    , @NamedQuery(name = "Student.findBySymbol", query = "SELECT s FROM Student s WHERE s.symbol = :symbol")
    , @NamedQuery(name = "Student.findByClub", query = "SELECT s FROM Student s WHERE s.club = :club")
    , @NamedQuery(name = "Student.findByFaculty", query = "SELECT s FROM Student s WHERE s.faculty = :faculty")
    , @NamedQuery(name = "Student.findBySemester", query = "SELECT s FROM Student s WHERE s.semester = :semester")
    , @NamedQuery(name = "Student.findBySection", query = "SELECT s FROM Student s WHERE s.section = :section")
    , @NamedQuery(name = "Student.findByBatch", query = "SELECT s FROM Student s WHERE s.batch = :batch")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Column(name = "conatct")
    private BigInteger conatct;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "photo")
    private byte [] photo;
    @Size(max = 100)
    @Column(name = "registration")
    private String registration;
    @Size(max = 100)
    @Column(name = "symbol")
    private String symbol;
    @Size(max = 45)
    @Column(name = "club")
    private String club;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "faculty")
    private String faculty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "semester")
    private String semester;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "section")
    private String section;
    @Basic(optional = false)
    @NotNull
    @Column(name = "batch")
    private int batch;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    @JsonManagedReference
    private List<StudentFacultyEnrollment> studentFacultyEnrollmentList;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private User userId;
    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(Long id, String fname, String lname, String gender, String address, Date dateofbirth, String email, byte [] photo, String faculty, String semester, String section, int batch) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.photo = photo;
        this.faculty = faculty;
        this.semester = semester;
        this.section = section;
        this.batch = batch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public BigInteger getConatct() {
        return conatct;
    }

    public void setConatct(BigInteger conatct) {
        this.conatct = conatct;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    @XmlTransient
    public List<StudentFacultyEnrollment> getStudentFacultyEnrollmentList() {
        return studentFacultyEnrollmentList;
    }

    public void setStudentFacultyEnrollmentList(List<StudentFacultyEnrollment> studentFacultyEnrollmentList) {
        this.studentFacultyEnrollmentList = studentFacultyEnrollmentList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.Administration.models.Student[ id=" + id + " ]";
    }
    
}
