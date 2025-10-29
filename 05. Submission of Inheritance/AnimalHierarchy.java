
class Animal {
    protected String name;
    protected int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    public Dog(String name, int age){
        super(name, age);
    }
    @Override
    public void makeSound(){
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    public Cat(String name, int age){
        super(name, age);
    }
    @Override
    public void makeSound(){
        System.out.println("Cat meows");
    }
}
class Bird extends Animal {
    public Bird(String name, int age){
        super(name, age);
    }
    @Override
    public void makeSound(){
        System.out.println("Bird chirps");
    }
}
public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal[] animals = new Animal[] {
            new Dog("Rover", 3),
            new Cat("Whiskers", 2),
            new Bird("Tweety",1)
        };
        for (Animal animal : animals) {
            System.out.print(animal.name + " says: ");
            animal.makeSound();
        }
    }
}
