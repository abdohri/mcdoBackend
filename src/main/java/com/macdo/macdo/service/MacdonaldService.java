package com.macdo.macdo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.macdo.macdo.model.Macdonald;

@Service
public class MacdonaldService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MacdonaldService.class);
    private static String COMMA=",";
    
	@Autowired
	MacdonaldComponent macdonaldComponent;

	@Transactional
	public List<Macdonald> searchMacdonald(String state) throws Exception {
		LOGGER.info("Start searching in file...");
		List<Macdonald> result = null;
		try {
			result = new ArrayList<Macdonald>();
			for (Macdonald macdonald : macdonaldComponent.getMacdos()) {
				//check if the line contain the state send it by user 
				if (macdonald.getAdress().contains(COMMA+state+COMMA)) {
					LOGGER.info(macdonald.toString());
					result.add(macdonald);
				}
			}
			LOGGER.info("end  of searching in file...");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return result;
	}

}
