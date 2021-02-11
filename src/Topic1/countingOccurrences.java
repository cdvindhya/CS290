import java.io.*;
import java.util.*;

public class countingOccurrences {

    static Comparator<int[]> comp = new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] < b[i]) return -1;
                else if (a[i] > b[i]) return 1;
            }
            return 0;
        }
    };

    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private int MAX_LINE_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer, lineBuf;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            lineBuf = new byte[MAX_LINE_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public boolean hasNext() throws IOException {
            byte c;
            while ((c = read()) != -1) {
                if (c > ' ') {        // Find first byte bigger than ' '
                    bufferPointer--;
                    return true;
                }
            }
            return false;
        }

        // return the next line that contains at least one character > ' '
        public String nextLine() throws IOException {
            int ctr = 0;
            byte c;
            boolean empty = true;
            while ((c = read()) != -1) {
                if (c == '\r') continue;    // ignore '\r'
                if (c == '\n') {
                    if (empty) {
                        ctr = 0;
                        continue;
                    } // read only spaces etc. until \n
                    else break;
                }
                if (ctr == MAX_LINE_SIZE) {
                    MAX_LINE_SIZE *= 2;
                    lineBuf = Arrays.copyOf(lineBuf, MAX_LINE_SIZE);
                }
                lineBuf[ctr++] = c;
                if (c > ' ') empty = false;
            }
            return new String(lineBuf, 0, ctr);
        }

        public String next() throws IOException {
            int ctr = 0;
            byte c = read();
            while (c <= ' ') c = read();
            while (c > ' ') {
                if (ctr == MAX_LINE_SIZE) {
                    MAX_LINE_SIZE *= 2;
                    lineBuf = Arrays.copyOf(lineBuf, MAX_LINE_SIZE);
                }
                lineBuf[ctr++] = c;
                c = read();
            }
            return new String(lineBuf, 0, ctr);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            if (bytesRead <= 0) return -1;  // No data
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }

    public static void main(String[] args) { //Time complexity: O(N)
        FastReader in = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int N = 0;
        int Q = 0;
        try {
            N = in.nextInt();
            Q = in.nextInt();
        } catch (IOException X) {
            System.out.println("Encountered IO Exception");
        }
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            try {
                arr[i] = in.nextInt();
            } catch (IOException X) {
                System.out.println("Encountered IO Exception");
            }
        }

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] arr3 = new int[N];
        int[] arr4 = new int[N];
        int[] arr5 = new int[N];
        int[] arr6 = new int[N];
        int[] arr7 = new int[N];
        int[] arr8 = new int[N];
        int[] arr9 = new int[N];
        int[] arr10 = new int[N];

        // int[][] prefixSum = new int[10][N];
        //int j = 1;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                arr1[i]++;
            }
            if (i != 0) {
                arr1[i] = arr1[i] + arr1[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 2) {
                arr2[i]++;
            }
            if (i != 0) {
                arr2[i] = arr2[i] + arr2[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 3) {
                arr3[i]++;
            }
            if (i != 0) {
                arr3[i] = arr3[i] + arr3[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 4) {
                arr4[i]++;
            }
            if (i != 0) {
                arr4[i] = arr4[i] + arr4[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 5) {
                arr5[i]++;
            }
            if (i != 0) {
                arr5[i] = arr5[i] + arr5[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 6) {
                arr6[i]++;
            }
            if (i != 0) {
                arr6[i] = arr6[i] + arr6[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 7) {
                arr7[i]++;
            }
            if (i != 0) {
                arr7[i] = arr7[i] + arr7[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 8) {
                arr8[i]++;
            }
            if (i != 0) {
                arr8[i] = arr8[i] + arr8[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 9) {
                arr9[i]++;
            }
            if (i != 0) {
                arr9[i] = arr9[i] + arr9[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 10) {
                arr10[i]++;
            }
            if (i != 0) {
                arr10[i] = arr10[i] + arr10[i - 1];
            }
        }

        int a = 0;
        int b = 0;
        int c = 0;

        for (int j = 0; j < Q; j++) { //Q
            try {
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
            } catch (IOException X) {
                System.out.println("Encountered IO Exception");
            }

            switch (c) {
                case 1:
                    if (a != 1) {
                        pw.println(arr1[b - 1] - arr1[a - 2]);
                    } else {
                        pw.println(arr1[b - 1]);
                    }
                    break;
                case 2:
                    if (a != 1) {
                        pw.println(arr2[b - 1] - arr2[a - 2]);
                    } else {
                        pw.println(arr2[b - 1]);
                    }
                    break;
                case 3:
                    if (a != 1) {
                        pw.println(arr3[b - 1] - arr3[a - 2]);
                    } else {
                        pw.println(arr3[b - 1]);
                    }
                    break;
                case 4:
                    if (a != 1) {
                        pw.println(arr4[b - 1] - arr4[a - 2]);
                    } else {
                        pw.println(arr4[b - 1]);
                    }
                    break;
                case 5:
                    if (a != 1) {
                        pw.println(arr5[b - 1] - arr5[a - 2]);
                    } else {
                        pw.println(arr5[b - 1]);
                    }
                    break;
                case 6:
                    if (a != 1) {
                        pw.println(arr6[b - 1] - arr6[a - 2]);
                    } else {
                        pw.println(arr6[b - 1]);
                    }
                    break;
                case 7:
                    if (a != 1) {
                        pw.println(arr7[b - 1] - arr7[a - 2]);
                    } else {
                        pw.println(arr7[b - 1]);
                    }
                    break;
                case 8:
                    if (a != 1) {
                        pw.println(arr8[b - 1] - arr8[a - 2]);
                    } else {
                        pw.println(arr8[b - 1]);
                    }
                    break;
                case 9:
                    if (a != 1) {
                        pw.println(arr9[b - 1] - arr9[a - 2]);
                    } else {
                        pw.println(arr9[b - 1]);
                    }
                    break;
                case 10:
                    if (a != 1) {
                        pw.println(arr10[b - 1] - arr10[a - 2]);
                    } else {
                        pw.println(arr10[b - 1]);
                    }
                    break;
            }
        }
        pw.flush();
        pw.close();
    }
}
