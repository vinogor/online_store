package marketWithPatternCommand.dao;

import marketWithPatternCommand.dao.impl.BucketDaoImpl;
import marketWithPatternCommand.entity.Item;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SimpleDraftTest {

    private static List<Item> allItems;

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

        BucketDao bucketDao = (BucketDaoImpl) appContext.getBean("bucketDaoImpl");

        showAll(bucketDao);

        System.out.println("ищем по имени");
        bucketDao.findByName("Pistol").show();

        System.out.println();
        System.out.println();
        System.out.println("удаляем Pistol");
        bucketDao.delete(new Item("Pistol", 1, 1));

        showAll(bucketDao);

        System.out.println("добавляем новое значенеие");
        bucketDao.insert(new Item("Plate", 3, 66));

        showAll(bucketDao);

        bucketDao.update(new Item("Plate", 3, 6666));
        showAll(bucketDao);

        appContext.close();
    }

    static void  showAll(BucketDao bucketDao) {
        System.out.println();
        System.out.println("Сейчас в корзине: ");
        allItems = bucketDao.findAll();

        for(Item item : allItems) {
            item.show();
            System.out.println();
        }
        System.out.println();
    }
}
