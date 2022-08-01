package thanhvu.spring_jdbc.entity;

import java.time.LocalDate;

public class Staff {
    private int id;
    private int officerId;
    private String staffName;
    private int age;
    private int gender;
    private String address;
    private String specializedAtt;
    private String created_at;

    public Staff() {
    }

    public Staff(int id, int officerId, String staffName, int age, int gender, String address, String specializedAtt,
     String created_at) {
        this.id = id;
        this.officerId = officerId;
        this.staffName = staffName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.specializedAtt = specializedAtt;
        this.created_at = created_at;
    }
    public Staff(int officerId, String staffName, int age, int gender, String address, String specializedAtt) {
        this.officerId = officerId;
        this.staffName = staffName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.specializedAtt = specializedAtt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecializedAtt() {
        return specializedAtt;
    }

    public void setSpecializedAtt(String specializedAtt) {
        this.specializedAtt = specializedAtt;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", officerId=" + officerId +
                ", staffName='" + staffName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", specializedAtt='" + specializedAtt + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
