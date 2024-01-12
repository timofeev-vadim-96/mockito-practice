package seminars.fourth.hotel;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {
    private static BookingService bookingService;
    private static HotelService hotelService;

    @BeforeAll
    public static void init() {
        hotelService = mock(HotelService.class);
        when(hotelService.isRoomAvailable(anyInt())).thenAnswer(i -> ( Integer)i.getArgument(0) % 2 == 0);
        bookingService = new BookingService(hotelService);
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 15})
    public void bookRoomFalse(int id) {
        assertFalse(bookingService.bookRoom(id));
    }

    @ParameterizedTest
    @ValueSource(ints = {14, 16})
    public void bookRoomTrue(int id) {
        assertTrue(bookingService.bookRoom(id));
    }


}