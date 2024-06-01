public class Dog extends Animals {
    static int countDog = 0;
    private String name;
    private int age;
    private String color;
    private int weight;
    private String breed;


    public Dog(String name, int age, String color, int weight, String breed) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.breed = breed;
        countDog++;
    }
    @Override
    public void run (int distance) {
        if (distance < 0) {
            System.out.println("Некоректно задана дистанция.");
        }else if (distance <= 500) {
            System.out.printf(name + " ");
            super.run(distance);
        } else
            System.out.println("Слишком большая дистанция для собаки " + name + ".");
    }

    @Override
    public void swim (int distance) {
        if (distance < 0) {
            System.out.println("Некоректно задана дистанция.");
        }else if (distance <= 10) {
            System.out.printf(name + " ");
            super.swim(distance);
        } else
            System.out.println("Слишком большая дистанция для собаки " + name + ".");
    }
    static int getCountDog(){
        return countDog;
    }
}
