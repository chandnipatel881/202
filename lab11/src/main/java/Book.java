public class Book implements Media {

    private String Id;
    private String author;
    private String title;
    private int yearPublished;

    public Book(String id, String artist, String title, int yearPublished){
        this.Id = id;
        this.author = artist;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public <T> Comparable<T> getId(){
        return (Comparable<T>) this.Id;
    }

    public String getCreator(){
        return this.author;
    };
    public String getTitle(){
        return this.title;
    };
    public int getYear(){
        return this.yearPublished;
    };
}
