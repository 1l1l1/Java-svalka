public class MyPolynom extends MyArray{
    MyPolynom(){super();}
    MyPolynom(double[] a, double[] b){super(a, b);}
    MyPolynom(double a, double b, double c, double d, double e){
        super(a, b, c, d, e);
    }
    double solve(){
        return cArr[0]+cArr[1]*xArr[0]+cArr[2]*xArr[1];
    }

    @Override
    public String toString() {
        return cArr[0]+"+"+cArr[1]+"*"+xArr[0]+"+"+cArr[2]+"*"+xArr[1]+"="+this.solve();
    }
}
