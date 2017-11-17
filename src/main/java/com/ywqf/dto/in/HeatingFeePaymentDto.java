package com.ywqf.dto.in;

public class HeatingFeePaymentDto {
   
	private int id;
	private String Rname;
    private int heating_pay_id;
	private String house_num;
	private int community_id;


	private String at_search;
	private int page;
	private int rows;

	private int comm;
	private int estateSearchId;
	private String status;
	private String okey;

	private int heating_pay_num;
	private int house_id;
	private String owner_name;
	private double heating_unit_price;
	private double discount_heating_unit_price;
	private double heating_area;
	private double payment_amount;
	private int year;
	private double heating_discount;
	private String payment_date;
	private int charge_worker_id;
	private String operator;


	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
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

	public String getOkey() {
		return okey;
	}

	public void setOkey(String okey) {
		this.okey = okey;
	}

	public int getHeating_pay_num() {
		return heating_pay_num;
	}

	public void setHeating_pay_num(int heating_pay_num) {
		this.heating_pay_num = heating_pay_num;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public double getHeating_unit_price() {
		return heating_unit_price;
	}

	public void setHeating_unit_price(double heating_unit_price) {
		this.heating_unit_price = heating_unit_price;
	}

	public double getDiscount_heating_unit_price() {
		return discount_heating_unit_price;
	}

	public void setDiscount_heating_unit_price(double discount_heating_unit_price) {
		this.discount_heating_unit_price = discount_heating_unit_price;
	}

	public double getHeating_area() {
		return heating_area;
	}

	public void setHeating_area(double heating_area) {
		this.heating_area = heating_area;
	}

	public double getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(double payment_amount) {
		this.payment_amount = payment_amount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getHeating_discount() {
		return heating_discount;
	}

	public void setHeating_discount(double heating_discount) {
		this.heating_discount = heating_discount;
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

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public int getHeating_pay_id() {
		return heating_pay_id;
	}

	public void setHeating_pay_id(int heating_pay_id) {
		this.heating_pay_id = heating_pay_id;
	}

	public int getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}

	public String getHouse_num() {
		return house_num;
	}

	public void setHouse_num(String house_num) {
		this.house_num = house_num;
	}

	public String getRname() {
		return Rname;
	}

	public void setRname(String rname) {
		Rname = rname;
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
		return "HeatingFeePaymentDto{" +
				"id=" + id +
				", Rname='" + Rname + '\'' +
				", house_num='" + house_num + '\'' +
				", community_id=" + community_id +
				", at_search='" + at_search + '\'' +
				", page=" + page +
				", rows=" + rows +
				'}';
	}
}
