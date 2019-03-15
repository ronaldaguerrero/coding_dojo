class Human extends Mammal {
    
    public void goToWork(){
        System.out.println("I'm going to work, something only humans can do.");
    }
    public void startSleeping() { // overrides superclass method
        System.out.println("Toss and turn"); 
        super.startSleeping(); // accesses superclass method
    }
}