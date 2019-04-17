package marketWithPatternCommand.database;

import marketWithPatternCommand.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SpringJdbcAndH2db {

    @Autowired
    @Qualifier("jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    void getItems() {
//        System.out.println(jdbcTemplate);
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