import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class Scratch {
    public static void main(String[] args) throws IOException {
        String source = "test text2";
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("test_demo3.json"))) {
            outputStream.write(source.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }
}