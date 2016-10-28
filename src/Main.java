import proxy.DynamicSubject;
import proxy.RealSubject;
import proxy.Subject;

import java.lang.reflect.*;

/**
 * 详见：http://blog.csdn.net/yongjian1092/article/details/7364451
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("============显示Java系统已经定义的类==============");

        //获得类的类型
        Boolean var1 = true;
        Class<?> classType2 = var1.getClass();
        System.out.println(classType2);

        //输出Boolean类型
        Class<?> classType3 = Boolean.TYPE;
        System.out.println(classType3);

        //输出boolean类型的类
        Class<?> classType4 = Boolean.class;
        System.out.println(classType4);


        Class<?> classType5 = null;
        try {
            classType5 = Class.forName("java.lang.Boolean");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(classType5);


        Class<?> classType = ExtendType.class;

        System.out.println("============属性==============");
        System.out.println("============使用getFields获取属性：父类+子类，仅public的参数==============");
        // 使用getFields获取属性
        Field[] fields = classType.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("============使用getDeclaredFields获取属性：仅本类中所有的属性，（包括private的属性）==============");

        // 使用getDeclaredFields获取属性
        fields = classType.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }


        System.out.println("============方法==============");

        System.out.println("============使用getMethods获取函数：所有方法，包括父类的方法==============");
        // 使用getMethods获取函数
        //Class<?> classType = ExtendType.class;
        //获得这个类的方法的集合
        Method[] methods = classType.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("============使用getDeclaredMethods获取函数，仅仅只是声明了的方法（共有，私有都获得）==============");
        // 使用getDeclaredMethods获取函数
        methods = classType.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }


        System.out.println("============构造器==============");

        System.out.println("============使用getConstructors获取构造器==============");
        // 使用getConstructors获取构造器
        Constructor<?>[] constructors = classType.getConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }


        System.out.println("============使用getDeclaredConstructors获取构造器：所有的构造方法==============");
        // 使用getDeclaredConstructors获取构造器
        constructors = classType.getDeclaredConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }


        /**
         * 新建类的实例
         */
        System.out.println("============新建类的实例的几种方法：==============");

        System.out.println("============1、调用类的Class对象的newInstance方法，该方法会调用对象的默认构造器，如果没有默认构造器，会调用失败.==============");
        //已知一个类的名字
        Class<?> classType1 = ExtendType.class;
        //初始化：空实例
        Object inst = null;
        try {
            //使用这个类来构造一个，没有参数的对象
            inst = classType1.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        //打印这个对象
        System.out.println(inst);


        System.out.println("============2、调用默认Constructor对象的newInstance方法==============");

        //一直这个类的名字
        Class<?> classType33 = ExtendType.class;

        //初始化：空构造方法
        Constructor<?> constructor1 = null;
        try {
            //从这个已知类名的类中获得构造方法
            constructor1 = classType33.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //初始化：空对象
        Object inst1 = null;
        try {
            assert constructor1 != null;
            //使用获得的这个构造方法。初始化实例
            inst1 = constructor1.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //打印这个实例
        System.out.println(inst1);


        System.out.println("============3、调用带参数Constructor对象的newInstance方法==============");

        //初始化:空构造方法
        Constructor<?> constructor2 = null;
        try {
            //获得类中的某两种参数的一个构造方法（有可能不存在）
            constructor2 = classType.getDeclaredConstructor(int.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //初始化：空实例
        Object inst444 = null;
        try {
            //实例不为空
            assert constructor2 != null;
            //通过这个构造方法，直接使用带参数构造一个这个类
            inst444 = constructor2.newInstance(1, "123");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //打印出这个实例
        System.out.println(inst444);


        /**
         * 6调用类的函数
         通过反射获取类Method对象，调用Field的Invoke方法调用函数。
         */
        //Class<?> classType = ExtendType.class;
        /*Object inst555 = null;
        try {
            inst555 = classType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Method logMethod = classType.<strong>getDeclaredMethod </strong > ("Log", String.class);
        try {
            logMethod.invoke(inst555, "test");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }*/


        /**
         * 7设置/获取类的属性值
         通过反射获取类的Field对象，调用Field方法设置或获取值
         */
        //Class<?> classType = ExtendType.class;
        /*Object inst666 = null;
        try {
            inst666 = classType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Field intField = null;
        try {
            intField = classType.getField("pubIntExtendField");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        intField.<STRONG>setInt </STRONG > (inst666, 100);
        int value = intField.<STRONG>getInt </STRONG > (inst);*/


        System.out.println("============8、使用代理模式.不是很清楚应用场景==============");
        //真实类
        RealSubject realSub = new RealSubject();
        //调用句柄，新建这个真实类的调用句柄
        InvocationHandler handler = new DynamicSubject(realSub);
        //这个句柄获得这个类
        Class<?> classType8888 = handler.getClass();
        //
        Subject sub = (Subject) Proxy.newProxyInstance(classType8888.getClassLoader(),
                realSub.getClass().getInterfaces(), handler);
        System.out.println(sub.getClass());
        sub.Request();

    }
}
