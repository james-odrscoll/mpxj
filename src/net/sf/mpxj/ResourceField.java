/*
 * file:       ResourceField.java
 * author:     Jon Iles
 * copyright:  (c) Packwood Software 2005
 * date:       26/04/2005
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

package net.sf.mpxj;

import java.util.Locale;

/**
 * Instances of this type represent Resource fields.
 */
public final class ResourceField implements FieldType
{
   /**
    * Private constructor.
    *
    * @param value task field value
    * @param dataType data type
    */
   private ResourceField(int value, DataType dataType)
   {
      m_value = value;
      m_dataType = dataType;
      TYPE_VALUES[value] = this;
   }

   /**
    * {@inheritDoc}
    */
   public String getName()
   {
      return (getName(Locale.ENGLISH));
   }

   /**
    * {@inheritDoc}
    */
   public String getName(Locale locale)
   {
      String[] titles = LocaleData.getStringArray(locale, LocaleData.RESOURCE_COLUMNS);
      String result = null;

      if (m_value >= 0 && m_value < titles.length)
      {
         result = titles[m_value];
      }

      return (result);
   }

   /**
    * {@inheritDoc}
    */
   public int getValue()
   {
      return (m_value);
   }

   /**
    * {@inheritDoc}
    */
   public DataType getDataType()
   {
      return (m_dataType);
   }

   /**
    * Retrieves the string representation of this instance.
    *
    * @return string representation
    */
   @Override public String toString()
   {
      return (getName());
   }

   /**
    * {@inheritDoc}
    */
   @Override public boolean equals(Object obj)
   {
      boolean result = false;
      if (obj instanceof ResourceField)
      {
         result = (m_value == ((ResourceField) obj).m_value);
      }
      return (result);
   }

   /**
    * {@inheritDoc}
    */
   @Override public int hashCode()
   {
      return (m_value);
   }

   /**
    * This method takes the integer enumeration of a resource field
    * and returns an appropriate class instance.
    *
    * @param type integer task field enumeration
    * @return ResourceField instance
    */
   public static ResourceField getInstance(int type)
   {
      ResourceField result = null;

      if (type >= 0 && type < MAX_VALUE)
      {
         result = TYPE_VALUES[type];
      }

      return (result);
   }

