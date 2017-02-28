import java.util.Arrays;

public class MyArray {
    double [] cArr=new double[3];
    double [] xArr=new double[2];
    MyArray(){
        cArr[0]=1;
        cArr[1]=1;
        cArr[2]=1;
        xArr[0]=1;
        xArr[1]=1;
    }
    MyArray(double[] a, double[] b){
        cArr[0]=a[0];
        cArr[0]=a[1];
        cArr[0]=a[2];
        cArr[0]=b[0];
        cArr[0]=b[1];
    }
    MyArray(double a, double b, double c, double d, double e){
        cArr[0]=a;
        cArr[1]=b;
        cArr[2]=c;
        xArr[0]=d;
        xArr[1]=e;
    }

    @Override
    public String toString() {
        return
                "cArr=" + Arrays.toString(cArr) +
                "\nxArr=" + Arrays.toString(xArr);
    }
}
