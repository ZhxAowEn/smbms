package com.zhxw.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhxw.smbms.dao.ProviderMapper;
import com.zhxw.smbms.pojo.Smbms_Provider;
import com.zhxw.smbms.service.ProviderService;

@Service("providerServiceImpl")
@Transactional // 开启事务
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    public ProviderMapper getProviderMapper() {
        return providerMapper;
    }

    public void setProviderMapper(ProviderMapper providerMapper) {
        this.providerMapper = providerMapper;
    }

    @Override
    public List<Smbms_Provider> getProviderList(String proCode, String proName,
                                                Integer currPageNo, Integer pageSize) {

        return providerMapper.getProviderList(proCode, proName, currPageNo, pageSize);
    }

    @Override
    public int getProviderCount(String proCode, String proName) {

        return providerMapper.getProviderCount(proCode, proName);
    }

    @Override
    public List<Smbms_Provider> getProviderName() {

        return providerMapper.getProviderName();
    }

    @Override
    public Smbms_Provider getProvideById(int id) {

        return providerMapper.getProvideById(id);
    }

    @Override
    public void proUpdate(Smbms_Provider provider) {
        providerMapper.proUpdate(provider);
    }

    @Override
    public void proDelete(int id) {
        providerMapper.proDelete(id);
    }

}
