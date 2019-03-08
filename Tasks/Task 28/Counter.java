public class Counter extends Thread {
    private int from;
    private int to;
    private int array[];
    private int sumResult;
    private boolean finished;
    private boolean untouched;

    public Counter(int from, int to, int array[]) {
        this.from = from;
        this.to = to;
        this.array = array;
        this.finished = false;
        this.untouched = true;
    }

    @Override
    public void run() {
        this.finished = false;
        this.untouched = true;
        for (int i = this.from; i <= this.to; i++) {
            this.sumResult = this.sumResult + this.array[i];
//          System.out.println("прибавил" + this.array[i]);
        }
//      System.out.println("закончил считать. Сумма = " + this.sumResult);
        this.finished = true;
    }

    public int getSumResult() {
        return sumResult;
    }

    public boolean valid() {
        boolean valid = (this.finished && this.untouched);
        return valid;
    }

    public void touched() {
        this.untouched = false;
    }
}
