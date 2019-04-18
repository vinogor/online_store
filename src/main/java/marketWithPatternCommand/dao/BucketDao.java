package marketWithPatternCommand.dao;

import marketWithPatternCommand.entity.Item;

import java.util.List;

public interface BucketDao {

//    void putItem(String name, Item item);
//    Map<String, Item> getBucketStorage();
//    void show();
//    void clear();

    String MYSQL_TABLE_BUCKET = "my_base.bucket";

    String SQL_FIND_ALL = "SELECT * FROM " + MYSQL_TABLE_BUCKET;
    String SQL_FIND_BY_NAME = SQL_FIND_ALL + " WHERE " + "name" + " = ?";
    String SQL_INSERT_PARAMETERIZED = "" +
            "INSERT INTO " + MYSQL_TABLE_BUCKET + " (" + "name" + ", " + "price"  + ", " + "quantity" +
            ") values (:nameParam, :priceParam, :quantityParam)";
    String SQL_UPDATE = "UPDATE " + MYSQL_TABLE_BUCKET + " SET " + "quantity" + " = ?" + " WHERE " + "name" + " = ?";
    String SQL_DELETE = "DELETE FROM " + MYSQL_TABLE_BUCKET + " WHERE " + "name" + " = ?";

//  реализуем CRUD (Create, Read, Update, Delete) - создание, чтение, обновление и удаление.

    // получить все Item
    List<Item> findAll();

    // получить Item по имени
    Item findByName(String name);

    // вставить
    void insert(Item item);

    // изменить
    void update(Item item);

    // удалить
    void delete(Item item);
}