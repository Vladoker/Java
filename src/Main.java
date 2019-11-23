public class Main {
    public static void main(String[] args) {

        EmployeeManager employeeManager = EmployeeManager.getInstance();



        employeeManager.addEmployee(1);

        employeeManager.showEmployee();


        System.out.println("/////////////////////////////////////////////////////////////////");

        System.out.println("Колво: " + employeeManager.GetEmployeeCount());




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
}
