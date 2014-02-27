package com.shopping.zhouyang.service;

import com.shopping.guoguo.pojo.Address;

public interface AddressService {
				public int addAddress(Address address);
				public Address showAddressByOid(String oid);
				public int deleteAddressByOid(String oid);
}
