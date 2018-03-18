package generator;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Generator {
    public void generate(int number) {
        for (int index = 0; index < number; index++) {
            String path = takePath();
            int imageId = Dao.getInstance().addImage(path);

            Map<String, String> authorParameters = takeAuthorParameters();
            int authorId = Dao.getInstance().addAuthor(authorParameters);

            Map<String, Object> articleParameters = takeArticleData();
            articleParameters.put("image_id", imageId);
            articleParameters.put("author_id", authorId);
            int num = index + 1;
            articleParameters.put("title", "article " + num);
            Dao.getInstance().addArticle(articleParameters);
        }
    }
    private int genIndex(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
    private String takePath() {
        int index = genIndex(5);
        ImagePath[] imagePath = ImagePath.values();
        return imagePath[index].getPath();
    }
    private Map<String, String> takeAuthorParameters() {
        int nameIndex = genIndex(8);
        int surnameIndex = genIndex(8);
        int countryIndex = genIndex(7);

        Name[] names = Name.values();
        Surname[] surnames = Surname.values();
        Country[] countries = Country.values();

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("name", names[nameIndex].toString());
        parameters.put("surname", surnames[surnameIndex].toString());
        parameters.put("country", countries[countryIndex].toString());
        return parameters;
    }
    private Map<String, Object> takeArticleData() {
        Map<String, Object> parameters = new HashMap<String, Object>();

        long min = 6000000000000L;
        long milisec = (long) Math.floor(min * Math.random() + 600000000000L);
        Date date = new Date(milisec);
        parameters.put("date", date);

        int value = genIndex(5);
        Body[] bodies = Body.values();
        parameters.put("body", bodies[value].getBody());

        return parameters;
    }
}
