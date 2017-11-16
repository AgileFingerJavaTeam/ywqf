package com.ywqf.dto.in;

public class PropertyFeePaymentDto {
    //
	private String at_search;
	private int page;
	private int rows;
	private String status;
	//
	private int id;
	//
	private int corp_id;
	
	//
	private int estate_pay_num;
	private int community_id;
	private int house_id;
	private String house_num;
	private String owner_name;
	private double area;
	private double estate_unit_price;
	private int pay_month_type_id;
	private String pay_date;
	private double payment_amount;
	private String service_start_date;
	private String service_end_date;
	private int charge_worker_id;
	private String operator;
	
	//
	private int estateSearchId;
	
	//�ɷ�����
	private String at_pay_start;
	private String at_pay_end;
	
	private String at_date_time;
	
	//����������
	private String at_service_start;
	private String at_service_end;
	
	//check    0.���� 1.����
	private String okey;

	private int comm;

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public String getOkey() {
		return okey;
	}
	public void setOkey(String okey) {
		this.okey = okey;
	}
	public String getAt_service_start() {
		return at_service_start;
	}
	public void setAt_service_start(String at_service_start) {
		this.at_service_start = at_service_start;
	}
	public String getAt_service_end() {
		return at_service_end;
	}
	public void setAt_service_end(String at_service_end) {
		this.at_service_end = at_service_end;
	}
	public String getAt_date_time() {
		return at_date_time;
	}
	public void setAt_date_time(String at_date_time) {
		this.at_date_time = at_date_time;
	}
	public String getAt_pay_start() {
		return at_pay_start;
	}
	public void setAt_pay_start(String at_pay_start) {
		this.at_pay_start = at_pay_start;
	}
	public String getAt_pay_end() {
		return at_pay_end;
	}
	public void setAt_pay_end(String at_pay_end) {
		this.at_pay_end = at_pay_end;
	}
	public int getEstateSearchId() {
		return estateSearchId;
	}
	public void setEstateSearchId(int estateSearchId) {
		this.estateSearchId = estateSearchId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEstate_pay_num() {
		return estate_pay_num;
	}
	public void setEstate_pay_num(int estate_pay_num) {
		this.estate_pay_num = estate_pay_num;
	}
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	public String getHouse_num() {
		return house_num;
	}
	public void setHouse_num(String house_num) {
		this.house_num = house_num;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getEstate_unit_price() {
		return estate_unit_price;
	}
	public void setEstate_unit_price(double estate_unit_price) {
		this.estate_unit_price = estate_unit_price;
	}
	public int getPay_month_type_id() {
		return pay_month_type_id;
	}
	public void setPay_month_type_id(int pay_month_type_id) {
		this.pay_month_type_id = pay_month_type_id;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public double getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(double payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getService_start_date() {
		return service_start_date;
	}
	public void setService_start_date(String service_start_date) {
		this.service_start_date = service_start_date;
	}
	public String getService_end_date() {
		return service_end_date;
	}
	public void setService_end_date(String service_end_date) {
		this.service_end_date = service_end_date;
	}
	public int getCharge_worker_id() {
		return charge_worker_id;
	}
	public void setCharge_worker_id(int charge_worker_id) {
		this.charge_worker_id = charge_worker_id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getCorp_id() {
		return corp_id;
	}
	public void setCorp_id(int corp_id) {
		this.corp_id = corp_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAt_search() {
		return at_search;
	}
	public void setAt_search(String at_search) {
		this.at_search = at_search;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "PropertyFeePaymentDto [at_search=" + at_search + ", page=" + page + ", rows=" + rows + ", id=" + id
				+ ", corp_id=" + corp_id + "]";
	}

	
	
	
	
	
	
}
