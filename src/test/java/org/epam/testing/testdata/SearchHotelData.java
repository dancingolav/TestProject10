package org.epam.testing.testdata;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;

/**
 * Created by AlexSh on 17.10.2016.
 */



public class SearchHotelData {
      @DataProvider(name="dataforsearch")
       public static Object [][] createDataForSearch() {
           return new Object[][] {
                   { true, "Мальта", "Валетта"},
                   { true, "Мальта", "Гзира"},
                   { true, "Мальта", "Слима"},
                   { true, "Мальта", "Сент-Джулианс" },
                   { true, "Мальта","kjhkhkhkjhkjhkjhk"},
                   { true, "Мальта", "" },
                   { true, "", "Валетта"},
                   { true, "", "Гзира"},
                   { true, "", "Слима"},
                   { true, "", "Сент-Джулианс"},
                   { false, "", ""},
                   { false, "dgdsgdgdfgsgdfsgdsgdsfg", ""},
                   { true, "gjhgjjhgjhgjhgjh", "Валетта"}


           };


       }
}
