package thanhvu.spring_jdbc.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Staff(
                rs.getInt("id"),
                rs.getInt("officer_id"),
                rs.getString("staff_name"),
                rs.getInt("age"),
                rs.getInt("gender"),
                rs.getString("address"),
                rs.getString("specialized_att"),
                rs.getString("created_at")
        );
    }
}
