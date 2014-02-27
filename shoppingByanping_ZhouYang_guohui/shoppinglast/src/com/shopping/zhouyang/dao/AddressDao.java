package com.shopping.zhouyang.dao;

import com.shopping.guoguo.pojo.Address;

public interface AddressDao {
				public int saveAddress(Address address);
				public Address getAddressByOid(String oid);
				public int removeAddressByOid(String oid);
}
