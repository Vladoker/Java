import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class EmployeeManager {
    private static EmployeeManager instance;
    private Set<Employee> list;


    private EmployeeManager() {
        list = new HashSet<>();
    }

    public static EmployeeManager getInstance(){
        if (instance == null){
            instance = new EmployeeManager();
        }
        return instance;
    }

    public int GetEmployeeCount(){
        return list.size();
    }

    public void addEmployee(int count, BufferedReader reader){

        try {
            for (int i = 0; i < count; ) {
                String[] mas = new String[6];

                Main.line("-",'-');
                System.out.print("insert Name: ");
                mas[0] = reader.readLine();

                System.out.print("insert Surname: ");
                mas[1] = reader.readLine();

                System.out.print("sex: ");
                mas[2] = reader.readLine();

                System.out.print("Введите дату рождения в формате day.month.year : ");
                mas[3] = reader.readLine();

                System.out.print("address: ");
                mas[4] = reader.readLine();

                System.out.print("salary: ");
                mas[5] = reader.readLine();

                try {
                    Gender s = Gender.FEMALE;
                    String strSex = mas[2].toUpperCase();
                    if (strSex.contains("B") || strSex.contains("M") || strSex.contains("М") || strSex.contains("1")){
                        s = Gender.MALE;
                    }

                    String[] date = mas[3].split("\\.");


                    byte d = Byte.parseByte(date[0]);
                    byte m = Byte.parseByte(date[1]);
                    int y = Integer.parseInt(date[2]);
                    double salary = Double.parseDouble(mas[5]);

                    list.add(new Employee(mas[0], mas[1], s, d, m, y, mas[4], salary));

                    i++;

                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }

        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void showEmployee(){
        Iterator iter = list.iterator();
        for (; iter.hasNext(); ) {
            Main.line("-",'-');
            System.out.println(iter.next().toString());
        }
    }

    public void exportEmployee(String patch){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(patch))) {

            for (Employee emp : list) {
                bufferedWriter.write(emp.toString());
                bufferedWriter.write("\r\n************************************************\r\n");
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public Employee searchEmployee(String nameAndSurname) {
        for(Employee emp : list){
            String temp = (emp.getName()+ " " + emp.getSurname()).toUpperCase();
            String temp2 = (emp.getSurname()+ " " + emp.getName()).toUpperCase();
            if (nameAndSurname.equalsIgnoreCase(temp) || nameAndSurname.equalsIgnoreCase(temp2)) return emp;
        }
        return null;
    }

    public boolean deleteEmployee(String nameAndSurname) {
       Employee emp = this.searchEmployee(nameAndSurname);
       return list.remove(emp);
    }

}
