package seminars.fourth.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    private static BookService bookService;
    private static BookRepository bookRepository;

    @BeforeAll
    public static void init(){
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    public void findBookByIdTest(String id) {
        when(bookRepository.findById(id)).thenReturn(new Book(id));

        assertEquals(id, bookService.findBookById(id).getId());
    }

    @Test
    public void findAllBooksTest() {
        List<Book> testBookList = new ArrayList<>();
        testBookList.add(new Book("1"));
        testBookList.add(new Book("2"));

        when(bookRepository.findAll()).thenReturn(testBookList);

        assertEquals(testBookList, bookService.findAllBooks());
    }
}