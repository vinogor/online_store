package marketWithPatternCommand.database;

import marketWithPatternCommand.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SpringJdbcAndH2db {

    private JdbcTemplate jdbcTemplate;

//    @Qualifier("jdbcTemplate")
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void getItems() {
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