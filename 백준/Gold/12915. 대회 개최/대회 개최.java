import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int EM = sc.nextInt();
        int M = sc.nextInt();
        int MH = sc.nextInt();
        int H = sc.nextInt();

        int cnt = 0;
        while (true) {
            if (E > 0) {
                E--;
            } else if (E == 0 && EM > 0) {
                EM--;
            } else if (E == 0 && EM == 0) {
                break;
            }
            
            if (H > 0) {
                H--;
            } else if (H == 0 && MH > 0) {
                MH--;
            }
            else if (H == 0 && MH == 0) {
                break;
            }
            
            if (M > 0) {
                M--;
            } else if (M == 0) {
                if (EM > 0 || MH > 0) {
                    if (EM >= MH)
                        EM--;
                    else
                        MH--;
                }
                else if (EM == 0 && MH == 0) {
                    break;
                }
            }
            
            cnt++;
        }
        System.out.print(cnt);
    }
}
