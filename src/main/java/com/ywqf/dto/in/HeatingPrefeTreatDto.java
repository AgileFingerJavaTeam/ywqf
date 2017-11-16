package com.ywqf.dto.in;


public class HeatingPrefeTreatDto {
    private String discount_start_date;
    private String discount_end_date;
    private Double rate;

    public String getDiscount_start_date() {
        return discount_start_date;
    }

    public void setDiscount_start_date(String discount_start_date) {
        this.discount_start_date = discount_start_date;
    }

    public String getDiscount_end_date() {
        return discount_end_date;
    }

    public void setDiscount_end_date(String discount_end_date) {
        this.discount_end_date = discount_end_date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "HeatingPrefeTreatDto{" +
                "discount_start_date='" + discount_start_date + '\'' +
                ", discount_end_date='" + discount_end_date + '\'' +
                ", rate=" + rate +
                '}';
    }
}
