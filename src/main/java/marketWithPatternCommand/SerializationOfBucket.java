package marketWithPatternCommand;

import marketWithPatternCommand.entity.Bucket;

import java.io.*;

public class SerializationOfBucket {

    public static void doSerialize(Bucket bucket, String name) {

        try (
                FileOutputStream fos = new FileOutputStream(name + ".txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(bucket);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Bucket doUnSerialize(String name) {

        Bucket bucket = null;
        File file = new File(name + ".txt");
        try (
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream oin = new ObjectInputStream(fis)
                ) {
            bucket = (Bucket) oin.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("    Repo if buckets clean? " + file.delete());
        return bucket;
    }
}
