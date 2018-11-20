package com.zhxw.smbms.pojo;


import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class Smbms_Bill {

  private long id;
  private String billcode;
  private String productname;
  private String productdesc;
  private String productunit;
  private double productcount;
  private double totalprice;
  private long ispayment;
  private long createdby;
  private Date creationdate;
  private long modifyby;
  private Date modifydate;
  private long providerid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getBillcode() {
    return billcode;
  }

  public void setBillcode(String billcode) {
    this.billcode = billcode;
  }


  public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }


  public String getProductdesc() {
    return productdesc;
  }

  public void setProductdesc(String productdesc) {
    this.productdesc = productdesc;
  }


  public String getProductunit() {
    return productunit;
  }

  public void setProductunit(String productunit) {
    this.productunit = productunit;
  }


  public double getProductcount() {
    return productcount;
  }

  public void setProductcount(double productcount) {
    this.productcount = productcount;
  }


  public double getTotalprice() {
    return totalprice;
  }

  public void setTotalprice(double totalprice) {
    this.totalprice = totalprice;
  }


  public long getIspayment() {
    return ispayment;
  }

  public void setIspayment(long ispayment) {
    this.ispayment = ispayment;
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


  public long getProviderid() {
    return providerid;
  }

  public void setProviderid(long providerid) {
    this.providerid = providerid;
  }

}
