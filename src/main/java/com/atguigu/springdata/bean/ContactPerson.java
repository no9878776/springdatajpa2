package com.atguigu.springdata.bean;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Yurisman
 * @create 2021-02-2021/2/3-上午 08:16
 */
@Entity
@Table(name = "t_contact_person")
public class ContactPerson implements Serializable {
    private static final long serialVersionUID = 8199191028494928232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer id;

    @Column(name = "contact_name")
    private String name;

    @Column(name = "contact_gender")
    private String gender;

    @Column(name = "contact_phone")
    private String phone;

    @Column(name = "contact_mobile")
    private String mobile;

    @Column(name = "contact_email")
    private String email;

    @Column(name = "contact_position")
    private String position;

    @Column(name = "contact_memo")
    private String memo;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cust_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", memo='" + memo + '\'' +
                ", customer=" + customer +
                '}';
    }

    public ContactPerson() {
    }

    public ContactPerson(String name, String gender, String phone, String mobile, String email, String position, String memo) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.position = position;
        this.memo = memo;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
