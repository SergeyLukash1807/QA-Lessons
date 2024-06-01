public class Animals {
    static int countAnimals = 0;
    public Animals () {
        countAnimals++;
    }

    public void run (int distance) {
        if (distance > 0)
            System.out.println("пробежал " + distance + " м.");
        else
            System.out.println("Некоректно задана дистанция.");

    }
    public void swim (int distance) {
        if (distance > 0)
            System.out.println("проплыл " + distance + " м.");
        else
            System.out.println("Некоректно задана дистанция.");
    }
    public static int getCountAnimals(){
        return countAnimals;
    }

}
