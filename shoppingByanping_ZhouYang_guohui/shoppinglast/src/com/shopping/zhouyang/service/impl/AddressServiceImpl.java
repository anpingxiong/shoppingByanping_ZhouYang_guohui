package com.shopping.zhouyang.service.impl;

import com.shopping.factory.CreateDaoFactory;

import com.shopping.guoguo.pojo.Address;
import com.shopping.util.GetLogger;
import com.shopping.zhouyang.dao.AddressDao;
import com.shopping.zhouyang.service.AddressService;

public class AddressServiceImpl implements AddressService {
		private static AddressService addressService = new AddressServiceImpl();
		private static AddressDao addressDao = (AddressDao)CreateDaoFactory.createDao("com.shopping.zhouyang.dao.impl.AddressDao");
		private AddressServiceImpl(){}
		
		public static AddressService getInstance(){
			return addressService;
		}

	public int addAddress(Address address) {
	
		GetLogger.getLogger().warn(address.getGetname()+"添加成功");
		return addressDao.saveAddress(address);
	}

	public Address showAddressByOid(String oid) {
	
		return addressDao.getAddressByOid(oid);
	}

	public int deleteAddressByOid(String oid) {
		
		return addressDao.removeAddressByOid(oid);
	}

}
