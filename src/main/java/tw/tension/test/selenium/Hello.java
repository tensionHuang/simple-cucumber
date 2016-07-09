package tw.tension.test.selenium;

/**
 * Created by Rickey Huang on 2016/7/7.
 */
public class Hello {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String greeting() {
        return name + " hello!";
    }
}
