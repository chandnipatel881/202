public class Patron implements Comparable<Patron> {

    Name name;
    Integer roomNumber;

    public Patron(String first, String last, int roomNumber){
        name = new Name(first,last);
        this.roomNumber = roomNumber;
    }

    public String toString(){
        return name.toString() + " : " + this.roomNumber;
    }

    public int compareTo(Patron o){
        if(this.name != o.name){
            return this.name.compareTo(o.name);
        }
        return this.roomNumber.compareTo(o.roomNumber);
    }

}
