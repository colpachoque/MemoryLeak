import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExampleFactory {
    public ExampleFactory() {
    }

    public static IExample newInstance() {
        try {
            return newInstanceWithThrows();
        } catch (InstantiationException var1) {
            throw new RuntimeException(var1.getCause());
        } catch (IllegalAccessException var2) {
            throw new RuntimeException(var2);
        } catch (ClassNotFoundException var3) {
            throw new RuntimeException(var3);
        }
    }

    private static IExample newInstanceWithThrows() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        URLClassLoader tmp = new URLClassLoader(new URL[]{getClassPath()}) {
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return !"Example".equals(name) && !"A".equals(name) ? super.loadClass(name) : this.findClass(name);
            }
        };
        return (IExample)tmp.loadClass("Example").newInstance();
    }

    private static URL getClassPath() {
        String dir = "file:///D:/Projects/Work/MemoryLeak/out/production/MemoryLeak/";

        try {
            return new URL(dir);
        } catch (MalformedURLException var2) {
            throw new RuntimeException(var2);
        }
    }
}
