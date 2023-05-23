import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Scanner;

public class Test {
    //主界面
    public static void menu(){
        System.out.println();
        System.out.println("*****************欢迎来到电子小词典****************");
        System.out.println("***********1.增加单词          2.删除单词**********");
        System.out.println("***********3.修改单词          4.查找单词**********");
        System.out.println("***********5.查看全部单词       6.退出词典**********");
        System.out.println();
        System.out.print("请输入您选择的功能：");
    }


    public static void func(){
        Dictionary dictionary = new Dictionary();
        dictionary.init(dictionary);//初始化词典
        Scanner scanner = new Scanner(System.in);
        String choice;//用户输入
        do{
            menu();
            choice=scanner.nextLine();

            switch (choice){
                case "1":
                    System.out.print("请输入单词：");
                    String word = scanner.nextLine();
                    System.out.print("请输入词意：");
                    String value = scanner.nextLine();
                    dictionary.insert(word,value);
                    System.out.println("添加成功！");
                    break;
                case "2":
                    System.out.print("请输入待删除的单词：");
                    word = scanner.nextLine();
                    boolean ret = dictionary.remove(word);
                    if(ret){
                        System.out.println("删除成功！");
                    }
                    break;
                case "3":
                    System.out.print("请输入需要修改的单词：");
                    word = scanner.nextLine();
                    System.out.print("请输入修改后的单词：");
                    value = scanner.nextLine();
                    dictionary.revise(word,value);
                    System.out.println("修改成功！");
                    break;
                case "4":
                    System.out.print("请输入查找的单词：");
                    word = scanner.nextLine();
                    Dictionary.TreeNode ret1 = dictionary.search(word);
                    if(ret1!=null){
                        System.out.println("您查找到的单词是："+ret1.key+"  "+ret1.values);
                    }else{
                        System.out.println("查找失败，单词不存在");
                    }
                    break;
                case "5":
                    System.out.println("可查看单词的选择有：   1.前序遍历  2.中序遍历  3.后序遍历");
                    System.out.print("请选择：");
                    String choice1 = scanner.nextLine();
                    while(true){
                        if(choice1.compareTo("1")==0){
                            dictionary.order();
                            break;
                        }else if(choice1.compareTo("2")==0){
                            dictionary.inorder();
                            break;
                        }else if(choice1.compareTo("3")==0){
                            dictionary.reorder();
                            break;
                        }else{
                            System.out.print("输入错误，请重新输入：");
                        }
                    }
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误，请重新选择！");
                    break;
            }
        }while(choice.compareTo("6")!=0);
    }

    public static void main(String[] args) {
        func();
    }
}
