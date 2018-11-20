package com.zhxw.smbms.service.impl;

import com.zhxw.smbms.dao.BillMapper;
import com.zhxw.smbms.pojo.Smbms_Bill;
import com.zhxw.smbms.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("billServiceImpl")//定义一个业务逻辑层对象
@Transactional//所有的public方法都开启事务
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    public BillMapper getBillMapper() {
        return billMapper;
    }

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    /**
     * 增加订单
     *
     * @param bill
     * @return
     * @throws Exception
     */
    @Override
    public int add(Smbms_Bill bill) throws Exception {
        return billMapper.add(bill);
    }

    /**
     * 通过条件获取订单列表-模糊查询-billList
     *
     * @param bill
     * @return
     * @throws Exception
     */
    @Override
    public List<Smbms_Bill> getBillList(Smbms_Bill bill) throws Exception {
        return billMapper.getBillList(bill);
    }

    /**
     * 通过billId删除Bill
     *
     * @param delId
     * @return
     * @throws Exception
     */
    @Override
    public int deleteBillById(String delId) throws Exception {
        return billMapper.deleteBillById(delId);
    }

    /**
     * 通过billId获取Bill
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Smbms_Bill getBillById(String id) throws Exception {
        return billMapper.getBillById(id);
    }

    /**
     * 修改订单信息
     *
     * @param bill
     * @return
     * @throws Exception
     */
    @Override
    public int modify(Smbms_Bill bill) throws Exception {
        return billMapper.modify(bill);
    }
}
