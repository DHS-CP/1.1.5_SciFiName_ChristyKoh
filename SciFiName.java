
/**
 * SciFiName gathers input from a user to generate a custom name that
 * sounds like it could be used in a science fiction book or movie.
 * 
 * @author ckinnard
 * @version 3/4/16
 */

public class SciFiName   
{
    private static String SciFirstName = new String();
    private static String SciLastName = new String();
    private static String SciOrigin = new String();
    /*
     * All input that you privide should be at least three letters long
     * or the program may crash (but feel free to test this!)
     * 
     * For best results, user lowercase letters and do not use spaces in your input
     */
    public static void main()
    {
        System.out.println("If you provide me some information I will provide a Science Fiction name for you.");
        System.out.println("Please have all responses  be at least three characters long.");
        System.out.println("For best results, user lowercase letters with no spaces.\n");

        // notice this methd (print) does not print a newline
        System.out.print("Enter your first name: ");
        String firstName = UserInput.getString().toLowerCase();
        System.out.print("Enter your last name: ");
        String lastName = UserInput.getString().toLowerCase();
        System.out.print("Enter the city where you or one of your parents were born: ");
        String city = UserInput.getString().toLowerCase();
        System.out.print("Enter the name of your grammar school: ");
        String school = UserInput.getString().toLowerCase();
        System.out.print("Enter the first name of a sibling or other relative: ");
        String relativeName = UserInput.getString().toLowerCase();
        System.out.print("Enter the last name of your Language Arts teacher: ");
        String teacherName = UserInput.getString().toLowerCase();

        // generate a sciFi name
        SciLastName = firstName.replace("o","ai"); 
        SciLastName = SciLastName.replace("r","s"); 
        SciLastName = SciLastName.replace("h","l") + firstName.substring(0,3); 
        int h = (int)(Math.random()*(city.length()-1)) + 1;
        SciFirstName = city.substring(0,h);
        int s = school.indexOf("o");
        if (s != -1) SciLastName = SciLastName + school.substring(s);
        
        
        //generate a sciFi origin
        int i = (int)(Math.random()*(teacherName.length()-1)) + 1;
        int j = (int)(Math.random()*(relativeName.length()-1)) + 1;
        if (j<i) SciOrigin = relativeName.substring(i) + teacherName.substring(j,i);
        else if (j>i) SciOrigin = relativeName.substring(i,j) + teacherName.substring(i);
        else SciOrigin = relativeName.substring(j) + teacherName.substring(i);
        
        //capitalize first letters
        SciFirstName = SciFirstName.substring(0,1).toUpperCase() + SciFirstName.substring(1);
        SciLastName = SciLastName.substring(0,1).toUpperCase() + SciLastName.substring(1);
        SciOrigin = SciOrigin.substring(0,1).toUpperCase() + SciOrigin.substring(1);
     
        
        System.out.print("Salutations, " + SciFirstName + " " + SciLastName +" of " + SciOrigin + ".");
    }
}
