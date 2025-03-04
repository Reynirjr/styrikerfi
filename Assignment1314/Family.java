import java.util.concurrent.Semaphore;

public class Family {

    //***Definition and initialisation of shared semaphores***
    //***Student code here***

    static Semaphore toilet = new Semaphore(1);
    static Semaphore foodReady = new Semaphore(0);
    static Semaphore drinkReady = new Semaphore(0);

    enum Person { CHILD, MOTHER, FATHER }

    public static void main(String[] args) throws InterruptedException {
        Thread child1 = new FamilyMember(Person.CHILD);
        Thread child2 = new FamilyMember(Person.CHILD);
        Thread mother = new FamilyMember(Person.MOTHER);
        Thread father = new FamilyMember(Person.FATHER);

        child1.start();
        child2.start();
        mother.start();
        father.start();

        child1.join();
        child2.join();
        mother.join();
        father.join();

        System.out.println("Family's day is complete.");
    }

static class FamilyMember extends Thread {
        private Person person;

        public FamilyMember(Person person) {
            this.person = person;
        }

    @Override
    public void run() {
        switch (person) {
            case CHILD:
                useToilet();
                try {

                    foodReady.acquire();

                    drinkReady.acquire();

                    haveBreakfast();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break;
            case MOTHER:
                useToilet();
                prepareFood();
                
                //***Mother releases breakfastReady when food is ready***
                //***Student code here***
                foodReady.release(2);

                takeAndDriveToSchool();
                break;
            case FATHER:
                useToilet();
                prepareDrinks();
                
                //***Father releases breakfastReady when drinks are ready***                        
                //***Student code here***
                drinkReady.release(2);

                clearTable();

                //***Student code here***

                break;
        }
    }
}
    static void useToilet() {
        try {

            //***Student code here***
            toilet.acquire();
            System.out.println(Thread.currentThread().getName() + " is using the toilet.");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        } finally {

            //***Student code here***
            toilet.release();

        }
    }

    static void prepareFood() {
        System.out.println(Thread.currentThread().getName() + " is preparing food.");
    }

    static void prepareDrinks() {
        System.out.println(Thread.currentThread().getName() + " is preparing drinks.");
    }

    static void haveBreakfast() {
        System.out.println(Thread.currentThread().getName() + " is having breakfast.");
    }

    static void takeAndDriveToSchool() {
        System.out.println(Thread.currentThread().getName() + " is taking a child to school.");
    }

    static void clearTable() {
        System.out.println(Thread.currentThread().getName() + " is clearing the table.");
    }
}