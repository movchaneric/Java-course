public class DataSyncOne extends Data{
    private boolean getDiffLock = true;
    private boolean updateLock = false;

    public DataSyncOne(int x, int y) {
        super(x, y);
    }

    public synchronized int getDiff(){
        int tempDiff;
        //updateLock is false until all get thread are done
        while(updateLock){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        tempDiff = super.getDiff();
        //getDiff is done
        getDiffLock = false;
        notifyAll();
        return tempDiff;
    }

    // Update method will be preformed only when get method is done
    public synchronized void update(int dx, int dy){
        //Only when updateLock is true => wait mode in getDiff => no get operation
        while(getDiffLock || updateLock){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //Change state for update to update data.
        updateLock = true;
        super.update(dx, dy);
        //Change state for update Lock to finish update data.
        updateLock = false;
        //Wake up next thread.
        notifyAll();
    }
}