   public static final int ID_VALUE = 0;
   public static final int NAME_VALUE = 1;
   public static final int INITIALS_VALUE = 2;
   public static final int GROUP_VALUE = 3;
   public static final int MAX_UNITS_VALUE = 4;
   public static final int BASE_CALENDAR_VALUE = 5;
   public static final int STANDARD_RATE_VALUE = 6;
   public static final int OVERTIME_RATE_VALUE = 7;
   public static final int TEXT1_VALUE = 8;
   public static final int TEXT2_VALUE = 9;
   public static final int CODE_VALUE = 10;
   public static final int ACTUAL_COST_VALUE = 11;
   public static final int COST_VALUE = 12;
   public static final int WORK_VALUE = 13;
   public static final int ACTUAL_WORK_VALUE = 14;
   public static final int BASELINE_WORK_VALUE = 15;
   public static final int OVERTIME_WORK_VALUE = 16;
   public static final int BASELINE_COST_VALUE = 17;
   public static final int COST_PER_USE_VALUE = 18;
   public static final int ACCRUE_AT_VALUE = 19;
   public static final int REMAINING_COST_VALUE = 20;
   public static final int REMAINING_WORK_VALUE = 21;
   public static final int WORK_VARIANCE_VALUE = 22;
   public static final int COST_VARIANCE_VALUE = 23;
   public static final int OVERALLOCATED_VALUE = 24;
   public static final int PEAK_VALUE = 25;
   public static final int UNIQUE_ID_VALUE = 26;
   public static final int NOTES_VALUE = 27;
   public static final int PERCENT_WORK_COMPLETE_VALUE = 28;
   public static final int TEXT3_VALUE = 29;
   public static final int TEXT4_VALUE = 30;
   public static final int TEXT5_VALUE = 31;
   public static final int OBJECTS_VALUE = 32;
   public static final int LINKED_FIELDS_VALUE = 33;
   public static final int EMAIL_ADDRESS_VALUE = 34;
   public static final int REGULAR_WORK_VALUE = 35;
   public static final int ACTUAL_OVERTIME_WORK_VALUE = 36;
   public static final int REMAINING_OVERTIME_WORK_VALUE = 37;
   public static final int OVERTIME_COST_VALUE = 38;
   public static final int ACTUAL_OVERTIME_COST_VALUE = 39;
   public static final int REMAINING_OVERTIME_COST_VALUE = 40;
   public static final int BCWS_VALUE = 41;
   public static final int BCWP_VALUE = 42;
   public static final int ACWP_VALUE = 43;
   public static final int SV_VALUE = 44;
   public static final int AVAILABLE_FROM_VALUE = 45;
   public static final int AVAILABLE_TO_VALUE = 46;
   public static final int INDICATORS_VALUE = 47;
   public static final int TEXT6_VALUE = 48;
   public static final int TEXT7_VALUE = 49;
   public static final int TEXT8_VALUE = 50;
   public static final int TEXT9_VALUE = 51;
   public static final int TEXT10_VALUE = 52;
   public static final int START1_VALUE = 53;
   public static final int START2_VALUE = 54;
   public static final int START3_VALUE = 55;
   public static final int START4_VALUE = 56;
   public static final int START5_VALUE = 57;
   public static final int FINISH1_VALUE = 58;
   public static final int FINISH2_VALUE = 59;
   public static final int FINISH3_VALUE = 60;
   public static final int FINISH4_VALUE = 61;
   public static final int FINISH5_VALUE = 62;
   public static final int NUMBER1_VALUE = 63;
   public static final int NUMBER2_VALUE = 64;
   public static final int NUMBER3_VALUE = 65;
   public static final int NUMBER4_VALUE = 66;
   public static final int NUMBER5_VALUE = 67;
   public static final int DURATION1_VALUE = 68;
   public static final int DURATION2_VALUE = 69;
   public static final int DURATION3_VALUE = 70;
   public static final int COST1_VALUE = 71;
   public static final int COST2_VALUE = 72;
   public static final int COST3_VALUE = 73;
   public static final int FLAG10_VALUE = 74;
   public static final int FLAG1_VALUE = 75;
   public static final int FLAG2_VALUE = 76;
   public static final int FLAG3_VALUE = 77;
   public static final int FLAG4_VALUE = 78;
   public static final int FLAG5_VALUE = 79;
   public static final int FLAG6_VALUE = 80;
   public static final int FLAG7_VALUE = 81;
   public static final int FLAG8_VALUE = 82;
   public static final int FLAG9_VALUE = 83;
   public static final int HYPERLINK_VALUE = 84;
   public static final int HYPERLINK_ADDRESS_VALUE = 85;
   public static final int HYPERLINK_SUBADDRESS_VALUE = 86;
   public static final int HYPERLINK_HREF_VALUE = 87;
   public static final int ASSIGNMENT_VALUE = 88;
   public static final int TASK_SUMMARY_NAME_VALUE = 89;
   public static final int CAN_LEVEL_VALUE = 90;
   public static final int WORK_CONTOUR_VALUE = 91;
   public static final int COST4_VALUE = 92;
   public static final int COST5_VALUE = 93;
   public static final int COST6_VALUE = 94;
   public static final int COST7_VALUE = 95;
   public static final int COST8_VALUE = 96;
   public static final int COST9_VALUE = 97;
   public static final int COST10_VALUE = 98;
   public static final int DATE1_VALUE = 99;
   public static final int DATE2_VALUE = 100;
   public static final int DATE3_VALUE = 101;
   public static final int DATE4_VALUE = 102;
   public static final int DATE5_VALUE = 103;
   public static final int DATE6_VALUE = 104;
   public static final int DATE7_VALUE = 105;
   public static final int DATE8_VALUE = 106;
   public static final int DATE9_VALUE = 107;
   public static final int DATE10_VALUE = 108;
   public static final int DURATION4_VALUE = 109;
   public static final int DURATION5_VALUE = 110;
   public static final int DURATION6_VALUE = 111;
   public static final int DURATION7_VALUE = 112;
   public static final int DURATION8_VALUE = 113;
   public static final int DURATION9_VALUE = 114;
   public static final int DURATION10_VALUE = 115;
   public static final int FINISH6_VALUE = 116;
   public static final int FINISH7_VALUE = 117;
   public static final int FINISH8_VALUE = 118;
   public static final int FINISH9_VALUE = 119;
   public static final int FINISH10_VALUE = 120;
   public static final int FLAG11_VALUE = 121;
   public static final int FLAG12_VALUE = 122;
   public static final int FLAG13_VALUE = 123;
   public static final int FLAG14_VALUE = 124;
   public static final int FLAG15_VALUE = 125;
   public static final int FLAG16_VALUE = 126;
   public static final int FLAG17_VALUE = 127;
   public static final int FLAG18_VALUE = 128;
   public static final int FLAG19_VALUE = 129;
   public static final int FLAG20_VALUE = 130;
   public static final int NUMBER6_VALUE = 131;
   public static final int NUMBER7_VALUE = 132;
   public static final int NUMBER8_VALUE = 133;
   public static final int NUMBER9_VALUE = 134;
   public static final int NUMBER10_VALUE = 135;
   public static final int NUMBER11_VALUE = 136;
   public static final int NUMBER12_VALUE = 137;
   public static final int NUMBER13_VALUE = 138;
   public static final int NUMBER14_VALUE = 139;
   public static final int NUMBER15_VALUE = 140;
   public static final int NUMBER16_VALUE = 141;
   public static final int NUMBER17_VALUE = 142;
   public static final int NUMBER18_VALUE = 143;
   public static final int NUMBER19_VALUE = 144;
   public static final int NUMBER20_VALUE = 145;
   public static final int START6_VALUE = 146;
   public static final int START7_VALUE = 147;
   public static final int START8_VALUE = 148;
   public static final int START9_VALUE = 149;
   public static final int START10_VALUE = 150;
   public static final int TEXT11_VALUE = 151;
   public static final int TEXT12_VALUE = 152;
   public static final int TEXT13_VALUE = 153;
   public static final int TEXT14_VALUE = 154;
   public static final int TEXT15_VALUE = 155;
   public static final int TEXT16_VALUE = 156;
   public static final int TEXT17_VALUE = 157;
   public static final int TEXT18_VALUE = 158;
   public static final int TEXT19_VALUE = 159;
   public static final int TEXT20_VALUE = 160;
   public static final int TEXT21_VALUE = 161;
   public static final int TEXT22_VALUE = 162;
   public static final int TEXT23_VALUE = 163;
   public static final int TEXT24_VALUE = 164;
   public static final int TEXT25_VALUE = 165;
   public static final int TEXT26_VALUE = 166;
   public static final int TEXT27_VALUE = 167;
   public static final int TEXT28_VALUE = 168;
   public static final int TEXT29_VALUE = 169;
   public static final int TEXT30_VALUE = 170;
   public static final int PHONETICS_VALUE = 171;
   public static final int ASSIGNMENT_DELAY_VALUE = 172;
   public static final int ASSIGNMENT_UNITS_VALUE = 173;
   public static final int BASELINE_START_VALUE = 174;
   public static final int BASELINE_FINISH_VALUE = 175;
   public static final int CONFIRMED_VALUE = 176;
   public static final int FINISH_VALUE = 177;
   public static final int LEVELING_DELAY_VALUE = 178;
   public static final int RESPONSE_PENDING_VALUE = 179;
   public static final int START_VALUE = 180;
   public static final int TEAMSTATUS_PENDING_VALUE = 181;
   public static final int CV_VALUE = 182;
   public static final int UPDATE_NEEDED_VALUE = 183;
   public static final int COST_RATE_TABLE_VALUE = 184;
   public static final int ACTUAL_START_VALUE = 185;
   public static final int ACTUAL_FINISH_VALUE = 186;
   public static final int WORKGROUP_VALUE = 187;
   public static final int PROJECT_VALUE = 188;
   public static final int OUTLINE_CODE1_VALUE = 189;
   public static final int OUTLINE_CODE2_VALUE = 190;
   public static final int OUTLINE_CODE3_VALUE = 191;
   public static final int OUTLINE_CODE4_VALUE = 192;
   public static final int OUTLINE_CODE5_VALUE = 193;
   public static final int OUTLINE_CODE6_VALUE = 194;
   public static final int OUTLINE_CODE7_VALUE = 195;
   public static final int OUTLINE_CODE8_VALUE = 196;
   public static final int OUTLINE_CODE9_VALUE = 197;
   public static final int OUTLINE_CODE10_VALUE = 198;
   public static final int MATERIAL_LABEL_VALUE = 199;
   public static final int TYPE_VALUE = 200;
   public static final int VAC_VALUE = 201;
   public static final int GROUP_BY_SUMMARY_VALUE = 202;
   public static final int WINDOWS_USER_ACCOUNT_VALUE = 203;

   public static final int BASELINE1_WORK_VALUE = 204;
   public static final int BASELINE1_COST_VALUE = 205;
   public static final int BASELINE2_WORK_VALUE = 206;
   public static final int BASELINE2_COST_VALUE = 207;
   public static final int BASELINE3_WORK_VALUE = 208;
   public static final int BASELINE3_COST_VALUE = 209;
   public static final int BASELINE4_WORK_VALUE = 210;
   public static final int BASELINE4_COST_VALUE = 211;
   public static final int BASELINE5_WORK_VALUE = 212;
   public static final int BASELINE5_COST_VALUE = 213;
   public static final int BASELINE6_WORK_VALUE = 214;
   public static final int BASELINE6_COST_VALUE = 215;
   public static final int BASELINE7_WORK_VALUE = 216;
   public static final int BASELINE7_COST_VALUE = 217;
   public static final int BASELINE8_WORK_VALUE = 218;
   public static final int BASELINE8_COST_VALUE = 219;
   public static final int BASELINE9_WORK_VALUE = 220;
   public static final int BASELINE9_COST_VALUE = 221;
   public static final int BASELINE10_WORK_VALUE = 222;
   public static final int BASELINE10_COST_VALUE = 223;

