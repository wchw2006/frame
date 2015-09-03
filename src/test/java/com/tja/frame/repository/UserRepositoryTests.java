package com.tja.frame.repository;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tja.frame.core.domain.Organization;
import com.tja.frame.core.domain.User;
import com.tja.frame.core.repository.OrganizationDao;
import com.tja.frame.core.repository.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"/context-*.xml",
	"/core-context-*.xml"
})
@Transactional
public class UserRepositoryTests {

	@Autowired
	UserDao userDao;
	
	@Autowired
	OrganizationDao organizationDao;
	
	public static final String USER_NAME ="5876";
	public static final String ORG_NAME ="信息技术部";
	
	@Before
	public void initData() {
	}
	
	@Test
	@Rollback(true)   
	public void saveUser(){
		Organization org = new Organization();
		org.setName(ORG_NAME);
		org.setLevel(2);
		org.setStatus(1);
		org.setCode("888");
		organizationDao.save(org);
		
		User user = new User();
		user.setOrganization(org);
		user.setUserName(USER_NAME);
		user.setRealName("xiaoxin");
		user.setPassword("xiaoxin");
		user.setStatus(1);  //有效用户
		user.setBirthDate(new Date());
		
		userDao.save(user);
		
		User u1 = userDao.findByUserName("5876");
		
		Assert.assertNotNull(u1.getOrganization());
		Assert.assertNotNull(u1);
		Assert.assertNotNull(u1.getId());
		Assert.assertEquals(user.getPassword(), u1.getPassword());
	}

	@After
   public  void destroy() {
   }
	
}
