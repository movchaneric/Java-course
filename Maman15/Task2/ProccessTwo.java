public class ProccessTwo <T extends Data> extends Thread{
    private T dt;

    public ProccessTwo(T dt){
        this.dt = dt;
    }

    @Override
    public void run(){
        int tempDiff;

        for (int i = 0; i < 10; i++) {
            //Get the difference between x and y.
            tempDiff = dt.getDiff();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error in proccessTwo %s%n" + e.getMessage());
            }
        }
    }


}
