package com.dt.sys.depart.vo;

import java.io.Serializable;

/**
 * @description: 部门试图层
 * @author: liqi
 * @create: 2019-06-24
 */
public class DepartVo implements Serializable {

    private String id;
    /**名称*/
    private String departName;
    /**父亲id*/
    private String departPid;
    /**英文名*/
    private String departNameEn;
    /**缩写*/
    private String departNameAbbr;
    /**描述*/
    private String remark;
    /**机构类型*/
    private String orgType;
    /**机构编码*/
    private String orgCode;
    /**传真*/
    private String fax;
    /**地址*/
    private String address;
    /**状态*/
    private String status;
    /**单位性质*/
    private String companyProperty;
    /**法人*/
    private String legalPerson;
    /**邮政编码*/
    private String zipCode;
    /**所属行业*/
    private String industry;
    /**联系人*/
    private String contactPerson;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartPid() {
        return departPid;
    }

    public void setDepartPid(String departPid) {
        this.departPid = departPid;
    }

    public String getDepartNameEn() {
        return departNameEn;
    }

    public void setDepartNameEn(String departNameEn) {
        this.departNameEn = departNameEn;
    }

    public String getDepartNameAbbr() {
        return departNameAbbr;
    }

    public void setDepartNameAbbr(String departNameAbbr) {
        this.departNameAbbr = departNameAbbr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
