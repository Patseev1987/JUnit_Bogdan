package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    void checkHotelPositive() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(2)).thenReturn(true);
        boolean check = bookingService.bookRoom(2);

        verify(hotelService, times(1)).isRoomAvailable(2);
        assertThat(check).isTrue();
    }
    @Test
    void checkHotelNegative() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(1)).thenReturn(false);
        boolean check = bookingService.bookRoom(1);

        verify(hotelService, times(1)).isRoomAvailable(1);
        assertThat(check).isFalse();
    }
}