//Created by user on 17.01.2017.
public class Triangle {
    double a;
    double b;
    double c;
    static double getArea(Triangle t){
        double p=(t.a+t.b+t.c)/2;
        return Math.sqrt(p*(p-t.a)*(p-t.b)*(p-t.c));
    }
    public Triangle(){
        a=1;
        b=1;
        c=1;
    }
    public Triangle(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public Triangle(double a, double c){
        this.a=a;
        this.b=a;
        this.c=c;
    }
    public Triangle(double a){
        this.a=a;
        this.b=a;
        this.c=a;
    }
    public static double getPerimeter(Triangle a){
        return a.a+a.b+a.c;
    }
    void modify(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public Triangle scale(double d){
        Triangle t=new Triangle();
        t.a=this.a*d;
        t.b=this.b*d;
        t.c=this.c*d;
        return t;
    }
    Triangle scale(double da,double db, double dc){
        Triangle t=new Triangle();
        t.a=this.a*da;
        t.b=this.b*db;
        t.c=this.c*dc;
        return t;
    }
    @Override
    public String toString(){
        return  "Triangle{"+a+","+b+","+c+"}";
    }
    Triangle getAHalf(){
        Triangle d=new Triangle();
        d.a=this.a;
        d.b=Triangle.getArea(this)/this.a;
        d.c=Math.sqrt(d.a*d.a+d.b*d.b);
        return d;
    }
    boolean isEquilateral(){
        if (this.a==this.b) {
            if (this.a == this.c)
                return true;
            else
                return false;
        }
        return false;
    }
    boolean isIsosceles(){
        if (this.a==this.b || this.b==this.c || this.a==this.c)
            return true;
        else
            return false;
    }
    boolean isRecangular() {
        if (this.a * this.a + this.b * this.b == this.c * this.c)
            return true;
        else
            return false;
    }
    public boolean checkTriangle(){
        if (a+b>c && a+c>b && b+c>a)
            return true;
        else
            return false;
    }
}