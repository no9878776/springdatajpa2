package com.atguigu.springdata.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yurisman
 * @create 2021-02-2021/2/3-上午 08:10
 */
@Entity
@Table(name = "t_customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = -7814726531582020118L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer id;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_source")
    private String source;

    @Column(name = "cust_industry")
    private String industry;

    @Column(name = "cust_level")
    private String level;

    @Column(name = "cust_address")
    private String address;

    @Column(name = "cust_phone")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
//    @JoinColumn(name = "cust_id",referencedColumnName = "cust_id")
//    @JoinColumn(name = "fk_cust_id")
    private Set<ContactPerson> contactPersons = new HashSet<>();

    public Set<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(Set<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", industry='" + industry + '\'' +
                ", level='" + level + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Customer() {
    }

    public Customer(String name, String source, String industry, String level, String address, String phone) {
        this.name = name;
        this.source = source;
        this.industry = industry;
        this.level = level;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
