package seminars.fourth.book;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
            void checkBookServiceFindBookById() {
        BookRepository inMemoryBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(inMemoryBookRepository);
        when(inMemoryBookRepository.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));
        Book book1 = bookService.findBookById("1");
        String author = book1.getAuthor();
        String title = book1.getTitle();
        String id = book1.getId();
        verify(inMemoryBookRepository,times(1)).findById("1");
        assertThat(author).isNotNull().isEqualTo("Author1");
        assertThat(title).isNotNull().isEqualTo("Book1");
        assertThat(id).isEqualTo("1");
    }
}