import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> bowlingBalls = new HashMap<>();
        
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            int weight;
            
            if (command == 1) {
                int lockerNumber = Integer.parseInt(input[1]);
                weight = Integer.parseInt(input[2]);
                bowlingBalls.put(weight, lockerNumber);
            } else if (command == 2) {
                weight = Integer.parseInt(input[1]);
                bw.write(bowlingBalls.get(weight) + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}