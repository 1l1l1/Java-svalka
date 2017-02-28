public class Man {
    String name;
    int age;
    boolean male;
    double weight;
    Man(){
        male=false;
        age=18;
        name="Ivan";
        weight=60;
    }
    Man(String a, int b, boolean c, double d){
        male=c;
        age=b;
        name=a;
        weight=d;
    }
    void setName(String a){name=a;}
    void setAge(int a){age=a;}
    void setWeight(double a){weight=a;}

    @Override
    public String toString() {
        if (male)
            return name+":"+age+"/female ("+weight+")";
        else
            return name+":"+age+"/male ("+weight+")";
    }
    Man myClone(){
        return new Man(name,age,male,weight);
    }
}
