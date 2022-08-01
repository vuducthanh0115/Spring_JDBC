package thanhvu.spring_jdbc.repository;

import thanhvu.spring_jdbc.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffRepository {
    int addStaff(Staff staff);
    int updateStaff(int id, Staff staff);
    int updateStaffP(int id, Staff staff);
    Optional getStaffById(int id);
    int deleteStaffById(int id);
    List<Staff> getAllStaff();


}
