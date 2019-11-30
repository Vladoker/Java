import java.io.*;

public class Main {
    public static void main(String[] args)  {
//        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            EmployeeManager employeeManager = EmployeeManager.getInstance();
//            String user;
//            for (;;){
//                user = "";
//                line("Employee Manager",'-');
//                System.out.println("1. Add employees");
//                System.out.println("2. List employees");
//                System.out.println("3. Export employees");
//                System.out.println("0. Exit");
//                line("-",'-');
//                System.out.print("choose option: ");
//                user = reader.readLine();
//
//                if (user.equals("1")){
//                    System.out.print("count employees: ");
//                    user = reader.readLine();
//                    employeeManager.addEmployee(Integer.parseInt(user));
//                }
//                else if(user.equals("2")){
//                    employeeManager.showEmployee();
//                }
//                else if (user.equals("0")){
//                    break;
//                }
//            }
//        }
//        catch (Exception ex){
//            System.out.println(ex);
//        }



        EmployeeManager employeeManager = EmployeeManager.getInstance();
        employeeManager.addEmployee(1);
        employeeManager.exportEmployee("C:\\Users\\Vladislav\\Downloads\\test\\test.txt");







    }

    public static void star(int count) {
        char s = '*';
        String str = "";

        for (int i = 0; ; i++) {
            if (i < count ) System.out.println(str += s);
            else {
                for (int j = count - 1; j > 0 ; j--) {
                    for (int k = 0; k < j; k++) {
                        System.out.print(s);
                    }
                    System.out.println();
                }
                break;
            }
        }
    }

    public static void line (String str,char separator){
        int count = 50;
        count = (count - str.length()) / 2;
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print(separator);
        }
        System.out.print(str);
        for (int i = 0; i < count; i++) {
            System.out.print(separator);
        }
        System.out.println();
    }
}
