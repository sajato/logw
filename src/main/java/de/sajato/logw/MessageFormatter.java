package de.sajato.logw;

class MessageFormatter {

    public static String format(String messagePattern, Object[] argArray) {
        return org.slf4j.helpers.MessageFormatter.arrayFormat(messagePattern, argArray).getMessage();
    }

}
