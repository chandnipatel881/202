import java.util.HashMap;
import java.util.ArrayList;

public class DSS {

    private HashMap<Integer,Document> map;

    /**
     * DSS class constructor
     */
    public DSS(){
        map = new HashMap<Integer, Document>();
    }

    public void add(Integer docId, Document document){
        map.put(docId,document);
    }

    /**
     * Display a document
     * @param documentID - to display
     * @return
     */
    public Document displayDoc(Integer documentID){
        return map.get(documentID);
    }

    /**
     * List all active or archived documents depending on the boolean input forActive
     * @param forActive - if true, then the caller will get list of active documents
     *                  - if false, then the caller will get list of archived documents
     * @return
     */
    public ArrayList<Document> listAllActiveOrArchiveDocuments(boolean forActive){
        ArrayList<Document> activeDocs = new ArrayList<Document>();
        ArrayList<Document> archivedDocs = new ArrayList<Document>();
        for(int i = 10001; i < 10001 +map.size(); i++) {
            if (map.get(i) != null) {
                if (map.get(i).isActive()) {
                    activeDocs.add(map.get(i));
                } else {
                    archivedDocs.add(map.get(i));
                }
            }
        }
        if(forActive) {
            return activeDocs;
        }
        else{
            return archivedDocs;
        }
    }

    public ArrayList<Integer> searchDoc(String str){
        ArrayList<Integer> docIdList = new ArrayList<Integer>();
        for(int i = 10001; i < 10001 +map.size(); i++) {
            if(map.get(i).contains(str)){
                docIdList.add(i);
            }
        }
        return docIdList;
    }

    /**
     * Archives a document
     * @param docID - document ID to archive
     * @return
     */
    public boolean archiveDocument(Integer docID){
        if(map.get(docID) != null && map.get(docID).isActive() ) {
            map.get(docID).setActive(false);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a document from archived documents
     * @param docID
     * @return
     */
    public boolean retrieveDocument(Integer docID){
        if(map.get(docID) != null && !map.get(docID).isActive()) {
            map.get(docID).setActive(true);
            return true;
        }
        return false;
    }

    /**
     * Clears the archive
     */
    public void clearArchive(){
        for(int i = 10001; i < 10001 + map.size(); i++) {
            if (!map.get(i).isActive() && map.get(i)!=null) {
                map.remove(i);
            }
        }
    }


}
