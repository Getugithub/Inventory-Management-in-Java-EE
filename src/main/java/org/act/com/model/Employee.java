package org.act.com.model;
// Generated Jul 1, 2022 4:22:39 PM by Hibernate Tools 5.2.0.Final


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name="employee"
    ,schema="public"
)
public class Employee  implements java.io.Serializable {


     private long id;
     private Departments departments;
     private Date createdOn;
     private String email;
     private String name;
     private String status;
     private Date updatedOn;
     private Set<ResourceRequest> resourceRequests = new HashSet<ResourceRequest>(0);
     private Set<PurchaseRequest> purchaseRequests = new HashSet<PurchaseRequest>(0);
     private Set<Holdings> holdingses = new HashSet<Holdings>(0);

    public Employee() {
    }

	
    public Employee(long id) {
        this.id = id;
    }
    public Employee(long id, Departments departments, Date createdOn, String email, String name, String status, Date updatedOn, Set<ResourceRequest> resourceRequests, Set<PurchaseRequest> purchaseRequests, Set<Holdings> holdingses) {
       this.id = id;
       this.departments = departments;
       this.createdOn = createdOn;
       this.email = email;
       this.name = name;
       this.status = status;
       this.updatedOn = updatedOn;
       this.resourceRequests = resourceRequests;
       this.purchaseRequests = purchaseRequests;
       this.holdingses = holdingses;
    }
   
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department")
    public Departments getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", length=29)
    public Date getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    
    @Column(name="email", length=200)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="name", length=200)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="status", length=200)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_on", length=29)
    public Date getUpdatedOn() {
        return this.updatedOn;
    }
    
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
    @JsonIgnore
@OneToMany(fetch=FetchType.LAZY, mappedBy="employee")
    public Set<ResourceRequest> getResourceRequests() {
        return this.resourceRequests;
    }
    
    public void setResourceRequests(Set<ResourceRequest> resourceRequests) {
        this.resourceRequests = resourceRequests;
    }
    @JsonIgnore
@OneToMany(fetch=FetchType.LAZY, mappedBy="employee")
    public Set<PurchaseRequest> getPurchaseRequests() {
        return this.purchaseRequests;
    }
    
    public void setPurchaseRequests(Set<PurchaseRequest> purchaseRequests) {
        this.purchaseRequests = purchaseRequests;
    }
    @JsonIgnore
@OneToMany(fetch=FetchType.LAZY, mappedBy="employee")
    public Set<Holdings> getHoldingses() {
        return this.holdingses;
    }
    
    public void setHoldingses(Set<Holdings> holdingses) {
        this.holdingses = holdingses;
    }




}

