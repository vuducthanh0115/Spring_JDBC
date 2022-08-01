package thanhvu.spring_jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thanhvu.spring_jdbc.entity.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("staffs")
public class StaffServiceImpl implements StaffService{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean addStaffByPreparedStatement(Staff staff){
        String sqlInsert="""
            insert into staff(officer_id, staff_name, age, gender, address,specialized_att)
            values (?,?,?,?,?,?);
            """;
        return jdbcTemplate.execute(sqlInsert, (PreparedStatementCallback<Boolean>) preparedStatement -> {
            preparedStatement.setInt(1,staff.getOfficerId());
            preparedStatement.setString(2,staff.getStaffName());
            preparedStatement.setInt(3,staff.getAge());
            preparedStatement.setInt(4,staff.getGender());
            preparedStatement.setString(5,staff.getAddress());
            preparedStatement.setString(6,staff.getSpecializedAtt());
            return preparedStatement.execute();
        });
    }

    //@Transactional
    public void insert(List<Staff> listStaff) {
        String sql = """
            insert into staff(officer_id, staff_name, age, gender, address,specialized_att)
            values (?,?,?,?,?,?);
            """;
        for (Staff staff: listStaff) {
            jdbcTemplate.update(sql,staff.getOfficerId(), staff.getStaffName(), staff.getAge(),
                    staff.getGender(),staff.getAddress(),staff.getSpecializedAtt());
            System.out.println("Inserted staff: " + staff.getId() +" - " +staff.getStaffName());
        }
    }

    public List<Staff> getAllStaffs(){
        return jdbcTemplate.query("select * from staff",new ResultSetExtractor<List<Staff>>(){
            @Override
            public List<Staff> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Staff> list=new ArrayList<Staff>();
                while(rs.next()){
                    Staff staff=new Staff();
                    staff.setId(rs.getInt(1));
                    staff.setOfficerId(rs.getInt(2));
                    staff.setStaffName(rs.getString(3));
                    staff.setAge(rs.getInt(4));
                    staff.setGender(rs.getInt(5));
                    staff.setAddress(rs.getString(6));
                    staff.setSpecializedAtt(rs.getString(7));
                    staff.setCreated_at(rs.getString(8));
                    list.add(staff);
                }
                return list;
            }
        });
    }

    @Override
    public List<Staff> getAllStaffsRowMapper() {
        return jdbcTemplate.query("select * from staff",new RowMapper<Staff>(){
            @Override
            public Staff mapRow(ResultSet rs, int rownumber) throws SQLException {
                Staff staff = new Staff();
                staff.setId(rs.getInt(1));
                staff.setOfficerId(rs.getInt(2));
                staff.setStaffName(rs.getString(3));
                staff.setAge(rs.getInt(4));
                staff.setGender(rs.getInt(5));
                staff.setAddress(rs.getString(6));
                staff.setSpecializedAtt(rs.getString(7));
                staff.setCreated_at(rs.getString(8));
                return staff;
            }
        });
    }

}
