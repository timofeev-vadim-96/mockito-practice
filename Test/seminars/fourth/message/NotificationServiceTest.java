package seminars.fourth.message;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {
    private static MessageService messageService;
    private static NotificationService notificationService;

    @BeforeAll
    public static void init(){
        messageService = mock(MessageService.class);
        notificationService = new NotificationService(messageService);
    }

    @Test
    public void sendNotificationTest(){
        notificationService.sendNotification("some message", "some recipient");
        verify(messageService, atLeastOnce()).sendMessage("some message", "some recipient");
    }
}