package com.ywqf.entity;

public class PaymentInfor {
	private int month;//月份
	private int paymentStatus;//缴费状态
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "PaymentInfor{" +
				"month=" + month +
				", paymentStatus=" + paymentStatus +
				'}';
	}
}
