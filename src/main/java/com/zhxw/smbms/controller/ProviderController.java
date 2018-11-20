package com.zhxw.smbms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zhxw.smbms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhxw.smbms.pojo.Smbms_Provider;
import com.zhxw.smbms.service.ProviderService;
import com.zhxw.smbms.pojo.Smbms_Page;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pro")
public class ProviderController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ProviderService providerService;

    public ProviderService getProviderService() {
        return providerService;
    }

    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

    // 供应商管理
    @RequestMapping(value = "/getProviderView", produces = "text/plain;charset=UTF-8")
    public String getProviderView(
            @RequestParam(value = "currPageNo", required = true, defaultValue = "1") int currPageNo,
            @RequestParam(value = "queryProCode", required = true, defaultValue = "") String proCode,
            @RequestParam(value = "queryProName", required = true, defaultValue = "") String proName,
            Model model, HttpServletRequest Request) throws Exception {
        System.out.println(proName);
        logger.debug("getProviderView=============" + Request.getMethod() + "=======================");
       /* if (Request.getMethod() == "GET") {
            proCode = new String(proCode.getBytes("iso-8859-1"), "utf-8");
            proName = new String(proName.getBytes("iso-8859-1"), "utf-8");
        }*/
        Smbms_Page page = new Smbms_Page();
        page.setCurrPageNo(currPageNo);
        page.setPageSize(5);
        page.setTotalCount(providerService.getProviderCount(proCode,
                proName));
        List<Smbms_Provider> providerList = providerService.getProviderList(
                proCode, proName,
                (page.getCurrPageNo() - 1) * page.getPageSize(),
                page.getPageSize());
        model.addAttribute("proCode", proCode);
        model.addAttribute("proName", proName);
        if (providerList.size() > 0) {
            model.addAttribute("providerList", providerList);
            model.addAttribute("page", page);
        } else {
            model.addAttribute("providerList_Null", "无符合条件的供应商!");
        }
        return "provider/providerManage";
    }


    // 添加供应商
    @RequestMapping(value = "/getProAdd")
    public String getProAdd(
            /* @RequestParam(value = "proId", required = true) int id,*/
            Model model) {
        return "provider/providerAdd";
    }

    // 查看供应商
    @RequestMapping(value = "/getProSee")
    public String getProSee(
            @RequestParam(value = "proId", required = true) int id,
            Model model) {
        Smbms_Provider provider = providerService.getProvideById(id);
        model.addAttribute("provider", provider);
        return "provider/providerSee";
    }

    // 修改供应商（预加载）
    @RequestMapping(value = "/getProUpdate")
    public String getProUpdate(
            @RequestParam(value = "proId", required = true) int proId,
            @RequestParam(value = "currPageNo", required = true) int currPageNo,
            Model model) {
        Smbms_Provider provider = providerService.getProvideById(proId);
        model.addAttribute("provider", provider);
        model.addAttribute("currPageNo", currPageNo);
        return "provider/providerUpdate";
    }

    // 修改供应商
    @RequestMapping(value = "/proUpdate")
    public String proUpdate(
            Smbms_Provider provider,
            @RequestParam(value = "currPageNo", required = true) int currPageNo,
            RedirectAttributes attr)
            throws Exception {
        /* proName = new String(proName.getBytes("iso-8859-1"), "utf-8");*/
        providerService.proUpdate(provider);
        // 重定向 调用controller内的方法
        attr.addAttribute("queryProCode", provider.getProcode());
        attr.addAttribute("queryProName", provider.getProname());
        return "redirect:/pro/getProviderView";

    }

    // 删除供应商
    @RequestMapping(value = "/proDelete")
    public String proDelete(
            @RequestParam(value = "proId", required = true) int id,
            @RequestParam(value = "currPageNo", required = true) int currPageNo,
            @RequestParam(value = "queryProCode", required = true, defaultValue = "") String proCode,
            @RequestParam(value = "queryProName", required = true, defaultValue = "") String proName,
            @RequestParam(value = "pageCount", required = true) int TotalPageCount)
            throws Exception {
        logger.debug("proDelete=================================");
        providerService.proDelete(id);
        Smbms_Page page = new Smbms_Page();
        page.setTotalCount(providerService.getProviderCount("", ""));
        if (page.getTotalPageCount() < TotalPageCount
                && currPageNo == TotalPageCount) {
            return "redirect:/pro/getProviderView?currPageNo="
                    + (currPageNo - 1) + "&queryProCode=" + proCode
                    + "&queryProName=" + proName;
        }
        return "redirect:/pro/getProviderView?currPageNo=" + currPageNo
                + "&queryProCode=" + proCode + "&queryProName="
                + proName;
    }
}
