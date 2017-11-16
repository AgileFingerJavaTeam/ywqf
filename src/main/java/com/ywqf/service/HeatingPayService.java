package com.ywqf.service;

import com.ywqf.dto.excution.HeatingPayExcution;
import com.ywqf.dto.in.HeatingPayDto;
import org.springframework.stereotype.Service;

@Service
public interface HeatingPayService {
    public HeatingPayExcution findHeatingPayInfo(HeatingPayDto heatingPayDto);
}
