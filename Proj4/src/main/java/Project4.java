import java.util.ArrayList;
import java.util.Scanner;

public class Project4 {

    public static void displayMenu(){
        System.out.println("\nDocument Storage System Menu");
        System.out.println("1 - Create and store an e-mail");
        System.out.println("2 - Create and store a memo");
        System.out.println("3 - Create and store a report");
        System.out.println("4 - Display a document");
        System.out.println("5 - List all active documents");
        System.out.println("6 - List all archived documents");
        System.out.println("7 - Locate documents containing a specific word or phrase");
        System.out.println("8 - Archive a document");
        System.out.println("9 - Retrieve a document from the archive");
        System.out.println("10 - Clear the archive");
        System.out.println("99 - Quit");
        System.out.println("Enter your choice:");
    }

    public static String getAuthor(Scanner in){
        System.out.println("Enter author: ");
        return in.nextLine();
    }

    public static String getSubjectOrTitle(Scanner in,boolean title){
        if(title){
            System.out.println("Enter title: ");
        }
        else {
            System.out.println("Enter subject: ");
        }
        return in.nextLine();
    }

    public static String getRecipientName(Scanner in){
        System.out.println("Enter recipient name: ");
        return in.nextLine();
    }

    public static String getRecipientEmail(Scanner in){
        System.out.println("Enter recipient email: ");
        return in.nextLine();
    }


    /**
     * getMultipleLines returns String with Multiple lines
     * @param in -- Scanner object
     * @param recipeintList -- if list is true, means the caller wants to use the routine for recipientList
     *                else, the caller wants to use the routine for textBody
     * @return
     */
    public static String getMutipleLines(Scanner in, boolean recipeintList){
        if (recipeintList){
            System.out.println("Enter distribution list (type END on separate line to stop):");
        }
        else {
            System.out.println("Enter text body (type END on separate line to stop): ");
        }
        String textBody = "";
        String str = "";
        while (true) {
            textBody = in.nextLine();
            if (textBody.equals("END")) {
                break;
            } else {
                str +="\n";
                str += textBody;
            }
        }
        return str;
    }

    public static void createAndSaveEmail(Scanner in, DSS dss){
        String discard = in.nextLine();

        Email email = new Email(getAuthor(in),getSubjectOrTitle(in,false),getRecipientName(in),getRecipientEmail(in),getMutipleLines(in,false));
        dss.add(email.getDocumentID(), email);
        System.out.println("Email " + email.getDocumentID() + " entered into active documents list");

    }

    public static void createAndSaveMemo(Scanner in, DSS dss){
        String discard = in.nextLine();
        Document memo = new Memo(getAuthor(in),getSubjectOrTitle(in,false),getRecipientName(in),getMutipleLines(in,true),getMutipleLines(in,false));
        dss.add(memo.getDocumentID(), memo);
        System.out.println("Memo " + memo.getDocumentID() + " entered into active documents list");
    }

    public static void createAndSaveReport(Scanner in, DSS dss){
        String discard = in.nextLine();
        Document report = new Report(getAuthor(in),getSubjectOrTitle(in,true),getMutipleLines(in,false));
        dss.add(report.getDocumentID(), report);
        System.out.println("Report " + report.getDocumentID() + " entered into active documents list");
    }

    public static void displayADocument(Scanner in, DSS dss){
        String discard = in.nextLine();
        System.out.println("Enter the document ID: ");
        System.out.println(dss.displayDoc(in.nextInt()).toString());
    }

    public static void listAllActiveDoc(Scanner in,DSS dss){
        String discard = in.nextLine();
        ArrayList<Document> activeDocs = new ArrayList<Document>();

        activeDocs = dss.listAllActiveOrArchiveDocuments(true);

        if(activeDocs.size() > 0) {
            System.out.println("Active Document List: ");
            for (int i = 0; i < activeDocs.size(); i++) {
                System.out.println(activeDocs.get(i));
            }
        }
        else{
            System.out.println("There are no active documents");
        }
    }

    public static void listAllArchivedDoc(Scanner in,DSS dss){
        String discard = in.nextLine();
        ArrayList<Document> archivedDocs = new ArrayList<Document>();

        archivedDocs = dss.listAllActiveOrArchiveDocuments(false);

        if(archivedDocs.size() > 0) {
            System.out.println("Archived Document List: ");
            for (int i = 0; i < archivedDocs.size(); i++) {
                System.out.println(archivedDocs.get(i));
            }
        }
        else{
            System.out.println("There are no archived documents");
        }
    }

    public static void archiveADoc(Scanner in,DSS dss){
        String discard = in.nextLine();
        System.out.println("Enter the document ID: ");
        Integer docID = in.nextInt();
        if(dss.archiveDocument(docID)){
            System.out.println("Document " + docID + " is now archived.");
        }
        else{
            System.out.println("The document is either already archived or it doesn't exist in the storage system");
        }
    }

    public static void searchDoc(Scanner in, DSS dss){

        String discard = in.nextLine();
        ArrayList<Integer> docIdList = new ArrayList<Integer>();

        System.out.println("Enter your search phrase : ");
        String str = in.nextLine();
        docIdList = dss.searchDoc(str);
        for(int i = 0; i < docIdList.size(); i++){
            System.out.println(docIdList.get(i));
        }
    }

    public static void retrieveADoc(Scanner in, DSS dss){
        String discard = in.nextLine();
        System.out.println("Enter the document ID: ");
        Integer docID = in.nextInt();
        if(dss.retrieveDocument(docID)){
            System.out.println("Document " + docID + " is now retrieved.");
        }
        else{
            System.out.println("The document is either already active or it doesn't exist in the storage system");
        }
    }

    public static void main(String[] args){

       Scanner in = new Scanner(System.in);
       DSS dss = new DSS();

        displayMenu();

        int input = 0;

        do{
            input = in.nextInt();

            switch(input){
                case 1 :
                    createAndSaveEmail(in,dss);
                    break;
                case 2:
                    createAndSaveMemo(in,dss);
                    break;
                case 3:
                    createAndSaveReport(in,dss);
                    break;
                case 4:
                    displayADocument(in,dss);
                    break;
                case 5:
                    listAllActiveDoc(in,dss);
                    break;
                case 6:
                    listAllArchivedDoc(in,dss);
                    break;
                case 7:
                    searchDoc(in,dss);
                    break;
                case 8:
                    archiveADoc(in,dss);
                    break;
                case 9:
                    retrieveADoc(in,dss);
                case 10:
                    in.nextLine();
                    dss.clearArchive();
                    System.out.println("Archived has been cleared out");
                    break;
                case 99:
                    System.exit(0);
            }
            displayMenu();
        }while(input!=99);
    }
}
