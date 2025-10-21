package three;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

class Dish {
    String name;
    int price;
    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

class Order {
    private static int globalId = 0;
    int id;
    int price;
    Date date;
    Dish[] content;
    public Order(Date date, Dish[] content) {
        this.id = globalId++;
        this.date = date;
        this.content = content;
        int price = 0;
        for (Dish dish : content) {
            price += dish.price;
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==  this) return true;
        if (obj == null || obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        if (this.id != other.id) return false;
        if (this.price != other.price) return false;
        if (this.date != other.date) return false;
        if (!Arrays.equals(this.content, other.content)) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format(
            "Заказ №%s:\n стоимость - %s,\n заказанные блюда - %s",
            id, date.toString(), Arrays.toString(content)
        );
    }
}

public class RestaurantHashMap {
    private HashMap<Integer, Order> orderMap;

    public RestaurantHashMap() {
        orderMap = new HashMap<Integer, Order>();
    }

    public void insert(int tableId, Order order) {
        orderMap.put(tableId, order);
    }
    public void delete(int tableId) {
        orderMap.remove(tableId);
    }
    public Order get(int tableId) {
        return orderMap.get(tableId);
    }
}

class Restaurant {
    public static void main(String[] args) {
        RestaurantHashMap restaurantHashMap = new RestaurantHashMap();
        //Придумаем пару блюд
        Dish fries = new Dish("Картошка фри", 300);
        Dish steak = new Dish("Стейк", 800);
        Dish juice = new Dish("Сок", 150);
        //Добавим заказы в таблицу
        restaurantHashMap.insert(1, new Order(
                new Date(System.currentTimeMillis()), new Dish[]{fries, steak}
            )
        );
        restaurantHashMap.insert(2, new Order(
                new Date(System.currentTimeMillis()), new Dish[]{fries, fries, juice}
            )
        );
        System.out.println(restaurantHashMap.get(1).toString());
        //Заменим один из них
        restaurantHashMap.insert(1, new Order(
                        new Date(System.currentTimeMillis()), new Dish[]{juice, juice}
                )
        );
        System.out.println(restaurantHashMap.get(1).toString());
        //Теперь удалим его
        restaurantHashMap.delete(1);
        System.out.println(restaurantHashMap.get(1));
    }
}