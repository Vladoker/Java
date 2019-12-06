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

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public boolean getSex() {
        return sex;
    }

    public String toString() {
        return "Name: " + name + "\r\nSurname: " + surname + "\r\nSex: " + (sex ? "M":"W") + "\r\nAddress: " + address + "\r\nSalary: " + salary +
               "\r\nДень: " +  date.get(Calendar.DAY_OF_MONTH) + " Месяц: " + (date.get(Calendar.MONTH) +1) + " Год: " + date.get(Calendar.YEAR);
    }


    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Employee)) return false;

        Employee temp = (Employee) obj;

        return this.name.equals(temp.getName())
                && this.surname.equals(temp.getSurname())
                && this.sex == temp.getSex();
    }




}
