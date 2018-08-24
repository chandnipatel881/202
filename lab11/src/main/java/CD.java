public class CD implements Media {

    private Integer Id;
    private String artist;
    private String title;
    private int year;

    public CD(Integer id, String artist, String title, int year){
        this.Id = id;
        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    public <T> Comparable<T> getId(){
        return (Comparable<T>) this.Id;
    }

    public String getCreator(){
        return this.artist;
    };
    public String getTitle(){
        return this.title;
    };
    public int getYear(){
        return this.year;
    };
}

