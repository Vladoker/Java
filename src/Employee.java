import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee {

    private String name,surname,address;
    private Calendar date;
    private boolean sex;
    private double salary;


    public Employee(String name, String surname,boolean sex, byte day, byte month, int year, String address, double salary) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        date = new GregorianCalendar(year,--month,day);
    }

    public String toString() {
        return "Name: " + name + "\nSurname: " + surname + "\nSex: " + (sex ? "M":"W") + "\nAddress: " + address + "\nSalary: " + salary +
               "\nДень: " +  date.get(Calendar.DAY_OF_MONTH) + " Месяц: " + (date.get(Calendar.MONTH) +1) + " Год: " + date.get(Calendar.YEAR);
    }




}
