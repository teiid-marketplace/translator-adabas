package org.teiid.translator.adabas;

import org.teiid.core.util.TimestampWithTimezone;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class CalendarHelper {

  public static Time adjustTime(Calendar cal, Time value) {
    if (value != null && cal != null) {
      value = TimestampWithTimezone.createTime(value,
          Calendar.getInstance().getTimeZone(), cal);
    }
    return value;
  }

  public static Date adjustDate(Calendar cal, Date value) {
    if (value != null && cal != null) {
      value = TimestampWithTimezone.createDate(value,
          Calendar.getInstance().getTimeZone(), cal);
    }
    return value;
  }

  public static Timestamp adjustTimestamp(Calendar cal, Timestamp value) {
    if (value != null && cal != null) {
      value = TimestampWithTimezone.createTimestamp(value,
          Calendar.getInstance().getTimeZone(), cal);
    }
    return value;
  }

}
