import java.util.Random;


public class Feeding {
    private static int COUNT_OF_CATS;

    private static Random generator = new Random();

    public static void main(String[] args) {
        COUNT_OF_CATS = randomCountOfCats(5,10);

        Cat[] cats = new Cat[COUNT_OF_CATS];
        Plate plate = new Plate(randomFoodInBowl(50,100));

        for (int i=0; i<COUNT_OF_CATS; i++) {
            cats[i] = new Cat("Cat" + i, randomAppetiteOfCat(5,25));
        }

        System.out.println("===========================");
        System.out.println("Count of food at start = " + plate.getFood());
        System.out.println("--------------------------");

        feedingCats(cats,plate);
        System.out.println("-------------------------------------------------------");
        for (Cat cat : cats) {
            System.out.println(cat.catInfo());
        }
        System.out.println("============================================");

    }

    public static void feedingCats(Cat[] cats, Plate plate) {
        for (Cat currentCat : cats) {
            /*if (plate.getFood() < currentCat.getAppetite()) {
                System.out.println("There is little food in the bowl - " + plate.getFood() + " | for the cat " + currentCat.getName());
                continue;
            } else {
                currentCat.eat(plate);
                currentCat.setSatiety(true);
                System.out.println("Cat " + currentCat.getName() + " ate succesfully");
            }*/
           boolean isCurrentEat = currentCat.eat(plate);
           if (!isCurrentEat) {
               continue;
           } else {
               System.out.println("Cat " + currentCat.getName() + " ate succesfully");
           }
        }

    }

    public static int randomFoodInBowl(int minFood, int maxFood) {
        //Random generator = new Random();
        return(maxFood - generator.nextInt(maxFood-minFood));
    }

    public static int randomAppetiteOfCat(int minAppetite, int maxAppetite) {
        //Random generator = new Random();
        return (maxAppetite - generator.nextInt(maxAppetite-minAppetite));
    }

    public static int randomCountOfCats(int minCount, int maxCount) {
        //Random generator = new Random();
        return (maxCount - generator.nextInt(maxCount-minCount));
    }
}
