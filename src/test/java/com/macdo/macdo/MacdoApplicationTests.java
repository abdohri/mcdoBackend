package com.macdo.macdo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.macdo.macdo.Exception.MacdoException;
import com.macdo.macdo.controller.MacdonaldController;
import com.macdo.macdo.model.Macdonald;
import com.macdo.macdo.service.MacdonaldService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MacdoApplicationTests {

	@InjectMocks
	private MacdonaldController macdonaldController;
	@Mock
	private MacdonaldService macdonaldService;

	@Test
	public void find_Macdo_By_State() throws Exception {
		List<Macdonald> listPerson = new ArrayList<Macdonald>();
		Macdonald macdo = new Macdonald();
		macdo.setAdress("any adress");
		macdo.setName("any name");
		macdo.setLatitude(-66.33525);
		macdo.setLongitude(99.55487);
		listPerson.add(macdo);
		Macdonald macdo2 = new Macdonald();
		macdo2.setAdress("any adress");
		macdo2.setName("any name");
		macdo2.setLatitude(-66.33525);
		macdo2.setLongitude(99.55487);
		listPerson.add(macdo2);
		
		Mockito.when(macdonaldService.searchMacdonald("AK")).thenReturn(listPerson);
		List<Macdonald> list = macdonaldController.findAllMacdonaldByState("AK");
		assertThat(list).containsAll(listPerson);
		assertEquals(list.size(), 2);
	}
	@Test
	public void find_Macdo_By_States() throws Exception  {	
		List<Macdonald> listPerson = new ArrayList<Macdonald>();
		Macdonald macdo = new Macdonald();
		macdo.setAdress("any adress");
		macdo.setName("any name");
		macdo.setLatitude(-66.33525);
		macdo.setLongitude(99.55487);
		listPerson.add(macdo);

		Mockito.when(macdonaldService.searchMacdonald("AK")).thenReturn(listPerson);
		List<Macdonald> list = macdonaldController.findAllMacdonaldByState("AK");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), macdo);
		
	}
	
	@Test(expected = MacdoException.class)
	public void find_Macdo_By_State_Exception() throws Exception  {	
		
		Mockito.when(macdonaldService.searchMacdonald("AK")).thenThrow(MacdoException.class);
		List<Macdonald> list = macdonaldController.findAllMacdonaldByState("AK");

		
	}
}
