/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-07
 * Time:19:44
 */
public class Main {
    public static void main(String[] args) throws ArrayOutOfIndexException {
        MyArraylist list = new MyArraylist();
        list.add(0,1);
        list.add(1,34);
        list.set(2,56);
        list.display();
        System.out.println("===========");
        list.add(35);
        list.add(74);
        list.display();
        System.out.println("==================");
        System.out.println(list.contains(74));
        System.out.println(list.indexOf(74));
        System.out.println(list.get(4));
        System.out.println("=================");
        list.remove(74);
        list.display();
    }
}
