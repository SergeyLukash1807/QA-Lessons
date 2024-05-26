public class Park {
    private String name;
    private String address;
    private String workTime;
    public static class Attractions {
        private String name;
        private String workTime;
        private int price;

        public Attractions (String name, String workTime, int price) {
            this.name = name;
            this.price = price;
            this.workTime = workTime;
        }
    }
}
