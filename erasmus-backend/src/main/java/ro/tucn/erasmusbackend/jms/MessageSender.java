package ro.tucn.erasmusbackend.jms;

import ro.tucn.erasmusbackend.dto.mail.SendingStatus;

public interface MessageSender<Request> {

    SendingStatus sendMessage(Request request);
}
