package com.macdo.macdo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.macdo.macdo.model.Macdonald;

import lombok.Data;

@Component
@Data // this annotation is for generating getter and setter for all private attribute 'lombok'
public class MacdonaldComponent {
	private static final Logger LOGGER = LoggerFactory.getLogger(MacdonaldComponent.class);
	private static final String fileName = "mcdonalds.csv";

	private static final int latitude = 0;
	private static final int longitude = 1;
	private static final int name = 2;
	private static final int adress = 3;
	private List<Macdonald> macdos;

	//this method is executed in the startup of the app and fill all the lines of document in list of macdonald's list
	//in case of big file its better to use H2 embaded but in our case the file is small so we will use only list 
	/*
	@PostConstruct
	public void init() {
		BufferedReader fileReader = null;
		ClassLoader classLoader = new MacdonaldService().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		// File is found
		LOGGER.info("File Found : " + file.exists());
		try {
			macdos = new ArrayList<Macdonald>();
			String line = "";
			fileReader = new BufferedReader(new FileReader(file));

			fileReader.readLine();
            //read csv file and split every line bu this pattern to Macdonald object and fill all in static list
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				if (tokens.length > 0) {
					Macdonald macdonald = new Macdonald(Double.valueOf(tokens[latitude]),
							Double.valueOf(tokens[longitude]), tokens[name], tokens[adress]);

					macdos.add(macdonald);
				}
			}

		} catch (Exception e) {
			LOGGER.info("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				LOGGER.info("Closing fileReader Error!");
				e.printStackTrace();
			}
		}
	}
	*/
}
