import java.util.Scanner;
public class AkimClass {
    public static void main (String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        double arr[][]=new double[n][m];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
        Matrix s=new Matrix(arr);
        System.out.println(Matrix.inv(s));
    }
}