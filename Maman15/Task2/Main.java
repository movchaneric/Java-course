public class Main {
    public static void main(String[] args) {

        Data dt = new Data(0, 0);

        //Reference of 2 threads to dt
        ProccessOne p1 = new ProccessOne(dt);
        ProccessTwo p2 = new ProccessTwo(dt);
        Thread p1Thread = new Thread(p1);
        Thread p2Thread = new Thread(p2);
        p1.start();
        p2.start();
        //Wait for p1 and p2 to finish than print message
        try{
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("END OF TASK NUMBER 1");
        System.out.println("START TASK NUMBER 2");
        System.out.println();

        DataSync ds = new DataSync(0 , 0);
        ProccessOne p1Sync = new ProccessOne(ds);
        ProccessTwo p2Sync = new ProccessTwo(ds);
        Thread p1SyncThread = new Thread(p1Sync);
        Thread p2SyncThread = new Thread(p2Sync);
        p1SyncThread.start();
        p2SyncThread.start();
        //Wait for p1SyncThread and p2SyncThread to finish than print message
        try{
            p1SyncThread.join();
            p2SyncThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("END OF TASK NUMBER 2");
        System.out.println("START TASK NUMBER 3");
        System.out.println();



        DataSyncOne dsOne = new DataSyncOne(0,0);
        ProccessOne[] proccess1 = new ProccessOne[4];
        ProccessTwo[] proccess2 = new ProccessTwo[4];
        for (int i = 0; i < proccess1.length; i++) {
            proccess1[i] = new ProccessOne(dsOne);
            proccess1[i].start();
        }
        for (int i = 0; i < proccess2.length; i++) {
            proccess2[i] = new ProccessTwo(dsOne);
            proccess2[i].start();
        }
        //Wait for all threads to finish than print message
        try{
            for (int i = 0; i < proccess1.length; i++) {
                proccess1[i].join();
            }
            for (int i = 0; i < proccess2.length; i++) {
                proccess2[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("END OF TASK NUMBER 3");
        System.out.println();


    }
}