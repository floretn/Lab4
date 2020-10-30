package classLoader;

import java.io.*;

public class MyClassLoader extends ClassLoader{

    private String pathToBin;

    public MyClassLoader(String pathToBin, ClassLoader parent) {
        super(parent);
        this.pathToBin = pathToBin;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        String[] s = className.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length - 1; i++) {
            sb.append(s[i]).append("/");
        }
        pathToBin += String.valueOf(sb);
        System.out.println(pathToBin + " " + s[s.length - 1] + "/");
        try {
            byte[] b = fetchClassFromFS(pathToBin + s[s.length - 1] + ".class");
            return defineClass(className, b, 0, b.length);
        } catch (IOException ex) {
            return super.findClass(s[s.length - 1]);
        }
    }

    private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {

        File file = new File(path);
        InputStream is = new FileInputStream(file);

        long length = file.length();

        if (length > Integer.MAX_VALUE) {
            System.out.println("Файл не может быть считан полностью");
        }

        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead;

        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
            System.out.println("vn");
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+path);
        }

        is.close();
        return bytes;

    }
}
