package com.ywqf.service.impl;

import java.util.HashMap;
import java.util.List;

import com.ywqf.entity.CompanyAndCommunity;
import com.ywqf.exception.db.DeleteInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.exception.db.UpdateInnerErrorException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywqf.base.BaseException;
import com.ywqf.dao.HouseDao;
import com.ywqf.dto.excution.HouseExcution;
import com.ywqf.dto.in.HouseDto;
import com.ywqf.entity.HouseInfo;
import com.ywqf.enums.HouseEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.service.HouseConfigService;
@Service
public class HouseConfigServiceImpl implements HouseConfigService {
	 private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private HouseDao houseDao;

	@Override
	public HouseExcution findCompanyById() {
		int id=1000;
		try{
			CompanyAndCommunity companyName=houseDao.findCompanyById(id);
			if (companyName!=null){
				return  new HouseExcution(HouseEnum.FIND_SUCCESS,companyName);
			}else {
				throw  new QueryInnerErrorException("查询失败");
			}
		}catch (QueryInnerErrorException q) {
			throw q;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public HouseExcution findCompanyByType() {
		try{
			List<CompanyAndCommunity> companyName=houseDao.findCompanyByType();
			if (companyName!=null){
				return  new HouseExcution(HouseEnum.FIND_SUCCESS,companyName);
			}else {
				throw  new QueryInnerErrorException("查询失败");
			}
		}catch (QueryInnerErrorException q) {
			throw q;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public HouseExcution findCommunityById() {
		int id=1000;
		try{
			List<CompanyAndCommunity> companyName=houseDao.findCommunityById(id);
			if (companyName!=null){
				return  new HouseExcution(HouseEnum.FIND_SUCCESS,companyName);
			}else {
				throw  new QueryInnerErrorException("查询失败");
			}
		}catch (QueryInnerErrorException q) {
			throw q;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public HouseExcution findChildCommunityById(HouseDto houseDto) {
		int id=Integer.parseInt(houseDto.getId());
		try{
			List<CompanyAndCommunity> companyName=houseDao.findCommunityByCorp(id);
			if (companyName!=null){
				return  new HouseExcution(HouseEnum.FIND_SUCCESS,companyName);
			}else {
				throw  new QueryInnerErrorException("查询失败");
			}
		}catch (QueryInnerErrorException q) {
			throw q;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	/*查询房屋配置信息列表*/
	@Override
	public HouseExcution findHouseInfo(HouseDto houseDto) {
		int page=houseDto.getPage();
		int rows=houseDto.getRows();
		int community_id=Integer.parseInt(houseDto.getCommunity_id());
		int corp_id=Integer.parseInt(houseDto.getCorp_id());
		try{
			page=1;
			rows=20;
			int offset =0;
			List<HouseInfo> houselist= houseDao.findHouseInfo(offset,rows,community_id,corp_id);
			/*int total=houseDao.findHouseCount(community_id);*/
			HashMap map=new HashMap();
            map.put("rows",houselist);
/*
            map.put("total",total);
*/
            return  new HouseExcution(HouseEnum.FIND_SUCCESS,map);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}
	
	/*查询户型*/
	@Override
	public HouseExcution findRoomType(HouseDto houseDto) {
		try{
			List<HouseInfo> namelist=houseDao.findRoomType();
            return  new HouseExcution(HouseEnum.FIND_SUCCESS,namelist);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}

	/*查询社区名称*/
	@Override
	public HouseExcution findCommunityName(HouseDto houseDto) {
		int  corp_id=Integer.parseInt(houseDto.getCorp_id());
		try{
			List<HouseInfo> namelist=houseDao.findCommunityName(corp_id);
            return  new HouseExcution(HouseEnum.FIND_SUCCESS,namelist);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}

	/*提交新增信息*/
	@Override
	public HouseExcution saveHouseInfo(HouseDto houseDto) {
		int community_id=Integer.parseInt(houseDto.getCommunity_id());
		String building=houseDto.getBuilding();
		String unit=houseDto.getUnit();
		String floor=houseDto.getFloor();
		String room_num=houseDto.getRoom_num();
		int house_type_id=Integer.parseInt(houseDto.getHouse_type_id());
		double area=Double.parseDouble(houseDto.getArea());
		double now_estate_unit_price=Double.parseDouble(houseDto.getNow_estate_unit_price());
		double now_estate_fee=Double.parseDouble(houseDto.getNow_estate_fee());
		String owner_name=houseDto.getOwner_name();
		String owner_tel=houseDto.getOwner_tel();
		String owner_standby_tel=houseDto.getOwner_standby_tel();
		int family_size=Integer.parseInt(houseDto.getFamily_size());
		String house_num=building+'-'+unit+'-'+room_num;
		try{
			int saveHouseInfo=houseDao.saveHouseInfo(community_id,building,unit,floor,room_num,house_type_id,area,now_estate_unit_price,now_estate_fee,owner_name,owner_tel,owner_standby_tel,family_size,house_num);
			if (saveHouseInfo>0) {
				return  new HouseExcution(HouseEnum.ADD_SUCCESS);
			}else{
				throw new InsertInnerErrorException("添加失败");
			}
		}catch (InsertInnerErrorException i) {
            throw i;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
		
	}

	@Override
	public HouseExcution findHouseInfoByID(HouseDto houseDto) {
		int id=Integer.parseInt(houseDto.getId());
		try{
			HouseInfo houseInfo=houseDao.findHouseInfoByID(id);
			if (houseDto!=null){
				return  new HouseExcution(HouseEnum.FIND_SUCCESS,houseInfo);
			}else {
				throw  new QueryInnerErrorException("查询失败");
			}
		}catch (QueryInnerErrorException q) {
			throw q;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}

	}

	@Override
	public HouseExcution editHouseInfo(HouseDto houseDto) {
		int community_id=Integer.parseInt(houseDto.getCommunity_id());
		String building=houseDto.getBuilding();
		String unit=houseDto.getUnit();
		String floor=houseDto.getFloor();
		String room_num=houseDto.getRoom_num();
		int house_type_id=Integer.parseInt(houseDto.getHouse_type_id());
		double area=Double.parseDouble(houseDto.getArea());
		double now_estate_unit_price=Double.parseDouble(houseDto.getNow_estate_unit_price());
		double now_estate_fee=Double.parseDouble(houseDto.getNow_estate_fee());
		String owner_name=houseDto.getOwner_name();
		String owner_tel=houseDto.getOwner_tel();
		String owner_standby_tel=houseDto.getOwner_standby_tel();
		int family_size=Integer.parseInt(houseDto.getFamily_size());
		int id=Integer.parseInt(houseDto.getId());
		try{
			int editHouseInfo=houseDao.editHouseInfo(community_id,building,unit,floor,room_num,house_type_id,area,now_estate_unit_price,now_estate_fee,owner_name,owner_tel,owner_standby_tel,family_size,id);
			if (editHouseInfo>0) {
				return  new HouseExcution(HouseEnum.UPDATE_SUCCESS);
			}else{
				throw new InsertInnerErrorException("编辑失败");
			}
		}catch (UpdateInnerErrorException u) {
			throw u;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public HouseExcution deleteHouseInfo(HouseDto houseDto) {
		int id=Integer.parseInt(houseDto.getId());
		try{
			int deleteHouseInfo=houseDao.deleteHouseInfo(id);
			if (deleteHouseInfo>0) {
				return  new HouseExcution(HouseEnum.DEL_SUCCESS);
			}else{
				throw new InsertInnerErrorException("删除失败");
			}
		}catch (DeleteInnerErrorException d) {
			throw d;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}


}
