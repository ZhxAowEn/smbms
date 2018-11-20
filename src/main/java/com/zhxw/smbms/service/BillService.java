package com.zhxw.smbms.service;

import com.zhxw.smbms.pojo.Smbms_Bill;

import java.util.List;
public interface BillService {
	/**
	 * 增加订单
	 * @param bill
	 * @return
	 */
	public int add(Smbms_Bill bill) throws Exception;


	/**
	 * 通过条件获取订单列表-模糊查询-billList
	 * @param bill
	 * @return
	 */
	public List<Smbms_Bill> getBillList(Smbms_Bill bill) throws Exception;

	/**
	 * 通过billId删除Bill
	 * @param delId
	 * @return
	 */
	public int deleteBillById(String delId) throws Exception;


	/**
	 * 通过billId获取Bill
	 * @param id
	 * @return
	 */
	public Smbms_Bill getBillById(String id) throws Exception;

	/**
	 * 修改订单信息
	 * @param bill
	 * @return
	 */
	public int modify(Smbms_Bill bill) throws Exception;
}
