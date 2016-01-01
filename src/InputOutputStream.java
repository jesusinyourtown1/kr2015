import java.io.*;

public class InputOutputStream {
    private InputStream inputstream;                     
    private OutputStream outputStream;                  
    public String path;                


    public InputOutputStream(String path) {
        this.path = path;
    }


   
    public String read() throws IOException {
        inputstream = new FileInputStream(path);            
        int data = inputstream.read();          
        char content;
        String str = "";
   
        while(data != -1) {

            content = (char) data;               
            str = str + content;
            data = inputstream.read();
        }
        inputstream.close();            
        return str;
    }

    
    public void write(String st) throws IOException {
        String a = "";
        inputstream = new FileInputStream(path);
        int data = inputstream.read();
        char b;
        while(data != -1) {
            b = (char) data;
            a = a + b;
            data = inputstream.read();
        }
        inputstream.close();

        st = a + st;
        outputStream = new FileOutputStream(path);       
        outputStream.write(st.getBytes());             
        outputStream.close();               
    }

    public void clean() throws IOException {
        String st="";
        outputStream = new FileOutputStream(path);
        outputStream.write(st.getBytes());
        outputStream.close();
    }
}
