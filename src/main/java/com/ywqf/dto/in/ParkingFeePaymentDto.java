package com.ywqf.dto.in;

public class ParkingFeePaymentDto {
    private int id;
    private String Rname;
	private String at_search;
	private int page;
	private int rows;

	private int corp_id;
	private String House_num;
	private int community_id;
    private int comm;
    private int estateSearchId;
	private int parking_pay_num;
	private int parking_num;
	private String car_owner_name;
	private String owner_name;
	private String license_plate_number;
	private double parking_unit_price;
	private int pay_month_type_id;
	private String pay_date;
	private double payment_amount;
	private String service_start_date;
	private String service_end_date;
	private int charge_worker_id;
	private String operator;
	private int house_id;
	private int parking_space_id;
	private String car_owner_tel;

	private String status;
	private String okey;

	public String getRname() {
		return Rname;
	}

	public void setRname(String rname) {
		Rname = rname;
	}

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

	public String getCar_owner_tel() {
		return car_owner_tel;
	}

	public void setCar_owner_tel(String car_owner_tel) {
		this.car_owner_tel = car_owner_tel;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public int getParking_space_id() {
		return parking_space_id;
	}

	public void setParking_space_id(int parking_space_id) {
		this.parking_space_id = parking_space_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public int getParking_pay_num() {
		return parking_pay_num;
	}

	public void setParking_pay_num(int parking_pay_num) {
		this.parking_pay_num = parking_pay_num;
	}

	public int getParking_num() {
		return parking_num;
	}

	public void setParking_num(int parking_num) {
		this.parking_num = parking_num;
	}

	public String getCar_owner_name() {
		return car_owner_name;
	}

	public void setCar_owner_name(String car_owner_name) {
		this.car_owner_name = car_owner_name;
	}

	public String getLicense_plate_number() {
		return license_plate_number;
	}

	public void setLicense_plate_number(String license_plate_number) {
		this.license_plate_number = license_plate_number;
	}

	public double getParking_unit_price() {
		return parking_unit_price;
	}

	public void setParking_unit_price(double parking_unit_price) {
		this.parking_unit_price = parking_unit_price;
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

	public String getHouse_num() {
		return House_num;
	}

	public void setHouse_num(String house_num) {
		House_num = house_num;
	}

	public int getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
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
		return "ParkingFeePaymentDto{" +
				"id=" + id +
				", at_search='" + at_search + '\'' +
				", page=" + page +
				", rows=" + rows +
				", corp_id=" + corp_id +
				", House_num='" + House_num + '\'' +
				", community_id=" + community_id +
				", parking_pay_num=" + parking_pay_num +
				", parking_num=" + parking_num +
				", car_owner_name='" + car_owner_name + '\'' +
				", owner_name='" + owner_name + '\'' +
				", license_plate_number='" + license_plate_number + '\'' +
				", parking_unit_price=" + parking_unit_price +
				", pay_month_type_id=" + pay_month_type_id +
				", pay_date='" + pay_date + '\'' +
				", payment_amount=" + payment_amount +
				", service_start_date='" + service_start_date + '\'' +
				", service_end_date='" + service_end_date + '\'' +
				", charge_worker_id=" + charge_worker_id +
				", operator='" + operator + '\'' +
				", house_id=" + house_id +
				", parking_space_id=" + parking_space_id +
				", car_owner_tel='" + car_owner_tel + '\'' +
				'}';
	}
}
