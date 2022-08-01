package thanhvu.spring_jdbc.service;

import thanhvu.spring_jdbc.entity.Staff;

import java.util.List;

public interface StaffService {
    Boolean addStaffByPreparedStatement(Staff staff);
    List<Staff> getAllStaffs();

    List<Staff> getAllStaffsRowMapper();
}
