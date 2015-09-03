package com.tja.frame.command;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tja.frame.common.provider.Menu;
import com.tja.frame.common.provider.MenuProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"/context-*.xml",
	"/core-context-*.xml"
})
public class CommonTests {

	@Autowired
	private MenuProvider menuProvider;
	
	@Test
	public void testMenu() {
		Set<Menu> menus	 = menuProvider.getMenus();
		Assert.assertNotNull(menus);
		for(Menu m:menus) {
			Assert.assertNotNull(m.getId());
			System.out.println(m.getId()+":"+m.getName()+" URL:"+m.getUrl()+
					" parentId:"+m.getParentId()+" children size:"+m.getChildren().size()
					+" perm:"+m.getPerm());
		}
	}
}
