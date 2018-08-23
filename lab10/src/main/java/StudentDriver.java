import java.util.Scanner;
import java.io.*;

public class StudentDriver {

    /**
     * @param args
     */

    public static void main(String[] args)
    {
        Scanner fileScanner = null;
        Student students[];
        int numStudents = 0;
        FileInputStream file;

        //Step a: Perform number of arguments check
        if (args.length == 0) {
            throw new RuntimeException("Command Line Argument is missing");
        }

        try
        {
            file = new FileInputStream("src/main/java/students.txt");
            /*Step b: Assign the file's input stream to the
            Scanner object.
            */
            fileScanner = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found "
                    + e.getMessage());
            System.exit(-1);
        }

        /*Step c: Read the number of students from the file
         and store in numStudents
        */
        numStudents = fileScanner.nextInt();

        System.out.println("The number of students is: " + numStudents);

        /*Step d: Allocate memory for students array based on
        numStudents
        */
        students = new Student[numStudents];

        int i = 0;
        while (fileScanner.hasNextLine())
        {
            /*Step e: Read from the file line by line using the
            Scanner object and store the values read in the
            students array.
            */
            students[i] = new Student(fileScanner.next(), fileScanner.nextInt());
            i++;

        }

        /* Step f: close the file reader as you are done
        reading the file
        */


        /*Step g: Print out the information read from the
        file which is stored in students array in the form
        Student name = [name] and id = [id]
        */
        for(Student s : students){
            System.out.printf("Student Name : %s ", s.getName());
            System.out.printf("ID : %s \n", s.getId());
        }

    }
}
