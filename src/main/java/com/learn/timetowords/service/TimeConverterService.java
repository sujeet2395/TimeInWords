package com.learn.timetowords.service;

import org.springframework.stereotype.Service;

import com.learn.timetowords.payload.TimeRequest;
import com.learn.timetowords.payload.TimeResponse;

@Service
public class TimeConverterService {
	public TimeResponse timeConverter(TimeRequest timeRequest) {
        String[] parts = timeRequest.getTime().split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        String timeInWords = getTimeInWords(hours, minutes);
        TimeResponse timeResponse=new TimeResponse();
        timeResponse.setTimeInWords(timeInWords);
        return timeResponse;
    }

    public String getTimeInWords(int hours, int minutes) {
        if (hours == 0 && minutes == 0) {
            return "It's midnight.";
        } else if (hours == 12 && minutes == 0) {
            return "It's midday.";
        }

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty"};
        String[] minutesWords = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String hourWord = "";
        if (hours % 12 > 0) {
            hourWord = ones[hours % 12];
        }
        if(hours==12 || hours==0) {
        	hourWord=ones[12];
        }
        String minuteWord = "";
        if (minutes > 0) {
            if (minutes < 20) {
                minuteWord = minutesWords[minutes];
            } else {
                int tensValue = minutes / 10;
                int onesValue = minutes % 10;
                minuteWord = tens[tensValue] + (onesValue==0?"":" " + minutesWords[onesValue]);
            }
        }

        String amPm = hours < 12 ? "am" : "pm";

        String timeInWords = "It's "+hourWord + " " + minuteWord + " " + amPm+".";
        return timeInWords.trim();
    }
}
