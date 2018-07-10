import java.util.ArrayList;

public class ResidenceDriver
{
    public static void main(String[] args)
    {
        //make a House object
        //use toString to print the values related to this house
        House house = new House();

        //make a new Apartment object on the 2nd floor that has a washer
        //use toString to print the values related to this apartment
        Apartment apt = new Apartment(2,true);

        //make a new Tent object
        //use toString to print the values related to this tent
        Tent tent = new Tent();

        ArrayList<Residence> residences = new ArrayList<Residence>();
        residences.add(house);
        residences.add(apt);
        residences.add(tent);

        for(Residence r : residences) {
            System.out.println(r);
        }

        Object obj = new Object();
    }

}