public class Report extends Document{

    private String title;

    /**
     * Constructor of Report class
     * @param author
     * @param title
     * @param textBody
     */
    public Report(String author, String title, String textBody){
        super(author,textBody);
        this.title = title;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(super.toString());
        str.append("\nReport title : ");
        str.append(this.title);
        str.append("\nText Body : ");
        str.append(this.getTextBody());

        return str.toString();
    }
}
