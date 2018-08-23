public class Memo extends Document {

    private String subject;
    private String recipientName;
    private String recipientList;

    /**
     * Constructor of Memo class
     * @param author
     * @param recipientName
     * @param recipientList
     * @param textBody
     */
    public Memo(String author, String subject,String recipientName, String recipientList, String textBody) {
        super(author, textBody);
        this.subject = subject;
        this.recipientName = recipientName;
        this.recipientList = recipientList;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append(super.toString());
        str.append("\nEmail Subject : ");
        str.append(this.subject);
        str.append("\nRecipient Name : ");
        str.append(this.recipientName);
        str.append("\nRecipient List: ");
        str.append(this.recipientList);
        str.append("\nText Body : ");
        str.append(this.getTextBody());

        return str.toString();
    }



}
