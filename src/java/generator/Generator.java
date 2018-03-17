package generator;

public class Generator {
    public void generate(int number) {
        for (int index = 0; index < number; index++) {
            String path = genPath();
            int imageId = Dao.getInstance().addImage(path);


        }
    }

    private String genPath() {

    }
}
