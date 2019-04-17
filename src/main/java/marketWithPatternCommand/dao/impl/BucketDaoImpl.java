package marketWithPatternCommand.dao.impl;

import marketWithPatternCommand.dao.BucketDao;
import marketWithPatternCommand.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BucketDaoImpl implements BucketDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Item> findAll() {

        System.out.println("получить все Item из Bucket");

        List<Item> results = jdbcTemplate.query(
                SQL_FIND_ALL,
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
        return results;
    }

    @Override
    public Item findByName(String name) {

        Object[] objects = new Object[]{name};

        Item item = jdbcTemplate.queryForObject(
                SQL_FIND_BY_NAME, objects, new RowMapper<Item>() {
                    @Override
                    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                        Item item = new Item();
                        item.setName(resultSet.getString("name"));
                        item.setPrice(resultSet.getInt("price"));
                        item.setQuantity(resultSet.getInt("quantity"));
                        return item;
                    }
                }
        );
        return item;
    }

    @Override
    public void insert(Item item) {
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT, new String[] {  });
                ps.setString(1, item.getName());
                ps.setInt(2, item.getPrice());
                ps.setInt(3, item.getQuantity());
                return ps;
            }
        };
        jdbcTemplate.update(preparedStatementCreator);

    }

    // устнавливает НОВОЕ значение quantity
    @Override
    public void update(Item item) {
        // кол-во   /   имя
        Object[] objects = new Object[] {
                item.getQuantity(),
                item.getName()
        };
        jdbcTemplate.update(SQL_UPDATE, objects);
    }

    @Override
    public void delete(Item item) {
        Object[] objects = new Object[] {
                item.getName()
        };
        jdbcTemplate.update(SQL_DELETE, objects);
    }
}