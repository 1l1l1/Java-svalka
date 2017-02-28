public class Student extends Man{
    int yearOfStudy;
    void setYearOfStudy(int a){yearOfStudy=a;}
    void incYearOfStudy(){yearOfStudy+=1;}
    Student(){
        super();
        yearOfStudy=1;
    }
    Student(String a, int b, boolean c, double d, int e){
        super(a, b, c, d);
        yearOfStudy=e;
    }
    @Override
    public String toString() {
        if (male)
            return name+":"+age+"/female ("+weight+") "+yearOfStudy;
        else
            return name+":"+age+"/male ("+weight+") "+yearOfStudy;
    }
    @Override
    public Student myClone(){
        return new Student(name,age,male,weight,yearOfStudy);
    }
}
