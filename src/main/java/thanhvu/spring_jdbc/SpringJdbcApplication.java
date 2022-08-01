package thanhvu.spring_jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import thanhvu.spring_jdbc.entity.Staff;
import thanhvu.spring_jdbc.repository.StaffRepositoryImpl;
import thanhvu.spring_jdbc.service.StaffServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext con =SpringApplication.run(SpringJdbcApplication.class, args);
        StaffRepositoryImpl staffRepository = (StaffRepositoryImpl) con.getBean("staff");
        /*List<Staff> list = staffRepository.getAllStaff();
        for (Staff staff : list) {
            System.out.println(staff.toString());
        }*/

        StaffServiceImpl staffS = (StaffServiceImpl) con.getBean("staffs");

        /*staffS.addStaffByPreparedStatement(new Staff(1,"Rollback2",21,1,"HN","IT"));*/

        List<Staff> listStaff = new ArrayList<Staff>();
        listStaff.add(new Staff(1,"Rollback5",21,1,"HN","IT"));
        listStaff.add(new Staff(1,"Rollback5",21,1,"HN","IT"));
        listStaff.add(new Staff(1,"Rollback5",21,1,null,"IT"));
        staffS.insert(listStaff);

        List<Staff> lists = staffS.getAllStaffs();

        for(Staff staffs:lists){
            System.out.println(staffs);
        }

        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------");

        List<Staff> list=staffS.getAllStaffsRowMapper();

        for(Staff staffs:list){
            System.out.println(staffs);
        }


    }

}
