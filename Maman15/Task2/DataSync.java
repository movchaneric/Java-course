public class DataSync extends Data{

    // isDone to represent if one function is done and the other can start working
    private boolean isDone = false;

    public DataSync(int x, int y) {
        super(x, y);
    }

    public synchronized int getDiff(){
        int tempDiff;
        while(!isDone){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        tempDiff = super.getDiff();
        isDone = !isDone;
        notifyAll();
        return tempDiff;
    }

    // Update method will be preformed only when get method is done
    public synchronized void update(int dx, int dy){
        //Wait for get method to finish
        while(isDone){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        super.update(dx, dy);
        //mark for next function to continue
        isDone = !isDone;
        //Wake up next thread
        notifyAll();
    }
}
