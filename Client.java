import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        // generating an array of 100 random integers
        Random rd = new Random(); // creating Random object
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");

        // protobuf configuration
        ArrayData bo = ArrayData.newBuilder()
                .addData(arr[0])
                .addData(arr[1])
                .addData(arr[2])
                .addData(arr[3])
                .addData(arr[4])
                .addData(arr[5])
                .addData(arr[6])
                .addData(arr[7])
                .addData(arr[8])
                .addData(arr[9])
                .build();

        // sending the data to server
        Socket s;
        try {
            s = new Socket("localhost", 4000);
            OutputStream os = s.getOutputStream();

            bo.writeTo(os);
            os.flush();
            System.out.println(bo);

        } catch (IOException e) {
            e.printStackTrace();
        }
      
        while (true) {
            Thread.sleep(500);
        }
    }
}