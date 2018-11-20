package com.zhxw.smbms.pojo;


import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class Smbms_Address {

  private long id;
  private String contact;
  private String addressdesc;
  private String postcode;
  private String tel;
  private long createdby;
  private Date creationdate;
  private long modifyby;
  private Date modifydate;
  private long userid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }


  public String getAddressdesc() {
    return addressdesc;
  }

  public void setAddressdesc(String addressdesc) {
    this.addressdesc = addressdesc;
  }


  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public long getCreatedby() {
    return createdby;
  }

  public void setCreatedby(long createdby) {
    this.createdby = createdby;
  }


  public Date getCreationdate() {
    return creationdate;
  }

  public void setCreationdate(Date creationdate) {
    this.creationdate = creationdate;
  }


  public long getModifyby() {
    return modifyby;
  }

  public void setModifyby(long modifyby) {
    this.modifyby = modifyby;
  }


  public Date getModifydate() {
    return modifydate;
  }

  public void setModifydate(Date modifydate) {
    this.modifydate = modifydate;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

}
