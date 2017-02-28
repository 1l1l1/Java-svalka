//Created by popelyshkoaa.18 on 23.01.2017.
public class Frac {
    int numerator;
    int denominator;
    Frac(){
        numerator=0;
        denominator=1;
    }
    Frac(int a){
        numerator=a;
        denominator=1;
    }
    Frac(int a, int b){
        numerator=a;
        denominator=b;
    }
    Frac inv(){return new Frac(denominator, numerator);}
    @Override
    public String toString(){return numerator+"/"+denominator;}
    Frac sum(Frac a){return new Frac (a.numerator*this.denominator+this.numerator*a.denominator, a.denominator*this.denominator);}
    Frac sum(int a){return new Frac (a*this.denominator+this.numerator, this.denominator);}
    Frac mult(int a){return new Frac (a*numerator,denominator);}
    Frac mult(Frac a){return new Frac (a.numerator*this.numerator,this.denominator*a.denominator);}
    Frac doShort(){
        int nod=1;
        for (int i=1; i<=numerator; i++)
            if (numerator%i==0 && denominator%i==0)
                nod=i;
        return new Frac(numerator/nod,denominator/nod);
    }
    Frac myClone(){
        return new Frac (numerator, denominator);
    }
    Frac div(int a){
        Frac kkflflfcdlf= new Frac();
        kkflflfcdlf.denominator=this.denominator*a;
        kkflflfcdlf.numerator=this.numerator;
        return kkflflfcdlf;
    }
    boolean isDenumeratorZero(){
        if (this.denominator==0)
            return true;
        else
            return false;
    }
    boolean isShorten(){
        boolean b=false;
        for (int i=2; i<this.numerator; i++)
            if (this.numerator%i==0 && this.denominator%i==0)
                b=true;
        return  b;
    }
    boolean isEqual(Frac a){
        Frac f1=a.doShort();
        Frac f2=this.doShort();
        if (f2.numerator==f1.numerator && f2.denominator==f1.denominator)
            return true;
        else
            return false;
    }
    int compareTo(Frac a){
        int c=this.numerator*a.denominator;
        int d=a.numerator*this.denominator;
        if (c==d)
            return 0;
        else
        if (c>d)
            return 1;
        else
            return -1;
    }
}