package dop.enam;

public class Nain {

    static final int APPLE_GRENNY_SMITH = 0;
    static final int APPLE_ARCADE = 1;
    static final int APPLE_GOLDEN = 2;
    static final int APPLE_ANIS = 3;

    static final int SIZE_S = 0;
    static final int SIZE_M = 1;
    static final int SIZE_L = 2;
    static final int SIZE_XL = 3;

    enum Apples{
        GRENNY_SMITH,
        ARCADE,
        GOLDEN,
        ANIS;
        public int a;
        public static int b;

        Apples() {
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        Apples(int a) {
            this.a = a;
        }
    }

    enum Size{
        S,
        M,
        L,
        XL
    }
    public static void main(String[] args) {

    }
}
