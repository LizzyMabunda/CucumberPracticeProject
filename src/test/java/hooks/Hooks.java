package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Base;

public class Hooks {

    @Before
    public void setup() {

        Base.initializeBrowser();   // opens browser once per scenario
    }
    @After
    public void tearDown() {

    }
}
