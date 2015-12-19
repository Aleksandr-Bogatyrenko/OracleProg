package lectionString;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * Created by Александр on 05.11.2015.
 */
    public class Main {

        public static void main(String[] args) {





            String str = "This string need to split, \n by spaces and commas";

            StringTokenizer st = new StringTokenizer(str);

// по умолчанию происходит разделение по \t\n\r\f

            System.out.println("---- Split by space ------");

            while (st.hasMoreElements()) {

                System.out.println(st.nextElement());

            }

            System.out.println("---- Split by comma ',' ------");

            StringTokenizer st2 = new StringTokenizer(str, ",");

            while (st2.hasMoreElements()) {

                System.out.println(st2.nextElement());

            }

            Calendar calendar = new GregorianCalendar();

            ImmutableClass immutableClass =

                    new ImmutableClass(100, "hello", calendar.getTime());



            System.out.println("before change " + immutableClass);

            Date mutableField = immutableClass.getMutableField();

            mutableField.setTime(10000000l);

            System.out.println("change " + mutableField);

            System.out.println("after change " + immutableClass);

        }

    }

    final class ImmutableClass {

        private final Integer immutableField1; // immutable по умолчанию

        private final String immutableField2; // immutable по умолчанию

        private final Date mutableField; // // mutable

        public ImmutableClass(Integer fld1, String fld2, Date date) {

            this.immutableField1 = fld1;

            this.immutableField2 = fld2;

            this.mutableField = new Date(date.getTime());

        }

        public static ImmutableClass createNewInstance(Integer fld1, String fld2,

                                                       Date date) // можно так же создавать инстансы через фабричный метод

        {

            return new ImmutableClass(fld1, fld2, date);

        }



 /*не нужно предоставлять setter методы*/


        public Integer getImmutableField1() {

            return immutableField1;

        }

        public String getImmutableField2() {

            return immutableField2;

        }

        public Date getMutableField() {

            return new Date(mutableField.getTime());

            // нужно вернуть ссылку на новый обьект но с теми же характеристиками

        }

        @Override

        public String toString() {

            return immutableField1 + " - " + immutableField2 + " - " + mutableField;

        }

    }

