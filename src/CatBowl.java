public class CatBowl {
    private int food;
    public int getFood() {
        return food;
    }
    public CatBowl (int food){
        this.food = Math.max(food, 0);
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addCatFood (int food) {
        this.food = this.food + food;
        if (this.food > 100) {
            this.food = 100;
            System.out.println("Миска с едой переполнена и лишнее высыпано.");
        } else if (food < 0) {
            System.out.println("Нужно добавить еды");
        }
    }
}
