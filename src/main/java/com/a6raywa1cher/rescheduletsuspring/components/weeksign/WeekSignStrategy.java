package com.a6raywa1cher.rescheduletsuspring.components.weeksign;

import com.a6raywa1cher.rescheduletsuspring.models.WeekSign;

import java.time.LocalDate;
import java.util.Date;

public interface WeekSignStrategy {
	WeekSign getWeekSign(Date date, LocalDate startDate, WeekSign startWeekSign);
}
