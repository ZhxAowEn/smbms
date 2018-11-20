package com.zhxw.smbms.pojo;

import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class Smbms_Provider {

  private long id;
  private String procode;
  private String proname;
  private String prodesc;
  private String procontact;
  private String prophone;
  private String proaddress;
  private String profax;
  private long createdby;
  private Date creationdate;
  private Date modifydate;
  private long modifyby;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getProcode() {
    return procode;
  }

  public void setProcode(String procode) {
    this.procode = procode;
  }


  public String getProname() {
    return proname;
  }

  public void setProname(String proname) {
    this.proname = proname;
  }


  public String getProdesc() {
    return prodesc;
  }

  public void setProdesc(String prodesc) {
    this.prodesc = prodesc;
  }


  public String getProcontact() {
    return procontact;
  }

  public void setProcontact(String procontact) {
    this.procontact = procontact;
  }


  public String getProphone() {
    return prophone;
  }

  public void setProphone(String prophone) {
    this.prophone = prophone;
  }


  public String getProaddress() {
    return proaddress;
  }

  public void setProaddress(String proaddress) {
    this.proaddress = proaddress;
  }


  public String getProfax() {
    return profax;
  }

  public void setProfax(String profax) {
    this.profax = profax;
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


  public Date getModifydate() {
    return modifydate;
  }

  public void setModifydate(Date modifydate) {
    this.modifydate = modifydate;
  }


  public long getModifyby() {
    return modifyby;
  }

  public void setModifyby(long modifyby) {
    this.modifyby = modifyby;
  }

}
