public class Park {
    private String name;
    private String address;
    private String workTime;
    public Park(String name, String address, String workTime) {
        this.name = name;
        this.address = address;
        this.workTime = workTime;
    }
    public class Attraction {
        private String name;
        private String workTime;
        private int price;
        public Attraction (String name, String workTime, int price) {
            this.name = name;
            this.price = price;
            this.workTime = workTime;
        }

        @Override
        public String toString() {
            return "Название атракциона: " + name + '\'' +
                    ", время работы: " + workTime + '\'' +
                    ", цена билета: " + price;
        }
    }
    public static void main(String[] args) {
        Park mirKaruseley = new Park("Мир Каруселей", "г. Светлогорск, Калининградское шоссе 17", "10:00 - 22:00");
        Park.Attraction [] mirKaruseleyAttractionArray = new Attraction[4];
        mirKaruseleyAttractionArray [0] = mirKaruseley. new Attraction ("Карусель", "10:00 - 17:00", 500);
        mirKaruseleyAttractionArray [1] = mirKaruseley. new Attraction ("Колесо обозрения", "12:00 - 22:00", 600);
        mirKaruseleyAttractionArray [2] = mirKaruseley. new Attraction ("Картинг", "10:00 - 15:00", 500);
        mirKaruseleyAttractionArray [3] = mirKaruseley. new Attraction ("Лабиринт", "12:00 - 19:00", 400);
        System.out.println(mirKaruseley);
        for (Attraction attraction : mirKaruseleyAttractionArray) {
            System.out.println(attraction);
        }
    }
    @Override
    public String toString() {
        return "Название парка: " + name + '\'' +
                "адресс: " + address + '\'' +
                ", время работы парка: " + workTime + '\'';
    }
}
















