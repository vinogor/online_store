package marketWithPatternCommand;

import marketWithPatternCommand.entity.FieldToSetDate;
import marketWithPatternCommand.entity.ItemWithShelfLife;
import marketWithPatternCommand.entity.Store;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;

// "Обработчик вызовов"
public class InvocationHandlerForStore implements InvocationHandler {

    private Store origStore;

    public InvocationHandlerForStore(Store origStore) {
        this.origStore = origStore;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("addItem")) {
            if (args[0] instanceof ItemWithShelfLife) {

                Class clazz = args[0].getClass();

                Field[] fields = clazz.getDeclaredFields();

                Calendar c1 = new GregorianCalendar(); // текущее время
                Calendar c2 = (GregorianCalendar) c1.clone(); // +7 дней
                c2.add(Calendar.DAY_OF_YEAR, 7);

                for (Field f : fields) {
                    f.setAccessible(true);
                    // определяем, есть ли у поля нужная нам аннотация
                    if (f.isAnnotationPresent(FieldToSetDate.class)){
                        FieldToSetDate fieldToSetDate = f.getAnnotation(FieldToSetDate.class);
                        if (fieldToSetDate.dateType() == 1) {
                            f.set(args[0], c1);
                        }
                        if (fieldToSetDate.dateType() == 2) {
                            f.set(args[0], c2);
                        }
                    }
                }

                // СПОСОБ БЕЗ АННОТАЦИЙ (работает)
//                for (Field f : fields) {
//                    f.setAccessible(true);
//
//                    if (f.getName().equals("dateOfDelivery")) {
//                        f.set(args[0], c1);
//                    }
//                    if (f.getName().equals("dateOfShelfLife")) {
//                        f.set(args[0], c2);
//                    }
//                }

            }
        }
        return method.invoke(origStore, args);
    }
}
