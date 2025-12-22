import java.util.HashMap;

public class Library {
  // static attribute
  private static int nextId = 0;

  // static inner enum
  public static enum Genre {
    MATH,
    HISTORY,
    ENGLISH,
  }


  // static inner class
  public static class Book {
    private int id;
    private Genre genre;
    private String title;

    public Book(String title, Genre genre) {
      this.id = nextId++;
      this.title = title;
      this.genre = genre;
    }

    public int getId() {
      return id;
    }

    public String getTitle() {
      return title;
    }

    public Genre getGenre() {
      return genre;
    }

    @Override
    public String toString() {
      return "Book{id=" + id + ", title='" + title + "'}";
    }
  }

  private HashMap<Genre, HashMap<Integer, Book>> bookMap;

  public Library() {
    this.bookMap = new HashMap<>();
  }

  public void add(Genre genre, String title) {
    Book newBook = new Book(title, genre);
    HashMap<Integer, Book> genreMap;

    if (bookMap.containsKey(genre)) {
      genreMap = bookMap.get(genre);
    } else {
      genreMap = new HashMap<Integer, Book>();
      bookMap.put(genre, genreMap);
    }

    genreMap.put(newBook.getId(), newBook);
  }

  public Book search(int bookId) {
    for (Genre genre : bookMap.keySet()) {
      HashMap<Integer, Book> genreMap = bookMap.get(genre);
      if (genreMap.containsKey(bookId)) return genreMap.get(bookId);
    }
    return null;
  }

  public HashMap<Integer, Book> search(Genre genre) {
    return bookMap.get(genre);
  }

  public HashMap<Genre, HashMap<Integer, Book>> getBookMap() {
    return bookMap;
  }



  // main method
  public static void main(String[] args) {
    // test
    Library library = new Library();
    library.add(Genre.MATH, "math 1");
    library.add(Genre.MATH, "math 2");
    library.add(Genre.MATH, "math 3");
    library.add(Genre.MATH, "math 4");
    library.add(Genre.ENGLISH, "eng 1");
    System.out.println(library.getBookMap());

    System.out.println(library.search(0));
    System.out.println(library.search(Genre.ENGLISH));


  }
}
