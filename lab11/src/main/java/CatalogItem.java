public class CatalogItem<S extends Media> implements Comparable<CatalogItem<S>> {

    private S media;

    public CatalogItem(S media){
        this.media = media;
    }

    public int compareTo(CatalogItem<S> obj){
        return obj.media.getId().compareTo(this.media.getId());
    }

    public String toString(){
        StringBuffer str = new StringBuffer();

        str.append(media.getId());
        str.append(" : ");
        str.append(media.getCreator());
        str.append(" : ");
        str.append(media.getTitle());
        str.append(" : ");
        str.append(media.getYear());
        str.append("\n");

        return str.toString();
    }
}
