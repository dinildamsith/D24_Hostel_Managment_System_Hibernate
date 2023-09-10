package lk.ijse.d24_hostel_managment_system.utill;

import java.util.regex.Pattern;

public class Regex {

        private static final Pattern namePattern = Pattern.compile("^[a-zA-Z '.-]{4,}$");
         private static final Pattern addressPattern = Pattern.compile("^[a-zA-Z '.-]{4,}$");
        private static final Pattern emailPattern = Pattern.compile("(^[a-zA-Z0-9_.-]+)@([a-zA-Z]+)([\\.])(com)$");
        private static final Pattern doublePattern = Pattern.compile("^[0-9]+\\.?[0-9]*$");
        private static final Pattern intPattern = Pattern.compile("^[1-9]\\d*$");
        private static final Pattern contactPattern = Pattern.compile("^([0-9]{10,10})?$");
        private static final Pattern roomIdPattern = Pattern.compile("^RM-\\d{4}");

        public static Pattern getRoomIdPattern(){
            return roomIdPattern;
        }

        public static Pattern getNamePattern() {
            return namePattern;
        }

        public static Pattern getDoublePattern() {
            return doublePattern;
        }

        public static Pattern getEmailPattern() {
            return emailPattern;
        }

        public static Pattern getIntPattern() {
            return intPattern;
        }

        public static Pattern getContactPattern() {
            return contactPattern;
        }

        public  static  Pattern getAddressPattern(){
            return addressPattern;
        }

    }

