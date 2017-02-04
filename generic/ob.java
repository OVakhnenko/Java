package generic;

public class ob {

    class Gen<T> {
        T ob; // объявление объекта типа T

        // Передать конструктору ссылку на объект типа T
        Gen(T o) {
            ob = o;
        }

        // Вернуть ob
        T getob() {
            return ob;
        }

        // Показать тип T
        void showType() {
            System.out.println("Тип T: " + ob.getClass().getName());
        }
    }

    public void main(String[] args) {
        // Код для кнопки
        // Работаем с обобщённым классом
        // Создаём Gen-ссылку для Integer
        Gen<Integer> iOb;

        // Создаём объект Gen<Integer>
        iOb = new Gen<Integer>(77);

        // Показать тип данных, используемый iOb
        iOb.showType();

        // Получить значение iOb
        int value = iOb.getob();
        System.out.println("Значение " + value);

        // Создадим объект Gen для String
        Gen<String> strOb = new Gen<String>("Обобщённый текст");

        // Показать тип данных, используемый strOb
        strOb.showType();

        // Получить значение strOb
        String str = strOb.getob();
        System.out.println("Значение: " + str);
    }
}
