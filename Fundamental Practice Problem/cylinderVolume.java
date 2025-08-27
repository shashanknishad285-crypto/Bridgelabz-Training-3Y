import java.util.Scanner;
public class cylinderVolume {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int h = sc.nextInt();
        double vol = Math.PI*r*r*h;
        System.out.println(vol);
    }
}
