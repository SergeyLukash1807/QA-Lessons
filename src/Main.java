public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Хасан", 6, "Чёрно-белый", 6);
        cats[1] = new Cat("Федя", 2, "Чёрно-белый", 3);
        cats[2] = new Cat("Муха", 8, "Чёрно-белый", 4);

        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog("Дрим",4,"Чёрно-коричневый",35,"Немецкая овчарка");
        dogs[1] = new Dog("Голд",6,"Золотистый",30,"Ретривер");

        dogs[0].run(510);
        dogs[0].run(490);
        dogs[1].swim(10);


        cats[0].run(150);
        cats[1].run(201);
        cats[2].swim(10);

        System.out.println("Общее количество животных: " + Animals.getCountAnimals());
        System.out.println("Количество котов: " + Cat.getCountCat());
        System.out.println("Количество собак: " + Dog.getCountDog());

        CatBowl catBowl = new CatBowl(50);
        catBowl.addCatFood(100);
        cats[0].catEat(catBowl);
        catBowl.addCatFood(20);
        cats[1].catEat(catBowl);
        cats[2].catEat(catBowl);
        catBowl.addCatFood(60);
        cats[2].catEat(catBowl);


// Задание 2


        Figure circle = new Circle(5);
        System.out.println(circle);
        circle.setFillColor("Белый");
        circle.setBorderColor("Чёрный");
        circle.getArea();
        circle.getPerimeter();

        Figure rectangle = new Rectangle(2, 4);
        System.out.println(rectangle);
        rectangle.setFillColor("Красный");
        rectangle.setBorderColor("Чёрный");
        rectangle.getArea();
        rectangle.getPerimeter();

        Figure triangle = new Triangle(3, 4, 5);
        System.out.println(triangle);
        triangle.setFillColor("Синий");
        triangle.setBorderColor("Чёрный");
        triangle.getArea();
        triangle.getPerimeter();
    }

    interface Figure {
        default void setFillColor(String color) {
            System.out.println("Цвет заливки⁚ " + color);
        }
        default void setBorderColor(String color) {
            System.out.println("Цвет границы⁚ " + color);

        }
        default double getPerimeter() {
            return 0;
        }
        default double getArea() {
            return 0;
        }

    }

    public static class Circle implements Figure {
        private final double r;

        public Circle(double radius) {
            this.r = radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * r;
        }

        @Override
        public double getArea() {
            return Math.PI * r * r;
        }

        @Override
        public String toString() {
            var name = "Круг";
            return name +"\n" + " P = " + getPerimeter() + "\n"+ " S = " + getArea();
        }
    }

    public static class Rectangle implements Figure {
        private final double a;
        private final double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double getPerimeter() {
            return 2 * (a + b);
        }

        @Override
        public double getArea() {
            return a * b;
        }

        @Override
        public String toString() {
            var name = "Прямоугольник";
            return name +"\n" + " P = " + getPerimeter() + "\n"+ " S = " + getArea();
        }
    }

    public static class Triangle implements Figure {
        private final double a;
        private final double b;
        private final double c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public double getPerimeter() {
            return a + b + c;
        }
        @Override
        public double getArea() {

            return Math.sqrt(getPerimeter()/2) * (getPerimeter() - a) * (getPerimeter() - b) * (getPerimeter() - c);
        }
        @Override
        public String toString() {
            var name = "Треугольник";
            return name +"\n" + " P = " + getPerimeter() + "\n"+ " S = " + getArea();
        }
    }
}