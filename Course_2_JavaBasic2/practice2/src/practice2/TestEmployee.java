package practice2;

/**
 * Created by practice.luchian on 15-Feb-17.
 */
public class TestEmployee {
    public static void main(String[] args)
    {
        Employee ovidiu = new Employee(25614761, "Ovidiu Luchian", "Testing");
        ovidiu.strEmpDept = "HR";
        System.out.println(String.format("Starting today %s will work for the %s department", ovidiu.strEmpName, ovidiu.strEmpDept));

        try{
            Employee alex = new Employee(0, "Alex", "Testing");
        }catch(IllegalArgumentException ex){
            System.out.println("Please enter a positive number! " + ex);
        }

        System.out.println("The ID is: " + ovidiu.getIntId());
    }
}
