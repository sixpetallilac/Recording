public class Timer {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        //code start

        System.out.println("test hello");
        /** some codes**/

        //code done
        long l2 = System.currentTimeMillis() - l;
        System.out.println((l2 > 1000) ? ("done |" + l2 / 1000 + "." + l2 % 1000 + "s") : ("done |" + l2 + "ms"));
    }
}