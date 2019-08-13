package com.zl.pojo.client;
/**
 * 客户公司信息实体类
 *
 */
public class ClientCompany {
	private int id; 	//公司信息表主键id
	private String companyName;	//公司名	company_Name
	private String companyNature;	//公司性质：行政机关，事业单位。社会团体，企业，个体户工商户。其他		company_nature
	private int companyPhone;	//公司联系方式	company_phone
	private String companyIndustry;		//行业类别：公共管理与社会组织，科教文化，金融电力电信，邮政交通运输公共，计算机服务和软件业。体育娱乐。工商服务业贸易，其他	company_industry
	private String companyAddress;	//公司地址		company_address
	private String companyJob;	//职务：厅局级以上，处级，科级，一般干部，其他，总经理级，部门经理级，职员，其他	compant_job
	private	String annualIncome;	//从事职称：高级职称及以上。中级职称，初级职称，初级及以下	company_annual_income
	private int companyPostalcode;	//公司邮编	company_postalcode
	private int client;	//外键，客户主键id	company_client_id，此处为方便级联，写成外键对象
	private int binding;	//公司信息与客户的绑定状态，0为未绑定，即离职公司等，1为绑定状态，即现公司
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNature() {
		return companyNature;
	}
	public void setCompanyNature(String companyNature) {
		this.companyNature = companyNature;
	}
	public int getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(int companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyIndustry() {
		return companyIndustry;
	}
	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyJob() {
		return companyJob;
	}
	public void setCompanyJob(String companyJob) {
		this.companyJob = companyJob;
	}
	public String getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}
	public int getCompanyPostalcode() {
		return companyPostalcode;
	}
	public void setCompanyPostalcode(int companyPostalcode) {
		this.companyPostalcode = companyPostalcode;
	}
	
	
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	public int getBinding() {
		return binding;
	}
	public void setBinding(int binding) {
		this.binding = binding;
	}
	
	@Override
	public String toString() {
		return "ClientCompany [id=" + id + ", companyName=" + companyName + ", companyNature=" + companyNature
				+ ", companyPhone=" + companyPhone + ", companyIndustry=" + companyIndustry + ", companyAddress="
				+ companyAddress + ", companyJob=" + companyJob + ", annualIncome=" + annualIncome
				+ ", companyPostalcode=" + companyPostalcode + ", client=" + client + ", binding=" + binding + "]";
	}

}
