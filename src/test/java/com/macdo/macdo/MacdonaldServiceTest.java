package com.macdo.macdo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.macdo.macdo.model.Macdonald;
import com.macdo.macdo.service.MacdonaldService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MacdonaldServiceTest {

	@Autowired
	private MacdonaldService macdonaldService;
	@Test
	public void find_Macdo_By_State() throws Exception {
		List<Macdonald> macdos=macdonaldService.searchMacdonald("AK");
		assertThat(macdos.size()>0);
		assertEquals(macdos.size(), 24);
		assertThat(macdos.get(0).getAdress()!=null);
		assertThat(macdos.get(0).getName()!=null);
		assertThat(macdos.get(0).getLatitude()>0);
	}
	@Test
	public void find_Macdo_By_State_Empty() throws Exception {
		List<Macdonald> macdos=macdonaldService.searchMacdonald("XW");
		assertNotNull(macdos);
		assertEquals(macdos.size(), 0);
	}
}
