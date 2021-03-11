package Topic6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class backpackingMiddleEarth {
    public static void main(String[] args) throws IOException {

        FastReader in = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int N = in.nextInt();
        Stack stack = new Stack();

        int gold = 0;
        int amber = 0;
        int crystal = 0;
        String stuck = "-1 -1 -1";

        Boolean stuckBool = false;

        for (int i = 0; i < N; i++) {
            String input = in.nextLine();
            char[] a = input.toCharArray();

            gold = 0;
            amber = 0;
            crystal = 0;

            stack = new Stack();

            int index = 0;

            while (index < input.length() && !stuckBool) {
                if (a[index] == '=') {
                    index++;
                } else if (a[index] == '$') {
                    stack.push(a[index]);
                    index++;
                } else if (a[index] == '#') {
                    stack.push(a[index]);
                    index++;
                } else if (a[index] == '@') {
                    stack.push(a[index]);
                    index++;
                } else if (a[index] == 'd') {

                    if (stack.isEmpty()) {
                        pw.print(stuck); // -1 -1 -1
                        stuckBool = true;
                        break;
                    }

                    char c = (char) stack.pop();
                    if (c != '$') {

                        while (c != '$') {
                            if (stack.isEmpty()) {
                                stuckBool = true;
                                break;
                            }
                            c = (char) stack.pop();
                        }

                    }

                    index++;

                } else if (a[index] == 'n') {

                    if (stack.isEmpty()) {
                        stuckBool = true;
                        break;
                    }

                    char c = (char) stack.pop();
                    if (c != '@') {

                        while (c != '@') {
                            if (stack.isEmpty()) {
                                stuckBool = true;
                                break;
                            }
                            c = (char) stack.pop();
                        } //while

                    }//if

                    index++;

                } else if (a[index] == 't') {

                    if (stack.isEmpty()) {
                        stuckBool = true;
                        break;
                    }

                    char c = (char) stack.pop();
                    if (c != '#') {

                        while (c != '#') {
                            if (stack.isEmpty()) {
                                stuckBool = true;
                            }
                            c = (char) stack.pop();
                        }

                    }

                    index++;

                }

            } //while

            while (!stack.isEmpty() && !stuckBool) {
                char c = (char) stack.pop();
                if (c == '$') {
                    gold++;
                } else if (c == '&') {
                    amber++;
                } else if (c == '#') {
                    crystal++;
                }
            }

            if (!stuckBool) {
                String result = "" + gold + " " + amber + " " + crystal;
                pw.println(result);
            } else {
                pw.println(stuck);
            }

        } //for loop

        pw.close();

    }

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
                if (c > ' ') {		// Find first byte bigger than ' '
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
                if (c == '\r')        continue; 	// ignore '\r'
                if (c == '\n') {
                    if (empty)  { ctr = 0;   continue;  } // read only spaces etc. until \n
                    else        break;
                }
                if (ctr == MAX_LINE_SIZE) {
                    MAX_LINE_SIZE *= 2;
                    lineBuf = Arrays.copyOf(lineBuf, MAX_LINE_SIZE);
                }
                lineBuf[ctr++] = c;
                if (c > ' ')  empty = false;
            }
            return new String(lineBuf, 0, ctr);
        }
        public String next() throws IOException {
            int ctr = 0;
            byte c = read();
            while (c <= ' ')  	c = read();
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
            while (c <= ' ')   c = read();
            boolean neg = (c == '-');
            if (neg)           c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)           return -ret;
            return ret;
        }
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')    c = read();
            boolean neg = (c == '-');
            if (neg)            c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)            return -ret;
            return ret;
        }
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)  	c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)     return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)     fillBuffer();
            if (bytesRead <= 0)  return -1;  // No data
            return buffer[bufferPointer++];
        }
        public void close() throws IOException {
            if (din == null) 	   return;
            din.close();
        }
    }

}
