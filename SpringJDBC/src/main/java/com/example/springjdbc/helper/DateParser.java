package com.example.springjdbc.helper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateParser {

    public static Date parseDate(LocalDateTime date){
        Instant instant=date.atZone(ZoneId.systemDefault()).toInstant();
        Date date1=Date.from(instant);
        return date1;
    }
}
