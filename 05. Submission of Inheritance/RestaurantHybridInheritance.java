
interface Worker {
    void performDuties();
}
class Person {
    protected String name;
    protected int id;
    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }
}
class Chef extends Person implements Worker {
    public Chef(String name, int id){
        super(name, id);
    }
    public void performDuties(){
        System.out.println("Chef " + name + " is cooking.");
    }
}
class Waiter extends Person implements Worker {
    public Waiter(String name, int id){
        super(name, id);
    }
    public void performDuties(){
        System.out.println("Waiter " + name + " is serving tables.");
    }
}
public class RestaurantHybridInheritance {
    public static void main(String[] args){
        Worker[] workers = {
            new Chef("Ram", 101),
            new Waiter("Shyam", 102)
        };
        for (Worker w : workers) {
            w.performDuties();
        }
    }
}
