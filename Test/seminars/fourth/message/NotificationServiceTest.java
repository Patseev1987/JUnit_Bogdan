package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {
    @Test
    void messageTest(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);
        messageService.sendMessage("text","Bogdan");
        verify(messageService,times(1)).sendMessage("text","Bogdan");
    }

}