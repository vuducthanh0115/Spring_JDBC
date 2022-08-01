package thanhvu.spring_jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thanhvu.spring_jdbc.entity.Staff;
import thanhvu.spring_jdbc.entity.StaffMapper;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Repository("staff")
public class StaffRepositoryImpl implements StaffRepository {
    private static final String sqlInsert = """
            insert into staff(officer_id, staff_name, age, gender, address,specialized_att)
            values (?,?,?,?,?,?);
            """;
    private static final String sqlUpdate = """
            update staff 
            set 
            officer_id = ?,
            staff_name = ?, 
            age = ?, 
            gender = ?, 
            address = ?,
            specialized_att = ? 
            where id = ?;
            """;
    private static final String sqlSelectById = """
            select * from staff
            where id = ?;
            """;
    private static final String sqplDeleteById = """
            delete from staff where id = ?;
            """;
    private static final String sqlSelectAll = """
            select * from staff;
            """;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StaffRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addStaff(Staff staff) {
        return jdbcTemplate.update(sqlInsert,
                staff.getOfficerId(),
                staff.getStaffName(),
                staff.getAge(),
                staff.getGender(),
                staff.getAddress(),
                staff.getSpecializedAtt()
        );
    }

    @Override
    public int updateStaff(int id, Staff staff) {
        return jdbcTemplate.update(sqlUpdate,
                staff.getOfficerId(),
                staff.getStaffName(),
                staff.getAge(),
                staff.getGender(),
                staff.getAddress(),
                staff.getSpecializedAtt(),
                id
        );
    }

    @Override
    public int updateStaffP(int id, Staff staff) {
        return jdbcTemplate.update(sqlUpdate,
                staff.getOfficerId(),
                id
        );
    }

    @Override
    public Optional getStaffById(int id) {
        return jdbcTemplate.query(sqlSelectById, new StaffMapper(), id)
                .stream()
                .findFirst();
        /*return jdbcTemplate.queryForObject(sqlSelectById, (rs, rowNum)->
            new Staff(
                    rs.getInt("id"),
                    rs.getInt("officer_id"),
                    rs.getString("staff_name"),
                    rs.getInt("age"),
                    rs.getInt("gender"),
                    rs.getString("address"),
                    rs.getString("specialized_att"),
                    rs.getString("created_at")
            ),id
        );*/
    }

    @Override
    public int deleteStaffById(int id) {
        return jdbcTemplate.update(sqplDeleteById, id);
    }

    @Override
    public List<Staff> getAllStaff() {
        return jdbcTemplate.query(sqlSelectAll, new StaffMapper());
    }
}
