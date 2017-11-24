public class Player {

    private  String name;
    private int score;
    private int fruitsEaten;

    // accessor method
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getFruitsEaten() {
        return fruitsEaten;
    }

    //mutator method
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setFruitsEaten(int fruitsEaten) {
        this.fruitsEaten = fruitsEaten;
    }

    public  Player(String name, int score, int fruitsEaten){
        setName(name);
        setScore(score);
        setFruitsEaten(fruitsEaten);
    }

    //no-args constructor

    public  Player(){
        this("Not Entered",0,0);
    }


    public String toString() {
        return "Name: " +getName() + "\nScore: " + getScore() + "\nFruits Eaten: " +getFruitsEaten();
    }
}