   public static final int ENTERPRISE_COST1_VALUE = 224;
   public static final int ENTERPRISE_COST2_VALUE = 225;
   public static final int ENTERPRISE_COST3_VALUE = 226;
   public static final int ENTERPRISE_COST4_VALUE = 227;
   public static final int ENTERPRISE_COST5_VALUE = 228;
   public static final int ENTERPRISE_COST6_VALUE = 229;
   public static final int ENTERPRISE_COST7_VALUE = 230;
   public static final int ENTERPRISE_COST8_VALUE = 231;
   public static final int ENTERPRISE_COST9_VALUE = 232;
   public static final int ENTERPRISE_COST10_VALUE = 233;
   public static final int ENTERPRISE_DATE1_VALUE = 234;
   public static final int ENTERPRISE_DATE2_VALUE = 235;
   public static final int ENTERPRISE_DATE3_VALUE = 236;
   public static final int ENTERPRISE_DATE4_VALUE = 237;
   public static final int ENTERPRISE_DATE5_VALUE = 238;
   public static final int ENTERPRISE_DATE6_VALUE = 239;
   public static final int ENTERPRISE_DATE7_VALUE = 240;
   public static final int ENTERPRISE_DATE8_VALUE = 241;
   public static final int ENTERPRISE_DATE9_VALUE = 242;
   public static final int ENTERPRISE_DATE10_VALUE = 243;
   public static final int ENTERPRISE_DATE11_VALUE = 244;
   public static final int ENTERPRISE_DATE12_VALUE = 245;
   public static final int ENTERPRISE_DATE13_VALUE = 246;
   public static final int ENTERPRISE_DATE14_VALUE = 247;
   public static final int ENTERPRISE_DATE15_VALUE = 248;
   public static final int ENTERPRISE_DATE16_VALUE = 249;
   public static final int ENTERPRISE_DATE17_VALUE = 250;
   public static final int ENTERPRISE_DATE18_VALUE = 251;
   public static final int ENTERPRISE_DATE19_VALUE = 252;
   public static final int ENTERPRISE_DATE20_VALUE = 253;
   public static final int ENTERPRISE_DATE21_VALUE = 254;
   public static final int ENTERPRISE_DATE22_VALUE = 255;
   public static final int ENTERPRISE_DATE23_VALUE = 256;
   public static final int ENTERPRISE_DATE24_VALUE = 257;
   public static final int ENTERPRISE_DATE25_VALUE = 258;
   public static final int ENTERPRISE_DATE26_VALUE = 259;
   public static final int ENTERPRISE_DATE27_VALUE = 260;
   public static final int ENTERPRISE_DATE28_VALUE = 261;
   public static final int ENTERPRISE_DATE29_VALUE = 262;
   public static final int ENTERPRISE_DATE30_VALUE = 263;
   public static final int ENTERPRISE_DURATION1_VALUE = 264;
   public static final int ENTERPRISE_DURATION2_VALUE = 265;
   public static final int ENTERPRISE_DURATION3_VALUE = 266;
   public static final int ENTERPRISE_DURATION4_VALUE = 267;
   public static final int ENTERPRISE_DURATION5_VALUE = 268;
   public static final int ENTERPRISE_DURATION6_VALUE = 269;
   public static final int ENTERPRISE_DURATION7_VALUE = 270;
   public static final int ENTERPRISE_DURATION8_VALUE = 271;
   public static final int ENTERPRISE_DURATION9_VALUE = 272;
   public static final int ENTERPRISE_DURATION10_VALUE = 273;
   public static final int ENTERPRISE_FLAG1_VALUE = 274;
   public static final int ENTERPRISE_FLAG2_VALUE = 275;
   public static final int ENTERPRISE_FLAG3_VALUE = 276;
   public static final int ENTERPRISE_FLAG4_VALUE = 277;
   public static final int ENTERPRISE_FLAG5_VALUE = 278;
   public static final int ENTERPRISE_FLAG6_VALUE = 279;
   public static final int ENTERPRISE_FLAG7_VALUE = 280;
   public static final int ENTERPRISE_FLAG8_VALUE = 281;
   public static final int ENTERPRISE_FLAG9_VALUE = 282;
   public static final int ENTERPRISE_FLAG10_VALUE = 283;
   public static final int ENTERPRISE_FLAG11_VALUE = 284;
   public static final int ENTERPRISE_FLAG12_VALUE = 285;
   public static final int ENTERPRISE_FLAG13_VALUE = 286;
   public static final int ENTERPRISE_FLAG14_VALUE = 287;
   public static final int ENTERPRISE_FLAG15_VALUE = 288;
   public static final int ENTERPRISE_FLAG16_VALUE = 289;
   public static final int ENTERPRISE_FLAG17_VALUE = 290;
   public static final int ENTERPRISE_FLAG18_VALUE = 291;
   public static final int ENTERPRISE_FLAG19_VALUE = 292;
   public static final int ENTERPRISE_FLAG20_VALUE = 293;
   public static final int ENTERPRISE_NUMBER1_VALUE = 294;
   public static final int ENTERPRISE_NUMBER2_VALUE = 295;
   public static final int ENTERPRISE_NUMBER3_VALUE = 296;
   public static final int ENTERPRISE_NUMBER4_VALUE = 297;
   public static final int ENTERPRISE_NUMBER5_VALUE = 298;
   public static final int ENTERPRISE_NUMBER6_VALUE = 299;
   public static final int ENTERPRISE_NUMBER7_VALUE = 300;
   public static final int ENTERPRISE_NUMBER8_VALUE = 301;
   public static final int ENTERPRISE_NUMBER9_VALUE = 302;
   public static final int ENTERPRISE_NUMBER10_VALUE = 303;
   public static final int ENTERPRISE_NUMBER11_VALUE = 304;
   public static final int ENTERPRISE_NUMBER12_VALUE = 305;
   public static final int ENTERPRISE_NUMBER13_VALUE = 306;
   public static final int ENTERPRISE_NUMBER14_VALUE = 307;
   public static final int ENTERPRISE_NUMBER15_VALUE = 308;
   public static final int ENTERPRISE_NUMBER16_VALUE = 309;
   public static final int ENTERPRISE_NUMBER17_VALUE = 310;
   public static final int ENTERPRISE_NUMBER18_VALUE = 311;
   public static final int ENTERPRISE_NUMBER19_VALUE = 312;
   public static final int ENTERPRISE_NUMBER20_VALUE = 313;
   public static final int ENTERPRISE_NUMBER21_VALUE = 314;
   public static final int ENTERPRISE_NUMBER22_VALUE = 315;
   public static final int ENTERPRISE_NUMBER23_VALUE = 316;
   public static final int ENTERPRISE_NUMBER24_VALUE = 317;
   public static final int ENTERPRISE_NUMBER25_VALUE = 318;
   public static final int ENTERPRISE_NUMBER26_VALUE = 319;
   public static final int ENTERPRISE_NUMBER27_VALUE = 320;
   public static final int ENTERPRISE_NUMBER28_VALUE = 321;
   public static final int ENTERPRISE_NUMBER29_VALUE = 322;
   public static final int ENTERPRISE_NUMBER30_VALUE = 323;
   public static final int ENTERPRISE_NUMBER31_VALUE = 324;
   public static final int ENTERPRISE_NUMBER32_VALUE = 325;
   public static final int ENTERPRISE_NUMBER33_VALUE = 326;
   public static final int ENTERPRISE_NUMBER34_VALUE = 327;
   public static final int ENTERPRISE_NUMBER35_VALUE = 328;
   public static final int ENTERPRISE_NUMBER36_VALUE = 329;
   public static final int ENTERPRISE_NUMBER37_VALUE = 330;
   public static final int ENTERPRISE_NUMBER38_VALUE = 331;
   public static final int ENTERPRISE_NUMBER39_VALUE = 332;
   public static final int ENTERPRISE_NUMBER40_VALUE = 333;
   public static final int ENTERPRISE_TEXT1_VALUE = 334;
   public static final int ENTERPRISE_TEXT2_VALUE = 335;
   public static final int ENTERPRISE_TEXT3_VALUE = 336;
   public static final int ENTERPRISE_TEXT4_VALUE = 337;
   public static final int ENTERPRISE_TEXT5_VALUE = 338;
   public static final int ENTERPRISE_TEXT6_VALUE = 339;
   public static final int ENTERPRISE_TEXT7_VALUE = 340;
   public static final int ENTERPRISE_TEXT8_VALUE = 341;
   public static final int ENTERPRISE_TEXT9_VALUE = 342;
   public static final int ENTERPRISE_TEXT10_VALUE = 343;
   public static final int ENTERPRISE_TEXT11_VALUE = 344;
   public static final int ENTERPRISE_TEXT12_VALUE = 345;
   public static final int ENTERPRISE_TEXT13_VALUE = 346;
   public static final int ENTERPRISE_TEXT14_VALUE = 347;
   public static final int ENTERPRISE_TEXT15_VALUE = 348;
   public static final int ENTERPRISE_TEXT16_VALUE = 349;
   public static final int ENTERPRISE_TEXT17_VALUE = 350;
   public static final int ENTERPRISE_TEXT18_VALUE = 351;
   public static final int ENTERPRISE_TEXT19_VALUE = 352;
   public static final int ENTERPRISE_TEXT20_VALUE = 353;
   public static final int ENTERPRISE_TEXT21_VALUE = 354;
   public static final int ENTERPRISE_TEXT22_VALUE = 355;
   public static final int ENTERPRISE_TEXT23_VALUE = 356;
   public static final int ENTERPRISE_TEXT24_VALUE = 357;
   public static final int ENTERPRISE_TEXT25_VALUE = 358;
   public static final int ENTERPRISE_TEXT26_VALUE = 359;
   public static final int ENTERPRISE_TEXT27_VALUE = 360;
   public static final int ENTERPRISE_TEXT28_VALUE = 361;
   public static final int ENTERPRISE_TEXT29_VALUE = 362;
   public static final int ENTERPRISE_TEXT30_VALUE = 363;
   public static final int ENTERPRISE_TEXT31_VALUE = 364;
   public static final int ENTERPRISE_TEXT32_VALUE = 365;
   public static final int ENTERPRISE_TEXT33_VALUE = 366;
   public static final int ENTERPRISE_TEXT34_VALUE = 367;
   public static final int ENTERPRISE_TEXT35_VALUE = 368;
   public static final int ENTERPRISE_TEXT36_VALUE = 369;
   public static final int ENTERPRISE_TEXT37_VALUE = 370;
   public static final int ENTERPRISE_TEXT38_VALUE = 371;
   public static final int ENTERPRISE_TEXT39_VALUE = 372;
   public static final int ENTERPRISE_TEXT40_VALUE = 373;
   public static final int ENTERPRISE_VALUE = 374;
   public static final int ERRORS_VALUE = 375;
   public static final int IMPORT_VALUE = 376;
   public static final int CREATED_VALUE = 377;
   public static final int BUDGET_VALUE = 378;
   public static final int TASK_OUTLINE_NUMBER_VALUE = 379;
   public static final int GUID_VALUE = 380;

