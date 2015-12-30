package eu.sajato.logw;

class MessageFormatter {

    public static String format(String messagePattern, Object[] arguments) {
        return org.slf4j.helpers.MessageFormatter.arrayFormat(messagePattern, arguments).getMessage();
    }

}
