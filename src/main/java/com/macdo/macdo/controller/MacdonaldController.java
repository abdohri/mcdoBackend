package com.macdo.macdo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macdo.macdo.Exception.MacdoException;
import com.macdo.macdo.model.Macdonald;
import com.macdo.macdo.service.MacdonaldService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MacdonaldController {
	@Autowired
	private MacdonaldService macdonaldService;

	@ApiOperation(value = "Search a mcdonalds with state key")
	@RequestMapping(value = "/state/{key}", method = GET)
	public List<Macdonald> findAllMacdonaldByState(
			@ApiParam(value = "key of state that need to be searched", required = true) @PathVariable("key") String state)
			throws Exception {
		List<Macdonald> list = null;
		try {
			list = macdonaldService.searchMacdonald(state);
		} catch (Exception e) {
			throw new MacdoException("Error in findAllMacdonaldByState" + e.getMessage());
		}
		return list;
	}
}
