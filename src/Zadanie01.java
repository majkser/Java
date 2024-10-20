class Zadanie01 {
    private static final int BLAD = -2_000_000_000;
    private int[] bits;
    private int index;
    private boolean resultReturned;
    private int result;

    public Zadanie01() {
        bits = new int[100];
        index = 0;
        resultReturned = false;
        result = BLAD;
    }

    public void input(int bit) {
        if (index == bits.length) {
            int[] newBits = new int[bits.length * 2];
            System.arraycopy(bits, 0, newBits, 0, bits.length);
            bits = newBits;
        }
        bits[index++] = bit;
    }

    private void reset() {
        index = 0;
        resultReturned = false;
    }

    public int wynik() {

            if (resultReturned) {
                return BLAD;
            }

            int a = bits[0] * 8 + bits[1] * 4 + bits[2] * 2 + bits[3];

            if (index < 4 + a + 2 + a) {
                return BLAD;
            }

            int[] b = new int[a];
            int bValue = 0;

            for (int i = 4; i < a + 4; i++) {
                b[i - 4] = bits[i];
            }

            for (int i = 4 + 1; i < a + 4; i++) {
                bValue += b[i - 4] * (int) Math.pow(2, a - i + 3);
            }

            if (b[0] == 1) {
                bValue = -bValue;
            }

            int c1 = bits[4 + a];
            int c2 = bits[4 + a + 1];

            int[] d = new int[a];
            int dValue = 0;

            for (int i = 4 + a + 2; i < 4 + 2 * a + 2; i++) {
                d[i - 4 - a - 2] = bits[i];
            }

            for (int i = 4 + a + 2 + 1; i < 4 + 2 * a + 2; i++) {
                dValue += d[i - 4 - a - 2] * (int) Math.pow(2, 2 * a - i + 4 + 1);
            }

            if (d[0] == 1) {
                dValue = -dValue;
            }

            if (c1 == 0 && c2 == 0) {
                result = bValue + dValue;
            } else if (c1 == 0 && c2 == 1) {
                result = bValue - dValue;
            } else if (c1 == 1 && c2 == 0) {
                result = bValue * dValue;
            } else if (c1 == 1 && c2 == 1) {
                result = bValue / dValue;
            }



        resultReturned = true;
        reset();

        return result;
    }
}
