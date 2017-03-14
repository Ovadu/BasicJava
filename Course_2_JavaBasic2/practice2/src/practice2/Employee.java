package practice2;

/**
 * Created by practice.luchian on 15-Feb-17.
 */
public class Employee {
    int intId;
    String strEmpName;
    String strEmpDept;

    public Employee (int intId, String strEmpName, String strEmpDept) throws IllegalArgumentException
    {
        this.intId = intId;
        this.strEmpName = strEmpName;
        this.strEmpDept = strEmpDept;

        if (intId <= 0){
            throw new IllegalArgumentException();
        }

        System.out.println(String.format("Welcome %s! You are now part of %s department  and your ID is %s", strEmpName, strEmpDept, intId));
    }

    public int getIntId(){
        return intId;
    }

}
