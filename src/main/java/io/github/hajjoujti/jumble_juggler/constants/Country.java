/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.hajjoujti.jumble_juggler.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code Country} enum represents different countries along with their relevant information,
 * such as name, alpha3 code, currency code, flag unicode, capital city, continent, and whether this
 * country has a GoogleLibNumber. Each country is represented as a constant in the enum, providing a
 * convenient way to access country-specific details.
 */
public enum Country {
  AD("Andorra", "ATG", "🇦🇩", "EUR", "Andorra la Vella", "EU", true),
  AE("United Arab Emirates", "ARE", "🇦🇪", "AED", "Abu Dhabi", "AS", true),
  AF("Afghanistan", "AFG", "🇦🇫", "AFN", "Kabul", "AS", true),
  AG("Antigua and Barbuda", "ATG", "🇦🇬", "XCD", "St. John's", "NA", true),
  AI("Anguilla", "AIA", "🇦🇮", "XCD", "The Valley", "NA", true),
  AL("Albania", "ALB", "🇦🇱", "ALL", "Tirana", "EU", true),
  AM("Armenia", "ARM", "🇦🇲", "AMD", "Yerevan", "AS", true),
  AO("Angola", "AGO", "🇦🇴", "AOA", "Luanda", "AF", true),
  AQ("Antarctica", "ATA", "🇦🇶", "", "", "AN", false),
  AR("Argentina", "ARG", "🇦🇷", "ARS", "Buenos Aires", "SA", true),
  AS("American Samoa", "ASM", "🇦🇸", "USD", "Pago Pago", "OC", true),
  AT("Austria", "AUT", "🇦🇹", "EUR", "Vienna", "EU", true),
  AU("Australia", "AUS", "🇦🇺", "AUD", "Canberra", "OC", true),
  AW("Aruba", "ABW", "🇦🇼", "AWG", "Oranjestad", "NA", true),
  AX("Aland Islands", "ALA", "🇦🇽", "EUR", "Mariehamn", "EU", true),
  AZ("Azerbaijan", "AZE", "🇦🇿", "AZN", "Baku", "AS", true),
  BA("Bosnia and Herzegovina", "BIH", "🇧🇦", "BAM", "Sarajevo", "EU", true),
  BB("Barbados", "BRB", "🇧🇧", "BBD", "Bridgetown", "NA", true),
  BD("Bangladesh", "BGD", "🇧🇩", "BDT", "Dhaka", "AS", true),
  BE("Belgium", "BEL", "🇧🇪", "EUR", "Brussels", "EU", true),
  BF("Burkina Faso", "BFA", "🇧🇫", "XOF", "Ouagadougou", "AF", true),
  BG("Bulgaria", "BGR", "🇧🇬", "BGN", "Sofia", "EU", true),
  BH("Bahrain", "BHR", "🇧🇭", "BHD", "Manama", "AS", true),
  BI("Burundi", "BDI", "🇧🇮", "BIF", "Bujumbura", "AF", true),
  BJ("Benin", "BEN", "🇧🇯", "XOF", "Porto-Novo", "AF", true),
  BL("Saint Barthelemy", "BLM", "🇧🇱", "EUR", "Gustavia", "NA", true),
  BM("Bermuda", "BMU", "🇧🇲", "BMD", "Hamilton", "NA", true),
  BN("Brunei", "BRN", "🇧🇳", "BND", "Bandar Seri Begawan", "AS", true),
  BO("Bolivia", "BOL", "🇧🇴", "BOB", "Sucre", "SA", true),
  BQ("Bonaire, Saint Eustatius and Saba", "BES", "🇧🇶", "USD", "", "NA", true),
  BR("Brazil", "BRA", "🇧🇷", "BRL", "Brasilia", "SA", true),
  BS("Bahamas", "BHS", "🇧🇸", "BSD", "Nassau", "NA", true),
  BT("Bhutan", "BTN", "🇧🇹", "BTN", "Thimphu", "AS", true),
  BW("Botswana", "BWA", "🇧🇼", "BWP", "Gaborone", "AF", true),
  BY("Belarus", "BLR", "🇧🇾", "BYR", "Minsk", "EU", true),
  BZ("Belize", "BLZ", "🇧🇿", "BZD", "Belmopan", "NA", true),
  CA("Canada", "CAN", "🇨🇦", "CAD", "Ottawa", "NA", true),
  CC("Cocos Islands", "CCK", "🇨🇨", "AUD", "West Island", "AS", true),
  CD("Democratic Republic of the Congo", "COD", "🇨🇩", "CDF", "Kinshasa", "AF", true),
  CF("Central African Republic", "CAF", "🇨🇫", "XAF", "Bangui", "AF", true),
  CG("Republic of the Congo", "COG", "🇨🇬", "XAF", "Brazzaville", "AF", true),
  CH("Switzerland", "CHE", "🇨🇭", "CHF", "Bern", "EU", true),
  CI("Ivory Coast", "CIV", "🇨🇮", "XOF", "Yamoussoukro", "AF", true),
  CK("Cook Islands", "COK", "🇨🇰", "NZD", "Avarua", "OC", true),
  CL("Chile", "CHL", "🇨🇱", "CLP", "Santiago", "SA", true),
  CM("Cameroon", "CMR", "🇨🇲", "XAF", "Yaounde", "AF", true),
  CN("China", "CHN", "🇨🇳", "CNY", "Beijing", "AS", true),
  CO("Colombia", "COL", "🇨🇴", "COP", "Bogota", "SA", true),
  CR("Costa Rica", "CRI", "🇨🇷", "CRC", "San Jose", "NA", true),
  CU("Cuba", "CUB", "🇨🇺", "CUP", "Havana", "NA", true),
  CV("Cape Verde", "CPV", "🇨🇻", "CVE", "Praia", "AF", true),
  CW("Curacao", "CUW", "🇨🇼", "ANG", "Willemstad", "NA", true),
  CX("Christmas Island", "CXR", "🇨🇽", "AUD", "Flying Fish Cove", "AS", true),
  CY("Cyprus", "CYP", "🇨🇾", "EUR", "Nicosia", "AS", true),
  CZ("Czech Republic", "CZE", "🇨🇿", "CZK", "Prague", "EU", true),
  DE("Germany", "DEU", "🇩🇪", "EUR", "Berlin", "EU", true),
  DJ("Djibouti", "DJI", "🇩🇯", "DJF", "Djibouti", "AF", true),
  DK("Denmark", "DNK", "🇩🇰", "DKK", "Copenhagen", "EU", true),
  DM("Dominica", "DMA", "🇩🇲", "XCD", "Roseau", "NA", true),
  DO("Dominican Republic", "DOM", "🇩🇴", "DOP", "Santo Domingo", "NA", true),
  DZ("Algeria", "DZA", "🇩🇿", "DZD", "Algiers", "AF", true),
  EC("Ecuador", "ECU", "🇪🇨", "USD", "Quito", "SA", true),
  EE("Estonia", "EST", "🇪🇪", "EUR", "Tallinn", "EU", true),
  EG("Egypt", "EGY", "🇪🇬", "EGP", "Cairo", "AF", true),
  EH("Western Sahara", "ESH", "🇪🇭", "MAD", "El-Aaiun", "AF", true),
  ER("Eritrea", "ERI", "🇪🇷", "ERN", "Asmara", "AF", true),
  ES("Spain", "ESP", "🇪🇸", "EUR", "Madrid", "EU", true),
  ET("Ethiopia", "ETH", "🇪🇹", "ETB", "Addis Ababa", "AF", true),
  FI("Finland", "FIN", "🇫🇮", "EUR", "Helsinki", "EU", true),
  FJ("Fiji", "FJI", "🇫🇯", "FJD", "Suva", "OC", true),
  FK("Falkland Islands", "FLK", "🇫🇰", "FKP", "Stanley", "SA", true),
  FM("Micronesia", "FSM", "🇫🇲", "USD", "Palikir", "OC", true),
  FO("Faroe Islands", "FRO", "🇫🇴", "DKK", "Torshavn", "EU", true),
  FR("France", "FRA", "🇫🇷", "EUR", "Paris", "EU", true),
  GA("Gabon", "GAB", "🇬🇦", "XAF", "Libreville", "AF", true),
  GB("United Kingdom", "GBR", "🇬🇧", "GBP", "London", "EU", true),
  GD("Grenada", "GRD", "🇬🇩", "XCD", "St. George's", "NA", true),
  GE("Georgia", "GEO", "🇬🇪", "GEL", "Tbilisi", "AS", true),
  GF("French Guiana", "GUF", "🇬🇫", "EUR", "Cayenne", "SA", true),
  GG("Guernsey", "GGY", "🇬🇬", "GBP", "St Peter Port", "EU", true),
  GH("Ghana", "GHA", "🇬🇭", "GHS", "Accra", "AF", true),
  GI("Gibraltar", "GIB", "🇬🇮", "GIP", "Gibraltar", "EU", true),
  GL("Greenland", "GRL", "🇬🇱", "DKK", "Nuuk", "NA", true),
  GM("Gambia", "GMB", "🇬🇲", "GMD", "Banjul", "AF", true),
  GN("Guinea", "GIN", "🇬🇳", "GNF", "Conakry", "AF", true),
  GP("Guadeloupe", "GLP", "🇬🇵", "EUR", "Basse-Terre", "NA", true),
  GQ("Equatorial Guinea", "GNQ", "🇬🇶", "XAF", "Malabo", "AF", true),
  GR("Greece", "GRC", "🇬🇷", "EUR", "Athens", "EU", true),
  GS(
      "South Georgia and the South Sandwich Islands",
      "SGS",
      "🇬🇸",
      "GBP",
      "Grytviken",
      "AN",
      false),
  GT("Guatemala", "GTM", "🇬🇹", "GTQ", "Guatemala City", "NA", true),
  GU("Guam", "GUM", "🇬🇺", "USD", "Hagatna", "OC", true),
  GW("Guinea-Bissau", "GNB", "🇬🇼", "XOF", "Bissau", "AF", true),
  GY("Guyana", "GUY", "🇬🇾", "GYD", "Georgetown", "SA", true),
  HK("Hong Kong", "HKG", "🇭🇰", "HKD", "Hong Kong", "AS", true),
  HM("Heard Island and McDonald Islands", "HMD", "🇭🇲", "AUD", "", "AN", false),
  HN("Honduras", "HND", "🇭🇳", "HNL", "Tegucigalpa", "NA", true),
  HR("Croatia", "HRV", "🇭🇷", "HRK", "Zagreb", "EU", true),
  HT("Haiti", "HTI", "🇭🇹", "HTG", "Port-au-Prince", "NA", true),
  HU("Hungary", "HUN", "🇭🇺", "HUF", "Budapest", "EU", true),
  ID("Indonesia", "IDN", "🇮🇩", "IDR", "Jakarta", "AS", true),
  IE("Ireland", "IRL", "🇮🇪", "EUR", "Dublin", "EU", true),
  IL("Israel", "ISR", "🇮🇱", "ILS", "Jerusalem", "AS", true),
  IM("Isle of Man", "IMN", "🇮🇲", "GBP", "Douglas, Isle of Man", "EU", true),
  IN("India", "IND", "🇮🇳", "INR", "New Delhi", "AS", true),
  IO("British Indian Ocean Territory", "IOT", "🇮🇴", "USD", "Diego Garcia", "AS", true),
  IQ("Iraq", "IRQ", "🇮🇶", "IQD", "Baghdad", "AS", true),
  IR("Iran", "IRN", "🇮🇷", "IRR", "Tehran", "AS", true),
  IS("Iceland", "ISL", "🇮🇸", "ISK", "Reykjavik", "EU", true),
  IT("Italy", "ITA", "🇮🇹", "EUR", "Rome", "EU", true),
  JE("Jersey", "JEY", "🇯🇪", "GBP", "Saint Helier", "EU", true),
  JM("Jamaica", "JAM", "🇯🇲", "JMD", "Kingston", "NA", true),
  JO("Jordan", "JOR", "🇯🇴", "JOD", "Amman", "AS", true),
  JP("Japan", "JPN", "🇯🇵", "JPY", "Tokyo", "AS", true),
  KE("Kenya", "KEN", "🇰🇪", "KES", "Nairobi", "AF", true),
  KG("Kyrgyzstan", "KGZ", "🇰🇬", "KGS", "Bishkek", "AS", true),
  KH("Cambodia", "KHM", "🇰🇭", "KHR", "Phnom Penh", "AS", true),
  KI("Kiribati", "KIR", "🇰🇮", "AUD", "Tarawa", "OC", true),
  KM("Comoros", "COM", "🇰🇲", "KMF", "Moroni", "AF", true),
  KN("Saint Kitts and Nevis", "KNA", "🇰🇳", "XCD", "Basseterre", "NA", true),
  KP("North Korea", "PRK", "🇰🇵", "KPW", "Pyongyang", "AS", true),
  KR("South Korea", "KOR", "🇰🇷", "KRW", "Seoul", "AS", true),
  KW("Kuwait", "KWT", "🇰🇼", "KWD", "Kuwait City", "AS", true),
  KY("Cayman Islands", "CYM", "🇰🇾", "KYD", "George Town", "NA", true),
  KZ("Kazakhstan", "KAZ", "🇰🇿", "KZT", "Nur-Sultan", "AS", true),
  LA("Laos", "LAO", "🇱🇦", "LAK", "Vientiane", "AS", true),
  LB("Lebanon", "LBN", "🇱🇧", "LBP", "Beirut", "AS", true),
  LC("Saint Lucia", "LCA", "🇱🇨", "XCD", "Castries", "NA", true),
  LI("Liechtenstein", "LIE", "🇱🇮", "CHF", "Vaduz", "EU", true),
  LK("Sri Lanka", "LKA", "🇱🇰", "LKR", "Colombo", "AS", true),
  LR("Liberia", "LBR", "🇱🇷", "LRD", "Monrovia", "AF", true),
  LS("Lesotho", "LSO", "🇱🇸", "LSL", "Maseru", "AF", true),
  LT("Lithuania", "LTU", "🇱🇹", "LTL", "Vilnius", "EU", true),
  LU("Luxembourg", "LUX", "🇱🇺", "EUR", "Luxembourg", "EU", true),
  LV("Latvia", "LVA", "🇱🇻", "EUR", "Riga", "EU", true),
  LY("Libya", "LBY", "🇱🇾", "LYD", "Tripolis", "AF", true),
  MA("Morocco", "MAR", "🇲🇦", "MAD", "Rabat", "AF", true),
  MC("Monaco", "MCO", "🇲🇨", "EUR", "Monaco", "EU", true),
  MD("Moldova", "MDA", "🇲🇩", "MDL", "Chisinau", "EU", true),
  ME("Montenegro", "MNE", "🇲🇪", "EUR", "Podgorica", "EU", true),
  MF("Saint Martin", "MAF", "🇲🇫", "EUR", "Marigot", "NA", true),
  MG("Madagascar", "MDG", "🇲🇬", "MGA", "Antananarivo", "AF", true),
  MH("Marshall Islands", "MHL", "🇲🇭", "USD", "Majuro", "OC", true),
  MK("Macedonia", "MKD", "🇲🇰", "MKD", "Skopje", "EU", true),
  ML("Mali", "MLI", "🇲🇱", "XOF", "Bamako", "AF", true),
  MM("Myanmar", "MMR", "🇲🇲", "MMK", "Nay Pyi Taw", "AS", true),
  MN("Mongolia", "MNG", "🇲🇳", "MNT", "Ulan Bator", "AS", true),
  MO("Macao", "MAC", "🇲🇴", "MOP", "Macao", "AS", true),
  MP("Northern Mariana Islands", "MNP", "🇲🇵", "USD", "Saipan", "OC", true),
  MQ("Martinique", "MTQ", "🇲🇶", "EUR", "Fort-de-France", "NA", true),
  MR("Mauritania", "MRT", "🇲🇷", "MRO", "Nouakchott", "AF", true),
  MS("Montserrat", "MSR", "🇲🇸", "XCD", "Plymouth", "NA", true),
  MT("Malta", "MLT", "🇲🇹", "EUR", "Valletta", "EU", true),
  MU("Mauritius", "MUS", "🇲🇺", "MUR", "Port Louis", "AF", true),
  MV("Maldives", "MDV", "🇲🇻", "MVR", "Male", "AS", true),
  MW("Malawi", "MWI", "🇲🇼", "MWK", "Lilongwe", "AF", true),
  MX("Mexico", "MEX", "🇲🇽", "MXN", "Mexico City", "NA", true),
  MY("Malaysia", "MYS", "🇲🇾", "MYR", "Kuala Lumpur", "AS", true),
  MZ("Mozambique", "MOZ", "🇲🇿", "MZN", "Maputo", "AF", true),
  NA("Namibia", "NAM", "🇳🇦", "NAD", "Windhoek", "AF", true),
  NC("New Caledonia", "NCL", "🇳🇨", "XPF", "Noumea", "OC", true),
  NE("Niger", "NER", "🇳🇪", "XOF", "Niamey", "AF", true),
  NF("Norfolk Island", "NFK", "🇳🇫", "AUD", "Kingston", "OC", true),
  NG("Nigeria", "NGA", "🇳🇬", "NGN", "Abuja", "AF", true),
  NI("Nicaragua", "NIC", "🇳🇮", "NIO", "Managua", "NA", true),
  NL("Netherlands", "NLD", "🇳🇱", "EUR", "Amsterdam", "EU", true),
  NO("Norway", "NOR", "🇳🇴", "NOK", "Oslo", "EU", true),
  NP("Nepal", "NPL", "🇳🇵", "NPR", "Kathmandu", "AS", true),
  NR("Nauru", "NRU", "🇳🇷", "AUD", "Yaren", "OC", true),
  NU("Niue", "NIU", "🇳🇺", "NZD", "Alofi", "OC", true),
  NZ("New Zealand", "NZL", "🇳🇿", "NZD", "Wellington", "OC", true),
  OM("Oman", "OMN", "🇴🇲", "OMR", "Muscat", "AS", true),
  PA("Panama", "PAN", "🇵🇦", "PAB", "Panama City", "NA", true),
  PE("Peru", "PER", "🇵🇪", "PEN", "Lima", "SA", true),
  PF("French Polynesia", "PYF", "🇵🇫", "XPF", "Papeete", "OC", true),
  PG("Papua New Guinea", "PNG", "🇵🇬", "PGK", "Port Moresby", "OC", true),
  PH("Philippines", "PHL", "🇵🇭", "PHP", "Manila", "AS", true),
  PK("Pakistan", "PAK", "🇵🇰", "PKR", "Islamabad", "AS", true),
  PL("Poland", "POL", "🇵🇱", "PLN", "Warsaw", "EU", true),
  PM("Saint Pierre and Miquelon", "SPM", "🇵🇲", "EUR", "Saint-Pierre", "NA", true),
  PN("Pitcairn", "PCN", "🇵🇳", "NZD", "Adamstown", "OC", false),
  PR("Puerto Rico", "PRI", "🇵🇷", "USD", "San Juan", "NA", true),
  PS("Palestinian Territory", "PSE", "🇵🇸", "ILS", "East Jerusalem", "AS", true),
  PT("Portugal", "PRT", "🇵🇹", "EUR", "Lisbon", "EU", true),
  PW("Palau", "PLW", "🇵🇼", "USD", "Melekeok", "OC", true),
  PY("Paraguay", "PRY", "🇵🇾", "PYG", "Asuncion", "SA", true),
  QA("Qatar", "QAT", "🇶🇦", "QAR", "Doha", "AS", true),
  RE("Reunion", "REU", "🇷🇪", "EUR", "Saint-Denis", "AF", true),
  RO("Romania", "ROU", "🇷🇴", "RON", "Bucharest", "EU", true),
  RS("Serbia", "SRB", "🇷🇸", "RSD", "Belgrade", "EU", true),
  RU("Russia", "RUS", "🇷🇺", "RUB", "Moscow", "EU", true),
  RW("Rwanda", "RWA", "🇷🇼", "RWF", "Kigali", "AF", true),
  SA("Saudi Arabia", "SAU", "🇸🇦", "SAR", "Riyadh", "AS", true),
  SB("Solomon Islands", "SLB", "🇸🇧", "SBD", "Honiara", "OC", true),
  SC("Seychelles", "SYC", "🇸🇨", "SCR", "Victoria", "AF", true),
  SD("Sudan", "SDN", "🇸🇩", "SDG", "Khartoum", "AF", true),
  SE("Sweden", "SWE", "🇸🇪", "SEK", "Stockholm", "EU", true),
  SG("Singapore", "SGP", "🇸🇬", "SGD", "Singapore", "AS", true),
  SH("Saint Helena", "SHN", "🇸🇭", "SHP", "Jamestown", "AF", true),
  SI("Slovenia", "SVN", "🇸🇮", "EUR", "Ljubljana", "EU", true),
  SJ("Svalbard and Jan Mayen", "SJM", "🇸🇯", "NOK", "Longyearbyen", "EU", true),
  SK("Slovakia", "SVK", "🇸🇰", "EUR", "Bratislava", "EU", true),
  SL("Sierra Leone", "SLE", "🇸🇱", "SLL", "Freetown", "AF", true),
  SM("San Marino", "SMR", "🇸🇲", "EUR", "San Marino", "EU", true),
  SN("Senegal", "SEN", "🇸🇳", "XOF", "Dakar", "AF", true),
  SO("Somalia", "SOM", "🇸🇴", "SOS", "Mogadishu", "AF", true),
  SR("Suriname", "SUR", "🇸🇷", "SRD", "Paramaribo", "SA", true),
  SS("South Sudan", "SSD", "🇸🇸", "SSP", "Juba", "AF", true),
  ST("Sao Tome and Principe", "STP", "🇸🇹", "STN", "Sao Tome", "AF", true),
  SV("El Salvador", "SLV", "🇸🇻", "USD", "San Salvador", "NA", true),
  SX("Sint Maarten", "SXM", "🇸🇽", "ANG", "Philipsburg", "NA", true),
  SY("Syria", "SYR", "🇸🇾", "SYP", "Damascus", "AS", true),
  SZ("Swaziland", "SWZ", "🇸🇿", "SZL", "Mbabane", "AF", true),
  TC("Turks and Caicos Islands", "TCA", "🇹🇨", "USD", "Cockburn Town", "NA", true),
  TD("Chad", "TCD", "🇹🇩", "XAF", "N'Djamena", "AF", true),
  TF("French Southern Territories", "ATF", "🇹🇫", "EUR", "Port-aux-Francais", "AN", false),
  TG("Togo", "TGO", "🇹🇬", "XOF", "Lome", "AF", true),
  TH("Thailand", "THA", "🇹🇭", "THB", "Bangkok", "AS", true),
  TJ("Tajikistan", "TJK", "🇹🇯", "TJS", "Dushanbe", "AS", true),
  TK("Tokelau", "TKL", "🇹🇰", "NZD", "", "OC", true),
  TL("East Timor", "TLS", "🇹🇱", "USD", "Dili", "OC", true),
  TM("Turkmenistan", "TKM", "🇹🇲", "TMT", "Ashgabat", "AS", true),
  TN("Tunisia", "TUN", "🇹🇳", "TND", "Tunis", "AF", true),
  TO("Tonga", "TON", "🇹🇴", "TOP", "Nuku'alofa", "OC", true),
  TR("Turkey", "TUR", "🇹🇷", "TRY", "Ankara", "AS", true),
  TT("Trinidad and Tobago", "TTO", "🇹🇹", "TTD", "Port of Spain", "NA", true),
  TV("Tuvalu", "TUV", "🇹🇻", "AUD", "Funafuti", "OC", true),
  TW("Taiwan", "TWN", "🇹🇼", "TWD", "Taipei", "AS", true),
  TZ("Tanzania", "TZA", "🇹🇿", "TZS", "Dodoma", "AF", true),
  UA("Ukraine", "UKR", "🇺🇦", "UAH", "Kiev", "EU", true),
  UG("Uganda", "UGA", "🇺🇬", "UGX", "Kampala", "AF", true),
  UM("United States Minor Outlying Islands", "UMI", "🇺🇲", "USD", "", "OC", false),
  US("United States", "USA", "🇺🇸", "USD", "Washington", "NA", true),
  UY("Uruguay", "URY", "🇺🇾", "UYU", "Montevideo", "SA", true),
  UZ("Uzbekistan", "UZB", "🇺🇿", "UZS", "Tashkent", "AS", true),
  VA("Vatican", "VAT", "🇻🇦", "EUR", "Vatican City", "EU", true),
  VC("Saint Vincent and the Grenadines", "VCT", "🇻🇨", "XCD", "Kingstown", "NA", true),
  VE("Venezuela", "VEN", "🇻🇪", "VEF", "Caracas", "SA", true),
  VG("British Virgin Islands", "VGB", "🇻🇬", "USD", "Road Town", "NA", true),
  VI("U.S. Virgin Islands", "VIR", "🇻🇮", "USD", "Charlotte Amalie", "NA", true),
  VN("Vietnam", "VNM", "🇻🇳", "VND", "Hanoi", "AS", true),
  VU("Vanuatu", "VUT", "🇻🇺", "VUV", "Port Vila", "OC", true),
  WF("Wallis and Futuna", "WLF", "🇼🇫", "XPF", "Mata Utu", "OC", true),
  WS("Samoa", "WSM", "🇼🇸", "WST", "Apia", "OC", true),
  XK("Kosovo", "XKX", "🇽🇰", "EUR", "Pristina", "EU", true),
  YE("Yemen", "YEM", "🇾🇪", "YER", "Sanaa", "AS", true),
  YT("Mayotte", "MYT", "🇾🇹", "EUR", "Mamoudzou", "AF", true),
  ZA("South Africa", "ZAF", "🇿🇦", "ZAR", "Pretoria", "AF", true),
  ZM("Zambia", "ZMB", "🇿🇲", "ZMK", "Lusaka", "AF", true),
  ZW("Zimbabwe", "ZWE", "🇿🇼", "ZWL", "Harare", "AF", true);

