public class Cat extends Animals {
    static int countCat = 0;
    private String name;
    private int age;
    private String color;
    private int weight;
    private boolean satiety;
    private int needEat;


    public Cat(String name, int age, String color, int weight) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.satiety = false;
        this.needEat = weight * 12;
        countCat++;
    }

    @Override
    public void run (int distance) {
        if (distance <= 200) {
            System.out.printf(name + " ");
            super.run(distance);
        } else
            System.out.println("Слишком большая дистанция для кота " + name + ".");
    }

    @Override
    public void swim (int distance) {
        if (distance > 0) {
            System.out.println("Коты не умеют плавать.");
        } else
            System.out.println("Некоректно задана дистанция.");
    }
    static int getCountCat(){
        return countCat;
    }

    public boolean catEat (CatBowl catBowl) {
        if (!satiety) {
            if (catBowl.getFood() >= needEat) {
                catBowl.setFood(catBowl.getFood()-needEat);
                satiety = true;
                System.out.println(name + " поел и наелся");
                System.out.println("В миске осталось " + catBowl.getFood() + " еды");
                return true;
            }else {
                System.out.println(name + " не смог поесть, нужно добавить корм.");
                System.out.println("В миске осталось " + catBowl.getFood() + " еды" );
                return false;
            }
        }else {
            System.out.println(name + " не голоден.");
            System.out.println("В миске осталось " + catBowl.getFood() + " еды");
            return true;
        }

    }
}




