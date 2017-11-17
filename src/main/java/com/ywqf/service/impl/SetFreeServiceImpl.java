package com.ywqf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.dao.SetFreeDao;
import com.ywqf.dto.excution.FreePropertyExcution;
import com.ywqf.dto.in.FreePropertyDto;
import com.ywqf.entity.FreeProperty;
import com.ywqf.enums.PayCarNumEnum;
import com.ywqf.service.SetFreeService;
@Service
public class SetFreeServiceImpl implements SetFreeService {
	//日志对象
		private Logger logger = LoggerFactory.getLogger(this.getClass());
	    @Autowired
	    private SetFreeDao setFreeDao;
		@Override
		public FreePropertyExcution ListFreeProperty(FreePropertyDto freePropertyDto) {
			try {
				List<FreeProperty> listFreeProperty =setFreeDao.listFreeProperty(freePropertyDto);
				if(listFreeProperty==null){
					listFreeProperty = new ArrayList<>();
				}
				HashMap map = new HashMap();
				map.put("rows", listFreeProperty);
				return new FreePropertyExcution(PayCarNumEnum.SUCCESS,map);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			return null;
		}
		@Override
		public FreePropertyExcution ListpreviewFreeProperty(FreePropertyDto freePropertyDto) {
			try {
				List<FreeProperty> listFreeProperty =setFreeDao.listFreeProperty(freePropertyDto);
				if(listFreeProperty==null){
					listFreeProperty = new ArrayList<>();
				}
				double previousEstateUnitPrice = freePropertyDto.getMoney();
				for(FreeProperty freeProperty:listFreeProperty){
					double area = freeProperty.getArea();
					double previousEstateFee = area*previousEstateUnitPrice;
					freeProperty.setPreviousEstateFee(previousEstateFee);
					freeProperty.setPreviousEstateUnitPrice(previousEstateUnitPrice);
				}
				HashMap map = new HashMap();
				map.put("rows", listFreeProperty);
				return new FreePropertyExcution(PayCarNumEnum.SUCCESS,map);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			return null;
		}
}
