package week8.liveliness;

public class LiveLock {
    /**
        A husband and wife are trying to eat, but only have one spoon between them.
        Each spouse is too polite, and will pass the spoon to their spouse if the spouse has not eaten

        -> Livelock is a situation where two or more threads keep responding to each other's actions,
             but none of them makes any progress. It's like a polite version of a deadlock,
             where threads are actively trying to avoid conflicts but end up in a situation where they are stuck.

        -> this is stupid, 互相謙讓，導致兩個人都吃不到飯LOL

        -> If both diners are hungry, they repeatedly exchange the spoon, each insisting that the other eat first.
            This polite exchange of the spoon continues indefinitely, and neither diner gets to eat. This is a livelock

        -> A livelock occurs when threads are actively trying to avoid
            conflicts but end up in a situation where they are stuck in a polite, non-productive loop.
     * */

    static class Spoon {
        private Diner owner;

        public Spoon(Diner d) {
            owner = d;
        }

        public synchronized Diner getOwner() {
            return owner;
        }

        public synchronized void setOwner(Diner d) {
            owner = d;
        }

        public synchronized void use() {
            System.out.println(owner.name + " has eaten!");
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String n) {
            name = n;
            isHungry = true;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // current Dinner don't have the spoon, so wait patiently for spouse.
                //  checks if the spoon is owned by the other diner. If it is, they wait briefly to avoid competing for spoon
                // spoon.owner return diner
                if (spoon.owner != this) {
                    try {
                        Thread.sleep(1);
                    }
                    catch(InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                // If spouse is hungry, insist upon passing the spoon.
                // if current diner has spoon and is hungry, but realize spouse is hungry, pass the spoon,
                // then spoon to other spouse and notice this current dinner is hungry, so just keep passing the spoon...
                if (spouse.isHungry()) {
                    System.out.println(name + " You eat first my darling " + spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                // Spouse wasn't hungry, so finally eat
                spoon.use();
                isHungry = false;
                System.out.println(name + ": I am stuffed, my darling " + spouse.getName());
                spoon.setOwner(spouse);
            }
        }

        public static void main(String[] args) {
            /**
             alice has spoon, bob thread start call eatWith alice, notice he does not have spoon, will wait and continue,
             then alice start eatWith bob she has spoon, but realize bob is hungry, pass the spoon to bob and continue,
             then bob wake finds out he has the spoon, but also realize alice is hungry, then pass spoon back to alice
             then continue passing spoon infinitely.
             * */
            final Diner husband = new Diner("Bob");
            final Diner wife = new Diner("Alice");

            final Spoon s = new Spoon(wife); // spoon owner is alice wife first,

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    husband.eatWith(s, wife);
                }
            });
            t1.start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    wife.eatWith(s, husband);
                }
            }).start();
        }
    }
}
