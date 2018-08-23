public class Name implements Comparable<Name>{

    private String first;
    private String last;

    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append(this.first + " " + this.last);

        return str.toString();
    }

    public int compareTo(Name o) {
        if(this.last != o.last){
            return this.last.compareTo(o.last);
        }
        return this.first.compareTo(o.first);
    }
}
