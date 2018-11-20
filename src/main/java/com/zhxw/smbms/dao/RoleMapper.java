package com.zhxw.smbms.dao;

import java.util.List;
import com.zhxw.smbms.pojo.Smbms_Role;

public interface RoleMapper {
	
	public List<Smbms_Role> getRoleList(Smbms_Role role)throws Exception;

}