  private final String countryName;
  private final String iso3;
  private final String unicode;
  private final String currency;
  private final String capital;
  private final String continent;
  private final boolean isInGoogleLibPhoneNumber; // For testing only
  private static final List<Country> COUNTRIES = new ArrayList<>();
  private static final Map<String, Country> ISO2_COUNTRY_MAP = new HashMap<>();
  private static final Map<String, Country> ISO3_COUNTRY_MAP = new HashMap<>();

  static {
    COUNTRIES.addAll(Arrays.asList(values()));
    for (Country country : values()) {
      ISO2_COUNTRY_MAP.put(country.name(), country);
      ISO3_COUNTRY_MAP.put(country.iso3, country);
    }
  }

  Country(
      String countryName,
      String iso3,
      String unicode,
      String currency,
      String capital,
      String continent,
      boolean isInGoogleLibPhoneNumber) {
    this.countryName = countryName;
    this.iso3 = iso3;
    this.unicode = unicode;
    this.currency = currency;
    this.capital = capital;
    this.continent = continent;
    this.isInGoogleLibPhoneNumber = isInGoogleLibPhoneNumber;
  }

  /**
   * Returns the official name of the country.
   *
   * @return The official name of the country.
   */
  public String getCountryName() {
    return countryName;
  }

  /**
   * Returns the three-letter country code.
   *
   * @return The three-letter country code.
   */
  public String getIso3() {
    return iso3;
  }

  /**
   * Returns the unicode representation of the country's flag.
   *
   * @return The emoji representation of the country's flag.
   */
  public String getUnicode() {
    return unicode;
  }

  /**
   * Returns the official currency code of the country.
   *
   * @return The official currency code.
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Returns the capital city of the country.
   *
   * @return The capital city of the country.
   */
  public String getCapital() {
    return capital;
  }

  /**
   * Returns the continent to which the country belongs.
   *
   * @return The region of the country.
   */
  public String getContinent() {
    return continent;
  }

  /**
   * Returns if the country has a Google lib number.
   *
   * @return {@code true} if the country has a Google lib number. {@code false} otherwise.
   * @see <a href="https://github.com/google/libphonenumber">libphonenumber</a>
   */
  public boolean isInGoogleLibPhoneNumber() {
    return isInGoogleLibPhoneNumber;
  }

  public static List<Country> getCountries() {
    return COUNTRIES;
  }

  public static Map<String, Country> getIso2CountryMap() {
    return ISO2_COUNTRY_MAP;
  }

  public static Map<String, Country> getIso3CountryMap() {
    return ISO3_COUNTRY_MAP;
  }
}
