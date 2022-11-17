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

public class Server {

    public static void main(String[] args) {
        int[] arraysorted = new int[10];
        try {
            ServerSocket ss = new ServerSocket(4000);
            Socket s2 = ss.accept();
            InputStream a = s2.getInputStream();

            // ParseFrom & mergeFrom didnt work
            // ArrayData sf = ArrayData.parseFrom(a);
            // ArrayData sf = ArrayData.mergeFrom(a);

            // ignoring the first two messages
            a.read();
            a.read();

            System.out.println("Data from Client: ");
            for (int j = 0; j < 10; j++) {
                int aa = a.read();
                arraysorted[j] = aa;
                // arraysorted[j] = sf.getData(j);
                System.out.print(j + ": " + arraysorted[j] + "  ");
            }
            System.out.println(" ");
            sortingArray(arraysorted);

            System.out.println("Sorted Array ");
            for (int k = 0; k < 10; k++) {
                System.out.print(arraysorted[k] + " ");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sortingArray(int array[]) {
        for (int i = 1; i < array.length; ++i) {

            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {

                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }
}