   public static final int MAX_VALUE = 381;
   private static final ResourceField[] TYPE_VALUES = new ResourceField[MAX_VALUE];

   public static final ResourceField ID = new ResourceField(ID_VALUE, DataType.NUMERIC);
   public static final ResourceField NAME = new ResourceField(NAME_VALUE, DataType.STRING);
   public static final ResourceField INITIALS = new ResourceField(INITIALS_VALUE, DataType.STRING);
   public static final ResourceField GROUP = new ResourceField(GROUP_VALUE, DataType.STRING);
   public static final ResourceField MAX_UNITS = new ResourceField(MAX_UNITS_VALUE, DataType.UNITS);
   public static final ResourceField BASE_CALENDAR = new ResourceField(BASE_CALENDAR_VALUE, DataType.STRING);
   public static final ResourceField STANDARD_RATE = new ResourceField(STANDARD_RATE_VALUE, DataType.RATE);
   public static final ResourceField OVERTIME_RATE = new ResourceField(OVERTIME_RATE_VALUE, DataType.RATE);
   public static final ResourceField TEXT1 = new ResourceField(TEXT1_VALUE, DataType.STRING);
   public static final ResourceField TEXT2 = new ResourceField(TEXT2_VALUE, DataType.STRING);
   public static final ResourceField CODE = new ResourceField(CODE_VALUE, DataType.STRING);
   public static final ResourceField ACTUAL_COST = new ResourceField(ACTUAL_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField COST = new ResourceField(COST_VALUE, DataType.CURRENCY);
   public static final ResourceField WORK = new ResourceField(WORK_VALUE, DataType.DURATION);
   public static final ResourceField ACTUAL_WORK = new ResourceField(ACTUAL_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE_WORK = new ResourceField(BASELINE_WORK_VALUE, DataType.DURATION);
   public static final ResourceField OVERTIME_WORK = new ResourceField(OVERTIME_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE_COST = new ResourceField(BASELINE_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField COST_PER_USE = new ResourceField(COST_PER_USE_VALUE, DataType.CURRENCY);
   public static final ResourceField ACCRUE_AT = new ResourceField(ACCRUE_AT_VALUE, DataType.ACCRUE);
   public static final ResourceField REMAINING_COST = new ResourceField(REMAINING_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField REMAINING_WORK = new ResourceField(REMAINING_WORK_VALUE, DataType.DURATION);
   public static final ResourceField WORK_VARIANCE = new ResourceField(WORK_VARIANCE_VALUE, DataType.DURATION);
   public static final ResourceField COST_VARIANCE = new ResourceField(COST_VARIANCE_VALUE, DataType.CURRENCY);
   public static final ResourceField OVERALLOCATED = new ResourceField(OVERALLOCATED_VALUE, DataType.BOOLEAN);
   public static final ResourceField PEAK = new ResourceField(PEAK_VALUE, DataType.NUMERIC);
   public static final ResourceField UNIQUE_ID = new ResourceField(UNIQUE_ID_VALUE, DataType.NUMERIC);
   public static final ResourceField NOTES = new ResourceField(NOTES_VALUE, DataType.STRING);
   public static final ResourceField PERCENT_WORK_COMPLETE = new ResourceField(PERCENT_WORK_COMPLETE_VALUE, DataType.PERCENTAGE);
   public static final ResourceField TEXT3 = new ResourceField(TEXT3_VALUE, DataType.STRING);
   public static final ResourceField TEXT4 = new ResourceField(TEXT4_VALUE, DataType.STRING);
   public static final ResourceField TEXT5 = new ResourceField(TEXT5_VALUE, DataType.STRING);
   public static final ResourceField OBJECTS = new ResourceField(OBJECTS_VALUE, DataType.NUMERIC);
   public static final ResourceField LINKED_FIELDS = new ResourceField(LINKED_FIELDS_VALUE, DataType.STRING);
   public static final ResourceField EMAIL_ADDRESS = new ResourceField(EMAIL_ADDRESS_VALUE, DataType.STRING);
   public static final ResourceField REGULAR_WORK = new ResourceField(REGULAR_WORK_VALUE, DataType.DURATION);
   public static final ResourceField ACTUAL_OVERTIME_WORK = new ResourceField(ACTUAL_OVERTIME_WORK_VALUE, DataType.DURATION);
   public static final ResourceField REMAINING_OVERTIME_WORK = new ResourceField(REMAINING_OVERTIME_WORK_VALUE, DataType.DURATION);
   public static final ResourceField OVERTIME_COST = new ResourceField(OVERTIME_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField ACTUAL_OVERTIME_COST = new ResourceField(ACTUAL_OVERTIME_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField REMAINING_OVERTIME_COST = new ResourceField(REMAINING_OVERTIME_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BCWS = new ResourceField(BCWS_VALUE, DataType.NUMERIC);
   public static final ResourceField BCWP = new ResourceField(BCWP_VALUE, DataType.NUMERIC);
   public static final ResourceField ACWP = new ResourceField(ACWP_VALUE, DataType.NUMERIC);
   public static final ResourceField SV = new ResourceField(SV_VALUE, DataType.NUMERIC);
   public static final ResourceField AVAILABLE_FROM = new ResourceField(AVAILABLE_FROM_VALUE, DataType.DATE);
   public static final ResourceField AVAILABLE_TO = new ResourceField(AVAILABLE_TO_VALUE, DataType.DATE);
   public static final ResourceField INDICATORS = new ResourceField(INDICATORS_VALUE, DataType.STRING);
   public static final ResourceField TEXT6 = new ResourceField(TEXT6_VALUE, DataType.STRING);
   public static final ResourceField TEXT7 = new ResourceField(TEXT7_VALUE, DataType.STRING);
   public static final ResourceField TEXT8 = new ResourceField(TEXT8_VALUE, DataType.STRING);
   public static final ResourceField TEXT9 = new ResourceField(TEXT9_VALUE, DataType.STRING);
   public static final ResourceField TEXT10 = new ResourceField(TEXT10_VALUE, DataType.STRING);
   public static final ResourceField START1 = new ResourceField(START1_VALUE, DataType.DATE);
   public static final ResourceField START2 = new ResourceField(START2_VALUE, DataType.DATE);
   public static final ResourceField START3 = new ResourceField(START3_VALUE, DataType.DATE);
   public static final ResourceField START4 = new ResourceField(START4_VALUE, DataType.DATE);
   public static final ResourceField START5 = new ResourceField(START5_VALUE, DataType.DATE);
   public static final ResourceField FINISH1 = new ResourceField(FINISH1_VALUE, DataType.DATE);
   public static final ResourceField FINISH2 = new ResourceField(FINISH2_VALUE, DataType.DATE);
   public static final ResourceField FINISH3 = new ResourceField(FINISH3_VALUE, DataType.DATE);
   public static final ResourceField FINISH4 = new ResourceField(FINISH4_VALUE, DataType.DATE);
   public static final ResourceField FINISH5 = new ResourceField(FINISH5_VALUE, DataType.DATE);
   public static final ResourceField NUMBER1 = new ResourceField(NUMBER1_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER2 = new ResourceField(NUMBER2_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER3 = new ResourceField(NUMBER3_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER4 = new ResourceField(NUMBER4_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER5 = new ResourceField(NUMBER5_VALUE, DataType.NUMERIC);
   public static final ResourceField DURATION1 = new ResourceField(DURATION1_VALUE, DataType.DURATION);
   public static final ResourceField DURATION2 = new ResourceField(DURATION2_VALUE, DataType.DURATION);
   public static final ResourceField DURATION3 = new ResourceField(DURATION3_VALUE, DataType.DURATION);
   public static final ResourceField COST1 = new ResourceField(COST1_VALUE, DataType.CURRENCY);
   public static final ResourceField COST2 = new ResourceField(COST2_VALUE, DataType.CURRENCY);
   public static final ResourceField COST3 = new ResourceField(COST3_VALUE, DataType.CURRENCY);
   public static final ResourceField FLAG10 = new ResourceField(FLAG10_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG1 = new ResourceField(FLAG1_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG2 = new ResourceField(FLAG2_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG3 = new ResourceField(FLAG3_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG4 = new ResourceField(FLAG4_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG5 = new ResourceField(FLAG5_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG6 = new ResourceField(FLAG6_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG7 = new ResourceField(FLAG7_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG8 = new ResourceField(FLAG8_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG9 = new ResourceField(FLAG9_VALUE, DataType.BOOLEAN);
   public static final ResourceField HYPERLINK = new ResourceField(HYPERLINK_VALUE, DataType.STRING);
   public static final ResourceField HYPERLINK_ADDRESS = new ResourceField(HYPERLINK_ADDRESS_VALUE, DataType.STRING);
   public static final ResourceField HYPERLINK_SUBADDRESS = new ResourceField(HYPERLINK_SUBADDRESS_VALUE, DataType.STRING);
   public static final ResourceField HYPERLINK_HREF = new ResourceField(HYPERLINK_HREF_VALUE, DataType.STRING);
   public static final ResourceField ASSIGNMENT = new ResourceField(ASSIGNMENT_VALUE, DataType.STRING);
   public static final ResourceField TASK_SUMMARY_NAME = new ResourceField(TASK_SUMMARY_NAME_VALUE, DataType.STRING);
   public static final ResourceField CAN_LEVEL = new ResourceField(CAN_LEVEL_VALUE, DataType.BOOLEAN);
   public static final ResourceField WORK_CONTOUR = new ResourceField(WORK_CONTOUR_VALUE, DataType.STRING);
   public static final ResourceField COST4 = new ResourceField(COST4_VALUE, DataType.CURRENCY);
   public static final ResourceField COST5 = new ResourceField(COST5_VALUE, DataType.CURRENCY);
   public static final ResourceField COST6 = new ResourceField(COST6_VALUE, DataType.CURRENCY);
   public static final ResourceField COST7 = new ResourceField(COST7_VALUE, DataType.CURRENCY);
   public static final ResourceField COST8 = new ResourceField(COST8_VALUE, DataType.CURRENCY);
   public static final ResourceField COST9 = new ResourceField(COST9_VALUE, DataType.CURRENCY);
   public static final ResourceField COST10 = new ResourceField(COST10_VALUE, DataType.CURRENCY);
   public static final ResourceField DATE1 = new ResourceField(DATE1_VALUE, DataType.DATE);
   public static final ResourceField DATE2 = new ResourceField(DATE2_VALUE, DataType.DATE);
   public static final ResourceField DATE3 = new ResourceField(DATE3_VALUE, DataType.DATE);
   public static final ResourceField DATE4 = new ResourceField(DATE4_VALUE, DataType.DATE);
   public static final ResourceField DATE5 = new ResourceField(DATE5_VALUE, DataType.DATE);
   public static final ResourceField DATE6 = new ResourceField(DATE6_VALUE, DataType.DATE);
   public static final ResourceField DATE7 = new ResourceField(DATE7_VALUE, DataType.DATE);
   public static final ResourceField DATE8 = new ResourceField(DATE8_VALUE, DataType.DATE);
   public static final ResourceField DATE9 = new ResourceField(DATE9_VALUE, DataType.DATE);
   public static final ResourceField DATE10 = new ResourceField(DATE10_VALUE, DataType.DATE);
   public static final ResourceField DURATION4 = new ResourceField(DURATION4_VALUE, DataType.DURATION);
   public static final ResourceField DURATION5 = new ResourceField(DURATION5_VALUE, DataType.DURATION);
   public static final ResourceField DURATION6 = new ResourceField(DURATION6_VALUE, DataType.DURATION);
   public static final ResourceField DURATION7 = new ResourceField(DURATION7_VALUE, DataType.DURATION);
   public static final ResourceField DURATION8 = new ResourceField(DURATION8_VALUE, DataType.DURATION);
   public static final ResourceField DURATION9 = new ResourceField(DURATION9_VALUE, DataType.DURATION);
   public static final ResourceField DURATION10 = new ResourceField(DURATION10_VALUE, DataType.DURATION);
   public static final ResourceField FINISH6 = new ResourceField(FINISH6_VALUE, DataType.DATE);
   public static final ResourceField FINISH7 = new ResourceField(FINISH7_VALUE, DataType.DATE);
   public static final ResourceField FINISH8 = new ResourceField(FINISH8_VALUE, DataType.DATE);
   public static final ResourceField FINISH9 = new ResourceField(FINISH9_VALUE, DataType.DATE);
   public static final ResourceField FINISH10 = new ResourceField(FINISH10_VALUE, DataType.DATE);
   public static final ResourceField FLAG11 = new ResourceField(FLAG11_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG12 = new ResourceField(FLAG12_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG13 = new ResourceField(FLAG13_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG14 = new ResourceField(FLAG14_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG15 = new ResourceField(FLAG15_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG16 = new ResourceField(FLAG16_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG17 = new ResourceField(FLAG17_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG18 = new ResourceField(FLAG18_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG19 = new ResourceField(FLAG19_VALUE, DataType.BOOLEAN);
   public static final ResourceField FLAG20 = new ResourceField(FLAG20_VALUE, DataType.BOOLEAN);
   public static final ResourceField NUMBER6 = new ResourceField(NUMBER6_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER7 = new ResourceField(NUMBER7_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER8 = new ResourceField(NUMBER8_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER9 = new ResourceField(NUMBER9_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER10 = new ResourceField(NUMBER10_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER11 = new ResourceField(NUMBER11_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER12 = new ResourceField(NUMBER12_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER13 = new ResourceField(NUMBER13_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER14 = new ResourceField(NUMBER14_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER15 = new ResourceField(NUMBER15_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER16 = new ResourceField(NUMBER16_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER17 = new ResourceField(NUMBER17_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER18 = new ResourceField(NUMBER18_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER19 = new ResourceField(NUMBER19_VALUE, DataType.NUMERIC);
   public static final ResourceField NUMBER20 = new ResourceField(NUMBER20_VALUE, DataType.NUMERIC);
   public static final ResourceField START6 = new ResourceField(START6_VALUE, DataType.DATE);
   public static final ResourceField START7 = new ResourceField(START7_VALUE, DataType.DATE);
   public static final ResourceField START8 = new ResourceField(START8_VALUE, DataType.DATE);
   public static final ResourceField START9 = new ResourceField(START9_VALUE, DataType.DATE);
   public static final ResourceField START10 = new ResourceField(START10_VALUE, DataType.DATE);
   public static final ResourceField TEXT11 = new ResourceField(TEXT11_VALUE, DataType.STRING);
   public static final ResourceField TEXT12 = new ResourceField(TEXT12_VALUE, DataType.STRING);
   public static final ResourceField TEXT13 = new ResourceField(TEXT13_VALUE, DataType.STRING);
   public static final ResourceField TEXT14 = new ResourceField(TEXT14_VALUE, DataType.STRING);
   public static final ResourceField TEXT15 = new ResourceField(TEXT15_VALUE, DataType.STRING);
   public static final ResourceField TEXT16 = new ResourceField(TEXT16_VALUE, DataType.STRING);
   public static final ResourceField TEXT17 = new ResourceField(TEXT17_VALUE, DataType.STRING);
   public static final ResourceField TEXT18 = new ResourceField(TEXT18_VALUE, DataType.STRING);
   public static final ResourceField TEXT19 = new ResourceField(TEXT19_VALUE, DataType.STRING);
   public static final ResourceField TEXT20 = new ResourceField(TEXT20_VALUE, DataType.STRING);
   public static final ResourceField TEXT21 = new ResourceField(TEXT21_VALUE, DataType.STRING);
   public static final ResourceField TEXT22 = new ResourceField(TEXT22_VALUE, DataType.STRING);
   public static final ResourceField TEXT23 = new ResourceField(TEXT23_VALUE, DataType.STRING);
   public static final ResourceField TEXT24 = new ResourceField(TEXT24_VALUE, DataType.STRING);
   public static final ResourceField TEXT25 = new ResourceField(TEXT25_VALUE, DataType.STRING);
   public static final ResourceField TEXT26 = new ResourceField(TEXT26_VALUE, DataType.STRING);
   public static final ResourceField TEXT27 = new ResourceField(TEXT27_VALUE, DataType.STRING);
   public static final ResourceField TEXT28 = new ResourceField(TEXT28_VALUE, DataType.STRING);
   public static final ResourceField TEXT29 = new ResourceField(TEXT29_VALUE, DataType.STRING);
   public static final ResourceField TEXT30 = new ResourceField(TEXT30_VALUE, DataType.STRING);
   public static final ResourceField PHONETICS = new ResourceField(PHONETICS_VALUE, DataType.STRING);
   public static final ResourceField ASSIGNMENT_DELAY = new ResourceField(ASSIGNMENT_DELAY_VALUE, DataType.STRING);
   public static final ResourceField ASSIGNMENT_UNITS = new ResourceField(ASSIGNMENT_UNITS_VALUE, DataType.STRING);
   public static final ResourceField BASELINE_START = new ResourceField(BASELINE_START_VALUE, DataType.DATE);
   public static final ResourceField BASELINE_FINISH = new ResourceField(BASELINE_FINISH_VALUE, DataType.DATE);
   public static final ResourceField CONFIRMED = new ResourceField(CONFIRMED_VALUE, DataType.BOOLEAN);
   public static final ResourceField FINISH = new ResourceField(FINISH_VALUE, DataType.DATE);
   public static final ResourceField LEVELING_DELAY = new ResourceField(LEVELING_DELAY_VALUE, DataType.STRING);
   public static final ResourceField RESPONSE_PENDING = new ResourceField(RESPONSE_PENDING_VALUE, DataType.BOOLEAN);
   public static final ResourceField START = new ResourceField(START_VALUE, DataType.DATE);
   public static final ResourceField TEAMSTATUS_PENDING = new ResourceField(TEAMSTATUS_PENDING_VALUE, DataType.BOOLEAN);
   public static final ResourceField CV = new ResourceField(CV_VALUE, DataType.NUMERIC);
   public static final ResourceField UPDATE_NEEDED = new ResourceField(UPDATE_NEEDED_VALUE, DataType.BOOLEAN);
   public static final ResourceField COST_RATE_TABLE = new ResourceField(COST_RATE_TABLE_VALUE, DataType.STRING);
   public static final ResourceField ACTUAL_START = new ResourceField(ACTUAL_START_VALUE, DataType.DATE);
   public static final ResourceField ACTUAL_FINISH = new ResourceField(ACTUAL_FINISH_VALUE, DataType.DATE);
   public static final ResourceField WORKGROUP = new ResourceField(WORKGROUP_VALUE, DataType.STRING);
   public static final ResourceField PROJECT = new ResourceField(PROJECT_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE1 = new ResourceField(OUTLINE_CODE1_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE2 = new ResourceField(OUTLINE_CODE2_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE3 = new ResourceField(OUTLINE_CODE3_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE4 = new ResourceField(OUTLINE_CODE4_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE5 = new ResourceField(OUTLINE_CODE5_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE6 = new ResourceField(OUTLINE_CODE6_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE7 = new ResourceField(OUTLINE_CODE7_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE8 = new ResourceField(OUTLINE_CODE8_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE9 = new ResourceField(OUTLINE_CODE9_VALUE, DataType.STRING);
   public static final ResourceField OUTLINE_CODE10 = new ResourceField(OUTLINE_CODE10_VALUE, DataType.STRING);
   public static final ResourceField MATERIAL_LABEL = new ResourceField(MATERIAL_LABEL_VALUE, DataType.STRING);
   public static final ResourceField TYPE = new ResourceField(TYPE_VALUE, DataType.RESOURCE_TYPE);
   public static final ResourceField VAC = new ResourceField(VAC_VALUE, DataType.CURRENCY);
   public static final ResourceField GROUP_BY_SUMMARY = new ResourceField(GROUP_BY_SUMMARY_VALUE, DataType.STRING);
   public static final ResourceField WINDOWS_USER_ACCOUNT = new ResourceField(WINDOWS_USER_ACCOUNT_VALUE, DataType.STRING);
   public static final ResourceField BASELINE1_WORK = new ResourceField(BASELINE1_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE1_COST = new ResourceField(BASELINE1_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE2_WORK = new ResourceField(BASELINE2_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE2_COST = new ResourceField(BASELINE2_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE3_WORK = new ResourceField(BASELINE3_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE3_COST = new ResourceField(BASELINE3_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE4_WORK = new ResourceField(BASELINE4_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE4_COST = new ResourceField(BASELINE4_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE5_WORK = new ResourceField(BASELINE5_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE5_COST = new ResourceField(BASELINE5_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE6_WORK = new ResourceField(BASELINE6_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE6_COST = new ResourceField(BASELINE6_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE7_WORK = new ResourceField(BASELINE7_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE7_COST = new ResourceField(BASELINE7_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE8_WORK = new ResourceField(BASELINE8_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE8_COST = new ResourceField(BASELINE8_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE9_WORK = new ResourceField(BASELINE9_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE9_COST = new ResourceField(BASELINE9_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField BASELINE10_WORK = new ResourceField(BASELINE10_WORK_VALUE, DataType.DURATION);
   public static final ResourceField BASELINE10_COST = new ResourceField(BASELINE10_COST_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST1 = new ResourceField(ENTERPRISE_COST1_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST2 = new ResourceField(ENTERPRISE_COST2_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST3 = new ResourceField(ENTERPRISE_COST3_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST4 = new ResourceField(ENTERPRISE_COST4_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST5 = new ResourceField(ENTERPRISE_COST5_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST6 = new ResourceField(ENTERPRISE_COST6_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST7 = new ResourceField(ENTERPRISE_COST7_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST8 = new ResourceField(ENTERPRISE_COST8_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST9 = new ResourceField(ENTERPRISE_COST9_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_COST10 = new ResourceField(ENTERPRISE_COST10_VALUE, DataType.CURRENCY);
   public static final ResourceField ENTERPRISE_DATE1 = new ResourceField(ENTERPRISE_DATE1_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE2 = new ResourceField(ENTERPRISE_DATE2_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE3 = new ResourceField(ENTERPRISE_DATE3_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE4 = new ResourceField(ENTERPRISE_DATE4_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE5 = new ResourceField(ENTERPRISE_DATE5_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE6 = new ResourceField(ENTERPRISE_DATE6_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE7 = new ResourceField(ENTERPRISE_DATE7_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE8 = new ResourceField(ENTERPRISE_DATE8_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE9 = new ResourceField(ENTERPRISE_DATE9_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE10 = new ResourceField(ENTERPRISE_DATE10_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE11 = new ResourceField(ENTERPRISE_DATE11_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE12 = new ResourceField(ENTERPRISE_DATE12_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE13 = new ResourceField(ENTERPRISE_DATE13_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE14 = new ResourceField(ENTERPRISE_DATE14_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE15 = new ResourceField(ENTERPRISE_DATE15_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE16 = new ResourceField(ENTERPRISE_DATE16_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE17 = new ResourceField(ENTERPRISE_DATE17_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE18 = new ResourceField(ENTERPRISE_DATE18_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE19 = new ResourceField(ENTERPRISE_DATE19_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE20 = new ResourceField(ENTERPRISE_DATE20_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE21 = new ResourceField(ENTERPRISE_DATE21_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE22 = new ResourceField(ENTERPRISE_DATE22_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE23 = new ResourceField(ENTERPRISE_DATE23_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE24 = new ResourceField(ENTERPRISE_DATE24_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE25 = new ResourceField(ENTERPRISE_DATE25_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE26 = new ResourceField(ENTERPRISE_DATE26_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE27 = new ResourceField(ENTERPRISE_DATE27_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE28 = new ResourceField(ENTERPRISE_DATE28_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE29 = new ResourceField(ENTERPRISE_DATE29_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DATE30 = new ResourceField(ENTERPRISE_DATE30_VALUE, DataType.DATE);
   public static final ResourceField ENTERPRISE_DURATION1 = new ResourceField(ENTERPRISE_DURATION1_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION2 = new ResourceField(ENTERPRISE_DURATION2_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION3 = new ResourceField(ENTERPRISE_DURATION3_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION4 = new ResourceField(ENTERPRISE_DURATION4_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION5 = new ResourceField(ENTERPRISE_DURATION5_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION6 = new ResourceField(ENTERPRISE_DURATION6_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION7 = new ResourceField(ENTERPRISE_DURATION7_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION8 = new ResourceField(ENTERPRISE_DURATION8_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION9 = new ResourceField(ENTERPRISE_DURATION9_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_DURATION10 = new ResourceField(ENTERPRISE_DURATION10_VALUE, DataType.DURATION);
   public static final ResourceField ENTERPRISE_FLAG1 = new ResourceField(ENTERPRISE_FLAG1_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG2 = new ResourceField(ENTERPRISE_FLAG2_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG3 = new ResourceField(ENTERPRISE_FLAG3_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG4 = new ResourceField(ENTERPRISE_FLAG4_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG5 = new ResourceField(ENTERPRISE_FLAG5_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG6 = new ResourceField(ENTERPRISE_FLAG6_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG7 = new ResourceField(ENTERPRISE_FLAG7_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG8 = new ResourceField(ENTERPRISE_FLAG8_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG9 = new ResourceField(ENTERPRISE_FLAG9_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG10 = new ResourceField(ENTERPRISE_FLAG10_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG11 = new ResourceField(ENTERPRISE_FLAG11_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG12 = new ResourceField(ENTERPRISE_FLAG12_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG13 = new ResourceField(ENTERPRISE_FLAG13_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG14 = new ResourceField(ENTERPRISE_FLAG14_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG15 = new ResourceField(ENTERPRISE_FLAG15_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG16 = new ResourceField(ENTERPRISE_FLAG16_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG17 = new ResourceField(ENTERPRISE_FLAG17_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG18 = new ResourceField(ENTERPRISE_FLAG18_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG19 = new ResourceField(ENTERPRISE_FLAG19_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_FLAG20 = new ResourceField(ENTERPRISE_FLAG20_VALUE, DataType.BOOLEAN);
   public static final ResourceField ENTERPRISE_NUMBER1 = new ResourceField(ENTERPRISE_NUMBER1_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER2 = new ResourceField(ENTERPRISE_NUMBER2_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER3 = new ResourceField(ENTERPRISE_NUMBER3_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER4 = new ResourceField(ENTERPRISE_NUMBER4_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER5 = new ResourceField(ENTERPRISE_NUMBER5_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER6 = new ResourceField(ENTERPRISE_NUMBER6_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER7 = new ResourceField(ENTERPRISE_NUMBER7_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER8 = new ResourceField(ENTERPRISE_NUMBER8_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER9 = new ResourceField(ENTERPRISE_NUMBER9_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER10 = new ResourceField(ENTERPRISE_NUMBER10_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER11 = new ResourceField(ENTERPRISE_NUMBER11_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER12 = new ResourceField(ENTERPRISE_NUMBER12_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER13 = new ResourceField(ENTERPRISE_NUMBER13_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER14 = new ResourceField(ENTERPRISE_NUMBER14_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER15 = new ResourceField(ENTERPRISE_NUMBER15_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER16 = new ResourceField(ENTERPRISE_NUMBER16_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER17 = new ResourceField(ENTERPRISE_NUMBER17_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER18 = new ResourceField(ENTERPRISE_NUMBER18_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER19 = new ResourceField(ENTERPRISE_NUMBER19_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER20 = new ResourceField(ENTERPRISE_NUMBER20_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER21 = new ResourceField(ENTERPRISE_NUMBER21_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER22 = new ResourceField(ENTERPRISE_NUMBER22_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER23 = new ResourceField(ENTERPRISE_NUMBER23_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER24 = new ResourceField(ENTERPRISE_NUMBER24_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER25 = new ResourceField(ENTERPRISE_NUMBER25_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER26 = new ResourceField(ENTERPRISE_NUMBER26_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER27 = new ResourceField(ENTERPRISE_NUMBER27_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER28 = new ResourceField(ENTERPRISE_NUMBER28_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER29 = new ResourceField(ENTERPRISE_NUMBER29_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER30 = new ResourceField(ENTERPRISE_NUMBER30_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER31 = new ResourceField(ENTERPRISE_NUMBER31_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER32 = new ResourceField(ENTERPRISE_NUMBER32_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER33 = new ResourceField(ENTERPRISE_NUMBER33_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER34 = new ResourceField(ENTERPRISE_NUMBER34_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER35 = new ResourceField(ENTERPRISE_NUMBER35_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER36 = new ResourceField(ENTERPRISE_NUMBER36_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER37 = new ResourceField(ENTERPRISE_NUMBER37_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER38 = new ResourceField(ENTERPRISE_NUMBER38_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER39 = new ResourceField(ENTERPRISE_NUMBER39_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_NUMBER40 = new ResourceField(ENTERPRISE_NUMBER40_VALUE, DataType.NUMERIC);
   public static final ResourceField ENTERPRISE_TEXT1 = new ResourceField(ENTERPRISE_TEXT1_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT2 = new ResourceField(ENTERPRISE_TEXT2_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT3 = new ResourceField(ENTERPRISE_TEXT3_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT4 = new ResourceField(ENTERPRISE_TEXT4_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT5 = new ResourceField(ENTERPRISE_TEXT5_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT6 = new ResourceField(ENTERPRISE_TEXT6_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT7 = new ResourceField(ENTERPRISE_TEXT7_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT8 = new ResourceField(ENTERPRISE_TEXT8_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT9 = new ResourceField(ENTERPRISE_TEXT9_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT10 = new ResourceField(ENTERPRISE_TEXT10_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT11 = new ResourceField(ENTERPRISE_TEXT11_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT12 = new ResourceField(ENTERPRISE_TEXT12_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT13 = new ResourceField(ENTERPRISE_TEXT13_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT14 = new ResourceField(ENTERPRISE_TEXT14_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT15 = new ResourceField(ENTERPRISE_TEXT15_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT16 = new ResourceField(ENTERPRISE_TEXT16_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT17 = new ResourceField(ENTERPRISE_TEXT17_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT18 = new ResourceField(ENTERPRISE_TEXT18_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT19 = new ResourceField(ENTERPRISE_TEXT19_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT20 = new ResourceField(ENTERPRISE_TEXT20_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT21 = new ResourceField(ENTERPRISE_TEXT21_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT22 = new ResourceField(ENTERPRISE_TEXT22_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT23 = new ResourceField(ENTERPRISE_TEXT23_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT24 = new ResourceField(ENTERPRISE_TEXT24_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT25 = new ResourceField(ENTERPRISE_TEXT25_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT26 = new ResourceField(ENTERPRISE_TEXT26_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT27 = new ResourceField(ENTERPRISE_TEXT27_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT28 = new ResourceField(ENTERPRISE_TEXT28_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT29 = new ResourceField(ENTERPRISE_TEXT29_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT30 = new ResourceField(ENTERPRISE_TEXT30_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT31 = new ResourceField(ENTERPRISE_TEXT31_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT32 = new ResourceField(ENTERPRISE_TEXT32_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT33 = new ResourceField(ENTERPRISE_TEXT33_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT34 = new ResourceField(ENTERPRISE_TEXT34_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT35 = new ResourceField(ENTERPRISE_TEXT35_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT36 = new ResourceField(ENTERPRISE_TEXT36_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT37 = new ResourceField(ENTERPRISE_TEXT37_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT38 = new ResourceField(ENTERPRISE_TEXT38_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT39 = new ResourceField(ENTERPRISE_TEXT39_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE_TEXT40 = new ResourceField(ENTERPRISE_TEXT40_VALUE, DataType.STRING);
   public static final ResourceField ENTERPRISE = new ResourceField(ENTERPRISE_VALUE, DataType.BOOLEAN);
   public static final ResourceField ERRORS = new ResourceField(ERRORS_VALUE, DataType.STRING);
   public static final ResourceField IMPORT = new ResourceField(IMPORT_VALUE, DataType.BOOLEAN);
   public static final ResourceField CREATED = new ResourceField(CREATED_VALUE, DataType.DATE);
   public static final ResourceField BUDGET = new ResourceField(BUDGET_VALUE, DataType.BOOLEAN);
   public static final ResourceField TASK_OUTLINE_NUMBER = new ResourceField(TASK_OUTLINE_NUMBER_VALUE, DataType.STRING);
   public static final ResourceField GUID = new ResourceField(GUID_VALUE, DataType.STRING);

   private int m_value;
   private DataType m_dataType;
}
