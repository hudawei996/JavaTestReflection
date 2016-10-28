/**
 * Created by huyongqiang on 2016/10/27.
 */
class Type {
    //属性
    public int pubIntField;
    public String pubStringField;
    private int prvIntField;

    //构造方法
    public Type() {
        Log("Default Constructor");
    }

    Type(int arg1, String arg2) {
        pubIntField = arg1;
        pubStringField = arg2;

        Log("Constructor with parameters");
    }

    //方法
    public void setIntField(int val) {
        this.prvIntField = val;
    }

    public int getIntField() {
        return prvIntField;
    }

    private void Log(String msg) {
        System.out.println("Type:" + msg);
    }
}

/**
 * 继承类
 */
class ExtendType extends Type {
    //属性
    public int pubIntExtendField;
    public String pubStringExtendField;
    private int prvIntExtendField;

    //构造方法
    public ExtendType() {
        Log("Default Constructor");
    }

    ExtendType(int arg1, String arg2) {
        pubIntExtendField = arg1;
        pubStringExtendField = arg2;

        Log("Constructor with parameters");
    }

    //一般方法
    public void setIntExtendField(int field7) {
        this.prvIntExtendField = field7;
    }

    public int getIntExtendField() {
        return prvIntExtendField;
    }

    private void Log(String msg) {
        System.out.println("ExtendType:" + msg);
    }
}
