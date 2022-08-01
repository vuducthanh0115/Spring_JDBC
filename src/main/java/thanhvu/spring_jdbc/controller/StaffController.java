package thanhvu.spring_jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thanhvu.spring_jdbc.entity.Staff;
import thanhvu.spring_jdbc.repository.StaffRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/staff")
public class StaffController {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
//  ("api/staff/add")
    @PostMapping("/add")
    public void addStaff(@RequestBody Staff staff) {
        staffRepository.addStaff(staff);
    }

    @PutMapping("/update/{id}")
    public int updateStaff(@RequestBody Staff staff ,@PathVariable("id") int id) {
        return staffRepository.updateStaff(id, staff);
    }

    /*@PatchMapping("/update/{id}")
    public void updateStaffPatch(@RequestBody Staff staff ,@PathVariable("id") int id) {
        Staff s = staffRepository.getStaffById(id);
        s.setStaffName(staff.getStaffName());
        staffRepository.updateStaffP(id, s);
    }*/

    @GetMapping("/get")
    public Optional getStaff(@RequestParam("id") int id) {
        return staffRepository.getStaffById(id);
    }

    @GetMapping("/all")
    public List<Staff> getStaff() {
        return staffRepository.getAllStaff();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStaff(@PathVariable("id") int id) {
        staffRepository.deleteStaffById(id);
    }


}
