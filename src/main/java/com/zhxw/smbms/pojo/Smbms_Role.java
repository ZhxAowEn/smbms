package com.zhxw.smbms.pojo;

import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class Smbms_Role {

  private long id;
  private String rolecode;
  private String rolename;
  private long createdby;
  private Date creationdate;
  private long modifyby;
  private Date modifydate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRolecode() {
    return rolecode;
  }

  public void setRolecode(String rolecode) {
    this.rolecode = rolecode;
  }


  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
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

}
