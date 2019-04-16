package marketWithPatternCommand.database;

import marketWithPatternCommand.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcRepo {

    @Autowired
            @Qualifier("getJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    void getTableStore() {
        System.out.println(jdbcTemplate);
        List<Item> results = jdbcTemplate.query(
                "SELECT * FROM store",
                new RowMapper<Item>() {
                    @Override
                    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Item(
                                rs.getString("name"),
                                rs.getInt("price"),
                                rs.getInt("quantity")
                        );
                    }
                });

        for (Item item : results) {
            item.show();
            System.out.println();
        }
    }
}
