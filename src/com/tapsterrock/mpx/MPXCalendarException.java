/*
 * file:       MPXCalendarException.java
 * author:     Jon Iles
 * copyright:  (c) Tapster Rock Limited 2002-2003
 * date:       28/11/2003
 */

/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

package com.tapsterrock.mpx;

import java.util.Date;

/**
 * This class represents instances of Calendar Exception records from
 * an MPX file. It is used to define exceptions to the working days described
 * in both base and resource calendars.
 */
public final class MPXCalendarException extends MPXRecord
{
   /**
    * Default constructor.
    *
    * @param file the parent file to which this record belongs.
    * @param calendar parent calendar to which this record belongs.
    * @throws MPXException Thrown on parse errors
    */
   MPXCalendarException (MPXFile file, MPXCalendar calendar)
      throws MPXException
   {
      this (file, calendar, Record.EMPTY_RECORD);
   }

   /**
    * Constructor used to create an instance of this class from data
    * taken from an MPXFile record.
    *
    * @param file the MPXFile object to which this record belongs.
    * @param calendar parent calendar to which this record belongs.
    * @param record record containing the data for this object.
    * @throws MPXException Thrown on parse errors
    */
   MPXCalendarException (MPXFile file, MPXCalendar calendar, Record record)
      throws MPXException
   {
      super(file, MAX_FIELDS);

      m_parentCalendar = calendar;

      setFromDate(record.getDate(0));
      setToDate(record.getDate(1));
      setWorking(record.getNumericBoolean(2));
      setFromTime1(record.getTime(3));
      setToTime1(record.getTime(4));
      setFromTime2(record.getTime(5));
      setToTime2(record.getTime(6));
      setFromTime3(record.getTime(7));
      setToTime3(record.getTime(8));
   }


   /**
    * Returns the from date
    *
    * @return Date
    */
   public Date getFromDate ()
   {
      return ((Date)get(FROM_DATE));
   }

   /**
    * Sets from date.
    *
    * @param from date
    */
   public void setFromDate (Date from)
   {
      putDate (FROM_DATE,from);
   }

   /**
    * Get to date
    *
    * @return Date
    */
   public Date getToDate ()
   {
      return ((Date)get(TO_DATE));
   }

   /**
    * Sets To Date
    *
    * @param to Date
    */
   public void setToDate (Date to)
   {
      putDate (TO_DATE,to);
   }

   /**
    * gets working status
    *
    * @return boolean value
    */
   public boolean getWorkingValue ()
   {
      return  (getNumericBooleanValue (WORKING));
   }

   /**
    * gets working status
    *
    * @return boolean value
    */
   public NumericBoolean getWorking ()
   {
      return  ((NumericBoolean)get (WORKING));
   }

   /**
    * Sets working status of this exception.
    *
    * @param flag Boolean flag
    */
   public void setWorking (boolean flag)
   {
      put (WORKING, NumericBoolean.getInstance(flag));
   }

   /**
    * Sets working status of this exception.
    *
    * @param flag Boolean flag
    */
   public void setWorking (NumericBoolean flag)
   {
      put (WORKING, flag);
   }

   /**
    * Get FromTime1
    *
    * @return Time
    */
   public Date getFromTime1 ()
   {
      return ((Date)get(FROM_TIME_1));
   }

   /**
    * Sets from time 1
    *
    * @param from Time
    */
   public void setFromTime1 (Date from)
   {
      putTime (FROM_TIME_1, from);
   }

   /**
    * Get ToTime1
    *
    * @return Time
    */
   public Date getToTime1 ()
   {
      return ((Date)get(TO_TIME_1));
   }

   /**
    * Sets to time 1
    *
    * @param to Time
    */
   public void setToTime1 (Date to)
   {
      putTime (TO_TIME_1, to);
   }

   /**
    * Get FromTime2
    *
    * @return Time
    */
   public Date getFromTime2 ()
   {
      return ((Date)get(FROM_TIME_2));
   }

   /**
    * Sets from time 2
    *
    * @param from Time
    */
   public void setFromTime2 (Date from)
   {
      putTime (FROM_TIME_2, from);
   }

   /**
    * Get ToTime2
    *
    * @return Time
    */
   public Date getToTime2 ()
   {
      return ((Date)get(TO_TIME_2));
   }

   /**
    * Sets to time 2
    *
    * @param to Time
    */
   public void setToTime2 (Date to)
   {
      putTime (TO_TIME_2, to);
   }

   /**
    * Get ToTime3
    * @return Time
    */
   public Date getFromTime3 ()
   {
      return ((Date)get(FROM_TIME_3));
   }

   /**
    * Sets from time 3
    *
    * @param from Time
    */
   public void setFromTime3 (Date from)
   {
      putTime (FROM_TIME_3,from);
   }

   /**
    * Get ToTime3
    *
    * @return Time
    */
   public Date getToTime3 ()
   {
      return ((Date)get(TO_TIME_3));
   }

   /**
    * Sets to time 3
    *
    * @param to Time
    */
   public void setToTime3 (Date to)
   {
      putTime (TO_TIME_3, to);
   }

   /**
    * This method determines whether the given date falls in the range of
    * dates covered by this exception. Note that this method assumes that both
    * the start and end date of this exception have been set.
    *
    * @param date Date to be tested
    * @return Boolean value
    */
   public boolean contains (Date date)
   {
      boolean result = false;

      if (date != null)
      {
         long time = date.getTime();

         if (time >= getFromDate().getTime() && time <= getToDate().getTime())
         {
            result = true;
         }
      }

      return (result);
   }

   /**
    * This method generates a string in MPX format representing the
    * contents of this record.
    *
    * @return string containing the data for this record in MPX format.
    */
   public String toString ()
   {
      int recordNumber;

      if (m_parentCalendar.isBaseCalendar() == true)
      {
         recordNumber = BASE_CALENDAR_EXCEPTION_RECORD_NUMBER;
      }
      else
      {
         recordNumber = RESOURCE_CALENDAR_EXCEPTION_RECORD_NUMBER;
      }

      return (toString(recordNumber));
   }

   /**
    * Reference to the parent calendar of this exception.
    */
   private MPXCalendar m_parentCalendar;

   /**
    * Constant identifier for the FromDate field
    */
   private static final int FROM_DATE = 0;

   /**
    * Constant identifier for the ToDate field
    */
   private static final int TO_DATE = 1;

   /**
    * Constant identifier for the Working field
    */
   private static final int WORKING = 2;

   /**
    * Constant identifier for the FromTime 1 field
    */
   private static final int FROM_TIME_1 = 3;

   /**
    * Constant identifier for the To Time 1 field
    */
   private static final int TO_TIME_1 = 4;

   /**
    * Constant identifier for the From Time 2 field
    */
   private static final int FROM_TIME_2 = 5;

   /**
    * Constant identifier for the To Time 2 field
    */
   private static final int TO_TIME_2 = 6;

   /**
    * Constant identifier for the From Time 3 field
    */
   private static final int FROM_TIME_3 = 7;

   /**
    * Constant identifier for the To Time 3 field
    */
   private static final int TO_TIME_3 = 8;

   /**
    * Maximum number of fields in this record.
    */
   private static final int MAX_FIELDS = 9;

   /**
    * Constant containing the record number associated with this record.
    * if this instance represents a base calendar exception.
    */
   static final int BASE_CALENDAR_EXCEPTION_RECORD_NUMBER = 26;

   /**
    * Constant containing the record number associated with this record.
    * if this instance represents a resource calendar exception.
    */
   static final int RESOURCE_CALENDAR_EXCEPTION_RECORD_NUMBER = 57;
}
