public class Email extends Document {

    private String subject;
    private String recipientName;
    private String recipientEmail;

    /**
     * Constructor of Email class
     * @param author
     * @param recipientName
     * @param recipientEmail
     * @param textBody
     */
    public Email(String author, String subject,String recipientName, String recipientEmail, String textBody){
        super(author, textBody);
        this.subject = subject;
        this.recipientName = recipientName;
        this.recipientEmail = recipientEmail;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append(super.toString());
        str.append("\nEmail Subject : ");
        str.append(this.subject);
        str.append("\nRecipient Name : ");
        str.append(this.recipientName);
        str.append("\nRecipient Email : ");
        str.append(this.recipientEmail);

        return str.toString();
    }

}
