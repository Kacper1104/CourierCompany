package Presenter.Presenter.Test;

import Presenter.Package_New_Edit_Presenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Package_New_Edit_PresenterTest {

    @Test
    public void testCodeFormat_letters()
    {
        Package_New_Edit_Presenter p = new Package_New_Edit_Presenter();

        assertEquals(false, p.checkFormatOfCode("abc"));
    }

    @Test
    public void testCodeFormat_emptyString()
    {
        Package_New_Edit_Presenter p = new Package_New_Edit_Presenter();

        assertEquals(false, p.checkFormatOfCode(""));
    }

    @Test
    public void testCodeFormat_lettersAndNumbers()
    {
        Package_New_Edit_Presenter p = new Package_New_Edit_Presenter();

        assertEquals(false, p.checkFormatOfCode("1a2b3c"));
    }

    @Test
    public void testCodeFormat_numbersWrongFormat()
    {
        Package_New_Edit_Presenter p = new Package_New_Edit_Presenter();

        assertEquals(false, p.checkFormatOfCode("1-222"));
    }

    @Test
    public void testCodeFormat_onlyDash()
    {
        Package_New_Edit_Presenter p = new Package_New_Edit_Presenter();

        assertEquals(false, p.checkFormatOfCode("-"));
    }

    @Test
    public void testCodeFormat_goodFormatLetters()
    {
        Package_New_Edit_Presenter p = new Package_New_Edit_Presenter();

        assertEquals(false, p.checkFormatOfCode("ab-cde"));
    }

    @Test
    public void testCodeFormat_goodFormatNumbers()
    {
        Package_New_Edit_Presenter p = new Package_New_Edit_Presenter();

        assertEquals(true, p.checkFormatOfCode("00-000"));
    }


}