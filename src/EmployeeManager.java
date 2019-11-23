import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EmployeeManager {
    private static EmployeeManager instance;
    private ArrayList<Employee> list;


    private EmployeeManager() {
        list = new ArrayList<>();
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

    public void addEmployee(int count){

        try(BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in))){

            for (int i = 0; i < count; ) {
                String[] mas = new String[6];

                System.out.println("/////////////////////////////////////////////////////////////////");
                System.out.println("insert Name: ");
                mas[0] = reader.readLine();

                System.out.println("insert Surname: ");
                mas[1] = reader.readLine();

                System.out.println("sex: ");
                mas[2] = reader.readLine();

                System.out.println("Введите дату рождения в формате day.month.year : ");
                mas[3] = reader.readLine();

                System.out.println("address: ");
                mas[4] = reader.readLine();

                System.out.println("salary: ");
                mas[5] = reader.readLine();

                try {
                    boolean s = false;
                    String strSex = mas[2].toUpperCase();
                    if (strSex.contains("B") || strSex.contains("M") || strSex.contains("М") || strSex.contains("1")){
                        s = true;
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
        for (int i = 0; i < list.size(); i++) {
            System.out.println("/////////////////////////////////////////////////////////////////");
            System.out.println(list.get(i).toString());
        }
    }

}
