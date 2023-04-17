package view;
import Controller.PhoneBookManage;
import module.Contact;
import module.Type;

import java.io.IOException;
import java.util.Scanner;

public class ManagePhoneBook {

    static PhoneBookManage phoneBookManage = new PhoneBookManage();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true){
            System.out.println(" 1, Thêm số mới(insertPhone) ");
            System.out.println(" 2, Hiển thị số theo Type(display) ");
            System.out.println(" 3, Tìm số theo tên(searchPhone) ");
            System.out.println(" 4, Sắp xếp theo tên(sort) ");
            System.out.println(" 5, Cập nhập số(updatePhone) ");
            System.out.println(" 6, Xóa số theo tên(removePhone) ");
            System.out.println(" 7,          LOAD DATA            ");
            System.out.println(" 8,          SAVE DATA            ");
            System.out.println(" 0,           THOÁT               ");
            System.out.print("=> : ");
            String choice = new Scanner(System.in).nextLine();
            switch (choice){
                case "1":
                    insertPhone();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    searchPhone();
                    break;
                case "4":
                    sort();
                    break;
                case "5":
                    updatePhone();
                    break;
                case "6":
                    removePhone();
                    break;
                case "7":
                    String fileLoad = "D:\\java\\main\\hai.bin";
                    phoneBookManage.loadFromFile(fileLoad);
                    break;
                case "8":
                    String fileSave = "D:\\java\\main\\hai.bin";
                    phoneBookManage.saveToFile(fileSave);
                    break;
                case "0":
                    return;
            }
        }
    }

    public static void insertPhone(){
        System.out.print("Nhập tên mới: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Nhập Số Mới: ");
        String numberPhone = new Scanner(System.in).nextLine();
        Contact contact = new Contact(name, numberPhone);
        phoneBookManage.insertPhone(contact);
    }
    public static void display(){
        System.out.println("""
                1, Hiển thị tất cả danh bạ
                2, Hiển thị theo Type
                """);
        String choice = new Scanner(System.in).nextLine();
        switch (choice){
            case "1":
                phoneBookManage.display(null);
                break;
            case "2":
                System.out.print("Nhập ID Type: ");
                String id = new Scanner(System.in).nextLine();
                System.out.print("Nhập Tên Type: ");
                String name = new Scanner(System.in).nextLine();
                Type type = new Type(id, name);
                phoneBookManage.display(type);
                break;
        }
    }
    public static void searchPhone(){
        System.out.print("Nhập tên cần tìm kiếm: ");
        String name = new Scanner(System.in).nextLine();
        phoneBookManage.searchPhone(name);
    }
    public static void sort(){
        phoneBookManage.sort();
    }
    public static void updatePhone(){
        System.out.print("Nhập tên cần sửa: ");
        String oldName = new Scanner(System.in).nextLine();
        System.out.print("Nhập Số mới: ");
        String newPhone = new Scanner(System.in).nextLine();
        phoneBookManage.updatePhone(oldName, newPhone);
    }
    public static void removePhone(){
        System.out.print("Nhập tên cần xóa số: ");
        String name = new Scanner(System.in).nextLine();
        phoneBookManage.removePhone(name);
    }
}
