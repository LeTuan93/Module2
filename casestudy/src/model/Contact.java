package src.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contact implements Comparable<Contact> {
    private String phoneNumber;
    private String contactGroup;
    private String fullName;
    private String sex;
    private String address;
    private String birthday;
    private String email;

    public Contact() {
    }

    public Contact(String phoneNumber, String contactGroup, String fullName, String sex, String address, String birthday, String email) {
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
        this.fullName = fullName;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Contact o) {
        // Tách các phần của tên
        List<String> obj1 = Arrays.asList(fullName.split(" "));
        List<String> obj2 = Arrays.asList(o.getFullName().split(" "));

        int cmpFirstName = obj1.get(obj1.size() - 1).compareTo(obj2.get(obj2.size() - 1));
        if (cmpFirstName != 0) return cmpFirstName;

        int cmpLastName = obj1.get(0).compareTo(obj2.get(0));
        if (cmpLastName != 0) return cmpLastName;

        String middleName1 = obj1.size() > 2 ? obj1.get(1) : "";
        String middleName2 = obj2.size() > 2 ? obj2.get(1) : "";
        return middleName1.compareTo(middleName2);

    }

    @Override
    public String toString() {
        return "Số điện thoại: " + phoneNumber +
                ", Tên nhóm: " + contactGroup +
                ", Họ và tên: " + fullName +
                ", Giới tính: " + sex +
                ", Địa chỉ: " + address +
                ", Ngày sinh: " + birthday +
                ", Email: " + email;
    }

}
