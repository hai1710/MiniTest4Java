package Controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class PhoneBookManage extends Phone implements IPhone {
    private ArrayList<Contact> contactArrayList;
    private ArrayList<Type> typeArrayList;

    public PhoneBookManage() {
        contactArrayList = new ArrayList<>();
        typeArrayList = new ArrayList<>();
    }
    public void saveToFile(String filename) throws IOException {
        WriteFile<Contact> writeFile = new WriteFile<>();
        writeFile.writeToFile(filename, contactArrayList);
        System.out.println("Lưu danh bạ thành công vào " + filename);
    }
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        ReadFile<Contact> readFile = new ReadFile<>();
        contactArrayList = readFile.readFromFile(filename);
        System.out.println("Đọc dữ liệu từ " + filename + " thành công.");
    }
    public void addType(Type type) {
        typeArrayList.add(type);
    }
    @Override
    public void searchPhone(String name) {
        boolean isFound = false;
        for (Contact c : contactArrayList) {
            if (c.getName().equals(name)) {
                System.out.println(c);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Không tìm thấy liên hệ có tên " + name + " trong danh sách.");
        }
    }

    @Override
    public void sort() {
        Collections.sort(contactArrayList, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        for (Contact c : contactArrayList) {
            System.out.println(c);
        }
    }

    @Override
    void display(module.Type type) {

    }

    @Override
    void insertPhone(Contact contact) {

    }

    @Override
    void removePhone(String name) {

    }

    @Override
    void updatePhone(String name, String newPhone) {

    }

    public static class Type implements Serializable {

        private String idType;
        private String nameType;
        public Type(String idType, String nameType) {
            this.idType = idType;
            this.nameType = nameType;
        }

        public String getIdType() {
            return idType;
        }

        public void setIdType(String idType) {
            this.idType = idType;
        }

        public String getNameType() {
            return nameType;
        }

        public void setNameType(String nameType) {
            this.nameType = nameType;
        }

        @Override
        public String toString() {
            return idType + "\t\t" + nameType;
        }
    }
}