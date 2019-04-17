package marketWithPatternCommand;

import marketWithPatternCommand.entity.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

import static marketWithPatternCommand.Constants.*;

public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

        Store storeOrig = new Store();

        ClassLoader classLoader = storeOrig.getClass().getClassLoader();
        Class<?>[] interfaces = storeOrig.getClass().getInterfaces();
        InvocationHandlerForStore invocationHandler = new InvocationHandlerForStore(storeOrig);

        StoreInterface proxyStore = (StoreInterface) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        proxyStore.addItem(new ItemWithShelfLife("milk", 3, USD, 20));

        proxyStore.addItem("Car", 100, USD,10);
        proxyStore.addItem("Pistol", 50, RUB, 100);
        proxyStore.addItem("Pencil", 10, RUB, 1);

        proxyStore.addItem(new ItemSimple("plate", 5, RUB, 200));


        Buyer buyer = new Buyer("Sasha", 5000);

        Market market = new Market(storeOrig, buyer);
        market.start();

        appContext.close();
    }
}
