public class ProccessOne <T extends  Data> extends Thread {
    private T dt;

    //Tread object of type Data
    public ProccessOne(T dt){
        this.dt = dt;
    }

    @Override
    public void run(){
        int x,y;

        for (int i = 0; i < 10; i++) {
            //create random x,y numbers between 1....50
            x = (int) (Math.random() * (50) + 1);
            y = (int) (Math.random() * (50) + 1);

            //Update object of type Data with new x,y using update method
            dt.update(x, y);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error in proccessOne %s%n" + e.getMessage());
            }
        }
    }

}
