package marketWithPatternCommand.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.TreeMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BucketTest {

    private Bucket bucket = new Bucket();
    private Bucket bucketMock = mock(Bucket.class);

    private static final String DUMMY_NAME_1 = "DUMMY_NAME_1";
    private static final Item ITEM_1 = new Item(DUMMY_NAME_1, 100, "RUB", 10);

    // положили 1 позицию в корзину,
    // проверили сколько товарных позиций там теперь лежит
    @Test
    public void putTest01() {
        bucket.putItem(DUMMY_NAME_1, ITEM_1);
        assertEquals(1, bucket.getBucketStorage().size());
    }

    // положили 1 позицию в корзину, используя метод putItem
    // проверили сколько раз вызвался метод и c верными ли аргументами он вызвался
    @Test
    public void putTest01mock() {
        bucketMock.putItem(DUMMY_NAME_1, ITEM_1);
        verify(bucketMock, times(1)).putItem(DUMMY_NAME_1, ITEM_1);
    }

    // просто наполняем бакет 1 тов. позицией и проверяем возвращается ли TreeMap с данным товаром
    @Test
    public void get01() {
        bucket.putItem(DUMMY_NAME_1, ITEM_1);
        assertEquals(new TreeMap<String, Item>(){{put(DUMMY_NAME_1, ITEM_1);}}, bucket.getBucketStorage());
    }
}