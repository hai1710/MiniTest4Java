package Controller;

import module.Type;

public abstract class Phone {
    abstract void display(Type type);
    abstract void insertPhone(Contact contact);
    abstract void removePhone(String name);
    abstract void updatePhone(String name, String newPhone);

    public static class Contact {
        private String name;
        private String phoneNumber;
        private Type type;

        public Contact() {
        }

        public Contact(String name, String phoneNumber, Type type) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
