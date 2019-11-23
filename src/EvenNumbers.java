

public class EvenNumbers {

    private int number, div = 8,count = 20;


    public EvenNumbers(int number) {
        this.number = number;
    }
    public EvenNumbers(int number,int divider) {
        this.number = number;
        div = divider;
    }
    public EvenNumbers(int number ,int divider , int count) {
        this.number = number;
        div = divider;
        this.count = count;
    }

    public void show() {
        try {
            for (int i = 0; i < count; ) {

                if (number % div == 0 ) {
                    System.out.print(number++ + " ");
                    i++;
                }
                else ++number;

            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }



}
