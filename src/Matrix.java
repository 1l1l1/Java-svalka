// Created by user on 23.01.2017.

public class Matrix {
    private int n;
    private int m;
    private double arr [][]=new double[n][m];
    Matrix(int a, int b){n=a;m=b;arr=new double[n][m];}
    public Matrix (double arr[][]) {
        this.arr=new double[arr.length][arr.length];
        for (int i = 0;  i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                this.arr[i][j] = arr[i][j];
        n = arr.length;
        m = arr[0].length;
    }
    protected Matrix (int n){
        this.arr=new double[n][n];
        for (int i=0; i<n; i++)
            arr[i][i]=1;
        this.n=n;
        m=n;
    }
    Matrix(){
        this(1);
    }

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
    private Matrix sum (Matrix m) {
        if (m.m != this.m || m.n != this.n)
            return null;
        else {
            Matrix a = new Matrix(m.n, m.m);
            for (int i = 0; i < m.n; i++)
                for (int j = 0; j < m.m; j++)
                    a.arr[i][j] = this.arr[i][j] + m.arr[i][j];
            return a;
        }
    }
    protected Matrix mult (double a) {
        Matrix b = new Matrix(this.n, this.m);
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                b.arr[i][j] = this.arr[i][j]*a;
        return b;
    }
    Matrix mult (Matrix m){
        if (m.n != this.m)
            return null;
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
    public final Matrix getMinor(int a, int b){
        Matrix m=new Matrix (this.n-1,this.m-1);
        for (int i=0; i<m.arr.length; i++)
            for (int j=0; j<m.arr[0].length; j++) {
                if (i >= a && j >= b)
                    m.arr[i][j] = this.arr[i + 1][j + 1];
                if (i >= a && j < b)
                    m.arr[i][j] = this.arr[i + 1][j];
                if (i < a && j >= b)
                    m.arr[i][j] = this.arr[i][j + 1];
                if (i < a && j < b)
                    m.arr[i][j] = this.arr[i][j];
            }
        return m;
    }
    public static int getf (int n){
        int f=1;
        for (int i=1; i<=n; i++)
            f=f*i;
        return f;
    }
    public static double determinant(Matrix m) {
        double A[][]=m.arr;
        int n = A.length;
        double D = 1.0;
        double B[][] = new double[n][n];
        int intarr[] = new int[n];
        int hold, shutochki;
        double v;
        double abs;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = A[i][j];
        for (int k = 0; k < n; k++) {
            intarr[k] = k;
        }
        for (int k = 0; k < n - 1; k++) {
            v = B[intarr[k]][k];
            abs = Math.abs(v);
            shutochki = k;
            for (int i = k; i < n; i++) {
                if (Math.abs(B[intarr[i]][k]) > abs) {
                    shutochki = i;
                    v = B[intarr[i]][k];
                    abs = Math.abs(v);
                }
            }
            if (shutochki != k) {
                hold = intarr[k];
                intarr[k] = intarr[shutochki];
                intarr[shutochki] = hold;
                D = -D;
            }
            if (abs < 1.0E-10) {
                return 0.0;
            } else {
                D = D * v;
                for (int j = k + 1; j < n; j++) {
                    B[intarr[k]][j] = B[intarr[k]][j] / B[intarr[k]][k];
                }
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        for (int j = k + 1; j < n; j++) {
                            B[intarr[i]][j] = B[intarr[i]][j] - B[intarr[i]][k] * B[intarr[k]][j];
                        }
                    }
                }
            }
        }
        return D * B[intarr[n - 1]][n - 1];
    }
    public static final Matrix inv(Matrix a) {
        double A[][]=a.arr;
        int n = A.length;
        int row[] = new int[n];
        int col[] = new int[n];
        double temp[] = new double[n];
        int h, ie, je;
        double e, d;

        if (A[0].length != n) {
            return null;
        }
        for (int k = 0; k < n; k++) {
            row[k] = k;
            col[k] = k;
        }
        for (int k = 0; k < n; k++) {
            e = A[row[k]][col[k]];
            ie = k;
            je = k;
            for (int i = k; i < n; i++) {
                for (int j = k; j < n; j++) {
                    d = Math.abs(e);
                    if (Math.abs(A[row[i]][col[j]]) > d) {
                        ie = i;
                        je = j;
                        e = A[row[i]][col[j]];
                    }
                }
            }
            if (Math.abs(e) < 1.0E-10) {
                return null;
            }
            h = row[k];
            row[k] = row[ie];
            row[ie] = h;
            h = col[k];
            col[k] = col[je];
            col[je] = h;
            A[row[k]][col[k]] = 1.0 / e;
            for (int j = 0; j < n; j++) {
                if (j != k) {
                    A[row[k]][col[j]] = A[row[k]][col[j]] * A[row[k]][col[k]];
                }
            }
            for (int i = 0; i < n; i++) {
                if (k != i) {
                    for (int j = 0; j < n; j++) {
                        if (k != j) {
                            A[row[i]][col[j]] = A[row[i]][col[j]] - A[row[i]][col[k]] *
                                    A[row[k]][col[j]];
                        }
                    }
                    A[row[i]][col[k]] = -A[row[i]][col[k]] * A[row[k]][col[k]];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                temp[col[i]] = A[row[i]][j];
            }
            for (int i = 0; i < n; i++) {
                A[i][j] = temp[i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[row[j]] = A[i][col[j]];
            }
            for (int j = 0; j < n; j++) {
                A[i][j] = temp[j];
            }
        }
        return a;
    }
}