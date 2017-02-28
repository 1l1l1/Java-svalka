// Created by user on 23.01.2017.

public class Matrix {
    int n;
    int m;
    double arr [][]=new double[n][m];
    Matrix(int a, int b){n=a;m=b;arr=new double[n][m];}
    @Override
    public String toString() {
        String s = "Matrix{";
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                String s1;
                s1= String.format("%4.1f", arr[i][j]);
                s+=s1;
                //s+= " ";
            }
            s += "\n";
        }
        s += "}";
        return s;
    }
    void setArr(double [][] arr){
        n=arr.length;
        m=arr[0].length;
        this.arr=new double[n][m];
        this.arr=arr;
    }
    Matrix sum (Matrix m) {
        if (m.m != this.m || m.n != this.n) {
            //System.out.println("У ТЕБЯ СНОВА ОШИБКА, КРИВОРУКИЙ ТЫ ИДИОТ");
            return null;
        }
        else {
            Matrix a = new Matrix(m.n, m.m);
            for (int i = 0; i < m.n; i++)
                for (int j = 0; j < m.m; j++)
                    a.arr[i][j] = this.arr[i][j] + m.arr[i][j];
            return a;
        }
    }
    Matrix mult (double a) {
        Matrix b = new Matrix(this.n, this.m);
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                b.arr[i][j] = this.arr[i][j]*a;
        return b;
    }
    Matrix multM (Matrix m){
        if (m.n != this.m) {
            System.out.println("У ТЕБЯ СНОВА ОШИБКА, КРИВОРУКИЙ ТЫ ИДИОТ");
            return null;
        }
        else {
            Matrix a = new Matrix(this.n, m.m);
            for (int i = 0; i < this.n; i++)
                for (int j = 0; j < m.m; j++) {
                    int x = 0;
                    System.out.println('.');
                    for (int k = 0; k < m.n; k++)
                        x += this.arr[i][k] * m.arr[k][j];
                    a.arr[i][j] = x;
                }
            return a;
        }
    }
    boolean isSquare(){
        if (n==m)
            return true;
        else
            return false;
    }
    boolean isIdent(){
        if (!this.isSquare())
            return false;
        else {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (i == j)
                        if (arr[i][j] != 1)
                            return false;
                        else;
                    else
                        if (arr[i][j] != 0)
                            return false;
            return true;
        }
    }
}