import java.util.Date;

public class Document  {

    private static int count = 10000;
    private int documentID;
    private String author;
    private Date dateTime;
    private boolean active; //True if the document is active, false means the document is archived
    private String textBody;

    /**
     * Constructor of Document class
     * Sets the document Id starting from 10000 incrementing 1 every time
     * @param author
     */
    public Document(String author, String textBody){
        this.count++;
        this.author = author;
        dateTime = new Date();
        this.active = true;
        this.documentID = count;
        this.textBody = textBody;
    }

    public boolean contains(String str){
        if(this.textBody.contains(str)){
            return true;
        }
        return false;
    }

    /**
     * Returns the document ID of the document
     * @return
     */
    public int getDocumentID(){
        return this.documentID;
    }

    /**
     * Returns true if the document is active, false otherwise
     * @return
     */
    public boolean isActive(){
        return this.active;
    }

    /**
     * Sets the document active or archive depending on the input variable
     * @param active
     */
    public void setActive(boolean active){
        this.active = active;
    }

    public String getTextBody(){
        return this.textBody;
    }
    /**
     * String representation of DSS class
     * @return
     */
    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("\nDocument ID : ");
        str.append(this.documentID);
        str.append("\nDate : ");
        str.append(dateTime.toString());
        str.append("\nAuthor : ");
        str.append(this.author);


        return str.toString();
    }

}
