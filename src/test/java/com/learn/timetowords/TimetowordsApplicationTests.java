package com.learn.timetowords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.timetowords.service.TimeConverterService;

@SpringBootTest
class TimetowordsApplicationTests {

	@Autowired
	private TimeConverterService timeConverterService;
	
	@Test
	void timeInWordsTest_morning() {
		assertEquals("It's midnight.", timeConverterService.getTimeInWords(00, 00));
		assertEquals("It's twelve twelve am.", timeConverterService.getTimeInWords(00, 12));
		assertEquals("It's eleven thirty four am.", timeConverterService.getTimeInWords(11, 34));
		assertEquals("It's eleven fifty nine am.", timeConverterService.getTimeInWords(11, 59));
	}
	@Test
	void timeInWordsTest_noon() {
		assertEquals("It's midday.", timeConverterService.getTimeInWords(12, 00));
		assertEquals("It's twelve thirty pm.", timeConverterService.getTimeInWords(12, 30));
		assertEquals("It's one forty five pm.", timeConverterService.getTimeInWords(13, 45));
		assertEquals("It's eleven forty pm.", timeConverterService.getTimeInWords(23, 40));
	}

}
